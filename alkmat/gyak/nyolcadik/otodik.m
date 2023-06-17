f=@(x) x(1)^3+x(2)^3-3*x(1)-3*x(2);
[xop,fop]=fminsearch(f,[0.5,0.5])

f=@(x) x(1)^3+x(2)^3-3*x(1)-3*x(2);
[xopt,fopt]=fminunc(f,[0.5,0.5])