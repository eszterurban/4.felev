fva = @(x) x.*sin(x.^2);
integral(fva,-pi/2,pi/2)

fvb = @(x) (1/(sqrt(2*pi)))*exp(-(x.^2)/2);
integral(fvb, -inf, inf)

fvc = @(x) sqrt(1-x.^2);
integral(fvc, -1, 1)