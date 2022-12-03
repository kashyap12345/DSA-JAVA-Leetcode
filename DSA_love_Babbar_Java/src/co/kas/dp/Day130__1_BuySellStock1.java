package co.kas.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day130__1_BuySellStock1 {
	
	public static void main(String[] args) {

		int[] prices = new int[] { 7,1,5,3,6,4 }; //ans 5
		int mini = prices[0];
        int profit = 0;
        
        for(int i=1;i<prices.length;i++){
            
            int diff = prices[i] - mini;
            profit = Math.max(profit,diff);
            mini = Math.min(mini,prices[i]);
        }
		System.out.println(profit);
	}
}
