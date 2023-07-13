package com.example.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView1);
        // Restaure TextView s'il y a un saveInstanceState
        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Enregistre l'état de TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }

    public void startTask(View view) {
        // Placer un message dans la vue texte
        mTextView.setText(R.string.napping);
        // Démarre l'AsyncTask.
        new SimpleAsyncTask(mTextView).execute();
    }
}