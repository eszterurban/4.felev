x=0:5:60;
f=[ 2.2 2.8 3 3 2.7 2.5 2.4 2.9 3.3 3.5 3.5 3.3 3];
trapz(x,f)
y=cumtrapz(x,f)