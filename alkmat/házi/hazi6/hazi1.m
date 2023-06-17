f = @(x) (x.*sin(x))./(sqrt(1+x.^2));
integral(f,0,pi)

f2 = @(x,y) cos(x).*exp(x+y.^2);
ymax = @(x) sqrt(1-x);
integral2(f2,0,1,0,ymax)