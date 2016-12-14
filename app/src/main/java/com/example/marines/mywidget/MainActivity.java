package com.example.marines.mywidget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Notas> listaNotas;
    private AdaptadorNotas adaptador;
    private ListView listView;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamamos nuestros elementos del XML
        listView = (ListView) findViewById(R.id.listView);
        et1 = (EditText) findViewById(R.id.editText);

        //Obtenemos las notas de la clase Notas
        listaNotas = new Notas().notas();
        //Verificamos que la lista este llena
        if (listaNotas != null) {
            //Agregamos la lista a nuestro adaptador
            adaptador = new AdaptadorNotas(this, listaNotas);
            //Agregamos el adaptador a nuestro listview
            listView.setAdapter(adaptador);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int posicion, long l) {
               //Obtenemos la nota a la que le damos clic
                final Notas nota = (Notas) adapterView.getItemAtPosition(posicion);

               //Cramos el alertDialog
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                //Le agregamos un titulo al alerDialog
                dialogo1.setTitle("Importante");
                //para poder salir dando clic fuera del dialog
                dialogo1.setCancelable(true);
                //Afregamos un mensaje
                dialogo1.setMessage("¿Tarea finalizada?");
                //Opcion eliminar
                dialogo1.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //Removemos del listview el item al que le dimos clic
                        listaNotas.remove(posicion);
                        //Actualizamos el listview
                        adaptador.notifyDataSetChanged();
                    }
                });
                //Agregar titulo de marcar o desmarcar
                String titulo;
                if (nota.getRealizado()) {
                    titulo = "Desmarcar";
                } else {
                    titulo = "Marcar";
                }
                //Opcion desmarcar o marcar
                dialogo1.setNegativeButton(titulo, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                       //Verificamos si esta marcado desmarcamos y si esta desmarcado marcamos
                        if (nota.getRealizado()) {
                            nota.setRealizado(false);
                        } else {
                            nota.setRealizado(true);
                        }
                        //Actualizmaos el listview
                        adaptador.notifyDataSetChanged();
                    }
                });
                //Mostramos el mensaje
                dialogo1.show();

            }
        });

    }

    //Accion clic en agregar
    public void agregar(View v) {
        //Agregamos la nueva nota
        Notas nota=new Notas(et1.getText().toString(),false);
        //Verificamos que se allà escrito algo en el editext
        if(!et1.getText().toString().trim().equalsIgnoreCase("")) {
            //Agregamos la nueva nota
            adaptador.add(nota);
            //Actualizamos el listview
            adaptador.notifyDataSetChanged();
            //limpiamos el editetx
            et1.setText("");
        }
    }
}
