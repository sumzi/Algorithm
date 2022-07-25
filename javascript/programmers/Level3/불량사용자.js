function solution(user_id, banned_id) {
  const n = user_id.length;
  const m = banned_id.length;
  const isBanned = [];

  user_id.forEach((user) => {
    const tmp = [];
    const a = user.length;
    banned_id.forEach((banned) => {
      const b = banned.length;
      if (a != b) tmp.push(0);
      else {
        let flag = true;
        for (let i = 0; i < a; i++) {
          if (banned[i] != "*" && user[i] != banned[i]) {
            flag = false;
            break;
          }
        }
        tmp.push(flag ? 1 : 0);
      }
    });
    isBanned.push(tmp);
  });
  const answer = [];
  const visited = Array(n).fill(0);
  const permutation = (cnt, arr) => {
    if (m === cnt) {
      arr.sort();
      answer.push(arr.join(""));
      return;
    }
    for (let i = 0; i < n; i++) {
      if (!visited[i] && isBanned[i][cnt]) {
        visited[i] = 1;
        permutation(cnt + 1, arr.concat(user_id[i]));
        visited[i] = 0;
      }
    }
  };
  permutation(0, []);
  return new Set(answer).size;
}
console.log(
  solution(
    ["frodo", "fradi", "crodo", "abc123", "frodoc"],
    ["*rodo", "*rodo", "******"]
  )
);
