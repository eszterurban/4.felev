"""
Allapotok hanno ize torony problema

H1,H2,H3 a tornyok
H1 = {{0},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}}
H2 = {{0},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}}
H3 = {{0},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}}

Kezdo allapot
a0 = <{1,2,3},0,0> - minden a 1. oszlopon van
a1 = <0,0,0>
a2 = <0,0,0>

Cél allapot
a0 = <0,0,0>
a1 = <0,0,0>
a2 = <0,0,{1,2,3}>

#ZH, HOGY EZEKBŐL VALAMI KIMARAD ÉS AZT KELL MEGIRNI
Operátorok
O = {oi,j,k | i ∈{1,2,3} ^ j ∈{1,2,3} ^ i != j ^ k ∈{1,2,3}}(18 lehetséges operátor)
Dom(oi,j,k)={<a1,a2,a3> | <a1,a2,a3> ∈ A ^ k=min(ai U {∞}) ^ k<min(aj U{∞})}
oi,j,k(<a1,a2,a3>) = <b1,b2,b3>
Bn, ahol n = 1,2,3
    an U {k}, ha n = j
    an \ {k}, ha n = i
    an, egyébként 

https://github.com/robertlakatos/aipublic
"""
from libs.problem import Problem
from collections import namedtuple
State=namedtuple("State", ["disk","char"])

class Hanoi(Problem):
    def __init__(self, n):
        #n darab korongunk van
        self.size = n
          #"1" * n : kezdő állapot. Hány darab korong van az 1-es rúdon
        #"3" * n : Cél állapot. Hány darab korong van a 2-es rúdon
        super().__init__("1" * n, "3" * n)



    def actions(self, state):
        #operatorok definialasa
        acts = []

        #nézzük meg az egyes rudak állapotát
        f1 = state.find("1")
        f2 = state.find("2")
        f3 = state.find("3")

        #ha az 1. ród nem üres és tartalma kisebb mint ami
        #a 2. rúdon van vagy a 2. rúd üres akkor
        #1. rúdról átrakhatunk a második rúdra

        if -1 < f1 and (f1 < f2 or f2 == -1):
            acts.append(State(f1, "2"))

        if -1 < f1 and (f1 < f3 or f3 == -1):
            acts.append(State(f1, "3"))

        if -1 < f2 and (f2 < f1 or f1 == -1):
            acts.append(State(f2, "1"))

        if -1 < f2 and (f2 < f3 or f3 == -1):
            acts.append(State(f2, "3"))

        if -1 < f3 and (f3 < f1 or f1 == -1):
            acts.append(State(f3, "1"))

        if -1 < f3 and (f3 < f2 or f2 == -1):
            acts.append(State(f3, "2"))
    
        return acts
    
    def result(self, state, action):
         #operátorok hatásának definiálása

        #disk = korong, char = rúd
        disk, char = action

        #előtte és utánna lévő korongok helyeinek összefűzése
        return state[0:disk] + char + state[disk + 1:]