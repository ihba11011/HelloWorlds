package com.example.hp.helloworld;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView txttitle;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      //  textView=findViewById(R.id.txtResult);

        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> data=new ArrayList<>();
        recyclerView.setAdapter(new RecyclerAdapter(data));
        myDb = new DataBaseHelper(this);
    Cursor res=myDb.getAllData();

    StringBuffer stringBuffer=new StringBuffer();
    if(res!=null && res.getCount()>0){
        while(res.moveToNext()){
            stringBuffer.append("Id: "+res.getString(0)+"\n");
            stringBuffer.append("Name: "+res.getString(1)+"\n");
            stringBuffer.append("Surname: "+res.getString(2)+"\n");
            stringBuffer.append("Marks: "+res.getString(3)+"\n"+"\n");

        }
        this.txttitle  = txttitle;
        txttitle.setText(stringBuffer.toString());
        // System.out.println(txtResult);


            Toast.makeText(this, "Data Reterieved successfully", Toast.LENGTH_SHORT).show();
        }
    else

        {
            Toast.makeText(this, "No Data to retrieve", Toast.LENGTH_SHORT).show();
        }
    }

}
