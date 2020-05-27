package com.example.ca3_11704613;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admincredentials extends AppCompatActivity {

    EditText passwordText;
    Button submitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincredentials);


        passwordText=findViewById(R.id.enterpasscde);
        submitbtn=findViewById(R.id.submitpasswordAdmin);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordText.getText().toString().isEmpty()){
                    Toast.makeText(admincredentials.this, "Enter Passcode", Toast.LENGTH_SHORT).show();
                }
                else if(passwordText.getText().toString().equals("admin12345")){
                    Intent intent = new Intent(getApplicationContext(), AdminPage.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(admincredentials.this, "Wrong Passcode", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
