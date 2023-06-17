%%

0.4 - 0.5 + 0.1 == 0

0.1 - 0.5 + 0.4 == 0

0.5 - 0.4 - 0.1 == 0

0.5 - 0.1 - 0.4 == 0

% 0.1 binaris alakja : 0.0001100110011...
% 0.4 binaris alakja : 0.01100110011...
% 0.5 binaris alakja : 0.1

%%
% Az alabbi algoritmus vegrehajtasa utan mennyi az x elmeleti, illetve a gepi
% szamıtas utan adodo erteke?

x=1/3;
for i=1:40
    x=4*x-1
end
x

%% Vizsgalja meg az alabbi kifejezesek erteket!

2^66 + 1 == 2^66
2^66 + 10 == 2^66
2^66 + 100 == 2^66
2^66 + 1000 == 2^66
2^66 + 10000 == 2^66
%%
% Mi lesz a legkisebb olyan n>0 szam, amire mar hamis lesz a 2^66 + n == 2^66? 

k = 1000;
while 2^66 + k == 2^66
   k = k + 1;
end
k


%%
% Mit tapasztal, ha az alabbi kodokat lefuttatja?
%%
a = 0;
for i = 1:5
    a = a + 0.2;
end
a == 1

a = 1;
for i = 1:5
    a = a - 0.2;
end
a == 0

%% Lebegopontos szamitasok
a = 2;
t = 4;
kmin = -3;
kmax = 2;

gepi_eps = a^(1-t);
%%
% Irjunk kodot a tenyleges gepi epszilon meghatarozasara!
k = -60;
while 1 + 2^k == 1
   k = k + 1;
end
k

%%
% Beepitett fuggveny
help eps
%% 
eps(1)
eps(1) == 2^k

%% Irjon kodot az epsilon 0 meghatarozasara

k = -2000;
while 0 + 2^k == 0
   k = k + 1;
end
k
%% Beepitett fuggveny
eps_0 = eps(0)
eps_0 == 2^k
%% Visszautalva az elozo feladatra, a jobb szomszedtol valo tav
eps(2^66)

%%
realmin()
realmax()
%%
x = 1/3;
for i=1:40
    x = 4*x-1
end
x
%%
x = 1;
for i = 1:200
	(exp(x)-1)/x
	x = x/2;
end
%%
a  = [0 0.1 0.2 0.3 0.4];
b  = 0:.1:.4;
as = sprintf('%20.18f\n',a)
bs = sprintf('%20.18f\n',b)

a == b 
% helyett csak a feladat pontossagat figyelembe veve adjunk meg egy
% tolerancia hiba erteket, amit vizsgaljunk!
tol = 1e-10
abs(a-b) < tol

all(abs(a-b) < tol)


%