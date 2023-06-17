f=@(x) -100*cos(6*x).^2-320*sin(3*x)*cos(3*x)+174;
fplot(f,[-1, 1])
[x,fval]=fminbnd(f,0.1, 0.2)