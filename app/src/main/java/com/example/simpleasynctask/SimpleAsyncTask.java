package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask  extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        try {
            int slp = n * 200;
            Thread.sleep(slp);
            return "Enfin réveillé après avoir dormi pendant " + slp + " millisecondes !";
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        return "Error";

    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
