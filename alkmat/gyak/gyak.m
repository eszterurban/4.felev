A=[1 6; 3 3; 6 2];
b=[60; 45; 66];
c=[-4; -8];
[x,fval,~,~,lambda]=linprog(c,A,b,[],[],[0;0],[]);
lambda.ineqlin;

A=[2 6; 4 5; 6 2];
b=[72 74 78]';
c=[-6; -10];
linprog(c,A,b,[],[],[0;0],[]);

f=@(x) x(1).^2+x(1).^4+x(2).^6-x(2).^2+2.*x(1).*x(2);
fminsearch(f,[2,2]);

f=[1 1 -19 -1 90 -72];
roots(f);

f=@(x) cos(x.^4)-sin(2*x.^3-1);
fzero(f,1);

f=@(x) -100*sin(6*x).^2-120*cos(6*x)+128;
[x,fval]=fminbnd(f,0,0.2);

A=[0 1/2 1/3 1/3; 1/3 0 1/3 1/3; 1/3 1/2 0 1/3; 1/3 0 1/3 0];
x=[1;0;0;0];
for i=1:100
    x=A*x;
end
x=x/sum(x);

A=[-1 2 0; 0 1 -1; 3 -3 2];
v=[-4; -2; -2];
dot(A*v,v)/dot(v,v);

A=[0 7 1; 0.7 0 0; 0 0.7 0];
[V,U]=eig(A);
U(1)^2;

A=[73 32 19 10; -73 -32 -17 -11; -116 -50 -32 -16; -88 -40 -26 -9];
[V,U]=eig(A);
v=V(:,2);
v/v(2);

A=[0.4 0.1 0.4; 0.3 0.7 0.2; 0.3 0.2 0.4];
[V,U]=eig(A);
v=V(:,1);
v/sum(v);

f=@(x) (3.^x).*cos(x);
integral(f,-inf,2);

f=@(x) ((x.^2).*cos(x))./(sqrt(1-x.^2));
integral(f,0,0.5);

f=@(x,y) (exp(-x.^2-y.^2))./(sqrt(x+y));
max=@(x) 1-x;
integral2(f,0,1,0,max);

x=[-3 0 2];
v=[-61 63 -3 7 15];
spline(x,v,-1.6);
a=-3;
b=2;
n=3;
xx=linspace(a,b,n+1);
yy=spline(x,v,xx);
trapz(xx,yy);

f=@(x) (exp(-x))./(sqrt(5-x.^2));
integral(f,-1,1);
v=[1.5,2.1,2.6,3.1,2.2,4.0];
trapz(v)*0.25;

f=@(x,y) (sqrt(x./y))./(cos(x));
integral2(f,3,4,4,5);

v=[0 2 4];
x=[-1 1 -5 -59 -37];
spline(v,x,0.8);

a=[-3.0,-1.4,-1.2,2.6];
f=1./(1+cos(a).^2);
p=polyfit(a,f,length(a)-1);
polyval(p,0);

t=[0 1 2 3 5];
f=[1.44 3.47 5.39 7.42 11.38];
p=polyfit(t,f,1);
polyval(p,7.5);

A=[3 3 0; -2 1 -3; 1 -5 1];
norm(A,1);
norm(A,"inf");

A=[1 2 8; -2 -3 -13; -3 -6 -24];
b=[-17 26 51]';
rank(A);
rank(b);

x=[-1 -5 -2 4]';
norm(x,1);
norm(x,2);
norm(x,"inf");

A=[1 -4 -4; 4 -15 -16; 1 -6 -3];
cond(A,1);
0.3/cond(A,1);

A=[1 2 8; -2 -3 -13; -3 -6 -24];
b=[-17 26 51]';
rref(A,b);
rank(A);
rank(A,b);

A=[1 3 -3; -2 -5 4; -3 -4 -1];
b=[14 -23 -17]';
rref([A,b]);

A=[0 1/2 1/3 1/2; 1/2 0 1/3 1/2; 1/2 0 0 0; 0 1/2 1/3 0];
[V,U]=eig(A);
v=V(:,1);
v/sum(v);

f=@(x) sin(pi*x).*abs(x);
a=linspace(-1,3,13);
s=trapz(f,a)
