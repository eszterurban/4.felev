%% Interpolacio
% Adott adatokra illeszkedo minimalis fokszamu polinom meghatarozasa. Az
% adatok es a polinom egy abran valo abrazolasa.
% Kiegeszites: 
% polyfit(), polyval(), fuggveny hasznalata, eredmenyenek ertelmezese
% \ (backslash operator), plot()
% Pelda feladatok: 

%% 1. 
% Hatarozzuk meg a (-2, -5),(-1, 3),(0, 1),(2, 15) pontokra illeszkedo
% minimalis fokszamu polinomot! Es abrazolja egy kozos abran a
% pontokat es az illesztett polinomot!

x = [-2 -1 0 2];
f = [-5 3 1 15];

% minimalis fokszam = adataok darabszama - 1
m = length(x)-1;

p = polyfit(x,f,m);
% p =  2.0000    1.0000   -3.0000    1.0000
% foegyutthatoval kezdodo sorrend a polyfit eredmenye!
% a polinom = L_3(x) = 2*x^3+1*x^2-3*x+1

figure
plot(x,f,"*")
hold on
xx = linspace(min(x),max(x),100);
y = polyval(p,xx);
plot(xx,y)
%Ellenorzes:  az abran a polinom gorbejenek at kell haladni a pontokon!
plot(x,f,"*",xx,y,'r')

%% 2. 
% Hatarozzuk meg a (-3, -6), (-2, -17), (-1, -8), (1, -2), (2, 19)
% pontokra illeszkedo
% minimalis fokszamu polinomot! Es abrazolja egy kozos abran a
% pontokat es az illesztett polinomot!

x = [-3 -2 -1 1 2];
f = [-6 -17 -8 -2 19];

m = length(x)-1;

p = polyfit(x,f,m);

figure
plot(x,f,"*")
hold on
xx = linspace(min(x),max(x),100);
y = polyval(p,xx);
plot(xx,y)


%% 3. 
% Hatarozzuk meg a (-3, -31), (-2, -8), (1, 1), (2, 22)
% pontokra illeszkedo
% minimalis fokszamu polinomot! Es abrazolja egy kozos abran a
% pontokat es az illesztett polinomot!

x = [-3 -2 1 2];
f = [-31 -8 1 22];

m = length(x)-1;

p = polyfit(x,f,m);

figure
plot(x,f,"*")
hold on
xx = linspace(min(x),max(x),100);
y = polyval(p,xx);
plot(xx,y)

%%
% Kozelitse az f(x) = e^x - sin(pi*x)
% fuggvenyt a [0,1] intervallumon egy masodfoku polinommal.
% Abrazolja az eredeti es az illesztett fuggvenyt kozos abran.

x = linspace(0,1);
y_f = exp(x) - sin(pi*x);

p = polyfit(x,y_f,2);
y_pol = polyval(p,x);

plot(x,y_f,'r-')
hold on
plot(x,y_pol,'b:')
legend('f(x)','poligon')

%%
% Tudjuk, hogy egy test meterben szamolva
% s0 utat tett meg, egyenletes v0 (m/s) sebesseggel,
% majd azutan egyenletesen gyorsitani kezdett a (m/s^2)
% gyorsulassal. A gyorsulas kezdetetol szamolva 
% a 2., 4., es 5. masodperc vegen az osszes megtett ut
% rendre 16, 38 es 52 m.
% Hatarozza meg s0, v0 es a erteket.

t = [2,4,5]';
f = [16,38,52]';
p = polyfit(t,f,2)
x = linspace(0,6);
plot(t,f,'b*',x,polyval(p,x),'r-')
hold on 
plot(x,2.*x+5,'g')
s0 = polyval(p,0)

%%
% Rajzoltassuk ki kozos abran az alabbi 3 fuggvenyt
x = linspace(-1,1);
f = 1./(1+25*x.^2);
plot(x,f,'k')
hold on 

xx = -1:0.2:1;
f = 1./(1+25*xx.^2);
p = polyfit(xx,f,length(xx)-1);
plot(x,polyval(p,x),'r')

k = 1:11;
xx = cos(((2*k-1)/22)*pi);
f = 1./(1+25*xx.^2);
p = polyfit(xx,f,length(xx)-1);
plot(x,polyval(p,x),'g')

%%
% Spline interpolacio
% Kiegeszites: 
% spline(), fuggveny hasznalata, eredmenyenek ertelmezese
% plot()

% spline() fuggveny: Eloallıtja a szakaszonkent harmadfoku spline egyutthatoit. Itt x az
% alappontok vektora, az y vektor elso es utolso koordinataja a ket
% vegpontban adott derivaltertek, a tobbi koordinata a fuggvenyertekek.

