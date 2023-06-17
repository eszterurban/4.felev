A=[1,0.99;0.99,0.98];
b=[1.99,1.97]';
b2=[1.99,1.98]';
x=A\b;
y=A\b2;

norm(y,"inf")/norm(x,"inf")
norm(b2,"inf")/norm(b,"inf")

cond_A=cond(A,"inf")
