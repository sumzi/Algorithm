function solution(phone_number) {
  const n = phone_number.length;
  return "*".repeat(n - 4) + phone_number.substr(n - 4, 4);
}
