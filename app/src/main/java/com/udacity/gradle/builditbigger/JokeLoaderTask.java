package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import app.sanketbhat.androidjokeui.JokeActivity;

public class JokeLoaderTask extends AsyncTask<Void, Void, Void> {

    @SuppressLint("StaticFieldLeak")
    private final Context context;

    JokeLoaderTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... aVoid) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        String joke = "Silly joke";
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_JOKE, joke);
        context.startActivity(intent);
    }
}
