--     private int id;
--     private String data;
--     private byte isDel;

create table if not exists demo01 (
  id int(4) not null primary key auto_increment,
  `data` varchar(300) default null,
  isDel tinyint(1) default 0
) engine = InnoDB default charset = utf8 auto_increment = 1;
