#!/usr/bin/env python3

from Gyorshatvanyozas import gyorshatvanyozas

def millerrabin(a,p):
    s = 1
    while ((p - 1) / pow(2, s)) % 2 != 1:
        s = s + 1
    d = (p - 1) / pow(2, s)

    if gyorshatvanyozas(a, d, p) == 1:
        return True
    else:
        if s == 1:
            if gyorshatvanyozas(a, d, p) == p - 1:
                return True
        else:
            for r in range(0, s - 1):
                if gyorshatvanyozas(a, d * pow(2, r), p) == p - 1:
                    return True
        return False
    
def main():
    print(millerrabin(631,7))

if __name__ == "__main__":
    main()