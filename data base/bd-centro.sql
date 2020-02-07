CREATE DATABASE  IF NOT EXISTS `bd_centro` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_centro`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_centro
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cat_categorialivro`
--

DROP TABLE IF EXISTS `cat_categorialivro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cat_categorialivro` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cat_familia` varchar(100) NOT NULL,
  `cat_cdd` int(11) NOT NULL,
  `cat_tipo` enum('Infantil','Não infantil') DEFAULT NULL,
  `cat_data_registo` datetime NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_categorialivro`
--

LOCK TABLES `cat_categorialivro` WRITE;
/*!40000 ALTER TABLE `cat_categorialivro` DISABLE KEYS */;
INSERT INTO `cat_categorialivro` VALUES (1,'Filosofia',100,NULL,'2019-12-16 14:21:40'),(2,'Linguas',400,NULL,'2019-12-16 14:22:00'),(3,'Ciências Sociais',300,NULL,'2019-12-16 14:22:46'),(4,'Artes',700,NULL,'2019-12-16 14:22:56'),(5,'Literatura',800,NULL,'2019-12-16 14:23:09'),(6,'Lógica',160,NULL,'2019-12-16 14:23:40'),(7,'Religião',200,NULL,'2019-12-16 14:23:56'),(8,'Literatura Moçambicana',457,NULL,'2019-12-16 14:24:10'),(9,'Infantil',430,NULL,'2019-12-16 14:28:21'),(10,'Portugues',332,NULL,'2019-12-17 09:21:48');
/*!40000 ALTER TABLE `cat_categorialivro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cur_curso`
--

DROP TABLE IF EXISTS `cur_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cur_curso` (
  `cur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cur_nome` varchar(50) NOT NULL DEFAULT ' ',
  `cur_duracao` varchar(100) NOT NULL DEFAULT ' ',
  `cur_preco` decimal(7,2) DEFAULT '0.00',
  `cur_numeroaprovacoes` bigint(20) DEFAULT '0',
  `cur_numeroreprovacoes` bigint(20) DEFAULT '0',
  `cur_numerodesistencias` bigint(20) DEFAULT '0',
  `cur_data_registo` datetime NOT NULL,
  PRIMARY KEY (`cur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cur_curso`
--

LOCK TABLES `cur_curso` WRITE;
/*!40000 ALTER TABLE `cur_curso` DISABLE KEYS */;
INSERT INTO `cur_curso` VALUES (2,'Culinária Doces','1 mês',200.00,1,0,0,'2019-12-16 14:13:02'),(3,'Informatica Básica','1/2 Mês',200.00,2,0,0,'2019-12-16 14:13:40'),(4,'Informatica Avançada','1/2 Mês',300.00,1,0,0,'2019-12-16 14:13:00'),(5,'Guitarra','2 mês',200.00,0,1,1,'2019-12-16 14:14:17'),(6,'Guitarra II','3 mês',250.00,0,0,0,'2019-12-16 14:14:31'),(7,'Culinária Assados','3 semanas',200.00,1,1,0,'2019-12-16 14:19:07'),(8,'Programação web','1 mês',200.00,0,0,1,'2019-12-17 09:38:21');
/*!40000 ALTER TABLE `cur_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dev_devolucao`
--

DROP TABLE IF EXISTS `dev_devolucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dev_devolucao` (
  `dev_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dev_utenteId` bigint(20) NOT NULL,
  `dev_livroId` bigint(20) NOT NULL,
  `dev_data_registo` datetime NOT NULL,
  PRIMARY KEY (`dev_id`),
  KEY `dev_devolucao_ibfk_1` (`dev_utenteId`),
  KEY `dev_devolucao_ibfk_2` (`dev_livroId`),
  CONSTRAINT `dev_devolucao_ibfk_1` FOREIGN KEY (`dev_utenteId`) REFERENCES `ute_utente` (`ute_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_devolucao_ibfk_2` FOREIGN KEY (`dev_livroId`) REFERENCES `liv_livro` (`liv_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dev_devolucao`
--

LOCK TABLES `dev_devolucao` WRITE;
/*!40000 ALTER TABLE `dev_devolucao` DISABLE KEYS */;
INSERT INTO `dev_devolucao` VALUES (1,1,2,'2019-12-16 16:18:41'),(2,1,1,'2019-12-16 16:18:44'),(3,1,1,'2019-12-17 09:13:41');
/*!40000 ALTER TABLE `dev_devolucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dev_devolucaoinfantil`
--

DROP TABLE IF EXISTS `dev_devolucaoinfantil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dev_devolucaoinfantil` (
  `dev_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dev_utenteId` bigint(20) DEFAULT NULL,
  `dev_livroId` bigint(20) DEFAULT NULL,
  `dev_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`dev_id`),
  KEY `dev_devolucaoinfantil_ibfk_1` (`dev_utenteId`),
  KEY `dev_devolucaoinfantil_ibfk_2` (`dev_livroId`),
  CONSTRAINT `dev_devolucaoinfantil_ibfk_1` FOREIGN KEY (`dev_utenteId`) REFERENCES `utm_utentemenor` (`utm_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dev_devolucaoinfantil_ibfk_2` FOREIGN KEY (`dev_livroId`) REFERENCES `lin_livroinfantil` (`lin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dev_devolucaoinfantil`
--

LOCK TABLES `dev_devolucaoinfantil` WRITE;
/*!40000 ALTER TABLE `dev_devolucaoinfantil` DISABLE KEYS */;
INSERT INTO `dev_devolucaoinfantil` VALUES (1,1,2,'2019-12-16 16:19:55'),(2,2,3,'2019-12-16 16:19:57'),(3,1,1,'2019-12-16 16:19:59'),(4,3,1,'2019-12-17 09:32:28');
/*!40000 ALTER TABLE `dev_devolucaoinfantil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_emprestimo`
--

DROP TABLE IF EXISTS `emp_emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `emp_emprestimo` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_utenteId` bigint(20) NOT NULL,
  `emp_livroId` bigint(20) NOT NULL,
  `emp_data_registo` datetime NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `emp_emprestimo_ibfk_2` (`emp_livroId`),
  KEY `emp_emprestimo_ibfk_1` (`emp_utenteId`),
  CONSTRAINT `emp_emprestimo_ibfk_1` FOREIGN KEY (`emp_utenteId`) REFERENCES `ute_utente` (`ute_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `emp_emprestimo_ibfk_2` FOREIGN KEY (`emp_livroId`) REFERENCES `liv_livro` (`liv_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_emprestimo`
--

LOCK TABLES `emp_emprestimo` WRITE;
/*!40000 ALTER TABLE `emp_emprestimo` DISABLE KEYS */;
INSERT INTO `emp_emprestimo` VALUES (4,1,1,'2019-12-17 09:25:03');
/*!40000 ALTER TABLE `emp_emprestimo` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_utente_emprestimos` AFTER INSERT ON `emp_emprestimo` FOR EACH ROW update ute_utente set ute_numeroEmps = ute_numeroemps + 1 where ute_id = new.emp_utenteid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_livro_emprestimos` AFTER INSERT ON `emp_emprestimo` FOR EACH ROW update liv_livro set liv_numeropedidos=liv_numeropedidos + 1 where liv_id = new.emp_livroid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `emp_emprestimo_BEFORE_DELETE` AFTER DELETE ON `emp_emprestimo` FOR EACH ROW BEGIN
insert into dev_devolucao values(default, old.emp_utenteid, old.emp_livroid, now());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `emp_emprestimoinfantil`
--

DROP TABLE IF EXISTS `emp_emprestimoinfantil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `emp_emprestimoinfantil` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_utenteId` bigint(20) NOT NULL,
  `emp_livroId` bigint(20) NOT NULL,
  `emp_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `emp_utenteId` (`emp_utenteId`),
  KEY `emp_livroId` (`emp_livroId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_emprestimoinfantil`
--

LOCK TABLES `emp_emprestimoinfantil` WRITE;
/*!40000 ALTER TABLE `emp_emprestimoinfantil` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_emprestimoinfantil` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_livroInfantil_emprestimos` AFTER INSERT ON `emp_emprestimoinfantil` FOR EACH ROW update lin_livroinfantil set lin_numeropedidos=lin_numeropedidos + 1 where lin_id = new.emp_livroid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_utenteMenor_emprestimos` AFTER INSERT ON `emp_emprestimoinfantil` FOR EACH ROW update utm_utentemenor set utm_numeroemps=utm_numeroemps+1 where utm_id=new.emp_utenteid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `emp_emprestimoinfantil_AFTER_DELETE` AFTER DELETE ON `emp_emprestimoinfantil` FOR EACH ROW BEGIN
insert into dev_devolucaoinfantil values(default, old.emp_utenteid, old.emp_livroid, now());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `for_formador`
--

DROP TABLE IF EXISTS `for_formador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `for_formador` (
  `for_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `for_nome` varchar(100) NOT NULL,
  `for_data_nascimento` date NOT NULL,
  `for_genero` enum('M','F') NOT NULL,
  `for_contacto` varchar(9) NOT NULL,
  `for_competencias` longtext NOT NULL,
  `for_email` varchar(255) DEFAULT ' ',
  `for_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`for_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `for_formador`
--

LOCK TABLES `for_formador` WRITE;
/*!40000 ALTER TABLE `for_formador` DISABLE KEYS */;
INSERT INTO `for_formador` VALUES (1,'Joaquim Cesário','1981-02-23','M','873384734','Teste','ayrton_pereira1996@hotmail.com','2019-12-16 16:29:35'),(2,'Marta Mancange','1975-07-08','F','873384666','Comunicativa\r\nAssidua\r\n...','teste@teste.com','2019-12-16 21:05:00'),(3,'Fernando Rodrigues','1960-09-07','M','876565373','Teste','teste@teste.com','2019-12-17 00:44:09'),(4,'André Rodrigues','1980-10-07','M','856565373','Teste','teste@teste.com','2019-12-17 00:44:10'),(5,'Marta Frederico Renato','1975-09-07','F','826565373','Teste','teste@teste.com','2019-12-17 00:44:10'),(6,'Morais Pestana','1990-10-07','M','826565373','Teste','teste@teste.com','2019-12-17 00:44:11'),(7,'Fernanda Silva','1960-09-07','F','825565373','Teste','teste@teste.com','2019-12-17 00:46:31'),(8,'Furuma Rodrigues','1990-12-07','M','855565373','Teste','teste@teste.com','2019-12-17 00:46:31'),(9,'Xuruma Macane','1999-09-07','M','875565373','Teste','teste@teste.com','2019-12-17 00:46:32'),(10,'Carlitos Pestana','1995-10-07','M','844565373','Teste','teste@teste.com','2019-12-17 00:46:32'),(11,'Rui Simao','2006-02-07','M','855384738','','teste@teste.com','2019-12-17 09:42:40');
/*!40000 ALTER TABLE `for_formador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formador_leciona_curso`
--

DROP TABLE IF EXISTS `formador_leciona_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `formador_leciona_curso` (
  `flc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flc_formadorid` bigint(20) DEFAULT NULL,
  `flc_cursoid` bigint(20) DEFAULT NULL,
  `flc_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`flc_id`),
  KEY `formador_leciona_curso_ibfk_1` (`flc_formadorid`),
  KEY `formador_leciona_curso_ibfk_2` (`flc_cursoid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formador_leciona_curso`
--

LOCK TABLES `formador_leciona_curso` WRITE;
/*!40000 ALTER TABLE `formador_leciona_curso` DISABLE KEYS */;
INSERT INTO `formador_leciona_curso` VALUES (1,1,4,'2019-12-16 16:30:00'),(2,2,7,'2019-12-16 21:09:00'),(3,2,7,'2019-12-16 21:10:00'),(4,9,6,'2019-12-17 09:43:30');
/*!40000 ALTER TABLE `formador_leciona_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gen_genero`
--

DROP TABLE IF EXISTS `gen_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gen_genero` (
  `gen_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gen_tipo` enum('M','F') DEFAULT NULL,
  PRIMARY KEY (`gen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gen_genero`
--

LOCK TABLES `gen_genero` WRITE;
/*!40000 ALTER TABLE `gen_genero` DISABLE KEYS */;
INSERT INTO `gen_genero` VALUES (1,'M'),(2,'F');
/*!40000 ALTER TABLE `gen_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ins_instituicaoensino`
--

DROP TABLE IF EXISTS `ins_instituicaoensino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ins_instituicaoensino` (
  `ins_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ins_nome` varchar(45) DEFAULT NULL,
  `ins_numero_estudantes` int(11) DEFAULT '0',
  `ins_tipo` enum('Infantil','Não infantil') DEFAULT NULL,
  `ins_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`ins_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ins_instituicaoensino`
--

LOCK TABLES `ins_instituicaoensino` WRITE;
/*!40000 ALTER TABLE `ins_instituicaoensino` DISABLE KEYS */;
INSERT INTO `ins_instituicaoensino` VALUES (1,'Universidade Católica de Moçambique',3,'Não infantil','2019-12-16 13:30:11'),(2,'Universidade Eduardo Modlane',2,'Não infantil','2019-12-16 13:30:20'),(3,'Universidade UniLicungo',7,'Não infantil','2019-12-16 13:30:00'),(4,'Escola Secundária 25 de Setembro',0,'Não infantil','2019-12-16 13:30:00'),(5,'Escola Secundária Patrice Lumumba',0,'Não infantil','2019-12-16 13:30:59'),(6,'Escola São Carlos Lwanga',1,'Não infantil','2019-12-16 13:31:16'),(7,'Escola Primária de Quelimane',1,'Infantil','2019-12-16 14:44:14'),(8,'Escola primária do Sinacura',2,'Infantil','2019-12-16 14:44:28'),(9,'Escola Primária do Cualane',3,'Infantil','2019-12-16 14:44:42'),(10,'Escola Secundaria Santagua',0,'Não infantil','2019-12-17 09:31:45'),(11,'Escola primaria da sagrada',1,'Infantil','2019-12-17 09:35:26');
/*!40000 ALTER TABLE `ins_instituicaoensino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lin_livroinfantil`
--

DROP TABLE IF EXISTS `lin_livroinfantil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lin_livroinfantil` (
  `lin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lin_titulo` varchar(100) NOT NULL,
  `lin_autor` varchar(255) NOT NULL,
  `lin_anoedicao` varchar(4) DEFAULT NULL,
  `lin_edicao` varchar(10) DEFAULT NULL,
  `lin_editora` varchar(50) DEFAULT NULL,
  `lin_isbn` varchar(20) DEFAULT NULL,
  `lin_numeropedidos` bigint(20) DEFAULT '0',
  `lin_categoriaid` bigint(20) DEFAULT NULL,
  `lin_data_registo` datetime NOT NULL,
  PRIMARY KEY (`lin_id`),
  KEY `lin_livroinfantil_ibfk_2` (`lin_categoriaid`),
  CONSTRAINT `lin_livroinfantil_ibfk_1` FOREIGN KEY (`lin_categoriaid`) REFERENCES `cat_categorialivro` (`cat_id`),
  CONSTRAINT `lin_livroinfantil_ibfk_2` FOREIGN KEY (`lin_categoriaid`) REFERENCES `cat_categorialivro` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lin_livroinfantil`
--

LOCK TABLES `lin_livroinfantil` WRITE;
/*!40000 ALTER TABLE `lin_livroinfantil` DISABLE KEYS */;
INSERT INTO `lin_livroinfantil` VALUES (1,'Contos da anita','Joao Ernesto','2019','1','Moza Editora','328-427-403-3',2,9,'2019-12-16 16:15:23'),(2,'A branca de neve','Mia Couto','2009','1','Moza Editora','239-820-474-2',1,9,'2019-12-16 16:15:43'),(3,'Tarzan','Joao Ernesto, João Silva','2009','1','Moza Editora','039-807-483-2',1,9,'2019-12-16 16:16:01');
/*!40000 ALTER TABLE `lin_livroinfantil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liv_livro`
--

DROP TABLE IF EXISTS `liv_livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `liv_livro` (
  `liv_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `liv_titulo` varchar(100) NOT NULL,
  `liv_autor` varchar(255) NOT NULL,
  `liv_anoedicao` varchar(4) DEFAULT NULL,
  `liv_edicao` varchar(10) DEFAULT NULL,
  `liv_editora` varchar(50) DEFAULT NULL,
  `liv_isbn` varchar(20) DEFAULT NULL,
  `liv_numeropedidos` bigint(20) NOT NULL DEFAULT '0',
  `liv_categoriaid` bigint(20) NOT NULL,
  `liv_data_registo` datetime NOT NULL,
  PRIMARY KEY (`liv_id`),
  KEY `liv_livro_ibfk_1` (`liv_categoriaid`),
  CONSTRAINT `liv_livro_ibfk_1` FOREIGN KEY (`liv_categoriaid`) REFERENCES `cat_categorialivro` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liv_livro`
--

LOCK TABLES `liv_livro` WRITE;
/*!40000 ALTER TABLE `liv_livro` DISABLE KEYS */;
INSERT INTO `liv_livro` VALUES (1,'O voo da ave','Mia Couto','2008','1','Moza Editora','238-974-982-7',3,8,'2019-12-16 14:25:00'),(2,'O nascer do amanha','Joao Ernesto, João Silva','2','4','Moza Editora','509-349-499-9',1,3,'2019-12-16 14:25:44'),(3,'Mentes obscuras','Marta Alegria','2008','1','Porto Editora','234-252-342-3',0,5,'2019-12-16 14:26:08'),(4,'Mentes obscuras II','Marta Alegria','2009','5','Moza Editora','123-123-132-1',0,5,'2019-12-16 14:26:30'),(5,'A lingua Portuguesa','Henrique Faria, César Francisco','2000','4','Moza Editora','221-313-123-1',0,2,'2019-12-16 14:27:34'),(6,'Pensamento Filosofico','Joao Ernesto','2000','1','Moza Editora','333-333-333-3',0,1,'2019-12-17 09:20:15');
/*!40000 ALTER TABLE `liv_livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `per_perfil`
--

DROP TABLE IF EXISTS `per_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `per_perfil` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_descricao` varchar(30) NOT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `per_perfil`
--

LOCK TABLES `per_perfil` WRITE;
/*!40000 ALTER TABLE `per_perfil` DISABLE KEYS */;
INSERT INTO `per_perfil` VALUES (1,'GESTOR'),(2,'COORDENADOR'),(3,'BIBLIOTECARIO'),(4,'BIBLIOTECARIOINFANTIL');
/*!40000 ALTER TABLE `per_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usu_usuario`
--

DROP TABLE IF EXISTS `usu_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usu_usuario` (
  `usu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usu_idPerfil` int(11) DEFAULT NULL,
  `usu_nomeUsuario` varchar(255) DEFAULT NULL,
  `usu_senha` varchar(255) DEFAULT NULL,
  `usu_dataRegisto` datetime DEFAULT NULL,
  PRIMARY KEY (`usu_id`),
  KEY `usu_idPerfil` (`usu_idPerfil`),
  CONSTRAINT `usu_usuario_ibfk_1` FOREIGN KEY (`usu_idPerfil`) REFERENCES `per_perfil` (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usu_usuario`
--

LOCK TABLES `usu_usuario` WRITE;
/*!40000 ALTER TABLE `usu_usuario` DISABLE KEYS */;
INSERT INTO `usu_usuario` VALUES (1,1,'userGestor','$2a$10$60leL41/wtgSKVE9CQzdHO/8m5T5qNNBP4HoE4vSFNC6dstL4xeJy','2019-11-17 13:40:00'),(2,2,'userCoordenador','$2a$10$uNfiV0qX.WxGvPrdFPzsr.JVK5P3CDk4byrcpZtCASNC9gtqbXJ7m','2019-11-20 09:31:09'),(3,3,'userBibliotecario_normal','$2a$10$SyZB9SQ8OOyz3Ji92v1D6.5AOh2RixIjfnR/Qq/PhNsHdELxp3Ova','2019-11-20 09:36:09'),(8,4,'userbibliotecario_infantil','$2a$10$Xz1ehVRyplEZaRzwIzvL6e09j8vyQJDPeFp0OoO7UltPvkwucjvKm','2019-12-03 18:31:03'),(11,2,'admin','$2a$10$dCX0OSPiwqfmgCpnMQ3PqOw8bVH2.d7dAbOqLPiooOZp5/sQNlgwy','2019-12-17 09:44:06');
/*!40000 ALTER TABLE `usu_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uta_utentesaprovados`
--

DROP TABLE IF EXISTS `uta_utentesaprovados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `uta_utentesaprovados` (
  `uta_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uta_estudanteId` bigint(20) DEFAULT NULL,
  `uta_utenteId` bigint(20) DEFAULT NULL,
  `uta_cursoId` bigint(20) DEFAULT NULL,
  `uta_notafinal` decimal(4,2) DEFAULT NULL,
  `uta_comentario` longtext,
  `uta_data_registo` datetime NOT NULL,
  PRIMARY KEY (`uta_id`),
  KEY `uta_utentesaprovados_ibfk_2` (`uta_utenteId`),
  KEY `uta_utentesaprovados_ibfk_3` (`uta_cursoId`),
  KEY `uta_utentesaprovados_ibfk_4` (`uta_estudanteId`),
  CONSTRAINT `uta_utentesaprovados_ibfk_1` FOREIGN KEY (`uta_utenteId`) REFERENCES `ute_utente` (`ute_id`),
  CONSTRAINT `uta_utentesaprovados_ibfk_2` FOREIGN KEY (`uta_utenteId`) REFERENCES `ute_utente` (`ute_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uta_utentesaprovados_ibfk_3` FOREIGN KEY (`uta_cursoId`) REFERENCES `cur_curso` (`cur_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uta_utentesaprovados_ibfk_4` FOREIGN KEY (`uta_estudanteId`) REFERENCES `utente_frequenta_curso` (`ufc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uta_utentesaprovados`
--

LOCK TABLES `uta_utentesaprovados` WRITE;
/*!40000 ALTER TABLE `uta_utentesaprovados` DISABLE KEYS */;
INSERT INTO `uta_utentesaprovados` VALUES (1,NULL,1,2,20.00,'','2019-12-16 16:22:26'),(2,NULL,2,3,14.00,'','2019-12-16 16:25:39'),(3,NULL,1,7,19.00,'','2019-12-16 20:02:40'),(4,NULL,4,4,11.00,'','2019-12-16 21:04:55'),(5,NULL,3,3,18.00,'','2019-12-17 09:40:48');
/*!40000 ALTER TABLE `uta_utentesaprovados` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_aprovacao` AFTER INSERT ON `uta_utentesaprovados` FOR EACH ROW delete from utente_frequenta_curso where new.uta_cursoid = ufc_cursoid and new.uta_utenteid = ufc_utenteid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `aumento_aprovacoes` AFTER INSERT ON `uta_utentesaprovados` FOR EACH ROW update cur_curso set cur_numeroaprovacoes=cur_numeroaprovacoes+1 where new.uta_cursoid=cur_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `utd_utentesdesistiram`
--

DROP TABLE IF EXISTS `utd_utentesdesistiram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utd_utentesdesistiram` (
  `utd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `utd_utenteId` bigint(20) DEFAULT NULL,
  `utd_cursoId` bigint(20) DEFAULT NULL,
  `utd_comentario` longtext,
  `utd_data_registo` datetime NOT NULL,
  PRIMARY KEY (`utd_id`),
  KEY `utd_utentesdesistiram_ibfk_1` (`utd_utenteId`),
  KEY `utd_utentesdesistiram_ibfk_2` (`utd_cursoId`),
  CONSTRAINT `utd_utentesdesistiram_ibfk_1` FOREIGN KEY (`utd_utenteId`) REFERENCES `ute_utente` (`ute_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utd_utentesdesistiram_ibfk_2` FOREIGN KEY (`utd_cursoId`) REFERENCES `cur_curso` (`cur_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utd_utentesdesistiram`
--

LOCK TABLES `utd_utentesdesistiram` WRITE;
/*!40000 ALTER TABLE `utd_utentesdesistiram` DISABLE KEYS */;
INSERT INTO `utd_utentesdesistiram` VALUES (1,2,5,'','2019-12-16 16:21:00'),(2,1,8,'','2019-12-17 09:40:00');
/*!40000 ALTER TABLE `utd_utentesdesistiram` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_desistencia` AFTER INSERT ON `utd_utentesdesistiram` FOR EACH ROW delete from utente_frequenta_curso where new.utd_cursoid = ufc_cursoid and new.utd_utenteid=ufc_utenteid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `aumento_desistencias` AFTER INSERT ON `utd_utentesdesistiram` FOR EACH ROW update cur_curso set cur_numerodesistencias=cur_numerodesistencias+1 where new.utd_cursoid=cur_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ute_endereco`
--

DROP TABLE IF EXISTS `ute_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ute_endereco` (
  `ute_enderecoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `ute_cidade` varchar(50) DEFAULT ' ',
  `ute_bairro` varchar(50) DEFAULT ' ',
  `ute_quarteirao` varchar(50) DEFAULT ' ',
  PRIMARY KEY (`ute_enderecoId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ute_endereco`
--

LOCK TABLES `ute_endereco` WRITE;
/*!40000 ALTER TABLE `ute_endereco` DISABLE KEYS */;
INSERT INTO `ute_endereco` VALUES (1,'Quelimane','Liberdade','A'),(2,'Quelimane','Benfica','A'),(3,'Queliamane','Liberdade','B'),(4,'Quelimane','Benfica','A'),(5,'Quelimane','Samugue','B'),(6,'Quelimane','Benfica','A'),(7,'Quelimane','Benfica','A'),(8,'Quelimane','Benfica','A'),(9,'Quelimane','Benfica','A'),(10,'Quelimane','Benfica','A'),(11,'Quelimane','Benfica','A'),(12,'Quelimane','Samugue','B'),(13,'Quelimane','Benfica','A'),(14,'Quelimane','Benfica','A'),(15,'Quelimane','Benfica','A'),(16,'Quelimane','Samugue','A'),(17,'Quelimane','Benfica','A'),(18,'Quelimane','Liberdade','A'),(19,'Quelimane','Liberdade','A'),(20,'Quelimane','Benfica','A'),(21,'Quelimane','Liberdade','A');
/*!40000 ALTER TABLE `ute_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ute_utente`
--

DROP TABLE IF EXISTS `ute_utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ute_utente` (
  `ute_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ute_nome` varchar(100) DEFAULT NULL,
  `ute_datanascimento` date DEFAULT NULL,
  `ute_genero` enum('M','F') DEFAULT NULL,
  `ute_naturalidade` varchar(50) DEFAULT NULL,
  `ute_bi` varchar(13) DEFAULT NULL,
  `ute_nomepai` varchar(100) DEFAULT '  ',
  `ute_nomemae` varchar(100) DEFAULT '  ',
  `ute_localtrabalho` varchar(50) DEFAULT '  ',
  `ute_contacto` varchar(9) DEFAULT ' ',
  `ute_estado` enum('Não permitido','Permitido') DEFAULT 'Permitido',
  `ute_numeroemps` bigint(20) DEFAULT '0',
  `ute_data_registo` datetime DEFAULT NULL,
  `ute_instituicaoid` bigint(20) DEFAULT NULL,
  `ute_enderecoid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ute_id`),
  KEY `ute_utente_ibfk_1` (`ute_instituicaoid`),
  KEY `ute_utente_ibfk_2` (`ute_enderecoid`),
  CONSTRAINT `ute_utente_ibfk_1` FOREIGN KEY (`ute_instituicaoid`) REFERENCES `ins_instituicaoensino` (`ins_id`),
  CONSTRAINT `ute_utente_ibfk_2` FOREIGN KEY (`ute_enderecoid`) REFERENCES `ute_endereco` (`ute_enderecoid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ute_utente`
--

LOCK TABLES `ute_utente` WRITE;
/*!40000 ALTER TABLE `ute_utente` DISABLE KEYS */;
INSERT INTO `ute_utente` VALUES (1,'Maria Lurdes Ernesto','1955-01-12','F','Quelimane','324283748927Y','Ernesto Jaime','Lurdes Jaime','IMEP','873384738','Não permitido',4,'2019-12-16 13:37:00',1,19),(2,'Joaquim Chiz Ferreira','1989-03-02','M','Milange','237737797777Q','Manuel Chiz Ferreira','Zambia Chiz Ferreira','FGH','823384738','Não permitido',0,'2019-12-16 13:41:00',3,20),(3,'Fernando Chiz Ferreira','1973-01-30','M','Quelimane','237737777777S','Daniel','Rosa Divina Chiz Ferreira','','834384738','Não permitido',0,'2019-12-16 13:47:10',6,3),(4,'Matilde Esmeralda Bento','1989-02-22','F','Mocuba','234737777777S','Ruben Bento','Esmeralda Bento','Municipio','874746646','Não permitido',0,'2019-12-16 13:53:00',2,15),(5,'Ruben Freitas','1999-03-11','M','Mocuba','237737777777T','Cesario Freitas','Matilde Freitas','Municipio','873384444','Não permitido',0,'2019-12-16 13:56:00',1,12),(6,'Francisco Salomão','1994-01-05','M','Maputo','237737777777R','Eduardo Salomao','Renata Salomão','','823384738','Não permitido',0,'2019-12-16 13:59:23',2,6),(7,'Renato Silva','1994-05-16','M','Quelimane','237737777777R','Silva Matos','Raquel Silva','','823384738','Não permitido',0,'2019-12-16 14:07:47',3,7),(8,'Justino João Elias','1994-06-14','M','Lichinga','237737777777R','João Renato','Renata Jaime','Municipio','822384738','Não permitido',0,'2019-12-16 14:59:53',1,8),(9,'Bernardo Jaime Lopes','1979-06-20','M','Quelimane','237737777777C','Jaime Lopes','Joaquina','Municipio','854384738','Não permitido',0,'2019-12-16 15:27:26',3,9),(10,'Joana Francisca','1992-02-05','F','Maputo','237737777777L','Joao Ferreira','Francisca Ferreira','','873839393','Não permitido',0,'2019-12-16 15:45:00',3,14),(11,'Bernadine Lopes Santiago','1994-10-18','F','Milange','237737777777R','Santiago Jaime','Renata Lopes','','873384734','Não permitido',0,'2019-12-16 15:50:30',3,11),(12,'Sebastião Ernesto José','1980-01-01','M','Maputo','237737777777Q','Sebastião José','Sebastiana André','Municipio','845555555','Não permitido',0,'2019-12-16 20:59:42',3,16),(13,'Matilde Silva','1997-02-12','F','Mocuba','237737733777F','Silva Matos','Maria Silva','Municipio','874233333','Permitido',0,'2019-12-17 09:29:57',3,21);
/*!40000 ALTER TABLE `ute_utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `acrescimo_numero_estudante` AFTER INSERT ON `ute_utente` FOR EACH ROW update ins_instituicaoensino set ins_numero_estudantes = ins_numero_estudantes + 1 where new.ute_instituicaoid=ins_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `utente_frequenta_curso`
--

DROP TABLE IF EXISTS `utente_frequenta_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente_frequenta_curso` (
  `ufc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ufc_utenteId` bigint(20) DEFAULT NULL,
  `ufc_cursoId` bigint(20) DEFAULT NULL,
  `ufc_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`ufc_id`),
  KEY `utente_frequenta_curso_ibfk_1` (`ufc_utenteId`),
  KEY `utente_frequenta_curso_ibfk_2` (`ufc_cursoId`),
  CONSTRAINT `utente_frequenta_curso_ibfk_1` FOREIGN KEY (`ufc_utenteId`) REFERENCES `ute_utente` (`ute_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utente_frequenta_curso_ibfk_2` FOREIGN KEY (`ufc_cursoId`) REFERENCES `cur_curso` (`cur_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente_frequenta_curso`
--

LOCK TABLES `utente_frequenta_curso` WRITE;
/*!40000 ALTER TABLE `utente_frequenta_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_frequenta_curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_confirmacao` AFTER INSERT ON `utente_frequenta_curso` FOR EACH ROW delete from utente_pre_registo_curso where new.ufc_utenteid = upr_utenteid and new.ufc_cursoid = upr_cursoid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `utente_pre_registo_curso`
--

DROP TABLE IF EXISTS `utente_pre_registo_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente_pre_registo_curso` (
  `upr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `upr_utenteId` bigint(20) NOT NULL,
  `upr_cursoId` bigint(20) NOT NULL,
  `upr_data_registo` datetime NOT NULL,
  PRIMARY KEY (`upr_id`),
  KEY `upr_utenteId` (`upr_utenteId`),
  KEY `upr_cursoId` (`upr_cursoId`),
  CONSTRAINT `utente_pre_registo_curso_ibfk_1` FOREIGN KEY (`upr_utenteId`) REFERENCES `ute_utente` (`ute_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utente_pre_registo_curso_ibfk_2` FOREIGN KEY (`upr_cursoId`) REFERENCES `cur_curso` (`cur_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente_pre_registo_curso`
--

LOCK TABLES `utente_pre_registo_curso` WRITE;
/*!40000 ALTER TABLE `utente_pre_registo_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente_pre_registo_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utm_encarregadoeducacao`
--

DROP TABLE IF EXISTS `utm_encarregadoeducacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utm_encarregadoeducacao` (
  `utm_encarregadoid` bigint(20) NOT NULL AUTO_INCREMENT,
  `utm_nome_encarregado` varchar(100) DEFAULT ' ',
  `utm_parentesco` varchar(50) DEFAULT ' ',
  `utm_contacto` varchar(100) DEFAULT ' ',
  PRIMARY KEY (`utm_encarregadoid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utm_encarregadoeducacao`
--

LOCK TABLES `utm_encarregadoeducacao` WRITE;
/*!40000 ALTER TABLE `utm_encarregadoeducacao` DISABLE KEYS */;
INSERT INTO `utm_encarregadoeducacao` VALUES (1,'Jaime Silva','Pai','928374852'),(2,'Lurdes Conceição','Mãe','928374853'),(3,'Júlia Camuene','Mãe','928374856'),(4,'Joaquim Matos','Tio','928374854'),(5,'Eduardo','Pai',''),(6,'Eduardo','Pai',''),(7,'Marta','Mãe','823456789');
/*!40000 ALTER TABLE `utm_encarregadoeducacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utm_endereco`
--

DROP TABLE IF EXISTS `utm_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utm_endereco` (
  `utm_enderecoid` bigint(20) NOT NULL AUTO_INCREMENT,
  `utm_cidade` varchar(50) DEFAULT ' ',
  `utm_bairro` varchar(50) DEFAULT ' ',
  `utm_quarteirao` varchar(50) DEFAULT ' ',
  PRIMARY KEY (`utm_enderecoid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utm_endereco`
--

LOCK TABLES `utm_endereco` WRITE;
/*!40000 ALTER TABLE `utm_endereco` DISABLE KEYS */;
INSERT INTO `utm_endereco` VALUES (1,'Quelimane','Centro','A'),(2,'Quelimane','Samugue','B'),(3,'Quelimane','Samugue','A'),(4,'Quelimane','Liberdade','B'),(5,'Quelimane','Benfica','A'),(6,'Quelimane','Liberdade','A'),(7,'Quelimane','Benfica','A');
/*!40000 ALTER TABLE `utm_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utm_utentemenor`
--

DROP TABLE IF EXISTS `utm_utentemenor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utm_utentemenor` (
  `utm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `utm_nome` varchar(100) NOT NULL,
  `utm_datanascimento` date DEFAULT NULL,
  `utm_genero` enum('M','F') DEFAULT NULL,
  `utm_naturalidade` varchar(50) DEFAULT ' ',
  `utm_bi` varchar(13) DEFAULT ' ',
  `utm_nomepai` varchar(100) DEFAULT ' ',
  `utm_nomemae` varchar(100) DEFAULT ' ',
  `utm_turma` varchar(10) NOT NULL,
  `utm_classe` varchar(10) NOT NULL,
  `utm_numeroemps` bigint(20) DEFAULT '0',
  `utm_data_registo` datetime NOT NULL,
  `utm_encarregadoid` bigint(20) NOT NULL,
  `utm_enderecoid` bigint(20) NOT NULL,
  `utm_instituicaoid` bigint(20) NOT NULL,
  PRIMARY KEY (`utm_id`),
  KEY `utm_utentemenor_ibfk_1` (`utm_encarregadoid`),
  KEY `utm_utentemenor_ibfk_2` (`utm_enderecoid`),
  KEY `utm_utentemenor_ibfk_3` (`utm_instituicaoid`),
  CONSTRAINT `utm_utentemenor_ibfk_1` FOREIGN KEY (`utm_encarregadoid`) REFERENCES `utm_encarregadoeducacao` (`utm_encarregadoid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utm_utentemenor_ibfk_2` FOREIGN KEY (`utm_enderecoid`) REFERENCES `utm_endereco` (`utm_enderecoid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utm_utentemenor_ibfk_3` FOREIGN KEY (`utm_instituicaoid`) REFERENCES `ins_instituicaoensino` (`ins_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utm_utentemenor`
--

LOCK TABLES `utm_utentemenor` WRITE;
/*!40000 ALTER TABLE `utm_utentemenor` DISABLE KEYS */;
INSERT INTO `utm_utentemenor` VALUES (1,'Zeca Junior','2014-06-17','M','Mocuba','237737774333V','Jaime Silva','Renata Silva','A','2',2,'2019-12-16 15:58:21',1,1,7),(2,'Rosa Conceição','2014-02-15','F','Mocuba','','Renato Conceição','Lurdes Conceição','A','3',1,'2019-12-16 16:01:57',2,2,9),(3,'Zâmbia Camuene','2015-02-26','F','Milange','234243243536H','Serafim Camuene','Júlia Camuene','A','3',1,'2019-12-16 16:05:58',3,3,8),(4,'Fernandinho da Silva Pestana','2013-02-06','M','Maputo','','Andre Silva','Soraia Silva','A','4',0,'2019-12-16 16:14:00',4,4,8),(5,'Renato Junior','2016-07-17','M','Quelimane','','Eduardo','Eduarda','A','3',0,'2019-12-16 21:03:11',5,5,9),(6,'Bernardo Junior','2014-02-17','M','Mocuba','','Eduardo','Silva','A','4',0,'2019-12-16 21:16:14',6,6,9),(7,'Eduardo Coelho','2016-06-14','M','Quelimane','','Joao Ferreira','marta','A','3',0,'2019-12-17 09:36:55',7,7,11);
/*!40000 ALTER TABLE `utm_utentemenor` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `acrescimo_numero_utentemenor` AFTER INSERT ON `utm_utentemenor` FOR EACH ROW update ins_instituicaoensino set ins_numero_estudantes = ins_numero_estudantes + 1 where new.utm_instituicaoid = ins_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `utr_utentesreprovados`
--

DROP TABLE IF EXISTS `utr_utentesreprovados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utr_utentesreprovados` (
  `utr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `utr_estudanteId` bigint(20) DEFAULT NULL,
  `utr_utenteId` bigint(20) DEFAULT NULL,
  `utr_cursoId` bigint(20) DEFAULT NULL,
  `utr_notafinal` decimal(4,2) DEFAULT NULL,
  `utr_comentario` longtext,
  `utr_data_registo` datetime DEFAULT NULL,
  PRIMARY KEY (`utr_id`),
  KEY `utr_utenteId` (`utr_utenteId`),
  KEY `utr_utentesreprovados_ibfk_1` (`utr_estudanteId`),
  KEY `utr_cursoId` (`utr_cursoId`),
  CONSTRAINT `utr_utentesreprovados_ibfk_1` FOREIGN KEY (`utr_estudanteId`) REFERENCES `utente_frequenta_curso` (`ufc_id`),
  CONSTRAINT `utr_utentesreprovados_ibfk_2` FOREIGN KEY (`utr_utenteId`) REFERENCES `ute_utente` (`ute_id`),
  CONSTRAINT `utr_utentesreprovados_ibfk_3` FOREIGN KEY (`utr_cursoId`) REFERENCES `cur_curso` (`cur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utr_utentesreprovados`
--

LOCK TABLES `utr_utentesreprovados` WRITE;
/*!40000 ALTER TABLE `utr_utentesreprovados` DISABLE KEYS */;
INSERT INTO `utr_utentesreprovados` VALUES (1,NULL,1,5,7.00,'','2019-12-16 16:21:00'),(2,NULL,3,7,8.00,'','2019-12-16 21:04:00');
/*!40000 ALTER TABLE `utr_utentesreprovados` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_reprovacao` AFTER INSERT ON `utr_utentesreprovados` FOR EACH ROW delete from utente_frequenta_curso where new.utr_cursoid = ufc_cursoid and new.utr_utenteid=ufc_utenteid */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `aumento_reprovacoes` AFTER INSERT ON `utr_utentesreprovados` FOR EACH ROW update cur_curso set cur_numeroreprovacoes=cur_numeroreprovacoes+1 where new.utr_cursoid=cur_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-07 23:33:34
