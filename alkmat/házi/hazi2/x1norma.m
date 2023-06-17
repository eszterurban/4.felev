% Írjon egy függvényt, mely adott n esetén kiszámolja az x=(x1,...,xn) vektor 1-normáját, ahol xk=1k−cos(k), ha k=1,…,n
% Kiegészítő információk:
% 1≤n≤33
% Ennél a feladatnál tilos használni ["for", "while", "do", "until", "if", "switch", "norm"]-ra épülő konstrukciókat.

function h = solveit(n)
    k = (1:n);
    x = 1./k - cos(k);
    h = sum(abs(x));
end
