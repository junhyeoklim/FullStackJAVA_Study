package test;

import java.util.Arrays;

class Person2 implements Comparable<Person2> {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }    

    public int compareTo(Person2 p) {        

        if(this.name.length() > p.name.length())
            return 1;
        else if(this.name.length() < p.name.length())
            return -1;
        else
            return 0;
    }
    
    @Override
    public String toString() {
        return name + ": " + age;
    }
}

class Test2 {
    public static void main(String[] args) {
        Person2[] ar = new Person2[3];

        ar[0] = new Person2("Le22e", 29);
        ar[1] = new Person2("Go1o", 15);
        ar[2] = new Person2("Soo", 37);

        Arrays.sort(ar);

        for(Person2 p : ar) 
            System.out.println(p);
    }
}
