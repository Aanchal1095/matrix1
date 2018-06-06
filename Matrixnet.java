
import java.io.*;
public class Matrixnet {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            line = br.readLine();
            String[] s = line.split(" ");
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] sum = new int[n][m];
        sum[0][0] = a[0][0];
        for(int i = 1; i < n; i++){
            sum[i][0] = sum[i-1][0] + a[i][0];
        }

        for(int i = 1; i < m; i++){
            sum[0][i] = sum[0][i-1] + a[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                sum[i][j] = a[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
               System.out.print(sum[i][j]+ " ");
            }
            System.out.println();
        }

        line = br.readLine();
        int q = Integer.parseInt(line);
        for(int i = 0; i < q; i++){
            line = br.readLine();
            int x = Integer.parseInt(line.split(" ")[0]) - 1;
            int y = Integer.parseInt(line.split(" ")[1]) - 1;
            System.out.println(sum[x][y] + "");
        }
    }
}
