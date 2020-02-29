package com.example.myapplication.interactor;

import com.example.myapplication.domain.Car;

import java.util.ArrayList;
import java.util.Random;

public class CarsRepository {

    private static String[] carNames = {
            "Abarth",
            "Alfa Romeo",
            "Aston Martin",
            "Audi",
            "Bentley",
            "BMW",
            "Bugatti",
            "Cadillac",
            "Chevrolet",
            "Chrysler",
            "Citroën",
            "Dacia",
            "Daewoo",
    };

    private static String[] carModels = {
            "mark2",
            "rx7",
            "skyline",
            "cx5",
            "turino",
            "fuel",
            "murano",
            "rio",
            "focus",
            "impala",
            "mustang",
            "xl200",
            "cruiser"};

    static ArrayList<Car> generateCarList(int count) {
        ArrayList<Car> carsList = new ArrayList();
        for (int i = 0; i < count; i++) {
            Random rand = new Random();
            carsList.add(new Car(carNames[rand.nextInt(carNames.length)], carModels[rand.nextInt(carModels.length)], rand.nextInt(300) + 90, rand.nextDouble() + 1.3, rand.nextInt(200000) + 500));
        }
        return carsList;
    }

}
