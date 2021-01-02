class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> idxInPieces = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            idxInPieces.put(pieces[i][0], i);
        }
        
        int i = 0, j;
        int[] match;
        
        while (i < arr.length) {
            if (!idxInPieces.containsKey(arr[i])) {
                return false;
            }

            match = pieces[idxInPieces.get(arr[i])];
            j = 0;
            
            while (j + 1 < match.length) {
                if (i + 2 == pieces.length || arr[++i] != match[++j]) {
                    return false;
                }
            }
        }

        return true;
    }
}