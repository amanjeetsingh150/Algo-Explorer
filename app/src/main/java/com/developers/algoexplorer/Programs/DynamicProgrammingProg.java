package com.developers.algoexplorer.Programs;

/**
 * Created by Amanjeet Singh on 19-Jan-17.
 */

public class DynamicProgrammingProg {
    public static final String Knapsack="#include<iostream>\n" +
            "using namespace std;\n" +
            "#include<stdio.h>\n" +
            "void knapsack(int n,int W);\n" +
            "int n,i,w,W;\n" +
            "int weight[50],v[50];\n" +
            "int C[50][50];\n" +
            "void main()\n" +
            "{\n" +
            "cout<<\"Enter number of items\";\n" +
            "cin>>n;\n" +
            "cout<<\"Enter Capacity\";\n" +
            "cin>>W;\n" +
            "cout<<\"Enter weights\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cin>>weight[i];\n" +
            "}\n" +
            "cout<<\"Enter values\";\n" +
            "for(i=0;i<n;i++)\n" +
            "{\n" +
            "cin>>v[i];\n" +
            "}\n" +
            "knapsack(n,W);\n" +
            "\n" +
            "}\n" +
            "\n" +
            "void knapsack(int n,int W)\n"+
            "{\n"+
            "\n" +
            "for(int c = 0; c <= W; c++){\n" +
            "  C[0][c] = 0;\n" +
            " }\n" +
            "for(i = 1; i <= n; i++){\n" +
            " C[i][0] = 0;\n" +
            " \n" +
            "}\n" +
            "for(i=1;i<=n;i++)\n" +
            "{\n" +
            "for(w=0;w<=W;w++)\n" +
            " if(weight[i]<=w)\n" +
            "  if(v[i]+C[i-1][w-weight[i]]>C[i-1][w])\n" +
            "   C[i][w]=v[i]+C[i-1][w-weight[i]];\n" +
            "  else\n" +
            "  C[i][w]=C[i-1][w];\n" +
            " else\n" +
            "  C[i][w]=C[i-1][w];\n" +
            "}\n" +
            "cout<<C[i][w];\n" +
            "\n" +
            "}\n" +
            "\n";
    public static final String binomial="#include<iostream>\n" +
            "using namespace std;\n" +
            "class bin\n" +
            "{\n" +
            "int n,k;\n" +
            "public:\n" +
            "void read()\n" +
            "{\n" +
            "cout<<\"Enter n and k\\n\";\n" +
            "cin>>n;cin>>k;\n" +
            "}\n" +
            "int compute();\n" +
            "void display()\n" +
            "{\n" +
            "cout<<\"The binomial coefficient is:\";\n" +
            "cout<<compute();\n" +
            "}\n" +
            "int mim(int a, int b)\n" +
            "{\n" +
            "if(a>b)return b;\n" +
            " else return a;\n" +
            " }\n" +
            "};\n" +
            "int bin::compute()\n" +
            "{\n" +
            "int i,j;\n" +
            "int a[20][20];\n" +
            "for(i=0;i<=n;i++)\n" +
            "{\n" +
            "for(j=0;j<=mim(i,k);j++)\n" +
            "{\n" +
            "if(j==0||j==i)\n" +
            " {\n" +
            "  a[i][j]=1;\n" +
            " }\n" +
            "else\n" +
            " a[i][j]=a[i-1][j-1]+a[i-1][j];\n" +
            "}\n" +
            "}\n" +
            "return a[n][k];\n" +
            "}\n" +
            "int main()\n" +
            "{\n" +
            "bin B;\n" +
            "B.read();\n" +
            "B.compute();\n" +
            "B.display();\n" +
            "return 0;\n" +
            "}";
    public static final String LcsProg="#include <iostream>\n" +
            "\n" +
            "\n" +
            "int lcs(char *X, char *Y, int m, int n)\n" +
            "{\n" +
            "int L[m+1][n+1];\n" +
            "for(int i = 0; i<=m; i++)\n" +
            "{\n" +
            "for(int j = 0; j<=n; j++)\n" +
            "{\n" +
            "if(i==0 || j==0)\n" +
            "{\n" +
            "L[i][j] = 0;\n" +
            "}\n" +
            "else if(X[i-1] == Y[j-1])\n" +
            "{\n" +
            "L[i][j] = L[i-1][j-1] + 1;\n" +
            "}\n" +
            "else \n" +
            "{\n" +
            "L[i][j]=std::max(L[i-1][j], L[i][j-1]);\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "return L[m][n];\n" +
            "}\n" +
            "\n" +
            "int main()\n" +
            "{\n" +
            "int m;\n" +
            "int n;\n" +
            "char X[m], Y[n];\n" +
            "std::cin >> m >> n;\n" +
            "std::cout << \"Enter the string X : \";\n" +
            "for( int i = 0; i<m; i++)\n" +
            "{\n" +
            "std::cin >> X[i];\n" +
            "}\n" +
            "std::cout << \"Enter the string Y : \";\n" +
            "for(int j = 0; j<n; j++)\n" +
            "{\n" +
            "std::cin >> Y[j];\n" +
            "}\n" +
            "std::cout << std::endl;\n" +
            "std::cout<<\"The length of the LCS is \" << lcs( X, Y, m, n) << std::endl ;\n" +
            "return 0;\n" +
            "}\n" +
            "\n" +
            "\t\n";
    public static final String MCM_prog="#include<cstdlib>\n" +
            "#define SZ 10\n" +
            "using namespace std;\n" +
            " \n" +
            "int table[SZ][SZ];\n" +
            "int P[] = {1, 2, 3, 4, 3};\n" +
            " \n" +
            "int MCM(int i, int j)\n" +
            "{\n" +
            "if(i==j) return 0;\n" +
            "\n" +
            "else\n" +
            "{\n" +
            "int min = INT_MAX;\n" +
            "\n" +
            "for(int k=i;k<j;k++)\n" +
            "{\n" +
            "if(table[i][k]==0)\n" +
            " table[i][k] = MCM(i,k);\n" +
            " if(table[k+1][j]==0)\n" +
            "  table[k+1][j] = MCM(k+1,j);\n" +
            "  int sum = table[i][k] + table[k+1][j] + P[i-1]*P[j]*P[k];\n" +
            "  if(sum<min)\n" +
            "    min = sum;  \n" +
            " }\n" +
            " return min;\n" +
            "}\n" +
            "}\n" +
            "\n" +
            "int main()\n" +
            "{\n" +
            "int size = sizeof(P)/sizeof(P[0]);\n" +
            "cout<<\"Minimum number of mutiplications is<<\",MCM(1,size-1));\n" +
            "return 0;\n" +
            "}";
}
