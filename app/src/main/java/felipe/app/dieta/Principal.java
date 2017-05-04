package felipe.app.dieta;

/*Componhentes:
   Edmilson Matos
   Danilo Augusto
   Felipe Mello
   Fernando Fabio
   Wendel Correia */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void startLoginActivity(View view) {

        Intent loginActivity = new Intent(this, Login.class);
        startActivity(loginActivity);
    }

    public void startCadastroActivity(View view) {

        Intent cadastroActivity = new Intent(this, Cadastro.class);
        startActivity(cadastroActivity);
    }

    public void startDietaActivity(View view) {

        Intent DietaActivity = new Intent(this, Dieta.class);
        startActivity(DietaActivity);
    }

    private static final String INSERIR_FILME =
            "INSERT INTO biblioteca.filme(Titulo, Elenco, Duracao, NomeProdutora) VALUES(?,?,?,?)";
    private Connection conexaoBanco;

    public void salvar(View v) {
        conexaoBanco = ConnectionFactory.getConnection();
        try{

            PreparedStatement sentencaSQL =
                    conexaoBanco.prepareStatement("INSERT INTO biblioteca.filme(Titulo, Elenco, Duracao, NomeProdutora) VALUES(Teste, Teste, 10, Teste)");
           /* sentencaSQL.setString(1, "Teste");
            sentencaSQL.setString(2, "Teste");
            sentencaSQL.setFloat(3, 10);
            sentencaSQL.setString(4,"TESTE");*/
            sentencaSQL.executeUpdate();
            sentencaSQL.close();
            conexaoBanco.close();
         //   return retorno;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar livro em banco de dados.");
           // return 0;
        }
    }




}
