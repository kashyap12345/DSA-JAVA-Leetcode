package com.cisco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream; 
 
public class PickingUpTickets { 
    public static void main(String[] args) { 
       
    	List<Integer> li = new ArrayList<Integer>(Arrays.asList(1,1,2,2,4,4,6,6,6));
    	List<Integer> sorted = li.stream().sorted().collect(Collectors.toList());
    	//System.out.println(sorted);
    	int last =0;
    	PriorityQueue<Integer> pqMaxHeap = new PriorityQueue<>((a,b) ->b-a);
    	for(int i = 0; i<sorted.size()-1;i++){
    		
    		if(sorted.get(i+1) - sorted.get(i) >1){
    			
    			pqMaxHeap.add(i+1 - last);
    			last = i+1;
    		}
    	}
    	pqMaxHeap.add(sorted.size()-last);
    	if(pqMaxHeap.isEmpty())
    		System.out.println(sorted.size()-1);
    	else
    		System.out.println(pqMaxHeap.peek());
    }  
} 