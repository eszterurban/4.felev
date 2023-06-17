b1=(-98:1)';

b2=b1;
b2(100)=b1(100)+1.00001;
norm(b1, inf)
norm(b2, inf)
