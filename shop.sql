
DROP TABLE IF EXISTS `memberinfo`;

CREATE  TABLE  memberinfo (
  mno  int(11)  NOT NULL  AUTO_INCREMENT,
  nickName  varchar(100)  COLLATE utf8_bin NOT NULL,
  realName  varchar(100)  COLLATE utf8_bin DEFAULT NULL,
  pwd  varchar(100)  COLLATE utf8_bin NOT NULL,
  tel  varchar(15)  COLLATE utf8_bin NOT NULL,
  email  varchar(100)  COLLATE utf8_bin NOT NULL,
  regDate  datetime DEFAULT NULL,
  PRIMARY KEY (mno),
  UNIQUE KEY nickName(nickName),
  UNIQUE KEY tel (tel),
  UNIQUE KEY email (email)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO memberinfo VALUES ('1', 'yang', '', md5('843925707'), '15607450672', '843925707@qq.com', '2020-9-03 19:00:00', '1');
INSERT INTO memberinfo VALUES ('', 'yc', '', md5('123456'), '15096098012', '1293580602@qq.com',  '2020-8-03 16:41:50');
truncate tb1; 

DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE   admininfo (
  aid   int(11)   NOT NULL AUTO_INCREMENT,
  aname   varchar(100)   COLLATE utf8_bin NOT NULL,
  pwd   varchar(100)   COLLATE utf8_bin NOT NULL,
  tel   varchar(15)    COLLATE utf8_bin DEFAULT NULL,
  email  varchar(100)  COLLATE utf8_bin NOT NULL,
  regDate  datetime DEFAULT NULL,
  PRIMARY KEY (aid),
  UNIQUE KEY  aname (aname),
  UNIQUE KEY   tel (tel),
  UNIQUE KEY email (email)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE  goodstype(
  tno   int(11)   NOT NULL AUTO_INCREMENT,
  tname   varchar(100) COLLATE utf8_bin NOT NULL,
  pic varchar(100) COLLATE utf8_bin DEFAULT NULL,
  status   int(11) DEFAULT NULL,
  PRIMARY KEY (tno)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO goodstype VALUES ('1', '休闲食品', 'images/休闲食品.jpg', '1');

CREATE TABLE  goodsinfo (
  gno int(11) NOT NULL AUTO_INCREMENT,
  gname   varchar(100) COLLATE utf8_bin NOT NULL,
  tno  int(11) DEFAULT NULL,
  price  decimal(8,2) DEFAULT NULL,
  intro   varchar(400) COLLATE utf8_bin DEFAULT NULL,
  balance   int(11) DEFAULT NULL,
  pics   varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  unit   varchar(50) COLLATE utf8_bin DEFAULT NULL,
  qperied  varchar(50) COLLATE utf8_bin DEFAULT NULL,
  weight   varchar(50) COLLATE utf8_bin DEFAULT NULL,
  descr   text COLLATE utf8_bin,
  PRIMARY KEY (gno),
  KEY  FK_goodsInfo_tno(tno),
  CONSTRAINT  FK_goodsInfo_tno  FOREIGN KEY (tno)   REFERENCES   goodstype  (tno)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO goodsinfo VALUES ('2', '哈密瓜', '2', '15.00', '很甜，很好吃', '100', 'images/food/哈密瓜.jpg', '个', '1个月', '1KG', null);

CREATE TABLE  cartinfo  (
  cno varchar(100) COLLATE utf8_bin NOT NULL,
  mno int(11) DEFAULT NULL,
  gno   int(11) DEFAULT NULL,
  num   int(11) DEFAULT NULL,
  PRIMARY KEY (cno),
  KEY   FK_cartInfo_mno  (mno),
  KEY   FK_cartInfo_gno  (gno),
  CONSTRAINT   FK_cartInfo_gno   FOREIGN KEY ( gno) REFERENCES  goodsinfo (gno),
  CONSTRAINT   FK_cartInfo_mno FOREIGN KEY (mno) REFERENCES  memberinfo (mno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE  orderinfo (
  ono   varchar(100) COLLATE utf8_bin NOT NULL,
  odate  datetime DEFAULT NULL,
  ano   varchar(100) COLLATE utf8_bin DEFAULT NULL,
  sdate   datetime DEFAULT NULL,
  rdate   datetime DEFAULT NULL,
  status  int(11) DEFAULT NULL,
  price  decimal(10,2) DEFAULT NULL,
  invoice  int(11) DEFAULT NULL,
  PRIMARY KEY (ono),
  KEY  FK_orderInfo_ano (ano),
  CONSTRAINT  FK_orderInfo_ano FOREIGN KEY (ano) REFERENCES addrinfo (ano)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE   orderiteminfo (
  ino   int(11) NOT NULL AUTO_INCREMENT,
  ono   varchar(100) COLLATE utf8_bin DEFAULT NULL,
  gno   int(11) DEFAULT NULL,
  nums   int(11) DEFAULT NULL,
  price   decimal(10,2) DEFAULT NULL,
  status   int(11) DEFAULT NULL,
  PRIMARY KEY ( ino),
  KEY   FK_orderItemInfo_gno (gno),
  KEY   FK_orderItemInfo_ono  (ono),
  CONSTRAINT   FK_orderItemInfo_gno   FOREIGN KEY (gno) REFERENCES  goodsinfo (gno),
  CONSTRAINT   FK_orderItemInfo_ono   FOREIGN KEY (ono) REFERENCES  orderinfo (ono)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `addrinfo` (
  `ano` varchar(100) COLLATE utf8_bin NOT NULL,
  `mno` int(11) DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin NOT NULL,
  `province` varchar(100) COLLATE utf8_bin NOT NULL,
  `city` varchar(100) COLLATE utf8_bin NOT NULL,
  `area` varchar(100) COLLATE utf8_bin NOT NULL,
  `addr` varchar(100) COLLATE utf8_bin NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ano`),
  KEY `FK_addrInfo_mno` (`mno`),
  CONSTRAINT `FK_addrInfo_mno` FOREIGN KEY (`mno`) REFERENCES `memberinfo` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;