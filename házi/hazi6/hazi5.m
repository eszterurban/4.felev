x = [2 3 4];
y = [-39 -28 -89 -202 -139];
s = spline(x, y, 3.9)
a = 2;
b = 4;
n = 5;
xx = linspace(a,b,n+1);
yy = spline(x,y,xx);
trapz(xx,yy)