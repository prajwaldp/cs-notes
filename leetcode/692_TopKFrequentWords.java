class Word {
    public String word;
    public int count;
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        List<Word> wordList = new ArrayList<>();
        for (String w: freq.keySet()) {
            wordList.add(new Word(w, freq.get(w)));
        }
        PriorityQueue<Word> maxHeap = new PriorityQueue<>((x, y) -> {
            if (x.count == y.count) {
                return x.word.compareTo(y.word);
            }
            return y.count - x.count;
        });

        for (Word w: wordList) {
            maxHeap.offer(w);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(maxHeap.poll().word);
        }
        return ans;
    }
}