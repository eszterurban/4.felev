%Írjon egy függvényt, mely adott A mátrix és d 
% természetes szám  esetén azt a B 
% mátrixot adja vissza, melyet úgy kapunk, hogy az A jobb alsó d×d-s
% részmátrixa alá illesztjük a d×d-s nullmátrixot
function B=fun(A,d)
B = [A(end-d+1:end,end-d+1:end);zeros(d,d)];
end

function B=fun(A,d)
B=[A(1:d,1:d);ones(d,d)];
end