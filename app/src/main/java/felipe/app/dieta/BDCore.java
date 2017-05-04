package felipe.app.dieta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fylyp on 03/05/2017.
 */

public class BDCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "Dieta";
    private static final int VERSAO_BD = 11;


    public BDCore(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null, senha text not null, usuario text not null, sexo text not null, idade integer not null, peso integer not null, tipodecorpo text not null, altura integer not null, jornadadetrabalho integer not null);");
        bd.execSQL("create table CafeDaManha(_id integer primary key autoincrement, nome text not null, calorias integer not null)");
        bd.execSQL("create table Almoco(_id integer primary key autoincrement, nome text not null, calorias integer not null)");
        bd.execSQL("create table Jantar(_id integer primary key autoincrement, nome text not null, calorias integer not null)");
        bd.execSQL("create table Intervalo(_id integer primary key autoincrement, nome text not null, calorias integer not null)");
        bd.execSQL("create table Dieta(_id integer primary key autoincrement, idUsuario integer not null, foreign key(idUsuario) references usuario(_id))");
        bd.execSQL("create table Dieta_has_cafedamanha(_idDieta integer, idCafeDaManha integer, foreign key(_idDieta) references Dieta(_id), foreign key(idCafeDaManha) references CafeDaManha(_id))");
        bd.execSQL("create table Dieta_has_Almoco(_idDieta integer, idAlmoco integer, foreign key(_idDieta) references Dieta(_id), foreign key(idAlmoco) references Almoco(_id))");
        bd.execSQL("create table Dieta_has_Jantar(_idDieta integer, idJantar integer, foreign key(_idDieta) references Dieta(_id), foreign key(idJantar) references Jantar(_id))");
        bd.execSQL("create table Dieta_has_Intervalo(_idDieta integer, idIntervalo integer, foreign key(_idDieta) references Dieta(_id), foreign key(idIntervalo) references Intervalo(_id))");

        ContentValues valores = new ContentValues();

        valores.put("nome", "1 banana média");
        valores.put("calorias", 105);



        bd.insert("usuario", null, valores);


        //"create table usuario(_idUsuario integer primary key autoincrement, usuario text, senha text, nome text, idade integer, peso integer, tipodecorpo text, jornadadetrabalho integer, sexo text, altura integer"

    }

    //"create table usuario(_id integer primary key autoincrement, nome text not null, email text not null, senha text not null);" +

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table usuario;");
        onCreate(bd);
    }

}
