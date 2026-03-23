public class Attaque {

    private int id;
    private String nom;
    private Type type;
    private int puissance;

    public Attaque(int id, String nom, Type type, int puissance) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.puissance = puissance;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Type getType() {
        return type;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}