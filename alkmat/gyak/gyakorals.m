f=[1 12 -7 -534 -1404 3672 12960];
roots(f);

f=@(x) -100*sin(4*x).^2-120*cos(4*x)+133;
[x,fval]=fminbnd(f,0,0.4);

f=@(x) cos(x.^2-x)-sin(x.^2+1)-1;
fzero(f,1);

f=@(x) x(1).^5-3.*x(1)+x(2).^5-3.*x(2);
fminsearch(f,[2,2])