package com.example.ca3_11704613;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class issuePage extends AppCompatActivity {

    ListView bookslist;
    ArrayAdapter adapter;
    int numberOfBooksIssued=0;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_page);

        Toast.makeText(this, MainActivity.getRegistration(), Toast.LENGTH_SHORT).show();
        db=new DatabaseHelper(this);


        ArrayList  booknames=new ArrayList<String>();
        booknames = getIntent().getStringArrayListExtra("books");
       // Toast.makeText(this, booknames.toString(), Toast.LENGTH_SHORT).show();


        bookslist=findViewById(R.id.book_lv);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,booknames);
        bookslist.setAdapter(adapter);

        bookslist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfBooksIssued++;

               if (numberOfBooksIssued<=3){
                   Toast.makeText(issuePage.this, adapter.getItem(position)+" is Issued", Toast.LENGTH_SHORT).show();
                   db.updateBooksAvail(Integer.toString(position+1),"Unavailable");
                   db.insertDataIntoStudent(MainActivity.getRegistration(),adapter.getItem(position).toString(),"Unavailable");
                   adapter.remove(position);
                   
               }else{
                   Toast.makeText(issuePage.this, "limit reached", Toast.LENGTH_SHORT).show();
               }
                return true;
            }
        });




    }
}
