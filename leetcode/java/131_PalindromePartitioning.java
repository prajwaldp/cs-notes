class Solution {
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    private void partitionHelper(String s, int pos, List<List<String>> res, List<String> curr) {
        int len = s.length();
        if (pos == len) {
            List<String> currCopy = new ArrayList<>();
            currCopy.addAll(curr);
            res.add(currCopy);
            return;
        }

        for (int i = pos; i < len; i++) {
            if (i == pos || isPalindrome(s, pos, i)) {
                curr.add(s.substring(pos, i + 1));
                partitionHelper(s, i + 1, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelper(s, 0, res, new ArrayList<>());
        return res;
    }
}
