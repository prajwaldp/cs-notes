import java.io.*;

public final class C_PingPong {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] xy = br.readLine().split("\\s");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            System.out.printf("%d %d\n", x - 1, y);
        }
    }
}
