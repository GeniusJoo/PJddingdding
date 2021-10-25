package test;

import java.util.ArrayList;
import test.information.stu;

public class Binary_search {// ÀÌÁøÅ½»ö
	int BSearch_id(ArrayList<stu>[] arr, int target) {
	    int low = 0;
	    int high = arr.length - 1;
	    int mid;

	    while(low <= high) {
	        mid = (low + high) / 2;
	        System.out.println(mid);
	        System.out.println(arr[mid].get(0).number);
	        if (arr[mid].get(0).number == target)
	            return mid;
	        else if (arr[mid].get(0).number > target)
	            high = mid - 1;
	        else
	            low = mid + 1;
	    }
	    return -1;
	}
}
