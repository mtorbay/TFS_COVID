package com.mira.tfscovid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAfficher;
    EditText editNom;
    EditText editPrenom;
    EditText editPhone;
    EditText editEmail;
    RadioGroup radioGroup;
    private final int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Nom;
        String Prenom;
        String Phone;
        String Email;
        Nom=editNom.getText().toString();
        Prenom=editPrenom.getText().toString();
        Email=editEmail.getText().toString();
        Phone=editPhone.getText().toString();

        btnAfficher=findViewById(R.id.btnAfficher);
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                intent.putExtra("NomMessage",Nom);
                intent.putExtra("PrenomMessage",Prenom);
                intent.putExtra("EmailMessage",Email);
                intent.putExtra("PhoneMessage",Phone);
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