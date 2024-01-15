package org.example.sem_2.Reflection_API.animal_reflection;

class Dog extends Animal {
    String breed;

    public Dog(String name, int age, String breed) {
        super( name, age );
        this.breed = breed;
    }

    @BarkAnnotation
    public void bark() {
        System.out.println("Говорит : Чар-чар!");
    }

}
