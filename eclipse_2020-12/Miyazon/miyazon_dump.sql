-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: Miyazon
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `number` int DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `listing_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo11lwrntim28ye9u1q0hnvops` (`listing_id`),
  KEY `FKb5o626f86h46m4s7ms6ginnop` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listing`
--

DROP TABLE IF EXISTS `listing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `product_name` varchar(100) NOT NULL,
  `stock` int DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd5ij902be0h18ynxu2666xtkj` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listing`
--

LOCK TABLES `listing` WRITE;
/*!40000 ALTER TABLE `listing` DISABLE KEYS */;
INSERT INTO `listing` VALUES (1,'スポーツ・アウトドア','1B17528717B153526AB6ED66B2C9699DBF69731EFD8D71A958369E3E134DB47A.jpg','赤と黒。湘北の色です。',100,'バッシュ',1,1),(2,'インテリア・寝具・収納','8A4FACCA880B60CAADD72F89966937DBFA112EF5E6C6B944145BC23971424E4E.jpg','寝ることが趣味な方にオススメです。',500000,'マットレス',19,2),(3,'スポーツ・アウトドア','14EB130766F2EEEFE7EEB588D3177D2E23BD2024788EA2CE3438A68A166082D1.jpg','肌を黒くすることができます。',200000,'サーフボード',500,4),(4,'家電','D9209BE1285FA1670E70B5796F13E04E98308792625AE8D85B5CFB9E94B03172.jpg','海外留学の必需品です。',1000000,'自動翻訳機',0,5);
/*!40000 ALTER TABLE `listing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchases` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `number` int NOT NULL,
  `pay_method` varchar(255) NOT NULL,
  `listing_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK22cqrpugewlk2al8vto2fipu8` (`listing_id`),
  KEY `FKm0ndjymn9p747pfp4515pio8i` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
INSERT INTO `purchases` VALUES (1,'2021-02-14 16:04:02',1,'クレジットカード',4,6),(2,'2021-02-14 16:05:22',1,'銀行振込',2,3);
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `account_number` varchar(7) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `admin_flag` int NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `birthday` varchar(8) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `credit_card_company` varchar(255) DEFAULT NULL,
  `credit_card_number` varchar(16) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_r2bdsy4yqtkpssr475ch00bdr` (`account`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1031@gomail.com','1201031','普通','神奈川県平塚市１０３１－１',1,'湘北銀行','19740401','湘北','VISA','1031103110311031','桜木花道','85293B227B4AAE3DA03B30945E54CFBB47BDC551E169A0C0EEB20CC5569F989E','男','09010311031'),(2,'2222@gomail.com','2222222','普通','神奈川県平塚市２２２２－２２２',1,'湘北銀行','19750101','湘北','VISA','2222222222222222','流川楓','1EFAB919AA6A97AD69D39EFE8BFA617207FF6204DD4269096F80538CBB85D8F9','男','08022222222'),(3,'3333@gomail.com','3333333','普通','神奈川県平塚市３３３３－３３３３',0,'湘北銀行','1950303','湘北','JCB','3333333333333333','赤木晴子','A76B1EF2C89E03AC3C1EB18CAE2DF50E1F00F2EFB4F6322533DA3CE93FC241BD','女','08033333333'),(4,'4444@gomail.com','4444444','普通','神奈川県藤沢市４４４４－４４４４',1,'海南銀行','19720404','海南','American Express','4444444444444444','牧紳一','E98A8E5EBA265F5AA10AB9CCAA873FC2C3FA885B8CE75C71B205B4E4A39D479F','男','09044444444'),(5,'5555@gomail.com','5555555','普通','大阪府大阪市平野区５５５５－５５５５',1,'豊玉銀行','19720505','豊玉','VISA','5555555555555555','岸本実理','65415BB496534D0E314EDA1BF936680836E50353CBBFAFEF407195EAE38186AF','男','09055555555'),(6,'6666@gomail.com','6666666','普通','秋田県能代市６６６６－６６６６',1,'山王銀行','19730606','山王','MasterCard','6666666666666666','沢北栄治','409E46303F86EF5BB109210DF8035C9F12AD494113ABF58BD0D77272646F70D2','男','08066666666'),(7,'7777@gomail.com','7777777','普通','神奈川県鎌倉市７７７７－７７７７',0,'陵南銀行','19730707','陵南','American Express','7777777777777777','仙道彰','905B3B03C00B83912155448ADA8DDBD38AFA7BFD796C7F453B147313FC961923','男','08077777777');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-27 19:45:49
