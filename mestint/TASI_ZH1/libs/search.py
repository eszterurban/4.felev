# numerikus számításokhoz, n dimenziós tömbök kezeléséhez
import numpy as np
# csomópontok létrehozására szolgáló node osztály
from libs.node import Node
from collections import deque

# próba hiba módszer


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


def hill_climbing_for_3Cup(problem, heuristic):
    # kezdő állapot
    state = Node(problem.initial)

    # végtelen ciklus definiálása
    while True:
        # ha a probléma megoldva akkor leállítjuk a végtelen ciklust
        if problem.goal_test(state.state):
            return state
        # az alkalmazható operátorok segítségével
        # gyártsuk le az összes lehetséges utódot
        successors = state.expand(problem)

        #keresünk egy jobb állapotot a heurisztikának megfelelően
        test_successors = []
        for s_test in successors:
            if heuristic(state.state)>=heuristic(s_test.state):
                test_successors.append(s_test)
            
        #ha nincs jobb állapot
        if len(test_successors)==0:
            return 'Unsolvable'
    
        #ha több azonosan jó van akkor random választunk egyet
        state = test_successors[np.random.randint(0,len(test_successors))]

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

def depth_first_graph_search(problem):
    #kezdő elem berembe helyezése
    frontier = [(Node(problem.initial))]

    #halmaz deklarálása a már bejárt elemekhez
    explored = set()

    #amig tudunk mélyebre menni
    while frontier:
        #legfelső elem kiemelése a veremből
        node = frontier.pop()

        #ha cél állapotban vagyunk vége
        if problem.goal_test(node.state):
            return node
    
        #állapot feljegyzése hogy tudjuk hogy már jártunk itt
        explored.add(node.state)

        #verem bővítése amíg benemjárt elemekkel
        frontier.extend(child for child in node.expand(problem)
                        if child.state not in explored and child not in frontier)

def best_first_graph_search(probelm, f):
    #best-first kereső olyan keresőfával kereső mely a legkisebb heursztikájú nyílt

    #kezdo allapot
    node = Node(probelm.initial)

    #prioritásos (valamilyen heurisztika szeint rendezett) sor létrehozása
    frontier = []

    #kezdő állapot felvétele a prioritásos sorba
    frontier.append(node)

    #halmaz létrehozása a már megvizsgálásával
    explored = set()

    #amig talalunk elemet
    while frontier:
        #elem kivétele a verem tetejéről
        node = frontier.pop()
        
        #ha cél állapotban vagyunk akkor kész
        if probelm.goal_test(node.state):
            return node
        
        #feldolgozott elemek bővítése
        explored.add(node.state)

        #operáltorral legyártott gyermek elemek bejárása
        for child in node.expand(probelm):
            #ha még nem dolgoztuk fel
            if child.state not in explored and child not in frontier:
                frontier.append(child)
        
        #rendezzük a listát(sor) a heurisztikábak megfelelően
        frontier = f(frontier)
        print(node.state)




def astar_search(problem,f=None):
    #Az A*-algoritmus olyan A algoritmusfajta,mely garanálja az optinális megoldáselőállítását
    #h*(n) az n-vpl valamely célcsúcsba jutás optimalizálás költsége
    #g*(n) a startcsúcsból n-be jutás optimális költsége
    #f*(n)=g*(n)+h*(n) értelemszerűen a startcsúcsból n-en keresztül valamely célcsucsba jutás
    return best_first_graph_search(problem,f)

