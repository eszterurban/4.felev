#harmadik gyakorlat
import sys
sys.path.append("C:\\Users\\hallgato\\Documents\\mestint\\cs10\\Mestint\\gyak")

from collections import namedtuple
from libs.search import trial_error
from libs.hano import Hanoi

Student = namedtuple('Student',['name','age','DOB'])
S = Student('Nandini','19','25541997')
#print("Index is :",S[1])

h = Hanoi(3)
print(h.initial, h.goal)
print(trial_error(h).solution())