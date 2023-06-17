%% Linearis programozas
% 1. feladat
% Oldjuk meg grafikus uton az alabbi feladatot!
% Egy butoripari vallalkozas ketfele butort gyart: talaloszekrenyt es komodot.
% Egy talaloszekreny eloallitasahoz 2 egyseg faanyagra, 1 egyseg lakkra es 1
% egyseg uvegre, meg egy komod eloallitasahoz 1 egyseg faanyagra es 1
% egyseg lakkra van szukseg. Egy talaloszekrenyt 30 ezer, egy komodot 20
% ezer Ft-ert lehet eladni. Hatarozza meg a maximalis bevetelt biztosıto
% gyartasi tervet, ha 100 egyseg faanyag, 80 egyseg lakk es 40 egyseg uveg
% all rendelkezesre!

% Irjuk fel a modellt!
% Keszitsunk abrat hozza!
figure
hold on
fplot(@(x) 100-2*x)
fplot(@(x) 80-x)
%xline(40) % fuggoleges vonal
plot([40,40],[0,100]) % fuggoleges vonal
%%
for z=0:10:100
    fplot(@(x) z-3/2*x,'r:' )
end
%%
axis([0,100,0,100])


%%
c = [-30000;-20000];
A = [2,1;1,1;1,0];
b = [100;80;40];
Aeq = [];
beq = [];
lb = [0;0];
ub = [];
x = linprog(c,A,b,Aeq,beq,lb,ub)
plot(x(1),x(2),'r*')
%% Oldja meg az alabbi feladatot a modell alapjan!
% P(x) = 4*x1 + 3*x2 -> max
% x1 + x2 < = 40
% 2*x1 + x2 < = 60
% x1, x2 > = 0 

% Mennyi lesz az x2 valtozo optimalis erteke?
x = linprog([-4;-3],[1,1;2,1],[40;60],[],[],[0;0],[])
x(2)

%%
% Oldja meg grafikus uton az alabbi feladatot!
% Egy edesipari vallalatnal ketfele turodesszertet (natur es kakaos)
% gyartanak. Egy egyseg natur desszert eloallıtasahoz 20 egyseg edesıtett
% turora es 50 egyseg tejszınre van szukseg, mıg egy egyseg kakaos
% desszerthez 40 egyseg edesıtett turora, 20 egyseg tejszınre es 2 egyseg
% kakaora. A kakaos desszertet 300 Ft/egyseg, a naturt 190 Ft/egyseg aron
% lehet ertekesıteni, az eloallıtasi koltseguk 100 Ft/egyseg (kakaos) es 90
% Ft/egyseg (natur). Milyen gyartasi arany mellett erheto el a maximalis
% nyereseg, ha 280 egyseg edesıtett turo, 300 egyseg tejszın es 12 egyseg
% kakao all rendelkezesre?

% Irjuk fel a modellt!
% x1 a natur desszer db, x2 a kakaos desszert darabszama.

% 20x1+40x2<=280
% 50x1+20x2<=300
% 2x2<=12
% P(x) = (190-90)*x1 + (300-100)*x2
% P(x) = 100x1+200x2->max

% Keszitsunk abrat hozza!
figure
hold on
fplot(@(x) (280-20*x)/40)
fplot(@(x) (300-50*x)/20)
fplot(@(x) 6) % vizszintes vonal = konstans fv
%%
for z=0:1:30
    fplot(@(x) z-100/200*x,'r:' )
end
axis([0,30,0,30])


%%
c = [-100;-200];
A = [20,40;50,20;0,2];
b = [280;300;12];
Aeq = [];
beq = [];
lb = [0;0];
ub = [];
x = linprog(c,A,b,Aeq,beq,lb,ub)
%%
[x,fval,exitflag,output,lambda] =  linprog(c,A,b,Aeq,beq,lb,ub)

%%
plot(x(1),x(2),'r*')

%% Tovabbi peldak
% A modell: 
% 2*x1 + 7*x2 <= 84
% 4*x1 + 5*x2 <= 78
% 6*x1 + 4*x2 <= 96
% x1,x2 >= 0
% 10*x1 + 9*x2 -> max

% Matlab lionprog fuggvennyel oldjuk meg!
% Adjuk meg a ket termek arnyekarat is!
% Mennyi a maximalis profit?


A = [2,7;4,5;6,4];
b = [84;78;96];
c = [-10;-9]; % minimalizalas
Aeq = [];
beq = [];
lb = [0;0];
ub = [];
x = linprog(c,A,b,Aeq,beq,lb,ub)
%%
% help linprog
[X,FVAL,EXITFLAG,OUTPUT,LAMBDA] = linprog(c,A,b,Aeq,beq,lb,ub)
%%
% 1. termek
X(1)
% 2. termek
X(2)
% maximalis haszon
FVAL * -1
% fel nem hasznalt nyersanyagok mennyisege
maradek = b - A*x
A_maradek = maradek(1)
C_maradek = maradek(3)
%% arnyekar
lambda.ineqlin

%% hasonlo gyartasi feladat
A = [3,5;5,4;6,1];
b = [70;69;60];
c = [11;4]* -1; % minimalizalas
Aeq = [];
beq = [];
lb = [0;0];
ub = [];

[X,FVAL,EXITFLAG,OUTPUT,LAMBDA] = linprog(c,A,b,Aeq,beq,lb,ub)

% 1. termek
X(1)
% 2. termek
X(2)
% maximalis haszon
FVAL * -1;
% az A es C nyersanyagok arnyekara
LAMBDA.ineqlin([1,3])

%% Konzervgyar feladat
% 2 telephely, 3 termelo

A = [1,1,1,0,0,0;0,0,0,1,1,1;1,0,0,1,0,0;0,1,0,0,1,0;0,0,1,0,0,1];
b = [460;560;200;310;420];
c = [10;12;9;14.5;16.5;16]* -1; % minimalizalas
Aeq = [];
beq = [];
lb = [0;0;0;0;0;0];
ub = [];


[x,fval,exitflag,output,lambda] =  linprog(c,A,b,Aeq,beq,lb,ub)

%% Tapok
% A es B tap 4 fele alapanyagbol

A = [0.2,0;0,0.2;0.1,0.2;0.7,0.6]*-1;
b = [0.2;0.4;1;4.2]*-1;
c = [30;40];
Aeq = [];
beq = [];
lb = [0;0];
ub = [];


[x,fval,exitflag,output,lambda] =  linprog(c,A,b,Aeq,beq,lb,ub)