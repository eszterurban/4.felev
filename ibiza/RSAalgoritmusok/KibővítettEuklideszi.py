#!/usr/bin/env python3

def kibovitetteukledesz(a, b):
    x0, x1, y0, y1 = 1, 0, 0, 1
    s = 1
    while b != 0:
        r, q = a % b, int(a / b)
        a = b
        b = r
        x, y = x1, y1
        x1 = q * x1 + x0
        y1 = q * y1 + y0
        x0, y0 = x, y
        s = -s
    x = s * x0
    y = -s*y0
    d, x, y = a, x, y
    return d, x, y
