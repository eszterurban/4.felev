f= @(x,y) x.*exp(-x.^2-y.^2);
integral2(f,-2,2,-1,1)

f= @(x,y) sqrt(1-x.^2-y.^2);
ymin= @(x) -sqrt(1-x.^2);
ymax= @(x) sqrt(1-x.^2);
integral2(f,-1,1,ymin,ymax)
