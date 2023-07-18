-- adicionando chave estrangeira de fornecedor em empresa
alter table empresa add constraint fk_fornecedor_empresa foreign key (id) references fornecedor(id);

-- adicionando chave estrangeira de empresa em fornecedor
alter table fornecedor add constraint fk_empresa_fornecedor foreign key (id) references empresa(id);

-- adicionando chave estrangeira de pessoa fisica em fornecedor
alter table fornecedor add constraint fk_pessoa_fisica_fornecedor foreign key (id) references pessoafisica(id);

-- adicionando chave estrangeira de fornecedor em pessoa fisica
alter table pessoafisica add constraint fk_fornecedor_pessoa_fisica foreign key (id) references fornecedor(id);
