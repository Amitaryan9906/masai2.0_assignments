package java_assignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//Write a Java program to reverse a string without using built-in functions.

public class Assign1 {
public static void main(String[] args) {
//	Scanner = new Scanner(System.in;)
	String str = "Amit";
	
	String res= reverseString(str);

	System.out.println(res);
 int arr[] = {1,2,3,5,6,7,8,9};
 int arr1[] = {1,2,3,5,6,7,8,9,28,276,99,89};
 int mn=2;
System.out.println(findMissingNumber(arr,mn));
System.out.println(Arrays.toString(mergeAndRemoveDuplicates(arr, arr1)));
sortArray(arr1);
checkDuplicates(arr1);
findLargestAndSmallest(arr1);
}


private static String reverseString(String str) {
	
	StringBuilder st = new StringBuilder();
	for(int a =str.length()-1;a>=0;a--) {
		st.append(str.charAt(a));
	}
	
	return st.toString();
}

//Check if a given string is a palindrome.

private Boolean isPalindrome(String str) {
	
	for(int i=0;i<=str.length()/2;i++) {
		
	}
	
	
	return null;
}

//Remove duplicate characters from a string.
private String remove_duplicate_from_str() {
	// TODO Auto-generated method stub
	String res="";
	return res;
}

//- Find the first non-repeated character in a string.

private void first_nonrepeted_char() {
	// TODO Auto-generated method stub

}
//Remove duplicate characters from a string
private static String remove_duplicate_from_str(String input) {
    String res = "";
    Set<Character> seen = new HashSet<>();
    for (char c : input.toCharArray()) {
        if (!seen.contains(c)) {
            seen.add(c);
            res += c;
        }
    }
    return res;
}

// Find the first non-repeated character in a string
private static void first_nonrepeted_char(String input) {
    Map<Character, Integer> countMap = new LinkedHashMap<>();
    for (char c : input.toCharArray()) {
        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
        if (entry.getValue() == 1) {
            System.out.println("First non-repeated character: " + entry.getKey());
            return;
        }
    }

    System.out.println("No non-repeated characters found.");
}

// Count the occurrences of each character in a string
private void countCharacterOccurrences(String input) {
    Map<Character, Integer> countMap = new HashMap<>();
    for (char c : input.toCharArray()) {
        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}

// Find the largest and smallest number in an array
private static void findLargestAndSmallest(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
        if (num < min) min = num;
        if (num > max) max = num;
    }

    System.out.println("Smallest: " + min);
    System.out.println("Largest: " + max);
}

// Check for duplicate elements in an array
private static void checkDuplicates(int[] arr) {
    Set<Integer> seen = new HashSet<>();
    boolean found = false;

    for (int num : arr) {
        if (seen.contains(num)) {
            System.out.println("Duplicate found: " + num);
            found = true;
        } else {
            seen.add(num);
        }
    }

    if (!found) {
        System.out.println("No duplicates found.");
    }
}

// Sort an array without using the built-in sort method (using Bubble Sort)
private static void sortArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    System.out.println("Sorted Array: " + Arrays.toString(arr));
}

// Merge two arrays and remove duplicates
private static int[] mergeAndRemoveDuplicates(int[] arr1, int[] arr2) {
    Set<Integer> mergedSet = new LinkedHashSet<>();
    for (int num : arr1) mergedSet.add(num);
    for (int num : arr2) mergedSet.add(num);

    int[] result = new int[mergedSet.size()];
    int i = 0;
    for (int num : mergedSet) {
        result[i++] = num;
    }

    return result;
}

// Find the missing number in an array from 1 to n
public static int findMissingNumber(int[] arr, int n) {
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : arr) {
        actualSum += num;
    }

    return expectedSum - actualSum;
}

}
