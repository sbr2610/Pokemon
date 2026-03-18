public class Main {
    public static void main(String[] args) {
        TypeDAO dao = new TypeDAO();

        for (Type t : dao.findAll()) {
            System.out.println(t.getId() + " - " + t.getLibelle());
        }
    }
}
```

### Résultat attendu
```
1 - Combat
2 - Dragon
3 - Eau
4 - Electrique
5 - Feu
6 - Glace
7 - Insecte
8 - Normal
9 - Plante
10 - Poison
11 - Psy
12 - Roche
13 - Sol
14 - Spectre
15 - Vol