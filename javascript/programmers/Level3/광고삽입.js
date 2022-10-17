function solution(play_time, adv_time, logs) {
  const toTime = (sec) => {
    const h = "0" + Math.floor(sec / 3600);
    const m = "0" + Math.floor((sec / 60) % 60);
    const s = "0" + Math.floor(sec % 60);
    return h.slice(-2) + ":" + m.slice(-2) + ":" + s.slice(-2);
  };

  const toNumber = (time) => {
    const [h, m, s] = time.split(":").map((x) => +x);
    return h * 3600 + m * 60 + s;
  };

  const play = toNumber(play_time);
  const adv = toNumber(adv_time);
  const arr = Array(play).fill(0);

  logs.forEach((log) => {
    const times = log.split("-");
    const [start, end] = times.map((time) => toNumber(time));
    arr[start]++;
    arr[end]--;
  });

  for (let i = 1; i < play; i++) {
    arr[i] += arr[i - 1];
  }
  for (let i = 1; i < play; i++) {
    arr[i] += arr[i - 1];
  }
  let sum = arr[adv - 1];
  let time = 0;
  for (let i = adv; i < play; i++) {
    if (sum < arr[i] - arr[i - adv]) {
      sum = arr[i] - arr[i - adv];
      time = i - adv + 1;
    }
  }
  return toTime(time);
}
