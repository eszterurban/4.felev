A=[1 -5 -2; 2 -9 -9; 4 -16 -27];
cond(A,1)*0.1;
0.3/cond(A,1);

A=[0 -3 -4; 0 -3 4; 0 3 -1];
norm(A,1);
norm(A,inf);

A=[1 3 -3; 1 4 -5; 1 2 -1];
b=[0 0 0]';
x=A\b;
rref(A,b);
rank(A);
rank(b);

x=[-4 -4 -5 -1]';
norm(x,1);
norm(x,"inf");
norm(x,2);