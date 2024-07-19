package test;

import java.util.Arrays;

//class Person implements Comparable<Person>{
//	private String name;
//	private int age;
//
//	public Person(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return name + ": " + age;
//	}
//
//	@Override
//	public int compareTo(Person o) {
//		return this.age - o.age;
//	}
//
//}

class INum {
	private int num;

	public INum(int num) {
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		INum comp = (INum) obj;
		return this.num == comp.num;
	}
}

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }    
    
    @Override
    public String toString() {
        return name + ": " + age;
    }

	@Override
	public int compareTo(Person o) {
		return this.age-o.age;
	}
}

class ArrayObjSort {
	public static void main(String[] args) {

		//    	1번 문제
		//        Person[] ar = new Person[3];
		//
		//        ar[0] = new Person("Lee", 29);
		//        ar[1] = new Person("Goo", 15);
		//        ar[2] = new Person("Soo", 37);
		//
		//        Arrays.sort(ar);
		//        
		//        for(Person i : ar)
		//        	System.out.println(i);

		//    	2~4번 문제
		//		double[] arOrg= {1.1,2.2,3.3,4.4,5.5};
		//    	double[] copy = Arrays.copyOf(arOrg, arOrg.length);
		//    	double[] copy = Arrays.copyOf(arOrg, 3);
		//		double[] copy = Arrays.copyOfRange(arOrg, Arrays.binarySearch(arOrg, 2.2),Arrays.binarySearch(arOrg, 5.5));



		//    	for(double d : copy)
		//    		System.out.println(d);

		//    	for(double d : copy)
		//    		System.out.println(d);
		//		for(double d : copy)
		//			System.out.println(d);

		//		5번 문제

		//		int[] ar1 = {1,2,3,4,5};
		//		int[] ar2 = Arrays.copyOf(ar1, ar1.length);
		//
		//		System.out.println(Arrays.equals(ar1, ar2));

		//		6번 문제

		//		  INum[] ar1 = new INum[3];
		//	        INum[] ar2 = new INum[3];
		//	        
		//	        ar1[0] = new INum(1);
		//	        ar2[0] = new INum(1);
		//
		//	        ar1[1] = new INum(2);
		//	        ar2[1] = new INum(2);
		//
		//	        ar1[2] = new INum(3);
		//	        ar2[2] = new INum(3);
		//
		//	        System.out.println(Arrays.equals(ar1, ar2));
		
//		7번 문제
		
//		int[] ar1 = {1,5,3,2,4};
//		double[] ar2 = {3.3,2.2,5.5,1.1,4.4};
//		
//		Arrays.sort(ar1);
//		Arrays.sort(ar2);
//		
//		for(int i : ar1)
//			System.out.print(i+"\t");
//		System.out.println();
//		for(double d : ar2)
//			System.out.print(d+"\t");
		
//		8번 문제
//		int[] ar = {33,55,11,44,22};
//		
//		Arrays.sort(ar);
//		
//		System.out.println(Arrays.binarySearch(ar, 33));
		
//		9번 문제
	     Person[] ar = new Person[3];	     
	        ar[0] = new Person("Lee", 29);
	        ar[1] = new Person("Goo", 15);
	        ar[2] = new Person("Soo", 37);

	        Arrays.sort(ar);
	        
	        int idx = Arrays.binarySearch(ar, new Person("", 37));
	        
	        System.out.println(ar[idx]);
	}
}
