package dp;

import java.util.*;

class word implements Comparable<word>{
	int pos = 0;
	String text = null;
	word(String data, int post){
		char[] t = data.toCharArray();
		Arrays.sort(t);;
		this.text = String.valueOf(t);
		this.pos = post;
	}
	@Override
	public int compareTo(word o) {
		// TODO Auto-generated method stub
		if(this.text.compareTo(o.text)>=0)
			return 1;
		return -1;
	}
}
public class dpabc {
	public static void main(String[] args) {
		System.out.println(removeDuplicate("geeksforgee"));
		"geeksforgee".substring("geeksforgee".length());
	}
	public static String removeDuplicate(String abc) {
		String temp = "";
		for(int i = 0;i<abc.length()-1;i++) {
			if(abc.charAt(i+1)==abc.charAt(i)){
				temp = abc.substring(0,i)+abc.substring(i+2);
				break;
			}
			
		}
		if(temp.equals(""))
			return abc;
		else {
			return removeDuplicate(temp);
		}
	}
	public static int matrix(int[] abc, int start, int end) {
		
		if(start == end) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = start;i<end;i++) {
			count = matrix(abc, start, i)+matrix(abc,i+1,end)+abc[start-1]*abc[i]*abc[end];
			if(count<min)
				min = count;
		}
		return min;
	}
	public static int matrixdp(int[]abc, int start, int end){
		int[][] dp= new int[end][end];
		
		for(int L =2;L<end;L++) {
			for(int i = 1;i<end-L+1;i++) {
				int j = i+L-1;
				 dp[i][j] = Integer.MAX_VALUE;
				for(int k = i;k<=j-1;k++) {
					int q = dp[i][k]+dp[k+1][j]+(abc[i-1]*abc[k]*abc[j]);
					if(q<dp[i][j])
						dp[i][j] = q;
				}
			}
		}
		for(int i = 0;i<end;i++) {
			for(int j = 0;j<end;j++)
				System.out.print(dp[i][j]+ " ");
			System.out.println("");
		}
		return dp[1][end-1];
	}
	public static int binomial(int c, int k) {
		if(c==k || k == 0)
			return 1;
		return binomial(c-1,k-1) + binomial(c-1,k);
	}
	public static int binomialDp(int c, int k) {
		int[][] dp = new int[c+1][k+1];
		for(int i =0;i<=c;i++) {
			for(int j = 0;j<=Math.min(i, k);j++) {
				if(j ==0 || j == i) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				}
			}
		}
		for(int i = 0;i<=c;i++) {
			for(int j = 0;j<=k;j++)
				System.out.print(dp[i][j]+ " ");
			System.out.println("");
		}
		return dp[c][k];
	}
	public static int knapsack10(int[]w, int[] v, int weight, int n) {
		if(weight ==0 || n == 0)
			return 0;
		if(w[n-1]>weight) {
			return knapsack10(w,v,weight,n-1);
		}
		return Math.max(knapsack10(w,v,weight,n-1),v[n-1]+knapsack10(w,v,weight-w[n-1],n-1));
	}
	
	//limit check
	public static int knapsack10dp(int[]w, int[] v, int weight, int n) {
		int[][] dp =new int [weight+1][n+1];
		for(int i = 0;i<=weight;i++) {
			for(int j = 0;j<=n;j++) {
				if(i == 0 || j ==0) {
					dp[i][j] = 0;
				} else if (i >=w[j-1]) {
					dp[i][j]= Math.max(dp[i][j-1], v[j-1]+dp[i-w[j-1]][j-1]);
				}else {
					dp[i][j]=dp[i][j-1];
				}
			}
		}
		return dp[weight][n];
	}
	
}
