import java.io.*;

public final class B_Jumps {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int ans = solve(x);
            System.out.printf("%d\n", ans);
        }
    }

    static int solve(int x) {
        int jumps = 0;
        while (jumps * (jumps + 1) / 2 < x) jumps++;
        if (x == jumps * (jumps + 1) / 2 - 1) jumps++;
        return jumps;
    }
}
