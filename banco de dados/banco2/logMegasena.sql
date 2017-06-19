Create table LogApostas (
  IDLogAposta   integer not null, 
  
  IDConcurso_antigo    integer ,
  IDConcurso_novo    integer,
  
  IDAposta_novo integer,
  IDAposta_antigo integer, 
  
  data_aposta_antigo date,
  data_aposta_novo date,
  
  quantidade_numeros_antigo integer,
  quantidade_numeros_novo integer,
  
  valor_antigo number,
  valor_novo number,
  
  Usuario     varchar2(255) not null,
  
  Data          varchar2(255), 
  
  Operacao       char(1) not null, 
  constraint PK_LogApostas 
       primary key (IdLogAposta)
);
--drop table logapostas;
Create sequence sqLogApostas;
----
-- trigger tr_logApostas;
--drop table logApostas;

create or replace trigger TR_LogApostas
    after insert or update or delete on APOSTA
    for each row
Declare
  v_operacao char(1);
 
  v_idConcurso_antigo integer;  
  v_idConcurso_novo integer;  
  v_idAposta_antigo integer;
  v_idAposta_novo integer;
  
  data_aposta_antigo date;
  data_aposta_novo date;
  
  quantidade_numeros_antigo integer;
  quantidade_numeros_novo integer;
  
  valor_antigo number;
  valor_novo number;
  
Begin
  
  if INSERTING then
     v_operacao := 'I';
     
     data_aposta_antigo := null;
     data_aposta_novo := :new.data_hora;
  
    quantidade_numeros_antigo := null;
    quantidade_numeros_novo := :new.quantidade_numeros;
  
    valor_antigo := null;
    valor_novo := :new.valor;
    
    v_idConcurso_antigo := null;
    v_idConcurso_novo := :new.idconcurso;
    
    v_idAposta_antigo := null;
    v_idAposta_novo := :new.idaposta;
    
  elsif UPDATING then
     v_operacao := 'U'; 
     
     data_aposta_antigo := :old.data_hora;
     data_aposta_novo := :new.data_hora;
  
     quantidade_numeros_antigo := :old.quantidade_numeros;
     quantidade_numeros_novo := :new.quantidade_numeros;
  
     valor_antigo := :old.valor;
     valor_novo := :new.valor;
     
     v_idConcurso_antigo := :old.idconcurso;
     v_idConcurso_novo := :new.idconcurso;
     
    v_idAposta_antigo := :old.idaposta;
    v_idAposta_novo := :new.idaposta;
  else
     v_operacao := 'D';
     
     data_aposta_antigo := :old.data_hora;
     data_aposta_novo := null;
  
    quantidade_numeros_antigo := :old.quantidade_numeros;
    quantidade_numeros_novo := null;
  
    valor_antigo := :old.valor;
    valor_novo := null;
    
    v_idConcurso_antigo := :old.idconcurso;
    v_idConcurso_novo := null;
    
    v_idAposta_antigo := :old.idaposta;
    v_idAposta_novo := null;
  end if;
  
  Insert into LogApostas 
                (IDLogAposta,
                IdAposta_novo,
                IdAposta_antigo, 
                IDConcurso_novo, 
                data_aposta_novo,
                quantidade_numeros_novo, 
                valor_novo,
                IDConcurso_antigo, 
                data_aposta_antigo, 
                quantidade_numeros_antigo,
                valor_antigo, 
                data, 
                Usuario, 
                operacao)
      values 
                (sqLogApostas.nextval, 
                v_idAposta_novo,
                v_idAposta_antigo,
                v_idConcurso_novo, 
                data_aposta_novo, 
                quantidade_numeros_novo, 
                valor_novo, 
                v_idConcurso_antigo,
                data_aposta_antigo,
                quantidade_numeros_antigo, 
                valor_antigo, 
                to_char(SYSDATE, 'MM-DD-YYYY HH24:MI:SS'), 
                user, 
                v_operacao);

End TR_LogApostas;

---

Create table Log_Numero_Apostas (
  IDLog_Numero_Aposta   integer not null,     
  
  idaposta_antigo integer,
  idaposta_novo integer,
  
  numero_novo   integer,
  numero_antigo integer,
  
  Usuario     varchar2(255) not null,
  
  Data          varchar2(255), 
  
  Operacao       char(1) not null, 
  
  constraint PK_Log_Numero_Apostas 
       primary key (IDLog_Numero_Aposta)
);

Create sequence sqLog_Numero_Apostas;

create or replace trigger TR_logNumero_aposta
  after insert or delete or update on NUMERO_APOSTA
  for each row
DECLARE
  vNumero_antigo number;
  vNumero_novo number;
  
  v_idAposta_antigo integer;
  v_idAposta_novo integer;
  
  v_operacao char(1); 
BEGIN 
  if INSERTING then
     v_operacao := 'I';    
     v_idAposta_antigo := null;
     v_idAposta_novo := :new.idAposta;
     
     vNumero_antigo := null;
     vNumero_novo := :new.numero;
     
  elsif UPDATING then
     v_operacao := 'U'; 
     
     v_idAposta_antigo := :old.idaposta;
     v_idAposta_novo := :new.idAposta;
     
     vNumero_antigo := :old.numero;
     vNumero_novo := :new.numero;
     
  else
     v_operacao := 'D';
     
     v_idAposta_antigo := :old.idaposta;
     v_idAposta_novo := null;
     vNumero_antigo := :old.numero;
     vNumero_novo := null;
     
  end if;
  
  INSERT INTO Log_Numero_apostas   
            (IdLog_Numero_Aposta,
            IdAposta_antigo,
            idAposta_novo,
            numero_novo, 
            numero_antigo, 
            usuario, 
            data, 
            operacao)
    
  VALUES 
            (sqLog_Numero_Apostas.nextval, 
            v_IdAposta_antigo,
            v_IdAposta_novo,
            vnumero_novo, 
            vnumero_antigo,
            user, 
            to_char(SYSDATE, 'MM-DD-YYYY HH24:MI:SS'),
            v_operacao);
END;