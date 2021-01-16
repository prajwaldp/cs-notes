from collections import defaultdict


def same_shift_seq(strings):
    patterns = defaultdict(list)
    for s in strings:
        pattern = map(
            lambda i: ord(s[i]) - ord(s[i - 1]),
            range(1, len(s))
        )
        pattern = map(lambda x: x if x > 0 else 26 + x, pattern)
        pattern = map(str, pattern)
        patterns[''.join(pattern)].append(s)

    return patterns.values()

print(same_shift_seq(["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]))

"""
Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output:
[
    ["abc","bcd","xyz"],
    ["az","ba"],
    ["acef"],
    ["a","z"]
]
"""