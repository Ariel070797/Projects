import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText caja1;
    protected Spinner sp1;
    protected Button boton1, boton2;
    protected BaseDatosSQLite db;
    private Intent pasarPantalla;
    private Bundle extras;
    private String paquete1, paquete2, paquete3;
    private String contenidoCaja1="";
    private ArrayList<String> prioridades = new ArrayList<String>();
    private ArrayAdapter<String> adaptadorSP;
    private int prioridadSeleccionada = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        label1 = (TextView) findViewById(R.id.label1_second);
        caja1 = (EditText) findViewById(R.id.caja1_second);
        sp1 = (Spinner) findViewById(R.id.sp1_second);
        boton1 = (Button) findViewById(R.id.boton1_second);
        boton2 = (Button) findViewById(R.id.boton2_second);

        //Si existen, pasamos datos a la siguiente pantalla
        extras = getIntent().getExtras();
        if (extras != null) {

            //Llamada a la BBDD
            db = new BaseDatosSQLite(this);
            paquete1=extras.getString("ID");
            paquete2=extras.getString("PRIORITY");
            paquete3=extras.getString("TITLE");
            caja1.setText(paquete3);
            
            prioridades.add("Muy alta");
            prioridades.add("Alta");
            prioridades.add("Media");
            prioridades.add("Baja");
            prioridades.add("Muy baja");
            adaptadorSP = new ArrayAdapter<String>(SecondActivity.this, android.R.layout.simple_list_item_1, prioridades);
            sp1.setAdapter(adaptadorSP);
            sp1.setSelection(Integer.parseInt(paquete2));
            prioridadSeleccionada=Integer.parseInt(paquete2);

            sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    prioridadSeleccionada = position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //Crear notas y pasamos a la pantalla del inicio
            boton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    contenidoCaja1=caja1.getText().toString();
                    if (contenidoCaja1.equalsIgnoreCase("")) {
                        Toast.makeText(SecondActivity.this, "Debe introducir alguna nota", Toast.LENGTH_SHORT).show();
                    } else {
                        db.updateNote(Integer.parseInt(paquete1), contenidoCaja1, prioridadSeleccionada);
                        Toast.makeText(SecondActivity.this, "Nota actualizada correctamente", Toast.LENGTH_SHORT).show();
                        pasarPantalla = new Intent(SecondActivity.this, StartActivity.class);
                        pasarPantalla.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(pasarPantalla);
                    }
                }
            });

        } else {
            Toast.makeText(this, "No se han recibido paquetes", Toast.LENGTH_SHORT).show();
        }

        //Volver a la pantalla principal
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(SecondActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

    }
}
