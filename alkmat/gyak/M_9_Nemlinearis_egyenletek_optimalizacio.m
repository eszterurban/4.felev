%% Nemlinearis egyenletek

% Korabban: linearis egyenlet megoldasa, azaz az egyenlet gyokenek
% megtalalasa egyszeru feladat.
% linearis fuggveny : f(x) = ax + b
% linearis egyenlet: a*x = b, nullara rendezve: a*x + b = 0
% x = -b/a;
% Egyenletrendszer eseten is Gauss eliminacioval
% meg tudjuk konnyen oldani

%% De ha az egyenlet nem linearis:

% Olyan f(x) = 0 egyenlet gyokeit keressuk, 
% ahol az f nemlinearis fuggveny


%pl. nemlinearis fvre
f1 = @(x) cos(x) - x; % trigonometrikus fv-ek
f2 = @(x) x^5 - 3*x^4 + x^3 -5*x^2 + 3; % elsofokunal nagyobb fokszamu polinom
f3 = @(x) exp(x) - 4*x^2; %exponencialis (es a negyzetes tag)
f4 = @(x) log(x) - x + 2;  % logaritmus fv

%% Newton modszer
% Egy pontra tamaszkodo modszer
% Kvadratikus konvergencia
% Elso derivalt adott pontbeli erteket hasznalja minden lepesben

% Szamoljunk derivaltat a szimbolikus kifejezesekkel
syms x
f = x^3 - 3*x + 2
%%
diff(f) % 3*x^2 - 3
%%
f = @(x) x.^3 - 3*x + 2;
derivf = @(x) 3*x.^2 - 3;

x0 = 1.5; % kiindulo pont
[gyok,k] = nemlin_newton(f,derivf,x0,1e-8,100)

%% Kozelitsuk a kovetkezo fv gyoket Newton modszerrel az x0=1 pontbol kiindulva:
% f(x) = x^3 - 5x
syms x
f = x.^3 - 5*x;
diff(f)
%%
f = @(x) x.^3 - 5*x;
derivf = @(x) 3*x.^2 - 5;

x0 = 1; % kiindulo pont
[gyok,k] = nemlin_newton(f,derivf,x0,1e-5,100)
% Eloadasrol ismeros 1 es -1 ertekek kozotti valtakozas

%% Kozelitsuk a gyok a erteket Newton modszerrel
% x^2 - a = 0 --> x^2 = a --> x = sqrt(a), azaz x^2 - a = 0 egyenlet
% gyokenek kozelitese a feladat
% f(x) = x^2 - a
% f'(x) = 2x
a = 5;
format long
[gyok,k] = nemlin_newton(@(x)x.^2-a,@(x)2*x,2,1e-10,100)
% abs(gyok - sqrt(5)) % Ellenorzes
%% Szelo modszer
% Ha a Newton iteraciobeli derivalt szamitasa nem lehetseges vagy tul
% koltseges, akkor annak egy kozeliteset alkalmazzuk.
% Ket pontra tamaszkodo modszer
f = @(x) x.^3 - 3*x -2;
a = 0;
b = 3;
[gyok, k] = nemlin_szelo(f,a,b,1e-5,100)
%% Matlab beepitett fuggvenyek: 
% fzero: Csak olyan gyokot talal meg, ahol elojelet valt a fuggveny
% fsolve: Az F(x) = 0 egyenlet gyoket kozelıti az x0-bol indulva. F tobbvaltozos is lehet
% roots: polinom alaku fuggvenyek gyokeinek kozelitesere

% Kozelitsuk a cos(x) = 3x egyenletet a 0 kezdopontbol.
% Atformalas F(x) = 0 alakra:
F = @(x) cos(x) - 3*x;
fplot(F)
x0 = 0;
%%
[xopt,fopt] = fzero(F,x0)
%%
[xopt,fopt] = fsolve(F,x0)

%% Nemlinearis egyenletrendszerek gyokeinek kozelitese
F=@(x) [-4*x(1)+cos(2*x(1)-x(2))-3; -3*x(2)+sin(x(1))-2];
[xopt,fopt]=fsolve(F,[0;0])


%% Polinom gyokok kozelitese
% Egy polinomot egyertelmuen meghataroznak a tagok egyutthatoi
% pl. 3*x^5 - 4*x^4 + 2x^3 - x + 1
% az egyutthatok a foegyutthatoval kezdve: 
% 3, -4, 2, 0, -1, 1
p = [3, -4, 2, 0, -1, 1]; % az egyutthatok
roots(p)
% ennek a polinomnak komplex gyokei es egy valos gyoke van



