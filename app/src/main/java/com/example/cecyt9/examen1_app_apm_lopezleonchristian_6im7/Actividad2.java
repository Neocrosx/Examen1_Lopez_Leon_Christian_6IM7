package com.example.cecyt9.examen1_app_apm_lopezleonchristian_6im7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

public class Actividad2 extends AppCompatActivity {

    TextView nomydat;
    String conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        nomydat = (TextView) findViewById(R.id.txtVRes);
        Bundle recibe = getIntent().getExtras();
        conversion = recibe.getString("conv");

        nomydat.setText("López León Christian Oswaldo, \nResultado:\t".concat(conversion));
    }

    public void onClickEnviar(View v){

        Intent enviaMail = new Intent(Intent.ACTION_SEND);
        enviaMail.setData(Uri.parse("mailto:"));
        enviaMail.putExtra(Intent.EXTRA_EMAIL, new String[] { "eoropezag@ipn.mx"});
        enviaMail.putExtra(Intent.EXTRA_SUBJECT, "examen 1er parcial");
        enviaMail.putExtra(Intent.EXTRA_TEXT, nomydat.getText().toString());
        enviaMail.setType("text/plain");
        startActivity(Intent.createChooser(enviaMail, "Email"));

        }
}
