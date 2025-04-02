-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-04-2025 a las 17:12:07
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `siga`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `dni_alumno` int(8) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `email` varchar(48) NOT NULL,
  `matricula` varchar(32) NOT NULL,
  `domicilio` varchar(64) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `telefono_fijo` varchar(15) NOT NULL,
  `telefono_celular` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`dni_alumno`, `nombre`, `apellido`, `email`, `matricula`, `domicilio`, `ciudad`, `telefono_fijo`, `telefono_celular`) VALUES
(35789456, 'Juan', 'Pérez', 'juan.perez@email.com', 'MAT-2023-001', 'Av. Principal 123', 'Buenos Aires', '011-4567890', '15-4567-8901'),
(36987123, 'María', 'González', 'maria.g@email.com', 'MAT-2023-002', 'Calle 25 de Mayo 456', 'Córdoba', '011-4567891', '15-4567-8902'),
(37123456, 'Carlos', 'Rodríguez', 'carlos.r@email.com', 'MAT-2023-003', 'Belgrano 789', 'Rosario', '011-4567892', '15-4567-8903');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal_grandes`
--

CREATE TABLE `animal_grandes` (
  `cod_animal` int(8) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `cod_especie` int(4) NOT NULL,
  `cod_raza` int(4) NOT NULL,
  `peso` int(3) NOT NULL,
  `nacimiento` date NOT NULL,
  `sexo` varchar(6) NOT NULL,
  `color` varchar(32) NOT NULL,
  `dni_duenio` int(8) NOT NULL,
  `vivo` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `animal_grandes`
--

INSERT INTO `animal_grandes` (`cod_animal`, `nombre`, `cod_especie`, `cod_raza`, `peso`, `nacimiento`, `sexo`, `color`, `dni_duenio`, `vivo`) VALUES
(1, 'Tornado', 1, 1, 450, '2019-06-15', 'Macho', 'Negro', 20123456, 'Si'),
(2, 'Victoria', 2, 3, 600, '2018-07-20', 'Hembra', 'Blanco y Negro', 21234567, 'Si'),
(3, 'Lanita', 3, 5, 80, '2020-03-10', 'Hembra', 'Blanco', 22345678, 'Si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animal_pequenios`
--

