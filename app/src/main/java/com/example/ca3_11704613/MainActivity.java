package com.example.ca3_11704613;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button submitbtn;
    EditText regNo_et;
    public static String registrationNumber;
    ImageView adminpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitbtn=findViewById(R.id.submitbtn);

        regNo_et=findViewById(R.id.regnumber);

        adminpage=findViewById(R.id.adminn);



        adminpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),admincredentials.class);
                startActivity(intent);
            }
        });





        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (regNo_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Registration Number", Toast.LENGTH_SHORT).show();

                }else{
                    registrationNumber=regNo_et.getText().toString();
                    Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,welcomescreen.class);
                    startActivity(intent);
                }
            }
        });
    }
    public static String getRegistration(){

        return registrationNumber;
    }

}
