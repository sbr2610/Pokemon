import java.io.FileWriter;
import java.io.IOException;

public Class Combat {
    private Joueur joueur1;
    private Joueur joueur2;

    public Combat(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public void startCombat() {
        System.out.println(joueur1.nom + " VS " + joueur2.nom);
    }

    public Joueur victoire() {
        if (joueur1.pokemonKO == 6) {
            System.out.println(joueur1.nom + " a gagné la partie");
            return joueur1;
        } else {
            System.out.println(joueur2.nom + " a gagné la partie");
            return joueur2;
        }
    }

    public void sauvegarde() {
        if (joueur1.pokemonKO == 6 || joueur2.pokemonKO == 6) {
            try {
                FileWriter fichier = new FileWriter("combat.txt");
                fichier.write(joueur1.nom);
                fichier.write(joueur2.nom);
                fichier.close();
                System.out.println("Combat sauvegardé");
            } catch (IOException e) {
                System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
            }
        }
 
   }

   private joueurVictoire (){
    if joueur1.getNbpokemon()==0{
        return joueur2;
    }
        return joueur2
   }

   public Boolean finPartie(){
    if joueur1.getNbpokemon==0 ||joueur2.getNbpokemon()==0{
        System.out.println("le gagnant est" + this.victoire().getNom())
        return True;
    }
   }
   return False
}