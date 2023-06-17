f = @(x) x.^3-5*x;
derivf = @(x) 3*x.^2-5;
x0 = 1;
eps = 1e-8;
maxit = 100;
[gyok, k] = newton(x0, maxit, eps, f, derivf)