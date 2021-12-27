function solution(arr) {
    return arr.reduce((acc,cur,idx)=>acc+=cur)/arr.length;
}