function hasAllCodes(s: string, k: number): boolean {
  let set = new Set();
  
  for (let i = 0; i <= s.length - k; i++) {
    set.add(s.slice(i, i + k));
  }
  
  return set.size == 1 << k;
};

function hasAllCodesAlt(s: string, k: number): boolean {
  let set = new Set();
  let xor = 0;
  let zeroExits = false;
  
  for (let i = 1; i < Math.pow(2, k); i++)
    xor ^= i;
  
  for (let i = 0; i <= s.length - k; i++) {
    let substr = s.slice(i, i + k);
    
    if (!set.has(substr)) {
      set.add(substr);
      let num = parseInt(substr, 2);
      xor ^= num;
      if (num == 0) zeroExits = true;
    }
  }
  
  return xor === 0 && zeroExits;
};
