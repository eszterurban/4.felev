A=[1 7; 3 3; 6 2];
b=[70 48 72]';
c=[-4; -10];
[x, fval,~,~,lambda]=linprog(c,A,b,[],[],[0;0],[]);
mar=b-A*x;

A=[2 6; 4 5; 6 2];
b=[72 74 78]';
c=[-6 -10];
[x, fval,~,~,lambda]=linprog(c,A,b,[],[],[0;0],[]);
lambda.ineqlin