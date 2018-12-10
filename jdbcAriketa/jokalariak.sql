-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2018 a las 13:36:58
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ariketa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jokalariak`
--

CREATE DATABASE ariketa;

use ariketa;

CREATE TABLE IF NOT EXISTS `jokalariak` (
  `izena` varchar(15) NOT NULL,
  `abizena` varchar(20) NOT NULL,
  `emaila` varchar(45) NOT NULL,
  `postua` varchar(15) NOT NULL,
  `urtea` int(11) NOT NULL,
  PRIMARY KEY (`emaila`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jokalariak`
--

INSERT INTO `jokalariak` (`izena`, `abizena`, `emaila`, `postua`, `urtea`) VALUES
('ane', 'herrero', 'aneherrero@gmail.com', 'central', 26),
('ariane', 'gayoso', 'arianegayoso@gmail.com', 'pivote', 24),
('cristina', 'vivar', 'cristinavivar@gmail.com', 'lateral', 20),
('irune', 'ruiz', 'iruneruiz@gmail.com', 'extremo', 18),
('itziar', 'horrillo', 'itziarhorrilo@gmail.com', 'extremo', 23),
('janire', 'goenaga', 'janiregoenaga@gmail.com', 'extremo', 20),
('jone', 'izquierdo', 'joneizquierdo@gmail.com', 'lateral', 18),
('mirene', 'moreno', 'mirenemoreno@gmail.com', 'extremo', 20),
('nekane', 'recalde', 'nekanerecalde@gmail.com', 'central', 20),
('sara', 'garrido', 'saragarrido@gmail.com', 'portera', 21),
('sara', 'segura', 'sarasegura@gmail.com', 'central', 18),
('yaiza', 'rico', 'yaizarico@gmail.com', 'central', 23);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
