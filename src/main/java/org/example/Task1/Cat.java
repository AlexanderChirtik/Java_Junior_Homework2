package org.example.Task1;

public class Cat extends Animal{
    private double viewLengthInDark;

    public Cat(String name, int age, double viewLengthInDark) {
        super.name = name;
        super.age = age;
        this.viewLengthInDark = viewLengthInDark;
    }

    public void purr() {
        System.out.println("Кошка мурлыкает");
    }

    public void makeSound() {
        System.out.println("Мяу-мяу");
    }

    public double getViewLengthInDark() {
        return viewLengthInDark;
    }
}
