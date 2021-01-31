package com.sample.samplefilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager extends AppCompatActivity implements View.OnClickListener {

    Button btnCreateFile, btnViewContent;
    EditText etInsertText;
    TextView tvContent;
    String filePath = "/mnt/sdcard/writefile.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateFile = findViewById(R.id.btnCreateFile);
        btnCreateFile.setOnClickListener(this);

        btnViewContent = findViewById(R.id.btnViewContent);
        btnViewContent.setOnClickListener(this);

        etInsertText = findViewById(R.id.etInsertText);
        tvContent = findViewById(R.id.tvContent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateFile:
                String content = etInsertText.getText().toString();
                if (content.isEmpty()) {
                    Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
                } else {
                    createFile(content);
                    hideKeyboard();
                }

                break;

            case R.id.btnViewContent:

                File textFile = new File(filePath);
                if (textFile.exists()){
                    readFile();
                }else{
                    Toast.makeText(this, "Please Create a file ", Toast.LENGTH_SHORT).show();
                }


                break;
        }

    }


    //to create a file
    public void createFile(String content) {

        byte[] inputBytes = content.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(inputBytes);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            FileChannel fileChannel = fos.getChannel();
            fileChannel.write(buffer);
            fileChannel.close();
            fos.close();
            Toast.makeText(this, "Created file", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //to read file
    private void readFile() {
        StringBuilder text = new StringBuilder();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                //process the line
                text.append(line);
                text.append('\n');
            }
            br.close();
            fr.close();
            tvContent.setText(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
