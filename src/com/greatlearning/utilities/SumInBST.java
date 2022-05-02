package com.greatlearning.utilities;

import java.util.ArrayList;

public class SumInBST {

	static class Node {
		int key;
		Node left, right;
	}

	static Node newNode(int value) {
		Node temp = new Node();
		temp.key = value;
		temp.left = null;
		temp.right = null;

		return temp;
	}

	static Node insert(Node node, int key) {
		Node newNode = newNode(key);
		Node x = node;

		Node current_parent = null;
		while (x != null) {
			current_parent = x;

			if (key < x.key) {
				x = x.left;
			} else if (key > x.key) {
				x = x.right;
			} else {
				System.out.println("value already exists");
				return newNode;
			}
		}
		if (current_parent == null) {
			current_parent = newNode;
		} else if (key < current_parent.key) {
			current_parent.left = newNode;
		} else {
			current_parent.right = newNode;
		}
		return current_parent;
	}

	static ArrayList<Integer> treeToList(Node node, ArrayList<Integer> list) {
		if (node == null)
			return list;

		treeToList(node.left, list);
		list.add(node.key);
		treeToList(node.right, list);

		return list;
	}

	static boolean isPairPresent(Node node, int target) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayFromTree = treeToList(node, arrayList);

		int startIndex = 0;
		int endindex = arrayFromTree.size() - 1;

		while (startIndex < endindex) {

			if (arrayFromTree.get(startIndex) + arrayFromTree.get(endindex) == target) {
				System.out
						.println("Pair is (" + arrayFromTree.get(startIndex) + "," + arrayFromTree.get(endindex) + ")");
				return true;
			}

			if (arrayFromTree.get(startIndex) + arrayFromTree.get(endindex) > target) {
				endindex--;
			}

			if (arrayFromTree.get(startIndex) + arrayFromTree.get(endindex) < target) {
				startIndex++;
			}
		}

		System.out.println("Nodes are not found!");
		return false;
	}

	public static void main(String[] args) {

		int[] array = { 40, 20, 60, 10, 30, 50, 70 };
		;

		Node root = null;
		for (int i = 0; i < array.length; i++) {
			if (root == null) {
				root = insert(root, array[i]);
			} else {
				insert(root, array[i]);
			}
		}

		int sum = 130;
		System.out.println("Sum = " + sum);

		isPairPresent(root, sum);

	}

}
