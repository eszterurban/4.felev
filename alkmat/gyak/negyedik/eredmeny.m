function eredmeny = nsol(A,b)
    if rank(A)==rank([A,b])
        if rank(A)==size(A,2)
            ns=1;
            disp('Egy megoldás van')
        else 
            ns=8;
            disp('Határozatlan')
        end
    else 
        disp('Ellentmomndásos')
        ns=0;
    end
end