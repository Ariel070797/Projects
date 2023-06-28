import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText caja1;
    protected ListView lista1;
    protected Button boton1;
    private String contenidoCaja1 = "";
    protected Spinner sp1;
    protected BaseDatosSQLite db;
    private ArrayList<String> filas = new ArrayList<String>();
    private ArrayAdapter<String> adaptador;

    private Intent pasarPantalla;
    private String contenidoItem = "";
    private String[] partes;
    private int identificador = 0;
    private ArrayList<String> prioridades = new ArrayList<String>();
    private ArrayAdapter<String> adaptadorSP;
    private int prioridadSeleccionada = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        label1 = (TextView) findViewById(R.id.label1_start);
        caja1 = (EditText) findViewById(R.id.caja1_start);
        boton1 = (Button) findViewById(R.id.boton1_start);
        lista1 = (ListView) findViewById(R.id.lista1_start);
        sp1 = (Spinner) findViewById(R.id.sp1_start);
      
        //Llamada de la BBDD
        db = new BaseDatosSQLite(this);
      
        //Prioridad de las notas
        prioridades.add("Muy alta");
        prioridades.add("Alta");
        prioridades.add("Media");
        prioridades.add("Baja");
        prioridades.add("Muy baja");
        adaptadorSP = new ArrayAdapter<String>(StartActivity.this, android.R.layout.simple_list_item_1, prioridades);
        sp1.setAdapter(adaptadorSP);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prioridadSeleccionada = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Mostrar todas las notas creadas
        filas = db.getAllNotes();
        adaptador = new ArrayAdapter<String>(StartActivity.this, android.R.layout.simple_list_item_1, filas);
        lista1.setAdapter(adaptador);
      
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contenidoCaja1 = caja1.getText().toString();
                if (contenidoCaja1.equalsIgnoreCase("")) {
                    Toast.makeText(StartActivity.this, "Debe introducir alguna nota", Toast.LENGTH_SHORT).show();
                } else {
                    //insetar nota a base de datos
                    Toast.makeText(StartActivity.this, "Una vez pulsado, la prioridad seleccionada es: " + prioridadSeleccionada, Toast.LENGTH_SHORT).show();

                    if (prioridadSeleccionada == -1) {
                        prioridadSeleccionada = 0;
                    }
                    db.insertNote(contenidoCaja1, prioridadSeleccionada);
                    prioridadSeleccionada = -1;
                    Toast.makeText(StartActivity.this, "Nota creada correctamente", Toast.LENGTH_SHORT).show();
                    pasarPantalla = new Intent(StartActivity.this, StartActivity.class);
                    pasarPantalla.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(pasarPantalla);
                }
            }
        });

        //Mantener pulsado encima de alguna nota para eliminar
        lista1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                builder.setTitle("Eliminar nota");
                builder.setMessage("Â¿Seguro que quieres eliminar la nota?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        contenidoItem = parent.getItemAtPosition(position).toString();
                        partes = contenidoItem.split(".-");
                        if (partes.length > 1) {
                            Toast.makeText(StartActivity.this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                            identificador = Integer.parseInt(partes[0]);

                            //Se borra de la base de datos
                            db.deleteNote(identificador);
                            pasarPantalla = new Intent(StartActivity.this, StartActivity.class);
                            startActivity(pasarPantalla);
                        }
                    }
                });
                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();

                return true;
            }
        });

        //Pulsamos en alguna nota para ampliarla y ver detalles
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                contenidoItem = parent.getItemAtPosition(position).toString();
                partes = contenidoItem.split(".-");
                if (partes.length > 1) {

                    Note n = db.getNote(Integer.parseInt(partes[0]));
                    if (n != null) {

                        identificador = Integer.parseInt(partes[0]);
                        AlertDialog.Builder builder = new AlertDialog.Builder(StartActivity.this);
                        builder.setTitle("Mostrar nota");
                        builder.setMessage("Identificador: " + n.getId() + "\n Titulo: " + n.getTitle() + "\n Prioridad: " + n.getPriority());

                        builder.setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                pasarPantalla = new Intent(StartActivity.this, SecondActivity.class);
                                pasarPantalla.putExtra("ID", Integer.toString(n.getId()));
                                pasarPantalla.putExtra("PRIORITY", Integer.toString(n.getPriority()));
                                pasarPantalla.putExtra("TITLE", n.getTitle());
                                finish();
                                startActivity(pasarPantalla);
                            }
                        });
                        builder.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(StartActivity.this, "Has cerrado la ficha", Toast.LENGTH_SHORT).show();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });
    }
}
