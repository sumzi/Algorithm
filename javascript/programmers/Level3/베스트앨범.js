function solution(genres, plays) {
  const genre_list = {};
  const genre_play = new Map();
  genres.forEach((genre, index) => {
    const item = genre_list[genre];
    if (item) {
      item.push([plays[index], index]);
      genre_play.set(genre, genre_play.get(genre) + plays[index]);
    } else {
      genre_list[genre] = [[plays[index], index]];
      genre_play.set(genre, plays[index]);
    }
  });
  const bestAlbum = [];
  const genre_sort = [...genre_play].sort((a, b) => b[1] - a[1]);
  genre_sort.forEach(([genre, total]) => {
    const list = genre_list[genre].sort((a, b) => {
      if (a[0] === b[0]) {
        return a[1] - b[1];
      } else {
        return b[0] - a[0];
      }
    });
    for (let i = 0; i < Math.min(2, list.length); i++) {
      bestAlbum.push(list[i][1]);
    }
  });
  return bestAlbum;
}

console.log(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]));
