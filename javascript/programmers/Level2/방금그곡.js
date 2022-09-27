function solution(m, musicinfos) {
  const answer = [0, "(None)"];
  const changeNumber = (music) => {
    return music
      .replace(/(C#)/g, "c")
      .replace(/(D#)/g, "d")
      .replace(/(F#)/g, "f")
      .replace(/(G#)/g, "g")
      .replace(/(A#)/g, "a");
  };
  const diffTime = (s, e) => {
    const [sh, sm] = s.split(":");
    const [eh, em] = e.split(":");
    return +eh * 60 + +em - (+sh * 60 + +sm);
  };
  m = changeNumber(m);
  const mlen = m.length;

  musicinfos.forEach((music) => {
    const [start, end, title, code] = music.split(",");
    const time = diffTime(start, end);

    const c = changeNumber(code);
    const clen = c.length;
    for (let i = 0; i <= time - mlen; i++) {
      let flag = true;
      for (let j = 0; j < mlen; j++) {
        if (c[(i + j) % clen] != m[j]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        if (answer[0] < time) {
          answer[0] = time;
          answer[1] = title;
        }
      }
    }
  });
  return answer[1];
}
