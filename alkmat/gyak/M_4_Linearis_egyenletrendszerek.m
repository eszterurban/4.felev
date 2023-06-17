%%
% 1. feladat ellenorzese 
A = [-2,2,1;6,-3,-4;-4,1,1];
b = [0,-8,4]';
[L,U,P] = lu(A)
x = A\b

%%
L = [1,0,0;-3,1,0;2,-1,1]
U = [-2,2,1;0,3,-1;0,0,-2]
L*U

%%
% 2. feladat
A = [-3,1,0;12,-6,2;-6,4,1];
%[L,U] = lu(A)
L = [1,0,0;-4,1,0;2,-1,1];
U = [-3,1,0;0,-2,2;0,0,3];
L*U

b = [5;-28;12];
c = [-6;18;-15];
U\[L\b] == A\b
U\[L\c] == A\c

%%
%
% Linearis egyenletrendszer megoldasa es megoldasainak szama Matlabbal
%
% nincs megoldas vagy 1 megoldas vagy vegtelen sok megoldas

A=[-2 -1 4; 2 3 -1; -4 -10 -5];
b=[3; 1; -12];

x=A\b
% a backslash operator egy megoldast ad, mindharom lehetoseg eseten!

%%
% megoldasok szamanak meghatarozasa
rref([A b])
% A oszlopvektorai linearisan fuggetlenek, egyetlen megoldas

%%
A=[-4 -4 2; -2 -7 3; 2 12 -5];
b=[-2; 6; -13];
x=A\b

%%
% A matrix valoban szingularis, ha a determinansa 0
det(A) 
%%
r = rref([A b])
% az eliminacio vegen a matrix oszlopai linearisan fuggoek, de  b vektor
% benne van az oszlopvektorok altal felfeszitett terben
% vegtelen sok megoldas
%%
% egy megoldas a nullter bazisaval
p=null(A,'r') % r opcio, a racionalis alakot adja meg
lambda = 1; % tetszoleges valos szam
% Altalanos megoldasa az egyenletrendszernek: 
% az eliminacio vegen kapott matrix utolso oszlopa, mint egy megoldas es a
% lambda, tetszolegesen valaszthato parameterrel vegtelen sok tovabbi
% megoldast tudunk adni
x = r(:,end) + lambda *p

%%
% Tovabbi pelda - oldjuk meg az egyenletrendszert!
A = [1,1;1,2;1,3;1,4]
b = [4;6;9;12]
%%
x = A\b
% Ez megoldasa-e az egyenletrendszernek? Ellenorizzuk!
%%
rref([A,b])
% Az eliminacio utani kibovitett matrix ellentmondasos
% azaz nincs megoldasa
% a backslash operator ilyenkor is ad megoldast, ez egy legkisebb negyzetes
% ertelemben vett kozelito megoldas
%%
format rat
0.25
%%
format
0.25
%%
% Irjon Matlab fv-t, amely megadja, hogy egy A es b input eseten hany
% megoldasa van az Ax = b lin.egy.ren.-nek!
LER_megoldasszam(A,b)
%%
% Oldjuk meg a tovabbi egyenletrendszereket! 
% Azonos egyuttahto matrixhoz ket kulonbozo jobb oldali vektor adott
% Ax = b es Ax = c
A=[-2 -1 4; 2 3 -1; -4 -10 -5];
b=[3; 1; -12]; 
c=[17; 1; -42];
% a backslash operatorral egyszerre is meg tudjuk oldani mindket
% egyenletet, mivel azonos a matrix!
x=A\[b,c]
%%
% Teszteljuk az osszevont futtatas gyorsasagat nagyobb matrixokon!
A=rand(10000);
b=ones(10000,1);
c=zeros(10000,1);
tic;x=A\[b,c];toc

tic;x=A\b; x2=A\c; toc

%%
% LU felbontas Matlabbal
help lu
[L1,U]=lu(A); % L1 = P'*L
[L,U,P]=lu(A);
%%
 x=U\(L1\b);
 
%%
% Teszteljuk az LU felbontas elonyeit!
% Tobb jobboldali vektorral valo szamolasnal nem kell ujra eliminaciot
% vegrehajtani csak egyszer!

A=rand(10000);
b=ones(10000,1);
c=zeros(10000,1);
d=rand(10000,1);
e=rand(10000,1);

tic;x=A\b;x=A\c;x=A\d;x=A\e;toc

tic;[L,U]=lu(A);  x=U\(L\b); x=U\(L\c);  x=U\(L\d);  x=U\(L\e);toc
 
%%
% Cholesky
chol(A)
chol(A,'lower')
%%
% 6. feladat
x = zeros(2,1);
A = [10^-17, 1; 1,1];
b = [1;2];
% sorcsere nelkuli Gauss eliminacio
c=A(2,2)-A(1,2)*A(2,1)/A(1,1);
d=b(2)-b(1)*A(2,1)/A(1,1);
x(2)=d/c;
x(1)=(b(1)-A(1,2)*x(2))/A(1,1);
x

y = A\b
rref([A b])

%% 7. feladat
n = 10;
A = pascal(n);
x = ones(n,1);
b = A*x;

%%
format long
[L,U] = lu(A);
lu_x = U\(L\b)


C = chol(A,'lower');
chol_x = C'\(C\b)


x = A\b




