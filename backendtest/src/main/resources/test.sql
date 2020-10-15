CREATE DATABASE  IF NOT EXISTS `backendtest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `backendtest`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: backendtest
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans` (
  `id_loan` int NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id_loan`),
  KEY `FK52fkly2f4qlm5skxfkk2dr8f7` (`id_user`),
  CONSTRAINT `FK52fkly2f4qlm5skxfkk2dr8f7` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES (1,2500,1),(2,2600,1),(3,7500,1),(4,2500,1),(5,2600,1),(6,7500,1),(7,2500,1),(8,2600,1),(9,7500,1),(10,2500,2),(11,2600,2),(12,7500,2),(13,2500,2),(14,2600,2),(15,7500,2),(16,2500,2),(17,2600,2),(18,7500,2),(19,2500,3),(20,2600,3),(21,7500,3),(22,2500,3),(23,2600,3),(24,7500,3),(25,2500,3),(26,2600,3),(27,7500,3),(28,2500,4),(29,2600,4),(30,7500,4),(31,2500,4),(32,2600,4),(33,7500,4),(34,2500,4),(35,2600,4),(36,7500,4),(37,2500,5),(38,2600,5),(39,7500,5),(40,2500,5),(41,2600,5),(42,7500,5),(43,2500,5),(44,2600,5),(45,7500,5),(46,2500,6),(47,2600,6),(48,7500,6),(49,2500,6),(50,2600,6),(51,7500,6),(52,2500,6),(53,2600,6),(54,7500,6),(55,2500,7),(56,7500,7),(57,7400,7),(58,2500,7),(59,7500,7),(60,7400,7),(61,2500,7),(62,7500,7),(63,7400,7),(64,2500,8),(65,7500,8),(66,7400,8),(67,2500,8),(68,7500,8),(69,7400,8),(70,2500,8),(71,7500,8),(72,7400,8),(73,2500,9),(74,7500,9),(75,7400,9),(76,2500,9),(77,7500,9),(78,7400,9),(79,2500,9),(80,7500,9),(81,7400,9);
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test@app.com.ar','Pepe','Argento'),(2,'test@app.com.ar','Carlos','Argento'),(3,'test@app.com.ar','Pepa','Argento'),(4,'test@app.com.ar','John','Argento'),(5,'test@app.com.ar','Clark','Argento'),(6,'test@app.com.ar','Joe','Argento'),(7,'test@app.com.ar','Jen','Argento'),(8,'test@app.com.ar','Leon','Argento'),(9,'test@app.com.ar','Marco Aurelio','Argento');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'backendtest'
--

--
-- Dumping routines for database 'backendtest'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-13 17:05:47
