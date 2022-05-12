package es.ifp.proyectodamgrupo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText textUser;
    protected EditText textPass;
    protected Button buttonLogin;
    protected Button buttonRegister;

    private Intent pasarPantalla;
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        label1= (TextView) findViewById(R.id.label1_login);
        textUser= (EditText) findViewById(R.id.textUser_login);
        textPass= (EditText) findViewById(R.id.textPass_login);
        buttonLogin= (Button) findViewById(R.id.buttonLogin_login);
        buttonRegister= (Button) findViewById(R.id.buttonRegister_login);

        db=new DataBase();

        if (db.conex()) {
            Toast.makeText(this, "Conexión con servidor establecida", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Fallo en la conexión, reinicie aplicación", Toast.LENGTH_LONG).show();
        }


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=textUser.getText().toString();
                String pass=textPass.getText().toString();

                if (db.access(user, pass)) {

                    if (db.userOrAdmin(user)) {

                        pasarPantalla=new Intent(LoginActivity.this, ListActivityAdmin.class);
                        finish();
                        startActivity(pasarPantalla);

                    } else {

                        pasarPantalla=new Intent(LoginActivity.this, ListActivityUser.class);
                        finish();
                        startActivity(pasarPantalla);

                    }

                } else {

                    Toast.makeText(LoginActivity.this, "Usuario y/o contraseña erróneos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(LoginActivity.this, RegisterActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}