create schema desafiofullstack

-- criando tabela empresa
create table empresa
(
    id            int primary key unique,
    nome_fantasia varchar(100)       not null,
    cep           char(8)            not null,
    cnpj          varchar(20) unique not null,
    id_fornecedor int                not null
);

-- criando tabela pessoa fisica
create table pessoa_fisica
(
    id              int primary key unique,
    cep             char(8)      not null,
    email           varchar(100) not null,
    nome            varchar(100) not null,
    cpf             char(11) unique,
    rg              char(7),
    data_nascimento date
);

-- criando tabela fornecedor
create table fornecedor
(
    id              int primary key unique,
    cnpj            varchar(14) null unique,
    id_empresa      int         not null,
    id_pesso_fisica int
)
