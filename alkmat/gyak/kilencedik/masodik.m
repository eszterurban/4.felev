A=[1 1; 2 1];
b=[40; 60];
c=[-4;-3];
lb=[0;0];
x=linprog(c,A,b,[],[],lb,[])
x(2)