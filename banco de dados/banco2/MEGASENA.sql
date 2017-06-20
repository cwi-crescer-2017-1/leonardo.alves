create or replace package pck_megasena is

  -- Author  : ANDRENUNES
  -- Purpose : Manipulação na base de dados da Loteria mais conhecida do Brasil
  
  -- Variáveis Globais - definidas em procedimento específico
  gPremio_sena          number(12,2) := 0;
  gPremio_quina         number(12,2) := 0;
  gPremio_quadra        number(12,2) := 0;
  gAcumulado_proximo_05 number(12,2) := 0;
  gAcumulado_final_ano  number(12,2) := 0;
  
  -- Public type declarations
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number);
  function buscaPercentual(pIdentificador in varchar2) return number;
  procedure atualizaAcertadores (pConcurso in integer);
  
  procedure geraProximoConcurso;
  
  -- array para a tarefa atualizar acertadores  
  type numerosSorteados is varray(6) of integer;
  
end pck_megasena;
/

create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
    
  function pegarIdUltimoConcurso return integer as
    vId integer;
    begin    
        select max(idconcurso) into vId  from concurso; 
    return vId;
  end pegarIdUltimoConcurso;  
  
  ----
  
  function verificarAcumulado (pId in integer) return integer as
    vAcumulou integer;
    begin
        select acumulou
            into vAcumulou from concurso 
            where idconcurso = pId;     
    return vAcumulou;    
  end verificarAcumulado;
  
  ----
  
  function pegarTotalArrecadado (pId in integer) return number as
    vTotalArrecadado number(12,2);
    begin
        select (premio_sena + premio_quina + premio_quadra + acumulado_proximo_05 + acumulado_final_ano)
            into vTotalArrecadado 
            from concurso 
            where idconcurso = pId; 
    return vTotalArrecadado;
  end pegarTotalArrecadado;
  
  ----
  
  function defineProximoSorteio (pDiaDaSemana in char, pData in date) return date as
  /*    se o ultimo concurso for sabado, adiciona quatro dias pro proximo.
        se for quarta, adiciona tres dias pro proximo.    */    
    vData date;
    begin
        if pDiaDaSemana = 4 then
           vData := pData + 3;
        elsif pDiaDaSemana = 7 then
            vData := pData + 4;
        end if;  
    return vData;
  end defineProximoSorteio;
  
  ----
   /* PROCEDURE PRINCIPAL*/
  procedure geraProximoConcurso as      
            
    --- variaveis a respeito do concurso anterior  
    vIdUltimoConcurso        integer;
    vTotalArrecadado         number(12,2);
    vAcumulou                integer;  
    vDiaSemanaConcursoAnt    char;
    
    --- variaveis a respeito deste concurso
    vPremioBruto number(12,2);
    vIdConcurso  integer;
    vDataSorteio date;
    
   begin
     
      vIdUltimoConcurso := pegarIdUltimoConcurso;        
      vIdConcurso := vIdUltimoConcurso + 1;                
     
      vTotalArrecadado := pegarTotalArrecadado(vIdUltimoConcurso);                
      vPremioBruto := vTotalArrecadado * 0.453; -- 45,3% do total arrecadado.      
   
      vAcumulou := verificarAcumulado(vIdUltimoConcurso);  
      if vAcumulou = 1 then
        vPremioBruto := vPremioBruto + vTotalArrecadado;
      end if;
      
      -- pega o dia da semana e a data em que houve o sorteio anterior
      select to_char(data_sorteio, 'D'), data_sorteio 
        into vDiaSemanaConcursoAnt, vDataSorteio
        from concurso 
        where idconcurso = vIdUltimoConcurso;        
       
      vDataSorteio := defineProximoSorteio(vDiaSemanaConcursoAnt, vDataSorteio);     
      
      defineRateioPremio(vPremioBruto);    
       
       insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       values 
           (vIdConcurso, vDataSorteio, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
      
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
       
   function defineNumerosPremiados (pConcurso in integer) return numerosSorteados as
    sorteado numerosSorteados := numerosSorteados(0,0,0,0,0,0);
     -- preenche o array com os  numeros sorteados     
     begin        
        select 
            primeira_dezena, segunda_dezena, terceira_dezena, quarta_dezena, quinta_dezena, sexta_dezena
        into 
            sorteado(1), sorteado(2), sorteado(3), sorteado(4), sorteado(5), sorteado(6)
        from concurso where idconcurso = pConcurso;
    
     return sorteado;
   end defineNumerosPremiados;
   
   ----
   
   function pegarPremio (pAcertos in integer, pIdConcurso in integer) return number as
        vPremio number(12,2);
        begin
            if pAcertos = 4 then
                select premio_quadra into vPremio from concurso where idconcurso = pIdConcurso;
            elsif pAcertos = 5 then
                select premio_quina into vPremio from concurso where idconcurso = pIdConcurso;
            elsif pAcertos = 6 then
                select premio_sena into vPremio from concurso where idconcurso = pIdConcurso;
            end if;
            
        return vPremio;
   end pegarPremio;   
   
   ----
   
   procedure adicionarApostaPremiada (pIdAposta in integer, pAcertos in integer, pIdConcurso in integer) as    
        vPremio number(12,2) := pegarPremio(pAcertos, pIdConcurso);
        begin
            insert into aposta_premiada (idaposta, acertos, valor)
            values (pIdAposta, pAcertos, vPremio);  
            
   end adicionarApostaPremiada; 
  
    /* PROCEDURE PRINCIPAL */
  procedure atualizaAcertadores (pConcurso in integer) as
  
    -- variaveis a respeito do concurso    
    vNumeros numerosSorteados := numerosSorteados(0,0,0,0,0,0);
    vHaGanhadores boolean := false;
    
    vGanhadoresQuadra integer := 0;
    vGanhadoresQuina integer  := 0;
    vGanhadoresSena integer   := 0;
    
    -- variavel para cada aposta
    vNumerosAcertados integer;
    
   begin     
    
      vNumeros := defineNumerosPremiados(pConcurso);
   
      -- itera apostas do concurso
      for aposta in (select idaposta from aposta where idconcurso = pConcurso) loop
      
        vNumerosAcertados := 0;
        
        -- itera numeros apostados em aposta
        for numeroSorteado in (select numero from numero_aposta where idaposta = aposta.idaposta) loop
        
            -- checa se o numero bate com algum sorteado
            for n in 1 .. 6 loop      
            
                if numeroSorteado.numero = vNumeros(n) then
                    vNumerosAcertados := vNumerosAcertados + 1;
                end if;                
                
            end loop; -- loop 1..6
            
        end loop; -- loop numero     
        
        if vNumerosAcertados = 4 then
            vGanhadoresQuadra := vGanhadoresQuadra + 1;
        elsif vNumerosAcertados = 5 then
            vGanhadoresQuina := vGanhadoresQuina + 1;
        elsif vnumerosAcertados = 6 then
            vGanhadoresSena := vGanhadoresQuina + 1;
        end if;
        
        if vNumerosAcertados >= 4 then
            adicionarApostaPremiada(aposta.idaposta, vNumerosAcertados, pConcurso);            
        end if;  
        
        if vNumerosAcertados = 6 then
            vHaGanhadores := true;
        end if;
        
      end loop; -- loop aposta
      
      --divide o valor para cada ganhador      
      for ap in (select a.acertos, a.valor, a.idaposta_premiada 
                                from aposta_premiada a
                                inner join aposta b on a.idaposta = b.idaposta 
                                inner join concurso c on c.idconcurso = b.idconcurso 
                                where c.idconcurso = pConcurso)
      loop
      
        if ap.acertos = 4 then
            update aposta_premiada set valor = ap.valor / vGanhadoresQuadra
                where ap.idaposta_premiada = aposta_premiada.idaposta_premiada;
        elsif ap.acertos = 5 then
            update aposta_premiada set valor = ap.valor / vGanhadoresQuina  
                where ap.idaposta_premiada = aposta_premiada.idaposta_premiada;
        else 
            update aposta_premiada set valor = ap.valor / vGanhadoresSena   
                where ap.idaposta_premiada = aposta_premiada.idaposta_premiada;
        end if;     
    
      end loop;      
      
      if vHaGanhadores then
        update concurso set acumulou = 0 where idconcurso = pConcurso;
      else 
        update concurso set acumulou = 1 where idConcurso = pConcurso;
      end if;
      
   end atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;
/