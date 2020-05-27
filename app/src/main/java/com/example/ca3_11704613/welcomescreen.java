package com.example.ca3_11704613;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class welcomescreen extends AppCompatActivity {

    Button b1,b2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);

         db=new DatabaseHelper(this);





        b1=findViewById(R.id.issuebutton);
        b2=findViewById(R.id.returnutton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cur= db.getAllDataFromBooksTable();
                if (cur.getCount()==0){
                    Toast.makeText(welcomescreen.this, "No book Avalable, Contact Admin", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<String> list=new ArrayList<>();
                    while (cur.moveToNext()){
                        list.add(cur.getString(1));
                    }
                    Intent dataInt=new Intent(welcomescreen.this,issuePage.class);
                    dataInt.putExtra("books",list);
                    startActivity(dataInt);

                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur= db.getAllDataFromStudent();
                if (cur.getCount()==0){
                    Toast.makeText(welcomescreen.this, "No issued books", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<String> list=new ArrayList<>();
                    while (cur.moveToNext()){
                        list.add(cur.getString(2));
                    }
                    Intent dataInt=new Intent(welcomescreen.this,returnbookpage.class);
                    dataInt.putExtra("issued",list);
                    startActivity(dataInt);

                }



            }
        });
    }
}
