%% Sajatertekek, sajatvektorok

% A*x = lambda*x egyenletet teljesito 
% lambda ertek az A matrix sajaterteke, 
% x vektor a lambdahoz tartozo sajatvektora.

% pl.
A = [0,1,1;0.8,0,0;0,0.25,0]
% beepitett fv:
eig(A)
%%

u=eig(A)
%% egy u vektorral ter vissza, melynek elemei az A sajatertekei
%%
[V,U]=eig(A)
% Ket matrixszal ter vissza, az elso matrix oszlopvektorai az A
% sajatvektorai, a masodik matrix diagonalisaban levo ertekek az A
% sajetertekei (a sajatvektoroknak megfelelo sorrendben).
%% Pelda feladatok:

% Egeszitse ki az alabbi x vektort ugy,
% hogy az A matrix legnagyobb sajatertekehez
% tartozo sajatvektor legyen! 

A=[73,32,19,10;-73,-32,-17,-11;-116,-50,-32,-16;-88,-40,-26,-9]
%x1=1 x2= ?, x3= ?, x4= ?
%%

[U,V] = eig(A)
%%
v = U(:,4) % 3 s.ertekhez tartozo s.vektor
%%
l = 1/v(1)
v*l

% -0.5;-1;-3.5

%%
% A nyulak populacioja feladat mintajara:
% Halak egy zart populaciojara a kovetkezo teljesul:
% a halak nem elnek 3 evnel tovabb,
% az elso evben nem keletkezik utoduk,
% a masodik evben atlagosan 6,
% a harmadik evben atlagosan 8 utoduk lesz.
% Az 1 es 2 eves halak 50-50%-a eli meg a kovetkezo evet.
% Irja fel a megfelelo Leslie-matrixot 
% es hatarozzon meg egy stabil koreloszlast.
A = [0,6,8;0.5,0,0;0,0.5,0]
%%
[U,V] = eig(A)
%%
% 2 az egyetlen pozitiv s.e.
% ehhez tartozo s.v:
x = U(:,1)
%% az arany megadasa:
x = x/sum(x)
%%
x= A*x
x = x/sum(x)
%% PageRank - eloadas folia abra es levezetes

%% Pelda
% Negy weboldalat figyelve azt latjuk,
% hogy az egyes odalak a masik harombol 
% a lent felsoroltakra hivatkoznak.
% Az oldalak sulyait rendszeresen ujraszamoljuk ugy, 
% hogy minden oldal az eppen rendelkezesre allo sulyat 
% egyforma aranyban osztja szet azon oldalaknak,
% amikre hivatkozik. Adjon meg egy stabil sulyeloszlast!

%1. oldal:[2,3]
%2. oldal:[1]
%3. oldal:[4]
%4. oldal:[1,2,3]
% ez alapjan a matrix:
A = [0,1,0,1/3;1/2,0,0,1/3;1/2,0,0,1/3;0,0,1,0]
%%
% olyan x-et keresunk, ami valamilyen lambda eseten: A*x = lambda*x
[U,V] = eig(A)
%% lambda = 1 eseten pozitiv ez az ertek - ehhez tartozo sajatvektor:
x = U(:,1)
%% 
% ellenorzes:
A*x
%%
% Az alabbi v vektorban szereplo sulyeloszlas stabil-e?
v=[0.3077,0.2308,0.2308,0.2308]'

A*v

%% Szoveges pelda
%Egy cegnek egy adott varoson belul 3 telephelye van. Minden ev elejen a
%dolgozok jelentos reszet masik telephelyre kuldik dolgozni: az elso
%telephelyen a korabbi dolgozok 10%-a ottmarad, es ide helyezik at a
%masodik telephely dolgozoinak 50%-at, illetve a 3. telephely dolgozoinak
%40%-at. A masodik telephelyen szinten marad a dolgozok 10%-a, es meg
%ide kerul az 1. telephely dolgozonak 30%-a, illetve a 3. telephely
%dolgozoinak 50%-a. A harmadik telephelyen 10% marad a korabbi
%dolgozokbol, es ide helyezik az 1. telephely dolgozoinak 60%-at, illetve a
%2. telephely dolgozoinak 40%-at. Lehet-e olyan kiindulo eloszlast mondani
%a dolgozok szamara, mely az evek soran nem valtozik?
A = [0.1, 0.5,0.4;0.3,0.1,0.5;0.6,0.4,0.1]
%%
[U,V] = eig(A)
x = U(:,1)
%%
%A*x
x = x/sum(x)
%% Hatvanymodszer
% x_(k+1) = A*x_(k)
% Tulcsordulas elkerulese erdekeben normaljuk a keletkezo vektorokat!
% Megfelelo feltetelek teljesulese eseten a vektorsorozat tart az
% abszolutertekben legnagyobb sajatertekhez tartozo sajatvektorhoz.


