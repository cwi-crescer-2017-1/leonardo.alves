-- Gerado por Oracle SQL Developer Data Modeler 4.2.0.932
--   em:        2017-06-29 21:59:42 BRT
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

--ALTER TABLE usuario ADD CONSTRAINT usuario_id_usuario_un UNIQUE ( id_usuario );

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

ALTER TABLE usuarioamigo ADD CONSTRAINT id_usuario_amigo PRIMARY KEY ( id_usuario_amigo );

ALTER TABLE usuarioamigo ADD CONSTRAINT fk_amigo_id_usuario FOREIGN KEY ( amigo_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE comentario ADD CONSTRAINT fk_comentario_post FOREIGN KEY ( post_id_post )
    REFERENCES post ( id_post );

ALTER TABLE comentario ADD CONSTRAINT fk_comentario_usuario FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE curtida ADD CONSTRAINT fk_curtida_post FOREIGN KEY ( post_id_post )
    REFERENCES post ( id_post );

ALTER TABLE curtida ADD CONSTRAINT fk_curtida_usuario FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE post ADD CONSTRAINT fk_post_usuario FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

ALTER TABLE usuarioamigo ADD CONSTRAINT fk_usuario_id_usuario FOREIGN KEY ( usuario_id_usuario )
    REFERENCES usuario ( id_usuario );

CREATE SEQUENCE seq_comentario START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_curtida START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_post START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_usuario START WITH 1 CACHE 20 ORDER;

CREATE SEQUENCE seq_usuarioamigo START WITH 1 CACHE 20 ORDER;

-- Relat�rio do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             9
-- ALTER TABLE                             13
-- CREATE SEQUENCE                          5

-- ERRORS                                   0
-- WARNINGS                                 0
