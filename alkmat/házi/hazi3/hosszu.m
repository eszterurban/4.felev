function [a,b,y]=solve(t,f,x)
    G = [ones(size(t)), t];
    A = G'*G;
    b = G'*f;
    
    dA = det(A);
    tmp = [b,A(:,2)];
    konstans = det(tmp)/dA;
    
    tmp = [A(:,1),b];
    mer = det(tmp)/dA;
    a = mer;
    b = konstans;
    
    y = polyval([mer, konstans],x);
end