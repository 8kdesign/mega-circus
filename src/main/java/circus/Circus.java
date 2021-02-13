package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        //makeAnimalsTalk();
        //System.out.println("Total value of animals " + calculateAssetValue(animals));
        //System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        System.out.println("Number of animals: " + animals.length);
        //animals[2] = new Tiger("Tigger");
        //makeAnimalsTalk();
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        System.out.println("Number of animals: " + animalArrayList.size());
        animalArrayList.add(new Tiger("Tigger"));
        System.out.println("Number of animals: " + animalArrayList.size());

        Duck psyduck = new Duck("Psyduck");
        animalArrayList.add(psyduck);
        Elephant dumbo = new Elephant("Dumbo");
        animalArrayList.add(dumbo);

        printAnimals(animalArrayList);
        System.out.println("Dumbo's position is " + animalArrayList.indexOf(dumbo));

        animalArrayList.sort(Comparator.comparing(animal -> animal.name.toLowerCase()));
        printAnimals(animalArrayList);
        System.out.println("Dumbo's position is " + animalArrayList.indexOf(dumbo));

        System.out.println(Arrays.toString(animals));
    }

    private static void printAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal animal : animalArrayList) {
            System.out.println(animal);
        }
    }
}
