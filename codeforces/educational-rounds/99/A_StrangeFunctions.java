import java.io.*;

public final class A_StrangeFunctions {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String ip = br.readLine();
            System.out.println(ip.length());
        }
    }
}
