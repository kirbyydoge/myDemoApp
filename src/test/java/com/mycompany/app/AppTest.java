package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	
	public void testUnit1() {
		Integer[] arr1 = {0, 1, 2, 3, 4};
		Integer[] arr2 = {0, 1, 2, 3, 4};
		assertTrue(new App().checkSubArray(arr1, arr2, 0, 5));
	}
	
	public void testUnit2() {
		Integer[] arr1 = {0, 3, 2, 3, 4};
		Integer[] arr2 = {0, 1, 2, 4, 4};
		assertFalse(new App().checkSubArray(arr1, arr2, 0, 5));
	}
	
	public void testUnit3() {
		Integer[] arr1 = {0, 1, 2, 3, 4};
		Integer[] arr2 = {0, 1, 2, 3, 4};
		assertFalse(new App().checkSubArray(arr1, arr2, -1, 5));
	}
	
	public void testUnit4() {
		Integer[] arr1 = {0, 1, 2, 3, 4};
		Integer[] arr2 = {0, 1, 2, 3, 4};
		assertFalse(new App().checkSubArray(arr1, arr2, 0, 9));
	}
	
	public void testUnit5() {
		Integer[] arr1 = {-7, 1, 2, 5, 4};
		Integer[] arr2 = {-3, 1, 2, 4, 4};
		assertTrue(new App().checkSubArray(arr1, arr2, 1, 2));
	}

}
