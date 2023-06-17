%% Matlab vektorok, matrixok, beepitett fuggvenyek, operatorok

% Vektorok
a1 = [1,2,3,0.5,-2];

a2 = [1 2 3 0.5 -2];
%%
a1 == a2

ures_vektor = [];

b1 = 1:5;
b2 = 5:-1:0;
b3 = 2:0.2:3;

c1 = linspace(1,2,10);
c2 = linspace(1,100); % alapertelmezett darabszam 100

% Oszlopvektorok
d1 = [-3;0;7];
d2 = [-3,0,7]';
d3 = transpose([-3,0,7]);

% vektorok konstrualasa vektorokbol

e1 = [a1, b1];
e2 = [d1;d2];
e3 = [1, a1, 3, -1];
e4 = [2; e2; d1];
e5 = e4(2:4);
e6 = e4([2,3,4]);
e6(2) = []; % 6. elem torlese
e6([3, 7]) = []; % 3. es 7. elem torlese

% uj elemmel bovithetunk olyan indexre, amely eddig nem volt a vektorban!
% pl
a = [-1,3,2];
a(6) = 4;
% eredmeny: a = [-1,3,2,0,0,4]

% Hasznos beepitett fuggvenyek:
% dokumentacio: help fvneve
% pl: 
help min
% x legyen egy tetszoleges vektor 
x = 1:3:100;
min(x)
max(x)
sort(x)
sort(x,'descend')
flip(x)
length(x)
sum(x)
prod(x)
mean(x)
% indexeles
x(3)
x(1:2)
x(4:end)
x(:)
x([2,3,8])

% Muveletek azonos meretu vektorokkal 
a = 1:10;
b = 10:-1:1;

a+b;
a-b;
x = a+1;
x = a.^2;
x = a.*b;
x = a./b;
x = 1./a;
dot(a,b);

%% Feladatok
% Az elemek egyenkenti begepelese nelkul adjuk meg a kovetkezo vektorokat!
a = 0:30;
b = 2:2:100;
c = 2:-0.1:0;
d = [0:3:30,-100,30:-3:0];
e = 1./[2:20];
f = [1:19]./[2:20];

% legyen x egy adott 100 elemu sorvektor. AZ x vektorbol allitsa elo azt az
% y vektort, melynek elemei:
y1 = flip(x);
y2 = x(1:5);
y3 = x;
y3(4) = [];
y4 = x;
y4([5,72,93])  =[];
y5 = x(1:2:end);
y6 = x([2,5,17,81]);


%%
%Legyen adott az x sorvektor. A for utasitas hasznalata nelkul
%allitsa elo azt az y vektort, melynek i-edik eleme: 
x = linspace(1,100,5)
x = [1,2,3,4,5]% 10 az ellenorzeshez
% x(i)+2
y = x+2
% x(i)^2
y = x.^2
% 1/x(i)
y = 1./x
% sin(x(i)^3-1)
y = sin(x.^3-1);

% x(i)-i


y = x - [1:length(x)];


%% Matrix

A = [1,2,3,4;5,6,7,8;9,10,11,12];
A = [1:4;5:8;9:12];

%%
x = [-1 4 0];
y = [3 -2 5];
A = [-3 1 -4; 6 2 -5];

z = [A';x]
%%
% Konstrualjuk meg az elemek felsorolasa nelkul azt a B matrixot, melyet
% ugy kapunk, hogy:

% elhagyjuk az A matrix elso sorat
B = A;
B(1,:) = [];
% elhagyjuk az A matrix 2. es 4. oszlopat
B = A;
B(:,[2,4]) = [];
% elhagyjuk az A matrix utolso sorat es oszlopat
B = A;
B(end,:) = [];
B(:,end) = [];
B(end,end) = [];
% ketszer egymas melle irjuk  az A matrixot
B = [A,A];
% transzponaljuk az A matrixot
B = A';
% felcsereljuk az A matrix 2. es 4. oszlopat
B = A;
B(:,[2,4]) = B(:,[4,2]);
% negyzetre emeljuk az A elemeit
B = A.^2;
% az A minden elemet megnoveljuk 3-mal
B = A +3;
% A minden elemenek vesszuk a negyzetgyoket
B = sqrt(A);
% A minden elemenek vesszuk a szinuszat
B = sin(A);
% az A elso soranak masodik elemet kicsereljuk -2-re
B  = A;
B(1,2)  = -2; 
% az A 2. sorat kicsereljuk a [-1 0 -2 3 ] vektorra
B = A;
B(2,:) = [-1,0,-2,3];

% matrix eloallitas

A = [1:8;20:-2:6;2.^[1:8]];


%% Linearis algebra hasznos fuggvenyei

det(A)
inv(A)
dot(A)
norm(A) % ,1, inf
x = A\b

help diag
help tril
help triu

%%
% Fuggvenyek irasa Matlabban

% Logikai kifejezesek
% <, <=, >, >=, ==, ~= 
% A&B, A|B, ~A, xor(A,B)

% Logikai fuggvenyek
all()
any()

help find

logical()

% if -elseif - else end utasitas
N=input('Adjon meg egy egesz szamot: ');
if mod(N,3)==0
disp('Oszthato 3-mal');
elseif mod(N,3)==1
disp('3-mal osztva 1 maradekot ad');
else
disp('3-mal osztva 2 maradekot ad');
end
%%
% Vezerlo utasitasok
% break
% continue
pause
pause(5)
% return
error('uzenet')
%%
% Legyen 
x = [0 -1 2 0 4 4]
y = [-1 -2 3 1 0 4]
% Vizsgalja meg az alabbi logikai kifejezesek erteket!
x == y
x <= y
x > y
x > 0
y <= 3
x | y
x & y

% Az elozo feladat vektoraival vizsgalja meg az alabbi kifejezesek erteket
find(x == y)

find(x <= y)

%%
% Legyen a=rand(1,20) Keszitse el azt a b vektort, amely az a 0.5-nel
% nagyobb elemeit tartalmazza!

a = rand(1,20)
b = a(find(a>0.5))

%%
A = diag(1:5) + diag(3:3:9,-2);


B = triu(ones(5)*2) - 4*eye(5);
[A,B] = matrixokAB(8)
%%
% Irjon egy fuggvenyt, mely adott A matrix eseten eloallitja azt a 
% B matrixot, amelyet ugy kapunk, hogy az A minden soranak a vegere
% odairjuk az abban a sorban allo elemek atlagat!
help mean
% mean fuggveny alapertelmezetten oszlopok atlagat szamolja

A = diag(1:5) + diag(3:3:9,-2)
atlagolo_matrix(A)

%B = [A,mean(A,2)]
% Kulon fajlban!


function B = atlagolo_matrix(A)
    B = [A, mean(A,2)];
end


