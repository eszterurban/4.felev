x = [-1 4 0];
y = [3 -2 5];
A = [-3 1 -4; 6 2 -5];
z = [x, y]
q = [x; y]
b = [x', y']
a = [x'; y']
h = [A; x]
%c = [A, x] nem müködik
d = [x;A; y]
%e = [A'; x] nem mukodik
%f = [A', x] nem mukodik
g = [A', x']
i = x + y
j = x + y'
k = A + y
l = A + 2
m = x./y
%n = A ^ 2
p = A.^2