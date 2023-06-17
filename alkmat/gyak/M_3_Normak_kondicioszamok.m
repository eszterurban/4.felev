%% 1. feladat
% fv, mely adott n pozitiv egesz szam eseten eloallitja
% az A (nxn)matrixot.
% i=j 1, i<j eseten -1, 0 egyebkent






n = 5;
A = 2*eye(n) - triu(ones(n))
A = triu(2*eye(n) - ones(n))
A = eye(n)- triu(ones(n),1)
A = triu(zeros(n)-1)+eye(n)*2
A = triu(ones(n)*-1+2*eye(n))

%% 2. feladat
% A matrix, b vektor
% backslash operator


A = triu(ones(100)*-1+2*eye(100));
b1 = (-98:1)';

x = A\b1
%%
% perturbalt b vektor, b(100) = 1.00001
b2 = b1;
b2(100) = b1(100) + 1e-6;

y = A\b2

%%
% 4. feladat
% fv a normak kiszamitasara
% 1-, 2-, vegtelen norma


p = 2;%'inf';
x = 1:0.1:5;

if(p == 'inf')
    norma = max(abs(x));
else
    norma = sum(abs(x).^p)^(1/p);
end

norma
%%
norm(x,inf)
norm(y,inf)
norm(b1,inf)
norm(b2,inf)
%%
help norm
%%
norm(x,p)
%%
% fv irasa matrix norma szamitasara
% 1 es vegtelen norma
help sum % matrix default sum of columns
%%
A  = [-3,0,4;1,-1,2;-2,1,-2]

% 1-norma (oszlopnorma)
% vegtelen-norma (sornorma)

max(sum(abs(A),1))
max(sum(abs(A),2))
%%
norm(A,1)
norm(A,'inf')
%%
help normest
% matrix 2-es normajat kozeliti

%%
% kondicioszam
% korabbi feladat matrixa es b vektora
A = triu(ones(100)*-1+2*eye(100));
b1 = (-98:1)';
x = A\b1;
b2 = b1;
b2(100) = 1.00001;
y = A\b2;

condA = cond(A,'inf')
%%
db = abs(b2-b1)
dx = abs(y-x)
% b vektor relativ hibaja vegtelen normaban
norm(db,'inf')/norm(b1,'inf')
% x megoldas relativ hibaja
norm(dx,'inf')/norm(x,'inf')

%%
% 11. feladat

A = [1,0.99; 0.99,0.98];
b = [1.99;1.97];
b_d = [1.98;1.98];
x = A\b
y = A\b_d
% a megoldas relativ hibaja
rel_x = norm(x-y,'inf')/norm(x,'inf')
% jobb oldali vektor relativ hibaja vegtelen normaban
rel_b = norm(b_d-b,'inf')/norm(b,'inf')
% a matrix kondicioszama vegtelen normaban
cond_A = cond(A,'inf')
%%
rel_b*cond_A
% vessuk ossze az erteket cond_A-val
%%
% Hilbert matrix

H = hilb(6);

cond(H)

R = rand(6);
cond(R)

%% Extra
% Rajzoljuk ki az 1 normaju vektorokat!


figure
axis equal
hold on
for x1=-1:0.001:1
    for x2=-1:0.001:1
        if abs(norm([x1,x2],1) - 1) < 1e-10
           plot(x1,x2,'b.-'); 
        end
        if abs(norm([x1,x2],2) - 1) < 1e-5
           plot(x1,x2,'r.'); 
        end
        if abs(norm([x1,x2],inf) - 1) < 1e-10
           plot(x1,x2,'g.'); 
        end
    end
end

%%
% 3D, 1-norma
figure
hold on
for x1=-1:0.1:1
    for x2=-1:0.1:1
        for x3=-1:0.1:1
            if abs(norm([x1,x2,x3],1) - 1) < 1e-10
               scatter3(x1,x2,x3,'b.'); 
            end
        end
    end
end
