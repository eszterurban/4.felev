t = [15 46 74 105 135 166 196 227 258 288 319 349]';
f = [-1.7 0.1 5.2 10.3 15.8 18.9 21.1 20.3 16.1 10.2 4.2 0.5]';
A=[ones(length(t),1),cos(2*pi*(t-14)/365)];
x=(A'*A)\(A'*f);
z=x(1)+x(2)*cos(2*pi*(200-14)/365)
a=polyfit(t,f,3)
b=polyval(a,200)

figure
plot(t,f,"*")
hold on
xx = linspace(min(t),max(t),100); 
y = x(1) + x(2)*cos(2*pi*(xx-14)/365);
plot(xx,y)

yy = polyval(a,xx);
plot(xx,yy, ':')
