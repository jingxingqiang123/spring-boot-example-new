CREATE DATABASE `test1`;

CREATE TABLE `user` (
  `id` INT(11) DEFAULT NULL,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `realname` VARCHAR(200) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8