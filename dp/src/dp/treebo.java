package dp;

import java.util.*;

public class treebo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int no = sc.nextInt();
		String[] store = new String[no];
		for(int i = 0;i<no;i++) {
			store[i] = sc.next();
		}
		int count = 0;
		for(int i = 0;i<no;i++) {
			for(int j = i+1;j<no;j++) {
				 if(compare(store[i],store[j])){
					 count++;
				 }
			}
		}
		System.out.println(count);
	}
	public static boolean compare(String first, String second) {
		String small = first;
		String big = second;
		if(first.length()>second.length()) {
			big = first;
			small= second;
		}
		for(int i = 0;i<small.length();i++) {
			for(int j= 0;j<big.length();j++) {
				if(small.charAt(i) == big.charAt(j))
					return false;
			}
		}
		return true;
	}
}
