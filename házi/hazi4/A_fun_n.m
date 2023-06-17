function A=fun(n)
A=ones(n,n);
B=tril(A).*-2;
C=triu(A).*3;
D=eye(n)*2;
A=B+C+D;
end