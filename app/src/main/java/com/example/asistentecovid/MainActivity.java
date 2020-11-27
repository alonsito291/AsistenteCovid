package com.example.asistentecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button hospital,clinica,posta,comisaria,descarte,zonaRoja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hospital=(Button)findViewById(R.id.btnHopìtal);
        clinica=(Button)findViewById(R.id.btnClinica);
        posta=(Button)findViewById(R.id.btnPostas);
        comisaria=(Button)findViewById(R.id.btnComisarias);
        descarte=(Button)findViewById(R.id.btnDescarte);
        zonaRoja=(Button)findViewById(R.id.btnZonaRoja);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent().setClass(MainActivity.this,Hospital.class);
                startActivity(i);
            }
        });

        clinica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent().setClass(MainActivity.this,Clinica.class);
                startActivity(i);
            }
        });

        posta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent().setClass(MainActivity.this,CentroSalud.class);
                startActivity(i);
            }
        });

        comisaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent().setClass(MainActivity.this,Comisaria.class);
                startActivity(i);
            }
        });

        descarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent().setClass(MainActivity.this,FormularioDescarte.class);
                startActivity(i);
            }
        });
        zonaRoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent().setClass(MainActivity.this,ZonaRoja.class);
                startActivity(i);
            }
        });
    }
}