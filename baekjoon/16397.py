def bfs():
    q=[n]
    arr[n]=0

    while q:
        x=q.pop(0)
        y=arr[x]
        if y>t:
            print('ANG')
            return
        if x==g:
            print(y)
            return
        
        if 0<=(x+1)<100000 and arr[x+1]==-1:
            q.append(x+1)
            arr[x+1]=y+1
        if x!=0 and 0<=(x*2)<100000:
            tmp=list(str(x*2))
            tmp[0]=str(int(tmp[0])-1)
            nx=int(''.join(tmp))
            if arr[nx]==-1:
                q.append(nx)
                arr[nx]=y+1
    print('ANG')

n,t,g=map(int,input().split())
arr=[-1]*100000
bfs()