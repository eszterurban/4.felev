%kontúr
xx=linspace(-2,2); yy=xx;
[X,Y]=meshgrid(xx,yy);
Z=X.^3+Y.^3-3*X-3*Y;
figure; contour(X,Y,Z)
axis equal
hold on
%gradiens mező
xx=linspace(-2,2,11); yy=xx;
[X,Y]=meshgrid(xx,yy);
Z=X.^3+Y.^3-3*X-3*Y;
[dX,dY]=gradient(Z);
hold on; quiver(X,Y,dX,dY)
% quiver(X,Y,-dX,-dY) negativ gradiens mező