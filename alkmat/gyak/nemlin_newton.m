function [gyok,k] = nemlin_newton(f,derivf,x0,epsilon,maxit)
    
    gyok = 'Nem talaltunk gyokot, elertuk a maxit!';% inicializalas a maximum iteracio tulhaladasara
    for k = 1:maxit
        % Ellenorzes, hogy f derivalt nem 0 az adott pontban!
        if derivf(x0) == 0
            error('A derivalt 0, az iteracio nem szamolhato tovabb.');
            % gyok='A derivalt 0';
            % break
        end
        x1 =  x0 - f(x0)/derivf(x0)% Az f fv  aktualis pontbeli erintoje 
        if abs(f(x1)) < epsilon
            gyok = x1;
            break
        end    
        x0 = x1;
    end 
end
