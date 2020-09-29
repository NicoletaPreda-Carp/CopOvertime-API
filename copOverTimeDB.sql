-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: cop_overtime
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department_employees`
--

DROP TABLE IF EXISTS `department_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `department_id` int NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DEPARTMENT_EMPLOYEE_EMPLOYEES_idx` (`employee_id`),
  KEY `DEPARTMET_EMPLOYEE_DEPARTMENTS_idx` (`department_id`),
  CONSTRAINT `DEPARTMENT_EMPLOYEE_EMPLOYEES_FK` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `DEPARTMET_EMPLOYEE_DEPARTMENTS_FK` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_employees`
--

LOCK TABLES `department_employees` WRITE;
/*!40000 ALTER TABLE `department_employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_programs`
--

DROP TABLE IF EXISTS `department_programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_programs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `department_id` int NOT NULL,
  `program_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PROGRAM_PROGRAM_TYPES_FK_idx` (`program_type_id`),
  KEY `PROGRAM_DEPARTMENTS_FK_idx` (`department_id`),
  CONSTRAINT `DEPARTMENT_PROGRAM_DEPARTMENTS_FK` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `DEPARTMENT_PROGRAM_PROGRAM_TYPES_FK` FOREIGN KEY (`program_type_id`) REFERENCES `program_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_programs`
--

LOCK TABLES `department_programs` WRITE;
/*!40000 ALTER TABLE `department_programs` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_programs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'BITSLF'),(2,'BITSLF-Padoc'),(3,'Expertize'),(4,'Baze de Date'),(5,'IT'),(6,'Secretariat'),(7,'fghjk'),(8,'ae4562563');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_overtime_hours`
--

DROP TABLE IF EXISTS `employee_overtime_hours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_overtime_hours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `overtime_hour_id` int NOT NULL,
  `employee_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `EMPLPYEE_OT_HOURS_OVERTIME_HOUR_FK_idx` (`overtime_hour_id`),
  KEY `EMPLOYEE_OT_HOURS_EMPLOYEE_idx` (`employee_id`),
  CONSTRAINT `EMPLOYEE_OT_HOURS_EMPLOYEE` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `EMPLOYEE_OT_HOURS_OVERTIME_HOUR_FK` FOREIGN KEY (`overtime_hour_id`) REFERENCES `overtime_hours` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_overtime_hours`
--

LOCK TABLES `employee_overtime_hours` WRITE;
/*!40000 ALTER TABLE `employee_overtime_hours` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_overtime_hours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_ranks`
--

DROP TABLE IF EXISTS `employee_ranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_ranks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `rank_id` int NOT NULL,
  `started_at` date DEFAULT NULL,
  `ended_at` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EMPLOYEE_RANK_EMPLOYEES_FK_idx` (`employee_id`),
  KEY `EMPLOYEE_RANK_RANKS_FK_idx` (`rank_id`),
  CONSTRAINT `EMPLOYEE_RANK_EMPLOYEES_FK` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `EMPLOYEE_RANK_RANKS_FK` FOREIGN KEY (`rank_id`) REFERENCES `ranks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_ranks`
--

LOCK TABLES `employee_ranks` WRITE;
/*!40000 ALTER TABLE `employee_ranks` DISABLE KEYS */;
INSERT INTO `employee_ranks` VALUES (1,1,2,NULL,NULL),(2,3,5,NULL,NULL);
/*!40000 ALTER TABLE `employee_ranks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Vasiliu','Andrei'),(2,'Nicoara','Valentina'),(3,'Andrei','Ion');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legal_days_off`
--

DROP TABLE IF EXISTS `legal_days_off`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `legal_days_off` (
  `id` int NOT NULL AUTO_INCREMENT,
  `day_off` date NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legal_days_off`
--

LOCK TABLES `legal_days_off` WRITE;
/*!40000 ALTER TABLE `legal_days_off` DISABLE KEYS */;
INSERT INTO `legal_days_off` VALUES (0,'1970-01-01','N/A'),(1,'2020-01-01','Prima zi a Anului Nou'),(2,'2020-01-02','A doua zi a Anului Nou'),(3,'2020-01-24','Ziua Unirii Principatelor Române'),(4,'2020-04-17','Vinerea Mare'),(5,'2020-04-19','Prima zi de Paște ortodox'),(6,'2020-04-20','A doua zi de Paște ortodox'),(7,'2020-05-01','Ziua Muncii'),(8,'2020-06-01','Ziua Copilului'),(9,'2020-07-07','Prima zi de Rusalii'),(10,'2020-07-08','A doua zi de Rusalii'),(11,'2020-08-15','Adormirea Maicii Domnului'),(12,'2020-11-30','Sfântul Andrei'),(13,'2020-12-01','Ziua Națională a României'),(14,'2020-12-25','Prima zi de Crăciun'),(15,'2020-12-26','A doua zi de Crăciun');
/*!40000 ALTER TABLE `legal_days_off` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overtime_hours`
--

DROP TABLE IF EXISTS `overtime_hours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overtime_hours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `performed_at` date NOT NULL,
  `started_at` time NOT NULL,
  `ended_at` time NOT NULL,
  `number_of_hours` int DEFAULT NULL,
  `valid_number_of_days_id` int NOT NULL,
  `is_weekend` tinyint NOT NULL DEFAULT '0',
  `enabled` tinyint NOT NULL DEFAULT '0',
  `expires_at` date DEFAULT NULL,
  `legal_days_off_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LEGAL_DOFF_OVERTIMEHOURS_FK_idx` (`legal_days_off_id`),
  KEY `VNODPOTH_OVERTIMEHOURS_FK_idx` (`valid_number_of_days_id`),
  CONSTRAINT `LEGAL_DOFF_OVERTIMEHOURS_FK` FOREIGN KEY (`legal_days_off_id`) REFERENCES `legal_days_off` (`id`),
  CONSTRAINT `VNODPOTH_OVERTIMEHOURS_FK` FOREIGN KEY (`valid_number_of_days_id`) REFERENCES `valid_number_of_days_per_overtime_hours` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overtime_hours`
--

LOCK TABLES `overtime_hours` WRITE;
/*!40000 ALTER TABLE `overtime_hours` DISABLE KEYS */;
INSERT INTO `overtime_hours` VALUES (5,'2020-09-22','14:04:00','14:04:00',0,3,0,0,'2020-09-24',4),(7,'2020-12-15','16:06:00','18:59:00',2,1,1,1,'2020-09-30',0),(8,'2020-09-23','14:23:00','18:22:00',3,1,1,1,'2020-10-15',0);
/*!40000 ALTER TABLE `overtime_hours` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `overtime_hours_BEFORE_INSERT` BEFORE INSERT ON `overtime_hours` FOR EACH ROW BEGIN
	set new.number_of_hours = hour( timediff (new.started_at, new.ended_at));
END */;;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `overtime_hours_BEFORE_UPDATE` BEFORE UPDATE ON `overtime_hours` FOR EACH ROW BEGIN
	set new.number_of_hours = hour( timediff (new.started_at, new.ended_at));
