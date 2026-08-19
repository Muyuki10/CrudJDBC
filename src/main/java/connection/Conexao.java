package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static  final String URL = "jdbc:mysql://127.0.0.1:3306/Loja";
    private static final String USER = "root";
    private static final String SENHA = "" ;//usar senha propria do seu banco de dados;

    public static Connection conectar () {
        try{
            return  DriverManager.getConnection(URL,USER,SENHA);
        }catch (SQLException e){
            System.out.println("Erro ao conectar com o banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}
