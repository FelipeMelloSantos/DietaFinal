package felipe.app.dieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Dieta extends AppCompatActivity {

    TextView nome;
    Button teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nome = (TextView) findViewById(R.id.Nome);
        teste = (Button) findViewById(R.id.button5);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);



    }


    public void onClick(View v) {
        nome = (TextView) findViewById(R.id.Nome);
        String teste = "kuyfkhgv";
        BD bd = new BD(this);

        //nome.setText(bd.returnNome());


    }

}
