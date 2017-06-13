-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos
--quatro meses.

create view VWPRODUTOS4MESES as    
    select i.IDPRODUTO from PEDIDOITEM i 
    inner join PEDIDO p on p.IDPEDIDO = i.IDPEDIDO
    where MONTHS_BETWEEN(SYSDATE, p.DATAPEDIDO) <= 4;  
    
select p.NOME,
        p.IDPRODUTO 
        from PRODUTO p 
        where p.IDPRODUTO not in (select v.IDPRODUTO from  VWPRODUTOS4MESES v);
        
-- Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido
-- nos últimos quatro meses. Definir o valor I para o campo situacao.

update PRODUTO 
set SITUACAO = 'I' 
where IDPRODUTO not in (select v.IDPRODUTO from  VWPRODUTOS4MESES v);       

-- Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a 
--quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos
--no último ano (desde janeiro/2017).

select sum(i.IDPRODUTO) 
from PEDIDOITEM i 
inner join PEDIDO p on p.IDPEDIDO = i.IDPEDIDO
where :IDPRODUTO = i.IDPRODUTO 
and p.DATAPEDIDO between date '2017-01-01' and date '2017-12-31';




