A=[1 0 0 ; 0 1 0 ; 0 0 1 ; 0 0 0]
b=[-5 0;5 0;3 0; 0 1]
% Az x megadja a megoldást.
x = A\b

linear_equation_solver(A,b)
function [solution] = linear_equation_solver(A,b)
% A függvény meghatározza, hogy az Ax=b lineáris egyenletrendszer egyértelműen megoldható,
% ellentmondásos, vagy végtelen sok megoldása van.
% Bemenet: A - mxn mátrix, b - mx1 vektor
% Kimenet: solution - 'unique' ha az egyenletrendszer egyértelműen megoldható, 
%                     'inconsistent' ha ellentmondásos, 
%                     'infinite' ha végtelen sok megoldása van.

% Megvizsgáljuk, hogy a mátrixunknak van-e nulltételes oszlopa
if rank(A) < rank([A b])
    solution = 'inconsistent'; % Ha van, akkor az egyenletrendszer ellentmondásos
else
    % Megvizsgáljuk, hogy a mátrixunknak van-e szabad változója
    if rank(A) < size(A,2)
        solution = 'infinite'; % Ha van, akkor az egyenletrendszernek végtelen sok megoldása van
    else
        solution = 'unique'; % Ha nincs sem nulltételes oszlop, sem szabad változó, akkor az egyenletrendszer egyértelműen megoldható
    end
end
end
