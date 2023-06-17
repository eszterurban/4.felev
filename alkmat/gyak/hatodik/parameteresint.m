f= @(x,c) x.^2-c*x+3;
integral(@(x) f(x,4.5),0,5)