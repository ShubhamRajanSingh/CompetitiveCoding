
#N = int(input())
N=2
#raw_src = [input() for _ in range(N)]
#raw_des = [input() for _ in range(N)]
src, des = "WRBB", "RBBW"
#for i in range(N):
#    src += raw_src[i]
#    des += raw_des[i]
from collections import deque
class Sliders(object):
    def get_shortest_paths(self, n, src, des):
        
        def bfs(state, i, j):
            q= deque()
            q.append((state, i,j,''))
            if state == des:return 0
            seen = set()
            found = False
            res = []
            shortest_solution_depth = float('inf')
            while q:
                state, i, j, path = q.popleft()
                if len(path)>shortest_solution_depth:break
                if state == des:
                    found=True
                    shortest_solution_depth = len(path)
                    res.append(path)   
                seen.add(state)
                state = list(state)
                for moving, di, dj in [('U',1,0),('D',-1,0),('L',0,1),('R',0,-1)]:
                    r, c = i+di, j+dj
                    if not found and 0<=r<n and 0<=c<n:
                        new_state = state[:]
                        new_state[r*n+c], new_state[i*n+j] = state[i*n+j], state[r*n+c]
                        new_state = ''.join(new_state)
                        if new_state not in seen or new_state == des:
                            q.append((new_state, r, c, path+moving))
            if not res:return 0
            def get_checksum(res):
                fin_res = 0
                for r in set(res):
                    checksum = 0
                    for chr in r:
                        checksum *= 243
                        checksum += ord(chr)
                        checksum %= 100000007
                    fin_res += checksum
                    fin_res %= 100000007
                return fin_res
            return get_checksum(res)
        
        
        
        
        idx = src.index('W') 
        i, j = idx//n, idx%n     
        return bfs(src, i, j)
s = Sliders()

print(s.get_shortest_paths(N, src, des))