-- ex 01
select	count(cliente.totalOcorrencias)							as totalOcorrencias, 
		cliente.PrimeiroNome 
from 		
	(select	COUNT(SUBSTRING(Nome, 0, CHARINDEX (' ', Nome)))	as totalOcorrencias,
			SUBSTRING(Nome, 0, CHARINDEX (' ', Nome))			as PrimeiroNome
	from	Cliente
	group by Cliente.Nome)										as cliente 		

group by	cliente.totalOcorrencias, 
			cliente.PrimeiroNome
order by	totalOcorrencias desc;

-- ex 02

select	SUM(ped.Quantidade)		as Quantidade, 
		SUM(ped.ValorPedido)	as ValorPedido 
from 
	(select	COUNT(IDPedido)		as Quantidade, 
			SUM(ValorPedido)	as ValorPedido
	from	Pedido 
	where	MONTH(DataPedido) = 4 and 
			YEAR(DataPedido) = 2017
	group by IDPedido)			as ped;

-- ex 03
-- vwTotalClientesPorUF, vwMenorNumeroClientes, vwMaiorNumeroClientes

create view vwTotalClientesPorUF				as 
		select	sum(Cli.Clientes)				as TotalClientes, 
				Cidade.UF
		from	Cidade inner join
				(select	COUNT(Cliente.IDCidade) as Clientes, 
						Cliente.IDCidade  
				from Cliente group by IDCidade) as Cli 
					on cli.IDCidade = Cidade.IDCidade 
		group by Cidade.UF;

		

create view vwMenorNumeroClientes as
		select top 1	MIN(UFClientes.TotalClientes) as TotalClientes,
						Cidade.UF
		from Cidade inner join 
			vwTotalClientesPorUF					  as UFClientes 
				on UFClientes.UF = Cidade.UF
				group by Cidade.UF 
				order by TotalClientes asc;
			
create view vwMaiorNumeroClientes as		
		select top 1 MAX(UFClientes.TotalClientes) as TotalClientes,
				     Cidade.UF	
		from Cidade inner join
			vwTotalClientesPorUF				   as UFClientes 
				on UFClientes.UF = Cidade.UF
				group by Cidade.UF
				order by TotalClientes desc;			


select UF, TotalClientes from vwMaiorNumeroClientes 
union 
select UF, TotalClientes from vwMenorNumeroClientes;

-- ex 04 
begin transaction
insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao, DataCadastro) values
	('Galocha Maragato', 35.67, 77.95, 'A', GETDATE());
commit
-- ex 05

select Produto.Nome 
from Produto 
		left  join 
	 PedidoItem
		on Produto.IDProduto = PedidoItem.IDProduto 
		left join 
	 Pedido 
		on Pedido.IDPedido = PedidoItem.IDPedido
where PedidoItem.IDPedido is null
group by Produto.Nome;

-- ex 06 

-- vwLucro, vwTotalPedidoItem

create view vwLucro as
	select	(PrecoVenda - PrecoCusto) as lucro,
			 IDProduto,
			 Nome 
	from Produto;

create view vwTotalPedidoItem as
	select (Quantidade * PrecoUnitario) as totalPedido,			
			IDPedidoItem,
			IDProduto			
	 from PedidoItem	 
	

	-- precounitario x quantidade x diferenca precoCusto e precoVenda x n° pedidos = maior lucro ?
select top 30	produtoLucro.Nome												as Nome, 
			(pedidoTotal.totalPedido * produtoLucro.lucro * pedidos.numPedidos)	as lucro 
from vwLucro																	as produtoLucro 
		inner join 
	 vwTotalPedidoItem															as  pedidoTotal
		on produtoLucro.IDProduto = pedidoTotal.IDProduto
		inner join (select COUNT(IDPedido)										as numPedidos,
							IDProduto 
					from PedidoItem 
					group by IDProduto)											as pedidos 
		on pedidos.IDProduto = pedidoTotal.IDProduto
order by lucro desc;