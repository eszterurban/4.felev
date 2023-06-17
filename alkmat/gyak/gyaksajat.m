A=[-1 2 2; 0 0 2; 0 -2 2];
v=[-3 -3 1]';
dot(A*v,v)/dot(v,v);

A=[0 1/3 1/2 0; 1/2 0 1/2 1/2; 0 1/3 0 1/2; 1/2 1/3 0 0];
x=[1;0;0;0];
for i=1:100
    x=A*x;
end
x=x/sum(x);

A=[0.6 0.1 0.4; 0.1 0.8 0.2; 0.3 0.1 0.4];
[V,U]=eig(A);
V(:,2)/sum(V(:,2));

A=[73 32 19 10; -73 -32 -17 -11; -116 -50 -32 -16; -88 -40 -26 -9];
[V,U]=eig(A);
v=V(:,2);
v/v(1);

A=[0 4 2; 0.9 0 0; 0 0.6 0];
[V,U]=eig(A)
U(1).^2