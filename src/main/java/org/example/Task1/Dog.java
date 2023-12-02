package org.example.Task1;

public class Dog extends Animal{

    private double smellDistance;

    public Dog(String name, int age, double smellDistance) {
        super.name = name;
        super.age = age;
        this.smellDistance = smellDistance;
    }

    public void wagTail() {
        System.out.println("Собака веляет хвостом");
    }

    public void makeSound() {
        System.out.println("Гав-гав");
    }

    public double getSmellDistance() {
        return smellDistance;
    }
}
