package com.example.hp.helloworld;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtName, txtSurName, txtMarks;
    Button btnClick,btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        txtName = findViewById(R.id.idName);
        txtSurName = findViewById(R.id.idSurname);
        txtMarks = findViewById(R.id.idMarks);
        btn=findViewById(R.id.button);
        btnClick = findViewById(R.id.idBtn);
        btnClick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ClickMe();
            }
        });


    }
    public void ClickonClick(View v){
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
    private void ClickMe(){
        String name=txtName.getText().toString();
        String surname=txtSurName.getText().toString();
        String marks=txtMarks.getText().toString();
        Boolean result =myDb.insertData(name,surname,marks);

        if(result == true)
        {
        Toast.makeText(this, "Data insertion successfully", Toast.LENGTH_SHORT).show();
        }
    else

        {
        Toast.makeText(this, "Data insertion Failed", Toast.LENGTH_SHORT).show();
        }
    }

}
