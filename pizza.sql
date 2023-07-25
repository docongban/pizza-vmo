-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: pizza
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','2023-03-02 22:29:37','admin@gmail.com','admin','$2a$10$E2bxRcEJs5.rcdJ1567X8OkOuES5PCumgnW6X9Bq7SfzV3xHtq/wy','0123456789','ADMIN','2023-03-02 22:29:37'),(2,'test','2023-03-05 22:10:17','test@gmail.com','Nhân viên 1','$2a$10$LBBRgymvfzc3Z9vqTxxtN.MWHEeTe1Z/cOJPpViYxUYDlpdwgqmRG','1234567891','SELLER','2023-03-05 22:10:17'),(3,'test','2023-04-01 11:33:41','test@gmail.com','Nhân viên 2','$2a$10$aiK1zBIKCAowHhLxq/zmKOJ89yrkAeQftzsy4OCebETaMXE2Sgtgu','1234567892','SELLER','2023-04-01 11:33:41'),(4,'test','2023-04-01 11:34:18','test@gmail.com','Nhân viên 3','$2a$10$ShpU8v1jdGxH/IYNOiaV9.jrPTWuk7nafylURjwBcvio3jV8Iuv2u','1234567893','SELLER','2023-04-01 11:34:18'),(5,'test','2023-04-01 11:35:04','test@gmail.com','Nhân viên 4','$2a$10$HzAifMCno/XBIHTSX82dJeYLB6UaxusLkEkPwEdd6M3mUsy7IeNUa','1234567894','SELLER','2023-04-01 11:35:04'),(6,'test','2023-04-01 11:35:51','test@gmail.com','Nhân viên 5','$2a$10$j11kmmittvXQYaGofXJIC.zkGDLtrrBieIRj21Q2YqArA8BSaVHzi','1234567895','SELLER','2023-04-01 11:35:51'),(7,'test','2023-04-01 11:36:22','test@gmail.com','Nhân viên 6','$2a$10$0AOmP3fqglos3Cq.SWdYiu7dqXp8iTLt4NpncHwOAxYUY/MM.Qh72','1234567896','SELLER','2023-04-01 11:36:22'),(8,'test','2023-04-01 11:37:44','test@gmail.com','Khách hàng 1','$2a$10$RjbmJDpLL6myOqMqJE.hquN2NB8nz9y4xXvDlsPnjLh3hBm3n6c9K','01234567891','USER','2023-04-01 11:37:44'),(9,'test','2023-04-01 11:38:01','test@gmail.com','Khách hàng 2','$2a$10$UlVzZ6stDm85Wr/FLVcT9.22Z3IBkTF05cyTh5./JlPHYXOXgtY3a','01234567892','USER','2023-04-01 11:38:01'),(10,'test','2023-04-01 11:38:29','test@gmail.com','Khách hàng 3','$2a$10$NWTO3ahH3kcECGS1PnRI3e7Hi4a6YkPyZw4yqsezsavcOQOENrCiW','01234567893','USER','2023-04-01 11:38:29'),(11,'test','2023-04-01 11:38:52','test@gmail.com','Khách hàng 4','$2a$10$Sm636hAvwjqReBxDci1CxOkI/J7Tz9690G6V3gLyvan8ch.il1AIa','01234567894','USER','2023-04-01 11:38:52'),(12,'test','2023-04-01 11:39:03','test@gmail.com','Khách hàng 5','$2a$10$i8AKbsK1yPXaNk9zQ3rkKeC4BgyW.2.Rd3IVSNzVrVAtFea/Vanhe','01234567895','USER','2023-04-01 11:39:03'),(13,'test','2023-04-01 11:39:16','test@gmail.com','Khách hàng 6','$2a$10$d/tlqKltuU06C8o1RVG42usjPi.RNE.yDMhZENuy4jHW.QkadM7zu','01234567896','USER','2023-04-01 11:39:16'),(29,'test','2023-04-14 08:26:25','ban@gmail.com','Nguyễn Văn A','$2a$10$eXv5F/DO74CEw70078raKOWa1bjYAFiO09mPzCAUGPxpdUw/7z1Ba','123456','USER','2023-04-14 08:26:25'),(30,'Hà Nội','2023-04-16 14:30:40','teo@gmail.com','Nguyễn Văn Tèo','$2a$10$71Gf3C3xXO0rqxAZSoh25.nmbGa7em6ICvQaT6uOp5B32GyZam1lO','023456789','USER','2023-04-16 14:30:40'),(31,'Hà Nội','2023-04-16 14:41:21','nam@gmail.com','Nguyễn Văn Nam','$2a$10$rD0nNJzETzOl.8lmWZJJA.iirei1WHcEvfFuc0fyMLzhyZhOPXHmu','01234567','USER','2023-04-16 14:41:21');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `used_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (2,'img\\1.jpeg','USED'),(3,'img\\2.jpeg','USED'),(4,'img\\3.jpeg','USED'),(5,'img\\4.jpeg','USED'),(6,'img\\5.jpeg','USED'),(7,'img\\6.jpeg','USED'),(13,'img\\banner.jpeg','NONE');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'2022-03-09 03:29:54','Pizza','2022-05-24 11:49:20'),(2,'2022-03-09 03:29:54','Khai vị','2022-03-09 03:29:54'),(3,'2022-03-09 03:29:54','Mỳ Ý','2022-03-09 03:29:54'),(15,'2022-05-31 09:09:48','Đồ uống','2022-05-31 09:09:48'),(21,'2023-04-16 14:47:06','Kem Hộp','2023-04-16 14:47:06');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discount` double DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,5,350000),(2,7,650000),(3,10,1000000),(4,12,2000000),(5,15,5000000),(6,18,8000000),(8,20,10000000),(9,19,9000000);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evulate`
--

