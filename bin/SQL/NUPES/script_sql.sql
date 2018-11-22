
create database nupes;
use nupes;
create table usuario(
id int(12) not null auto_increment primary key,
matricula varchar(255) ,
senha int(10) not null);


create table pessoa(
id int(12) not null auto_increment primary key,
matricula varchar(255) not null,
nome varchar(255) not null);

create table aluno_curso(
id_curso int(12) ,
id_aluno int(12) ,
foreign key (id_curso) references curso(id),
foreign key (id_aluno) references aluno(id));

create table aluno(
id int(12) not null auto_increment primary key,
id_curso int(12),
periodo int,
foreign key (id) references pessoa(id));

drop table professor;
create table professor(
id int(12) not null auto_increment primary key,
id_curso int(12),
titulacao varchar(255) not null,
foreign key (id) references pessoa(id),
foreign key (id_curso) references curso(id));
drop table curso;

create table curso(
id int(12) not null primary key,
nome varchar(255) not null,
foreign key (id) references pessoa(id));

drop table professor;
INSERT INTO aluno(matricula,id_curso,periodo) values   ('20171043029',1,2);
insert INTO curso(nome,id_curso,matricula) values ('S.I',1,'20171043029');

select p.nome,p.matricula,A.periodo,C.nome
from pessoa as p
INNER JOIN aluno as A on p.matricula = A.matricula
INNER JOIN curso as C on a.id_curso = C.id_curso;
insert INTO usuario(matricula,senha) VALUES('20171043029','123');
INSERT INTO pessoa(matricula,nome) values('20171053029','thiago sena');
INSERT INTO curso(id,nome) values (1,'SISTEMAS DE INFORMAÇÃO');
SELECT 	P.nome, P.matricula, C.nome
FROM pessoa AS P
INNER JOIN curso AS C on P.id = C.ID;