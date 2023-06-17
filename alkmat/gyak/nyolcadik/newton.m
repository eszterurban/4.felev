function [gyok, k] = newton(x0, maxit, eps, f, derivf)
gyok = "Nem talált gyököt!";
for k = 1:maxit
    if derivf(x0) == 0
        error("A dervált 0, nem lehet végrehajtani a műveletet!")
    end
    x1 = x0 - f(x0)/derivf(x0);
    if abs(f(x1)) < eps
        gyok = x1;
        break
    end
    x0=x1;
end
end