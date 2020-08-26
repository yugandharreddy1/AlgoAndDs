package ds.io.LeetCode;

public class MyPow {

	public static void main(String[] args) {
		double x = 2.00000;
		int n = 10;
		myPow(x,n);
	}
	public static double myPow(double x, int m) {
		double temp=x;
		if(m==0)
			return 1;
		temp=myPow(x,m/2);
		if(m%2==0)
			return temp*temp;
		else 
		{
			if(m > 0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}
}
