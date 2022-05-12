package es.ifp.proyectodamgrupo8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListActivityUser extends AppCompatActivity {

    protected CalendarView calendar;
    protected Button button1;
    protected Button button2;
    protected String fecha="";

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        getSupportActionBar().hide();

        calendar= (CalendarView) findViewById(R.id.calendarView);
        button1=(Button) findViewById(R.id.button_UserList1);
        button2=(Button) findViewById(R.id.button2_UserList1);

        long ahora = System.currentTimeMillis();
        Date fechaHoy = new Date(ahora);
        DateFormat df = new SimpleDateFormat("d/M/yyyy");
        fecha = df.format(fechaHoy);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                fecha= day+"/"+(month+1)+"/"+year;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(ListActivityUser.this, ListActivityUser2.class);
                pasarPantalla.putExtra("FECHA", fecha);
                finish();
                startActivity(pasarPantalla);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla=new Intent(ListActivityUser.this, MisCitasUserActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}