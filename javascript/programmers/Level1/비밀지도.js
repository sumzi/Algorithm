function solution(n, arr1, arr2) {
  var answer = [];
  arr1 = arr1.map((arr) => arr.toString(2).padStart(n, "0"));
  arr2 = arr2.map((arr) => arr.toString(2).padStart(n, "0"));
  for (let i = 0; i < n; i++) {
    let tmp = "";
    for (let j = 0; j < n; j++) {
      tmp += arr1[i][j] === "1" || arr2[i][j] === "1" ? "#" : " ";
    }
    answer.push(tmp);
  }
  return answer;
}
