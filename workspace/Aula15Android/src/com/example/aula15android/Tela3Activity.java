package com.example.aula15android;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);


        Intent intent2 = getIntent();
        final TextView  peg = (TextView) findViewById(R.id.txtRes);

    String dados2 = (String) getIntent().getSerializableExtra("gui");

    peg.setText("dados ds Cliente" + dados2.toString().toCharArray());


    }
}