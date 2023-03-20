package com.jps.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    static int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<Integer>();

        for(int i=0;i<timePoints.size();i++){
            int hrs = Integer.parseInt(timePoints.get(i).substring(0,2));
            int mins = Integer.parseInt(timePoints.get(i).substring(3,5));
            minutes.add((hrs *60)+ (mins));
        }
        //sort
        Collections.sort(minutes);

        int mini = Integer.MAX_VALUE;
        for(int i=0; i< minutes.size()-1;i++){
            mini = Math.min(mini, minutes.get(i+1) -minutes.get(i));
        }
        int lastDiff = (minutes.get(0) +1440) - minutes.get(timePoints.size()-1);
        mini = Math.min(mini, lastDiff);

        return mini;

    }
    public static void main(String[] args) {
		List<String> ls = Arrays.asList("23:59","00:00");
		System.out.println(findMinDifference(ls));
	}
}