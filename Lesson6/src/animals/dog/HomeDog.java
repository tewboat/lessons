package animals.dog;

public class HomeDog extends Dog {

    HomeDog(){
        animalName = "Домашняя собака";
    }

    void runWithBall(){
        System.out.println(animalName + " бегает за мячиком");
    }
}
