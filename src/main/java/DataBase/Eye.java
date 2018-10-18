package DataBase;

public class Eye {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
