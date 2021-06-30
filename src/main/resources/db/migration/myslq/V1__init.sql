CREATE TABLE users (
	id int NOT NULL,
	name varchar(100) NULL,
	data_criacao datetime NOT NULL,
	data_atualizacao datetime NULL,
 PRIMARY KEY (id))ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 ALTER TABLE users
 CHANGE COLUMN id id INT(11) NOT NULL AUTO_INCREMENT,
 ADD UNIQUE INDEX `id_UNIQUE` (id ASC);