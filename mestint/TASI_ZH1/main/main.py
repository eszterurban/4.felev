"""
from libs.problem import Problem 
problem =  Problem((5,0,0),[(4,1,0),(4,0,1)])
print(problem.initial, problem.goal)
#----------------------------
from libs.node import Node
state1 = Node(3)
type(state1)
state2 = Node(state=3,parent=state1)
state2
#----------------------------
print(state1 is object)
if state1 > state2:
  print("state1 a nagyobb")
elif state1 < state2:
  print("state2 a nagyobb")
else:
  print("egyenlőek")


    
"""
