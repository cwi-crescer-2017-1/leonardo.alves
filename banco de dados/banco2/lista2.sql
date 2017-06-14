--Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
--Faça um código (PL/SQL) que liste quais são as cidades duplicadas. 
--Após isso liste todos os clientes que estão relacionados com estas cidades

--select nome, uf, count(2) from cidade group by nome, uf having count(2) >1;

declare  

  vCidadeNome cidade.nome%type;  
  vContadorCidade cidade.idcidade%type;
  
  cursor c_cidadeDup is  
    select nome,
           uf,           
           count(2) as ocorrencias,
           count(3)
    from cidade
    group by nome, uf
    having count(2) > 1 AND count(3) > 1
    order by nome;
    
    cursor c_clientesDup is
      select nome  
      from cliente 
      where idcidade = (select idcidade from cidade where nome like vCidadeNome AND rownum = vContadorCidade);  
      
begin
  for c in c_cidadeDup loop
  
     DBMS_OUTPUT.PUT_LINE('------------CIDADE----------');
     DBMS_OUTPUT.PUT_LINE( c.nome || '-'|| c.uf);
     vContadorCidade := 0;
     vCidadeNome := c.nome;

     DBMS_OUTPUT.PUT_LINE('---------CLIENTES----------');  
     while vContadorCidade < c.ocorrencias loop     
       vContadorCidade := vContadorCidade + 1;  
       
       for cliente in c_clientesDup loop     
          DBMS_OUTPUT.PUT_LINE( cliente.nome);
       end loop;
       
     end loop;
     
  end loop; 
end;


--Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens.
--Esta rotina deve receber por parametro o IDPedido e então verificar o valor 
--total de seus itens (quantidade x valor unitário).
declare 

  vValorTotal pedido.valorpedido%type;
  vIdPedido pedido.idPedido%type;
  
  cursor c_itensDoPedido (pIdPedido in number) is
    select  quantidade, 
            precounitario 
    from pedidoitem where idpedido = pIdPedido;
    
begin 
  vValorTotal := 0;
  vIdPedido := :idPedido;
  for item in c_itensDoPedido(vIdPedido) loop
    
    vValorTotal := vValorTotal + (item.quantidade * item.precounitario);
  end loop;
  
  DBMS_OUTPUT.PUT_LINE(vValorTotal);  
  update pedido set valorpedido = vValorTotal where idpedido = vIdPedido; 

end;

--Crie uma rotina que atualize todos os clientes que não realizaram nenhum 
--pedido nos últimos 6 meses (considere apenas o mês, dia 01 do 6º mês anterior)
--Definir o atributo Situacao para I.

update cliente 
set situacao = 'I'
where idcliente not in
    (select distinct idcliente 
     from pedido  
     where months_between(trunc(sysdate, 'MONTH'), trunc(datapedido, 'MONTH')) <= 6);
