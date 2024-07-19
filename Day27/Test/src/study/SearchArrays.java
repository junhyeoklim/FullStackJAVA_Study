package study;

import java.util.Arrays;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }    

    @Override
    public int compareTo(Person p) { 
    	
        return this.name.compareTo(p.name);
    }
    
    @Override
    public String toString() {
        return name + ": " + age;
    }
}


class SearchArrays {
    public static void main(String[] args) {
        Person[] ar = new Person[3];

        ar[0] = new Person("Lee", 29);
        ar[1] = new Person("Goo", 15);
        ar[2] = new Person("Soo", 37);

        Arrays.sort(ar);

        int idx = Arrays.binarySearch(ar, new Person("Goo", 15));
        System.out.println(ar[idx]);
    }
}