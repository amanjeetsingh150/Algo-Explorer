package com.developers.algoexplorer.Programs;

/**
 * Created by Amanjeet Singh on 23-Jan-17.
 */

public class GraphProgramming {
    public static final String floydpro="#include <iostream>\n" +
            "using namespace std;\n" +
            "\n" +
            "void floyds(int b[][7])\n" +
            "{\n" +
            " int i, j, k;\n" +
            " for (k = 0; k < 7; k++)\n" +
            " {\n" +
            " for (i = 0; i < 7; i++)\n" +
            "{\n" +
            "for (j = 0; j < 7; j++)\n" +
            "{\n" +
            "if ((b[i][k] * b[k][j] != 0) && (i != j))\n" +
            "{\n" +
            "if ((b[i][k] + b[k][j] < b[i][j]) || (b[i][j] == 0))\n" +
            "{\n" +
            "b[i][j] = b[i][k] + b[k][j];\n" +
            " }\n" +
            "}\n" +
            " }\n" +
            "}\n" +
            "}\n" +
            "for (i = 0; i < 7; i++)\n" +
            "{\n" +
            " cout<<\"nMinimum Cost With Respect to Node:\"<<i<<endl;\n" +
            " for (j = 0; j < 7; j++)\n" +
            " {\n" +
            " cout<<b[i][j]<<\"t\";\n" +
            " }\n" +
            "}\n" +
            "}\n" +
            "int main()\n" +
            "{\n" +
            "int b[7][7];\n" +
            "cout<<\"ENTER VALUES OF ADJACENCY MATRIXnn\";\n" +
            "for (int i = 0; i < 7; i++)\n" +
            "{\n" +
            " cout<<\"enter values for \"<<(i+1)<<\" row\"<<endl;\n" +
            " for (int j = 0; j < 7; j++)\n" +
            " cin>>b[i][j];\n" +
            "}\n" +
            "floyds(b);\n" +
            "return 0;\n" +
            "}";
    public static final String dijpro="#include<iostream>\n" +
            "#include<conio.h>\n" +
            "#include<stdio.h>\n" +
            "using namespace std;\n" +
            "int shortest(int ,int);\n" +
            "int cost[10][10],dist[20],i,j,n,k,m,S[20],v,totcost,path[20],p;\n" +
            "main()\n" +
            "{\n" +
            "int c;\n" +
            "cout <<\"enter no of vertices\";\n" +
            "cin >> n;\n" +
            "cout <<\"enter no of edges\"; \n" +
            "cin >>m;\n" +
            "cout <<\"\\nenter\\nEDGE Cost\\n\";\n" +
            "for(k=1;k<=m;k++)\n" +
            "{\n" +
            "cin >> i >> j >>c;\n" +
            "cost[i][j]=c;\n" +
            "}\n" +
            "for(i=1;i<=n;i++)\n" +
            "for(j=1;j<=n;j++)\n" +
            "if(cost[i][j]==0)\n" +
            "cost[i][j]=31999;\n" +
            "cout <<\"enter initial vertex\";\n" +
            "cin >>v;\n" +
            "cout << v<<\"\\n\";\n" +
            "shortest(v,n);\n" +
            " }\n" +
            " \n" +
            "int shortest(int v,int n)\n" +
            "{\n" +
            "int min;\n" +
            "for(i=1;i<=n;i++)\n" +
            "{\n" +
            "S[i]=0;\n" +
            "dist[i]=cost[v][i];\n" +
            "}\n" +
            "path[++p]=v;\n" +
            "S[v]=1;\n" +
            "dist[v]=0;\n" +
            "for(i=2;i<=n-1;i++)\n" +
            "{\n" +
            "k=-1;\n" +
            "min=31999;\n" +
            "for(j=1;j<=n;j++)\n" +
            "{\n" +
            "if(dist[j]<min && S[j]!=1)\n" +
            "{\n" +
            "min=dist[j];\n" +
            "k=j;\n" +
            "} \n" +
            "}\n" +
            "if(cost[v][k]<=dist[k])\n" +
            "p=1;\n" +
            "path[++p]=k;\n" +
            "for(j=1;j<=p;j++)\n" +
            "cout<<path[j];\n" +
            "cout <<\"\\n\";\n" +
            "//cout <<k;\n" +
            "S[k]=1;\n" +
            "for(j=1;j<=n;j++)\n" +
            "if(cost[k][j]!=31999 && dist[j]>=dist[k]+cost[k][j] && S[j]!=1)\n" +
            " dist[j]=dist[k]+cost[k][j];\n" +
            "}\n" +
            "}";

}
