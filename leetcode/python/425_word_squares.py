"""
https://en.wikipedia.org/wiki/Word_square

Given a list of words, find all possible word squares
"""

class TrieNode:
    def __init__(self):
        self.prefix = []  # index of words that have prefix from root to current node
        self.children = [None] * 26


class Solution:
    def wordSquares(self, words: List[str]) -> List[List[str]]:
        n = len(words[0])  # There is at least one word
        root = self.__build_trie(words)

        def backtrack(row):
            if row == len(board):
                ans.append(board.copy())
                return

            curr = root
            for i in range(row):
                ch_int = ord(board[i][row]) - ord('a')
                if curr.children[ch_int] is None:
                    return
                curr = curr.children[ch_int]

            for word_idx in curr.prefix:
                board[row] = words[word_idx]
                backtrack(row + 1)

        ans = []
        board = [None] * n
        for word in words:
            board[0] = word
            backtrack(1)
        return ans

    def __build_trie(self, words: List[str]) -> TrieNode:
        root = TrieNode()

        for word_idx, word in enumerate(words):
            curr = root

            for ch in word:
                ch_int = ord(ch) - ord('a')
                if curr.children[ch_int] is None:
                    curr.children[ch_int] = TrieNode()
                curr = curr.children[ch_int]
                curr.prefix.append(word_idx)

        return root
