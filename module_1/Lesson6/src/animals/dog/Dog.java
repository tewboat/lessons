package animals.dog;

import animals.Animal;

public class Dog extends Animal {
    Dog() {
        animalName = "Пес";
    }

    public void howl() {
        System.out.println(animalName + " ГАВ ГАВ");
    }
}
