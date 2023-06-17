%% Legkisebb negyzetek modszere

% Megfigyelt folyamat vagy kiserlet meresei az alappontok. 
% Ezekhez szeretnenk egy megadott modellt kozeliteni. 
% Mivel az alappontjaink, a meresek hibaval terheltek is lehetnek, igy nem
% celunk a tokeletes illeszkedes a pontokra, csak azt a modellt szeretnenk
% megtalalni, amelyik a legkozelebb esik a pontokhoz, azaz ami legjobban
% leirja a jelenseget, amit megfigyelunk.

%%
% alappontok meresi ideje: (abrazolaskor az elso koordinata, ha az ido az x tengely)
t = [0,2,4,6,8,10,12];

% a mert ertekek pl. a vizszint cm-beli allasa egy (50cm) tartalyban 
f = [3,4,5,5.5,6.5,7,8];

% A valasztott modell:
% F(t) = x_1 + x_2*t
% azaz ket ismeretlen parametere van a modellnek es az egyutthatoik: 1 es t

% abrazoljuk a pontokat!
plot(t,f);
%%
% Becsulje meg milyen magasan lesz a viz 20 perccel a meres inditasa utan!
% Mikor lesz tele a tartaly?

% Ezekhez ki kell szamolnunk a legkisebb negyzetes ertelemben legjobban
% kozelito modell parametereit, jelenleg x_1-et es x_2-t!

% Mivel ez egy linearis modell = elsofoku modell, ezert a egy elsofoku
% polinomot illesztunk az adatokra:
p = polyfit(t,f,1)% 1 a fokszam, mert egyenes/linearis modell/elsofoku polinom
% a p valtozoban vektorkent kapjuk vissza a polinom egyutthatoit a
% foegyutthatoval kezdve!
% Azaz x_1+x_2*t modell eseten x_2, x_1 sorrendben!
% p = 0.4018    3.1607 eseten
% F(t) = 3.1607 + 0.4018*t

%%
% A kirajzolashoz szukseg van a pontok megjelenitesere:
figure
plot(t,f,"*")

% ugyanerre az abrara rajzoljunk tovabb
hold on

% kiertekeljuk kello surusegben (100 pont eleg), a polinomot/modellt!
% a linspace fv kezdo es utolso ereteke az abrazolni kivant intervallum
% legyen, ami most nekunk az az intervallum, ahol a pontok is
% elhelyezkednek
x = linspace(min(t),max(t),100);
% a polyval fv. kiertekeli a p (korabban kiszamolt) polinom egyutthatok
% altal meghatarozott polinomot a megadott x pontokban
% visszateresi erteke az y vektor annyi elemu, amennyi az x vektor

y = polyval(p,x);
plot(x,y)

%%
% A kerdesekre elso valszkent rajzoljuk ki hosszabban a modellt!
figure
plot(t,f,"*")
hold on
x = linspace(-10,20,100);
y = polyval(p,x);
plot(x,y)
%% Es szamoljuk is ki, hogy mit josol a modell:
% Becsulje meg milyen magasan lesz a viz 20 perccel a meres inditasa utan!
polyval(p,20)
%% Mikor lesz tele a tartaly?
% azaz 50 = x_1 + x_2 * t -> t = ?
(50 - p(2))/p(1)

%%
% Polinomialis modellek eseten polyfit es polyval fuggvenyek hasznalata
% Elsofoku (linearis), masodfoku, harmadfoku stb. modellek

% F(t) = x_1 + x_2*t
% F(t) = x_1 + x_2*t + x_3*t^2
% F(t) = x_1 + x_2*t + x_3*t^2 + x_4*t^3
% ...
% Lathatjuk, hogy mindig eggyel tobb parameter van, mint ahanyadik foku a
% polinom. A modell foegyutthatoval kezdodo sorrendben is azonos modon
% szamolhato!

t = [-2,-1,0,3,6,8,12];
f = [-15,-9,-5,1,2,7,17];

p = polyfit(t,f,3)
x = linspace(min(t),max(t));
y = polyval(p,x);

plot(t,f,'b*',x,y,'r-')

%% Mi a modellunk? 
% p = 0.0311   -0.4956    3.3623   -5.4993
% F(t) = 0.0311*t^3 - 0.4956*t^2  +  3.3623*t   -  5.4993

%%
% Hatarozzuk meg az alabbi adatokat legkisebb ertelemben legjobban kozelito
% egyenest!

t = [1 1.1 1.1:0.1:2];
f = [8 8.9 9 9.8 10 11 11.5 11.5 12.5 13 13.7 14];

% 'egyenes' = 'linearis modell' = 'elsofoku polinom' = 'elsofoku modell'
p = polyfit(t,f,1)

% Az egyenes: 5.8235*t + 2.5338
%%
%Egy ipari merlegen egy nagyobb mennyisegu gabona van, amit valaki
%egyenletes sebesseggel lapatol a merlegrol zsakokba. Miutan elkezdte a
%munkat, idonkent megnezzuk mennyit mutat a merleg. Az alabbi ertekeket
%lattuk:
% ido (perc)
t = [1,15,20,28];
% tomeg (kg)
f = [980,605,470,250];

