package com.kas.BinarySearchTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Lect71_1_2sum_BST {
	//static List<Integer> inO  = new ArrayList();
	static void inOrder(TreeNode root,List<Integer> inO){
		
		if(root == null)
			return;
		inOrder(root.left, inO);
		inO.add(root.val);
		inOrder(root.right, inO);
		
	}
	static boolean findTarget(TreeNode root, int k) {
		List<Integer> inO  = new ArrayList();
		inOrder(root,inO);
		int i =0, j = inO.size()-1;
		while(i<j)
		{
			if(inO.get(i) + inO.get(j) == k)
				return true;
			else if(inO.get(i) + inO.get(j) < k) i++;
			else j--;
		} 
		return false;
	}

	
	public static void main(String[] args) {
		int k = -4;
		int[] element = new int[] { 0,-1,2,-3,4};
				
		TreeNode root = createBst(element);
		// here integer.max_val not work for last no. of int
		Boolean res = findTarget(root, k);
		System.out.println(res);

	}

	static void levelOrderTra(TreeNode root) {
		// 1 3 7
		TreeNode temp = null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			temp = q.peek();
			q.poll();
			System.out.print(" " + temp.val);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
	}

	static TreeNode insertInBst(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data, null, null);
			return node;
		}

		if (data < node.val) {
			node.left = insertInBst(node.left, data);
		}
		if (data > node.val) {
			node.right = insertInBst(node.right, data);
			;
		}
		return node;

	}

	// 1. builde tree
	static TreeNode createBst(int[] element) {

		TreeNode root = null;

		for (int i = 0; i < element.length; i++) {
			root = insertInBst(root, element[i]);
		}
		return root;

	}
}