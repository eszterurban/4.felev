c=[-100; -200];
A=[20,40;50,20;0,2];
b=[280; 300; 12];
lb=[0;0];
[x, fval, ~, ~, lambda] = linprog(c,A,b,[],[],lb,[])
%arnyekar
lambda.ineqlin
%nyereseg
fval*-1
%maradék
b-A*x