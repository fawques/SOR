CREATE DATABASE IF NOT EXISTS `sor_gestor` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sor_gestor`;

CREATE TABLE IF NOT EXISTS `desguace` (
  `id` binary(16) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `taller` (
  `id` binary(16) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `oferta` (
  `id` binary(16) NOT NULL,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` binary(16) NOT NULL,
  `desguace` binary(16) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pedido` (
  `id` binary(16) NOT NULL,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` binary(16) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pieza` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pedido_pieza` (
  `pedido` binary(16) NOT NULL,
  `pieza` varchar(45) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE IF NOT EXISTS `sor_taller` /*!40100 DEFAULT CHARACTER SET utf8 */;
use sor_taller;

CREATE TABLE IF NOT EXISTS `taller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` binary(16) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PRIMARY_GESTOR` (`id_gestor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` binary(16) DEFAULT NULL,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` binary(16) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PRIMARY_GESTOR` (`id_gestor`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`id_gestor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pieza` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `pedido_pieza` (
  `pedido` binary(16) NOT NULL,
  `pieza` varchar(45) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id_gestor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `oferta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` binary(16) DEFAULT NULL,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` binary(16) NOT NULL,
  `desguace` binary(16) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  KEY `PRIMARY_GESTOR` (`id_gestor`),
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id_gestor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE IF NOT EXISTS `sor_desguace` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sor_desguace`;
CREATE TABLE IF NOT EXISTS `desguace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` binary(16) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_gestor_UNIQUE` (`id_gestor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` binary(16) DEFAULT NULL,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` binary(16) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido_taller_FK_idx` (`taller`),
  KEY `PRIMARY_GESTOR` (`id_gestor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `pieza` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `oferta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_gestor` binary(16) DEFAULT NULL,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` binary(16) NOT NULL,
  `desguace` binary(16) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  KEY `PRIMARY_GESTOR` (`id_gestor`),
  CONSTRAINT `oferta_pedido_fk` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id_gestor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_desguace_fk` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`id_gestor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pedido_pieza` (
  `pedido` binary(16) NOT NULL,
  `pieza` varchar(45) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  CONSTRAINT `pedido_fk` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id_gestor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_fk` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

