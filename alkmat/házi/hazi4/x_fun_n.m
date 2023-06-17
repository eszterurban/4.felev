%Írjon egy függvényt, mely adott n 
% természetes szám  esetén azt a 2n 
% elemű sorvektort adja vissza, melynek páratlan 
% sorszámú koordinátái az 11,12,...,1n
% számokkal egyenlők, a páros sorszámúak az n,...,2,1 számokkal, 
% ebben a sorrendben. Pl. n=5
% esetén x=(1,5,12,4,13,3,14,2,15,1)
function x=fun(n)
x = zeros(1, 2*n);
x(1:2:end) = 1./(1:n);
x(2:2:end) = n:-1:1;
end

function x=fun(n)
x=ones(1,2*n);
x(1:2:2*n)=(1:1:n);
x(2:2:2*n)=(n:-1:1);
end