
INSERT INTO tb_usuario(nome, cpf, email, senha ,sexo) VALUES('Leo', '1233535', 'leo@gmail.com','$2a$10$C3KsGMEYFhUmvvgZf4wr2uub3fQ3im93ldRduONaPrVyDMSk9kqHq' ,'M');
INSERT INTO tb_usuario(nome, cpf, email, senha ,sexo) VALUES('Alex', '333333', 'alex@gmail.com','$2a$10$dbXsPP4yJvl0qrb.tDOgTuNcZU9mohKc0SerEjqaMr44Lry7tESXm' ,'M');

INSERT INTO tb_perfil(autorizacao) VALUES('ROLE_OPERATOR');
INSERT INTO tb_perfil(autorizacao) VALUES('ROLE_ADMIN');
INSERT INTO tb_perfil(autorizacao) VALUES('ROLE_EMPLOYEE');

INSERT INTO tb_usuario_perfil(id_usuario, id_perfil) VALUES(1, 2);
INSERT INTO tb_usuario_perfil(id_usuario, id_perfil) VALUES(1, 1);
INSERT INTO tb_usuario_perfil(id_usuario, id_perfil) VALUES(1, 3);
INSERT INTO tb_usuario_perfil(id_usuario, id_perfil) VALUES(2, 1);

INSERT INTO tb_categoria(nome) VALUES('Hot-Dog');
INSERT INTO tb_categoria(nome) VALUES('Hambúrguer');
INSERT INTO tb_categoria(nome) VALUES('Pizza');
INSERT INTO tb_categoria(nome) VALUES('Macarrão');
INSERT INTO tb_categoria(nome) VALUES('Marmita');

INSERT INTO tb_produto(descricao, imagem, nome, preco) VALUES('Pão , Salsicha, Queijo e Milho', 'https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/cachorro-quente.png', 'Cachorro-Quente', '10');
INSERT INTO tb_produto(descricao, imagem, nome, preco) VALUES('Pão , hambúrguer, Queijo e alface', 'https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/hamburgue.png', 'X-Bomba', '25');
INSERT INTO tb_produto(descricao, imagem, nome, preco) VALUES('calabresa , queijo, azeitona e orégano', 'https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/pizza.png', 'Pizza Calabresa', '45');
INSERT INTO tb_produto(descricao, imagem, nome, preco) VALUES('macarrão , extrato tomate, queijo', 'https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/macarrao.png', 'Macarrão ao Molho', '15');
INSERT INTO tb_produto(descricao, imagem, nome, preco) VALUES('arroz , feijão, frango, salada', 'https://raw.githubusercontent.com/lima6615/project_Delivery/main/img/marmita.png', 'Marmita de Frango', '15');

INSERT INTO tb_produto_categoria VALUES (1 , 1);
INSERT INTO tb_produto_categoria VALUES (2 , 2);
INSERT INTO tb_produto_categoria VALUES (3 , 3);
INSERT INTO tb_produto_categoria VALUES (4 , 4);
INSERT INTO tb_produto_categoria VALUES (5 , 5);
