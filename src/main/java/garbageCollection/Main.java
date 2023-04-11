package garbageCollection;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("Dog");
        Animal cat = new Animal("Cat");
        dog.show();
        cat.show();

        {
            System.out.println("In block ~~~");
            Animal dinosaur = new Animal("Dinosaur");
            Animal panda = new Animal("Panda");
            dinosaur.show();
            panda.show();
            dinosaur.showNextAnimalId();
            panda.showNextAnimalId();
            dinosaur = panda = null;
            System.gc();
            System.runFinalization();
            System.out.println("Out block ~~~");
        }
        dog.showNextAnimalId();
    }
}

class Animal {
    private int id;
    private String species;
    private static int nextId = 1;

    public Animal(String species) {
        this.species = species;
        this.id = nextId++;
    }

    public void show() {
        System.out.println("Animal have Id: " + id + ", belong to " + species);
    }

    public void showNextAnimalId() {
        System.out.println("Next animal id: " + nextId);
    }

    protected void finalize() {
        --nextId;
    }
}