class Solution {
    public String getSmallestString(int n, int k) {
        /*
        carry = k - 5
        
        if carry < 25:
            just add it to the current idx
        else:
            add z to the current idx
            make idx = idx - 1
            subtract 25 from carry
        */
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        
        int carry = k - n;
        int idx = n - 1;
        
        while (true) {
            if (carry - 25 > 0) {
                sb.setCharAt(idx, 'z');
                carry -= 25;
                idx -= 1;
            } else {
                sb.setCharAt(idx, (char)('a' + carry));
                break;
            }
        }
        
        return sb.toString();
    }
}