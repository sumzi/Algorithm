function solution(w, h) {
  function gcd(a, b) {
    let tmp;
    if (a < b) {
      tmp = a;
      a = b;
      b = tmp;
    }
    while (b) {
      tmp = a;
      a = b;
      b = tmp % a;
    }
    return a;
  }
  return w * h - (w + h - gcd(w, h));
}
