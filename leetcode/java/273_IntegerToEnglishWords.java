import java.util.*;

class Solution {

  final static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  final static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  public String numberToWords(int num) {
    StringBuilder res = new StringBuilder();

    if (num == 0) {
      return "Zero";
    }

    Map<Integer, String> money = new HashMap<>(); // TODO Rename variable
    money.put(1000000000, "Billion");
    money.put(1000000, "Million");
    money.put(1000, "Thousand");

    for (int divider = 1000000000; divider > 0; divider /= 1000) {
      if (num >= divider) {
        res.append(getStringFrom3DigitNumber(num / divider));
        if (divider >= 1000) {
          res.append(" ");
          res.append(money.get(divider));
        }
        if (num % divider > 0) {
          res.append(" ");
        }
      }
      num %= divider;
    }

    return res.toString();
  }

  private String getStringFrom3DigitNumber(int num) {
    StringBuilder sb = new StringBuilder();
    if (num >= 100) {
      sb.append(ones[num / 100]);
      sb.append(" Hundred");
      if (num % 100 > 0) {
        sb.append(" ");
      }
    }

    num %= 100;

    if (num >= 20) {
      sb.append(tens[num / 10]);
      num %= 10;

      if (num > 0) {
        sb.append(" ");
      }
    }

    if (num > 0) {
      sb.append(ones[num]);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] testcases = {123, 12345, 1234567, 1234567891, 1234567890, 1234567800, 123000,
      19, 1000, 2000000, 2000000000, 119, 1000001};
    for (int tc: testcases) {
      System.out.printf("%d = \"%s\"\n", tc, s.numberToWords(tc));
    }
  }
}