function solution(n, computers) {
    var answer = 0;
    let arr = Array.from({ length: n }, () => 0);

    function dfs(x) {
        arr[x] = 1;
        for (let i = 0; i < n; i++) {
            if (arr[i] === 0 && computers[x][i] === 1) {
                dfs(i);
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (arr[i] === 0) {
            dfs(i);
            answer++;
        }
    }
    return answer;
}