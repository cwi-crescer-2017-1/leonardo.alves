
-- ex 01
select IDEmpregado, NomeEmpregado, (year(getdate()) - year(DataNascimento)) as idade from Empregado where 
year(Empregado.DataAdmissao) = 1980;


-- ex 02

select MAX(Cargo) as [Maior número de empregados] from Empregado;

-- ex 03

select Cidade.UF, COUNT(Cidade.UF) as cidades from Cidade group by Cidade.uf; 

-- ex 04

insert into Departamento (IDDepartamento, NomeDepartamento, Localizacao) values
	(70, 'Inovação', 'SÃO LEOPOLDO');

update Empregado set IDDepartamento = 70
	where  MONTH(Empregado.DataAdmissao) = 12 and Empregado.Cargo != 'Atendente';


