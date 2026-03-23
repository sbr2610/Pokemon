public class Evolution {
    private Pokemon pokemonBase;
    private Pokemon pokemonEvolue;
    private int niveauRequis;

    public Evolution(Pokemon pokemonBase, Pokemon pokemonEvolue, int niveauRequis) {
        this.pokemonBase = pokemonBase;
        this.pokemonEvolue = pokemonEvolue;
        this.niveauRequis = niveauRequis;
    }

    public Pokemon getPokemonBase() { return pokemonBase; }
    public Pokemon getPokemonEvolue() { return pokemonEvolue; }
    public int getNiveauRequis() { return niveauRequis; }

    public void setPokemonBase(Pokemon pokemonBase) { this.pokemonBase = pokemonBase; }
    public void setPokemonEvolue(Pokemon pokemonEvolue) { this.pokemonEvolue = pokemonEvolue; }
    public void setNiveauRequis(int niveauRequis) { this.niveauRequis = niveauRequis; }
}


//ajouter ça dans le constructeur 
private boolean estEvolue;
//maintenant ça ze3ma dans getter setter
public boolean isEvolue() { return estEvolue; }
public void setEvolue(boolean estEvolue) { this.estEvolue = estEvolue; }
//nom
pokemon.setEvolue(true);