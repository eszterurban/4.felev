t=[0:2:12];
f=[3 4 5 5.5 6.5 7 8];
p=polyfit(t,f,1)
%F(t)=0.4*t^1+3.16*^0
huszp=polyval(p,20)
x=-p(2)/p(1)
y=(50-p(2))/p(1)