%rjon egy függvényt, mely adott t 
% (n elemű)  vektor esetén az alábbi A mártixszal tér vissza
function A=fun(t)
t = t(:);
A = [1 t.^2 exp(t)];
end

function A=fun(t)
t=t(:);
A=[ones(length(t),1),t.^2,exp(t)];
end