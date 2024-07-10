package com.javalec.ex;

public class BMICalculator {

	private double lowWeight ;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public void bmicalculation(double weight, double height) {
		
		double h = height * 0.01 ;
		double result = weight / (h*h);
		
		System.out.println("BMI 지수 : " + (int)result);
		
		if(result > obesity) {
			System.out.println("비만 입니다.");
		} else if(result > overWeight) {
			System.out.println("과체중 입니다.");
		}else if(result > normal) {
			System.out.println("정상 입니다.");
		}else {
			System.out.println("저체중 입니다.");
		}
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	
	
}
