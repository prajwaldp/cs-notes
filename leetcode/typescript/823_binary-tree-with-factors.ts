const MOD = Math.pow(10, 9) + 7;

function numFactoredBinaryTrees(arr: number[]): number {
  arr.sort((i, j) => i - j);
  let map = new Map();
  let count: number;

  map.set(arr[0], 1);
  for (let i = 1; i < arr.length; i++) {
    count = 1;
    for (let n of map.keys()) {
      if (arr[i] % n == 0 && map.has(Math.floor(arr[i] / n))) {
        count += map.get(n) * map.get(Math.floor(arr[i] / n));
      }
    }

    map.set(arr[i], count);
  }
  let sum = 0
  for (let c of map.values()) {
    sum = (sum + c) % MOD;
  }
  return sum;
};
