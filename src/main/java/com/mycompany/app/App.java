package com.mycompany.app;

public class App {

	//check if [begin, end) subarray is equal
	public boolean checkSubArray(Integer[] arr1, Integer[] arr2, int begin, int end) {
		if(arr1 == null || arr2 == null)
			return false;
		if(arr1.length < end || arr2.length < end)
			return false;
		if(begin < 0 || end < begin)
			return false;
		for(int i = begin; i < end; i++)
			if(arr1[i] != arr2[i])
				return false;
		return true;
	}

}
