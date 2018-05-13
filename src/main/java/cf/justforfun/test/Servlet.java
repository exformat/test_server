package cf.justforfun.test;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {

    DataBase db = new DataBase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        StringBuilder stringBuilder;

        printWriter.print("Hello!!!");

        for(Message message: db.getMessages()){

            stringBuilder = new StringBuilder();

            stringBuilder.append(message.getDate()).
                    append(" ").
                    append(message.getAuthor()).
                    append(": ").
                    append(message.getMessage());

            printWriter.println(stringBuilder.toString());

            System.out.println(stringBuilder.toString());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
