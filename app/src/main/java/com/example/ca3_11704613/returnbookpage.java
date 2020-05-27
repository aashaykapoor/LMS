package com.example.ca3_11704613;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class returnbookpage extends AppCompatActivity {

    ListView issuebooks;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returnbookpage);

        ArrayList booknames=new ArrayList<String>();
        booknames=getIntent().getStringArrayListExtra("issued");

        Toast.makeText(this, booknames.toString(), Toast.LENGTH_SHORT).show();
        issuebooks=findViewById(R.id.returnbookslist);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,booknames);
        issuebooks.setAdapter(adapter);
        
        issuebooks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(returnbookpage.this, "Book Returned Successfully", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
