import numpy as np
from ai.node import Node
from collections import deque

def trial_error(problem):
    state = Node(problem.initial)

    while True:
        if problem.goal_test(state.state):
            return state
 
        succesors=state.expand(problem)
        if len(succesors)==0:
            return 'Unsolvable'

        state=succesors[np.random.randint(0,len(succesors))]
        print(state.state)

def hill_climbing_for_3Cup(problem, heuristic):
    state = Node(problem.initial)

    while True:
        if problem.goal_test(state.state):
            return state

        succesors=state.expand(problem)

        test_succesors=[]
        for s_test in succesors:
            if heuristic(state.state)>=heuristic(s_test.state):
                test_succesors.append(s_test)

        if len(test_succesors)==0:
            return 'Unsolvable'

        state=test_succesors[np.random.randint(0,len(test_succesors))]
        print(state.state)

def breadth_first_tree_search(problem):
  frontier = deque([Node(problem.initial)])

  while frontier:
    node = frontier.popleft()

    if problem.goal_test(node.state):
      return node
    
    frontier.extend(node.expand(problem))
    print(node.state)

def depth_first_graph_search(problem):
  frontier = [(Node(problem.initial))]

  explored = set()

  while frontier:
    node = frontier.pop()
    if problem.goal_test(node.state):
      return node
    explored.add(node.state)
    frontier.extend(child for child in node.expand(problem) 
    if child.state not in explored and child not in frontier)
    print(node.state)

def best_first_graph_search(problem, f):
  node = Node(problem.initial)
  frontier=[]
  frontier.append(node)
  explored=set()
  while frontier:
    node = frontier.pop()
    if problem.goal_test(node.state):
      return node
    explored.add(node.state)

    for child in node.expand(problem):
      if child.state not in explored and child not in frontier:
        frontier.append(child)
      
      frontier= f(frontier)
      print(node.state)

def astar_search(problem, f=None):
  return best_first_graph_search(problem,f)