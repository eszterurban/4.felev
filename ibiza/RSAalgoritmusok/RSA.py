#!/usr/bin/env python3

from random import randint
from KibővítettEuklideszi import kibovitetteukledesz
from Gyorshatvanyozas import gyorshatvanyozas
from Kínaimaradéktétel import kinai_maradektetel
from MillerRabin import millerrabin

def RandomPrim():
    while True:
        p = randint(2, 1000000000)
        q = randint(2, 1000000000)
        if p != q and p % 2 != 0 and q % 2 != 0 and millerrabin(2, p) and millerrabin(2, q):
            return p, q

def KeyGen(phi):
    while True:
        e = randint(2, phi)
        (d, x, y) = kibovitetteukledesz(e, phi)
        if d == 1:
            return e, x, y

def RSA():
    #kulcsgeneralas
    p, q = RandomPrim()

    n = p*q

    phi = (p-1)*(q-1)

    (e, d, y) = KeyGen(phi)
    if d < 1:
        d = d + phi
    elif d < phi:
        d = d - phi

    #alairas
    mes=1234
    print("Üzenet: " + str(mes))

    c=gyorshatvanyozas(mes, e, n)
    print("Titkos üzenet: " + str(c))

    m= kinai_maradektetel(p,q,c,d)
    print("Visszafejtett üzenet: " + str(m))

    S=kinai_maradektetel(p,q,mes,d)

    #ellenorzes
    if m == gyorshatvanyozas(S,e,n):
        print("Helyes aláírás")

def main():
    print(RSA())

if __name__ == "__main__":
    main()