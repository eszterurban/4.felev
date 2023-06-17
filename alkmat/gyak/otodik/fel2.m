t = [-2 -1 0 2];
f = [-5 3 1 15];
n=length(t)
a=polyfit(t,f,n-1)

figure
plot(t,f,"*")
hold on
x = linspace(min(t),max(t),100);
y = polyval(a,x);
plot(x,y)