f=@(x,y) (cos(y.^2))./(exp(x));
egy=integral2(f,0,1,1,2)

x=[-4 2 3];
y=[35 -46 20 52 42];
ketto=spline(x,y,0.5)
a=-4;
b=3;
n=5;
xx=linspace(a,b,n+1);
yy=spline(x,y,xx);
harom=trapz(xx,yy)

f2=@(x) (cos(pi.*x))./(2.*exp(x).^2);
negy=integral(f2,0,5)
v=[2.6,1.5,3.1,3.2];
ot=trapz(v)*0.4

f3=@(x) (exp(2*x))./(1+exp(2*x));
hat = integral(f3,0,1)

f4=@(x,y) (exp(-y.^2))./(2+sin(pi*x));
ymax=@(x) 2*x;
het = integral2(f4,0,1,0,ymax)

f5=@(x) (exp(-x.^3)).*sin(x);
nyolc=integral(f5,0,inf)