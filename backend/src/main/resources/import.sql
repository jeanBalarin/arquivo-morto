insert into setor (id_setor, nome, sigla) values (1, 'tecnologia da informação', 'TI');
insert into setor (id_setor, nome, sigla) values (2, 'Recursos Humanos', 'RH');

insert into caixa (id_caixa, numero, prescricao, situacao,id_setor) values (1, '11-11', '2021-01-20', 1, 1);
insert into caixa (id_caixa, numero, prescricao, situacao,id_setor) values (2, '11-12', '2021-02-20', 0, 2);

insert into arquivo (id_arquivo, data_arquivo, descricao, caixa_id_caixa) values (1, '2021-01-21', 'teste 01', 1);
insert into arquivo (id_arquivo, data_arquivo, descricao, caixa_id_caixa) values (2, '2021-02-21', 'TESTe 02', 2);
insert into arquivo (id_arquivo, data_arquivo, descricao, caixa_id_caixa) values (3, '2021-03-21', 'teste 03', 1);
insert into arquivo (id_arquivo, data_arquivo, descricao, caixa_id_caixa) values (4, '2021-04-21', 'teste 04', 2);
insert into arquivo (id_arquivo, data_arquivo, descricao, caixa_id_caixa) values (5, '2021-05-21', 'teste 05', 1);

insert into local (id_local, descricao, nome) values (1, 'ao lado do estacionamento', 'escada amarela');