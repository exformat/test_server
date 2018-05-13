package cf.justforfun.test;

public class Main {

    public static void main(String[] args) {

        DataBase db = new DataBase();

        StringBuilder stringBuilder;

        for(Message message: db.getMessages()){

            stringBuilder = new StringBuilder();

            stringBuilder.append(message.getDate()).
                    append(" ").
                    append(message.getAuthor()).
                    append(": ").
                    append(message.getMessage());

            System.out.println(stringBuilder.toString());
        }

    }
}