DROP TABLE IF EXISTS `evulate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evulate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `order_account_id` int NOT NULL,
  `time` datetime DEFAULT NULL,
  `food_rate` int NOT NULL COMMENT '0-hài lòng, 1-bình thường, 2-không hài lòng',
  `service_rate` int NOT NULL COMMENT '0-hài lòng, 1-bình thường, 2-không hài lòng',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evulate`
--

LOCK TABLES `evulate` WRITE;
/*!40000 ALTER TABLE `evulate` DISABLE KEYS */;
INSERT INTO `evulate` VALUES (1,'Tôi rất không hài lòng',1,'2023-04-13 17:48:51',1,2),(2,'test',10,'2023-04-13 11:21:23',0,0),(4,'đánh giá dài đánh giá dài đánh giá dài đánh giá dài đánh giá dài đánh giá dài đánh giá dài đánh giá dài đánh giá dài ',6,'2023-04-13 16:08:00',0,0),(5,'khum',8,'2023-04-13 16:41:28',0,1),(6,'tôi đã khóc khi ăn món này',9,'2023-04-13 17:01:11',2,1),(7,'Không',34,'2023-04-14 08:29:21',0,1),(8,'Ship nhanh',36,'2023-04-16 14:32:56',0,1),(9,'Ship nhanh',37,'2023-04-16 14:43:51',0,1);
/*!40000 ALTER TABLE `evulate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `price` int DEFAULT NULL,
  `import_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Tiền điện',1000000,'2023-04-06 17:45:28'),(2,'Nhập rau',500000,'2023-03-08 18:20:55'),(3,'Nhập thịt',1000000,'2023-04-06 18:21:43'),(4,'Gia vị',500000,'2023-03-16 18:24:24'),(5,'Vỡ đồ',200000,'2023-03-20 18:25:35'),(6,'Tiền nước',200000,'2023-04-06 18:32:46'),(7,'Mì Chính',2000,'2023-04-08 16:43:07'),(8,'Bột mì',500000,'2023-04-16 14:35:26'),(9,'Gia vị ',100000,'2023-04-16 14:48:55');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_account`
--

DROP TABLE IF EXISTS `order_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_address` varchar(255) DEFAULT NULL,
  `account_email` varchar(255) DEFAULT NULL,
  `account_fullname` varchar(255) DEFAULT NULL,
  `account_phone` varchar(255) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_status` int NOT NULL,
  `account_id` int NOT NULL,
  `total` bigint NOT NULL,
  `total_after_discount` bigint NOT NULL,
  `evulate_status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_account`
--

LOCK TABLES `order_account` WRITE;
/*!40000 ALTER TABLE `order_account` DISABLE KEYS */;
INSERT INTO `order_account` VALUES (1,'test','test@gmail.com','Khách hàng 1','01234567891','2023-04-10 22:39:32',1,8,643000,610850,1),(2,'test','test@gmail.com','Khách hàng 1','01234567891','2023-03-20 22:39:54',0,8,863000,802590,0),(3,'test','test@gmail.com','Khách hàng 1','01234567891','2023-04-04 22:40:36',0,8,865000,804450,0),(4,'test','test@gmail.com','Khách hàng 1','01234567891','2023-03-19 22:43:39',0,8,377000,358150,0),(5,'test','test@gmail.com','Khách hàng 1','01234567891','2023-03-18 22:44:00',0,8,496000,471200,0),(6,'test','test@gmail.com','Khách hàng 2','01234567892','2023-04-11 22:44:24',0,9,607000,576650,1),(7,'test','test@gmail.com','Khách hàng 2','01234567892','2023-04-15 22:44:32',0,9,198000,198000,1),(8,'test','test@gmail.com','Khách hàng 2','01234567892','2023-03-29 22:44:42',0,9,476000,452200,1),(9,'test','test@gmail.com','Khách hàng 2','01234567892','2023-03-24 22:44:54',0,9,714000,664020,1),(10,'test','test@gmail.com','Khách hàng 2','01234567892','2023-04-11 22:45:16',0,9,921000,856530,1),(11,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-06 22:45:35',0,10,456000,433200,0),(12,'test','test@gmail.com','Khách hàng 3','01234567893','2023-03-04 22:46:37',0,10,595000,565250,0),(13,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-15 22:46:50',1,10,516000,490200,0),(14,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-09 22:47:01',0,10,515000,489250,0),(15,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-15 22:47:24',1,10,542000,514900,0),(16,'test','test@gmail.com','Khách hàng 4','01234567894','2023-03-19 22:48:05',0,11,813000,756090,0),(17,'test','test@gmail.com','Khách hàng 4','01234567894','2023-03-28 22:48:21',0,11,714000,664020,0),(18,'test','test@gmail.com','Khách hàng 4','01234567894','2023-04-12 22:48:37',0,11,604000,573800,0),(19,'test','test@gmail.com','Khách hàng 4','01234567894','2023-04-03 22:49:06',0,11,894000,831420,0),(20,'test','test@gmail.com','Khách hàng 4','01234567894','2023-03-17 22:49:28',0,11,644000,611800,0),(21,'test','test@gmail.com','Khách hàng 5','01234567895','2023-03-10 22:49:58',0,12,415000,394250,0),(22,'test','test@gmail.com','Khách hàng 5','01234567895','2023-03-13 22:50:05',0,12,278000,278000,0),(23,'test','test@gmail.com','Khách hàng 5','01234567895','2023-03-18 22:50:17',0,12,713000,663090,0),(24,'test','test@gmail.com','Khách hàng 5','01234567895','2023-03-02 22:50:40',0,12,952000,885360,0),(25,'test','test@gmail.com','Khách hàng 5','01234567895','2023-04-09 22:51:10',0,12,556000,528200,0),(26,'test','test@gmail.com','Khách hàng 5','01234567895','2023-03-04 22:51:54',0,12,684000,636120,0),(27,'test','test@gmail.com','Khách hàng 6','01234567896','2023-04-06 22:52:17',0,13,237000,237000,0),(28,'test','test@gmail.com','Khách hàng 6','01234567896','2023-03-24 22:52:29',0,13,595000,565250,0),(29,'test','test@gmail.com','Khách hàng 6','01234567896','2023-03-07 22:52:40',0,13,525000,498750,0),(30,'test','test@gmail.com','Khách hàng 6','01234567896','2023-04-04 22:52:58',0,13,476000,452200,0),(31,'test','test@gmail.com','Khách hàng 6','01234567896','2023-04-07 22:53:11',0,13,774000,719820,0),(32,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-11 00:04:36',0,10,178000,178000,0),(33,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-11 00:06:43',0,10,178000,178000,0),(34,'test','ban@gmail.com','Nguyễn Văn A','123456','2023-04-14 08:27:55',0,29,327000,327000,1),(35,'test','test@gmail.com','Khách hàng 3','01234567893','2023-04-16 13:32:12',1,10,89000,89000,0),(36,'Hà Nội','teo@gmail.com','Nguyễn Văn Tèo','023456789','2023-04-16 14:31:39',1,30,567000,538650,1),(37,'Hà Nội','nam@gmail.com','Nguyễn Văn Nam','01234567','2023-04-16 14:42:18',1,31,574000,545300,1),(38,'test','test@gmail.com','Khách hàng 1','01234567891','2023-05-23 15:40:46',0,8,267000,267000,0),(39,'test','test@gmail.com','Khách hàng 2','01234567892','2023-06-04 23:44:29',0,9,267000,267000,0),(40,'test','test@gmail.com','Khách hàng 2','01234567892','2023-06-05 00:21:41',0,9,89000,89000,0),(41,'test','test@gmail.com','Khách hàng 1','01234567891','2023-06-07 21:55:41',0,8,2479000,2181520,0),(42,'test','test@gmail.com','Khách hàng 2','01234567892','2023-06-07 21:56:27',0,9,3221000,2834480,0),(43,'test','test@gmail.com','Khách hàng 3','01234567893','2023-06-07 21:57:06',0,10,2917000,2566960,0),(44,'test','test@gmail.com','Khách hàng 4','01234567894','2023-06-07 22:09:51',1,11,318000,318000,0),(45,'test','test@gmail.com','Khách hàng 5','01234567895','2023-06-07 22:20:50',1,12,575000,546250,0);
/*!40000 ALTER TABLE `order_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_account_id` int NOT NULL,
  `order_quantity` int NOT NULL,
  `product_content` varchar(255) DEFAULT NULL,
  `product_price` bigint NOT NULL,
  `product_thumbnail` varchar(255) DEFAULT NULL,
  `product_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,2,'Sự kết hợp của nhiều kiểu chế biến khoai tây',79000,'img\\gio_khoai_tay_chien.jpeg','Giỏ Khoai Tây Chiên'),(2,1,1,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(3,1,2,'Sườn bò Kobe',79000,'img\\suon_sieu_sao_5_mieng.png','Sườn siêu sao 5 miếng'),(4,1,2,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(5,2,1,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(6,2,1,'Được làm từ hơn 20 loại nguyên liệu khác nhau.',59000,'img\\salad_dac_sac.png','Salad đặc sắc'),(7,2,4,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(8,2,1,'Dành riêng cho những người có niềm đam mê bất tận đối với đào.',119000,'img\\hai_san_dao.png','Pizza hải sản đào'),(9,2,1,'Cùng thư giãn với trà lipton.',10000,'img\\tra_lipton_lon.jpeg','Trà lipton lon'),(10,3,3,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(11,3,3,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(12,3,1,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(13,3,1,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(14,4,1,'Dễ làm dễ ăn.',99000,'img\\cay_xuc_xich.png','Mì cay xúc xích'),(15,4,1,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(16,4,2,'Sự kết hợp của nhiều kiểu chế biến khoai tây',79000,'img\\gio_khoai_tay_chien.jpeg','Giỏ Khoai Tây Chiên'),(17,5,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(18,5,1,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(19,5,1,'Màu xanh của rau củ sẽ làm nên sự đặc sắc của bàn ăn nhà bạn.',119000,'img\\pesto_xanh.png','Pizza pesto xanh'),(20,6,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(21,6,2,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(22,6,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(23,7,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(24,8,1,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói'),(25,8,3,'Dành riêng cho những người có niềm đam mê bất tận đối với đào.',119000,'img\\hai_san_dao.png','Pizza hải sản đào'),(26,9,2,'Thử mình với sức cay và hải sản ở vùng Đại Tây Dương',99000,'img\\cay_hai_san.png','Mì cay hải sản'),(27,9,2,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(28,9,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(29,10,5,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(30,10,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(31,10,3,'Sườn bò Kobe',79000,'img\\suon_sieu_sao_5_mieng.png','Sườn siêu sao 5 miếng'),(32,11,1,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(33,11,3,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(34,12,3,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(35,12,2,'Màu xanh của rau củ sẽ làm nên sự đặc sắc của bàn ăn nhà bạn.',119000,'img\\pesto_xanh.png','Pizza pesto xanh'),(36,13,3,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói'),(37,13,1,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(38,13,2,'Cùng thư giãn với trà lipton.',10000,'img\\tra_lipton_lon.jpeg','Trà lipton lon'),(39,14,3,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(40,14,1,'Màu xanh của rau củ sẽ làm nên sự đặc sắc của bàn ăn nhà bạn.',119000,'img\\pesto_xanh.png','Pizza pesto xanh'),(41,14,1,'Thử mình với sức cay và hải sản ở vùng Đại Tây Dương',99000,'img\\cay_hai_san.png','Mì cay hải sản'),(42,15,1,'Uống bốn chai, hai lít mỗi ngày.',7000,'img\\aquafina_chai.png','Nước khoáng Aquafina'),(43,15,2,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(44,15,3,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(45,16,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(46,16,2,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(47,16,3,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(48,17,3,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(49,17,1,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói'),(50,17,2,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(51,18,3,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(52,18,2,'Sườn bò Kobe',79000,'img\\suon_sieu_sao_5_mieng.png','Sườn siêu sao 5 miếng'),(53,18,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(54,19,2,'Thử mình với sức cay và hải sản ở vùng Đại Tây Dương',99000,'img\\cay_hai_san.png','Mì cay hải sản'),(55,19,2,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(56,19,1,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(57,19,3,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(58,20,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(59,20,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(60,20,3,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói'),(61,21,1,'Thơm ngon bổ rẻ.',39000,'img\\salad_tron_dau_giam.png','Salad trộn dầu giấm'),(62,21,2,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(63,21,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(64,22,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(65,23,2,'Được làm từ hơn 20 loại nguyên liệu khác nhau.',59000,'img\\salad_dac_sac.png','Salad đặc sắc'),(66,23,2,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(67,23,3,'Màu xanh của rau củ sẽ làm nên sự đặc sắc của bàn ăn nhà bạn.',119000,'img\\pesto_xanh.png','Pizza pesto xanh'),(68,24,2,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói'),(69,24,2,'Dành riêng cho những người có niềm đam mê bất tận đối với đào.',119000,'img\\hai_san_dao.png','Pizza hải sản đào'),(70,24,4,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(71,25,1,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(72,25,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(73,25,2,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(74,26,2,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(75,26,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(76,26,1,'Sườn bò Kobe',79000,'img\\suon_sieu_sao_5_mieng.png','Sườn siêu sao 5 miếng'),(77,26,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(78,27,2,'Sự kết hợp của nhiều kiểu chế biến khoai tây',79000,'img\\gio_khoai_tay_chien.jpeg','Giỏ Khoai Tây Chiên'),(79,27,1,'Sườn bò Kobe',79000,'img\\suon_sieu_sao_5_mieng.png','Sườn siêu sao 5 miếng'),(80,28,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(81,28,1,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(82,28,2,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(83,29,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(84,29,2,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(85,29,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(86,30,1,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói'),(87,30,3,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(88,31,1,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(89,31,3,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(90,31,2,'Dành riêng cho những người có niềm đam mê bất tận đối với đào.',119000,'img\\hai_san_dao.png','Pizza hải sản đào'),(91,32,2,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(92,33,2,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(93,34,2,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(94,34,1,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(95,35,1,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(96,36,3,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(97,36,1,'Giờ xả hơi: thành quả khó khăn.',12000,'img\\strongbow-honey.jpeg','Strong bow honey'),(98,36,2,'Thử mình với sức cay và hải sản ở vùng Đại Tây Dương',99000,'img\\cay_hai_san.png','Mì cay hải sản'),(99,37,3,'Sự kết hợp của nhiều kiểu chế biến khoai tây',79000,'img\\gio_khoai_tay_chien.jpeg','Giỏ Khoai Tây Chiên'),(100,37,1,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(101,37,2,'Thử mình với sức cay và hải sản ở vùng Đại Tây Dương',99000,'img\\cay_hai_san.png','Mì cay hải sản'),(102,38,2,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(103,38,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(104,39,2,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(105,39,1,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn'),(106,40,1,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(107,41,1,'Làm từ bột bánh kép ngon nhất thế giới.',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico'),(108,41,10,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(109,41,10,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(110,42,8,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(111,42,10,'Pizza rau củ dành của những người ăn chay, người giảm cân.',119000,'img\\rau_cu.png','Pizza rau củ'),(112,42,9,'Sự kết hợp giữa thịt nguội và bắp ngọt',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada'),(113,43,5,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ'),(114,43,9,'Màu xanh của rau củ sẽ làm nên sự đặc sắc của bàn ăn nhà bạn.',119000,'img\\pesto_xanh.png','Pizza pesto xanh'),(115,43,9,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai'),(116,44,1,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương'),(117,44,2,'Giăm bông, thịt muối và dứa',99000,'img\\hawaii_300.png','Pizza Hawaiian'),(118,45,2,'Sự kết hợp của nhiều kiểu chế biến khoai tây',79000,'img\\gio_khoai_tay_chien.jpeg','Giỏ Khoai Tây Chiên'),(119,45,3,'Phô mai nhập khẩu từ Pháp.',139000,'img\\pho_mai.png','Pizza phô mai');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int NOT NULL,
  `order_account_id` int NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `product_id` int NOT NULL,
  `quantiy` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `price` bigint NOT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `id_category` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photos` varchar(255) DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5cxv31vuhc7v32omftlxa8k3c` (`id_category`),
  CONSTRAINT `FK5cxv31vuhc7v32omftlxa8k3c` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (7,'Sự kết hợp của nhiều kiểu chế biến khoai tây','2021-10-31 09:18:43',79000,'img\\gio_khoai_tay_chien.jpeg','Giỏ Khoai Tây Chiên','2022-05-31 08:44:44',2,NULL,NULL,NULL),(20,'Làm từ bột bánh kép ngon nhất thế giới.','2022-05-31 08:38:04',89000,'img\\banh_kep_nuong_mexico.jpeg','Bánh kép nướng Mexico',NULL,2,NULL,NULL,NULL),(21,'Sườn bò Kobe','2022-05-31 08:39:45',79000,'img\\suon_sieu_sao_5_mieng.png','Sườn siêu sao 5 miếng',NULL,2,NULL,NULL,NULL),(22,'Mực được câu thủ công bằng cần tre ở Đại Tây Dương','2022-05-31 08:40:39',89000,'img\\muc_chien_gion.jpeg','Mực chiên giòn',NULL,2,NULL,NULL,NULL),(23,'Được làm từ hơn 20 loại nguyên liệu khác nhau.','2022-05-31 08:43:58',59000,'img\\salad_dac_sac.png','Salad đặc sắc',NULL,2,NULL,NULL,NULL),(24,'Được rút xương thủ công từ tay các nghệ nhân chăn gà.','2022-05-31 08:45:49',120000,'img\\ga_gion_khong_xuong.png','Gà giòn không xương',NULL,2,NULL,NULL,NULL),(25,'Thơm ngon bổ rẻ.','2022-05-31 08:47:49',39000,'img\\salad_tron_dau_giam.png','Salad trộn dầu giấm',NULL,2,NULL,NULL,NULL),(26,'Nước sốt đậm đà, thơm ngon đúng vị.','2022-05-31 08:49:04',89000,'img\\salad_tron_sot_caesar.png','Salad trộn sốt caesar',NULL,2,NULL,NULL,NULL),(27,'Xúc xích bò, giăm bông, thịt xông khói,...và cả thế giới rau phong phú.','2022-05-31 08:52:08',119000,'img\\5_thit_dac_biet.png','Pizza 5 Loại Thịt Đặc Biệt Và Rau Củ',NULL,1,NULL,NULL,NULL),(28,'Giăm bông, thịt muối và dứa','2022-05-31 08:53:05',99000,'img\\hawaii_300.png','Pizza Hawaiian',NULL,1,NULL,NULL,NULL),(29,'Sự kết hợp giữa thịt nguội và bắp ngọt','2022-05-31 08:54:09',119000,'img\\thi_nguoi_canada.png','Pizza Thịt Nguội Kiểu Canada',NULL,1,NULL,NULL,NULL),(30,'Phô mai nhập khẩu từ Pháp.','2022-05-31 08:55:22',139000,'img\\pho_mai.png','Pizza phô mai',NULL,1,NULL,NULL,NULL),(31,'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua','2022-05-31 08:56:42',119000,'img\\thit_xong_khoi.png','Pizza thịt xông khói','2022-05-31 15:15:25',1,NULL,NULL,NULL),(32,'Pizza rau củ dành của những người ăn chay, người giảm cân.','2022-05-31 08:57:54',119000,'img\\rau_cu.png','Pizza rau củ',NULL,1,NULL,NULL,NULL),(33,'Màu xanh của rau củ sẽ làm nên sự đặc sắc của bàn ăn nhà bạn.','2022-05-31 08:59:39',119000,'img\\pesto_xanh.png','Pizza pesto xanh',NULL,1,NULL,NULL,NULL),(34,'Dành riêng cho những người có niềm đam mê bất tận đối với đào.','2022-05-31 09:00:39',119000,'img\\hai_san_dao.png','Pizza hải sản đào',NULL,1,NULL,NULL,NULL),(35,'Nước sốt đậm đà, thơm ngon đúng vị.','2022-05-31 09:02:37',99000,'img\\sot_kem_ca_chua.png','Mì sốt kem cà chua',NULL,3,NULL,NULL,NULL),(36,'Dễ làm dễ ăn.','2022-05-31 09:03:20',99000,'img\\cay_xuc_xich.png','Mì cay xúc xích',NULL,3,NULL,NULL,NULL),(37,'Thử mình với sức cay và hải sản ở vùng Đại Tây Dương','2022-05-31 09:05:19',99000,'img\\cay_hai_san.png','Mì cay hải sản',NULL,3,NULL,NULL,NULL),(38,'Thịt bò Kobe được băm thủ công bằng chính đôi tay của các nghệ nhân.','2022-05-31 09:06:37',129000,'img\\thi_bo_bam.png','Mì thịt bò băm',NULL,3,NULL,NULL,NULL),(39,'There is no cola like the uncola.','2022-05-31 09:11:16',10000,'img\\7up_lon.jpeg','7 up lon',NULL,15,NULL,NULL,NULL),(40,'Uống pepsi gặp Messi.','2022-05-31 09:12:11',10000,'img\\pepsi_lon.jpeg','Pepsi lon',NULL,15,NULL,NULL,NULL),(41,'Giờ xả hơi: thành quả khó khăn.','2022-05-31 09:14:04',12000,'img\\strongbow-honey.jpeg','Strong bow honey',NULL,15,NULL,NULL,NULL),(42,'Cùng thư giãn với trà lipton.','2022-05-31 09:15:00',10000,'img\\tra_lipton_lon.jpeg','Trà lipton lon',NULL,15,NULL,NULL,NULL),(43,'Tạo ra một thế giới tốt đẹp hơn.','2022-05-31 09:16:02',12000,'img\\bia_heineken.png','Bia heineken',NULL,15,NULL,NULL,NULL),(44,'Đã đến năm của những chú hổ.','2022-05-31 09:16:45',12000,'img\\bia_tiger.png','Bia tiger',NULL,15,NULL,NULL,NULL),(45,'Quà Tết tinh tế, thay lời tri ân.','2022-05-31 09:17:17',12000,'img\\bia333.png','Bia 333',NULL,15,NULL,NULL,NULL),(46,'Uống bốn chai, hai lít mỗi ngày.','2022-05-31 09:18:24',7000,'img\\aquafina_chai.png','Nước khoáng Aquafina',NULL,15,NULL,NULL,NULL),(52,'Hộp 200 gram','2023-04-16 14:47:48',109000,'img\\kemhop.png','Kem Mocha Almond Fudge',NULL,21,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timekeeping`
--

DROP TABLE IF EXISTS `timekeeping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timekeeping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timekeeping`
--

LOCK TABLES `timekeeping` WRITE;
/*!40000 ALTER TABLE `timekeeping` DISABLE KEYS */;
INSERT INTO `timekeeping` VALUES (1,7,'2023-04-13 23:10:43'),(2,6,'2023-04-13 23:10:45'),(3,5,'2023-04-13 23:10:50'),(4,4,'2023-04-13 23:10:52'),(5,3,'2023-04-13 23:10:54'),(8,7,'2023-04-16 14:50:58'),(9,6,'2023-04-16 14:51:00'),(10,5,'2023-04-16 14:51:02'),(11,7,'2023-06-07 21:53:19'),(12,6,'2023-06-07 21:53:22'),(13,5,'2023-06-07 21:53:25'),(14,4,'2023-06-07 21:53:27'),(15,3,'2023-06-07 21:53:30'),(16,2,'2023-06-07 21:53:33'),(17,7,'2023-06-06 21:53:19'),(18,6,'2023-06-06 21:53:22'),(19,5,'2023-06-06 21:53:25'),(20,4,'2023-06-06 21:53:27'),(21,3,'2023-06-06 21:53:30'),(22,2,'2023-06-06 21:53:33');
/*!40000 ALTER TABLE `timekeeping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 23:08:45
