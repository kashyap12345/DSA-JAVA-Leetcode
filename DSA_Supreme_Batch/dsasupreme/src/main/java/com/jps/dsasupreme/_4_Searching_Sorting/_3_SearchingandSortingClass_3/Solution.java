package com.jps.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;
class Solution {
    boolean checkPalindrome(String s, int left, int right){
        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
            
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int slen = s.length();
        int i=0;
        int j= slen-1;
        while(i<=j){

            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return checkPalindrome(s,i+1,j) || checkPalindrome(s,i,j-1);
            }
        }
        return true;

        
    }
}