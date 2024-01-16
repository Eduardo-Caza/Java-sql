import java.sql.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String dbURL = "jdbc:mysql://localhost:3306/estudiantes";
        String dbUsername = "root";
        String dbPassword = "";
        Scanner scanner = new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            String sql = "INSERT INTO calificaciones VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, 2);
            statement.setString(2, "Carlos");
            statement.setInt(3, 1788569678);
            statement.setFloat(4, 10);
            statement.setFloat(5, 9);

            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Se inserto un nuevo registro");
            }

        } catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            if(conn != null){
                System.out.println("Conectado a la base de datos estudiantes exitosamente");
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM calificaciones");

            int id;
            String nombre;

            while(rs.next()){
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                System.out.println(id + " " + nombre);
            }

        }catch(Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }

        // Actualizar un registro
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            String sql = "UPDATE calificaciones SET nombre = ?, nota1 = ?, nota2 = ? WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, "Carlos");
            statement.setFloat(2, 8);
            statement.setFloat(3, 7);
            statement.setInt(4, 2);

            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Se actualizo un registro");
            }

        } catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }

        // Eliminar un registro
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            String sql = "DELETE FROM calificaciones WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, 2);

            int rowsDeleted = statement.executeUpdate();

            if(rowsDeleted > 0){
                System.out.println("Se elimino un registro");
            }

        } catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
