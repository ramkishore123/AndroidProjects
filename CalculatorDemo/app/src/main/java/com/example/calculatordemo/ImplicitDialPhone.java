package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImplicitDialPhone extends AppCompatActivity {
    Button dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_dial_phone);

        dial=findViewById(R.id.btn_imple_dial_intent);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+4917637246863"));

                if(intent.resolveActivity(getPackageManager())!=null){

                    startActivity(intent);
                }


            }
        });
    }
}
