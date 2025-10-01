// Classe Animal
class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    // Constructeur paramétré
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        return "Animal [family=" + family + ", name=" + name + ", age=" + age + ", isMammal=" + isMammal + "]";
    }
}

// Classe Zoo
class Zoo {
    Animal[] animals;
    String name;
    String city;
    int nbrCages;

    // Constructeur paramétré
    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25]; // max 25 animaux
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", nbrCages=" + nbrCages + "]";
    }
}

// Classe principale
public class Main {
    public static void main(String[] args) {
        // Création d’un animal
        Animal lion = new Animal("Felidae", "Lion", 5, true);

        // Création d’un zoo
        Zoo myZoo = new Zoo("Safari Park", "Tunis", 25);

        // Ajout du lion au zoo
        myZoo.animals[0] = lion;

        // Affichage d’un zoo
        System.out.println("=== Affichage Zoo ===");
        System.out.println(myZoo);
        System.out.println(myZoo.toString());

        // Affichage d’un animal
        System.out.println("\n=== Affichage Animal ===");
        System.out.println(lion);
        System.out.println(lion.toString());
    }
}
