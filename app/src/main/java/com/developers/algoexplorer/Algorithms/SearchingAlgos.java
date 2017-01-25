package com.developers.algoexplorer.Algorithms;

/**
 * Created by Amanjeet Singh on 17-Jan-17.
 */

public class SearchingAlgos {
    public static final String BINARY_SEARCH_ALGORITHM="function binarySearch(a, value, left, right)\n" +
            "if right < left\n" +
            " return not found\n" +
            "mid := floor((right-left)/2)+left\n" +
            "if a[mid] = value\n" +
            " return mid\n" +
            "if value < a[mid]\n" +
            " return binarySearch(a, value, left, mid-1)\n" +
            "else\n" +
            " return binarySearch(a, value, mid+1, right)\n"+
            "//mid determines the index of a given value";
    public static final String LINEAR_SEARCH_ALGORITHM="//Input: Array D, integer key\n" +
            "// Output: returns i when found,\n//or -1 if not found\n" +
            "\n" +
            " For i = 0 to last index of D:\n" +
            "   if D[i] equals key:\n" +
            "     return i\n" +
            " return -1 //if not found\n";
}
