/**
 * 
 */
package org.demo.java;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 剔除list中的重复元素方法1
 * <br/>
 * 		<b>使用hashset方式提出重复元素</b>
 * <br/>
 * 		<b>此方法不会改变原list数据存放位置</b>
 * 
 * @author chao.yu
 *
 */
public class ListWithDuplicateOne {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Constructing An ArrayList
		ArrayList<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLETS");
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");
		
		// Printing listWithDuplicateElements
		System.out.print("ArrayList With Duplicate Elements :");
		System.out.println(listWithDuplicateElements);
		
		// Constructing HashSet using listWithDuplicateElements
		HashSet<String> set = new HashSet<String>(listWithDuplicateElements);
		
		// Constructing listWithoutDuplicateElements using set
		ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(
				set);
		
		// Printing listWithoutDuplicateElements
		System.out.print("ArrayList After Removing Duplicate Elements :");
		
		System.out.println(listWithoutDuplicateElements);

	}

}
