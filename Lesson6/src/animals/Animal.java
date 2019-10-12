package animals;

public class Animal {
    public double neckLeght;
    public double weight;
    public double age;
    public String color;
    public char gender;
    public String animalName;
    public String breed;

    public void move() {
        System.out.println(animalName + " бегает");
    }

    public void eat() {
        System.out.println(animalName + " ест");
    }

    public void sleep() {
        System.out.println(animalName + " спит");
    }

    public void die() {
        System.out.println(animalName + " умирает");
    }

    public void sex(Giraffe giraffe) {
        System.out.println(animalName + " размножается с " + giraffe.toString());
    }
}
