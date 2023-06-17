A=[1, -2, -4; 2, 0, 1; 3, 3, -1]
[m, n] = size(A);
 B = zeros(m, n+1);
    for i = 1:m
        neg_count = sum(A(i,:) < 0);
        B(i,:) = [A(i,:), neg_count];
    end
B