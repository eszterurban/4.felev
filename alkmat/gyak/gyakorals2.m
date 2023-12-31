A=[0.5 0.3 0.2; 0.4 0.4 0.2; 0.1 0.2 0.7];
[V,U]=eig(A);
V(:,3)/sum(V(:,3));

B=[0 5 4; 0.6 0 0; 0 0.5 0];
[V,U]=eig(B);
U(1)^2;

C=[-1 1 -2; -2 0 -3; -3 -1 -3];
v=[-5;4;1];
dot(C*v,v)/dot(v,v);

D=[0 1/2 1/3 1/2; 0 0 1/3 1/2; 1/2 0 0 0; 1/2 1/2 1/3 0];
x=[1;0;0;0];
for i=1:100
    x=D*x;
end
x=x/sum(x);

E=[73 32 19 10; -73 -32 -17 -11; -116 -50 -32 -16; -88 -40 -26 -9];
[V,U]=eig(E);
v=V(:,1)
v/v(4)