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

function solution(skill, skill_trees) {
  let answer = 0;
  const skill_list = {};
  [...skill].forEach((s, i) => (skill_list[s] = i));
  skill_trees.forEach((skill) => {
    let level = 0;
    const isLearn = [...skill].every((cur) => {
      const target = skill_list[cur];
      if (target > level) return false;
      else if (target === level) level++;
      return true;
    });
    if (isLearn) answer++;
  });
  return answer;
}
