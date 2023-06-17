t=[1 1.1 1.1:0.1:2];
f=[8 8.9 9 9.8 10 11 11.5 11.5 12.5 13 13.7 14];
p=polyfit(t,f,1) 
%F(t)=5.82*t^1+2.53*^0
xx=linspace(0.9,2.1);
yy=polyval(p,xx);
figure; plot(t,f,'*',xx,yy)