package com.mira.tfscovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtNomDisplay;
    private TextView txtPrenomDisplay;
    private TextView txtPhoneDisplay;
    private TextView txtEmailDisplay;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtPrenomDisplay=findViewById(R.id.txtPrenomDisplay);
        txtNomDisplay=findViewById(R.id.txtNomDisplay);
        txtPhoneDisplay=findViewById(R.id.txtPhoneDisplay);
        txtEmailDisplay=findViewById(R.id.txtEmailDisplay);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            String nommessage=extras.getString("NomMessage");
            String prenommessage=extras.getString("PrenomMessage");
            String emailmessage=extras.getString("EmailMessage");
            String phonemessage=extras.getString("PhoneMessage");
            txtNomDisplay.setText(nommessage);
            txtPrenomDisplay.setText(prenommessage);
            txtEmailDisplay.setText(emailmessage);
            txtPhoneDisplay.setText(phonemessage);
        }

        btnRetour=findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent=getIntent();
                returnIntent.putExtra("returnData", "Retourner au premier page...");
                setResult(RESULT_OK,returnIntent);
                finish();

            }
        });
    }
}