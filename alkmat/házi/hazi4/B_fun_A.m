%Írjon egy függvényt, mely adott A mátrix esetén azzal a B 
% mártixszal tér vissza, melyet úgy kapunk, hogy  az A 
% 2-vel egyenlő elemei helyett 4-et írunk
function B=fun(A)
B = A;
B(B == 2) = 4;
end

%Írjon egy függvényt, mely adott A mátrix esetén azzal a B 
% mártixszal tér vissza, melyet úgy kapunk, hogy  az A
% pozitív  elemeit megnöveljük 1-gyel. 
function B=fun(A)
positiveElements = A > 0;
A(positiveElements) = A(positiveElements) + 1;
B = A;
end

function B=fun(A)
B=[(A>0)+1];
B=A.*B;
end

function B=fun(A)
B=[A sum(A<0,2)];
end