package felipe.app.dieta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private Usuario usuario = new Usuario();

    EditText nome;
    EditText usuarioED;
    EditText senhaED;
    EditText tipodecorpoED;
    EditText jornadadetrabalhoED;
    EditText idadeED;
    EditText pesoED;
    EditText alturaED;
    RadioButton masculinoRB;
    RadioButton femininoRB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        nome = (EditText) findViewById(R.id.NomeED);
        usuarioED = (EditText) findViewById(R.id.UsuarioED);
        senhaED = (EditText) findViewById(R.id.SenhaED);
        tipodecorpoED = (EditText) findViewById(R.id.TipoDeCorpoED);
        jornadadetrabalhoED = (EditText) findViewById(R.id.JornadaDeTrabalhoED);
        idadeED = (EditText) findViewById(R.id.IdadeED);
        pesoED = (EditText) findViewById(R.id.PesoED);
        alturaED = (EditText) findViewById(R.id.AlturaED);
        femininoRB = (RadioButton) findViewById(R.id.FemininoRB);
        masculinoRB = (RadioButton) findViewById(R.id.MasculinoRB);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void salvarUsuario(View v){

        nome = (EditText) findViewById(R.id.NomeED);
        usuarioED = (EditText) findViewById(R.id.UsuarioED);
        senhaED = (EditText) findViewById(R.id.SenhaED);
        tipodecorpoED = (EditText) findViewById(R.id.TipoDeCorpoED);
        jornadadetrabalhoED = (EditText) findViewById(R.id.JornadaDeTrabalhoED);
        idadeED = (EditText) findViewById(R.id.IdadeED);
        pesoED = (EditText) findViewById(R.id.PesoED);
        alturaED = (EditText) findViewById(R.id.AlturaED);
        femininoRB = (RadioButton) findViewById(R.id.FemininoRB);
        masculinoRB = (RadioButton) findViewById(R.id.MasculinoRB);

        usuario.setNome(nome.getText().toString());
        usuario.setIdade(Integer.parseInt(idadeED.getText().toString()));
        usuario.setPeso(Integer.parseInt(pesoED.getText().toString()));
        usuario.setSenha(senhaED.getText().toString());
        if(femininoRB.isChecked()){
            usuario.setSexo("F");
        }
        if(masculinoRB.isChecked()){
            usuario.setSexo("M");
        }

        usuario.setTipoDeCorpo(tipodecorpoED.getText().toString());
        usuario.setUsuario(usuarioED.getText().toString());
        usuario.setJornadaDeTrabalho(jornadadetrabalhoED.getText().toString());
        usuario.setAltura(Integer.parseInt(alturaED.getText().toString()));

/*
        usuario.setNome("Felipe");
        usuario.setIdade(18);
        usuario.setPeso(110);
        usuario.setSenha("Felipe");
        usuario.setSexo("M");
        usuario.setTipoDeCorpo("TEste2123");
        usuario.setUsuario("Felipe");
*/
        BD bd = new BD(this);
        bd.inserir(usuario);

        Toast.makeText(this, "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
