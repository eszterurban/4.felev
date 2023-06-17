function [gyok,k] = nemlin_szelo(f,a,b,epsilon,maxit)
    x0 = a;
    x1 = b;
    gyok = 'Maximum iteracio tullepese, nem talaltunk gyokot!';% inicializalas a maximum iteracio tulhaladasara
    for k = 1:maxit
        if f(x1)-f(x0) == 0
            error('Nem szamolhato tovabb')
        end
        lepes = f(x1)*(x1-x0)/(f(x1)-f(x0));
        x2 =  x1 - lepes
        if abs(f(x2)) < epsilon
            gyok = x2;
            break
        else
            % Az utolso ket pontot hasznaljuk a kovetkezo iteracioban
            x0 = x1;
            x1 = x2;
        end   
    end 
end
