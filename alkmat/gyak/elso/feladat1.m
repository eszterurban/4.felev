%a
a=0:30
b=2:2:100
c=2:-0.1:0
q=0:3:30;
d=[q -100 flip(q)] %[0:3:30 -100 30:-3:0]
w=2:20;
e=1./w %1./(2:20)
f=(1:19)./2:20
%b
x=linspace(1, 100)
y1=flip(x)
y2=x(1:5)
y3=x
y3(4)=[] %y3=x([1:3, 5:end])
y4=x([1:4, 6:71, 73:92, 94:end])
y5=x(1:2:end)
y6=x([2, 5, 17, 81])