CREATE TABLE `animal_pequenios` (
  `cod_animal` int(8) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `cod_especie` int(4) NOT NULL,
  `cod_raza` int(4) NOT NULL,
  `peso` int(3) NOT NULL,
  `nacimiento` date NOT NULL,
  `sexo` varchar(6) NOT NULL,
  `color` varchar(32) NOT NULL,
  `dni_duenio` int(8) NOT NULL,
  `vivo` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `animal_pequenios`
--

INSERT INTO `animal_pequenios` (`cod_animal`, `nombre`, `cod_especie`, `cod_raza`, `peso`, `nacimiento`, `sexo`, `color`, `dni_duenio`, `vivo`) VALUES
(1, 'Max', 1, 1, 25, '2020-05-15', 'Macho', 'Dorado', 20123456, 'Si'),
(2, 'Luna', 2, 3, 4, '2021-03-20', 'Hembra', 'Gris', 21234567, 'Si'),
(3, 'Pelusa', 3, 5, 2, '2022-01-10', 'Hembra', 'Blanco', 22345678, 'Si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `caso_clinico` varchar(9) NOT NULL,
  `fecha` date NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(11) NOT NULL,
  `dni_alumno` int(8) NOT NULL,
  `motivo` varchar(200) NOT NULL,
  `anamnesis` varchar(1000) NOT NULL,
  `temperatura` int(3) NOT NULL,
  `fc` int(3) NOT NULL,
  `fr` int(3) NOT NULL,
  `cc` int(1) NOT NULL,
  `ll_cap` varchar(6) NOT NULL,
  `pulso_ritmo` varchar(8) NOT NULL,
  `pulso_intensidad` varchar(6) NOT NULL,
  `hidratacion` varchar(16) NOT NULL,
  `ma_ocular` varchar(12) NOT NULL,
  `ma_bucal` varchar(12) NOT NULL,
  `ma_nasal` varchar(12) NOT NULL,
  `ma_genital` varchar(12) NOT NULL,
  `submandibular` varchar(27) DEFAULT NULL,
  `axilar` varchar(27) DEFAULT NULL,
  `inguinales` varchar(27) DEFAULT NULL,
  `popliteos` varchar(27) DEFAULT NULL,
  `lesion_tipo` varchar(64) DEFAULT NULL,
  `lesion_forma` varchar(16) DEFAULT NULL,
  `lesion_ubicacion` varchar(16) DEFAULT NULL,
  `lesion_simetria` varchar(16) DEFAULT NULL,
  `olor` varchar(64) DEFAULT NULL,
  `prurito` varchar(2) DEFAULT NULL,
  `manto_piloso` varchar(64) DEFAULT NULL,
  `ectoparasitos` varchar(2) DEFAULT NULL,
  `oido` varchar(64) DEFAULT NULL,
  `boca` varchar(128) DEFAULT NULL,
  `esofago` varchar(128) DEFAULT NULL,
  `estomago` varchar(128) NOT NULL,
  `intestino` varchar(128) DEFAULT NULL,
  `higado` varchar(128) DEFAULT NULL,
  `regurgitacion` varchar(2) DEFAULT NULL,
  `vomito` varchar(2) DEFAULT NULL,
  `diarrea` varchar(2) DEFAULT NULL,
  `ruidos` varchar(2) DEFAULT NULL,
  `distension` varchar(2) DEFAULT NULL,
  `vias_superiores` varchar(128) DEFAULT NULL,
  `vias_inferriores` varchar(128) DEFAULT NULL,
  `ritmo_respiratorio` varchar(9) DEFAULT NULL,
  `tipo` varchar(6) DEFAULT NULL,
  `tos_reflejo` varchar(8) DEFAULT NULL,
  `auscultacion` varchar(128) DEFAULT NULL,
  `corazon_auscultacion` varchar(256) DEFAULT NULL,
  `ritmo_corazon` varchar(9) DEFAULT NULL,
  `riñones` varchar(128) DEFAULT NULL,
  `ureteres` varchar(128) DEFAULT NULL,
  `vejiga` varchar(128) DEFAULT NULL,
  `uretra` varchar(128) DEFAULT NULL,
  `secreciones` varchar(128) DEFAULT NULL,
  `orina` varchar(128) DEFAULT NULL,
  `genitales_interno` varchar(16) DEFAULT NULL,
  `genitales_externo` varchar(64) DEFAULT NULL,
  `genitales_secreciones` varchar(32) DEFAULT NULL,
  `tacto_rectal` varchar(32) DEFAULT NULL,
  `locomotor_lesion` varchar(32) DEFAULT NULL,
  `locomotor_ubicacionL` varchar(16) DEFAULT NULL,
  `locomotor_deformacion` varchar(32) DEFAULT NULL,
  `locomotor_ubicacionD` varchar(32) DEFAULT NULL,
  `claudicacion_miembro` varchar(32) DEFAULT NULL,
  `claudicacion_tipo` int(1) DEFAULT NULL,
  `nervioso_ubicacion` varchar(32) DEFAULT NULL,
  `paralisis` varchar(32) DEFAULT NULL,
  `paresia` varchar(32) DEFAULT NULL,
  `convulsion` varchar(32) DEFAULT NULL,
  `ataxia` varchar(2) DEFAULT NULL,
  `reflejos` varchar(32) DEFAULT NULL,
  `sensibilidad` varchar(10) DEFAULT NULL,
  `conducta` varchar(16) DEFAULT NULL,
  `estado_sensorio` varchar(16) DEFAULT NULL,
  `snms` varchar(32) DEFAULT NULL,
  `snmi` varchar(32) DEFAULT NULL,
  `ojo_derecho` varchar(32) DEFAULT NULL,
  `ojo_izq` varchar(32) DEFAULT NULL,
  `diagnostico_presuntivo` varchar(140) DEFAULT NULL,
  `diagnostico_diferencial` varchar(140) DEFAULT NULL,
  `diagnostico_pronostico` varchar(256) DEFAULT NULL,
  `tratamiento` varchar(256) DEFAULT NULL,
  `indicaciones` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultag`
--

CREATE TABLE `consultag` (
  `caso_clinico` varchar(9) NOT NULL,
  `fecha` date NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(11) NOT NULL,
  `dni_alumno` int(8) NOT NULL,
  `motivo` varchar(200) NOT NULL,
  `anamnesis` varchar(1000) NOT NULL,
  `temperatura` int(3) NOT NULL,
  `fc` int(3) NOT NULL,
  `fr` int(3) NOT NULL,
  `cc` int(1) NOT NULL,
  `ll_cap` varchar(6) NOT NULL,
  `pulso_ritmo` varchar(8) NOT NULL,
  `pulso_intensidad` varchar(6) NOT NULL,
  `hidratacion` varchar(16) NOT NULL,
  `ma_ocular` varchar(12) NOT NULL,
  `ma_bucal` varchar(12) NOT NULL,
  `ma_nasal` varchar(12) NOT NULL,
  `ma_genital` varchar(12) NOT NULL,
  `submandibular` varchar(27) DEFAULT NULL,
  `axilar` varchar(27) DEFAULT NULL,
  `inguinales` varchar(27) DEFAULT NULL,
  `popliteos` varchar(27) DEFAULT NULL,
  `hallazgos` varchar(512) NOT NULL,
  `diagnostico_presuntivo` varchar(140) DEFAULT NULL,
  `diagnostico_diferencial` varchar(140) DEFAULT NULL,
  `diagnostico_pronostico` varchar(256) DEFAULT NULL,
  `tratamiento` varchar(256) DEFAULT NULL,
  `indicaciones` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `derivacion`
--

CREATE TABLE `derivacion` (
  `cod_derivacion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(11) NOT NULL,
  `dni_alumno` int(8) NOT NULL,
  `solicitud` varchar(512) NOT NULL,
  `sistema` varchar(512) NOT NULL,
  `sugerencia` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `derivaciong`
--

CREATE TABLE `derivaciong` (
  `cod_derivacion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(11) NOT NULL,
  `dni_alumno` int(8) NOT NULL,
  `solicitud` varchar(512) NOT NULL,
  `sistema` varchar(512) NOT NULL,
  `sugerencia` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `dni_doctor` int(8) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `email` varchar(48) NOT NULL,
  `matricula` varchar(32) NOT NULL,
  `domicilio` varchar(64) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `telefono_fijo` varchar(15) NOT NULL,
  `telefono_celular` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `doctor`
--

INSERT INTO `doctor` (`dni_doctor`, `nombre`, `apellido`, `email`, `matricula`, `domicilio`, `ciudad`, `telefono_fijo`, `telefono_celular`) VALUES
(25789456, 'Alberto', 'Martínez', 'alberto.m@clinica.com', 'MV-001', 'San Martín 234', 'Buenos Aires', '011-4567893', '15-4567-8904'),
(26987123, 'Laura', 'Sánchez', 'laura.s@clinica.com', 'MV-002', 'Rivadavia 567', 'Córdoba', '011-4567894', '15-4567-8905'),
(27123456, 'Ricardo', 'López', 'ricardo.l@clinica.com', 'MV-003', 'Mitre 890', 'Rosario', '011-4567895', '15-4567-8906');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duenio`
--

CREATE TABLE `duenio` (
  `dni_duenio` int(8) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `email` varchar(48) NOT NULL,
  `facebook` varchar(32) NOT NULL,
  `domicilio` varchar(64) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `telefono_fijo` varchar(15) NOT NULL,
  `telefono_celular` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `duenio`
--

INSERT INTO `duenio` (`dni_duenio`, `nombre`, `apellido`, `email`, `facebook`, `domicilio`, `ciudad`, `telefono_fijo`, `telefono_celular`) VALUES
(20123456, 'Pedro', 'Gómez', 'pedro.g@email.com', 'pedro.gomez', 'Lavalle 123', 'Buenos Aires', '011-4567896', '15-4567-8907'),
(21234567, 'Ana', 'Fernández', 'ana.f@email.com', 'ana.fernandez', 'Corrientes 456', 'Córdoba', '011-4567897', '15-4567-8908'),
(22345678, 'Luis', 'Torres', 'luis.t@email.com', 'luis.torres', 'Santa Fe 789', 'Rosario', '011-4567898', '15-4567-8909'),
(25145214, 'pepo', 'lara', '', '', '', 'bs as', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hemograma`
--

CREATE TABLE `hemograma` (
  `protocolo_lab` varchar(9) NOT NULL,
  `fecha` varchar(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(8) NOT NULL,
  `eritrocitos` int(8) DEFAULT NULL,
  `hemoglobina` int(2) DEFAULT NULL,
  `hematorcrito` int(2) DEFAULT NULL,
  `vcm` int(2) DEFAULT NULL,
  `hcm` int(2) DEFAULT NULL,
  `chcm` int(2) DEFAULT NULL,
  `reticulocitos` int(2) DEFAULT NULL,
  `ipr` int(3) DEFAULT NULL,
  `eritr_nucleados` int(3) DEFAULT NULL,
  `p_plasmaticas` decimal(3,0) DEFAULT NULL,
  `fibrinogeno` int(4) DEFAULT NULL,
  `rel_pp_fibr` int(2) DEFAULT NULL,
  `leucocitos` int(5) DEFAULT NULL,
  `mieloblastos` int(3) DEFAULT NULL,
  `promielocitos` int(3) DEFAULT NULL,
  `mielocitos` int(3) DEFAULT NULL,
  `metamielocitos` int(3) DEFAULT NULL,
  `neutrof_cay` int(3) DEFAULT NULL,
  `neutrof_seg` int(3) DEFAULT NULL,
  `eosinofilos` int(3) DEFAULT NULL,
  `basofilos` int(3) DEFAULT NULL,
  `linfocitos` int(3) DEFAULT NULL,
  `monocitos` int(3) DEFAULT NULL,
  `observaciones` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hemogramag`
--

CREATE TABLE `hemogramag` (
  `protocolo_lab` varchar(9) NOT NULL,
  `fecha` varchar(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(8) NOT NULL,
  `eritrocitos` int(8) DEFAULT NULL,
  `hemoglobina` int(2) DEFAULT NULL,
  `hematorcrito` int(2) DEFAULT NULL,
  `vcm` int(2) DEFAULT NULL,
  `hcm` int(2) DEFAULT NULL,
  `chcm` int(2) DEFAULT NULL,
  `reticulocitos` int(2) DEFAULT NULL,
  `ipr` int(3) DEFAULT NULL,
  `eritr_nucleados` int(3) DEFAULT NULL,
  `p_plasmaticas` decimal(3,0) DEFAULT NULL,
  `fibrinogeno` int(4) DEFAULT NULL,
  `rel_pp_fibr` int(2) DEFAULT NULL,
  `leucocitos` int(5) DEFAULT NULL,
  `mieloblastos` int(3) DEFAULT NULL,
  `promielocitos` int(3) DEFAULT NULL,
  `mielocitos` int(3) DEFAULT NULL,
  `metamielocitos` int(3) DEFAULT NULL,
  `neutrof_cay` int(3) DEFAULT NULL,
  `neutrof_seg` int(3) DEFAULT NULL,
  `eosinofilos` int(3) DEFAULT NULL,
  `basofilos` int(3) DEFAULT NULL,
  `linfocitos` int(3) DEFAULT NULL,
  `monocitos` int(3) DEFAULT NULL,
  `observaciones` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_especie`
--

CREATE TABLE `lista_especie` (
  `cod_especie` int(4) NOT NULL,
  `especie` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lista_especie`
--

INSERT INTO `lista_especie` (`cod_especie`, `especie`) VALUES
(1, 'Perro'),
(2, 'Gato'),
(3, 'Conejo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_especieg`
--

CREATE TABLE `lista_especieg` (
  `cod_especie` int(4) NOT NULL,
  `especie` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lista_especieg`
--

INSERT INTO `lista_especieg` (`cod_especie`, `especie`) VALUES
(1, 'Caballo'),
(2, 'Vaca'),
(3, 'Oveja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_raza`
--

CREATE TABLE `lista_raza` (
  `cod_raza` int(4) NOT NULL,
  `cod_especie` int(4) NOT NULL,
  `raza` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lista_raza`
--

INSERT INTO `lista_raza` (`cod_raza`, `cod_especie`, `raza`) VALUES
(1, 1, 'Labrador'),
(2, 1, 'Pastor Alemán'),
(3, 2, 'Siamés'),
(4, 2, 'Persa'),
(5, 3, 'Holandés');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_razag`
--

CREATE TABLE `lista_razag` (
  `cod_raza` int(4) NOT NULL,
  `cod_especie` int(4) NOT NULL,
  `raza` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lista_razag`
--

INSERT INTO `lista_razag` (`cod_raza`, `cod_especie`, `raza`) VALUES
(1, 1, 'Pura Sangre'),
(2, 1, 'Criollo'),
(3, 2, 'Holstein'),
(4, 2, 'Jersey'),
(5, 3, 'Merino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quimica_clinica`
--

CREATE TABLE `quimica_clinica` (
  `protocolo_lab` varchar(9) NOT NULL,
  `fecha` varchar(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(8) NOT NULL,
  `glucemia` int(3) DEFAULT NULL,
  `uremia` int(3) DEFAULT NULL,
  `creatininemia` decimal(3,0) DEFAULT NULL,
  `fosfatemia` int(3) DEFAULT NULL,
  `albuminemia` decimal(3,0) DEFAULT NULL,
  `got` int(3) DEFAULT NULL,
  `gpt` int(3) DEFAULT NULL,
  `cpk` int(3) DEFAULT NULL,
  `ldh` int(3) DEFAULT NULL,
  `obsercaciones` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quimica_clinicag`
--

CREATE TABLE `quimica_clinicag` (
  `protocolo_lab` varchar(9) NOT NULL,
  `fecha` varchar(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(8) NOT NULL,
  `glucemia` int(3) DEFAULT NULL,
  `uremia` int(3) DEFAULT NULL,
  `creatininemia` decimal(3,0) DEFAULT NULL,
  `fosfatemia` int(3) DEFAULT NULL,
  `albuminemia` decimal(3,0) DEFAULT NULL,
  `got` int(3) DEFAULT NULL,
  `gpt` int(3) DEFAULT NULL,
  `cpk` int(3) DEFAULT NULL,
  `ldh` int(3) DEFAULT NULL,
  `obsercaciones` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `retorno`
--

CREATE TABLE `retorno` (
  `cod_retorno` int(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `fecha` date NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(11) NOT NULL,
  `dni_alumno` int(8) NOT NULL,
  `anamnesis` varchar(1000) NOT NULL,
  `temperatura` int(3) NOT NULL,
  `fc` int(3) NOT NULL,
  `fr` int(3) NOT NULL,
  `cc` int(1) NOT NULL,
  `ll_cap` varchar(6) NOT NULL,
  `pulso_ritmo` varchar(8) NOT NULL,
  `pulso_intensidad` varchar(6) NOT NULL,
  `hidratacion` varchar(16) NOT NULL,
  `ma_ocular` varchar(12) NOT NULL,
  `ma_bucal` varchar(12) NOT NULL,
  `ma_nasal` varchar(12) NOT NULL,
  `ma_genital` varchar(12) NOT NULL,
  `submandibular` varchar(27) DEFAULT NULL,
  `axilar` varchar(27) DEFAULT NULL,
  `inguinales` varchar(27) DEFAULT NULL,
  `popliteos` varchar(27) DEFAULT NULL,
  `sistema` varchar(512) NOT NULL,
  `indicaciones` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `retornog`
--

CREATE TABLE `retornog` (
  `cod_retorno` int(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `fecha` date NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(11) NOT NULL,
  `dni_alumno` int(8) NOT NULL,
  `anamnesis` varchar(1000) NOT NULL,
  `temperatura` int(3) NOT NULL,
  `fc` int(3) NOT NULL,
  `fr` int(3) NOT NULL,
  `cc` int(1) NOT NULL,
  `ll_cap` varchar(6) NOT NULL,
  `pulso_ritmo` varchar(8) NOT NULL,
  `pulso_intensidad` varchar(6) NOT NULL,
  `hidratacion` varchar(16) NOT NULL,
  `ma_ocular` varchar(12) NOT NULL,
  `ma_bucal` varchar(12) NOT NULL,
  `ma_nasal` varchar(12) NOT NULL,
  `ma_genital` varchar(12) NOT NULL,
  `submandibular` varchar(27) DEFAULT NULL,
  `axilar` varchar(27) DEFAULT NULL,
  `inguinales` varchar(27) DEFAULT NULL,
  `popliteos` varchar(27) DEFAULT NULL,
  `sistema` varchar(512) NOT NULL,
  `indicaciones` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `urianalisis`
--

CREATE TABLE `urianalisis` (
  `protocolo_lab` varchar(9) NOT NULL,
  `fecha` varchar(11) NOT NULL,
  `caso_clinico` varchar(9) NOT NULL,
  `cod_animal` int(8) NOT NULL,
  `dni_doctor` int(8) NOT NULL,
  `color` varchar(20) DEFAULT NULL,
  `aspecto` varchar(20) DEFAULT NULL,
  `densidad` varchar(20) DEFAULT NULL,
  `ph` int(2) DEFAULT NULL,
  `proteina` varchar(8) DEFAULT NULL,
  `urobilinogeno` varchar(8) DEFAULT NULL,
  `glucosa` varchar(8) DEFAULT NULL,
  `c_cetonicos` varchar(8) DEFAULT NULL,
  `leucocitos` varchar(8) DEFAULT NULL,
  `nitritos` varchar(8) DEFAULT NULL,
  `sangre_oculta` varchar(8) DEFAULT NULL,
  `pig_biliares` varchar(8) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `celulas_sanguineas` varchar(9) DEFAULT NULL,
  `celulas_sanguineas2` varchar(20) DEFAULT NULL,
  `celulas_epiteliales` varchar(21) DEFAULT NULL,
  `celulas_epiteliales2` varchar(20) DEFAULT NULL,
  `cilindros` varchar(26) DEFAULT NULL,
  `cilindros2` varchar(40) DEFAULT NULL,
  `cristales` varchar(8) DEFAULT NULL,
  `cristales2` varchar(20) DEFAULT NULL,
  `otra` int(15) DEFAULT NULL,
  `otra2` int(40) DEFAULT NULL,
  `observaciones2` int(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`dni_alumno`);

--
-- Indices de la tabla `animal_grandes`
--
ALTER TABLE `animal_grandes`
  ADD PRIMARY KEY (`cod_animal`),
  ADD KEY `cod_especie` (`cod_especie`),
  ADD KEY `cod_raza` (`cod_raza`),
  ADD KEY `dni_duenio` (`dni_duenio`);

--
-- Indices de la tabla `animal_pequenios`
--
ALTER TABLE `animal_pequenios`
  ADD PRIMARY KEY (`cod_animal`),
  ADD KEY `cod_especie` (`cod_especie`),
  ADD KEY `cod_raza` (`cod_raza`),
  ADD KEY `dni_duenio` (`dni_duenio`);

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`),
  ADD KEY `dni_alumno` (`dni_alumno`);

--
-- Indices de la tabla `consultag`
--
ALTER TABLE `consultag`
  ADD PRIMARY KEY (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`),
  ADD KEY `dni_alumno` (`dni_alumno`);

--
-- Indices de la tabla `derivacion`
--
ALTER TABLE `derivacion`
  ADD PRIMARY KEY (`cod_derivacion`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`),
  ADD KEY `dni_alumno` (`dni_alumno`);

--
-- Indices de la tabla `derivaciong`
--
ALTER TABLE `derivaciong`
  ADD PRIMARY KEY (`cod_derivacion`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`),
  ADD KEY `dni_alumno` (`dni_alumno`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`dni_doctor`);

--
-- Indices de la tabla `duenio`
--
ALTER TABLE `duenio`
  ADD PRIMARY KEY (`dni_duenio`);

--
-- Indices de la tabla `hemograma`
--
ALTER TABLE `hemograma`
  ADD PRIMARY KEY (`protocolo_lab`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`);

--
-- Indices de la tabla `hemogramag`
--
ALTER TABLE `hemogramag`
  ADD PRIMARY KEY (`protocolo_lab`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`);

--
-- Indices de la tabla `lista_especie`
--
ALTER TABLE `lista_especie`
  ADD PRIMARY KEY (`cod_especie`);

--
-- Indices de la tabla `lista_especieg`
--
ALTER TABLE `lista_especieg`
  ADD PRIMARY KEY (`cod_especie`);

--
-- Indices de la tabla `lista_raza`
--
ALTER TABLE `lista_raza`
  ADD PRIMARY KEY (`cod_raza`),
  ADD KEY `cod_especie` (`cod_especie`);

--
-- Indices de la tabla `lista_razag`
--
ALTER TABLE `lista_razag`
  ADD PRIMARY KEY (`cod_raza`),
  ADD KEY `cod_especie` (`cod_especie`);

--
-- Indices de la tabla `quimica_clinica`
--
ALTER TABLE `quimica_clinica`
  ADD PRIMARY KEY (`protocolo_lab`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`);

--
-- Indices de la tabla `quimica_clinicag`
--
ALTER TABLE `quimica_clinicag`
  ADD PRIMARY KEY (`protocolo_lab`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`);

--
-- Indices de la tabla `retorno`
--
ALTER TABLE `retorno`
  ADD PRIMARY KEY (`cod_retorno`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`),
  ADD KEY `dni_alumno` (`dni_alumno`);

--
-- Indices de la tabla `retornog`
--
ALTER TABLE `retornog`
  ADD PRIMARY KEY (`cod_retorno`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`),
  ADD KEY `dni_alumno` (`dni_alumno`);

--
-- Indices de la tabla `urianalisis`
--
ALTER TABLE `urianalisis`
  ADD PRIMARY KEY (`protocolo_lab`),
  ADD KEY `caso_clinico` (`caso_clinico`),
  ADD KEY `cod_animal` (`cod_animal`),
  ADD KEY `dni_doctor` (`dni_doctor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `animal_grandes`
--
ALTER TABLE `animal_grandes`
  MODIFY `cod_animal` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `animal_pequenios`
--
ALTER TABLE `animal_pequenios`
  MODIFY `cod_animal` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `derivacion`
--
ALTER TABLE `derivacion`
  MODIFY `cod_derivacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `derivaciong`
--
ALTER TABLE `derivaciong`
  MODIFY `cod_derivacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lista_especie`
--
ALTER TABLE `lista_especie`
  MODIFY `cod_especie` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `lista_especieg`
--
ALTER TABLE `lista_especieg`
  MODIFY `cod_especie` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `lista_raza`
--
ALTER TABLE `lista_raza`
  MODIFY `cod_raza` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `lista_razag`
--
ALTER TABLE `lista_razag`
  MODIFY `cod_raza` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `retorno`
--
ALTER TABLE `retorno`
  MODIFY `cod_retorno` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `retornog`
--
ALTER TABLE `retornog`
  MODIFY `cod_retorno` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `animal_grandes`
--
ALTER TABLE `animal_grandes`
  ADD CONSTRAINT `animal_grandes_ibfk_1` FOREIGN KEY (`cod_especie`) REFERENCES `lista_especieg` (`cod_especie`),
  ADD CONSTRAINT `animal_grandes_ibfk_2` FOREIGN KEY (`cod_raza`) REFERENCES `lista_razag` (`cod_raza`),
  ADD CONSTRAINT `animal_grandes_ibfk_3` FOREIGN KEY (`dni_duenio`) REFERENCES `duenio` (`dni_duenio`);

--
-- Filtros para la tabla `animal_pequenios`
--
ALTER TABLE `animal_pequenios`
  ADD CONSTRAINT `animal_pequenios_ibfk_1` FOREIGN KEY (`cod_especie`) REFERENCES `lista_especie` (`cod_especie`),
  ADD CONSTRAINT `animal_pequenios_ibfk_2` FOREIGN KEY (`cod_raza`) REFERENCES `lista_raza` (`cod_raza`),
  ADD CONSTRAINT `animal_pequenios_ibfk_3` FOREIGN KEY (`dni_duenio`) REFERENCES `duenio` (`dni_duenio`);

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`cod_animal`) REFERENCES `animal_pequenios` (`cod_animal`),
  ADD CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`),
  ADD CONSTRAINT `consulta_ibfk_3` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`);

--
-- Filtros para la tabla `consultag`
--
ALTER TABLE `consultag`
  ADD CONSTRAINT `consultag_ibfk_1` FOREIGN KEY (`cod_animal`) REFERENCES `animal_grandes` (`cod_animal`),
  ADD CONSTRAINT `consultag_ibfk_2` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`),
  ADD CONSTRAINT `consultag_ibfk_3` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`);

--
-- Filtros para la tabla `derivacion`
--
ALTER TABLE `derivacion`
  ADD CONSTRAINT `derivacion_ibfk_1` FOREIGN KEY (`cod_animal`) REFERENCES `animal_pequenios` (`cod_animal`),
  ADD CONSTRAINT `derivacion_ibfk_2` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`),
  ADD CONSTRAINT `derivacion_ibfk_3` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`);

--
-- Filtros para la tabla `derivaciong`
--
ALTER TABLE `derivaciong`
  ADD CONSTRAINT `derivaciong_ibfk_1` FOREIGN KEY (`cod_animal`) REFERENCES `animal_grandes` (`cod_animal`),
  ADD CONSTRAINT `derivaciong_ibfk_2` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`),
  ADD CONSTRAINT `derivaciong_ibfk_3` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`);

--
-- Filtros para la tabla `hemograma`
--
ALTER TABLE `hemograma`
  ADD CONSTRAINT `hemograma_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consulta` (`caso_clinico`),
  ADD CONSTRAINT `hemograma_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_pequenios` (`cod_animal`),
  ADD CONSTRAINT `hemograma_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`);

--
-- Filtros para la tabla `hemogramag`
--
ALTER TABLE `hemogramag`
  ADD CONSTRAINT `hemogramag_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consultag` (`caso_clinico`),
  ADD CONSTRAINT `hemogramag_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_grandes` (`cod_animal`),
  ADD CONSTRAINT `hemogramag_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`);

--
-- Filtros para la tabla `lista_raza`
--
ALTER TABLE `lista_raza`
  ADD CONSTRAINT `lista_raza_ibfk_1` FOREIGN KEY (`cod_especie`) REFERENCES `lista_especie` (`cod_especie`);

--
-- Filtros para la tabla `lista_razag`
--
ALTER TABLE `lista_razag`
  ADD CONSTRAINT `lista_razag_ibfk_1` FOREIGN KEY (`cod_especie`) REFERENCES `lista_especieg` (`cod_especie`);

--
-- Filtros para la tabla `quimica_clinica`
--
ALTER TABLE `quimica_clinica`
  ADD CONSTRAINT `quimica_clinica_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consulta` (`caso_clinico`),
  ADD CONSTRAINT `quimica_clinica_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_pequenios` (`cod_animal`),
  ADD CONSTRAINT `quimica_clinica_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`);

--
-- Filtros para la tabla `quimica_clinicag`
--
ALTER TABLE `quimica_clinicag`
  ADD CONSTRAINT `quimica_clinicag_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consultag` (`caso_clinico`),
  ADD CONSTRAINT `quimica_clinicag_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_grandes` (`cod_animal`),
  ADD CONSTRAINT `quimica_clinicag_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`);

--
-- Filtros para la tabla `retorno`
--
ALTER TABLE `retorno`
  ADD CONSTRAINT `retorno_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consulta` (`caso_clinico`),
  ADD CONSTRAINT `retorno_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_pequenios` (`cod_animal`),
  ADD CONSTRAINT `retorno_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`),
  ADD CONSTRAINT `retorno_ibfk_4` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`);

--
-- Filtros para la tabla `retornog`
--
ALTER TABLE `retornog`
  ADD CONSTRAINT `retornog_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consultag` (`caso_clinico`),
  ADD CONSTRAINT `retornog_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_grandes` (`cod_animal`),
  ADD CONSTRAINT `retornog_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`),
  ADD CONSTRAINT `retornog_ibfk_4` FOREIGN KEY (`dni_alumno`) REFERENCES `alumno` (`dni_alumno`);

--
-- Filtros para la tabla `urianalisis`
--
ALTER TABLE `urianalisis`
  ADD CONSTRAINT `urianalisis_ibfk_1` FOREIGN KEY (`caso_clinico`) REFERENCES `consulta` (`caso_clinico`),
  ADD CONSTRAINT `urianalisis_ibfk_2` FOREIGN KEY (`cod_animal`) REFERENCES `animal_pequenios` (`cod_animal`),
  ADD CONSTRAINT `urianalisis_ibfk_3` FOREIGN KEY (`dni_doctor`) REFERENCES `doctor` (`dni_doctor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