END */;;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `overtime_hours_AFTER_DELETE` AFTER DELETE ON `overtime_hours` FOR EACH ROW BEGIN
 -- insert into altTabel(nume coloana1, col 2) values (old.number_of_hours)
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `program_types`
--

DROP TABLE IF EXISTS `program_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `starts_at` time NOT NULL,
  `ends_at` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_types`
--

LOCK TABLES `program_types` WRITE;
/*!40000 ALTER TABLE `program_types` DISABLE KEYS */;
INSERT INTO `program_types` VALUES (6,'24H-firstDay','08:00:00','23:59:59'),(7,'24H-secondDay','00:00:00','07:59:59'),(9,'normal','08:00:00','16:00:00');
/*!40000 ALTER TABLE `program_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranks`
--

DROP TABLE IF EXISTS `ranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranks`
--

LOCK TABLES `ranks` WRITE;
/*!40000 ALTER TABLE `ranks` DISABLE KEYS */;
INSERT INTO `ranks` VALUES (1,'comisar șef'),(2,'comisar'),(3,'subcomisar'),(4,'inspector principal'),(5,'inspector'),(6,'subinspector'),(7,'agent șef principal'),(8,'agent șef'),(9,'agent șef adjunct'),(10,'agent principal'),(11,'agent'),(12,'chestor'),(13,'chestor principal'),(14,'chestor șef adjunct'),(15,'chestor șef');
/*!40000 ALTER TABLE `ranks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valid_number_of_days_per_overtime_hours`
--

DROP TABLE IF EXISTS `valid_number_of_days_per_overtime_hours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valid_number_of_days_per_overtime_hours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valid_number_of_days` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valid_number_of_days_per_overtime_hours`
--

LOCK TABLES `valid_number_of_days_per_overtime_hours` WRITE;
/*!40000 ALTER TABLE `valid_number_of_days_per_overtime_hours` DISABLE KEYS */;
INSERT INTO `valid_number_of_days_per_overtime_hours` VALUES (1,15),(2,20),(3,30),(4,50),(5,55),(6,60);
/*!40000 ALTER TABLE `valid_number_of_days_per_overtime_hours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-29 21:26:39
