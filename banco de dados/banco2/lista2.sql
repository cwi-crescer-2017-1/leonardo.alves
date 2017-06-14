--Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
--Faça um código (PL/SQL) que liste quais são as cidades duplicadas. 
--Após isso liste todos os clientes que estão relacionados com estas cidades

--select nome, uf, count(2) from cidade group by nome, uf having count(2) >1;

declare 

  cursor c_cidadeDup is  
    select nome,
           uf
    from cidade
    group by nome, uf
    having count(1)> 1
    order by nome;
    
    cursor c_clientesDup (pCidade in varchar2, pUf in varchar2) is
      select cliente.nome from cliente inner join cidade 
      on cliente.idcidade = cidade.idcidade
      where cidade.nome = pCidade AND cidade.uf = pUf;  
      
begin
  for c in c_cidadeDup loop    
     DBMS_OUTPUT.PUT_LINE('Cidade: '|| c.nome || '-'|| c.uf);           
     for h in c_clientesDup(c.nome, c.uf) loop     
        DBMS_OUTPUT.PUT_LINE(h.nome);
     end loop;
  end loop; 
end;

--create index IX_Cidade_NomeUF   on Cidade (Nome,UF);
--create index IX_Cliente_Cidade  on Cliente (IDCidade);

--Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens.
--Esta rotina deve receber por parametro o IDPedido e então verificar o valor 
--total de seus itens (quantidade x valor unitário).
create or replace 
procedure atualiza_valor_pedido (pIdPedido in integer) as
  vValorTotal pedido.valorpedido%type;
begin  
  
  select sum(quantidade * precounitario) into vValorTotal
  from pedidoitem where idPedido = pIdPedido;  

  update pedido set valorpedido = vValorTotal where idpedido = pIdPedido; 

end;

exec atualiza_valor_pedido (56);
--Crie uma rotina que atualize todos os clientes que não realizaram nenhum 
--pedido nos últimos 6 meses (considere apenas o mês, dia 01 do 6º mês anterior)
--Definir o atributo Situacao para I.

update cliente 
set situacao = 'I'
where idcliente not in
    (select distinct idcliente 
     from pedido  
     where months_between(trunc(sysdate, 'MONTH'), trunc(datapedido, 'MONTH')) <= 6);
