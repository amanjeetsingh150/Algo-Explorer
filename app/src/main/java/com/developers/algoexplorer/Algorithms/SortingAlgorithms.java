package com.developers.algoexplorer.Algorithms;

/**
 * Created by Amanjeet Singh on 16-Jan-17.
 */

public class SortingAlgorithms {
    public static final String BUBBLE_SORT_ALGO="begin BubbleSort(list)\n" +
            "\n" +
            "for all elements of list\n" +
            "if list[i] > list[i+1]\n" +
            " swap(list[i], list[i+1])\n" +
            "end if\n" +
            "end for\n" +
            "\n" +
            "return list\n" +
            "\n" +
            "end BubbleSort";
    public static final String MERGE_SORT_ALGO="mergeSort(array, first, last):\n" +
            "//sort array[first] to array[last-1]\n" +
            "if last - first <= 1:\n" +
            "return //length 0 or 1 already sorted\n" +
            "\n" +
            "mid = (first + last)/2\n" +
            "mergeSort(array, first, mid) //recursive call 1\n" +
            "mergeSort(array, mid, last) //recursive call 2\n" +
            "merge(array, first, mid, last)\n\n" +
            "merge(array, first, mid, last):\n" +
            "//merge array[first to mid-1] and array[mid to last-1]\n" +
            "leftpos = first\n" +
            "rightpos = mid\n" +
            "for newpos from 0 to last-first:\n" +
            "if array[leftpos] <= array[rightpos]:\n" +
            " newarray[newpos] = array[leftpos]\n" +
            " leftpos++\n" +
            "else:\n" +
            " newarray[newpos] = array[rightpos]\n" +
            " rightpos++\n" +
            " copy newarray to array[first to (last-1)]";
    public static final String INSERTION_SORT_ALGORITHM="INSERTION_SORT (A)\n" +
            "\n" +
            "1.FOR j ← 2 TO length[A]\n" +
            "2.DO  key ← A[j]   \n" +
            "3.{Put A[j] into the sorted sequence A[1 . . j − 1]}  \n" +
            "4.i ← j − 1   \n" +
            "5.WHILE i > 0 and A[i] > key\n" +
            "6.DO A[i +1] ← A[i]           \n" +
            "7.i ← i − 1    \n" +
            "8.A[i + 1] ← key";
    public static final String QUICK_SORT_ALGORITHM="Quicksort(A as array, low as int, high as int){\n" +
            "if (low < high){\n" +
            "pivot_location = Partition(A,low,high)\n" +
            "Quicksort(A,low, pivot_location)\n" +
            "Quicksort(A, pivot_location + 1, high)\n" +
            "}\n" +
            "}\n" +
            "Partition(A as array, low as int, high as int){\n" +
            "pivot = A[low]\n" +
            "leftwall = low\n" +
            "\n" +
            "for i = low + 1 to high{\n" +
            "if (A[i] < pivot) then{\n" +
            "swap(A[i], A[leftwall])\n" +
            "leftwall = leftwall + 1\n" +
            "}\n" +
            "}\n" +
            "swap(pivot,A[leftwall])\n" +
            "\n" +
            "return (leftwall)}";
    public static final String HEAP_SORT_ALGORITHM="MaxHeapify(A, i)\n" +
            "l = left(i)\n" +
            "r = right(i)\n" +
            "if l <= heap-size[A] and A[l] > A[i]\n" +
            "then largest = l\n" +
            "else largest = i\n" +
            "if r <= heap-size[A] and A[r] > A[largest]\n" +
            " then largest = r\n" +
            " if largest != i\n" +
            "  then swap A[i] with A[largest]\n" +
            "  MaxHeapify(A, largest)\n" +
            "end func\n" +
            " \n" +
            "BuildMaxHeap(A)\n" +
            "heap-size[A] = length[A]\n" +
            "for i = |length[A]/2| downto 1\n" +
            "do MaxHeapify(A, i)\n" +
            "end func\n" +
            " \n" +
            "HeapSort(A)\n" +
            "BuildMaxHeap(A)\n" +
            "for i = length[A] downto 2\n" +
            "do swap A[1] with A[i]\n" +
            "heap-size[A] = heap-size[A] – 1\n" +
            "MaxHeapify(A, 1)\n" +
            "end func";
    public static final String SELECTION_SORT_ALGORITHM="SELECTION-SORT(A)\n" +
            "1.for j ← 1 to n-1\n" +
            "2. smallest ← j\n" +
            "3.for i ← j + 1 to n\n" +
            "4. if A[ i ] < A[ smallest ]\n" +
            "5.  smallest ← i\n" +
            "6.  Exchange A[ j ] ↔ A[ smallest ]";

}
