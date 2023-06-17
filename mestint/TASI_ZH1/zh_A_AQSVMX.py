# coding: utf-8

# # 1. ZH A csoport - Összesen 10 pont - 90 perc áll rendelkezésre a megoldáshoz

# ## Azonosító adatok

# - NÉV: Tasnádi Attila
# - NEPTUN KÓD: AQSVMX

# ## Feladatok

# 1. (2 pont) Adja meg az alábbi probléma jellemzőit, illetve cél és kezdő állapotát:
# - Egy vödörben 12 liter vodkát kell elosztani két orosz paraszt Igor és Sasha között.
# - Igor jobban bírja az alkoholt ezért neki 8 liter-t kell adni amíg Sasha-nak 4 litert
# - Igornak 9 literes palackja van míg Sasha-nak csak 5 literes.

# In[ ]:


# Válasz helye. Válaszát szabályos python commentek között adja meg.
"""
Állapotok:
v = vödör
p(i) = palackok
p0 = {{0},{1}...{12}}
p1 = {{0},{1}...{9}}
p2 = {{0},{1}...{5}}
Azaz a p0-ban (vödörben) 0-tól 12 literig bármennyi vodka lehet,
p1-ben Igor vödrében csak 0-tól 9 literig lehet vodka, míg
Sasha vödrében csak 0-tól 5 literig lehet vodka

a0 - vödör
a1 - igor palackja
a2 - sasha palackja
Kező állapot
a0 = 12
a1 = 0
a2 = 0

Cél állapotok:
a0 = 0
a1 = 8
a2 = 4

Operátorok:
Lényegében az öntögetést jelenti, hogy egyik vödörből a palackba, palackból
vödörbe, és ezek bármely kombinációja, azon kitétellel, hogy
Igor palackjában nem lehet több mint 8 liter, illetve
Sasha palackjában nem lehet több mint 4 léter
"""

# ### Futassa le az alábbi segéd osztályokat

# In[ ]:


class Problem:
    def __init__(self, initial, goal=None):
        self.initial = initial
        self.goal = goal

    def actions(self, state):
        raise NotImplementedError

    def result(self, state, action):
        raise NotImplementedError

    def goal_test(self, state):
        if isinstance(self.goal, list):
            for s in self.goal:
                if s==state:
                    return True

            return False
        else:
            return state == self.goal
        
    def path_cost(self, c, state1, action, state2):
        return c + 1


# In[ ]:


class Node:
    def __init__(self, state, parent=None, action=None, path_cost=0):
        self.state = state
        self.parent = parent
        self.action = action
        self.path_cost = path_cost
        self.depth = 0
        if parent:
            self.depth = parent.depth + 1

    def child_node(self, problem, action):
        next_state = problem.result(self.state, action)
        next_node = Node(state = next_state, 
                         parent = self, 
                         action = action, 
                         path_cost = problem.path_cost(self.path_cost, self.state, action, next_state))
        return next_node

    def expand(self, problem):
        return [self.child_node(problem, action) for action in problem.actions(self.state)]

    def solution(self):
        return [node.action for node in self.path()[1:]]

    def path(self):
        node, path_back = self, []
        while node:
            path_back.append(node)
            node = node.parent
        return list(reversed(path_back))


# ### Adott a következő állapottér reprezentáció
# 
# #### A farmer, a kecske, a farkas és a káposzta
# - Egy gazda át akar kelni egy folyón, és magával akar vinni egy farkast, egy kecskét és egy káposztát.
# - Van egy csónak, amelybe csak ketten férnek el, ő maga plusz vagy a farkas, a kecske vagy a káposzta. 
# - Ha a farkas és a kecske egyedül vannak egy parton, a farkas megeszi a kecskét. 
# - Ha a kecske és a káposzta egyedül van a parton, a kecske megeszi a káposztát.

# ### Jellemzők
# 
# - A jellemzők legyenek az egyes szereplők az általuk felvehető értékek pedig, hogy átkeltek, avagy nem a folyón.
# - Jelöljük 0-val hogy nem keltek át a folyón és 1-el hogy átkeltek
# - H1 = {0, 1}, farmer
# - H2 = {0, 1}, kecske
# - H3 = {0, 1}, farkas 
# - H4 = {0, 1}, káposzta 


# ### Állapotok halmaza
# 
# - A ⊆ H1xH2xH3xH4
# - Legyen a !-jel a negáció
# - A = {<a1, a2, a3, a4> | <a1, a2, a3, a4> ∈ H1 x H2 x H3 x H4 ∧ [!(a1==1 ∧ a2==0 ∧ a3==0) v !(a1==1 ∧ a2==0 ∧ a4==0)]}

# ### Kezdő állapot:
# 
# - a0 = <0, 0, 0, 0>

# ### Célállapotok:
# 
# - C = <1, 1, 1, 1>

# ### Operátorok:
# 
# - Legyen 1=farmer,2=farkas,3=kecske,4=kápozsta
# - O = {oi} = {oi | i ∈{1,2,3,4}} 
# - Dom(oi)={<a1, a2, a3, a4>  | <a1, a2, a3, a4> ∈ A ∧ (a1=a2 ∧ a3!=a4) v (a1=a4 ∧ a2!=a3) v (a1=a3) v (a2!=a3 ∧ a3!=a4)}
# - oi(<a1, a2, a3, a4> = <b1, b2, b3, b4>)
# - bk, ahol b=1,2,3,4
#     - ak=!ak ∧ a1=!a1, ha k=i ∧ i!=1
#     - a1=!a1, ha k=i ∧ i==1
#     - ak, egyébként

