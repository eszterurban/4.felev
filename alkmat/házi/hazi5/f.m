x=[-2.6,-0.8,1.0,2.4];
f1 = 1 ./ (1 + cos(x).^2);
p = polyfit(x,f1,length(x)-1)
h=polyval(p, 0.4)