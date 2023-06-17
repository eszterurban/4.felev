A=[0,1,1;0.8,0,0;0,0.25,0];
eig(A); %sajatertek vektor
[V,U] = eig(A) %V sajatvekrot (oszlopok szerint) matrix, U sajatertek matrix (diag)
a=V(:,1) %a legnagyobb sajatertek sajatvektorai

B=[73,32,19,10;-73,-32,-17,-11;-116,-50,-32,-16;-88,-40,-26,-9];
[V,U]=eig(B)
b=V(:,4) % c-vel konstan művelet hohgy a zelso erteke 1 legyen
b/b(1)

C = [0,1,1;0.8,0,0;0,0.25,0];
[V,U]=eig(C)
c=V(:,1)
c/sum(c) %vektor normálása
x=[100,80,20]'
C*x

D=[0,6,8;0.5,0,0;0,0.5,0];
[V,U]=eig(D)
d=V(:,1)
y=d/sum(d)
D*y

E = [0,1/3,1/2,0;0,0,1/2,0;1/2,1/3,0,1;1/2,1/3,0,0];

F = [0.1,0.5,0.4;0.3,0.1,0.5;0.6,0.4,0.1];
[V,U]=eig(F)
f=V(:,1)
z=f/sum(f)

%lambda = dot(A*v,v)/dot(v,v)
G = [-34,-16,8;70,33,-15;-4,-2,4]
[V,U]=eig(G)
g=V(:,3)
g/g(2)

H=[0,5,4;0.6,0,0;0,0.6,0];
[V,U]=eig(H)
h=V(:,1)
h/sum(h)
