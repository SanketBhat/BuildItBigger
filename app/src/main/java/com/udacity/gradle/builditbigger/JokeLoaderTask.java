package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import java.lang.ref.WeakReference;

import app.sanketbhat.androidjokeui.JokeActivity;

public class JokeLoaderTask extends AsyncTask<Void, Void, String> {

    private WeakReference<ProgressBar> progressBar;
    private MyApi api;

    JokeLoaderTask(WeakReference<ProgressBar> progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        if (progressBar != null) {

            ProgressBar progressBar1 = progressBar.get();
            if (progressBar1 != null) {
                progressBar1.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected String doInBackground(Void... aVoid) {
        try {
            if (api == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                api = builder.build();
            }

            Joke joke = api.getJoke().execute();
            return joke.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String jokeString) {
        if (progressBar != null) {
            ProgressBar progressBar1 = progressBar.get();
            if (progressBar1 != null) {
                progressBar1.setVisibility(View.INVISIBLE);
                Context context = progressBar.get().getContext();
                Intent intent = new Intent(context, JokeActivity.class);
                intent.putExtra(JokeActivity.EXTRA_JOKE, jokeString);
                context.startActivity(intent);
            }
        }
    }
}
