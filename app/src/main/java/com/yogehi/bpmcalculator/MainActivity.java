package com.yogehi.bpmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public double[] yayspeedmodsyay = new double[]{0, 0.25, 0.5, 0.75, 1, 1.25, 1.5, 1.75, 2, 2.25, 2.5, 2.75, 3, 3.25, 3.5, 3.75, 4, 4.25, 4.5, 4.75, 5, 5.25, 5.5, 5.75, 6, 6.25, 6.5, 6.75, 7, 7.25, 7.5, 7.75};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText yourBPM = (EditText) findViewById(R.id.editText_yourBPM);
        yourBPM.setGravity(Gravity.CENTER);
        EditText songBPM = (EditText) findViewById(R.id.editText_songBPM);
        songBPM.setGravity(Gravity.CENTER);
        TextView result_text = (TextView) findViewById(R.id.text_result);
        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        Button aboutButton = (Button) findViewById(R.id.buttonAbout);
        TextView option1 = (TextView) findViewById(R.id.text_option1);
        option1.setGravity(Gravity.CENTER);
        TextView option2 = (TextView) findViewById(R.id.text_option2);
        option2.setGravity(Gravity.CENTER);
        TextView option3 = (TextView) findViewById(R.id.text_option3);
        option3.setGravity(Gravity.CENTER);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float int_yourBPM = Float.valueOf(yourBPM.getText().toString());
                    float int_songBPM = Float.valueOf(songBPM.getText().toString());
                    float int_result = int_yourBPM / int_songBPM;

                    int marker = 0;
                    while(true){
                        Double speedMod = yayspeedmodsyay[marker];
                        Log.d("yaytagyay", "speedmod: " + speedMod);
                        Double result = Double.parseDouble(Double.toString(int_result));
                        int yaycompareyay = result.compareTo(speedMod);
                        if (yaycompareyay < 0) {
                            Log.d("yaytagyay", "yay: " + speedMod);
                            break;
                        }
                        marker = marker + 1;
                    }

                    float int_1below = int_songBPM * (float) yayspeedmodsyay[marker - 2];
                    float int_0 = int_songBPM * (float) yayspeedmodsyay[marker - 1];
                    float int_1above = int_songBPM * (float) yayspeedmodsyay[marker];

                    result_text.setText("x" + yayspeedmodsyay[marker - 1]);
                    option1.setText("x" + yayspeedmodsyay[marker - 2] + " - " + int_1below + " BPM");
                    option2.setText("x" + yayspeedmodsyay[marker - 1] + " - " + int_0 + " BPM");
                    option3.setText("x" + yayspeedmodsyay[marker - 0] + " - " + int_1above + " BPM");
                } catch(Exception e){
                    option1.setText("");
                    option2.setText("");
                    option3.setText("");
                    result_text.setText(e.toString());
                }
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setText("Something something use this app however you want. Just don't be a dick.");
                option2.setText("No I won't take suggestions. I made this for me only.");
                option3.setText("GitHub repo: https://github.com/Yogehi/BPMCalculator");
            }
        });
    }
}