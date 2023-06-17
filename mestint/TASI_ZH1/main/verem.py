import sys
sys.path.append('')

from libs.search import depth_first_graph_search
from libs.hano import Hanoi
stack = [1,2,3,4]
for i in range(2):
    print(stack.pop())

h = Hanoi(3)
print(h.size,h.initial,h.goal)
print(depth_first_graph_search(h).solution())