class Solution {
    public boolean checkValidString(String s) {
        int minUnclosedOpen = 0;
        int maxUnclosedOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                minUnclosedOpen++;
                maxUnclosedOpen++;
            } else if (ch == ')') {
                minUnclosedOpen--;
                maxUnclosedOpen--;
            } else {
                assert ch == '*';
                minUnclosedOpen--;
                maxUnclosedOpen++;
            }

            if (maxUnclosedOpen < 0) {
                return false;
            }

            minUnclosedOpen = Math.max(minUnclosedOpen, 0);
        }
        return minUnclosedOpen == 0;
    }
}