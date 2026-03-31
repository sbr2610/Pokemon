import java.util.ArrayList;

public class Type {

    private String nom; // nom du type, ex : Feu, Eau, Plante
    private ArrayList<Type> bonus; // types contre lesquels ce type est efficace
    private ArrayList<Type> malus; // types contre lesquels ce type est faible

    // Constructeur
    public Type(String nom) {
        this.nom = nom;
        this.bonus = new ArrayList<>();
        this.malus = new ArrayList<>();
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Ajouter un type contre lequel ce type a un bonus
    public void addBonus(Type type) {
        if (!bonus.contains(type)) {
            bonus.add(type);
        }
    }

    // Ajouter un type contre lequel ce type a un malus
    public void addMalus(Type type) {
        if (!malus.contains(type)) {
            malus.add(type);
        }
    }

    // Vérifie si ce type a un bonus contre un autre type
    public boolean haveBonusVs(Type typeAdverse) {
        return bonus.contains(typeAdverse);
    }

    // Vérifie si ce type a un malus contre un autre type
    public boolean havePenaltyVs(Type typeAdverse) {
        return malus.contains(typeAdverse);
    }

    // Vérifie si ce type est efficace contre un autre type
    public boolean isEfficient(Type typeAdverse) {
        return haveBonusVs(typeAdverse);
    }

    @Override
    public String toString() {
        return nom;

    public double recupMulti(int fkAtt,int fkDef){
        String sql = "SELECT multi from efficacite WHERE fkAtt = ? and fkDef= ? LIMIT 1;";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,fkAtt);
        pstmt.setInt(2,fkDef);
        ResultSet multi = pstmt.executeQuery(sql);
        return multi ;
    }

    }
    
}