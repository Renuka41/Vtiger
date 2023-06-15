package vtiger;

public class GenericMethodPractice {

	public static void main(String[] args) {
//caller method
		int c=add(20,30);
		System.out.println(c);
	}
	//called method - generic method 
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}

}
