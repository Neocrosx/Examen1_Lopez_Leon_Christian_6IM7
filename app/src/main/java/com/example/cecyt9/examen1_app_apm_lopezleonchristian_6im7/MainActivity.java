package com.example.cecyt9.examen1_app_apm_lopezleonchristian_6im7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cambio;
    float conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambio = (EditText) findViewById(R.id.txtCantidad);

    }

    public void onClickConvertir (View v){
        if(!cambio.getText().toString().equals("0")){
            try{
                float numb = Float.parseFloat(cambio.getText().toString());
                conversion = (numb) / (15);

                Intent envia = new Intent(this, Actividad2.class);
                Bundle datos = new Bundle();
                datos.putString("conv", Float.toString(conversion));
                envia.putExtras(datos);
                finish();
                startActivity(envia);

            }catch(Exception e){
                e.getMessage();
                Toast.makeText(this, "Favor de ingresar un número valido", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "El '0' no es un número valido, favor de ingresar un número valido", Toast.LENGTH_LONG).show();
        }
    }
}