% Becsuljuk meg mennyi ideig tart, amıg az osszes gabonat zsakokba rakja,
% illetve eredetileg mennyi gabona volt a merlegen.

plot(t,f)
%% Ez alapjan linearis modell jol kozelitheti a folyamatot:
p = polyfit(t,f,1);
x = linspace(0,40);
y = polyval(p,x);
plot(t,f,'b*')
hold on
plot(x,y)
%%Mennyi ideig tart amig az osszes gabona elfogy a merlegrol? 

vege = (0 - p(2))/p(1)
polyval(p,vege) % ellenorzes
%% Mennyi gabona volt eredetileg a merlegen?
polyval(p,0)

%%
% Hatarozzuk meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto masodfoku polinomot!
t = [2.1 2.2 2.3 2.3 2.5 2.6 2.8 2.9]; 
f = [2.5 2 2.5 2.7 3 4 5.4 7];
p = polyfit(t,f,2);
x = linspace(min(t),max(t));
y = polyval(p,x);
plot(t,f,'b*')
hold on
plot(x,y)


%%
%
% Altalanos modell
% Megoldasa a Gauss-fele normalegyenlettel!
%

% Hatarozza meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto F(t) = x1 + x2*cos(pi*t) + x3*sin(pi*t)
% alaku modell parametereit! Es abrazolja egy kozos abran a
% pontokat es a kozelito modellt!
% ti 0.1 0.5 1.2 1.5 2 2.1 2.4 3 3.2
% fi 3.9 2.6 -0.8 0.3 3.2 3.8 3.2 -0.7 -0.9

% Mivel itt altalanos esetben a Gauss-fele normalegyenlettel fogunk
% dolgozni, fontos, hogy a pontok oszlopvektorban legyenek megadva!
t = [0.1 0.5 1.2 1.5 2 2.1 2.4 3 3.2]';
f = [3.9 2.6 -0.8 0.3 3.2 3.8 3.2 -0.7 -0.9]';

% mivel nem polinom a modell, igy nem hasznalhatjuk a polyfit fv-t!
% Viszont minden modell eseten fel tudjuk epiteni a Gauss-fele
% normalegyenlet altal hasznalt A matrixot, s azzal tudunk szamolni!
% az egyutthato fuggvenyek a modell alapjan:
% fi_1(t) = 1
% fi_2(t) = cos(pi*t)
% fi_3(t) = sin(pi*t)
% Ezeket irjuk oszlopokba egymas melle, behelyettesitve a t vektor ertekeit

A=[ones(length(t),1), cos(pi*t), sin(pi*t)];


% A normalegyenlet A'*A*x = A'*f
% a backslash operator segitsegevel kifejezzuk az x vektort

x = (A'*A)\(A'*f) % Ez az x a modell parametereit tartalmazo vektor

% Ha x = 1.4372
%        2.0310
%        1.1711
% F(t) =  1.4372 + 2.0310 cos(pi*t) + 1.1711 sin(pi*t)

% Abrazolas: pontok es a modell gorbeje:
figure
plot(t,f,"*")
hold on
xx = linspace(min(t),max(t),100); % az x vektor most a parametereket tartalmazza
% A modell kiertekelesehez fel kell irni a modellt a kiszamolt
% parametereivel (A polyval csak polinomok eseten hasznalhato!)
y = x(1)+x(2)*cos(pi*xx)+x(3)*sin(pi*xx);

plot(xx,y)

%%
% Tovabbi feladatok:
%%
% Hatarozza meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto egyenes egyenletet! Es abrazolja egy kozos abran a
% pontokat es a kozelito modellt!
% t 1 1.2 1.4 1.4 1.5 1.7 1.9 2
% f 6.2 7 8 7.9 8.4 9.2 10 10.6

t = [1 1.2 1.4 1.4 1.5 1.7 1.9 2];
f = [6.2 7 8 7.9 8.4 9.2 10 10.6];

p = polyfit(t,f,1);
figure
plot(t,f,"*")
hold on
x = linspace(min(t),max(t),100);
y = polyval(p,x);
plot(x,y)


%%
% Hatarozza meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto harmadfoku polinomot! Es abrazolja egy kozos abran a
% pontokat es a kozelito modellt!
% t 0.5 0.8 1.1 1.3 1.5 1.7 1.9 2.1 2.3
% f 2.5 2.3 1.8 1.3 0.9 0.4 0.1 -0.05 -0.01

t = [0.5 0.8 1.1 1.3 1.5 1.7 1.9 2.1 2.3];
f = [2.5 2.3 1.8 1.3 0.9 0.4 0.1 -0.05 -0.01];

p = polyfit(t,f,3);
figure
plot(t,f,"*")
hold on
x = linspace(min(t),max(t),100);
y = polyval(p,x);
plot(x,y)