# 2. (3 pont) Készítsen egy osztályt, amely megvalósítja az állapotér reprezentációt a Problem és Node osztályok segítségével. Az állapottér reprezentáció megvalósításához származzon le a Problem osztályból és írja meg annak "állapot átmenet függvényét / operátorok / actions" és "operátor hatás definícióját / result". Ha szükséges bármilyen egyéb program csomag a futtatáshoz annak megadásáról se feledkezzen meg.

# In[ ]:


# Válasz helye. Válaszát futtatható python kóddal adja meg.
class Atkeles(Problem):
    def __init__(self):
        super().__init__((0,0,0,0),(1,1,1,1))

    def actions(self, state):
        gazda, kecske, farkas, kaposzta = state
        acts = []
        if (gazda == 0 and kecske == 0 and farkas == 0 and kaposzta == 0) :
            acts.append("1100")
        if (gazda == 1 and kecske == 1 and farkas == 0 and kaposzta == 0):
            acts.append("0100")
        if(gazda == 0 and kecske == 1 and farkas == 0 and kaposzta == 0):
            acts.append("1101")
        if (gazda == 1 and kecske == 1 and farkas == 0 and kaposzta == 1):
            acts.append("0001")
        if (gazda == 0 and kecske == 0 and farkas == 0 and kaposzta == 1):
            acts.append("1011")
        if (gazda == 1 and kecske == 0 and farkas == 1 and kaposzta == 1):
            acts.append("0011")
        if (gazda == 0 and kecske == 0 and farkas == 1 and kaposzta == 1):
            acts.append("1111")
    
        return acts
        
    def result(self, state, action):
        s1,s2,s3,s4 = state

        if action == "1100":
            s1,s2,s3,s4 = 1,1,0,0
            return(s1,s2,s3,s4)
        if action == "0100":
            s1,s2,s3,s4 = 0,1,0,0
            return(s1,s2,s3,s4)
        if action == "1101":
            s1,s2,s3,s4 = 1,1,0,1
            return(s1,s2,s3,s4)
        if action == "0001":
            s1,s2,s3,s4 = 0,0,0,1
            return(s1,s2,s3,s4)
        if action == "1011":
            s1,s2,s3,s4 = 1,0,1,1
            return(s1,s2,s3,s4)
        if action == "0011":
            s1,s2,s3,s4 = 0,0,1,1
            return(s1-1,s2,s3,s4)
        if action == "1111":
            s1,s2,s3,s4 = 1,1,1,1
            return(s1,s2,s3,s4)



# 3. (1 pont) Példányosítsa a reprezentációt a kezdő és cél állapottal majd írassa ki a kezdő sé cél állapotot a "print()" függvény segítségével 

# In[ ]:

# Válasz helye. Válaszát futtatható python kóddal adja meg.
peldany = Atkeles()
print(peldany.initial,peldany.goal)
# 4. (1. pont) Írja meg a próba hiba módszert a megoldás megtalálásához. Írjon megjegyzés szabályos python formátumban amiben leírja, hogy pontosan mit csinál az algoritmus. Ha szükséges bármilyen egyéb program csomag a futtatáshoz annak megadásáról se feledkezzen meg.

# In[ ]:


# Válasz helye. Válaszát futtatható python kóddal adja meg.
# próba hiba módszer
import numpy as np
def trial_error(problem):
    # kezdo allapot
    state = Node(problem.initial)

    # végtelen ciklus definiálása
    while True:
        # ha a probléma megoldva akkor leállítjuk a végtelen ciklust
        if problem.goal_test(state.state):
            print('Got it')
            return state

        # a alkamazható operátorok segítségével
        # gyártsuk le az összes lehetséges utódot
        successors = state.expand(problem)

        # ha nincs új állapot(utód)
        if len(successors) == 0:
            return 'Unsolvable'

        # random választunk egy újat a legyártott utódok közül
        state = successors[np.random.randint(0, len(successors))]
        print(state)

# 5. (1 pont) Futtasa a próba hiba módszert az elkészített reprezentációra és találja meg a megoldást. 

# In[ ]:

# Válasz helye. Válaszát futtatható python kóddal adja meg.

#print(trial_error(peldany).solution())

# 6. (1 pont) Írja meg a szélességi keresést a megoldás megtalálásához. Írjon megjegyzés szabályos python formátumban amiben leírja, hogy pontosan mit csinál az algoritmus. Ha szükséges bármilyen egyéb program csomag a futtatáshoz annak megadásáról se feledkezzen meg.

# In[ ]:


# Válasz helye. Válaszát futtatható python kóddal adja meg.
from collections import deque
def breadth_first_tree_search(problem):
    #kezdő állapot kiovasása és FIFO sorba helyezése
    frontier = deque([Node(problem.initial)])

    #amig nem értük el a határt
    while frontier:
        #legészlsőbb elem kiemelése
        node = frontier.popleft()

        #ha cél állapotban vagyunk akkor vége
        if problem.goal_test(node.state):
            return node
        
        #a kiemelt elemből az összes új állapot legyártása az operátorok segítségével
        #valójában ez a bejárás
        frontier.extend(node.expand(problem))
        print(node.state)

# 7. (1 pont) Futtasa a szélességi keresést az elkészített reprezentációra és találja meg a megoldást. Ha szükséges bármilyen egyéb program csomag a futtatáshoz annak megadásáról se feledkezzen meg.

# In[ ]:


# Válasz helye. Válaszát futtatható python kóddal adja meg.
print(breadth_first_tree_search(peldany))
