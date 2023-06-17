%Írjon egy függvényt, mely adott n és d 
% természetes számok  esetén azt az n×n-es A 
% mátrixot adja vissza, melynek bal felső d×d-s
% részmátrixában minden elem 2, a többi eleme pedig 3
function A=fun(n,d)
A=[ones(n,n).*3];
A(1:d,1:d)=2;
end

function A=fun(n,d)
A=[ones(n,n).*3];
A(1:d,1:d)=2;
end