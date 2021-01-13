class Solution {
  public int numRescueBoats(int[] people, int limit) {
    int n = people.length;

    Arrays.sort(people);
    int lo = 0;
    int hi = n - 1;

    int numBoats = 0;
    int weight = 0;
    int count = 0;

    while (lo <= hi) {
      while (lo <= hi && count < 2 && people[hi] + weight <= limit) {
        weight += people[hi];
        hi--;
        count++;
      }
      while (lo <= hi && count < 2 && people[lo] + weight <= limit) {
        weight += people[lo];
        lo++;
        count++;
      }

      numBoats++;
      weight = 0;
      count = 0;
    }

    return numBoats;
  }
}

/*
Alternate solution: A max of 2 people per boat are allowed.
The next heaviest person has to go.
That person can or can not share the boat with the next lightest person.

My previous solution did not make use of the max 2 people per boat fact.
Does it work for an arbitrary count?

Proof by contradiction:
=======================

Suppose in the greedy solution,
m = number of pairs
n = number of singles
|boats| = m + n
|poeple| = 2*m + n

Suppose there is an optimal solution that is not the above greedy solution,
u = number of pairs
v = number of singles
|boats| = u + v
|poeple| = 2*u + v

As assumed,
u + v < m + n
But 2*m + n = 2*u + v
=> m + (m + n) = u + (u + v)
=> Since m + n > u + v, m < u
This is a contradiction
*/

class SolutionAlt {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int i = 0;
    int j = people.length - 1;
    for(; i <= j; --j) {
      if (people[i] + people[j] <= limit) {
        i++;
      }
    }
    return people.length - 1 - j;
  }
}
