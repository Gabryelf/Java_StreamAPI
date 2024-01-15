package org.example.sem_2.Reflection_API.animal_reflection;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog("Чармандер", 5, "адская гончая");
        animals[1] = new Cat("Персиан", 4, "кремовый");

        for (Animal animal : animals) {
            System.out.println("Имя: " + animal.name);
            System.out.println("Возраст: " + animal.age);

            Class<? extends Animal> animalClass = animal.getClass();
            Method[] methods = animalClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(BarkAnnotation.class)) {
                    try {
                        method.invoke(animal);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                else if (method.isAnnotationPresent(MeowAnnotation.class)) {
                    try {
                        method.invoke(animal);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }

            System.out.println();
        }
    }
}