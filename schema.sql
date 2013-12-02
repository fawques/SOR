CREATE DATABASE IF NOT EXISTS `sor_gestor` /*!40100 DEFAULT CHARACTER SET utf8 */;

use sor_gestor;

CREATE TABLE IF NOT EXISTS `desguace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `taller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` int(11) NOT NULL,
  `desguace` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pieza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pedido_pieza` (
  `pedido` int(11) NOT NULL,
  `pieza` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE DATABASE IF NOT EXISTS `sor_taller` /*!40100 DEFAULT CHARACTER SET utf8 */;
use sor_taller;

CREATE TABLE `taller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` int(11) NOT NULL,
  `desguace` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE IF NOT EXISTS `sor_desguace` /*!40100 DEFAULT CHARACTER SET utf8 */;
use sor_desguace;

CREATE TABLE `desguace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido_taller_FK_idx` (`taller`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` int(11) NOT NULL,
  `desguace` int(11) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



