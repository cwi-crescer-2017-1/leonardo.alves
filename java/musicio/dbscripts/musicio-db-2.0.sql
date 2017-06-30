-- Gerado por Oracle SQL Developer Data Modeler 4.2.0.932
--   em:        2017-06-30 01:46:20 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE comentario (
    id_comentario        INTEGER NOT NULL,
    comentario           VARCHAR2(1023) NOT NULL,
    post_id_post         INTEGER NOT NULL,
    usuario_id_usuario   INTEGER NOT NULL
);

CREATE INDEX ix_id_comentario ON
    comentario ( id_comentario ASC );

CREATE INDEX ix_comentario ON
    comentario (
        post_id_post
    ASC,
        usuario_id_usuario
    ASC );

ALTER TABLE comentario ADD CONSTRAINT comentario_pk PRIMARY KEY ( id_comentario );

CREATE TABLE curtida (
    id_curtida           INTEGER NOT NULL,
    usuario_id_usuario   INTEGER NOT NULL,
    post_id_post         INTEGER NOT NULL
);

CREATE INDEX ix_id_curtida ON
    curtida ( id_curtida ASC );

CREATE INDEX ix_curtida ON
    curtida (
        usuario_id_usuario
    ASC,
        post_id_post
    ASC );

ALTER TABLE curtida ADD CONSTRAINT curtida_pk PRIMARY KEY ( id_curtida );

CREATE TABLE permissao (
    id_permissao   INTEGER NOT NULL,
    permissao      VARCHAR2(63) NOT NULL
);

CREATE INDEX ix_id_permissao ON
    permissao ( id_permissao ASC );

ALTER TABLE permissao ADD CONSTRAINT permissao_pk PRIMARY KEY ( id_permissao );

CREATE TABLE post (
    id_post              INTEGER NOT NULL,
    texto                VARCHAR2(1023) NOT NULL,
    data_post            DATE NOT NULL,
    usuario_id_usuario   INTEGER NOT NULL
);

CREATE INDEX ix_id_post ON
    post ( id_post ASC );

CREATE INDEX ix_post_usuario ON
    post ( usuario_id_usuario ASC );

ALTER TABLE post ADD CONSTRAINT post_pk PRIMARY KEY ( id_post );

CREATE TABLE usuario (
    id_usuario        INTEGER NOT NULL,
    nome              VARCHAR2(255) NOT NULL,
    email             VARCHAR2(255) NOT NULL,
    senha             VARCHAR2(255) NOT NULL,
    sexo              CHAR(1) NOT NULL,
    data_nascimento   DATE NOT NULL
);

CREATE INDEX ix_usuario ON
    usuario ( id_usuario ASC );

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

CREATE TABLE usuarioamigo (
    id_usuario_amigo     INTEGER NOT NULL,
    situacao             CHAR(1) NOT NULL,
    amigo_id_usuario     INTEGER NOT NULL,
    usuario_id_usuario   INTEGER NOT NULL
);

CREATE INDEX ix_usuario_amigo ON
    usuarioamigo (
        usuario_id_usuario
    ASC,
        amigo_id_usuario
    ASC );

CREATE INDEX ix_id_usuario_amigo ON
    usuarioamigo ( id_usuario_amigo ASC );

ALTER TABLE usuarioamigo ADD CONSTRAINT id_usuario_amigo PRIMARY KEY ( id_usuario_amigo,amigo_id_usuario );

CREATE TABLE usuariopermissao (
    id_usuario_permissao     INTEGER NOT NULL,
    permissao_id_permissao   INTEGER NOT NULL,
    usuario_id_usuario       INTEGER NOT NULL
);

CREATE INDEX ix_usuario_permissao ON
    usuariopermissao (
        permissao_id_permissao
    ASC,
        usuario_id_usuario
    ASC );

CREATE INDEX ix_id_usuario_permissao ON
    usuariopermissao ( id_usuario_permissao ASC );

ALTER TABLE usuariopermissao ADD CONSTRAINT usuariopermissao_pk PRIMARY KEY ( id_usuario_permissao );

ALTER TABLE comentario ADD CONSTRAINT comentario_post_fk FOREIGN KEY ( post_id_post )
    REFERENCES post ( id_post );

ALTER TABLE comentario ADD CONSTRAINT comentario_usuario_fk FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE curtida ADD CONSTRAINT curtida_post_fk FOREIGN KEY ( post_id_post )
    REFERENCES post ( id_post );

ALTER TABLE curtida ADD CONSTRAINT curtida_usuario_fk FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE usuarioamigo ADD CONSTRAINT fk_amigo_id_usuario FOREIGN KEY ( amigo_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE usuarioamigo ADD CONSTRAINT fk_usuario_id_usuario FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE post ADD CONSTRAINT post_usuario_fk FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE usuariopermissao ADD CONSTRAINT usuariopermissao_permissao_fk FOREIGN KEY ( permissao_id_permissao )
    REFERENCES permissao ( id_permissao );

ALTER TABLE usuariopermissao ADD CONSTRAINT usuariopermissao_usuario_fk FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

CREATE SEQUENCE seq_comentario START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_curtida START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_permissao START WITH 1 NOCACHE ORDER;

CREATE SEQUENCE seq_post START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_usuario START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE usuarioamigo_id_usuario_amigo START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_usuariopermissao START WITH 1 NOCACHE ORDER;



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                            12
-- ALTER TABLE                             17
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          7
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
