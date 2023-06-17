function [gyok,k] = nemlin_hur(f,a,b,epsilon,maxit)
    % elozetes vizsgalat, hogy letezik-e gyok
    if f(a)*f(b) > 0
        error('Nincs gyok a megadott intervallumon')
    end
    x0 = a;
    x1 = b;
    gyok = 'Maximum iteracio tullepese, nem talaltunk gyokot!';% inicializalas a maximum iteracio tulhaladasara
    for k = 1:maxit
        x2 =  x1 - f(x1)*(x1-x0)/(f(x1)-f(x0));% Az (x0, f(x0)) es (x1, f(x1)) pontokra illeszkedo egynes egyenletebol
        if f(x2) == 0
            gyok = x2;
            break
        elseif f(x0)*f(x2) < 0
            x1 = x2;
        elseif f(x1)*f(x2) < 0
            x0 = x2;
        end
        if abs(f(x2)) < epsilon * (1 + abs(f(x0)))
            gyok = x2;
            break
        end           
    end 
end
