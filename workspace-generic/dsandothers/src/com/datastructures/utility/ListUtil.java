package com.datastructures.utility;

import com.datastructures.elementary.impl.LinkedList;

public class ListUtil {
	public static <T> void removeDuplicates(LinkedList<T> list) {
		LinkedList<T>.Node trailer = list != null ? list.head: null;
		while (trailer != null) {
			LinkedList<T>.Node runner = trailer;
			while (runner != null && runner.next != null) {
				if (trailer.value.equals(runner.next.value)) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			trailer = trailer.next;
		}
	}
	
	public static <T> void printKthToLast(LinkedList<T> list, int k) {
		LinkedList<T>.Node kthNode = list.head;
		for (int i=0; i < k; i++ ) {
			kthNode = kthNode.next;
		}
		while(kthNode!=null) {
			System.out.println(kthNode.value);
		}
	}
	
	public static <T> void deleteCurrentNode(LinkedList<T>.Node node) {
		LinkedList<T>.Node temp = node.next;
		node.next = temp.next;
		node.value = (T)temp.value;
	}
	
	public static void addNumberList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer>.Node l1node = l1.head;
		LinkedList<Integer>.Node l2node = l2.head;
		int carry = 0;
		LinkedList<Integer> sumList = new LinkedList<>();
		System.out.println("List1 "+l1);
		System.out.println("List2 "+l2);
		while (l1node != null || l2node != null || carry > 0) {
			int l1Digit = l1node != null ? l1node.value: 0;
			int l2Digit = l2node != null ? l2node.value: 0;
			int sum = l1Digit + l2Digit + carry;
			carry = sum >9? 1: 0;
			sum = sum%10;
			sumList.add(sum);
			if (l1node != null) l1node = l1node.next; 
			if (l2node != null) l2node = l2node.next;
		}
		System.out.println("sumList "+sumList);		
	}
}
