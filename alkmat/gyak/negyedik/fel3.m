t=[2.1 2.2 2.3 2.3 2.5 2.6 2.8 2.9];
f=[2.5 2 2.5 2.7 3 4 5.4 7];
p=polyfit(t,f,2);
xx=linspace(2,3);
yy=polyval(p,xx);
figure;
plot(t,f,'*',xx,yy)