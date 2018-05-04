CREATE TABLE if not exists user (
  id varchar(36) NOT NULL,
  name varchar(128) DEFAULT NULL,
  age int(10) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8