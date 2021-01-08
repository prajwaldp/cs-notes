class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String nstr = Integer.toString(n);
        int nlen = nstr.length();
        int ndigits = digits.length;
        int count;

        count = countNumsWithLesserDigits(nlen, ndigits) + countNumsWithSameDigits(nstr, digits);
        return count;
    }

    private int countNumsWithLesserDigits(int nlen, int ndigits) {
        int count = 0;
        for (int i = 1; i < nlen; i++) {
            // Count the numbers with i digits
            count += Math.pow(ndigits, i);
        }
        return count;
    }

    private int countNumsWithSameDigits(String nstr, String[] digits) {
        int count = 0;
        int nlen = nstr.length();
        
        // for (String digit: digits) {
        //     if (digit.charAt(0) < nstr.charAt(0)) {
        //         count += Math.pow(digits.length, nlen - 1);
        //     } else if (digit.charAt(0) == nstr.charAt(0)) {
        //         if (nstr.length() == 1) {
        //             count++;
        //         } else {
        //             count += countNumsWithSameDigits(nstr.substring(1), digits);
        //         }
        //     }
        // }

        for (int i = 0; i < nlen; i++) {
            boolean isSameDigit = false;
            for (String digit: digits) {    
                if (digit.charAt(0) < nstr.charAt(i)) {
                    count += Math.pow(digits.length, nlen - 1);
                } else if (digit.charAt(0) == nstr.charAt(i)) {
                    // When `nstr` can be completely formed by the digits
                    // Alternatively return if !isSameDigit immediately instead of breaking
                    // And return count + 1 if that statement is never hit
                    if (i == nlen - 1) {
                        count++;
                    } else {
                        isSameDigit = true;
                    }

                }
            }
            if (!isSameDigit) {
                break;
            }
        }
        
        return count;
    }
}
