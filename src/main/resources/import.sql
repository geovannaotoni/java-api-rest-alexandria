INSERT INTO `authors` (`id`,`name`,`nationality`) VALUES (1,"Pedro Siqueira","Brasileiro");
INSERT INTO `publishers` (`id`,`name`,`address`) VALUES (1,"Prata Editora","Rua Doutor Veiga Filho, 350 São Paulo");

-- Query: SELECT * FROM alexandriadb.books
-- exported data
INSERT INTO `books` (`id`,`genre`,`title`,`publisher_id`) VALUES (1,"Espiritualidade","Senhora das Águas", 1);
INSERT INTO `books` (`id`,`genre`,`title`,`publisher_id`) VALUES (2,"Espiritualidade","Senhora dos Ares", NULL);

INSERT INTO `author_books` (`author_id`,`book_id`) VALUES (1,1);

