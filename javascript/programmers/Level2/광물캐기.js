const MAP = {
    diamond:[1,5,25],
    iron:[1,1,5],
    stone:[1,1,1]
}
function solution(picks, minerals) {
    const n = minerals.length;
    let answer = 10000;
    
    const DFS = (arr,index, sum) => {
        if(index===n || arr.reduce((acc,cur)=>acc+cur)===0){
            answer=Math.min(answer,sum);
            return;
        }
        const last = Math.min(index+5,n);
        
        for(let i=0;i<3;i++){
            if(!arr[i]) continue;
            let result = 0;
            arr[i]--;
            for(let j=index;j<last;j++){
                result+=MAP[minerals[j]][i];
            }
            DFS([...arr],last,sum+result);
            arr[i]++;
        }
        
    }
    DFS([...picks],0,0);
    return answer;
}