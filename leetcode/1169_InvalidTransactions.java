class Solution {
  public List<String> invalidTransactions(String[] transactions) {
    int n = transactions.length;
    String[] name = new String[n];
    int[] time = new int[n];
    int[] amount = new int[n];
    String[] city = new String[n];

    boolean[] invalid = new boolean[n];

    for (int i = 0; i < n; i++) {
      String t = transactions[i];
      String[] split = t.split(",");

      name[i] = split[0];
      time[i] = Integer.parseInt(split[1]);
      amount[i] = Integer.parseInt(split[2]);
      city[i] = split[3];
    }

    for (int i = 0; i < n; i++) {
      if (amount[i] > 1000) {
        invalid[i] = true;
      }
      for (int j = i + 1; j < n; j++) {
        if (name[i].equals(name[j]) &&
            !city[i].equals(city[j]) &&
            Math.abs(time[i] - time[j]) <= 60) {

          invalid[i] = true;
          invalid[j] = true;
        }
      }
    }

    List<String> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (invalid[i]) {
        res.add(transactions[i]);
      }
    }

    return res;
  }
}

class SolutionAlt {
  static class Transaction {
    public int id;
    public int amount;
    public int time;
    public String city;

    public Transaction(int id, String t) {
      String[] split = t.split(",");

      this.id = id;
      this.time = Integer.parseInt(split[1]);
      this.amount = Integer.parseInt(split[2]);
      this.city = split[3];
    }

    public String toString() {
      return String.format("<%d, %d, %d, %s>", id, time, amount, city);
    }
  }

  public List<String> invalidTransactions(String[] transactions) {
    Map<String, List<Transaction>> txns = new HashMap<>();
    int n = transactions.length;
    for (int i = 0; i < n; i++) {
      String t = transactions[i];
      String name = t.split(",")[0];
      txns.putIfAbsent(name, new ArrayList<>());
      txns.get(name).add(new Transaction(i, t));
    }

    boolean[] invalid = new boolean[n];
    List<String> res = new ArrayList<>();

    for (String name: txns.keySet()) {
      List<Transaction> userTxns = txns.get(name);
      Collections.sort(userTxns, (a, b) -> a.time - b.time);

      int j = 0;
      for (int i = 0; i < userTxns.size(); i++) {
        Transaction t = userTxns.get(i);

        if (t.amount > 1000) {
          invalid[t.id] = true;
        }

        int k;

        for (k = j; k < i; k++) {
          Transaction tk = userTxns.get(k);
          if (t.time - tk.time > 60) {
            j = k;
            continue;
          }
          if (!t.city.equals(tk.city)) {
            invalid[t.id] = true;
            invalid[tk.id] = true;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (invalid[i]) {
        res.add(transactions[i]);
      }
    }

    return res;
  }
}