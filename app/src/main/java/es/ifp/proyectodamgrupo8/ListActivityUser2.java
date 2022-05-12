package es.ifp.proyectodamgrupo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListActivityUser2 extends AppCompatActivity {

    protected TextView labelFecha;
    protected Button button10;
    protected Button button11;
    protected Button button12;
    protected Button button13;
    protected Button button16;
    protected Button button17;
    protected Button button18;
    protected Button button19;
    protected Button buttonVolver;

    private Intent pasarPantalla;
    private Bundle extras;
    private String paquete1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user2);

        labelFecha=(TextView) findViewById(R.id.labelFecha_UserList2);
        button10=(Button) findViewById(R.id.button10_UserList2);
        button11=(Button) findViewById(R.id.button11_UserList2);
        button12=(Button) findViewById(R.id.button12_UserList2);
        button13=(Button) findViewById(R.id.button13_UserList2);
        button16=(Button) findViewById(R.id.button16_UserList2);
        button17=(Button) findViewById(R.id.button17_UserList2);
        button18=(Button) findViewById(R.id.button18_UserList2);
        button19=(Button) findViewById(R.id.button19_UserList2);
        buttonVolver=(Button) findViewById(R.id.buttonVolver_UserList2);

        extras = getIntent().getExtras();

        if (extras != null) {

            paquete1 = extras.getString("FECHA");
            labelFecha.setText(paquete1);
        }

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(ListActivityUser2.this, ListActivityUser.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}