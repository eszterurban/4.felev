f = @(x,y) (2*y).*sin(x).*(cos(x).^2);
integral2(f,0,pi/4,-pi/3,0)

f2 = @(x,y) (1/2*pi).*exp(-(x.^2.+y.^2)./2);
integral2(f2,-inf,inf,-inf,inf)


f3 = @(x,y) log(x.*y).^10;
xmax = @(x) exp();
ymin = @(x) x;
ymax = @(x) x.^2;
integral2(f3,1,xmax,ymin,ymax)