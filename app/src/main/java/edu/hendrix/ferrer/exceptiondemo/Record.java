package edu.hendrix.ferrer.exceptiondemo;

/**
 * Created by gabriel on 2/8/19.
 */

public class Record {
    private String name;
    private int age;

    public Record(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Record parse(String str) {
        String[] parts = str.split(":");
        return new Record(parts[0], Integer.parseInt(parts[1]));
    }

    public String getName() {return name;}
    public int getAge() {return age;}

    @Override
    public String toString() {
        return name + ":" + age;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Record) {
            Record that = (Record)other;
            return this.name.equals(that.name) && this.age == that.age;
        } else {
            return false;
        }
    }
}
