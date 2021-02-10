vowel=['a','e','i','o','u']
res=[]
def dfs(num,code,a,b):
    if len(code)==l:
        if a>=1 and b>=2:
            res.append(code)
            return
    if num==c:
        return 
    dfs(num+1,code,a,b)
    if arr[num] in vowel:
        a+=1
    else: 
        b+=1
    dfs(num+1,code+arr[num],a,b)
    
l,c=map(int,input().split())
arr=list(input().split())
arr.sort()
dfs(0,'',0,0)
res.sort()
for i in res:
    print(i)