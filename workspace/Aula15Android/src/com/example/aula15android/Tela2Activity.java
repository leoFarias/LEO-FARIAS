package com.example.aula15android;

import java.util.ArrayList;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Tela2Activity extends Activity {

    TextView  dados;
   ArrayAdapter<String> arrayAdapter;
   ArrayList<String> lista, elementos;
   TextView gui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        String leo = (String) getIntent().getSerializableExtra("nome");
        dados.setText("Cliente" + leo );

        ListView listView = (ListView) findViewById(R.id.lvclientes);
       elementos = inserirClientes();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.activity_list_item, elementos);
     listView.setAdapter(arrayAdapter);

        Button novo = (Button) findViewById(R.id.BtoD);

        gui.setText( dados.getText());

        final Intent intent2 = new Intent( Tela2Activity.this , Tela3Activity.class);

        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getIntent().putExtra("gui",gui.getText().toString());
                startActivity(getIntent());

            }
        });

    }



    public ArrayList<String> inserirClientes() {

        lista = new ArrayList<String>();
        lista.add("leonardo Rodrigues");
        lista.add("Adriana Silva");
        lista.add("guilherme Farias");


        return lista;
        }

        }