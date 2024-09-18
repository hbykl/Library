CREATE DATABASE veritabani_adi;

use veritabani_adi;

CREATE TABLE `authors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `publishing_houses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `publishing_house` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `boooks` (
  `isbn` bigint NOT NULL,
  `author` varchar(255) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `publishing_house` varchar(255) NOT NULL,
  `series_name` varchar(255) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `author_id` bigint DEFAULT NULL,
  `house_id` bigint DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `FKgv2lsg2qtbl2jotvt8cme3w4q` (`author_id`),
  KEY `FKfqk1u52m0ncgq8wgu6pidf3k7` (`house_id`),
  CONSTRAINT `FKfqk1u52m0ncgq8wgu6pidf3k7` FOREIGN KEY (`house_id`) REFERENCES `publishing_houses` (`id`),
  CONSTRAINT `FKgv2lsg2qtbl2jotvt8cme3w4q` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
);

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` enum('ROLE_ADMIN','ROLE_STANDART') NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);

INSERT INTO `authors` (`id`,`author`,`description`) VALUES 
(1,'Rick Riordan','fantastik'),
(8,'test author','description'),
(9,'arthur conan doyle','cinayet ve dedektiflik üzerine'),
(10,'Clive Staples Lewis','fantastik kurgu'),
(11,'Elif Şafak','Çocuk kitabı'),
(12,'Özgü Atak','Biyografi'),
(13,'Yaşar Kemal Beyatlı','Roman');

INSERT INTO `publishing_houses` (`id`,`description`,`publishing_house`) VALUES 
(7,'epsilon','epsilon'),
(8,'cinayet ve dedektiflik üzerine','pegasus'),
(9,'fantastik kurgu','Doğan ve Egmont Yayıncılık'),
(10,'Çocuk kitabı','Doğan Egmont'),
(11,'Biyografi','Kaju'),
(12,'1930dan beri','Bulut');

INSERT INTO `boooks` (`isbn`,`author`,`book_name`,`description`,`publishing_house`,`series_name`,`subtitle`,`author_id`,`house_id`) VALUES 
(111,'Rick Riordan','şimşek hırsızı ','fantastik kurgu','Doğan Egmont','percy jackson ve olimpuslular','fantastik',NULL,NULL),
(123,'Özgü Atak','Marley','Biyografi-1','Kaju','Biyografi','köpek',NULL,NULL),
(252,'Clive Staples Lewis','Büyücünün Yeğeni','fantastik kurgu','Doğan ve Egmont Yayıncılık','narnia günlükleri','fantastik',10,9),
(255,'arthur conan doyle','sherlock holmes 1','cinayet ve dedektiflik üzerine','pegasus','sherlock holmes','dedektif',9,8),
(2783,'Elif Şafak','Sakız Sardunya','Çocuk kitabı','Doğan Egmont','','Çocuk',11,10),
(4343,'Clive Staples Lewis','aslan cadı ve dolap','fantastik kurgu','Doğan ve Egmont Yayıncılık','narnia günlükleri','fantastik',NULL,NULL);

INSERT INTO `role` (`id`,`role`) VALUES 
(1,'ROLE_ADMIN'),
(2,'ROLE_STANDART'),
(3,'ROLE_STANDART'),
(4,'ROLE_STANDART'),
(5,'ROLE_STANDART'),
(6,'ROLE_STANDART');

INSERT INTO `user` (`id`,`password`,`username`) VALUES 
(2,'123','husnabykl@com'),
(3,'123','mamizeren@com'),
(4,'gg','hütü@com'),
(5,'kk','test@com'),
(6,'11','mami@com'),
(7,'sifre123','oykatak@example.com');

INSERT INTO `user_roles` (`user_id`,`role_id`) VALUES 
(2,1),
(3,2),
(4,3),
(5,4),
(6,5),
(7,6);