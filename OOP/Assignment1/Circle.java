package interfaceShape;

class Circlec implements Shape{
	private static final double PI = 3.14;
	private double radius;
	public Circlec(double radius){this.radius = radius;}
	public void draw(){
		System.out.println("A Circle has been drawn");		
	}
	
	public double getArea(){
		return PI * radius * radius ; 
	}
}
