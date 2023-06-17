A=[1 6; 4 4; 5 3];
b=[60; 60; 65];
c=[-9;-6];
lb=[0;0];
x=linprog(c,A,b,[],[],lb,[])
[x,fval,~,~,lambda]=linprog(c,A,b,[],[],lb)
elso = x(1)
masodik = x(2)
haszon = fval*-1
% az A es C nyersanyagok arnyekara
lambda.ineqlin([1,3])