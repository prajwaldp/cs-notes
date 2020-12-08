## Standard Library

### Java BigInteger

Initializing

```java
import java.math.BigInteger;

BigInteger bits1 = new BigInteger("1"); // No Integer Constructor
// or
BigInteger bits2 = new BigInteger(new byte[] {1});

bits1.setBit(1);
boolean isBit1Set = bits1.testBit(1);

boolean and = bits1.and(bits2); // logical operators
BigInteger leftShifted = bits.shiftLeft(10); // left shifting
```

### C++ BitSet

```cpp
const int SIZE = 100; // some size, not dynammic like boost::dynamic_bitset
bitset<SIZE> bits(1); // The first bit is set to 1; yay!

bits |= bits << 10; // common bitset operation
bool is_bit10_set = bits[10]; // accessing is like arrays; yay!
```

### Java BitSet

```java
BitSet bits = new BitSet();
bits.set(0);

// No shift operators, have to use get()
```

## Code Tricks

### Getting pairs:

Ref: leetcode 1010 - number of pairs whose sum is divisible by 60
Getting the number of possible pairs does not have to be `nChoose2(n)`
