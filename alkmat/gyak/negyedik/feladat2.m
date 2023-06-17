t=[1 15 20 28];
f=[980 605 470 250];
p=polyfit(t,f,1)
x=-p(2)/p(1)
polyval(p,0)