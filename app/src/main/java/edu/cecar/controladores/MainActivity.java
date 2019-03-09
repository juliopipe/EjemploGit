package edu.cecar.controladores;

import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText teNombres;
    private TextInputEditText teNacionalidad;
    private TextInputEditText teSexo;
    private TextInputEditText teCategoria;

    // String url = "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000787132"; namuel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se referencias los elementos graficos
        teNombres = findViewById(R.id.teNombres);
        teNacionalidad = findViewById(R.id.teNacionalidad);
        teSexo = findViewById(R.id.teSexo);
        teCategoria = findViewById(R.id.teCategorizado);


        Button btObtenerDatosCVLac = findViewById(R.id.btObtenerDatos);
        btObtenerDatosCVLac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                extraerDatosCVLAC();

            }
        });
    }

    public void extraerDatosCVLAC() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Investigador investigador = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180");
                adicionarDatosCasillasTexto(investigador);

            }

        }).start();

    }

    public void adicionarDatosCasillasTexto(final Investigador investigador) {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                teNombres.setText(investigador.getNombres());
                teNacionalidad.setText(investigador.getNacionalidad());
                teSexo.setText(investigador.getSexo());
                teCategoria.setText(investigador.isCategorizado() ? "Si" : "No");

            }
        });

    }

}
