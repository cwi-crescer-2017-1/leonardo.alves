SELECT * INTO CidadeAux FROM Cidade;

TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux (Cidade.IDCidade, CidadeAux.Nome, CidadeAux.UF)
	(SELECT Cidade.IDCidade, Cidade.Nome, Cidade.UF FROM Cidade WHERE Cidade.UF = 'RS');

CREATE TABLE InformacoesProduto (
	IDInformacoesProduto int identity  not null,
	NomeCurto varchar(15)  not null,
	NomeDescritivo varchar(60) ,
	DataDaCriacao date  not null,
	LocalNoEstoque varchar(60) ,
	Quantidade int  not null,
	Preco float not null,
	constraint PK_InformacoesProduto_IDInformacoesProduto primary key (IDInformacoesProduto)
); 

INSERT INTO InformacoesProduto (NomeCurto, NomeDescritivo, DataDaCriacao, LocalNoEstoque, Quantidade, Preco)
	VALUES ('batata','batata doce marca leão','2015-08-23','galpão dos fundos','44',5.40),
		('arroz','arroz branco tipo 2 marca josé','2016-04-11','galpão da frente','90',4.90);

SELECT * FROM InformacoesProduto;