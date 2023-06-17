F=@(x) [x(1)+2*x(2)+3*x(3); cos(2*x(1))+3*x(2).^2-1];
x0=[1,1,1];
[gyok, pont] = fsolve(F, x0)