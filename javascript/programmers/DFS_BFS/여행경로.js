function solution(tickets) {
    var answer = [];
    let n = tickets.length;
    let visited = Array(n).fill(false);
    tickets.sort();
    const dfs = (cur, cnt, path) => {
        if (cnt == n && answer.length === 0) {
            answer = path;
            return;
        }
        for (let i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0] === cur) {
                visited[i] = true;
                dfs(tickets[i][1], cnt + 1, [...path, tickets[i][1]]);
                visited[i] = false;
            }
        }
    };
    dfs("ICN", 0, ["ICN"]);
    return answer;
}
