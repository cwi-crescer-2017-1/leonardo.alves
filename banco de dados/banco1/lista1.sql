SELECT * INTO CidadeAux FROM Cidade;

TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux (Cidade.IDCidade, CidadeAux.Nome, CidadeAux.UF)
    SELECT Cidade.IDCidade, Cidade.Nome, Cidade.UF 
	FROM Cidade 
	WHERE Cidade.UF = 'RS';

CREATE TABLE InformacoesProduto (
	IDInformacoesProduto int identity   not null,
	NomeCurto			 varchar(15)	not null,
	NomeDescritivo		 varchar(60)	not null,
	DataDaCriacao		 date			not null,
	LocalNoEstoque		 varchar(60)	not null,
	Quantidade			 decimal(7,3)	not null,
	Preco				 decimal(9,2)	not null,

	constraint PK_InformacoesProduto_IDInformacoesProduto primary key (IDInformacoesProduto)
); 

INSERT INTO InformacoesProduto (NomeCurto, NomeDescritivo, DataDaCriacao, LocalNoEstoque, Quantidade, Preco)
	VALUES 
		('batata','batata doce marca leao', getdate(),'galpao dos fundos',44,5.40),
		('arroz','arroz branco tipo 2 marca jose', getdate(),'galpao da frente',90,4.90);

SELECT * FROM InformacoesProduto

SELECT * FROM CIDADEAUX