% Pelda feladatok: 

% 1.
% Hatarozzuk meg az alabbi adatokhoz tartozo harmadfoku spline-t!
% Egy kozos abran rajzoljuk ki a pontokat es a gorbet!
% xi -2 -1 0 1  2 3
% S   4  1 7 4 12 9
% S' 15           8

x = -2:3;
y = [15 4 1 7 4 12 9 8]; % az elso es utolso helyre az S' ertekei kerulnek

xx = linspace(min(x),max(x));


% a spline fv 2 parameterrel az egyutthatokat adja vissza:
p = spline(x,y)
% mig 3 parameterrel ki is ertekeli egybol a 3. inputkent megadott
% pontokban:
yy = spline(x,y,xx);

plot(x,y(2:end-1),'*') % az y-ban eredetileg belerakott 2 plusz S' erteket nem akarjuk kirajzolni!
hold on
plot(xx,yy) % a spline kirajzolasa

%%
% Rajzoltassuk ki kozos abran az alabbi 3 fuggvenyt
x = linspace(-1,1);
f = 1./(1+25*x.^2);
plot(x,f,'k')
hold on 

xx = -1:0.2:1;
f = 1./(1+25*xx.^2);
p = polyfit(xx,f,length(xx)-1);
plot(x,polyval(p,x),'r')

xx = -1:0.2:1;
y = [0,1./(1+25*xx.^2),0];

plot(x,spline(xx,y,x),'g')

%%
%%%%%%%%

% Tovabbi peldak
% Mennyi lesz annak a minimális fokszámú polinomnak az értéke
% a -2.4 helyen, mely illeszkedik
% az f(x) = 1/(1+cos^2(x)) függvényre
% a -2.8, -1.2, 1.0, 1.2, 2.4 pontokban.
% Adja meg az illesztett polinom els?fokú tagjának együtthatóját. Válaszait
% 2 tizedesjegyre kerekítse.


% A minimális fokszámú polinom illesztése a feladat -> interpoláció.
% A megadott pontok most nem pontpárokban vannak, hanem csak az "x" els?
% koordináta van meg pontosan, ehhez ki kell számolni a függvény által
% adott értékeket.

x = [-2.8, -1.2, 1.0, 1.2, 2.4];
% az x vektor pontjait használjuk fel, mindre kiszámoljuk az értékeket.
% a pontozott operátorokat használjuk, mert vektorral (az x vektor) dolgozunk.
f = 1 ./ (1 + cos(x).^2);

% minimális fokszám = adatok darabszáma -1
n = length(x) -1;
% polinom illesztése pontokra polyfit fv-el
% együtthatók =  polyfit(pontok 1. koord, pontok 2. koord., fokszám)
p = polyfit(x,f,n)

% negyedfokú polinom együtthatóinak száma 5
% a p vektor tartalmazza az együtthatókat:
% p = -0.0573   -0.0228    0.4123    0.0328    0.4090
% a f?együtthatóval kezd és a konstans taggal ér véget
% az illesztett polinom ezek alapján: 
% p(x) = -0.0573x^4   -0.0228x^3 + 0.4123x^2 + 0.0328x + 0.4090

% az els?fokú tag együtthatója: 0.0328, két tizedesre kerkítve: 0.03

% a polinom helyettesítési értéke a -2.4 helyen
% polinom együtthatói alapján a kiértékelés a polyval fv-el
% polyval(polinom együtthatók a f?együtthatóval kezdve, pontok ahol ki akarjuk értékelni)
polyval(p, -2.4)

% 1.12 a helyettesítési érték 2 tizedesre kerekítve

%%

% Milyen értéket vesz fel az a -2 helyen
% az a minimális fokzámú H polinom, melyre
% H(-4)=-69, H(-1)=-6, H'(-4)=33?

% Mivel minimális fokszámú polinom, ezért interpolációs feladat.
% Mivel az egyik adott érték az els? derivált, így Hermit interpoláció
% Ehhez az osztott differencia táblázatot kell kiszámolnunk.
% nincs Matlab fv.
% -4 | -69 
%          33/1!=33
% -4 | -69                          (21-33)/(-1-(-4))=-4
%          (-6-(-69))/(-1-(-4))=21
% -1 | -6

% H_2(x) = -69 + 33*(x-(-4))-4*(x+4)^2
% -2 helyen a polinom értéke
x = -2;
-69 + 33*(x-(-4))-4*(x+4)^2
% -19
