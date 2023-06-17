b1=(-98:1)';
A=2*eye(100)-triu(ones(100));
x=A\b1;

b2=b1;
b2(100)=b1(100)+1.00001;


cond(A,inf)

norm(b2,"inf")/norm(b1,"inf")

norm(y,"inf")/norm(x,"inf")