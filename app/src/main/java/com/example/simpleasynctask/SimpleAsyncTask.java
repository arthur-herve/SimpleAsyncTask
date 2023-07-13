package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask  extends AsyncTask<Void, Integer, String> {
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;

    SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(pb);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
            int slp = n * 200;
            for (int sleepSteps = 0; sleepSteps<100; sleepSteps+=1){
                try{
                    Thread.sleep(slp/100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(sleepSteps);
            }
            return "Enfin réveillé après avoir dormi pendant " + slp + " millisecondes !";
    }

    protected void onProgressUpdate(Integer... progress) {
        mProgressBar.get().setProgress(progress[0]);
    }

    protected void onPostExecute(String result) {


        mTextView.get().setText(result);
    }
}
