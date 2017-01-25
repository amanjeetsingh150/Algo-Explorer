package com.developers.algoexplorer.Algorithms;

/**
 * Created by Amanjeet Singh on 19-Jan-17.
 */

public class DynamicProgrammingAlgos {
    public static final String knapsackalgo="// Input:\n" +
            "// Values(stored in array v)\n" +
            "// Weights(stored in array w)\n" +
            "// Number of distinct items(n)\n" +
            "// Knapsack capacity(W)\n" +
            "for i from 1 to n do\n"+
            "m[i, 0] := 0"+
            "for j from 0 to W do\n" +
            "m[0, j] := 0\n" +
            "end for\n" +
            "for i from 1 to n do\n" +
            "for j from 0 to W do\n" +
            "if w[i] <= j then\n" +
            "m[i,j]:=max(m[i-1, j], m[i-1, j-w[i]] + v[i])\n" +
            "else\n" +
            "m[i,j]:=m[i-1, j]\n" +
            "end if\n" +
            "end for\n" +
            "end for";
    public static final String binomialalgo="if (k == 0 || k == n) /* base caseS */\n" +
            "  return 1;\n" +
            "else /* recursive caseS */\n" +
            "  return C(n-1, k-1) +" +
            "C(n-1, k);";
    public static final String lcsalgo="LCS-Length(X, Y)\n" +
            "\n" +
            "m <- length[X]\n" +
            "n <- length[Y]\n" +
            "\n" +
            "for i <- 1 to m\n" +
            " c[i,0] <- 0\n" +
            "for j <- 1 to n\n" +
            " c[0,j] <- 0\n" +
            "\n" +
            "for i <- 1 to m\n" +
            " for j <- 1 to n\n" +
            "  if (x_i == y_j) {\n" +
            "   c[i,j] <- c[i-1,j-1] + 1\n" +
            "   b[i,j] <- NW\n" +
            "  }\n" +
            " else if (c[i-1,j] >= c[i,j-1]) {\n" +
            "  c[i,j] <- c[i-1,j]\n" +
            "  b[i,j] <- N\n" +
            "  }\n" +
            "  else {\n" +
            "  c[i,j] <- c[i,j-1]\n" +
            "  b[i,j] <- W\n" +
            " }";
    public static final String mcmalgo="Matrix-Chain(array p[1 .. n], int n) {\n" +
            "Array s[1 .. n − 1, 2 .. n];\n" +
            "FOR i = 1 TO n DO m[i, i] = 0;\n" +
            "FOR L = 2 TO n DO {\n" +
            " FOR i = 1 TO n − L + 1 do {\n" +
            "  j = i + L − 1;\n" +
            "  m[i, j] = infinity;\n" +
            "  FOR k = i TO j − 1 DO {\n" +
            "   q = m[i, k] + m[k + 1, j] + p[i − 1] p[k] p[j];\n" +
            "   IF (q < m[i, j]) {\n" +
            "    m[i, j] = q;\n" +
            "    s[i, j] = k;\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "return m[1, n](final cost) and s (splitting markers);\n" +
            "}";
}
