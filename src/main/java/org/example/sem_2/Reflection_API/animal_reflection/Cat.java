package org.example.sem_2.Reflection_API.animal_reflection;

class Cat extends Animal {
    String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @MeowAnnotation
    public void meow() {
        System.out.println("Говорит : Перссссии!");
    }
}
