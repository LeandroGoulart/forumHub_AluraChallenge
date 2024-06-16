create table topicos (
    id bigint auto_increment not null primary key,
    titulo varchar(100) not null,
    mensagem text not null,
    data_criacao timestamp not null,
    nome_autor varchar(100) not null,
    email_autor varchar(100) not null
);