package com.developers.algoexplorer.Programs;

/**
 * Created by Amanjeet Singh on 16-Jan-17.
 */

public class SortingPrograms {
    public static final String BUBBLE_SORT_PROG="/* C++ Program - Bubble Sort */\n" +
            "\t\t\n" +
            "#include<iostream.h>\n" +
            "#include<conio.h>\n" +
            "void main()\n" +
            "{\n" +
            "clrscr();\n" +
            "int n, i, arr[50], j, temp;\n" +
            "cout<<\"Enter total number of elements :\";\n" +
            "cin>>n;\n" +
            "cout<<\"Enter \"<<n<<\" numbers :\";\n" +
            "for(i=0; i<n; i++)\n" +
            "{\n" +
            "cin>>arr[i];\n" +
            "}\n" +
            "cout<<\"Sorting array using bubble sort:\\n\";\n" +
            "for(i=0; i<(n-1); i++)\n" +
            "{\n" +
            "for(j=0; j<(n-i-1); j++)\n" +
            "{\n" +
            "if(arr[j]>arr[j+1])\n" +
            "{\n" +
            "temp=arr[j];\n" +
            "arr[j]=arr[j+1];\n" +
            "arr[j+1]=temp;\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "cout<<\"Elements sorted successfully..!!\\n\";\n" +
            "cout<<\"Sorted list in ascending order :\\n\";\n" +
            "for(i=0; i<n; i++)\n" +
            "{\n" +
            "cout<<arr[i]<<\" \";\n" +
            "}\n" +
            "getch();\n" +
            "}";
    public final static String MERGE_SORT_PROGRAM="#include<iostream.h>\n" +
            "#include<conio.h>\n" +
            "void mergesort(int[],int,int);\n" +
            "void merge(int[],int,int,int);\n" +
            "void main()\n" +
            "{\n" +
            "int a[10],p,q,r,i,n;\n" +
            "clrscr();\n" +
            "cout<<\"Enter the number of elements\";\n" +
            "cin>>n;\n" +
            "p=0;\n" +
            "r=n-1;\n" +
            "cout<<\"Enter the array\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cin>>a[i];\n" +
            "}\n" +
            "mergesort(a,p,r);\n" +
            "cout<<\"The sorted array is:\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cout<<\"\\n\"<<a[i];\n" +
            "}\n" +
            "getch();\n" +
            "}\n" +
            "\n" +
            "void mergesort(int a[],int p,int r)\n" +
            "{\n" +
            "if( p < r)\n" +
            "{\n" +
            "int q=(p+r)/2;\n" +
            "mergesort(a,p,q);\n" +
            "mergesort(a,q+1,r) ;\n" +
            "merge(a,p,q,r);\n" +
            "}\n" +
            "}\n" +
            "void merge(int a[],int p,int q,int r)\n" +
            "{\n" +
            "int c[10];\n" +
            "int i=p;\n" +
            "int j=q+1;\n" +
            "int k=p;\n" +
            "while((i<=q)&&(j<=r))\n" +
            "{\n" +
            "if(a[i]<a[j])\n" +
            "{\n" +
            "c[k]=a[i];\n" +
            "i=i+1;\n" +
            "k=k+1;\n" +
            "}\n" +
            "else\n" +
            "{\n" +
            "c[k]=a[j];\n" +
            "j=j+1;\n" +
            "k=k+1;\n" +
            "}\n" +
            "}\n" +
            "while(i<=q)\n" +
            "{\n" +
            "c[k] =a[i];\n" +
            "i=i+1;\n" +
            "k=k+1;\n" +
            "}\n" +
            "while(j<=r)\n" +
            "{\n" +
            "c[k]=a[j];\n" +
            "j=j+1;\n" +
            "k=k+1;\n" +
            "}\n" +
            "int l=p;\n" +
            "while(l<=r)\n" +
            "{\n" +
            "a[l]=c[l];\n" +
            "l=l+1;\n" +
            "}\n" +
            "}";
    public static final String INSERTION_SORT_PROGRAM="#include<iostream>\n" +
            " \n" +
            "using namespace std;\n" +
            " \n" +
            "int main()\n" +
            "{\n" +
            "int i,j,n,temp,a[30];\n" +
            "cout<<\"Enter the number of elements:\";\n" +
            "cin>>n;\n" +
            "cout<<\"\\nEnter the elements\\n\";\n" +
            "\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cin>>a[i];\n" +
            "}\n" +
            "\n" +
            "for(i=1;i<=n-1;i++)\n" +
            "{\n" +
            "temp=a[i];\n" +
            "j=i-1;\n" +
            "\n" +
            "while((temp<a[j])&&(j>=0))\n" +
            "{\n" +
            "a[j+1]=a[j]; //moves element forward\n" +
            "j=j-1;\n" +
            "}\n" +
            "\n" +
            "a[j+1]=temp; //insert element in proper place\n" +
            "}\n" +
            "\n" +
            "cout<<\"\\nSorted list is as follows\\n\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cout<<a[i]<<\" \";\n" +
            "}\n" +
            "\n" +
            "return 0;\n" +
            "}";
    public static final String QUICK_SORT_PROGRAM="#include<iostream>\n" +
            "#include<conio.h>\n" +
            "using namespace std;\n" +
            "\n" +
            "//Function for partitioning array\n" +
            "int part(int low,int high,int *a)\n" +
            "{\n" +
            "int i,h=high,l=low,p,t;  //p==pivot\n" +
            "p=a[low];\n" +
            "while(low<high)\n" +
            "{\n" +
            "while(a[l]<p)\n" +
            "{\n" +
            "l++;\n" +
            "}\n" +
            "while(a[h]>p)\n" +
            "{\n" +
            "h--;\n" +
            "}\n" +
            "if(l<h)\n" +
            "{\n" +
            "t=a[l];\n" +
            "a[l]=a[h];\n" +
            "a[h]=t;\n" +
            "}\n" +
            "else\n" +
            "{\n" +
            "t=p;\n" +
            "p=a[l];\n" +
            "a[l]=t;\n" +
            "break;\n" +
            "}\n" +
            "}\n" +
            "return h;   \n" +
            "}\n" +
            "\n" +
            "void quick(int l,int h,int *a)\n" +
            "{\n" +
            "int index,i;\n" +
            "if(l<h)\n" +
            "{\n" +
            "index=part(l,h,a);\n" +
            "quick(l,index-1,a);\n" +
            "quick(index+1,h,a);\n" +
            "}\n" +
            "}\n" +
            "\n" +
            "int main()\n" +
            "{\n" +
            "int a[100],n,l,h,i;\n" +
            "cout<<\"Enter number of elements:\";\n" +
            "cin>>n;\n" +
            "cout<<\"Enter the elements(Use Space As A Separator):\";\n" +
            "for(i=0;i<n;i++)\n" +
            "cin>>a[i];\n" +
            "cout<<\"\\nInitial Array:\\n\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cout<<a[i]<<\"\\t\";\n" +
            "}  \n" +
            "h=n-1;\n" +
            "l=0;\n" +
            "quick(l,h,a);\n" +
            "cout<<\"\\nAfter Sorting:\\n\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cout<<a[i]<<\"\\t\";\n" +
            "}\n" +
            "getch();\n" +
            "return 0;\n" +
            "}\n" +
            "\n";
    public static final String HEAP_SORT_PROGRAM="#include <iostream>\n" +
            "using namespace std;\n" +
            "\n" +
            "void max_heapify(int *a, int i, int n)\n" +
            "{\n" +
            "int j, temp;\n" +
            "temp = a[i];\n" +
            "j = 2*i;\n" +
            "while (j <= n)\n" +
            "{\n" +
            "if (j < n && a[j+1] > a[j])\n" +
            "j = j+1;\n" +
            "if (temp > a[j])\n" +
            " break;\n" +
            "else if (temp <= a[j])\n" +
            "{\n" +
            "a[j/2] = a[j];\n" +
            "j = 2*j;\n" +
            "}\n" +
            "}\n" +
            "a[j/2] = temp;\n" +
            "return;\n" +
            "}\n" +
            "void heapsort(int *a, int n)\n" +
            "{\n" +
            "int i, temp;\n" +
            "for (i = n; i >= 2; i--)\n" +
            "{\n" +
            "temp = a[i];\n" +
            "a[i] = a[1];\n" +
            "a[1] = temp;\n" +
            "max_heapify(a, 1, i - 1);\n" +
            "}\n" +
            "}\n" +
            "void build_maxheap(int *a, int n)\n" +
            "{\n" +
            "int i;\n" +
            "for(i = n/2; i >= 1; i--)\n" +
            "{\n" +
            " max_heapify(a, i, n);\n" +
            "}\n" +
            "}\n" +
            "int main()\n" +
            "{\n" +
            "int n, i, x;\n" +
            "cout<<\"Enter no of elements of arrayn\";\n" +
            "cin>>n;\n" +
            "int a[20];\n" +
            "for (i = 1; i <= n; i++)\n" +
            "{\n" +
            "cout<<\"Enter element\"<<(i)<<endl;\n" +
            "cin>>a[i];\n" +
            "}\n" +
            "build_maxheap(a,n);\n" +
            "heapsort(a, n);\n" +
            "cout<<\"nnSorted Arrayn\";\n" +
            "for (i = 1; i <= n; i++)\n" +
            "{\n" +
            "cout<<a[i]<<endl;\n" +
            "}\n" +
            "return 0;\n" +
            "}";
    public static final String SELECTION_SORT_PROGRAM="#include<iostream>\n" +
            " \n" +
            "using namespace std;\n" +
            " \n" +
            "int main()\n" +
            "{\n" +
            "int i,j,n,loc,temp,min,a[30];\n" +
            "cout<<\"Enter the number of elements:\";\n" +
            "cin>>n;\n" +
            "cout<<\"\\nEnter the elements\\n\";\n" +
            "\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cin>>a[i];\n" +
            "}\n" +
            "\n" +
            "for(i=0;i<n-1;i++)\n" +
            "{\n" +
            "min=a[i];\n" +
            "loc=i;\n" +
            " for(j=i+1;j<n;j++)\n" +
            " {\n" +
            " if(min>a[j])\n" +
            " {\n" +
            " min=a[j];\n" +
            " loc=j;\n" +
            " }\n" +
            "}\n" +
            " \n" +
            "temp=a[i];\n" +
            " a[i]=a[loc];\n" +
            " a[loc]=temp;\n" +
            "}\n" +
            " \n" +
            "cout<<\"\\nSorted list is as follows\\n\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cout<<a[i]<<\" \";\n" +
            "}\n" +
            "\n" +
            "return 0;\n" +
            "}";
}
