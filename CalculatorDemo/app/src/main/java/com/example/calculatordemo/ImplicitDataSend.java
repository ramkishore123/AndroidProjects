package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitDataSend extends AppCompatActivity {

    Button shareData;
    EditText data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_data_send);

        shareData=findViewById(R.id.btn_dataShare);
        data=findViewById(R.id.et_data);

        shareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we donot know which component to send so system displays a list of it
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                //pre defined keys known to other applications
                intent.putExtra(intent.EXTRA_TEXT,data.getText().toString());
                intent.setType("text/plain");
                startActivity(intent);

            }
        });
    }
}