%% Halpopulacio pelda folytatasa:
A = [0,6,8;0.5,0,0;0,0.5,0]
[U,V] = eig(A)
x = U(:,1)
%%
% kiindulo populacio
x = [50,50,50]';

for i = 1:15
   x = A*x 
end
%%
% normaljuk, hogy ne csorduljon tul
x = [50,50,50]';

for i = 1:15
   x = (A*x);
   x = x/norm(x)
end
%% Hatvanymodszer a sajatertek kozelitesere - Rayleigh hanyados
% J(lambda) = norm(A*v - lambda*v,2) Euklideszi normaban vett minimumat
% a lambda = (Av,v)/(v,v) helyen veszi fel.
% Hatvanymodszerrel:
% kiszamoljuk a lambda_k = (Ax_k,x_k)/(x_k,x_k), es k tart vegtelen eseten 
% a lambda_k konvergal a keresett sajatertekhez

% Az elozo feladat x_15 vektoraval:
x
% belso szorzat = skaláris szorzat = dot product
lambda = dot(A*x,x)/dot(x,x)

%% Pelda
% Az alabbi A matrix es v vektor eseten melyik
% lambda-ra lesz minimalis
% az Av - lambda*v vektor euklideszi normaja?
% Valaszat 4 tizedesjegyre kerekitse.
A = [3,-2,0;0,-3,2;3,-3,2];
v = [-3;-5;0];
lambda = dot(A*v,v)/dot(v,v)

%% Inverz-iteracio
% A hatvanymodszert az A inverzre alkalmazzuk.
% Mivel ez koltseges, ezert nem az x_(k+1) = inv(A)*x_k egyenletet
% szamoljuk, hanem: A*x_(k+1) = x_k linearis egyenletrendszert oldjuk meg.
% Mivel az egyenletrendszer A matrixa minden k-ra ugyanaz, igy
% alkalmazzunk LU-felbontast elso lepesben.

A = [2,-2,3;1,1,1;1,3,-1];
[L,U] = lu(A);
x = [1,0,0]' % kezdo vektor
for k = 1:50    
    x = U\(L\x);
    k
    lambda = dot(A*x,x)/dot(x,x)
end

%% Egyeb szoveges feladat

%% Strand bufe
% Egy strandon 3 bufe mukodik, melyeknek a tulajdonosai sor arat minden
% reggel a masik ket bufe elozo napi arainak fuggvenyeben allıtjak be. 

% Az I. bufe tulajdonosa a masik ket bufe arainak szamtani kozepekent, 

% a II. bufe tulajdonosa az I. bufebeli ar 40%-anak es 
% a III. bufebeli ar 50%-anak osszegekent, 

% a III. bufe tulajdonosa pedig az I. bufebeli ar 60%-anak es a
% II. bufebeli ar 50%-anak osszegekent. 

% Hatarozzon meg egy olyan kiindulo araranyt,
% mely a napok soran valtozatlan marad. Vizsgalja meg hogyan
% alakul a bufekben a sor araranya, ha kezdetben azonos aron arultak a sort.

A = [0, 0.5,0.5;0.4,0,0.5;0.6,0.5,0]
%%
[V,U] = eig(A)

%%
x = V(:,1)
x = x/sum(x)

%%
x = A*x
%% 
% sor araranya
x = [1,1,1]'
%%
x = A*x
%% Szoveges
% Egy egyetem hallgatoi minden nap a kovetkezo 3 lehetoseg
% kozul valasztanak: vagy az egyetemi menzan ebedelnek,
% vagy a kozeli etelbarban, vagy maguknak foznek ebedet. 
% A menzan annyira rosszul foznek, hogy ket egymas utani
% napon senki nem eszik ott, viszont itt ebedel az elozo napon
% az etelbart valasztok 20 %-a, illetve 30 %-a azoknak,
% akik elozo nap maguknak foztek. Az etelbarban ebedelok 40 %-a 
% masnap is ide ter vissza, es itt fog enni az elozo napon 
% a menzan ebedelok 80 %-a, es a maguknak fozok 10 %-a.
% Azok kozul, akik maguknak foztek 60 % masnap is ezt 
% a megoldast valasztja, es szinten maganak fog fozni az 20,
% illetve 40 %-a azoknak, akik a menzan, 
% illetve az etelbarban ettek a megelozo napon.
% Tudjuk, hogy igy minden nap mindharom megoldast ugyanannyian 
% valasztjak,
% mint az azt megelozo napon. Adja meg, hogy egy adott napon 
% a hallgatok mekkora hanyada ebedel az egyes modokon. 
% Valaszat tizedestort alakban, 
% 2 tizedesjegyre kerekitve adja meg
% (pl. 51.7% eseten a valasz 0.52).
A = [0,0.2,0.3;0.8,0.4,0.1;0.2,0.4,0.6]
%%
A = [0-1,0.2,0.3;0.8,0.4-1,0.1;0.2,0.4,0.6-1;1,1,1]
%%
A\[0;0;0;1]