import java.sql.*;

public class Test {
    public static void main(String[] args) {
        //TODO : Connexion à la bd et tests divers 

        DatabaseManager dbm = new DatabaseManager();

        try{
            dbm.connect();
        }catch(SQLException e){
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Bonjour!");
        try {
            Statement stmt = dbm.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery ("SELECT * FROM pokemons");
            while(rs.next()){
                System.out.println("Id : "+ rs.getInt("id")+", Nom : " + rs.getString("nom"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}