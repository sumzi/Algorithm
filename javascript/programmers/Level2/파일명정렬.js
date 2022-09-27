// 1. files 를 나눈다.
// 2. sort를 사용해서 정렬하기
// a,b 비교한 값이 0보다 크면  b를 a보다 낮은 인덱트로 소트함
// 0이면 그대로
// 0보다 작으면 b를 a뒤로

function solution(files) {
  // const numberText = (file) => {};
  files = files.map((file) => {
    let number = "";
    const len = file.length;
    const result = [file];
    for (let i = 0; i < len; i++) {
      console.log(file.charCodeAt(i));
      const code = file.charCodeAt(i);
      if (47 < code && code < 59) {
        if (number.length === 0) {
          result.push(file.slice(0, i));
        }
        number += file[i];
        if (len === i + 1) {
          result.push(+number);
        }
      } else {
        if (number) {
          result.push(+number);
          result.push(file.slice(i, len));
          break;
        }
      }
    }
    return result;
  });
  files.sort((a, b) => {
    const headA = a[1].toUpperCase();
    const headB = b[1].toUpperCase();
    if (headA === headB) {
      if (a[2] === b[2]) return 0;
      return a[2] < b[2] ? -1 : 1;
    }
    return headA < headB ? -1 : 1;
  });

  return files.map((file) => file[0]);
}
console.log(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]));
// ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
console.log(solution(["O00321", "O49qcGPHuRLR5FEfoO00321"]));
//	["O49qcGPHuRLR5FEfoO00321", "O00321"]
// 	["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
