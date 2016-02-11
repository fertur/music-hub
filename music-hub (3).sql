-- phpMyAdmin SQL Dump
-- version 4.4.13.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost:3306
-- Tiempo de generación: 05-02-2016 a las 02:28:12
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.5.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `music-hub`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE IF NOT EXISTS `genero` (
  `id` int(255) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `descripcion` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Jazz', 'El jazz es una forma de arte musical que se originó en los Estados Unidos mediante la confrontación de los negros con la música europea. La instrumentación, melodía y armonía del jazz se derivan principalmente de la tradición musical de Occidente. El ritmo, el fraseo y la producción de sonido, y los elementos de armonía de blues se derivan de la música africana y del concepto musical de los afroamericanos.'),
(2, 'Mambo', 'El mambo se baila siguiendo un ritmo sincopado, con cuatro pasos por compás, o sea 4/4, nota musical tomada del son cubano y trasmitido al son montuno en el cual se apoya la base del mambo de Perez Prado y de José Curbelo. Se marcan los cuatro tiempos, con movimientos fuertes y frecuentes flexiones de las articulaciones de pies y brazos. Este es un baile "fuerte" que requiere velocidad de pies, mucha energía y pocas inhibiciones.\r\n\r\nEn la actualidad el mambo es uno de los ritmos latinos que se enseñan en clases de baile de salón, aunque en muchas escuelas tiende a confundírsele con el son montuno o guaracha comercialmente llamados salsa en Nueva York.'),
(3, 'Bass‎', 'El Bass (abreviado con las contracciones bass o B) es un tipo de música electrónica que surgió en Inglaterra a principios de los años 1990. El género se caracteriza por los breaks acelerados (típicamente entre 160 y 190 bpm) combinados con poderosas líneas de bajo. El drum and bass comenzó como una ramificación de la música rave a principios de los años 1990. Desde entonces, ha ido evolucionando y combinándose con otros estilos, lo que ha dado lugar a múltiples subgéneros.'),
(4, 'Blues', 'El blues (cuyo significado es melancolía o tristeza) es un género musical vocal e instrumental, basado en la utilización de notas de blues y de un patrón repetitivo, que suele seguir una estructura de doce compases. Originario de las comunidades afroamericanas de Estados Unidos, se desarrolló a través de las espirituales, canciones de oración, canciones de trabajo, rimas inglesas, baladas escocesas e irlandesas narradas y gritos de campo. La utilización de las notas del blues y la importancia de los patrones de llamada y respuesta, tanto en la música como en las letras, son indicativos de la herencia africana-occidental de este género. Un rasgo característico del blues es el uso extensivo de las técnicas "expresivas" de la guitarra (bend, vibrato, slide) y de la armónica (cross harp), que posteriormente influirían en solos de estilos como el rock. El blues influyó en la música popular estadounidense y occidental en general, llegando a formar parte de géneros musicales como el ragtime, jazz, bluegrass, rhythm and blues, rock and roll, funk, heavy metal, hip-hop, música country y canciones pop.\r\n\r\nLos géneros asociados al blues comparten un pequeño número de características similares, debido a que este género musical adopta su forma de las características personales de cada artista que lo interpreta.'),
(5, 'Música clásica', 'La música clásica es la corriente musical que comprende principalmente la música producida o basada en las tradiciones de la música litúrgica y secular de Occidente, principalmente Europa Occidental. Abarca un período de tiempo que va aproximadamente del siglo XI a la actualidad, aunque esta definición no es aplicable a la música realizada en nuestro siglo a pesar de presentar las mismas características. 1 , aunque las principales características del género fueron codificadas principalmente entre 1550 y 1900, que es habitualmente considerado como el período característico de producción de la música clásica.\r\n\r\nEl término música clásica aparece por primera vez a principios del siglo XIX, en un intento para destacar el período que va desde Johann Sebastian Bach hasta Ludwig van Beethoven como una edad dorada de la música.'),
(6, 'Dance', 'La música electrónica de baile, EDM (por sus siglas en inglés electronic dance music), música club, música dance, o simplemente dance, es un conjunto de géneros de música electrónica, como el house, techno, trance, eurodance, italo-disco, drum and bass, el híbrido dance-pop, entre otros. Orientada principalmente al baile, se caracteriza por estar realizada con sonidos sintéticos y ritmos bien marcados y repetitivos, con letras pegadizas cuando no es música instrumental.\r\n\r\nEs también frecuente, en países no angloparlantes, emplear el término "dance" en un sentido más restrictivo -lo que puede originar alguna confusión- para referirse a un subconjunto de la música electrónica de baile integrado fundamentalmente por los géneros de mayor difusión entre el gran público, como son el dance-pop, el italo-disco, el euro-disco, el euro-dance y el trance.\r\n\r\nEl dance comprende un amplio espectro de géneros musicales de contenido percusivo que, en buena medida, son herederos de la música electrónica de Kraftwerk y de la música disco de los años 1970. Esta música nació y fue popularizada en diferentes ambientes de discotecas en los años 1980. Hacia comienzos de los años 1990, la presencia de la música electrónica de baile dentro de la cultura contemporánea se había extendido ampliamente, comenzando a ser estudiada académicamente en áreas científicas como la historia, la cultura y la sociología. Para su creación se utilizan instrumentos electrónicos como el sintetizador, la caja de ritmos y el secuenciador. Generalmente se enfatizan los sonidos únicos de estos instrumentos, incluso cuando se imita el sonido de otros instrumentos acústicos tradicionales. En ocasiones comprende también música no destinada primariamente al baile, pero que está derivada en todo caso de algún género de música electrónica orientado al baile.\r\n\r\nLos géneros más populares dentro del dance como el dance-pop y el euro-dance adoptan varias características de otros géneros (House, Tecno, Trance, Pop entre otros), sin que reúnan unas características absolutamente propias, son siempre influenciados por la moda del momento.[cita requerida] Otra característica es que su música no es compleja debido a su enfoque comercial, manejando sonidos simples y básicos, y conjugándolos con ritmos alegres, siendo muy diferente a la música Underground. Tienen estructuras pop, muy simples: estrofas, estribillos, momentos de clímax, etc. Es la variante más comercial de la electrónica. El sonido de bajo suele ser de tipo TB-303 (sin distorsionar), las letras simples que hablan de amor o fiesta los sonidos de batería son la mayoría de tipo 909, incluye pocas variaciones rítmicas, algún barrido de filtro, voces mayormente femeninas y casi siempre una melodía principal hecha con algún tipo de sonido de sintetizador con onda de dientes de sierra (que suele sonar después de un estribillo cantado).');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generoobra`
--

CREATE TABLE IF NOT EXISTS `generoobra` (
  `id` int(255) NOT NULL,
  `id_genero` int(11) DEFAULT NULL,
  `id_obra` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `generoobra`
--

INSERT INTO `generoobra` (`id`, `id_genero`, `id_obra`) VALUES
(1, 1, 2),
(2, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupoinstrumento`
--

CREATE TABLE IF NOT EXISTS `grupoinstrumento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `grupoinstrumento`
--

INSERT INTO `grupoinstrumento` (`id`, `nombre`) VALUES
(1, 'Viento madera'),
(2, 'Viento metal'),
(3, 'Percusión');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instrumento`
--

CREATE TABLE IF NOT EXISTS `instrumento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_grupoinstrumento` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `instrumento`
--

INSERT INTO `instrumento` (`id`, `nombre`, `id_grupoinstrumento`) VALUES
(1, 'Clarinete', 1),
(2, 'Saxofón', 1),
(3, 'Trompeta', 3),
(4, 'Lira', 3),
(5, 'Fliscorno', 2),
(6, 'Fagot', 1),
(7, 'Trompa', 2),
(8, 'Flauta travesera', 1),
(9, 'Tuba', 2),
(10, 'Trombón', 2),
(11, 'Caja', 3),
(12, 'Timbales', 3),
(13, 'Platillos', 3),
(14, 'Batería', 3),
(15, 'Oboe', 1),
(16, 'Requinto', 1),
(17, 'Bombardino', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numpapel`
--

CREATE TABLE IF NOT EXISTS `numpapel` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `numpapel`
--

INSERT INTO `numpapel` (`id`, `nombre`) VALUES
(1, 'Principal'),
(2, 'Primero (1º)'),
(3, 'Segundo (2º)'),
(4, 'Tercero (3º)'),
(5, 'Cuarto (4ª)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `numpapelobra`
--

CREATE TABLE IF NOT EXISTS `numpapelobra` (
  `id` int(11) NOT NULL,
  `id_obra` int(11) DEFAULT NULL,
  `id_numpapel` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `numpapelobra`
--

INSERT INTO `numpapelobra` (`id`, `id_obra`, `id_numpapel`) VALUES
(1, 1, 1),
(2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE IF NOT EXISTS `obra` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `descripcion` text COLLATE utf8_unicode_ci,
  `id_instrumento` int(11) DEFAULT NULL,
  `id_numpapel` int(11) DEFAULT NULL,
  `fecha_subida` date DEFAULT NULL,
  `fecha_modificacion` date DEFAULT NULL,
  `visitas` int(255) DEFAULT NULL,
  `valoracion` int(255) DEFAULT NULL,
  `destacado` tinyint(1) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_genero` int(11) DEFAULT NULL,
  `id_tonalidadobra` int(11) DEFAULT NULL,
  `id_tipoobra` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`id`, `titulo`, `descripcion`, `id_instrumento`, `id_numpapel`, `fecha_subida`, `fecha_modificacion`, `visitas`, `valoracion`, `destacado`, `id_usuario`, `id_genero`, `id_tonalidadobra`, `id_tipoobra`) VALUES
(1, 'Peraltazo Music', 'Peraltazo Music es una obra tan buena que sirve como ejemplo para esta primera subida. Esta MUY testeada.', 2, 3, '2016-01-19', '2016-01-19', 27, 10, 1, 3, 2, 3, 1),
(2, 'Fertur', 'Esto ta mu fresco.', 1, 3, '2016-01-30', '2016-01-30', 111, 11, 1, 1, 4, 2, 2),
(4, 'la del chepas', 'se hizo la del chepas y compuso esta obra', 4, 5, '2016-01-11', '2016-01-13', 9856, 10, 0, 5, 6, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoobra`
--

CREATE TABLE IF NOT EXISTS `tipoobra` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipoobra`
--

INSERT INTO `tipoobra` (`id`, `descripcion`) VALUES
(1, 'Ensayos'),
(2, 'Pasacalles'),
(3, 'Charangas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE IF NOT EXISTS `tipousuario` (
  `id` int(255) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`id`, `descripcion`) VALUES
(1, 'anónimo'),
(2, 'usuario'),
(3, 'moderador'),
(4, 'administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tonalidadobra`
--

CREATE TABLE IF NOT EXISTS `tonalidadobra` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tonalidadobra`
--

INSERT INTO `tonalidadobra` (`id`, `nombre`) VALUES
(1, 'Clave de Sol'),
(2, 'Clave de Fa'),
(3, 'Clave de Do');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `alias` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `localidad` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_tipousuario` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `password`, `alias`, `localidad`, `email`, `id_tipousuario`) VALUES
(1, 'fertur', 'daw', 'Fernando', 'jalance', 'ferturnando_jalance@hotmail.com', 4),
(2, 'Luketes', 'luketes', 'Lucas Kywalker', 'Castellón de la Rivera', 'luketes@gmail.com', 2),
(3, 'Peraltazo', 'peralta', 'F. Peralta', 'valencia', 'peraltazo@peralta.zo', 2),
(4, 'comandante', 'daw', 'Jose I', 'Valencia', 'comandownte@downland.net', 3),
(5, 'chepas', 'chepas', 'El Chepas', 'Castellón de la Rivera', 'chepas@chepas.nah', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `generoobra`
--
ALTER TABLE `generoobra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `grupoinstrumento`
--
ALTER TABLE `grupoinstrumento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `instrumento`
--
ALTER TABLE `instrumento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `numpapel`
--
ALTER TABLE `numpapel`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `numpapelobra`
--
ALTER TABLE `numpapelobra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipoobra`
--
ALTER TABLE `tipoobra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tonalidadobra`
--
ALTER TABLE `tonalidadobra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `generoobra`
--
ALTER TABLE `generoobra`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `grupoinstrumento`
--
ALTER TABLE `grupoinstrumento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `instrumento`
--
ALTER TABLE `instrumento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `numpapel`
--
ALTER TABLE `numpapel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `numpapelobra`
--
ALTER TABLE `numpapelobra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `obra`
--
ALTER TABLE `obra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tipoobra`
--
ALTER TABLE `tipoobra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tonalidadobra`
--
ALTER TABLE `tonalidadobra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
