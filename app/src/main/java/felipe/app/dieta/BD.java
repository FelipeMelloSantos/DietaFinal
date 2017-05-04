package felipe.app.dieta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fylyp on 03/05/2017.
 */

public class BD {

    private SQLiteDatabase bd;

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("usuario", usuario.getUsuario());
        valores.put("sexo", usuario.getSexo());
        valores.put("idade", usuario.getIdade());
        valores.put("peso", usuario.getPeso());
        valores.put("nome", usuario.getNome());
        valores.put("tipodecorpo", usuario.getTipoDeCorpo());
        valores.put("senha", usuario.getSenha());
        valores.put("altura", usuario.getAltura());
        valores.put("jornadadetrabalho", usuario.getJornadaDeTrabalho());
       // valores.put("idUsuario", usuario.getId());

        bd.insert("usuario", null, valores);
    }


    public void atualizar(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());


        bd.update("usuario", valores, "_id = ?", new String[]{""+usuario.getId()});
    }


    public void deletar(Usuario usuario){
        bd.delete("usuario", "_id = "+usuario.getId(), null);
    }


    public List<Usuario> buscar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id", "nome", "email"};

        Cursor cursor = bd.query("usuario", colunas, "usuario = felipe and senha = 123", null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Usuario u = new Usuario();
                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));

                list.add(u);

            }while(cursor.moveToNext());
        }

        return(list);
    }

    public int returnNome(String usuario, String Senha){
        int id=-1;
        String[] colunas = new String[]{"_id", "Nome", "Senha", "Usuario", "Sexo", "Idade", "Peso", "TipodeCorpo", "Altura", "JornadadeTrabalho"};

        Cursor cursor = bd.query("usuario", colunas, "Usuario = '" + usuario + "' and Senha='" + Senha +  "'", null, null, null, "nome ASC");



        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(0);


        }

    return id;
    }


    public int returnAltura(String usuario, String Senha){
        int id=-1;
        String[] colunas = new String[]{"_id", "Nome", "Senha", "Usuario", "Sexo", "Idade", "Peso", "TipodeCorpo", "Altura", "JornadadeTrabalho"};

        Cursor cursor = bd.query("usuario", colunas, "Usuario = '" + usuario + "' and Senha='" + Senha +  "'", null, null, null, "nome ASC");



        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(8);


        }

        return id;
    }

    public int returnPeso(String usuario, String Senha){
        int id=-1;
        String[] colunas = new String[]{"_id", "Nome", "Senha", "Usuario", "Sexo", "Idade", "Peso", "TipodeCorpo", "Altura", "JornadadeTrabalho"};

        Cursor cursor = bd.query("usuario", colunas, "Usuario = '" + usuario + "' and Senha='" + Senha +  "'", null, null, null, "nome ASC");



        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(6);


        }

        return id;
    }

}
