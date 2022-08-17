DROP TABLE IF EXISTS `almacenes`;
DROP TABLE IF EXISTS `cajas`;

CREATE TABLE `almacenes` (
  `codigo` int NOT NULL auto_increment,
  `lugar` varchar(255) NOT NULL,
  `capacidad` int NOT NULL,
  PRIMARY KEY (`codigo`)
);

INSERT INTO `almacenes` (`lugar`,`capacidad`) VALUES ('Madrid',2500),('Leon',800),('Lugo',10),('Toledo',93);

CREATE TABLE `cajas` (
  `numReferencia` int NOT NULL auto_increment,
  `contenido` varchar(255) NOT NULL,
  `valor` int NOT NULL,
  `almacen` int NOT NULL,
  PRIMARY KEY (`numReferencia`),
  CONSTRAINT `cajas_fk1` FOREIGN KEY (`almacen`) REFERENCES `almacenes` (`codigo`)
);

INSERT INTO `cajas` (`contenido`,`valor`,`almacen`) VALUES ('Tazas',10,1),('Cucharas',20,2),('Coletero',1,3),('Estuche',15,4);