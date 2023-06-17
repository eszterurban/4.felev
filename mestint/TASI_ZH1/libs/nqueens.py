import sys
sys.path.append('')

from libs.problem import Problem

class NQueens(Problem):
    
    def __init__(self, N):
        super().__init__(tuple([-1] * N))
        self.N = N
    
    def actions(self, state):
        #a bal szélső üres oszlopban próbálja ki az összes nem ütköző sort
        if state[-1] != -1:
            return [] #minden oszlop kitoltve
        else:
            col = state.index(-1)
            return [ row for row in range(self.N) if not self.conflicated(state,row,col)]
    
    def result(self,state,row):
        #helyezz a kovetkezo királynot a megadott sorba
        col = state.index(-1)
        new = list(state[:])
        new[col] = row
        return tuple(new)
    
    def conflicated(self,state,row,col):
        #egy kiralyno elhelyezése (sor,oszlop) ütközik?
        return any(self.conflict(row, col, state[c], c) for c in range(col))
    
    def conflict(slef,row1,col1,row2,col2):
        #ütkozesbe kerülne két kiralyno elhelyezése 
        return (row1 == row2 or #ugyanabban a sorban
                col1 == col2 or #ugyanabban az oszlopban
                row1-col1 == row2-col2 or #ugyanabban az átlóban \ irany
                row1 + col1 == row2 + col2) #ugyanbabban az álóban / irany 

    def goal_test(self, state):
        #ellenorizze, hogy minden oszlop megtel-e és nincs utkozes
        if state[-1] == -1:
            return False
        return not any(self.conflicated(state,state[col],col) for col in range(len(state)))
    
    

