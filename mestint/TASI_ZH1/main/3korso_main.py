#masodik gyakorlat
import sys
sys.path.append('')

from libs.haromkorso import Cup3
c = Cup3((5, 0, 0), [(4, 1, 0), (4, 0, 1)])
print(c.initial, c.goal)

from libs.search import trial_error
print(trial_error(c).solution())

from libs.search import hill_climbing_for_3Cup
#a heurisztika lényege az hogy ha minél több üres korsót találunk annál távolabb vagyunk
#a megoldástól
def heuristic_calc_empty_jar(State):
    if State == (4,0,1) or State == (4,1,0):
        return 0
    c = 0
    for i in State:
        if i == 0:
            c+=1
    return c+1

print(hill_climbing_for_3Cup(c,heuristic_calc_empty_jar).solution())

for i in range(10):
    print(hill_climbing_for_3Cup(c,heuristic_calc_empty_jar).solution())