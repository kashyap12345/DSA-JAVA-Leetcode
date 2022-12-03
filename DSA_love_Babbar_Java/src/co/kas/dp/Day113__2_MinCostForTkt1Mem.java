package co.kas.dp;

public class Day113__2_MinCostForTkt1Mem {

	static int[] days = new int[]{2,5};
	static int[] cost = new int[]{1,4,25};
	static int n = days.length;
	static int dp[] = new int[n+1];
	/*static int[] days = new int[]{1,4,6,7,8,20};
	static int[] cost = new int[]{2,7,15};
	static int n = days.length;*/

	/*static int[] days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};
	static int[] cost = new int[]{2,7,15};
	static int n = days.length;*/
	
	static int countDearr(int indx) {

		if (indx >= n) return 0;
		if(dp[indx] != -1) return dp[indx];
			
		int opt1 = cost[0] + countDearr(indx+1);
		
		int i;
		for(i=indx; i<n && days[i] < days[indx] +7;i++);
		int opt2 = cost[1] + countDearr(i);
		
		for(i = indx; i<n && days[i] < days[indx] + 30;i++);
		int opt3 = cost[2] + countDearr(i);
		
		//only 1 parmeter changing while calling above fun inx so 1-d dp
		dp[indx] = Math.min(opt1, Math.min(opt2, opt3));
		return dp[indx];
	}

	public static void main(String[] args) {
		for(int i =0;i<=n;i++)
			dp[i] = -1;
		System.out.println(countDearr(0));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5