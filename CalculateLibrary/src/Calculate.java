
//Author Jeffrey Liu
//9-6-2018
//Version 1.0 (I'm going to call this version 1.0 forever.)

public class Calculate {
	
	//part 0 - first method and connecting
			
	public static double square(double squareInput) {
		
		//Ya mind if I change this to double? I want to use this for sqrt.

		return squareInput*squareInput;
	}
	
	//part one - moar methods
	
	public static int cube(int cubeInput) {
		return cubeInput*cubeInput*cubeInput;
	}
	
	public static double average(double avgOne, double avgTwo) {
		return (avgOne+avgTwo)/2;
	}
	
	public static double average (double avg1, double avg2, double avg3) {
		return (avg1+avg2+avg3)/3;
	}
	
	public static double toDegrees (double radian) {
		return radian*180/3.14159;
	}
	
	public static double toRadians (double degrees) {
		return degrees*3.14159/180;
	}
	
	public static double discriminant (double a, double b, double c) {
		return b*b-4*a*c;
	}
	
	public static String toImproperFrac(int number, int numerator, int denominator) {
		return (number*denominator)+numerator + " " + denominator;
	}
	
	public static String toMixedNum(int numerator, int denominator) {
		return (numerator/denominator)+"_"+(numerator%denominator)+"/"+denominator;
	}
	
	public static String foil(int a, int b, int c, int d, String x) {
		return (a*c)+x+"^2 + "+(a*d+b*c)+x+" + "+(b*d);
	}
	
	//part 2 - methods with conditionals
	
	public static boolean isDivisibleBy(int numerator, int denominator) {
		if(numerator%denominator==0) {
			return true;
		}else{
			return false;
		}
	}
	
	public static double absValue(double absolute) {
		if (absolute<0) {
			return absolute*-1;
		}else{
			return absolute;
		}
	}
	
	public static double max(double x, double y) {
		if (x>y) {
			return x;
		}else{
			return y;
		}
	}
	
	public static double max(double x, double y, double z) {
		double max;
		if (x>y) {
			max=x;
		}else{
			max=y;
		}
		if (max>z) {
			return max;
		}else{
			return z;
		}
	}
		
	public static int min(int x, int y) {
		
		//WHY IS THIS ONE AN INT BUT THE ABOVE ARE DOUBLES?

		if(x<y) {
			return x;
		}else{
			return y;
		}
	}
	
	public static double round2(double round) {
		
		//OK FOR SOME REASON %.01 DOES WEIRD STUFF, SO NOW I JUST MULTIPLY BY 100 LIKE SOME PLEB.
		
		double rounded=round*100;
		boolean isNegative=false;
		if (round<0) {
			rounded*=-1;
			isNegative=true;
		}
		if (rounded%1>=0.5) {
			rounded+=(1-rounded%1);
		}else{
			rounded-=(rounded%1);
		}
		if (!isNegative) {
			return rounded/100;
		}else{
			return rounded*=-100;
		}
	}
	
	//part 3: methods that call methods that have loops that do things
	
	public static double exponent(double base, int power) {
		double exponented=base;
		if(power==1) {
		}else if(power>1) {
			for(int i=1;i<power;i++) {
				exponented*=base;
			}
		}else{
			for(int i=1;i>power;i--) {
				exponented/=base;
			}
		}
		return exponented;
	}
	
	public static int factorial(int x) {
		int factorialed=1;
		for(int i=1;i<=x;i++) {
			factorialed*=i;
		}
		return factorialed;
	}
	
	public static boolean isPrime(int x) {
		boolean prime=true;
		for(int i=2;i<x;i++) {
			if(isDivisibleBy(x,i)) {
				prime=false;
				break;
			}else{
				prime=true;
			}
		}
		return prime;
	}
	
	public static int gcf(int x, int y) {
		int minMax=min(x,y);
		int gcf=1;
		for(int i=minMax;i>=1;i--) {
			if(isDivisibleBy(x,i)&&isDivisibleBy(y,i)) {
				gcf=i;
				break;
			}
		}
		return gcf;
	}
	
	public static double sqrt(double x) {
		double guess=x/20;
		while(absValue(x-square(guess)) >= 0.001){
			guess-=((square(guess)-x)/(2*guess));
		}
		return round2(guess);
	}
}
