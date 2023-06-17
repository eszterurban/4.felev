#!/usr/bin/env python3

def gyorshatvanyozas(base, exp, mod):

    result=1

    while exp > 0:
        if exp % 2:
            result = (result * base) % mod
        base = (base * base) % mod
        exp //=2
    return result