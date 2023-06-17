function A=matrixA(n)
    n=5;
    A=2*eye(n)-triu(ones(n));
end