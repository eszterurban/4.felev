A=[1, -2, 4; 2, 0, 1; 3, 2, -1; 0, 0, 0; -1, 2, 1];
mask = (A > 2 & A < 5);
B = [A, sum(mask,2)];
B

