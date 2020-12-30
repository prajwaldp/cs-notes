import java.io.*;

public final class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] reds = new int[n];
            String[] redVals = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                reds[i] = Integer.parseInt(redVals[i]);
            }
            int m = Integer.parseInt(br.readLine());
            int[] blues = new int[m];
            String[] blueVals = br.readLine().split("\\s");
            for (int i = 0; i < m; i++) {
                blues[i] = Integer.parseInt(blueVals[i]);
            }

            int redSum = 0;
            int blueSum = 0;

            int ans = 0;

            for (int i = 0; i <= n; i++) {
                blueSum = redSum;
                for (int j = 0; j < m; j++) {
                    blueSum += blues[j];
                    ans = Math.max(ans, blueSum);
                }
                if (i != n)
                    redSum += reds[i];
            }

            System.out.println(ans);
        }
    }
}

