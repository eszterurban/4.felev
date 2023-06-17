fv = @(x) x.*sin(5.*x);
integral(fv,0,10)

xi=0:10;
z=trapz(xi,fv(xi))

xi2=[0 0.5:9.5 10];
z2=trapz(xi2,fv(xi2))

x = linspace(0,10);
plot(x,fv(x))
hold on
plot(xi,fv(xi),'g-+')
plot(xi2,fv(xi2),'r-*')

x2 = linspace(0,100);
plot(x2,fv(x2),'b-+')