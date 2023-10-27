-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(300) DEFAULT NULL,
  `image_path` varchar(45) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (5,'this is the 2 post of my blog',NULL,NULL,'2023-10-27 08:30:23'),(6,'this is the 2 post of my blog',NULL,NULL,'2023-10-27 08:30:23'),(7,'this is the 2 post of my blog',NULL,NULL,'2023-10-27 08:30:23'),(8,'this is the 2 post of my blog',NULL,NULL,'2023-10-27 08:30:23'),(9,'this is the 2 post of my blog',NULL,'10','2023-10-27 08:30:23'),(10,'this is the 2 post of my blog',NULL,'9','2023-10-27 08:30:23'),(11,'this is the 2 post of my blog',NULL,'8','2023-10-27 08:30:48'),(12,'this is the 2 post of my blog',NULL,'2','2023-10-27 08:31:49'),(13,'this is the 2 post of my blog',NULL,'6','2023-10-27 08:37:02'),(14,'this is the 4 post of my blog',NULL,'6','2023-10-27 08:37:44'),(15,'this is the 4 post of my blog',NULL,'4','2023-10-27 08:38:35'),(16,'this is the 4 post of my blog',NULL,'2','2023-10-27 08:39:25'),(17,'this is the 4 post of my blog',NULL,'2','2023-10-27 08:39:44'),(18,NULL,NULL,'1','2023-10-27 08:40:03'),(19,'this is the 4 post of my blog',NULL,'7','2023-10-27 08:40:27'),(20,'this is the 4 post of my blog','path/to/image','90','2023-10-27 08:45:08'),(21,'this is the 4 post of my blog','path/to/image','90','2023-10-27 08:55:41');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-28  0:38:13
