import sys
sys.path.append('')
from collections import deque
from libs.search import breadth_first_tree_search
from libs.hano import Hanoi
from libs.haromkorso import Cup3

que = deque([1,2,3,4])
for i in range(2):
    print(que.popleft())
print(que)

breadth_first_tree_search(que)

#hanoi szeles
h = Hanoi(3)
print(h.size,h.initial,h.goal)
breadth_first_tree_search(h).solution()

#3korso
c = Cup3((5,0,0),[(4,1,0),(4,0,1)])
print(c.initial,c.goal)
breadth_first_tree_search(c).solution()