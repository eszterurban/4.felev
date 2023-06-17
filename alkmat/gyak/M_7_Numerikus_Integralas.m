%% Numerikus integralas

%%
% Anonim fuggvenyek - egy sorban, elagazas nelkuli utasitas vagy keplet
% fuggvenybe foglalasa
 @(x) x.*sin(x);
 
% function handle - pl. anonim fv valtozoban valo tarolasa
f1 = @(x) x.*sin(x);
% Ezt tudjuk ugy hasznalni, ahogy egy kulon fajlban megirt fuggvenyt hasznalnank
y = f1(pi/4)

%%
% Tobbvaltozos fuggveny megadasa
f2= @(x,y) x.^2+x.*y-y+3;
z=f2(2,-1)

%% Egyvaltozos fuggvenyek integralasa a beepitett integral() fuggvennyel
% numerikus integralas:
% integral(fv,xmin,xmax),
% ahol fv egy function handle valtozo,
% amely vektort is tudjon kezelni!

f= @(x) x.*sqrt(1+x);
integral(f,0,3)
% fontos, hogy elementkenti muveletekkel dolgozzunk!
% (lasd pontozott operatorok)

%% nem feltetlen szukseges az f valtozot letrehozni,
% hasznalhatunk egybol anonim fv-t
integral(@(x) x.*sqrt(1+x),0,3)

%% function handle-t tudunk csinalni a beepitett
% vagy sajat magunk altal kulon fajban megirt
% fuggvenyekbol is: 
f =  @sin;
f = @(x) sin(x);
f = @sajat_fuggveny_kulon_fajban;
% 
integral(@sin,0,pi)


%% Improprius integralok, az integral hatara vegtelen
integral(@(x) exp(-x),0,inf)
%% az sem baj, ha nincs ertelmezve
% a fv az intevallum vegpontjaban:
f= @(x) 1./sqrt(1-x.^2);
integral(f,-1,1)
%% Parameteres fuggvenyek integralja
f = @(x,c) x.^2 - c*x+3;
g = @(x) f(x,4.5);
integral(g,0,5)



%% Ha nem ismert a fuggveny, 
% aminek az integral kozeliteset akarjuk
% szamolni, csak a fv ertekei megadott pontokban.
% Akkor hasznaljuk a trapz() 
% beepitett fuggvenyt a pontokon
x=0:5:60;
f=[ 2.2 2.8 3 3 2.7 2.5 2.4 2.9 3.3 3.5 3.5 3.3 3];
trapz(x,f) % Az integral erteke
% az y vektor elemei az addig
% a pontig vett fuggveny integral ertekei
y=cumtrapz(x,f) 

%% Feladatok 
% Szamitsa ki az integralok erteket
% 26. dia
%% a)
f = @(x) x.*sin(x.^2);
integral(f,-pi/2,pi/2)
%% b)
f = @(x) (1/(sqrt(2*pi)))*exp(-(x.^2)/2);
integral(f,-Inf,Inf)
%% c)
f = @(x) sqrt(1-x.^2);
integral(f,-1,1)
%% Kozelitse a megadott integralt
% a Matlab integral fugvennyel
% es a trapz fuggvennyel
% ugy, hogy az alappontoknak az
% xi = 0:10 pontokat
% xi = [0,0.5:9.5 10] pontokat
% valasztja. 
% Abrazolja az integralando fuggvenyt a megadott intervallum felett.
% Novelje az alappontok szamat a trapz eseten
f = @(x) x.*sin(5*x);
integral(f,0,10)
xi_1 = 0:10;
xi_2 = [0,0.5:9.5,10];
trapz(xi_1,f(xi_1))
trapz(xi_2,f(xi_2))
%%
x = linspace(0,10);
plot(x,f(x))
%%
hold on
plot(xi_1,f(xi_1),'r-*')
plot(xi_2,f(xi_2),'g-*')
%%
xi_3 = linspace(0,10);
trapz(xi_3,f(xi_3))
plot(xi_3,f(xi_3),'bo')

%% Ketvaltozos fuggvenyek integralasa
% integral2(fun,xmin,xmax,ymin,ymax)
% ahol fun = @(x,y) ...;
f= @(x,y) x.*exp(-x.^2-y.^2);
integral2(f,-2,2,-1,1)

%%
% A fuggveny vegpontjait is megadhatjuk fuggvenykent
f= @(x,y) sqrt(1-x.^2-y.^2);
ymin= @(x) -sqrt(1-x.^2);
ymax= @(x) sqrt(1-x.^2);
integral2(f,-1,1,ymin,ymax)
%% Feladatok 30.dia
%% a)
f = @(x,y) 2*y.*sin(x).*cos(x).^2;
integral2(f,0,pi/4,-pi/3,0)
%% b)
f = @(x,y) (1/2*pi)*exp(-(x.^2+y.^2)/2);
integral2(f,-Inf,Inf,-Inf,Inf)
%% c)
f = @(x,y) log(x.*y);
ymin = @(x) x;
ymax = @(x) x.^2;
integral2(f,1,exp(1),ymin,ymax)
