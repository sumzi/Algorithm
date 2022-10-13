// function solution(nodeinfo) {
//   const answer = [[], []];
//   const n = nodeinfo.length;
//   let root = null,
//     w = 0,
//     h = 0;
//   const nodes = nodeinfo.map((node, i) => {
//     const newNode = [...node, i + 1];
//     w = Math.max(w, node[0]);
//     if (h < node[1]) {
//       h = node[1];
//       root = newNode;
//     }
//     return newNode;
//   });
//   const arr = Array.from(new Array(h + 1), () => []);
//   nodes.forEach((node) => {
//     arr[node[1]].push(node[2]);
//   });
//   const tree = Array.from(new Array(n + 1), () => new Array(2).fill(0));
//   const makeTree = (cur, l, r) => {
//     const [x, y] = nodeinfo[cur - 1];
//     for (let i = y - 1; i >= 0; i--) {
//       if (arr[i].length > 0) {
//         arr[i].forEach((next) => {
//           const [nx, ny] = nodeinfo[next - 1];
//           if (l <= nx && nx <= r) {
//             if (nx < x) {
//               tree[cur][0] = next;
//               makeTree(next, l, x);
//             } else {
//               tree[cur][1] = next;
//               makeTree(next, x, r);
//             }
//           }
//         });
//         break;
//       }
//     }
//   };
//   makeTree(root[2], 0, w);
//   const pre = (cur) => {
//     const [l, r] = tree[cur];
//     answer[0].push(cur);
//     if (l) pre(l);
//     if (r) pre(r);
//   };
//   const post = (cur) => {
//     const [l, r] = tree[cur];
//     if (l) post(l);
//     if (r) post(r);
//     answer[1].push(cur);
//   };
//   pre(root[2]);
//   post(root[2]);
//   return answer;
// }

function solution(nodeinfo) {
  let root = null;
  let pre = [];
  let post = [];

  const Node = function (x, y, num) {
    this.x = x;
    this.y = y;
    this.num = num;
    this.left = null;
    this.right = null;
  };

  const preorder = (node) => {
    pre.push(node.num);
    if (node.left) preorder(node.left);
    if (node.right) preorder(node.right);
  };

  const postorder = (node) => {
    if (node.left) postorder(node.left);
    if (node.right) postorder(node.right);
    post.push(node.num);
  };

  const makeTree = (node, x, y, num) => {
    const dir = node.x > x ? "left" : "right";
    if (node[dir] === null) {
      node[dir] = new Node(x, y, num);
    } else {
      makeTree(node[dir], x, y, num);
    }
  };

  const nodes = nodeinfo.map((node, i) => [...node, i + 1]);
  nodes.sort((a, b) => b[1] - a[1]);
  root = new Node(...nodes[0]);
  nodes.shift();
  nodes.forEach((node) => makeTree(root, ...node));

  preorder(root);
  postorder(root);
  return [pre, post];
}

console.log(
  solution([
    [5, 3],
    [11, 5],
    [13, 3],
    [3, 5],
    [6, 1],
    [1, 3],
    [8, 6],
    [7, 2],
    [2, 2],
  ])
);
//[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
