function solution(skill, skill_trees) {
  let answer = 0;
  skill_trees.forEach((skill_tree) => {
    let index = 0;
    let flag = true;
    for (let i = 0; i < skill_tree.length; i++) {
      if (skill.includes(skill_tree[i])) {
        if (skill_tree[i] === skill[index]) {
          index++;
        } else {
          flag = false;
          break;
        }
      }
    }
    if (flag) answer++;
  });
  return answer;
}
