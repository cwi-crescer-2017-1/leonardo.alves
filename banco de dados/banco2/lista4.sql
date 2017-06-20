----  TOP ESTADOS 
select c.UF UF,
        count(a.IDAPOSTA) APOSTAS,
        sum(a.VALOR) VALOR_ARRECADADO,
        count(IDAPOSTA_PREMIADA) ACERTADORES,
        sum(p.VALOR) PREMIACAO_TOTAL
from CIDADE c
    inner join APOSTA a on a.IDCIDADE = c.IDCIDADE
    full outer join APOSTA_PREMIADA p on p.IDAPOSTA = a.IDAPOSTA
    group by c.UF
    order by APOSTAS, VALOR_ARRECADADO desc;
    
    
--- IDENTIFICAÇÃO DE FRAUDE    
create view VW_VERIFICAFALSIFICACAO as
    select IDLOGAPOSTA          as ID_LOG, 
            IDCONCURSO_NOVO      as ID_CONCURSO, 
            IDAPOSTA_NOVO        as ID_APOSTA,
            c.DATA_SORTEIO       as DATA_SORTEIO,
            DATA_APOSTA_NOVO     as DATA_APOSTA,
            data                 as DATA_LOG  
    from LOGAPOSTAS l inner join CONCURSO c on l.IDCONCURSO_NOVO = c.IDCONCURSO 
    where DATA_APOSTA_NOVO > DATA_SORTEIO;    
    
