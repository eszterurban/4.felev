A=[2 7; 3 5; 6 4];
b=[77; 66; 96];
c=[-9;-8];
lb=[0;0];
x=linprog(c,A,b,[],[],lb,[])
figure
hold on
fplot(@(x) (77-2*x)/7)
fplot(@(x) (66-3*x)/5)
fplot(@(x) (96-6*x)/4)