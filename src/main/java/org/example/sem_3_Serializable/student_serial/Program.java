package org.example.sem_3_Serializable.student_serial;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;


public class Program {
    public static void main(String[] args) {

        Student student = new Student("Владимир", 32, 4.0);


        serializeBinary(student, "student.bin");


        serializeJSON(student, "student.json");


        serializeXML(student, "student.xml");


        Student deserializedStudentBinary = deserializeBinary("student.bin");
        System.out.println("Объект десериализован из бинарного файла: " + deserializedStudentBinary);


        Student deserializedStudentJSON = deserializeJSON("student.json");
        System.out.println("Объект десериализован из json файла: " + deserializedStudentJSON);


        Student deserializedStudentXML = deserializeXML("student.xml");
        System.out.println("Объект десериализован из xml файла: " + deserializedStudentXML);
    }

    private static void serializeBinary(Student student, String filename) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename));
            stream.writeObject(student);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student deserializeBinary(String filename) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename));
            Student student = (Student) stream.readObject();
            stream.close();
            return student;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void serializeJSON(Student student, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(student.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student deserializeJSON(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String json = reader.readLine();
            reader.close();

            String name = json.substring(json.indexOf(" имя ") + 6, json.indexOf('\'', json.indexOf(" имя ") + 6));
            int age = Integer.parseInt(json.substring(json.indexOf(" возраст ") + 4, json.indexOf(',', json.indexOf(" возраст ") + 4)));
            double GPA = Double.parseDouble(json.substring(json.indexOf(" средний балл ") + 4, json.indexOf(',', json.indexOf(" средний балл ") + 4)));

            return new Student(name, age, GPA);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void serializeXML(Student student, String filename) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
            encoder.writeObject(student);
            encoder.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student deserializeXML(String filename) {
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
            Student student = (Student) decoder.readObject();
            decoder.close();
            return student;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
