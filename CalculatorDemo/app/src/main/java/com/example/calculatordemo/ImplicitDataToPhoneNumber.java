package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitDataToPhoneNumber extends AppCompatActivity {

    Button sendData;
    EditText phoneData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_data_to_phone_number);

        sendData=findViewById(R.id.btn_phone);
        phoneData=findViewById(R.id.et_phoneData);


        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData( Uri.parse("smsto:+017637246863"));
                intent.putExtra(intent.EXTRA_TEXT,phoneData.getText().toString());
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }
}
