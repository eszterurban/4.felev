function [A,B] = matrixokAB(n)
    A = diag(1:n) + diag(3:3:(n-2)*3,-2);
    B = triu(ones(n)*2) - 4*eye(n);
end