import java.io.*;

public final class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String ip = br.readLine();
            int n = ip.length();
            if (ip.charAt(0) == ')' || ip.charAt(n - 1) == '(' || n % 2 == 1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
