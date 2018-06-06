

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Matrix {

    public  static  void main(String args[]) throws Exception
    {

     Scanner sc = new Scanner(System.in);
     int nrow = sc.nextInt();
     int mcol = sc.nextInt();
     int [][] a = new int[nrow][mcol];
     int [] [] dp = new int[nrow][mcol];

        for(int i=0;i<nrow;i++)
     {
         for(int j=0;j<mcol;j++)
         {
            a[i][j] = sc.nextInt();
         }
     }

    int query=sc.nextInt();

        ArrayList<ArrayList<Integer>> Q = new ArrayList<ArrayList<Integer>>();


        for(int i=0;i<query;i++)
        {
            ArrayList<Integer> XY = new ArrayList<Integer>();
            for(int j=0;j<2;j++)
            {
                XY.add(sc.nextInt());
            }
            Q.add(XY);
        }
      // System.out.println(Q);
        dp[0][0]=a[0][0];
        for(int i=1;i<nrow;i++)
        {
            dp[i][0]=a[i][0]+dp[i-1][0];
        }
        for(int j=1;j<mcol;j++)
        {
            dp[0][j]=a[0][j]+dp[0][j-1];
        }

        for(int k=0;k<nrow;k++)
        {
            for(int l=0;l<mcol;l++)
            {
                //System.out.print(dp[k][l]);
            }
           // System.out.println();
        }

        for(int i=1;i<nrow;i++)
        {
            for(int j=1;j<mcol;j++)
            {
               dp[i][j] = dp[i][j-1]+dp[i-1][j]+a[i][j]-dp[i-1][j-1];
            }
        }
for(int k=0;k<nrow;k++)
{
    for(int l=0;l<mcol;l++)
    {
       // System.out.print(dp[k][l]+ "  ");
    }
    //System.out.println();
}
     int result=0;
     for(int k=0;k<query;k++)
     {
         result=0;
         ArrayList<Integer> coordinates = new ArrayList<Integer>();
         coordinates=Q.get(k);
         int X=coordinates.get(0);
         int Y=coordinates.get(1);

         System.out.println(dp[X-1][Y-1]);
     }
    }


}
