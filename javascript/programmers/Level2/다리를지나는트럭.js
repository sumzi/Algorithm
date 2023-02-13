function solution(bridge_length, weight, truck_weights) {
  let time = 0;
  const stack = [];
  let stack_weight = 0;
  while (true) {
    time++;

    if (stack.length > 0 && stack[0][1] + bridge_length === time) {
      stack_weight -= stack[0][0];
      stack.shift();
    }
    if (stack_weight + truck_weights[0] <= weight) {
      stack_weight += truck_weights[0];
      stack.push([truck_weights.shift(), time]);
    }
    if (stack.length === 0 && truck_weights.length === 0) {
      break;
    }
  }
  return time;
}
console.log(solution(100, 100, [10]));
