-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 23/05/2016 às 21:24
-- Versão do servidor: 5.5.49-0ubuntu0.14.04.1
-- Versão do PHP: 5.5.9-1ubuntu4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `trabalho`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aeroportos`
--

CREATE TABLE IF NOT EXISTS `aeroportos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `sigla` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=215 ;

--
-- Fazendo dump de dados para tabela `aeroportos`
--

INSERT INTO `aeroportos` (`id`, `nome`, `sigla`) VALUES
(1, 'Andre Maggi Airport', 'OTT'),
(2, 'Araraquara Airport', 'AQA'),
(3, 'Santa Maria Airport', 'AJU'),
(4, 'Alta Floresta Airport', 'AFL'),
(5, 'Dario Guarita Airport', 'ARU'),
(6, 'Val de Cans International Airport', 'BEL'),
(7, 'Comandante Gustavo Kraemer Airport', 'BGX'),
(8, 'Pampulha - Carlos Drummond de Andrade Airport', 'PLU'),
(9, 'Major Brigadeiro Doorgal Borges Airport', 'QAK'),
(10, 'Presidente Juscelino Kubistschek International Airport', 'BSB'),
(11, 'Chafei Amsei Airport', 'BAT'),
(12, 'Bauru Airport', 'BAU'),
(13, 'Atlas Brasil Cantanhede Airport', 'BVB'),
(14, 'Umberto Modiano Airport', 'BZC'),
(15, 'Cascavel Airport', 'CAC'),
(16, 'Cabo Frio Airport', 'CFB'),
(17, 'Cachimbo Airport', 'ITB'),
(18, 'Tancredo Neves International Airport', 'CNF'),
(19, 'Campo Grande Airport', 'CGR'),
(20, 'Serafin Enoss Bertaso Airport', 'XAP'),
(21, 'Brig. Lysias Augusto Rodrigues Airport', 'CLN'),
(22, 'Carajas Airport', 'CKS'),
(23, 'Diomicio Freitas Airport', 'CCM'),
(24, 'Caldas Novas Airport', 'CLV'),
(25, 'Canoas Airport', 'QNS'),
(26, 'Bartolomeu Lisandro Airport', 'CAW'),
(27, 'Corumbá International Airport', 'CMG'),
(28, 'Afonso Pena Airport', 'CWB'),
(29, 'Caravelas Airport', 'CRQ'),
(30, 'Campo dos Bugres Airport', 'CXJ'),
(31, 'Marechal Rondon Airport', 'CGB'),
(32, 'Cruzeiro do Sul Airport', 'CZS'),
(33, 'Presidente Prudente Airport', 'PPB'),
(34, 'Eduardo Gomes International Airport', 'MAO'),
(35, 'Jacareacanga Airport', 'JCR'),
(36, 'Cataratas International Airport', 'IGU'),
(37, 'Hercílio Luz International Airport', 'FLN'),
(38, 'Fernando de Noronha Airport', 'FEN'),
(39, 'Pinto Martins International Airport', 'FOR'),
(40, 'Tom Jobim International Airport', 'GIG'),
(41, 'Guajara-Mirim Airport', 'GJM'),
(42, 'Santa Genoveva Airport', 'GYN'),
(43, 'São Paulo International Airport', 'GRU'),
(44, 'Tancredo Thomas de Faria Airport', 'GPB'),
(45, 'Governador Valadares Airport', 'GVR'),
(46, 'Guaratingueta Airport', 'GUJ'),
(47, 'Altamira Airport', 'ATM'),
(48, 'Itacoatiara Airport', 'ITA'),
(49, 'Itaituba Airport', 'ITB'),
(50, 'Bahia - Jorge Amado Airport', 'IOS'),
(51, 'Usiminas Airport', 'IPN'),
(52, 'Prefeito Renato Moreira Airport', 'IMP'),
(53, 'Francisco de Assis Airport', 'JDF'),
(54, 'Presidente Castro Pinto Airport', 'JPA'),
(55, 'Orlando Bezerra de Menezes Airport', 'JDO'),
(56, 'Lauro Carneiro de Loyola Airport', 'JOI'),
(57, 'Campina Grande Airport', 'CPV'),
(58, 'Viracopos International Airport', 'VCP'),
(59, 'Chapada Diamantina Airport', 'LEC'),
(60, 'Lages Airport', 'LAJ'),
(61, 'Lins Airport', 'LIP'),
(62, 'Governador José Richa Airport', 'LDB'),
(63, 'Bom Jesus da Lapa Airport', 'LAZ'),
(64, 'João Correa da Rocha Airport', 'MAB'),
(65, 'Minaçu Airport', 'MQH'),
(66, 'Monte Dourado Airport', 'MEU'),
(67, 'Benedito Lacerda Airport', 'MEA'),
(68, 'Ponta Pelada Airport', 'PLL'),
(69, 'Zumbi dos Palmares Airport', 'MCZ'),
(70, 'Alberto Alcolumbre Airport', 'MCP'),
(71, 'Dix-Sept Rosado Airport', 'MVF'),
(72, 'Campo de Marte Airport', 'SAO'),
(73, 'Ministro Victor Konder International Airport', 'NVT'),
(74, 'Augusto Severo Airport', 'NAT'),
(75, 'Oiapoque Airport', 'OYK'),
(76, 'Salgado Filho Airport', 'POA'),
(77, 'Lauro Kurtz Airport', 'PFB'),
(78, 'Brigadeiro Lysias Rodrigues Airport', 'PMW'),
(79, 'Pelotas Airport', 'PET'),
(80, 'Senador Nilo Coelho Airport', 'PNZ'),
(81, 'Porto Nacional Airport', 'PNB'),
(82, 'Porto Seguro Airport', 'BPS'),
(83, 'Governador Jorge Teixeira de Oliveira Airport', 'PVH'),
(84, 'Plácido de Castro International Airport', 'RBR'),
(85, 'Guararapes - Gilberto Freyre International Airport', 'REC'),
(86, 'Santos Dumont Airport', 'SDU'),
(87, 'Leite Lopes Airport', 'RAO'),
(88, 'Barreirinhas Airport', 'BRB'),
(89, 'Santa Cruz Airport', 'SNZ'),
(90, 'Professor Urbano Ernesto Stumpf Airport', 'SJK'),
(91, 'Marechal Cunha Machado International Airport', 'SLZ'),
(92, 'Santa Maria Airport', 'RIA'),
(93, 'Maestro Wilson Fonseca Airport', 'STM'),
(94, 'Congonhas Airport', 'CGH'),
(95, 'Deputado Luís Eduardo Magalhães International Airport', 'SSA'),
(96, 'Trombetas Airport', 'TMT'),
(97, 'Toledo Airport', 'TOW'),
(98, 'Tabatinga Airport', 'TBT'),
(99, 'Paulo Afonso Airport', 'PAV'),
(100, 'Rubem Berta Airport', 'URG'),
(101, 'Major Brigadeiro Trompowsky Airport', 'VAG'),
(102, 'Vilhena Airport', 'BVH'),
(103, 'Eurico de Aguiar Salles Airport', 'VIX'),
(104, 'Campo Fontenelle Airport', 'QPS'),
(105, 'Amarais Airport', 'CPQ'),
(106, 'Botucatu Airport', 'QCJ'),
(107, 'Senadora Eunice Micheles Airport', 'OLC'),
(108, 'Sorocaba Airport', 'SOD'),
(109, 'Dracena Airport', 'QDC'),
(110, 'Jales Airport', 'JLS'),
(111, 'Mococa Airport', 'QOA'),
(112, 'Aeroclube Airport', 'QNV'),
(113, 'Ourinhos Airport', 'OUS'),
(114, 'Piracicaba Airport', 'QHB'),
(115, 'Rio Claro Airport', 'QIQ'),
(116, 'Resende Airport', 'QRZ'),
(117, 'Ubatuba Airport', 'UBT'),
(118, 'Alagoinhas Airport', 'QGS'),
(119, 'Votuporanga Airport', 'VOT'),
(120, 'Limeira Airport', 'QGB'),
(121, 'Zona da Mata Regional Airport', 'IZA'),
(122, 'Municipal Bom Futuro Airport', 'LVR'),
(123, 'Franca Airport', 'FRC'),
(124, 'Confresa Airport', 'CFO'),
(125, 'Bauru - Arealva Airport', 'JTC'),
(126, 'Usina Santa Cruz Airport', 'ARS'),
(127, 'Arapiraca Airport', 'APQ'),
(128, 'Marcelo Pires Halzhausen Airport', 'AIF'),
(129, 'Barra do Corda Airport', 'BDC'),
(130, 'Belmonte Airport', 'BVM'),
(131, 'Barreiras Airport', 'BRA'),
(132, 'Balsas Airport', 'BSS'),
(133, 'Barra Airport', 'BQQ'),
(134, 'Carutapera Airport', 'CTP'),
(135, 'Cururupu Airport', 'CPU'),
(136, 'Colatina Airport', 'QCH'),
(137, 'Leopoldina Airport', 'LEP'),
(138, 'Canavieiras Airport', 'CNV'),
(139, 'Guarapari Airport', 'ODL'),
(140, 'Guadalupe Airport', 'GDP'),
(141, 'Guanambi Airport', 'GNM'),
(142, 'Garanhuns Airport', 'QGP'),
(143, 'Iguatu Airport', 'QIG'),
(144, 'Itapetinga Airport', 'QIT'),
(145, 'Jacobina Airport', 'JCM'),
(146, 'Santana do Araguaia Airport', 'CMP'),
(147, 'Conselheiro Lafaiete Airport', 'QDF'),
(148, 'Cachoeiro do Itapemirim Airport', 'QXD'),
(149, 'Currais Novos Airport', 'QCP'),
(150, 'Livramento do Brumado Airport', 'LVB'),
(151, 'Monte Alegre Airport', 'MTE'),
(152, 'Mucuri Airport', 'MVS'),
(153, 'Porto de Moz Airport', 'PTQ'),
(154, 'Nanuque Airport', 'NNU'),
(155, 'Sobral Airport', 'QBX'),
(156, 'Picos Airport', 'PCS'),
(157, 'Patos de Minas Airport', 'POJ'),
(158, 'Pirapora Airport', 'PIV'),
(159, 'Cangapara Airport', 'FLB'),
(160, 'Colina Verde Heliport', 'JDO'),
(161, 'Prado Airport', 'PDF'),
(162, 'Caruaru Airport', 'CAU'),
(163, 'Soure Airport', 'SFK'),
(164, 'Juscelino Kubitscheck Airport', 'TFL'),
(165, 'Breves Airport', 'BVS'),
(166, 'Camocim Airport', 'CMC'),
(167, 'Pinheiro Airport', 'PHI'),
(168, 'Pouso Alegre Airport', 'PPY'),
(169, 'Apucarana Airport', 'APU'),
(170, 'Blumenau Airport', 'BNU'),
(171, 'Canela Airport', 'QCN'),
(172, 'Dourados Airport', 'DOU'),
(173, 'Erechim Airport', 'ERM'),
(174, 'Itaqui Airport', 'ITQ'),
(175, 'Santa Terezinha Airport', 'JCB'),
(176, 'Cachoeira do Sul Airport', 'QDB'),
(177, 'Curitibanos Airport', 'QCR'),
(178, 'Carazinho Airport', 'QRE'),
(179, 'Alegrete Novo Airport', 'ALQ'),
(180, 'Mafra Airport', 'QMF'),
(181, 'Montenegro Airport', 'QGF'),
(182, 'Novo Hamburgo Airport', 'QHV'),
(183, 'Arapongas Airport', 'APX'),
(184, 'Pato Branco Airport', 'PTO'),
(185, 'Castro Airport', 'QAC'),
(186, 'Santa Cruz do Sul Airport', 'CSU'),
(187, 'Umuarama Airport', 'UMU'),
(188, 'Videira Airport', 'VIA'),
(189, 'Arapoti Airport', 'AAG'),
(190, 'Santa Rosa Airport', 'SRA'),
(191, 'Ponta Grossa Airport', 'PGZ'),
(192, 'Barcelos Airport', 'BAZ'),
(193, 'Borba Airport', 'RBB'),
(194, 'Carauari Airport', 'CAF'),
(195, 'Costa Marques Airport', 'CQS'),
(196, 'Diamantino Airport', 'DMT'),
(197, 'Canarana Airport', 'CQA'),
(198, 'Gurupi Airport', 'GRP'),
(199, 'Ipiranga Airport', 'IPG'),
(200, 'Santa Izabel do Morro Airport', 'IDO'),
(201, 'Juruena Airport', 'JRN'),
(202, 'Coari Airport', 'CIZ'),
(203, 'General Leite de Castro Airport', 'RVD'),
(204, 'Nova Vida Airport', 'AQM'),
(205, 'Novo Campo Airport', 'BCR'),
(206, 'Parintins Airport', 'PIN'),
(207, 'Pimenta Bueno Airport', 'PBQ'),
(208, 'Arraias Airport', 'AAI'),
(209, 'Santa Terezinha Airport', 'STZ'),
(210, 'Tapuruquara Airport', 'IRZ'),
(211, 'Taguatinga Airport', 'QHN'),
(212, 'Vila Rica Airport', 'VLP'),
(213, 'Regional Orlando Villas Boas Airport', 'MBK'),
(214, 'Xavantina Airport', 'NOK');

