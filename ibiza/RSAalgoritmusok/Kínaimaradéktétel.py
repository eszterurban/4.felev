#!/usr/bin/env python3

from KibővítettEuklideszi import kibovitetteukledesz
from Gyorshatvanyozas import gyorshatvanyozas

def kinai_maradektetel(p,q,m,d):
    c1 = gyorshatvanyozas(m,d%(p-1),p)
    c2 = gyorshatvanyozas(m,d%(q-1),q)
    M1, M2 = q,p
    M = p*q

    d,y1,y2 = kibovitetteukledesz(M1,M2)

    return ((c1*y1*M1)+(c2*y2*M2))%M