function solution(begin, target, words) {
    var answer = 51;
    let n = words.length;
    let m = begin.length;
    let arr = new Array(n);
    function check(word1, word2) {
        let cnt = 0;
        for (let i = 0; i < m; i++) {
            if (word1[i] !== word2[i]) cnt++;
        }
        if (cnt === 1) return true;
        return false;
    }
    function dfs(prev, cur, cnt) {
        if (words[cur] === target) {
            answer = Math.min(answer, cnt);
            return;
        }
        arr[cur] = 1;
        for (let i = 0; i < n; i++) {
            if (i === prev) continue;
            if (arr[i] === 0 && check(words[cur], words[i])) {
                dfs(cur, i, cnt + 1);
                arr[cur] = 0;
            }
        }
    }
    for (let i = 0; i < n; i++) {
        if (check(begin, words[i])) {
            arr.fill(0);
            dfs(-1, i, 1);
        }
    }
    if (answer === 51) {
        return 0;
    }
    return answer;
}
