import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class DBManagement {
    private Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement1;
    private PreparedStatement preparedStatement2;
    private PreparedStatement preparedStatement3;
    private PreparedStatement preparedStatement4;

    public DBManagement(Connection con) throws SQLException {
        this.con = con;
        this.statement = con.createStatement();
    }

    public void createTables() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS Benutzer(userID int IDENTITY CONSTRAINT user_pk PRIMARY KEY, name varchar(200), pwd varchar(200))");
        statement.execute("CREATE TABLE IF NOT EXISTS Blog(blogID int IDENTITY CONSTRAINT blog_pk PRIMARY KEY, name varchar(200), erstelldatum date, userID int, FOREIGN KEY (userID) REFERENCES Benutzer(userID))");
        statement.execute("CREATE TABLE IF NOT EXISTS Bild(bildID int IDENTITY CONSTRAINT bild_pk PRIMARY KEY, bild BLOB)");
        statement.execute("CREATE TABLE IF NOT EXISTS Blogeintrag(blogeintragID int IDENTITY CONSTRAINT blogeintrag_pk PRIMARY KEY, datum date, text varchar(200), blogID int, FOREIGN KEY (blogID) REFERENCES Blog(blogID), bildID int, FOREIGN KEY (bildID) REFERENCES Bild(bildID))");
    }

    public void insertIntoBenutzerBlog(String benutzername, String pwd, String blogname, Date erstelldatum, int userID) throws SQLException {
        statement.execute("insert into Benutzer (name, pwd) values ('"+benutzername+"', '"+pwd+"')");
        statement.execute("insert into Blog (name, erstelldatum, userID) values ('"+blogname+"', '"+erstelldatum+"', '"+userID+"')");
    }

    public void preparedInserts(){
        try {
            preparedStatement2 = con.prepareStatement("insert into Bild(bild) values(?)");
            preparedStatement3 = con.prepareStatement("insert into Blogeintrag(datum, text, blogID, bildID) values(?, ?, ? ,?)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void fillPreparedInserts(InputStream inputStream, Date datum, String text, int blogID, int bildID) throws SQLException, IOException {
        try {
            con.setAutoCommit(false);
            preparedStatement2.setBlob(1, inputStream);
            preparedStatement2.execute();
            con.commit();
            preparedStatement3.setDate(1, datum);
            preparedStatement3.setString(2, text);
            preparedStatement3.setInt(3, blogID);
            preparedStatement3.setInt(4, bildID);
            preparedStatement3.execute();
            con.commit();
            inputStream.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            inputStream.close();
            con.rollback();
            throw throwables;
        } catch (IOException e) {
            e.printStackTrace();
            inputStream.close();
            con.rollback();
        }
    }

    public void preparedSelect1(){
        try {
            preparedStatement1 = con.prepareStatement("select * from Blogeintrag, Blog where Blogeintrag.blogID = Blog.blogID and Blog.userID = ?;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void preparedSelect2(){
        try {
            preparedStatement4 = con.prepareStatement("select * from Benutzer where name like ?;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void fillPreparedSelects(int userID, String name){
        try {
            con.setAutoCommit(false);

            preparedStatement1.setInt(1, userID);
            ResultSet resultSet = preparedStatement1.executeQuery();
            con.commit();

            while (resultSet.next()) {
                System.out.println("BLOGPOST");
                System.out.println("BlogeintragID: " +resultSet.getInt("blogeintragID")+ "\n" +
                        "Datum: " +resultSet.getDate("datum")+ "\n" +
                        "Text: " +resultSet.getString("text")+ "\n" +
                        "BlogID: " +resultSet.getInt("blogID")+ "\n" +
                        "BildID: " + resultSet.getString("bildID") + "\n");
            }

            preparedStatement4.setString(1, name);
            ResultSet resultSet1 = preparedStatement4.executeQuery();
            con.commit();

            while (resultSet1.next()) {
                System.out.println("BENUTZER");
                System.out.println("UserID: " +resultSet1.getInt("userID")+ "\n" +
                        "Name: " +resultSet1.getString("name")+ "\n" +
                        "Pwd: " + resultSet1.getString("pwd"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closePreparedStatements(){
        try {
            preparedStatement1.close();
            preparedStatement2.close();
            preparedStatement3.close();
            preparedStatement4.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}