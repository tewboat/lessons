public class Dog {
    String breed;
    char gender;
    double weight;
    int age;

    void eat() {
        System.out.println("собака ест!!");
    }

    void howl(String phrase) {
        System.out.println("Говорит по-собачьи " + phrase);
    }

    String getDogInfo() {
        return "you're see dog: [breed = " + breed + "\n" +
                "gender=" + gender + "\n" +
                "weight=" + weight + "\n" +
                "age=" + age + "]";
    }

}

