function solution(jobs) {
  const n = jobs.length;
  let time = 0;
  let jobTime = 0;
  const queue = [];
  jobs.sort((a, b) => a[0] - b[0]);
  while (jobs.length !== 0 || queue.length !== 0) {
    while (jobs.length > 0) {
      if (jobs.length > 0 && jobs[0][0] <= time) {
        queue.push(jobs.shift());
      } else {
        break;
      }
    }

    if (queue.length > 0) {
      queue.sort((a, b) => a[1] - b[1]);
      const tmp = queue.shift();
      time += tmp[1];
      jobTime += time - tmp[0];
    } else if (jobs.length > 0) {
      time = jobs[0][0];
    }
  }
  return Math.floor(jobTime / n);
}

console.log(
  solution([
    [0, 3],
    [1, 9],
    [2, 6],
  ])
);
