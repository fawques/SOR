CREATE DATABASE IF NOT EXISTS `sor_gestor` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sor_gestor`;

CREATE TABLE `desguace` (
  `id` char(32) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taller` (
  `id` char(32) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pedido` (
  `id` char(32) NOT NULL,
  `id_aux` int(11) NOT NULL,
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` char(32) NOT NULL,
  `tallerNombre` char(32) NOT NULL,
  `fecha_baja` date DEFAULT '1970-01-01',
  `fecha_limite` date NOT NULL,
  `modo_automatico` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `pedido_taller_FK_idx` (`taller`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id` char(32) NOT NULL,
  `id_aux` int(11) NOT NULL,
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` char(32) NOT NULL,
  `desguace` char(32) NOT NULL,
  `desguaceNombre` char(32) NOT NULL,
  `fecha_baja` date DEFAULT '1970-01-01',
  `fecha_limite` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pieza` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido_pieza` (
  `pedido` char(32) NOT NULL,
  `pieza` varchar(45) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE IF NOT EXISTS `sor_taller` /*!40100 DEFAULT CHARACTER SET utf8 */;
use sor_taller;


CREATE TABLE `taller` (
  `id_aux` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(32) DEFAULT '',
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_aux`),
  KEY `PRIMARY_GESTOR` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `roles`(
  `rol` varchar(45) DEFAULT NULL,
  `nuevo_pedido` int(1) NOT NULL DEFAULT '0',
  `borrar_pedido` int(1) NOT NULL DEFAULT '0',
  `modificar_pedido` int(1) NOT NULL DEFAULT '0',
  `modificar_datos` int(1) NOT NULL DEFAULT '0',
  `baja` int(1) NOT NULL DEFAULT '0',
  `aceptar_ofertas` int(1) NOT NULL DEFAULT '0',
  `rechazar_ofertas` int(1) NOT NULL DEFAULT '0',
  `nuevo_usuario` int(1) NOT NULL DEFAULT '0',
  `nuevo_rol` int(1) NOT NULL DEFAULT '0',
  `cambiar_usuario` int(1) NOT NULL DEFAULT '0',
  `cambiar_rol` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuarios` (
  `nombre` varchar(30) NOT NULL,
  `contrasenya` varchar(30) DEFAULT NULL,
  `rol` varchar(45) NOT NULL,
  `nuevo_pedido` int(1) NOT NULL DEFAULT '0',
  `borrar_pedido` int(1) NOT NULL DEFAULT '0',
  `modificar_pedido` int(1) NOT NULL DEFAULT '0',
  `modificar_datos` int(1) NOT NULL DEFAULT '0',
  `baja` int(1) NOT NULL DEFAULT '0',
  `aceptar_ofertas` int(1) NOT NULL DEFAULT '0',
  `rechazar_ofertas` int(1) NOT NULL DEFAULT '0',
  `nuevo_usuario` int(1) NOT NULL DEFAULT '0',
  `nuevo_rol` int(1) NOT NULL DEFAULT '0',
  `cambiar_usuario` int(1) NOT NULL DEFAULT '0',
  `cambiar_rol` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`nombre`),
  KEY `rol_id` (`rol`),
  CONSTRAINT `rol_usuario` FOREIGN KEY (`rol`) REFERENCES `roles`(`rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido` (
  `id_aux` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(32) UNIQUE DEFAULT '',
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` char(32) NOT NULL,
  `fecha_baja` date DEFAULT '1970-01-01',
  `fecha_limite` date NOT NULL,
  `modo_automatico` tinyint(4) NOT NULL DEFAULT '0',
  `tallerNombre` char(32) NOT NULL,
  PRIMARY KEY (`id_aux`),
  KEY `PRIMARY_GESTOR` (`id`),
  KEY `pedido_taller_FK_idx` (`taller`),
  CONSTRAINT `pedido_taller_FK` FOREIGN KEY (`taller`) REFERENCES `taller` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pieza` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido_pieza` (
  `pedido` int(11) NOT NULL,
  `pieza` varchar(45) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  KEY `pedido_FK_idx` (`pedido`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id_aux`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id_aux` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(32) UNIQUE DEFAULT '',
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` char(32) NOT NULL,
  `desguace` char(32) NOT NULL,
  `desguaceNombre` char(32) NOT NULL,
  `fecha_baja` date DEFAULT '1970-01-01',
  `fecha_limite` date NOT NULL,

  PRIMARY KEY (`id_aux`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  KEY `PRIMARY_GESTOR` (`id`),
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `acciones` (
  `accion` varchar(10000) NOT NULL,
  `params` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE DATABASE IF NOT EXISTS `sor_desguace` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sor_desguace`;

CREATE TABLE `desguace` (
  `id_aux` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(32) DEFAULT '',
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `codPostal` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_aux`),
  KEY `PRIMARY_GESTOR` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `usuarios` (
  `nombre` varchar(30) NOT NULL,
  `contrasenya` varchar(30) DEFAULT NULL,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `pedido` (
  `id_aux` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(32) UNIQUE DEFAULT '',
  `fecha_alta` date NOT NULL,
  `estado` int(11) NOT NULL,
  `taller` char(32) NOT NULL,
  `fecha_baja` date DEFAULT '1970-01-01',
  `fecha_limite` date NOT NULL,
  `modo_automatico` tinyint(4) NOT NULL DEFAULT '0',
  `tallerNombre` char(32) NOT NULL,
  PRIMARY KEY (`id_aux`),
  KEY `PRIMARY_GESTOR` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pieza` (
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id_aux` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(32) UNIQUE DEFAULT '',
  `fecha_alta` date NOT NULL,
  `importe` double NOT NULL,
  `estado` int(11) NOT NULL,
  `pedido` char(32) NOT NULL,
  `desguace` char(32) NOT NULL,
  `fecha_baja` date DEFAULT '1970-01-01',
  `fecha_limite` date NOT NULL,
  `desguaceNombre` char(32) NOT NULL, 
  PRIMARY KEY (`id_aux`),
  KEY `oferta_pedido_FK_idx` (`pedido`),
  KEY `oferta_desguace_FK_idx` (`desguace`),
  CONSTRAINT `oferta_pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oferta_desguace_FK` FOREIGN KEY (`desguace`) REFERENCES `desguace` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `PRIMARY_GESTOR` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedido_pieza` (
  `pedido` int(11) NOT NULL,
  `pieza` varchar(45) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`pedido`,`pieza`),
  KEY `pieza_FK_idx` (`pieza`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id_aux`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pieza_FK` FOREIGN KEY (`pieza`) REFERENCES `pieza` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `acciones` (
  `accion` varchar(10000) NOT NULL,
  `params` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sor_taller`.`roles` (`rol`, `nuevo_pedido`, `borrar_pedido`, `modificar_pedido`, `modificar_datos`, `baja`, `aceptar_ofertas`, `rechazar_ofertas`, `nuevo_usuario`, `nuevo_rol`, `cambiar_usuario`, `cambiar_rol`) VALUES ('Administrador', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
