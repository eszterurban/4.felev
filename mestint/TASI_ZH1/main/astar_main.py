import sys
sys.path.append('')

from libs.node import Node 
from libs.search import astar_search
from libs.nqueens import NQueens
from libs.search import depth_first_graph_search
tmp = [Node((3,2,-1,-1)), Node((3,-1,-1,-1)), Node((1,2,-1,0))]

def sort_by_heur(items):
    return sorted(items,key = lambda x: sum(x.state))

#print(sort_by_heur(tmp))
nq = NQueens(8)
print(nq.initial,nq.goal)
print(astar_search(nq,sort_by_heur))