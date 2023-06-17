%Írjon egy Matlab függvényt, amely tetszőleges
% n esetén megadja az alábbi összeg értékét.
% s=∑k=1nk3ek
function s=fun(n)
k=1:n;
s=sum([(k.^3)./e.^k]);
end

function s=fun(n)
s=sum([sin(1:1:n)./(1:1:n)]);
end