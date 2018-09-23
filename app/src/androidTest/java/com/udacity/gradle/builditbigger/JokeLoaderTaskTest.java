package com.udacity.gradle.builditbigger;


import android.widget.ProgressBar;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;


public class JokeLoaderTaskTest {

    @Test
    public void jokeLoadingTest() throws InterruptedException {

        //Using CountDownLatch for waiting while asyncTask executes
        final CountDownLatch latch = new CountDownLatch(1);
        JokeLoaderTask taskToTest = new JokeLoaderTask(new WeakReference<ProgressBar>(null/*Not needed*/)) {
            @Override
            protected void onPostExecute(String jokeString) {
                Assert.assertNotNull(jokeString);
                Assert.assertEquals("Hello", jokeString);
                latch.countDown();
            }
        };
        latch.await();
        taskToTest.execute();
    }
}
