-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: shoppingcart
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` varchar(50) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `category_id` varchar(50) NOT NULL,
  `unit_price` int(11) DEFAULT 0,
  `image` varchar(100) DEFAULT 'noImage.jpg',
  `create_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','LA MEDUSA PATENT LEATHER PUMPS','11',53000,'female-shoes.jpg','2022-04-07 16:29:36'),('2','OLEVS Women\'s Dress Watches Rose Gold ','12',150000,'female-watch.jpg','2022-04-07 16:29:36'),('3','Salvatore Ferragamo Belt for men','13',380000,'man-belt.jpg','2022-04-07 16:29:36'),('4','Italian handmade shoes by Enzo Bonafe','14',2500000,'man-shoes.jpg','2022-04-07 16:29:36'),('5','ROLEX DATEJUST 41MM FULL-SET REF. 126331','15',13000000,'men-watch.jpg','2022-04-07 16:29:36'),('6','GG Marmont matelassé shoulder bag','16',800000,'ladies-bag.jpg','2022-04-07 16:29:36'),('7','Business Suits For Wedding','17',680000,'man-suits.jpg','2022-04-07 16:29:36'),('8','Chanel 21 Season cotton ecru','18',95000,'woman-cloths.jpg','2022-04-07 16:29:36');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `user_id` varchar(50) NOT NULL,
  `product_id` varchar(50) NOT NULL,
  `quantity` int(11) DEFAULT 0,
  `unit_price` int(11) DEFAULT 0,
  `create_date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES ('java','1',20,153000,'2022-04-07 17:16:06'),('java','3',1,380000,'2022-04-07 17:19:48'),('java','6',5,800000,'2022-04-07 17:19:48'),('java','7',6,3000000,'2022-04-07 17:19:48'),('john','4',4,370000,'2022-04-07 17:19:48'),('steve','2',5,500000,'2022-04-07 17:19:48'),('steve','5',3,1300000,'2022-04-07 17:19:48'),('steve','8',7,530000,'2022-04-07 17:19:48'),('steve','2',5,500000,'2022-04-07 19:30:42'),('java','3',1,380000,'2022-04-07 19:30:42'),('john','4',4,370000,'2022-04-07 19:30:42'),('steve','5',3,1300000,'2022-04-07 19:30:42'),('java','6',5,800000,'2022-04-07 19:30:42'),('java','7',6,3000000,'2022-04-07 19:30:42'),('steve','8',7,530000,'2022-04-07 19:30:42');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` varchar(100) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `category_desc` varchar(200) DEFAULT NULL,
  `create_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('11','여성하이힐','여성하이힐','2022-04-07 16:25:31'),('12','여성시계','여성시계','2022-04-07 16:25:31'),('13','남성벨트','남성벨트','2022-04-07 16:25:31'),('14','남성구두','남성구두','2022-04-07 16:25:31'),('15','남성시계','남성시계','2022-04-07 16:25:31'),('16','여성핸드백','여성핸드백','2022-04-07 16:25:31'),('17','남성수트','남성수트','2022-04-07 16:25:31'),('18','여성의류','여성의류','2022-04-07 16:25:31');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `quantity` int(11) DEFAULT 0,
  `amt` int(11) DEFAULT 0,
  `address` varchar(200) DEFAULT NULL,
  `status` char(2) DEFAULT NULL,
  `create_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`order_id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'1','java',2,106000,NULL,NULL,'2022-04-08 09:50:36'),(2,'2','john',15,2250000,NULL,NULL,'2022-04-08 09:50:36'),(3,'3','steve',20,7600000,NULL,NULL,'2022-04-08 09:50:36'),(4,'4','java',100,25000000,NULL,NULL,'2022-04-08 09:50:36'),(5,'2','java',150,22500000,NULL,NULL,'2022-04-08 09:50:36'),(6,'2','steve',25,3750000,NULL,NULL,'2022-04-08 09:50:36'),(7,'1','john',30,1590000,NULL,NULL,'2022-04-08 09:50:36'),(8,'5','java',7,91000000,NULL,NULL,'2022-04-08 09:50:36'),(9,'6','john',13,10400000,NULL,NULL,'2022-04-08 09:50:36'),(10,'7','steve',8,5440000,NULL,NULL,'2022-04-08 09:50:36');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(50) NOT NULL,
  `user_pwd` varchar(100) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_email` varchar(1200) NOT NULL,
  `user_hp` varchar(15) NOT NULL,
  `create_date` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('java','1234','홍길동','hong@kildong.com','010-5678-1234','2022-04-07 16:18:36'),('john','1234','존오','johnoh@google.com','010-5678-1234','2022-04-07 16:18:36'),('steve','1234','스티브','steve@amazon.com','010-5678-1234','2022-04-07 16:18:36');
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

-- Dump completed on 2022-04-17  8:53:50
