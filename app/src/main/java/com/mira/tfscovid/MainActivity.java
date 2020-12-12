package com.mira.tfscovid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAfficher;
    EditText editNom;
    EditText editPrenom;
    EditText editPhone;
    EditText editEmail;
    private final int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNom=findViewById(R.id.editNom);
        editPrenom=findViewById(R.id.editPrenom);
        editEmail=findViewById(R.id.editEmail);
        editPhone=findViewById(R.id.editPhone);



        btnAfficher=findViewById(R.id.btnAfficher);
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Nom=editNom.getText().toString();
                String Prenom=editPrenom.getText().toString();
                String Phone=editPhone.getText().toString();
                String Email=editEmail.getText().toString();

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                intent.putExtra("NomMessage",Nom);
                intent.putExtra("PrenomMessage",Prenom);
                intent.putExtra("EmailMessage",Email);
                intent.putExtra("PhoneMessage",Phone);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                String result=data.getStringExtra("returnData");
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}