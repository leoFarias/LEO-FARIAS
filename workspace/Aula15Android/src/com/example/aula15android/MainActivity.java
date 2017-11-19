package com.example.aula15android;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);

	        final EditText cliente  = (EditText) findViewById(R.id.txtCliente);
	        Button buscar = (Button) findViewById(R.id.bto1);


	        final Intent intent = new Intent( MainActivity.this , Tela2Activity.class);

	        buscar.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {

	                intent.putExtra("nome", cliente.getText().toString());
	                startActivity(intent);

	            }
	        });
	    }

	}
