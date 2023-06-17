function [gyok,k] = nemlin_felezo(f,a,b,epsilon,maxit)
    % elozetes vizsgalat, hogy letezik-e gyok
    if f(a)*f(b) > 0
        error('Nincs gyok a megadott intervallumon')
    end
    x0 = a;
    x1 = b;
    gyok = 'Maximum iteracio tullepese, nem talaltunk gyokot!';% inicializalas a maximum iteracio tulhaladasara
    for k = 1:maxit
        x2 = (x0+x1)/2;
        if f(x2) == 0
            gyok = x2;
            break
        elseif f(x0)*f(x2) < 0
            x1 = x2;
        elseif f(x1)*f(x2) < 0
            x0 = x2;
        end
        if abs(x1 - x0)< epsilon
            gyok = x2;
            break
        end           
    end 
    
end
