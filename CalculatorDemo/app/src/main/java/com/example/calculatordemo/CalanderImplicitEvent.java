package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalanderImplicitEvent extends AppCompatActivity {

     EditText title, location, description;
     Button alaram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander_implicit_event);

        title=findViewById(R.id.et_title);
        location=findViewById(R.id.et_location);
        description=findViewById(R.id.et_description);


        alaram=findViewById(R.id.btn_call_intent);

        alaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(! title.getText().toString().isEmpty() && !location.getText().toString().isEmpty()&&
                        !description.getText().toString().isEmpty()){


                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location.getText().toString());
                intent.putExtra(CalendarContract.Events.DESCRIPTION,description.getText().toString());
                intent.putExtra(CalendarContract.Events.ALL_DAY,true);

                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }

                }
            }
        });


    }
}
