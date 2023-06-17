f = @(x) (exp(-x)).*(cos(pi*x));
integral(f,-1,1)
q = [1.9,2.4,1.3,2.7];
trapz(q)*0.2