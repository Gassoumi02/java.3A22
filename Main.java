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

    // Comparer deux animaux (unicité par nom + famille)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal other = (Animal) obj;
        return this.name.equals(other.name) && this.family.equals(other.family);
    }
}

// Classe Zoo
class Zoo {
    private Animal[] animals;
    private int animalCount; // compteur
    private String name;
    private String city;
    private final int NBR_CAGES = 25; // constante

    // Constructeur paramétré
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
        this.animalCount = 0;
    }

    // Affichage du Zoo
    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", nbrCages=" + NBR_CAGES + ", animals=" + animalCount + "]";
    }

    // === Instruction 10 : ajouter un animal ===
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("❌ Le zoo est plein, impossible d’ajouter " + animal.name);
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("❌ L’animal " + animal.name + " existe déjà dans le zoo.");
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    // === Instruction 11 : afficher les animaux ===
    public void displayAnimals() {
        System.out.println("Animaux du zoo " + name + ":");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(" - " + animals[i]);
        }
    }

    // === Instruction 11 : rechercher un animal ===
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    // === Instruction 13 : supprimer un animal ===
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) return false;

        // Décaler les animaux pour combler le trou
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null; // dernière case vide
        animalCount--;
        return true;
    }

    // === Instruction 15 : vérifier si le zoo est plein ===
    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    // === Instruction 16 : comparer deux zoos ===
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount >= z2.animalCount) {
            return z1;
        } else {
            return z2;
        }
    }
}

// Classe principale
public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Safari Park", "Tunis");

        // Création d’animaux
        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal tiger = new Animal("Felidae", "Tiger", 4, true);
        Animal elephant = new Animal("Elephantidae", "Elephant", 10, true);

        // === Test addAnimal ===
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(elephant);

        // Ajouter le même animal
        myZoo.addAnimal(lion); // refusé car déjà présent

        // Afficher les animaux
        myZoo.displayAnimals();

        // Recherche
        System.out.println("Indice du lion : " + myZoo.searchAnimal(lion));
        Animal fakeLion = new Animal("Felidae", "Lion", 6, true);
        System.out.println("Indice du faux lion : " + myZoo.searchAnimal(fakeLion));

        // Suppression
        System.out.println("Suppression du tigre : " + myZoo.removeAnimal(tiger));
        myZoo.displayAnimals();

        // Vérifier si le zoo est plein
        System.out.println("Le zoo est-il plein ? " + myZoo.isZooFull());

        // Comparer deux zoos
        Zoo zoo2 = new Zoo("Wild Park", "Sousse");
        zoo2.addAnimal(new Animal("Canidae", "Wolf", 3, true));

        Zoo bigger = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("Le zoo avec le plus d’animaux est : " + bigger);
    }
}