-- --------------------------------------------------------

--
-- Estrutura para tabela `avioes`
--

CREATE TABLE IF NOT EXISTS `avioes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `descricao` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `companhias_areas_id` int(11) NOT NULL,
  `numero_assentos` int(11) NOT NULL,
  `valor_aviao` decimal(12,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_avioes_companhiasAereas1_idx` (`companhias_areas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `taxa` decimal(2,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `categorias_avioes`
--

CREATE TABLE IF NOT EXISTS `categorias_avioes` (
  `categorias_id` int(11) NOT NULL,
  `avioes_id` int(11) NOT NULL,
  `numeros_poltronas` int(11) NOT NULL,
  PRIMARY KEY (`categorias_id`,`avioes_id`),
  KEY `fk_categoriasAcentos_has_avioes_avioes1_idx` (`avioes_id`),
  KEY `fk_categoriasAcentos_has_avioes_categoriasAcentos1_idx` (`categorias_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `idade` int(11) DEFAULT NULL,
  `sexo` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usuario` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `senha` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente_passagens`
--

CREATE TABLE IF NOT EXISTS `cliente_passagens` (
  `cliente_id` int(11) NOT NULL,
  `passagens_id` int(11) NOT NULL,
  PRIMARY KEY (`cliente_id`,`passagens_id`),
  KEY `fk_cliente_has_passagens_passagens1_idx` (`passagens_id`),
  KEY `fk_cliente_has_passagens_cliente1_idx` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `companhias_aereas`
--

CREATE TABLE IF NOT EXISTS `companhias_aereas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `passagens`
--

CREATE TABLE IF NOT EXISTS `passagens` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voo_id` int(11) NOT NULL,
  `validade` date NOT NULL,
  `categorias_id` int(11) NOT NULL,
  `valor` decimal(12,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_passagens_voo1_idx` (`voo_id`),
  KEY `fk_passagens_categorias1_idx` (`categorias_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `voo`
--

CREATE TABLE IF NOT EXISTS `voo` (
  `voo_id` int(11) NOT NULL AUTO_INCREMENT,
  `horario_partida` datetime DEFAULT NULL,
  `horario_chegada` datetime DEFAULT NULL,
  `partida_id` int(11) NOT NULL,
  `chegada_id` int(11) NOT NULL,
  `avioes_id` int(11) NOT NULL,
  `data_voo` date NOT NULL,
  `valor_voo` decimal(12,2) NOT NULL,
  `ofertas` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`voo_id`),
  KEY `fk_voo_avioes1_idx` (`avioes_id`),
  KEY `fk_voo_aeroportos1_idx` (`partida_id`),
  KEY `fk_voo_aeroportos2_idx` (`chegada_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `avioes`
--
ALTER TABLE `avioes`
  ADD CONSTRAINT `fk_avioes_companhiasAereas1` FOREIGN KEY (`companhias_areas_id`) REFERENCES `companhias_aereas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `categorias_avioes`
--
ALTER TABLE `categorias_avioes`
  ADD CONSTRAINT `fk_categoriasAcentos_has_avioes_avioes1` FOREIGN KEY (`avioes_id`) REFERENCES `avioes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_categoriasAcentos_has_avioes_categoriasAcentos1` FOREIGN KEY (`categorias_id`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `cliente_passagens`
--
ALTER TABLE `cliente_passagens`
  ADD CONSTRAINT `fk_cliente_has_passagens_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_has_passagens_passagens1` FOREIGN KEY (`passagens_id`) REFERENCES `passagens` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `passagens`
--
ALTER TABLE `passagens`
  ADD CONSTRAINT `fk_passagens_categorias1` FOREIGN KEY (`categorias_id`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_passagens_voo1` FOREIGN KEY (`voo_id`) REFERENCES `voo` (`voo_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `voo`
--
ALTER TABLE `voo`
  ADD CONSTRAINT `fk_voo_aeroportos1` FOREIGN KEY (`partida_id`) REFERENCES `aeroportos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_voo_aeroportos2` FOREIGN KEY (`chegada_id`) REFERENCES `aeroportos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_voo_avioes1` FOREIGN KEY (`avioes_id`) REFERENCES `avioes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
