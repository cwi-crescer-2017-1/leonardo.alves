SELECT IDEmpregado, NomeEmpregado FROM Empregado
ORDER BY DataAdmissao ASC;

SELECT IDEmpregado, NomeEmpregado, Salario FROM Empregado
WHERE Comissao IS NULL
ORDER BY Salario DESC;

-- ex 3 []
SELECT IDEmpregado,
		 NomeEmpregado,
		 (Salario*13) SalarioAnual, 
		 isNull(Comissao*13,0) ComissaoAnual, 
		 (Salario*13) + isNull(Comissao*12, 0) RendaAnual
FROM Empregado;

-- ex 4
SELECT  IDEmpregado,
		NomeEmpregado,
		Cargo,
		Salario
FROM Empregado WHERE (salario*12 < 18500)	OR (Cargo = 'Atendente');
		

-- having é o where para funções de grupo tipo avg count min max etc
