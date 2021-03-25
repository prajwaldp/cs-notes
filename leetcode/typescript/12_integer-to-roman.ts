function intToRoman(num: number): string  {
  let values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  let keys = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];

  let roman = "";

  for (let i = 0; i <= 12; i++) {
    while (num >= values[i]) {
      roman += keys[i];
      num -= values[i];
    }
  }

  return roman;
}
