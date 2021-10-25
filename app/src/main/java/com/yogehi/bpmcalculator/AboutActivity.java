package com.yogehi.bpmcalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView about_text = (TextView) findViewById(R.id.aboutText);

        about_text.setText("Something something use this app however you want. Just don't be a dick.\n\nNo I won't take suggestions. I made this for me only.\n\nGitHub repo: https://github.com/Yogehi/BPMCalculator\n");
    }
}
