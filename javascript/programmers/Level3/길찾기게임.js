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
