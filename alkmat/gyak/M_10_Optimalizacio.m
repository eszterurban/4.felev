%% Optimalizalas
% beepitett matlab fuggvenyekkel
% korabban: 
% fzero: Csak olyan gyokot talal meg, ahol elojelet valt a fuggveny
% fsolve: Az F(x) = 0 egyenlet gyoket kozeliti az x0-bol indulva. F tobbvaltozos is lehet
% roots: polinom alaku fuggvenyek gyokeinek kozelitesere

%% Uj fuggvenyek minimalizalasra
% fminbnd, fminsearch, fminunc

%% Egyvaltozos fuggveny minimalizalasa
% fminbnd(f,xmin,xmax) - Egyvaltozos fv [xmin,xmax] intervallumbeli
%                        minimumat keresi, elojelvaltas nelkuli fv-ekre is

% Keressuk meg az f(x) = 13-9cos^2(x)-12sin(x) 
% fv [-4,4]-beli minimumhelyeit.
f=@(x) 13-9*cos(x).^2-12*sin(x);
fplot(f,[-4,4])
%%
[x,fval]=fminbnd(f,0,1)
%%
[x,fval]=fminbnd(f,2,3)

%% Tobbvaltozos fuggvenyek

% Adjunk meg egy tobbvaltozos fuggvenyt
f = @(x1,x2) x1.^3 + x2.^3 - 3*x1 - 3*x2;
fsurf(f)
%%
% egyszeru kirajzolas a racs eloallitasa nelkul
%%
fmesh(f)
%% A 3D rajzolashoz szukseges racspontok eloallitasa
xx=linspace(-2,2)
yy=xx
[X,Y]=meshgrid(xx,yy)
%%
%Z=X.^3+Y.^3-3*X-3*Y;
Z = f(X,Y);
figure 
mesh(X,Y,Z)
%%
surf(X,Y,Z)
%% Szintvonalak - contour plot
fcontour(f,[-2,2])
%%
xx=linspace(-2,2);
yy=xx;
[X,Y]=meshgrid(xx,yy);
Z=f(X,Y);
figure
contour(X,Y,Z)
axis equal

%% gradiens vektorok rajzolasa

[X,Y]=meshgrid(linspace(-2,2));
Z=f(X,Y);
[dX,dY]=gradient(Z);
hold on
quiver(X,Y,dX,dY)
%% rajzoljuk ki ezeket ritkabb racspontokra!
[X,Y]=meshgrid(linspace(-2,2,11));
Z=f(X,Y);
[dX,dY]=gradient(Z);
hold on
quiver(X,Y,dX,dY)
% Rajzoljunk negativ gradiens mezot, a csokkenesek iranyaba!
%quiver(X,Y,-dX,-dY)
%% Tobbvaltozos fuggvenyek minimalizalasa
% fminsearch
% fminunc 
% ehelyett:
% f = @(x1,x2) x1.^3 + x2.^3 - 3*x1 - 3*x2;
% minden fuggvenyt egyvaltozoskent kell megadni, hogy a minimalizalast
% vegre tudjuk hajtani!
f = @(x) x(1)^3+x(2)^3-3*x(1)-3*x(2);
% kezdoertekeket is meg kell adni
[xopt,fopt]=fminsearch(f,[0.5,0.5]) 
%%
[xopt,fopt]=fminunc(f,[0.5,0.5])

%% Feladat
% Rajzoltassa ki a megadott tartomany felett az alabbi ketvaltozos
% fuggvenyeket, a szintvonalaikat, a negativ gradiensmezot es kozelitse az
% adott tartomanyon belul a minimumhelyuket.
% f(x1,x2) = 1/6 x1^3 - x1 + 1/4 x1*x2^2, ha x eleme [-2.5,2.5]^2

f = @(x1,x2) 1/6*x1.^3 - x1 + 1/4*x1.*x2.^2;
interval = [-2.5,2.5,-2.5,2.5];
figure
fsurf(f,interval)

figure
[X,Y]=meshgrid(linspace(-2.5,2.5));
Z=f(X,Y);
contour(X,Y,Z,100)
axis equal

[X,Y]=meshgrid(linspace(-2.5,2.5,20));
Z=f(X,Y);
[dX,dY]=gradient(Z);
hold on
quiver(X,Y,-dX,-dY)

%%
f = @(x) 1/6*x(1).^3 - x(1) + 1/4*x(1).*x(2).^2;
[xopt,fopt] = fminsearch(f,[1,0])

%5[xopt,fopt] = fminsearch(f,[-2,2])



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Feladat
% Hatarozza meg az alabbi fuggveny [-2,2]x[-2,2]-be
% eso lokalis minimumai  kozul a legkisebbet!
% f(x1,x2) = x1^5 - 3*x1 + x2^5 - 3*x2
f = @(x1,x2) x1.^5 - 3*x1 + x2.^5 - 3*x2;
interval = [-2,2,-2,2];
figure
subplot(1,2,1)
fsurf(f,interval)

subplot(1,2,2)
[X,Y]=meshgrid(linspace(-2,2));
Z=f(X,Y);
contour(X,Y,Z)
axis equal
[X,Y]=meshgrid(linspace(-2,2,15));
Z=f(X,Y);
[dX,dY]=gradient(Z);
hold on
quiver(X,Y,-dX,-dY)

%%
f = @(x) x(1).^5 - 3*x(1) + x(2).^5 - 3*x(2);
[xopt,fopt] = fminsearch(f,[2,2])

%%

%Közelítse a cos(3x-1)-2sin(x-1)-1=0 egyenlet 0-hoz 
%legközelebbi gyökét 4 tizedesjegy pontossággal!
% -0,8422
% helyes: -0,668
f = @(x) cos(3*x-1)-2*sin(x-1)-1;
fplot(f)
options = optimset('Display','iter'); % show iterations
x = fzero(f,[-3,0], options)

hold on
plot(x,0, 'r*')