package com.kas.extra;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

//long text, first non repetative char
public class Solution2 {
	public static void main(String args[]) throws Exception {
       String inp = "sffkllslladf";
       //a->1,b->1
       //employee emp_id  emp_name hashCode(){return 1;} 
       //Hm<employee , String> ,  = (Emp1 ,abc)  = (Emp2 ,xyz)
    LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<Character,Integer>();
       for(int i =0 ; i< inp.length();i++){
    	   Character curr = inp.charAt(i);
    	   if(charCount.get(curr)  != null  )
    	   {
    		   //already available
    		   int countCurr = charCount.get(curr);
    		   charCount.put(curr, countCurr+1);
    	   }
    	   else
    	   {
    		   charCount.put(curr, 1);
    	   }  
       }
       //iterate over map
       for(Entry<Character, Integer> e :charCount.entrySet()){
    	   if(e.getValue() == 1){
    		   System.out.println(e.getKey());
    		   break;
    	   }
       }
       System.out.println(charCount.entrySet().stream().filter(m ->m.getValue() == 1).collect(Collectors.toList()));
    }
}