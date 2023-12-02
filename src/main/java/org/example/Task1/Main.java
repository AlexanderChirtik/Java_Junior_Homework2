package org.example.Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Собака1", 3, 120));
        animals.add(new Cat("Кот1", 11, 11));
        animals.add(new Cat("Кот2", 0, 8));
        animals.add(new Dog("Собака2", 15, 345.5));
        animals.add(new Cat("Кот3", 9, 321));

        /**
         * Вывод на экран информации о каждом объекте
         */
        getInfoAboutClass(animals);


        /**
         * Вызов метода "makeSound()" у каждого объекта, если такой метод присутствует
         */
        try {
            takeMethodSound(animals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static <T> void getInfoAboutClass(List<T> list) {
        for (T item:list) {
            getNameMyClass(item);
            getFieldsMyClass(item);
            getMySuperClass(item);
            getMethodsMyClass(item);
            getConstructorsMyClass(item);
            System.out.println();
        }
    }

    private static <T> void getNameMyClass (T animal) {
        Class<?> objClass = animal.getClass();
        System.out.println("Имя класса: " + objClass.getName());
    }

    private static <T> void getFieldsMyClass (T animal) {
        Class<?> objClass = animal.getClass();
        System.out.println("Поля класса: " + Arrays.toString(objClass.getDeclaredFields()));
    }

    private static <T> void getMySuperClass (T animal) {
        Class<?> objClass = animal.getClass();
        System.out.println("Имя родительского класса: " + objClass.getSuperclass());
    }

    private static <T> void getMethodsMyClass (T animal) {
        Class<?> objClass = animal.getClass();
        System.out.println("Методы класса: " + Arrays.toString(objClass.getDeclaredMethods()));
    }

    private static <T> void getConstructorsMyClass (T animal) {
        Class<?> objClass = animal.getClass();
        System.out.println("Конструктор класса: " + Arrays.toString(objClass.getConstructors()));
    }

    private static <T> void isMakeSound(T animal) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Class<?> objClass = animal.getClass();
        Method[] methods = objClass.getDeclaredMethods();
        for (Method item:methods) {
            if (item.getName().equals("makeSound")) {
                Method makeSound = objClass.getDeclaredMethod("makeSound");
                makeSound.invoke(animal);
            }
        }
    }

    private static void takeMethodSound(List<Animal> list) throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        for (Animal item:list) {
            isMakeSound(item);
        }
    }
}
