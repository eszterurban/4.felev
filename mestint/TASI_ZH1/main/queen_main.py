import sys
sys.path.append('')

from libs.nqueens import NQueens
from libs.search import *

nq4 = NQueens(8)
#print(nq4.initial,nq4.goal)
#trial_error(nq4)

print(nq4.initial,nq4.goal)
#print(breadth_first_tree_search(nq4))
print(depth_first_graph_search(nq4))