%%
% Hatarozza meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto F(t) = x1 + x2/t
% alaku modell parametereit! Es abrazolja egy kozos abran a
% pontokat es a kozelito modellt!
% ti 1 1.2 1.4 1.4 1.5 1.7 1.9 2 2.1 2.2
% fi 4.2 3.8 3.4 3.3 3.3 3 2.8 2.8 2.75 2.7

t = [1 1.2 1.4 1.4 1.5 1.7 1.9 2 2.1 2.2]';
f = [4.2 3.8 3.4 3.3 3.3 3 2.8 2.8 2.75 2.7]';

% az egyutthato fuggvenyek a modell alapjan:
% fi_1(t) = 1
% fi_2(t) = 1/t
% Ezeket irjuk oszlopokba egymas melle, behelyettesitve a t vektor ertekeit

A=[ones(length(t),1), 1./t];

% A normalegyenlet A'*A*x = A'*f

x = (A'*A)\(A'*f) % Ez az x a modell parametereit tartalmazo vektor


figure
plot(t,f,"*")
hold on
xx = linspace(min(t),max(t),100); 
y = x(1)+x(2)./xx;
plot(xx,y)
%%
% Hatarozza meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto F(t) = x1*sin(t) + x2*sin(2t) + x3*sin(3t)
% alaku modell parametereit! Es abrazolja egy kozos abran a
% pontokat es a kozelito modellt!
% ti 0.1 0.5 1.2 1.5 2 2.1 2.4 3 3.2 3.4 3.8 4 4.2 4.6 5
% fi 1 4.1 3 1 -1.5 -1.6 -1.7 -0.4 0.1 0.7 1.6 1.8 1.6 0.2 -2.5

t = [0.1 0.5 1.2 1.5 2 2.1 2.4 3 3.2 3.4 3.8 4 4.2 4.6 5]';
f = [1 4.1 3 1 -1.5 -1.6 -1.7 -0.4 0.1 0.7 1.6 1.8 1.6 0.2 -2.5]';

% az egyutthato fuggvenyek a modell alapjan:
% fi_1(t) = sin(t)
% fi_2(t) = sin(2t)
% fi_3(t) = sin(3t)
% Ezeket irjuk oszlopokba egymas melle, behelyettesitve a t vektor ertekeit

A=[sin(t), sin(2*t), sin(3*t)];

% A normalegyenlet A'*A*x = A'*f
x = (A'*A)\(A'*f)

figure
plot(t,f,"*")
hold on
xx = linspace(min(t),max(t),100); 
y = x(1)*sin(xx) + x(2)*sin(2*xx) + x(3)*sin(3*xx)
plot(xx,y)

%%
% Hatarozza meg az alabbi adatokat legkisebb negyzetes ertelemben
% legjobban kozelıto F(t) = x1 + x2*ln(t)
% alaku modell parametereit! Es abrazolja egy kozos abran a
% pontokat es a kozelito modellt!
% ti 0.1 0.5 1.2 1.5 2 2.1 2.4 3 3.2
% fi -0.6 1.5 2.5 2.9 3.2 3.3 3.5 3.8 3.9

t = [0.1 0.5 1.2 1.5 2 2.1 2.4 3 3.2]';
f = [-0.6 1.5 2.5 2.9 3.2 3.3 3.5 3.8 3.9]';

% az egyutthato fuggvenyek a modell alapjan:
% fi_1(t) = 1
% fi_2(t) = ln(t)
% Ezeket irjuk oszlopokba egymas melle, behelyettesitve a t vektor ertekeit

A=[ones(length(t),1), log(t)];

% A normalegyenlet A'*A*x = A'*f
x = (A'*A)\(A'*f)

figure
plot(t,f,"*")
hold on
xx = linspace(min(t),max(t),100); 
y = x(1) + x(2)*log(xx);
plot(xx,y)

%%
% Havi kozephomersekletek atlagai Budapesten (1901-1950)
% ti 15 46 74 105 135 166 196 227 258 288 319 349
% fi -1.7 0.1 5.2 10.3 15.8 18.9 21.1 20.3 16.1 10.2 4.2 0.5

% Hatarozzuk meg az adatokat legkisebb negyzetes ertelemben legjobban
% kozelito F(t) = x1 + x2*cos(2*pi*(t-14)/365) alaku modell parametereit.

t = [15 46 74 105 135 166 196 227 258 288 319 349]';
f = [-1.7 0.1 5.2 10.3 15.8 18.9 21.1 20.3 16.1 10.2 4.2 0.5]';

% az egyutthato fuggvenyek a modell alapjan:
% fi_1(t) = 1
% fi_2(t) = cos(2*pi*(t-14)/365)
% Ezeket irjuk oszlopokba egymas melle, behelyettesitve a t vektor ertekeit

A=[ones(length(t),1), cos(2*pi*(t-14)/365)];

% A normalegyenlet A'*A*x = A'*f
x = (A'*A)\(A'*f)

figure
plot(t,f,"*")
hold on
xx = linspace(min(t),max(t),100); 
y = x(1) + x(2)*cos(2*pi*(xx-14)/365);
plot(xx,y)