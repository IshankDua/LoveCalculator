package com.ckdtech.www.lovecalculator;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lovequotes2Activity extends AppCompatActivity implements View.OnClickListener{

    Button sendBtn;
    EditText phoneEdt,msgEdt;
    TextView statusTV;

    private  static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lovequotes2_activity);

        String sessionId = getIntent().getStringExtra("message");
        Toast.makeText(this, "message" + sessionId, Toast.LENGTH_SHORT).show();

        sendBtn = (Button)findViewById(R.id.button);
        phoneEdt = (EditText)findViewById(R.id.editText);
        msgEdt = (EditText)findViewById(R.id.editText2);
        msgEdt.setText(sessionId);

        statusTV = (TextView)findViewById(R.id.statusTV);


        sendBtn.setOnClickListener((View.OnClickListener) this);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission is not granted", Toast.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},123);
            sendBtn.setEnabled(false);
        }else{
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            sendBtn.setEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                statusTV.setText("Permission Granted Good to Continue or Send SMS");
                sendBtn.setEnabled(true);
            }else{
                statusTV.setText("Permission Not Granted");
                sendBtn.setEnabled(false);
            }
        }

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneEdt.getText().toString(), null, msgEdt.getText().toString(), null, null);
            statusTV.setText("Message Sent Successfully");
        }


    }
}


