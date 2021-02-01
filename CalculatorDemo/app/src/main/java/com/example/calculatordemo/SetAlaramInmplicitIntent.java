package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetAlaramInmplicitIntent extends AppCompatActivity {

    Button setAlaram;
    EditText hours, minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alaram_inmplicit_intent);

        hours=findViewById(R.id.et_Hours);
        minutes=findViewById(R.id.et_Minutes);
        setAlaram=findViewById(R.id.btn_alaram);


        setAlaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Hours= Integer.parseInt(hours.getText().toString());

                int Minutes= Integer.parseInt(minutes.getText().toString());


                Intent intent= new Intent();
                intent.setAction(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,Hours);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Minutes);


                if(intent.resolveActivity(getPackageManager())!=null){

                    if(Hours<24 && Minutes <60){

                        startActivity(intent);
                    }
                }




            }
        });
    }
}
