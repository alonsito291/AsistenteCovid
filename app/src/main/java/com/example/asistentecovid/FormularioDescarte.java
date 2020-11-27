package com.example.asistentecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioDescarte extends AppCompatActivity {

    TextView resultado;
    EditText nombre,temperatura,edad;
    RadioGroup diRespirar,contacto,doCabeza,doGarganta,doPecho,saturacion;
    Button evaluar;

    int valor1,valor2,valor3,valor4,valor5,valor6;
    int suma=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_descarte);

        resultado=(TextView)findViewById(R.id.txtResultado);

        nombre=(EditText)findViewById(R.id.txtNombre);
        temperatura=(EditText)findViewById(R.id.txtTemperatura);
        edad=(EditText)findViewById(R.id.txtEdad);

        diRespirar=(RadioGroup)findViewById(R.id.rbgDificultad);
        contacto=(RadioGroup)findViewById(R.id.rbgContacto);
        doCabeza=(RadioGroup)findViewById(R.id.rbgDolorCabeza);
        doGarganta=(RadioGroup)findViewById(R.id.rbgDolorGarganta);
        doPecho=(RadioGroup)findViewById(R.id.rbgDolorPecho);
        saturacion=(RadioGroup)findViewById(R.id.rbgNivelSaturacion);

        evaluar=(Button)findViewById(R.id.btnEvaluar);

        evaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int suma=valor1+valor2+valor3+valor4+valor5+valor6;
                int ed=Integer.parseInt(edad.getText().toString());
                double tem=Double.parseDouble(temperatura.getText().toString());
                String nom=nombre.getText().toString();
                if(nombre.equals("") || temperatura.equals("") || edad.equals("")){
                    Toast toast=Toast.makeText(getApplicationContext(),"Campo Vacio",Toast.LENGTH_LONG);
                    toast.show();
                }else if(ed<=25){
                    if(tem<37){

                        if (suma<=2){
                            resultado.setText(nom+" NO TIENE COVID19");
                        }else if(suma>2 & suma<=5){
                            resultado.setText(nom+" ES POSIBLE QUE SE HAYA CONTAGIADO");
                        }else if(suma>5){
                            resultado.setText(nom+" ESTA CONTAGIADO CON COVID. VAYA  AUN CENTRO DE SALUD PARA SU DESCARTE");
                        }
                    }else if(tem>37){

                        if (suma<=2){
                            resultado.setText(nom+" NO TIENE COVID19");
                        }else if(suma>2 & suma<=5){
                            resultado.setText(nom+" ES POSIBLE QUE SE HAYA CONTAGIADO");
                        }else if(suma>5){
                            resultado.setText(nom+" ESTA CONTAGIADO CON COVID. VAYA AUN CENTRO DE SALUD PARA SU DESCARTE");
                        }
                    }
                }else if(ed>25 & ed<=45){
                    if(tem<37){

                        if (suma<=2){
                            resultado.setText(nom+" NO TIENE COVID19");
                        }else if(suma>2 & suma<=5){
                            resultado.setText(nom+" ES POSIBLE QUE SE HAYA CONTAGIADO");
                        }else if(suma>5){
                            resultado.setText(nom+" ESTA CONTAGIADO CON COVID. VAYA AUN CENTRO DE SALUD PARA SU DESCARTE");
                        }
                    }else if(tem>37){

                        if (suma<=2){
                            resultado.setText(nom+" NO TIENE COVID19");
                        }else if(suma>2 & suma<=5){
                            resultado.setText(nom+" ES POSIBLE QUE SE HAYA CONTAGIADO");
                        }else if(suma>5){
                            resultado.setText(nom+" ESTA CONTAGIADO CON COVID. VAYA AUN CENTRO DE SALUD PARA SU DESCARTE");
                        }
                    }
                }else if(ed>45){
                    if(tem<37){

                        if (suma<=2){
                            resultado.setText(nom+" NO TIENE COVID19");
                        }else if(suma>2 & suma<=5){
                            resultado.setText(nom+" ES POSIBLE QUE SE HAYA CONTAGIADO, PERSONAS CON RIEGO ALTO");
                        }else if(suma>5){
                            resultado.setText(nom+" ESTA CONTAGIADO CON COVID. VAYA AUN CENTRO DE SALUD PARA SU DESCARTE, PERSONAS CON RIEGO ALTO");
                        }
                    }else if(tem>37){

                        if (suma<=2){
                            resultado.setText(nom+" NO TIENE COVID19");
                        }else if(suma>2 & suma<=5){
                            resultado.setText(nom+" ES POSIBLE QUE SE HAYA CONTAGIADO, PERSONAS CON RIEGO ALTO");
                        }else if(suma>5){
                            resultado.setText(nom+" ESTA CONTAGIADO CON COVID. VAYA AUN CENTRO DE SALUD PARA SU DESCARTE, PERSONAS CON RIEGO ALTO");
                        }
                    }
                }
            }
        });

        diRespirar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {

                if(chekedId==R.id.rbDiSi){
                    valor1=1;
                }else if(chekedId==R.id.rbDiNo){
                    valor1=0;
                }
            }
        });

        contacto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {

                if(chekedId==R.id.rbConSi){
                    valor2=1;
                }else if(chekedId==R.id.rbConNo){
                    valor2=0;
                }
            }
        });

        doCabeza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {

                if(chekedId==R.id.rbCaSi){
                    valor3=1;
                }else if(chekedId==R.id.rbCaNo){
                    valor3=0;
                }
            }
        });

        doGarganta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {

                if(chekedId==R.id.rbGarSi){
                    valor4=1;
                }else if(chekedId==R.id.rbGarNo){
                    valor4=0;
                }
            }
        });

        doPecho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {

                if(chekedId==R.id.rbPecSi){
                    valor5=1;
                }else if(chekedId==R.id.rbPecNo){
                    valor5=0;
                }
            }
        });

        saturacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedId) {

                if(chekedId==R.id.rbMe90){
                    valor6=4;
                }else if(chekedId==R.id.rbMa90){
                    valor6=0;
                }
            }
        });

    }
}