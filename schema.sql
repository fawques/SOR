CREATE DATABASE IF NOT EXISTS `sor_gestor` /*!40100 DEFAULT CHARACTER SET utf8 */;

use sor_gestor;

CREATE TABLE IF NOT EXISTS `desguace` (
  `idDesguace` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDesguace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `taller` (
  `idTaller` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTaller`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`idTaller`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `oferta` (
  `idOferta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` int(11) DEFAULT NULL,
  `desguace` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOferta`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`idDesguace`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE IF NOT EXISTS `sor_taller` /*!40100 DEFAULT CHARACTER SET utf8 */;
use sor_taller;

CREATE TABLE `taller` (
  `idTaller` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTaller`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`idTaller`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `oferta` (
  `idOferta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` int(11) DEFAULT NULL,
  `desguace` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOferta`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE DATABASE IF NOT EXISTS `sor_desguace` /*!40100 DEFAULT CHARACTER SET utf8 */;
use sor_desguace;

CREATE TABLE `desguace` (
  `idDesguace` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDesguace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `pedido_taller_FK_idx` (`taller`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `oferta` (
  `idOferta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` int(11) DEFAULT NULL,
  `desguace` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOferta`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`idDesguace`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



