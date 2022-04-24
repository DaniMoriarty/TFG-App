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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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



        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(RegisterActivity.this, ListActivity.class);
                finish();
                startActivity(pasarPantalla);

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