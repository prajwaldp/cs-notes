import java.io.*;

final public class D_SequencesAndSwaps {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            String[] line1 = br.readLine().split("\\s");
            String[] line2 = br.readLine().split("\\s");

            int x = Integer.parseInt(line1[1]);
            int n = line2.length;
            int[] arr = new int[n];

            int last = -1;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line2[i]);
                if (i > 0 && arr[i] > arr[i - 1]) last = i;
            }

            int count = 0;
            boolean sorted = true;
            
            for (int i = 0; i <= last; i++) {
                if (arr[i] > x) {
                    int tmp = arr[i];
                    arr[i] = x;
                    x = tmp;
                    count++;
                }
                if (i > 0 && arr[i] < arr[i - 1]) {
                    System.out.println("-1");
                    sorted = false;
                    break;
                }
            }
            if (sorted) System.out.println(count);
        }
    }
}