A=[2 1; 1 1; 1 0];
b=[100; 80; 40];
%azert minusz mert a maximumot keressuk és -1-el szorzunk ilyen esetben
c=[-30000;-20000];
lb=[0;0];
Aeq=[];
beq=[];
ub=[];
x = linprog(c,A,b,Aeq,beq,lb,ub)
b-A*x
[x,fval,~,~,lambda]=linprog(c,A,b,[],[],[0;0])
lambda.ineqlin