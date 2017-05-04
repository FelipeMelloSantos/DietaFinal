package felipe.app.dieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText usuario;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void startDietaActivity(View view) {

        Intent DietaActivity = new Intent(this, Dieta.class);
        startActivity(DietaActivity);
    }


    public void doLogin(View v){
        usuario = (EditText) findViewById(R.id.UsuarioED);
        senha = (EditText) findViewById(R.id.SenhaED);
        int teste=-1;
        int peso=0, altura=0;
        float aux, imc;

        Integer.toString(altura);

        BD bd = new BD(this);

        teste = bd.returnNome(usuario.getText().toString(), senha.getText().toString());
        peso = bd.returnPeso(usuario.getText().toString(), senha.getText().toString());
        altura = bd.returnAltura(usuario.getText().toString(), senha.getText().toString());

        aux = Float.parseFloat(Integer.toString(altura));

        aux = aux/100;

        imc=peso/(aux*aux);

        if (teste > 0){

            if(imc>30){
                Intent Dieta1200Activity = new Intent(this, Dieta1200.class);
                startActivity(Dieta1200Activity);
            }

            if(imc>=25 && imc<=30){
                Intent Dieta1700Activity = new Intent(this, Dieta1700.class);
                startActivity(Dieta1700Activity);
            }

            if(imc>=18 && imc<25){
                Intent Dieta2200Activity = new Intent(this, Dieta2200.class);
                startActivity(Dieta2200Activity);
            }

            if(imc<18){
                Intent Dieta3000Activity = new Intent(this, Dieta3000.class);
                startActivity(Dieta3000Activity);
            }


        }









    }



}
