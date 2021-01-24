from collections import defaultdict, Counter
from functools import reduce


class Solution:
    def minimumTeachings(self, n, languages, friendships):
        languages = list(map(set, languages))

        # If two friends don't know the same language,
        # teach them one
        to_teach = set()

        for [u, v] in friendships:
            u -= 1
            v -= 1

            if languages[u].isdisjoint(languages[v]):
                to_teach.add(u)
                to_teach.add(v)

        if len(to_teach) == 0:
            return 0

        # Find the best language to teach
        known_languages = defaultdict(int)
        for user in to_teach:
            for language in languages[user]:
                known_languages[language] += 1

        most_known_language_count = max(known_languages.values())
        return len(to_teach) - most_known_language_count

    def minimalTeachings_pythonic(self, n, languages, friendships):
        languages = list(map(set, languages))
        to_teach = set(user - 1
                       for f in friendships
                       if languages[f[0] - 1].isdisjoint(languages[f[1] - 1])
                       for user in f)

        if len(to_teach) == 0:
            return 0

        known_languages = Counter(l
                                  for u in to_teach
                                  for l in languages[u])

        return len(to_teach) - max(known_languages.values())

    def minimalTeachings_functional(self, n, languages, friendships):
        languages = list(map(set, languages))
        cant_communicate = list(filter(
            lambda f: languages[f[0] - 1].isdisjoint(languages[f[1] - 1]),
            friendships
        ))
        to_teach = reduce(lambda x, y: x + y, cant_communicate, [])
        to_teach = set(map(lambda x: x - 1, to_teach))

        if len(to_teach) == 0:
            return 0

        known_languages = Counter(reduce(
            lambda x, y: x + y,
            list(map(lambda x: list(languages[x]), to_teach)),
            []))

        return len(to_teach) - max(known_languages.values())
