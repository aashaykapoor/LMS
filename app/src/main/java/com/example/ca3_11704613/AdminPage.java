package com.example.ca3_11704613;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    Button b1, b2, b3;
    EditText enterBookName;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        b1 = findViewById(R.id.addbook);

        b3 = findViewById(R.id.finalsubmitbtn);

        db=new DatabaseHelper(this);

        enterBookName = findViewById(R.id.enter_et);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUp();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterBookName.getText().toString().isEmpty()){
                    Toast.makeText(AdminPage.this, "Enter Book Name", Toast.LENGTH_SHORT).show();
                }
                String bookname=enterBookName.getText().toString();
                db.insertDataIntoBooks(bookname);
                Toast.makeText(AdminPage.this, "Book Added", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void showUp() {
        enterBookName.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
    }


}