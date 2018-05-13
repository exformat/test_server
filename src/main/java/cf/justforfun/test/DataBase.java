package cf.justforfun.test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;

public class DataBase {

    private final String driver = "com.mysql.jdbc.driver";
    private final String url = "jdbc:mysql://localhost:3306/test";

    private String name = "root";
    private String pass = "27872787";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DataBase(){

        connect();
    }

    public void connect(){

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, name, pass);
            statement = connection.createStatement();
            //String query = "select count(*) from messages";
            //resultSet = statement.executeQuery(query);

        } catch (SQLException | ClassNotFoundException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public ArrayList<Message> getMessages(){

        ArrayList<Message> messages = new ArrayList<>();

        try {
            // executing SELECT query
            String getMessage = "select id, author, message, date from messages";
            resultSet = statement.executeQuery(getMessage);


            resultSet.last();
            do {
                int id = resultSet.getInt(1);
                String author = resultSet.getString(2);
                String message = resultSet.getString(3);
                Date date = new Date(resultSet.getLong(4));

                messages.add(new Message(id,author,message,date));
                //System.out.println(id + " " + date + " " + author + ": " + message);



            }while (resultSet.previous());

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return messages;
    }

    public void setMessage(String author, String message){

        long date = new Date().getTime();

        String query = "insert into messages (author, message, date) " +
                       "values ('" + author + "', '" + message + "', " + date + ")";
        System.out.println(query);

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){

        try { connection.close();} catch(SQLException e) {e.printStackTrace();}
        try { statement.close();}  catch(SQLException e) {e.printStackTrace();}
        try { resultSet.close(); } catch(SQLException e) {e.printStackTrace();}
    }



}
