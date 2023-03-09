create table wb_member(mb_idx int not null auto_increment,
mb_name varchar(100),
mb_text varchar(1000),
primary key(mb_idx)
)engine=myisam charset=utf8;