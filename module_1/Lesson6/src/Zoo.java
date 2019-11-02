import animals.Animal;
import animals.Giraffe;
import animals.Turtle;
import animals.dog.*;

public class Zoo {
    public static void main(String[] args) {
        Giraffe giraffe = new Giraffe();
        Turtle turtle = new Turtle();
        Bulldog bulldog = new Bulldog();
        Doge doge = new Doge();
        WildDog wildDog = new WildDog();

        new Window();

        Animal[] animals = new Animal[]{giraffe, turtle, bulldog, doge, wildDog};

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                animal.die();
            }
        }


    }
}
