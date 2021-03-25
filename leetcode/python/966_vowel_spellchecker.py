from collections import defaultdict


def _alter_case(c: str):
    return c.lower() if c.isupper() else c.upper()


def _is_vowel(c: str):
    return c in 'aeiouAEIOU'


class TrieNode:

    def __init__(self):
        self.word = ''
        self.children = defaultdict(TrieNode)
        self.is_end = False

    def insert(self, word):
        self._insert(word, 0)

    def check(self, query):
        return self._check(query, 0, '')

    def _insert(self, word, idx):
        if idx == len(word):
            self.is_end = True
            return

        self.children[word[idx]]._insert(word, idx + 1)

    def _check(self, query, idx, word):
        if idx == len(query):
            return self.is_end, word

        if query[idx] in self.children:
            res = self.children[query[idx]]._check(
                query, idx + 1, word + query[idx])
            if res[0]:
                return res

        if _alter_case(query[idx]) in self.children:
            res = self.children[_alter_case(query[idx])]._check(
                query, idx + 1, word + _alter_case(query[idx]))
            if res[0]:
                return res

        if _is_vowel(query[idx]):
            for v in 'aeiouAEIOU':
                if v != query[idx]:
                    res = self.children[v]._check(query, idx + 1, word + v)
                    if res[0]:
                        return res

        return False, ''


class Solution:
    # Does not pass testcases
    # Should return the first match from the wordlist
    # This solution returns the "best" match from the wordlist
    def spellcheckeralt(self, wordlist, queries):
        root = TrieNode()
        for word in wordlist:
            root.insert(word)

        return [result[1] if result[0] else ''
                for result in map(root.check, queries)]

    def spellchecker(self, wordlist, queries):
        def _masked(word):
            return ''.join('*' if c in 'aeiou' else c
                           for c in word.lower())

        d0 = set(wordlist)
        d1 = {w.lower(): w for w in wordlist[::-1]}
        d2 = {_masked(w): w for w in wordlist[::-1]}

        ret = []
        for word in queries:
            if word in d0:
                ret.append(word)
            elif word.lower() in d1:
                ret.append(d1[word.lower()])
            elif _masked[word] in d2:
                ret.append(d2[_masked(word)])
            else:
                ret.append('')

        return ret
