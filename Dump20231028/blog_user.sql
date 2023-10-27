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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dodo','uwamba','uwambadodos@gmail.com','0786138376','admin'),(2,'didi','dodos','uwambadi@gmail.gov','0786137377','admin'),(3,'dodos','uwambadi','uwambadodo@gmail.com','07861383738','admin'),(4,'dodos','uwambadi','uwambadodo@gmail.com','07861383738','admin'),(5,'dodos','uwambadi','uwambadodo@gmail.com','07861383738','admin'),(6,'dodos','uwambadi','uwambadodo@gmail.com','07861383738','admin'),(7,'uwambadodo@gmail.com','dodos','uwambadi1',NULL,'$2a$10$b5NzvhINTo08gn56fBj7AeJVZYtuz6vEgdPtwHdCbkcUjrc/t88zS'),(8,'uwambadodoss@gmail.com','dodos','uwambadi',NULL,'$2a$10$8Dnz9k/qKXhbIVA9elIha.oz17oYtKfXpSIFqCPd4TtYkp.V/8Tfi'),(9,'uwambadi',NULL,NULL,NULL,'$2a$10$E.Ue4JLmwOuCUjz.YX0KS.DSYVIS1aZzO8VZl804rEuKPYs28hPk.'),(10,NULL,'last','admin','admin','admin'),(11,'firstName','last','admin','admin','admin'),(12,'uwambadi',NULL,NULL,NULL,'$2a$10$E.Ue4JLmwOuCUjz.YX0KS.DSYVIS1aZzO8VZl804rEuKPYs28hPk.'),(13,'uwambadi',NULL,NULL,NULL,'$2a$10$E.Ue4JLmwOuCUjz.YX0KS.DSYVIS1aZzO8VZl804rEuKPYs28hPk.'),(14,'uwambadi',NULL,NULL,NULL,'$2a$10$E.Ue4JLmwOuCUjz.YX0KS.DSYVIS1aZzO8VZl804rEuKPYs28hPk.'),(15,'uwambadi',NULL,NULL,NULL,'$2a$10$E.Ue4JLmwOuCUjz.YX0KS.DSYVIS1aZzO8VZl804rEuKPYs28hPk.'),(16,'uwambadi',NULL,NULL,NULL,'$2a$10$E.Ue4JLmwOuCUjz.YX0KS.DSYVIS1aZzO8VZl804rEuKPYs28hPk.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-28  0:38:14
