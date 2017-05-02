
-- ex 01 self join e inner join
select emp.nomeEmpregado, departamento.nomeDepartamento, ger.NomeEmpregado
from Empregado emp
	inner join Empregado ger on emp.IDGerente = ger.IDEmpregado
	inner join Departamento on Departamento.IDDepartamento = emp.IDDepartamento;

-- ex 02

/*select	d.NomeDepartamento, 
			d.IDDepartamento 
from Departamento d inner join
			(select	top 1	max(temp.salario) salario, 
							temp.IDDepartamento
			from   (Select  IDDepartamento, 
							max(salario) as salario				
					from Empregado  
					where IDDepartamento is not null 
					group by Iddepartamento) as temp
			group by IDDepartamento
			order by salario desc) as temp2 on temp2.IDDepartamento = d.IDDepartamento;
*/

select  top 1   emp.NomeEmpregado, 
				emp.Salario, 
				emp.IDEmpregado, 
				dep.IDDepartamento, 
				dep.NomeDepartamento 
from Empregado emp inner join Departamento dep 
on emp.IDDepartamento = dep.IDDepartamento order by emp.salario desc;
-- ex 03

begin transaction
update Empregado set Salario = (salario * 1.173) where
	IDDepartamento in (Select IDDepartamento from Departamento where Localizacao = 'SAO PAULO');
commit

-- ex 04 

select	Cidade.UF, 
		Cidade.Nome 
from	Cidade 
group by	Cidade.UF, 
			Cidade.Nome 
having	count(Cidade.UF) > 1 AND 
		count(Cidade.Nome) > 1

-- ex 05 
begin transaction

create view vwNomeDasCidadesDuplicadas as --pega o nome
	select	Nome 
	from	Cidade 
	group by	Cidade.UF, 
				Cidade.Nome 
	having	count(Cidade.UF) > 1 AND 
			count(Cidade.Nome) > 1

create view vwIDENomeDasCidadesDuplicadas as --pega o id e o nome
	select	IDCidade, 
			Cidade.Nome 
	from Cidade  inner join vwNomeDasCidadesDuplicadas 
		on Cidade.Nome = vwNomeDasCidadesDuplicadas.Nome;
		

create view vwIDDasCidadesDuplicadas as -- pega so o id maior das cidades duplicadas
	select	max(Cidade.IDCidade) as id			
	from Cidade inner join vwIDENomeDasCidadesDuplicadas
			on Cidade.Nome = vwIDENomeDasCidadesDuplicadas.Nome
	group by Cidade.Nome; 



update Cidade set Nome = CONCAT(Cidade.Nome,'*') --faz o update com os ids maiores das cidades com nome duplicado
from vwIdDasCidadesDuplicadas where cidade.IDCidade = vwIDDasCidadesDuplicadas.id;

commit
