package es.ifp.proyectodamgrupo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText textUser;
    protected EditText textPass;
    protected Button buttonLogin;
    protected Button buttonRegister;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        label1= (TextView) findViewById(R.id.label1_login);
        textUser= (EditText) findViewById(R.id.textUser_login);
        textPass= (EditText) findViewById(R.id.textPass_login);
        buttonLogin= (Button) findViewById(R.id.buttonLogin_login);
        buttonRegister= (Button) findViewById(R.id.buttonRegister_login);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(LoginActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);
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