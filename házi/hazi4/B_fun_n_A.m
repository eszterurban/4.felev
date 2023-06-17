%Írjon egy függvényt, mely adott n 
% (természetes számokat tartalmazó) vektor és A
% mátrix esetén azzal a B
% mátrixszal tér vissza, melyet úgy kapunk, hogy az 
% A mátrix n-ben felsorolt indexű oszlopaiban az 
% elemeket 0-ra cseréljük.
function B=fun(n,A)
B=A;
B(:,n)=[zeros];
end

function B=fun(n,A)
A(:,n)=[];
B=A;
end