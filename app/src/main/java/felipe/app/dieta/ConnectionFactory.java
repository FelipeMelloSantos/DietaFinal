package felipe.app.dieta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by fylyp on 03/05/2017.
 */

public class ConnectionFactory {


    private static final String login = "root";
    private static final String senha = "";

    public static Connection getConnection() {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost", login, senha);
        }
        catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;

    }

}
