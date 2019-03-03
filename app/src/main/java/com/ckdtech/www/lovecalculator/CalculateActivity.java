package com.ckdtech.www.lovecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    EditText textName1;
    EditText textName2;
    TextView textViewResult;
    Button buttonCalculate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);

        textName1 = findViewById(R.id.textName1);
        textName2 = findViewById(R.id.textName2);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = textName1.getText().toString().toLowerCase();
                String str2 = textName2.getText().toString().toLowerCase();


                String calculation = calculate(str1,str2);
                textViewResult.setText(calculation);

            }
        });

    }


    String countChars(String str1, String str2){
        String combinedString = str1 + "Loves" + str2;

        String strAllChars = "";
        String strCount = "";

        for (char c1: combinedString.toCharArray()) {
            if (strAllChars.indexOf(c1)<0){
                int count = 0;
                for (char c2: combinedString.toCharArray()){
                    if (c1 == c2){
                        count = count + 1;
                    }
                }
                strAllChars = strAllChars + c1;
                strCount = strCount +String.valueOf(count);
            }
        }

      return strCount;

    }


    String shortenNumber(String str) {
        String shortenString = "";
        if(str.length() >=2) {
            int int1 = Integer.parseInt(String.valueOf(str.toCharArray()[0]));
            int int2 = Integer.parseInt(String.valueOf(str.toCharArray() [str.length() - 1]));
            shortenString = String.valueOf(int1 + int2) + shortenNumber(str.substring(1, str.length() - 1));
        } else{
            return str;
        }

        return shortenString;
    }


    String calculate(String str1, String str2){
        String shortString = countChars(str1 , str2);
        String output = shortString;
        do {
            output = output + "\n";
            shortString = shortenNumber(shortString);
            if (shortString.length() == 2) {
                output = output + "\n";
            }
            output = output + shortString;
            } while (shortString.length() > 2);
        output = output + "% is your Result";

        return output;
    }
}
