CREATE DATABASE  IF NOT EXISTS `cop_overtime` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cop_overtime`;
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
  CONSTRAINT `DEPARTMENT_EMPLOYEE_EMPLOYEES` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `DEPARTMET_EMPLOYEE_DEPARTMENTS` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `EMPLOYEE_RANK_EMPLOYEES_FK_idx` (`employee_id`),
  KEY `EMPLOYEE_RANK_RANKS_FK_idx` (`rank_id`),
  CONSTRAINT `EMPLOYEE_RANK_EMPLOYEES_FK` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `EMPLOYEE_RANK_RANKS_FK` FOREIGN KEY (`rank_id`) REFERENCES `ranks` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_ranks`
--

LOCK TABLES `employee_ranks` WRITE;
/*!40000 ALTER TABLE `employee_ranks` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legal_day_off`
--

DROP TABLE IF EXISTS `legal_day_off`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `legal_day_off` (
  `id` int NOT NULL AUTO_INCREMENT,
  `day_off` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legal_day_off`
--

LOCK TABLES `legal_day_off` WRITE;
/*!40000 ALTER TABLE `legal_day_off` DISABLE KEYS */;
/*!40000 ALTER TABLE `legal_day_off` ENABLE KEYS */;
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
  `valid_number_of_days_id` int DEFAULT NULL,
  `is_weekend` tinyint DEFAULT NULL,
  `enabled` tinyint NOT NULL,
  `expires_at` date NOT NULL,
  `legal_day_off_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `LEGAL_DOFF_OVERTIMEHOURS_FK_idx` (`legal_day_off_id`),
  CONSTRAINT `LEGAL_DOFF_OVERTIMEHOURS_FK` FOREIGN KEY (`legal_day_off_id`) REFERENCES `legal_day_off` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overtime_hours`
--

LOCK TABLES `overtime_hours` WRITE;
/*!40000 ALTER TABLE `overtime_hours` DISABLE KEYS */;
/*!40000 ALTER TABLE `overtime_hours` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program_types`
--

LOCK TABLES `program_types` WRITE;
/*!40000 ALTER TABLE `program_types` DISABLE KEYS */;
INSERT INTO `program_types` VALUES (1,'program Normal','08:00:00','16:00:00'),(2,'Schimbul 1','06:00:00','14:00:00'),(3,'Schimbul 2','14:00:00','22:00:00'),(4,'Schimbul 3','22:00:00','06:00:00'),(6,'24H-firstDay','08:00:00','23:59:59'),(7,'24H-secondDay','00:00:00','07:59:59');
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
  `started_at` date DEFAULT NULL,
  `ended_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranks`
--

LOCK TABLES `ranks` WRITE;
/*!40000 ALTER TABLE `ranks` DISABLE KEYS */;
INSERT INTO `ranks` VALUES (1,'comisar șef',NULL,NULL),(2,'comisar',NULL,NULL),(3,'subcomisar',NULL,NULL),(4,'inspector principal',NULL,NULL),(5,'inspector',NULL,NULL),(6,'subinspector',NULL,NULL),(7,'agent șef principal',NULL,NULL),(8,'agent șef',NULL,NULL),(9,'agent șef adjunct',NULL,NULL),(10,'agent principal',NULL,NULL),(11,'agent',NULL,NULL),(12,'chestor',NULL,NULL),(13,'chestor principal',NULL,NULL),(14,'chestor șef adjunct',NULL,NULL),(15,'chestor șef',NULL,NULL);
/*!40000 ALTER TABLE `ranks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-05 13:07:59
