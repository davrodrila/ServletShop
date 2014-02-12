CREATE TABLE `tienda`.`juegos` (
`IDJuego` INT( 10 ) NOT NULL ,
`Nombre` VARCHAR( 30 ) NOT NULL ,
`Precio` FLOAT( 4 ) NOT NULL ,
`FechaLanzamiento` VARCHAR( 10 ) NOT NULL ,
`Fabricante` VARCHAR( 30 ) NOT NULL ,
`Genero` INT( 3 ) NOT NULL ,
`juegoOnline` INT( 1 ) NOT NULL ,
`imagenJuego` VARCHAR( 50 ) NOT NULL ,
PRIMARY KEY ( `IDJuego` )
