-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: flightappdb
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `ticket_id` int NOT NULL AUTO_INCREMENT,
  `FName` varchar(255) DEFAULT NULL,
  `seat_num` varchar(255) DEFAULT NULL,
  `LName` varchar(255) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `cardnumber` int DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (2,'Anish','3D','Patel','CA104','poopoo',1,29349),(4,NULL,NULL,NULL,NULL,NULL,999,798787),(5,NULL,NULL,NULL,NULL,NULL,999,546465),(6,NULL,'2C',NULL,'CA103',NULL,999,5487),(7,'Anish',NULL,'Patel',NULL,'anishpatel213@gmail.com',999,78987),(8,'Anish','1A','Patel','CA102','anishpatel213@gmail.com',999,78987),(9,'Anish',NULL,'Patel',NULL,'anishpatel213@gmail.com',999,2323124),(10,'poo','1B','Patel','CA103','anishpatel213@gmail.com',999,45576),(11,'Anish',NULL,'Patel',NULL,'anishpatel213@gmail.com',999,33443),(12,'Anish','1D','Patel',NULL,'anishpatel213@gmail.com',999,33453),(13,'Anish','1B','P','CA101','234@hg.co',999,4443),(14,'Anish','3B','Patel','CA103','anishpatel213@gmail.com',999,78987),(15,'Anish','1B','Patel',NULL,'anishpatel213@gmail.com',999,41234234),(16,'Anish','1D','Patel','CA102','anishpatel213@gmail.com',999,23423423),(17,'Usman','8A','L','CA103','usman@usman.com',999,545575),(18,'Anish','1A','Patel','CA103','anishpatel213@gmail.com',1004,78987),(19,'Anish','9B','Patel','CA105','anishpatel213@gmail.com',999,98798),(20,'Bob','2A','M','CA109','bob@gmail.com',999,456847),(21,'shirley','5C','b','CA109','shirl@gmail.com',999,665595),(22,'dog','12D','dog','CA109','dog@gmail.com',1006,1665846),(23,'car','2C','car','CA107','car@car.com',1007,654867);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-03 20:38:51
