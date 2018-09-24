package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;
import android.widget.ProgressBar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

@RunWith(AndroidJUnit4.class)
public class JokeLoaderTaskTest {

    @Test
    public void jokeLoadingTest() throws InterruptedException {

        //Using CountDownLatch for waiting while asyncTask executes
        //Got this idea from the stackoverflow link...
        // https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
        final CountDownLatch latch = new CountDownLatch(1);
        JokeLoaderTask taskToTest = new JokeLoaderTask(new WeakReference<ProgressBar>(null/*Not needed*/)) {
            @Override
            protected void onPostExecute(String jokeString) {
                Assert.assertNotNull(jokeString);
                System.out.println("MyTest: Loaded Joke: " + jokeString);
                latch.countDown();
            }
        };
        taskToTest.execute();
        latch.await();
    }
}
