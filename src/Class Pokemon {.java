Class Pokemon {
    private String nom;
    private int pvMax;
    private int attaque;
    private int defense;
    private int vitesse;
    private Type type1;
    private Type type2;
    private static final int NB_ATTAQUES = 4;
    private Attaque[NB_ATTAQUES] attaque;

    public Pokemon (String : nom) { //constructeur
       this.nom = nom
    }

    public Attaque getAttaqueByIndex(int index){
        return attaques[index];
    }

    public void attaquer(Attaque attaque, Pokemon adversaire){
        int degats = attaque.puissance + this.attaque - adversaire.defense;
        adversaire.pv = adversaire.pv - degats;
    }
}