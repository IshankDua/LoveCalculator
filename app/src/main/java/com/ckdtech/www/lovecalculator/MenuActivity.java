package com.ckdtech.www.lovecalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnlogout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button btnlogout = (Button) findViewById(R.id.exit);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Exiting will means you are leaving the love game..Are You Sure you want to leave now...? ");
                builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){

                        finish();

                    }
                });
                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void calculateButtonClicked (View v){

        Intent a = new Intent(MenuActivity.this,CalculateActivity.class);
        startActivity(a);
        Toast.makeText(this, "Calculate Button Clicked", Toast.LENGTH_SHORT).show();

    }



    public void lovequotesButtonClicked (View v){

        Intent a = new Intent(MenuActivity.this,LovequotesActivity.class);
        startActivity(a);
        Toast.makeText(this, "Love Quotes Button Clicked", Toast.LENGTH_SHORT).show();

    }



    public void feedbackButtonClicked (View v){

        Intent a = new Intent(MenuActivity.this,ContactActivity.class);
        startActivity(a);
        Toast.makeText(this, "Feedback Button Clicked", Toast.LENGTH_SHORT).show();

    }


}
