t = [1 3 6 8 10];
f = [213 534 1000 1316 1627]'/100;
p = polyfit(t,f,1)
%az első szám a meredekség (most pl 1.5694 -> és még kerekíted)
%a második szám az egyenes konstanstagja (most 0.5916 -> kerekíted)
%helyettesítési érték:
polyval(p,4)