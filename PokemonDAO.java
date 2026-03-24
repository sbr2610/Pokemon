import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

    private Connection connection;

    public PokemonDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void insert(Pokemon pokemon) throws SQLException {
        String sql = "INSERT INTO pokemon (nom, pv_max, attaque, defense, vitesse, type1, type2) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pokemon.getNom());
            stmt.setInt(2, pokemon.getPvMax());
            stmt.setInt(3, pokemon.getAttaque());
            stmt.setInt(4, pokemon.getDefense());
            stmt.setInt(5, pokemon.getVitesse());
            stmt.setString(6, pokemon.getType1() != null ? pokemon.getType1().name() : null);
            stmt.setString(7, pokemon.getType2() != null ? pokemon.getType2().name() : null);
            stmt.executeUpdate();
        }
    }

    // READ by name
    public Pokemon findByNom(String nom) throws SQLException {
        String sql = "SELECT * FROM pokemon WHERE nom = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        }
        return null;
    }

    // READ all
    public List<Pokemon> findAll() throws SQLException {
        List<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM pokemon";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pokemons.add(mapResultSet(rs));
            }
        }
        return pokemons;
    }

    // UPDATE
    public void update(Pokemon pokemon) throws SQLException {
        String sql = "UPDATE pokemon SET pv_max = ?, attaque = ?, defense = ?, vitesse = ?, " +
                     "type1 = ?, type2 = ? WHERE nom = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pokemon.getPvMax());
            stmt.setInt(2, pokemon.getAttaque());
            stmt.setInt(3, pokemon.getDefense());
            stmt.setInt(4, pokemon.getVitesse());
            stmt.setString(5, pokemon.getType1() != null ? pokemon.getType1().name() : null);
            stmt.setString(6, pokemon.getType2() != null ? pokemon.getType2().name() : null);
            stmt.setString(7, pokemon.getNom());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void delete(String nom) throws SQLException {
        String sql = "DELETE FROM pokemon WHERE nom = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.executeUpdate();
        }
    }

    // Mapping ResultSet → Pokemon
    private Pokemon mapResultSet(ResultSet rs) throws SQLException {
        String nom      = rs.getString("nom");
        int pvMax       = rs.getInt("pv_max");
        int attaque     = rs.getInt("attaque");
        int defense     = rs.getInt("defense");
        int vitesse     = rs.getInt("vitesse");
        Type type1      = rs.getString("type1") != null ? Type.valueOf(rs.getString("type1")) : null;
        Type type2      = rs.getString("type2") != null ? Type.valueOf(rs.getString("type2")) : null;

        return new Pokemon(nom, pvMax, attaque, defense, vitesse, type1, type2);
    }
}