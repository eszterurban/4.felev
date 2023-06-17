A=pascal(10);
x=ones(10,1);
b=A*x;
[L U] = lu(A);
y1=L\b;
x1=U\y1;

LL=chol(A);
y1=LL\b;
x1=LL'\y1;

A\b
