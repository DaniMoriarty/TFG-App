package es.ifp.proyectodamgrupo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MisCitasUserActivity extends AppCompatActivity {

    protected ListView list;
    protected Button buttonNuevaCita;
    protected Button buttonSalir;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_citas_user);

        list=(ListView) findViewById(R.id.list_misCitas);
        buttonNuevaCita=(Button) findViewById(R.id.buttonNuevaCita_misCitas);
        buttonSalir=(Button) findViewById(R.id.buttonSalir_misCitas);


        buttonNuevaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(MisCitasUserActivity.this, ListActivityUser.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(MisCitasUserActivity.this, LoginActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}