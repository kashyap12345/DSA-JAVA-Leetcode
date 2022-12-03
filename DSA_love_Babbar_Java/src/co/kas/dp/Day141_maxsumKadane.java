package co.kas.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Day141_maxsumKadane {

	static int maxSumSubArray(int[] arr){
		
		int sum =0, maxi =Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++){
			sum = sum + arr[i];
			
			maxi = Math.max(maxi, sum);
			
			if(sum<0)
				sum =0;
		}
		return maxi;
	}
	public static void main(String[] args) {

		int[] arr = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
		System.out.println(maxSumSubArray(arr));
	}

}
