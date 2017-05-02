
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
		count(Cidade.Nome) > 1;

-- ex 05 

		 
