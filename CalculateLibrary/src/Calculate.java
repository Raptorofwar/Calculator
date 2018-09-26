
//Author Jeffrey Liu
//9-6-2018
//Version 1.0 (I'm going to call this version 1.0 forever.)

public class Calculate {
	
	//part 0 - first method and connecting
			
	public static int square(int squareInput) {
		
		//squares input

		return squareInput*squareInput;
	}
	
	public static double square(double squareInput) {
		
		//same as above except doubles
		
		return squareInput*squareInput;
	}
	
	//part one - moar methods
	
	public static int cube(int cubeInput) {
		
		//cubes an input
		
		return cubeInput*cubeInput*cubeInput;
	}
	
	public static double average(double avgOne, double avgTwo) {
		
		//averages 2 inputs
		
		return (avgOne+avgTwo)/2;
	}
	
	public static double average (double avg1, double avg2, double avg3) {
		
		//averages 3 inputs
		
		return (avg1+avg2+avg3)/3;
	}
	
	public static double toDegrees (double radian) {
		
		//converts radians to degrees
		
		return radian*180/3.14159;
	}
	
	public static double toRadians (double degrees) {
		
		//converts degrees to radians
		
		return degrees*3.14159/180;
	}
	
	public static double discriminant (double a, double b, double c) {
		
		//takes standard form abc, returns that little bit inside the square root
		//in quadratic formula
		
		return square(b)-4*a*c;
	}
	
	public static String toImproperFrac(int number, int numerator, int denominator) {
		
		//converts mixed number to improper fraction
		
		return (number*denominator)+numerator+" "+denominator;
	}
	
	public static String toMixedNum(int numerator, int denominator) {
		
		//converts improper fraction to mixed number
		
		return (numerator/denominator)+"_"+(numerator%denominator)+"/"+denominator;
	}
	
	public static String foil(int a, int b, int c, int d, String x) {
		
		//put in factored form, get standard form
		
		return (a*c)+x+"^2 + "+(a*d+b*c)+x+" + "+(b*d);
	}
	
	//part 2 - methods with conditionals
	
	public static boolean isDivisibleBy(int numerator, int denominator) {
		
		//tests if there's no remainder for a division
		
		if(denominator==0) {
			throw new IllegalArgumentException("Divide by 0");
		}
		if(numerator%denominator==0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static double absValue(double absolute) {
		
		//returns absolute value of two doubles
		
		if (absolute<0) {
			return absolute*-1;
		}else {
			return absolute;
		}
	}
	
	public static int absValue(int absolute) {
		
		//returns absolute values of two ints
		//having methods that only work with ints and methods that only work with doubles
		//is confusing as all ****
		
		if (absolute<0) {
			return absolute*-1;
		}else {
			return absolute;
		}
	}
	
	public static double max(double x, double y) {
		
		//finds largest of two inputs
		
		if (x>y) {
			return x;
		}else {
			return y;
		}
	}
	
	public static double max(double x, double y, double z) {
		
		//finds largest of three inputs
		
		double max;
		if (x>y) {
			max=x;
		}else {
			max=y;
		}
		if (max>z) {
			return max;
		}else {
			return z;
		}
	}
		
	public static int min(int x, int y) {
		
		//finds the smaller of two ints
		
		//WHY IS THIS ONE AN INT BUT THE ABOVE ARE DOUBLES?

		if(x<y) {
			return x;
		}else {
			return y;
		}
	}
	
	public static double min(double x, double y) {
		
		//copy of above method except for doubles, because reasons
		//more importantly just to fix part 4
		
		//Overloading! woooooo

		if(x<y) {
			return x;
		}else {
			return y;
		}
	}
	
	public static double round2(double round) {
		
		//rounds input to hundredths place
		
		//OK FOR SOME REASON %.01 DOES WEIRD STUFF
		//SO NOW I JUST MULTIPLY BY 100 LIKE SOME PLEB.
		
		double rounded=round*100;
		boolean isNegative=false;
		if (round<0) {
			rounded*=-1;
			isNegative=true;
		}
		if (rounded%1>=0.5) {
			rounded+=(1-rounded%1);
		}else {
			rounded-=(rounded%1);
		}
		if (!isNegative) {
			return rounded/100;
		}else {
			return rounded/=-100;
		}
	}
	
	//part 3: methods that call methods that have loops that do things
	
	public static double exponent(double base, int power) {
		
		//returns base to power power
		
		if(power<1) {
			throw new IllegalArgumentException("Negative power: "+power);
		}
		double exponented=base;
		if(power==1) {
		}else if(power>1) {
			for(int i=1;i<power;i++) {
				exponented*=base;
			}
		}else {
			for(int i=1;i>power;i--) {
				exponented/=base;
			}
		}
		return exponented;
	}
	
	public static int factorial(int x) {
		
		//input int, returns int*int-1*...*1
		
		if(x<0) {
			throw new IllegalArgumentException("Negative factorial: "+x);
		}
		int factorialed=1;
		for(int i=1;i<=x;i++) {
			factorialed*=i;
		}
		return factorialed;
	}
	
	public static boolean isPrime(int x) {
		
		//tests if input int is prime
		
		for(int i=2;i<x;i++) {
			if(isDivisibleBy(x,i)) {
				return true;
			}
		}
		return false;
	}
	
	public static int gcf(int x, int y) {
		
		//input two ints, returns greatest common factor
		
		int placeholder=y;
		int newx=x;
		int newy=y;
		while(newx!=0&&newy!=0) {
			placeholder=newx%newy;
			newx=newy;
		 	newy=placeholder;
		}
		if(newx==0) {
			 return absValue(newy);
		 }else {
			 return absValue(newx);
		 }
	}
	
	public static double sqrt(double x) {
		
		//input double, return sqrt of said double
		
		if(x<0) {
			throw new IllegalArgumentException("Negative square root: "+x);
		}
		double guess=x/20;
		while(absValue(x-square(guess)) >= 0.001){
			guess-=((square(guess)-x)/(2*guess));
		}
		return round2(guess);
	}
	
	// part 4: Exceptions, or lines of code saying no
	
	public static String quadform(int a, int b, int c) {
		
		//put in 3 ints a, b, and c, in accordance with quadratic formula
		//returns a string listing roots (x for y=0)
		
		double square=discriminant(a,b,c);
		double squareRoot;
		if(square<0) {
			return "no real roots";
		}
		squareRoot=sqrt(square);
		double plusRoot=((-b)+squareRoot)/(2*a);
		double minusRoot=((-b)-squareRoot)/(2*a);
		if(plusRoot!=minusRoot) {
			double maxRoot=round2(max(plusRoot, minusRoot));
			double minRoot=round2(min(plusRoot, minusRoot));
			String roots=minRoot+" and "+maxRoot;
			return roots;
		}else {
			return plusRoot+"";
		}
	}
}
