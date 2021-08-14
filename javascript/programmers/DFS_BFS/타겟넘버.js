function solution(numbers, target) {
    var answer = 0;
    function check(cnt, num) {
        if (cnt == numbers.length) {
            if (num == target) {
                answer++;
            }
            return;
        }
        check(cnt + 1, num - numbers[cnt]);
        check(cnt + 1, num + numbers[cnt]);
    }
    check(0, 0);
    return answer;
}
