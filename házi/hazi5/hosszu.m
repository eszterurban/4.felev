function [px,pd]=solve(t,x,d)
yy=abs(t)./(1.+exp(-t));
fuggveny=polyfit(t,yy,length(t)-1);
px=polyval(fuggveny,x);
pd=fuggveny(abs(d-end));  
end
