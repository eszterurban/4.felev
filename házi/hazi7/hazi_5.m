A=[0.6 0.1 0.4; 0.3 0.8 0.3; 0.1 0.1 0.3];  
[V,U]=eig(A)    
v=V(:,1)
v=v/sum(v)