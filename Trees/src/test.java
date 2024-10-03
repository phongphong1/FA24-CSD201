import java.util.*;

public class test{
	public static void main(String[] args) {
		Random rd = new Random();
		int[] a = new int[12];
		for (int i=0;i<12;i++){
			a[i] = rd.nextInt(10);
		}
		
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

	}
}