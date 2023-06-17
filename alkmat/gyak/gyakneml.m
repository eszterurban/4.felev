f=@(x) -100*sin(2*x).^2-40*cos(2*x)+11;
[x, fval]=fminbnd(f,0.2,0.4)

f=[1 -2 -15 40 4 -48];
roots(f);

fa=@(x) x(1).^4-3*x(1).^2+x(1)+x(2).^2-3;
[x, fval]=fminsearch(fa,[-2,2]);

f=@(x) cos(x.^2)-sin(2*x.^5-1);
fzero(f,1);