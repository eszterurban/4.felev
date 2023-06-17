f=@(x) cos(2*x.^2-3)-sin(x.^3+2);
hold on;
fplot(f,[-1 1]);
fplot(@(x) 0, [-1 1]);
hold off;
fzero(f,1)
fsolve(f,1)