function n=norma(v,p)
    if (p=='inf')
        n=max(abs(v))
    else
        n=sum(abs(v).^p)^(1/p)
    end
end
