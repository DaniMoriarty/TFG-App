package es.ifp.proyectodamgrupo8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected TextView label3;
    protected EditText textUser;
    protected EditText textPass;
    protected Button buttonRegister;
    protected Button buttonBack;
    protected RadioGroup radioGroup;
    protected RadioButton radioUser;
    protected RadioButton radioAdmin;

    private Intent pasarPantalla;
    private DataBase db;

    String user="";
    String pass="";
    String rol="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        label1= (TextView) findViewById(R.id.label1_register);
        label2= (TextView) findViewById(R.id.label2_register);
        label3= (TextView) findViewById(R.id.label3_register);
        textUser= (EditText) findViewById(R.id.textUser_register);
        textPass= (EditText) findViewById(R.id.textPass_register);
        buttonRegister= (Button) findViewById(R.id.button1_register);
        buttonBack= (Button) findViewById(R.id.button2_register);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup_register);
        radioUser= (RadioButton) findViewById(R.id.radioUser_register);
        radioAdmin= (RadioButton) findViewById(R.id.radioAdmin_register);

        db=new DataBase();

        if (!db.conex()) {

            Toast.makeText(this, "Fallo en la conexión, reinicie aplicación", Toast.LENGTH_LONG).show();
        }


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user=textUser.getText().toString();
                pass=textPass.getText().toString();
                if (radioUser.isChecked()) {
                    rol="usuario";
                } else {
                    rol="admin";
                }

                if (user.equals("") || pass.equals("")) {

                    Toast.makeText(RegisterActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else {

                    if (rol.equals("usuario")) {

                        pasarPantalla=new Intent(RegisterActivity.this, MisCitasUserActivity.class);
                        finish();
                        startActivity(pasarPantalla);

                    } else if (rol.equals("admin")) {

                        pasarPantalla=new Intent(RegisterActivity.this, ListActivityAdmin.class);
                        finish();
                        startActivity(pasarPantalla);

                    } else {

                        Toast.makeText(RegisterActivity.this, "Debes seleccionar un rol", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(RegisterActivity.this, LoginActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}