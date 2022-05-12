package es.ifp.proyectodamgrupo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListActivityAdmin extends AppCompatActivity {

    protected ListView list;
    protected Button buttonVolver;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_admin);
        getSupportActionBar().hide();

        list=(ListView) findViewById(R.id.list_adminList);
        buttonVolver=(Button) findViewById(R.id.buttonVolver_adminList);


        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(ListActivityAdmin.this, LoginActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}