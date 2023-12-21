CREATE DATABASE  IF NOT EXISTS `baseball_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `baseball_db`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: baseball_db
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `loginId` varchar(20) NOT NULL,
  `loginPass` varchar(60) NOT NULL,
  `point` int DEFAULT NULL,
  `エナジードリンク` int DEFAULT NULL,
  `ドーピング` int DEFAULT NULL,
  UNIQUE KEY `idadmins_UNIQUE` (`loginId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('a','$2a$10$GKxzpPKaaQEmlThyHp84guFGjUW0DFmsXSIk7pIWlIcAojn3lbKae',0,2,2),('dafauit','aaa',0,2,2);
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aplayers`
--

DROP TABLE IF EXISTS `aplayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aplayers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teamId` int DEFAULT NULL,
  `birthday` date NOT NULL,
  `position` char(2) NOT NULL,
  `battingAverage` int NOT NULL,
  `stamina` int DEFAULT NULL,
  `salary` int NOT NULL,
  `feel` varchar(5) DEFAULT NULL,
  `defense` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplayers`
--

LOCK TABLES `aplayers` WRITE;
/*!40000 ALTER TABLE `aplayers` DISABLE KEYS */;
INSERT INTO `aplayers` VALUES (1,'松井秀喜',1,'1974-06-12','CF',10,NULL,1000,NULL,7),(2,'バース',2,'1954-03-13','1B',9,NULL,900,NULL,6),(3,'池山隆寛',3,'1965-12-17','SS',6,NULL,500,NULL,8),(4,'イースラー',4,'1960-12-12','2B',7,NULL,400,NULL,6),(5,'遠藤',5,'1983-08-12','P',2,5,100,NULL,7),(6,'仁志敏久',1,'1971-10-04','2B',7,NULL,500,NULL,8),(7,'後藤孝志',1,'1969-05-14','RF',6,NULL,400,NULL,8),(8,'川相昌弘',1,'1964-09-27','LF',6,NULL,400,NULL,7),(9,'落合博満',1,'1953-12-09','1B',10,NULL,800,NULL,7),(10,'清水隆行',1,'1973-10-23','RF',7,NULL,400,NULL,5),(11,'村田真一',1,'1963-12-05','C',6,NULL,400,NULL,7),(12,'シェーン・マック',1,'1963-12-07','CF',8,NULL,600,NULL,8),(13,'斎藤雅樹',1,'1965-02-18','P',8,9,700,NULL,10),(14,'矢野燿大',2,'1968-12-06','C',7,NULL,600,NULL,7),(15,'今岡誠',2,'1974-09-11','3B',7,NULL,600,NULL,7),(16,'鳥谷敬',2,'1981-06-26','SS',7,NULL,600,NULL,8),(17,'片岡',2,'1981-10-03','LF',7,NULL,600,NULL,7),(18,'赤星憲広',2,'1976-04-10','CF',7,NULL,650,NULL,8),(19,'桧山進次郎',2,'1969-07-01','RF',7,NULL,600,NULL,7),(20,'今岡誠',2,'0194-09-11','2B',7,NULL,600,NULL,7),(21,'藤浪晋太郎',2,'1994-04-12','P',2,6,900,NULL,5),(22,'古田敦也',3,'1965-08-06','C',8,NULL,800,NULL,9),(23,'ペタジーニ',3,'1971-06-02','1B',9,NULL,750,NULL,6),(24,'山田哲人',3,'1992-07-16','2B',9,NULL,750,NULL,9),(25,'岩村明憲',3,'1979-02-09','3B',8,NULL,700,NULL,8),(26,'宮本慎也',3,'1970-11-05','SS',6,NULL,550,NULL,9),(27,'ラミレス',3,'1974-10-03','LF',9,NULL,750,NULL,6),(28,'青木宣親',3,'1982-01-05','CF',8,NULL,750,NULL,8),(29,'バレンティン',3,'1984-07-02','RF',9,NULL,750,NULL,6),(30,'ダルビッシュ有',4,'1986-08-16','P',5,7,5,NULL,10),(31,'大谷翔平',4,'1994-07-05','3B',10,NULL,1500,NULL,10),(32,'高橋信二',4,'1978-08-07','C',7,NULL,600,NULL,7),(33,'小笠原道大',4,'1973-10-25','1B',8,NULL,750,NULL,7),(34,'稲葉篤紀',4,'1972-08-03','RF',8,NULL,750,NULL,8),(35,'SHINJO',4,'1972-01-28','CF',7,NULL,700,NULL,8),(36,'田中幸雄',4,'1967-12-14','SS',7,NULL,650,NULL,7),(37,'張本勲',4,'1940-06-19','LF',9,NULL,700,NULL,7),(38,'大豆畑',5,'1995-09-18','C',5,NULL,600,NULL,5),(39,'ARAMAKI',5,'1992-02-29','1B',5,NULL,600,NULL,5),(40,'池上',5,'1992-02-29','2B',5,NULL,600,NULL,5),(41,'一田',5,'1992-02-29','3B',5,NULL,600,NULL,5),(42,'稲田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(43,'大田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(44,'太田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(45,'豊田',5,'1992-02-29','RF',5,NULL,600,NULL,5),(46,'大下',5,'1985-01-01','P',5,7,600,NULL,5),(47,'中田',5,'1992-02-29','C',5,NULL,600,NULL,5),(48,'花田',5,'1992-02-29','1B',5,NULL,600,NULL,5),(49,'久田',5,'1992-02-29','2B',5,NULL,600,NULL,5),(50,'水田',5,'1984-02-29','3B',5,NULL,600,NULL,5),(51,'三田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(52,'森田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(53,'山田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(70,'相馬大輔',5,'1992-02-29','RF',10,NULL,1000,NULL,10);
/*!40000 ALTER TABLE `aplayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ateams`
--

DROP TABLE IF EXISTS `ateams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ateams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `established` date DEFAULT NULL,
  `victory` int NOT NULL,
  `win` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ateams`
--

LOCK TABLES `ateams` WRITE;
/*!40000 ALTER TABLE `ateams` DISABLE KEYS */;
INSERT INTO `ateams` VALUES (1,'巨大','東京ドーム','1934-12-16',38,0),(2,'半神ジャガーズ','阪神甲子園球場','1935-12-10',5,0),(3,'カルピススワローズ','明治神宮野球','1950-01-12',9,0),(4,'北海道日本スパムズ','エスコンフィールド','1945-11-06',7,0),(5,'新大久保ジードライブズ','西戸山公園野球場','2023-09-01',0,0);
/*!40000 ALTER TABLE `ateams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defaultplayers`
--

DROP TABLE IF EXISTS `defaultplayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defaultplayers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teamId` int DEFAULT NULL,
  `birthday` date NOT NULL,
  `position` char(2) NOT NULL,
  `battingAverage` int NOT NULL,
  `stamina` int DEFAULT NULL,
  `salary` int NOT NULL,
  `feel` varchar(5) DEFAULT NULL,
  `defense` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defaultplayers`
--

LOCK TABLES `defaultplayers` WRITE;
/*!40000 ALTER TABLE `defaultplayers` DISABLE KEYS */;
INSERT INTO `defaultplayers` VALUES (1,'松井秀喜',1,'1974-06-12','CF',10,NULL,1000,NULL,7),(2,'バース',2,'1954-03-13','1B',9,NULL,900,NULL,6),(3,'池山隆寛',3,'1965-12-17','SS',6,NULL,500,NULL,8),(4,'イースラー',4,'1960-12-12','2B',7,NULL,400,NULL,6),(5,'遠藤',5,'1983-08-12','P',2,5,100,NULL,7),(6,'仁志敏久',1,'1971-10-04','2B',7,NULL,500,NULL,8),(7,'後藤孝志',1,'1969-05-14','RF',6,NULL,400,NULL,8),(8,'川相昌弘',1,'1964-09-27','LF',6,NULL,400,NULL,7),(9,'落合博満',1,'1953-12-09','1B',10,NULL,800,NULL,7),(10,'清水隆行',1,'1973-10-23','RF',7,NULL,400,NULL,5),(11,'村田真一',1,'1963-12-05','C',6,NULL,400,NULL,7),(12,'シェーン・マック',1,'1963-12-07','CF',8,NULL,600,NULL,8),(13,'斎藤雅樹',1,'1965-02-18','P',8,9,700,NULL,10),(14,'矢野燿大',2,'1968-12-06','C',7,NULL,600,NULL,7),(15,'今岡誠',2,'1974-09-11','3B',7,NULL,600,NULL,7),(16,'鳥谷敬',2,'1981-06-26','SS',7,NULL,600,NULL,8),(17,'片岡',2,'1981-10-03','LF',7,NULL,600,NULL,7),(18,'赤星憲広',2,'1976-04-10','CF',7,NULL,650,NULL,8),(19,'桧山進次郎',2,'1969-07-01','RF',7,NULL,600,NULL,7),(20,'今岡誠',2,'0194-09-11','2B',7,NULL,600,NULL,7),(21,'藤浪晋太郎',2,'1994-04-12','P',2,6,900,NULL,5),(22,'古田敦也',3,'1965-08-06','C',8,NULL,800,NULL,9),(23,'ペタジーニ',3,'1971-06-02','1B',9,NULL,750,NULL,6),(24,'山田哲人',3,'1992-07-16','2B',9,NULL,750,NULL,9),(25,'岩村明憲',3,'1979-02-09','3B',8,NULL,700,NULL,8),(26,'宮本慎也',3,'1970-11-05','SS',6,NULL,550,NULL,9),(27,'ラミレス',3,'1974-10-03','LF',9,NULL,750,NULL,6),(28,'青木宣親',3,'1982-01-05','CF',8,NULL,750,NULL,8),(29,'バレンティン',3,'1984-07-02','RF',9,NULL,750,NULL,6),(30,'ダルビッシュ有',4,'1986-08-16','P',5,7,5,NULL,10),(31,'大谷翔平',4,'1994-07-05','3B',10,NULL,1500,NULL,10),(32,'高橋信二',4,'1978-08-07','C',7,NULL,600,NULL,7),(33,'小笠原道大',4,'1973-10-25','1B',8,NULL,750,NULL,7),(34,'稲葉篤紀',4,'1972-08-03','RF',8,NULL,750,NULL,8),(35,'SHINJO',4,'1972-01-28','CF',7,NULL,700,NULL,8),(36,'田中幸雄',4,'1967-12-14','SS',7,NULL,650,NULL,7),(37,'張本勲',4,'1940-06-19','LF',9,NULL,700,NULL,7),(38,'大豆畑',5,'1995-09-18','C',5,NULL,600,NULL,5),(39,'ARAMAKI',5,'1992-02-29','1B',5,NULL,600,NULL,5),(40,'池上',5,'1992-02-29','2B',5,NULL,600,NULL,5),(41,'一田',5,'1992-02-29','3B',5,NULL,600,NULL,5),(42,'稲田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(43,'大田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(44,'太田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(45,'豊田',5,'1992-02-29','RF',5,NULL,600,NULL,5),(46,'大下',5,'1985-01-01','P',5,7,600,NULL,5),(47,'中田',5,'1992-02-29','C',5,NULL,600,NULL,5),(48,'花田',5,'1992-02-29','1B',5,NULL,600,NULL,5),(49,'久田',5,'1992-02-29','2B',5,NULL,600,NULL,5),(50,'水田',5,'1984-02-29','3B',5,NULL,600,NULL,5),(51,'三田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(52,'森田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(53,'山田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(70,'相馬大輔',5,'1992-02-29','RF',10,NULL,1000,NULL,10);
/*!40000 ALTER TABLE `defaultplayers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defaultteams`
--

DROP TABLE IF EXISTS `defaultteams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defaultteams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `established` date DEFAULT NULL,
  `victory` int NOT NULL,
  `win` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defaultteams`
--

LOCK TABLES `defaultteams` WRITE;
/*!40000 ALTER TABLE `defaultteams` DISABLE KEYS */;
INSERT INTO `defaultteams` VALUES (1,'巨大','東京ドーム','1934-12-16',38,0),(2,'半神ジャガーズ','阪神甲子園球場','1935-12-10',5,0),(3,'カルピススワローズ','明治神宮野球','1950-01-12',9,0),(4,'北海道日本スパムズ','エスコンフィールド','1945-11-06',7,0),(5,'新大久保ジードライブズ','西戸山公園野球場','2023-09-01',0,0);
/*!40000 ALTER TABLE `defaultteams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` int NOT NULL,
  `detail` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'エナジードリンク',100,'飲むと体力が5P回復する'),(2,'ドーピング',1000,'使用すると攻撃力が一時的に5UPする。だが使用後は攻撃力が2下がってしまう。');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teamId` int DEFAULT NULL,
  `birthday` date NOT NULL,
  `position` char(2) NOT NULL,
  `battingAverage` int NOT NULL,
  `stamina` int DEFAULT NULL,
  `salary` int NOT NULL,
  `feel` varchar(5) DEFAULT NULL,
  `defense` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'松井秀喜',1,'1974-06-12','CF',10,NULL,1000,NULL,7),(2,'バース',2,'1954-03-13','1B',9,NULL,900,NULL,6),(3,'池山隆寛',3,'1965-12-17','SS',6,NULL,500,NULL,8),(4,'イースラー',4,'1960-12-12','2B',7,NULL,400,NULL,6),(5,'遠藤',5,'1983-08-12','P',2,5,100,NULL,7),(6,'仁志敏久',1,'1971-10-04','2B',7,NULL,500,NULL,8),(7,'後藤孝志',1,'1969-05-14','RF',6,NULL,400,NULL,8),(8,'川相昌弘',1,'1964-09-27','LF',6,NULL,400,NULL,7),(9,'落合博満',1,'1953-12-09','1B',10,NULL,800,NULL,7),(10,'清水隆行',1,'1973-10-23','RF',7,NULL,400,NULL,5),(11,'村田真一',1,'1963-12-05','C',6,NULL,400,NULL,7),(12,'シェーン・マック',1,'1963-12-07','CF',8,NULL,600,NULL,8),(13,'斎藤雅樹',1,'1965-02-18','P',8,9,700,NULL,10),(14,'矢野燿大',2,'1968-12-06','C',7,NULL,600,NULL,7),(15,'今岡誠',2,'1974-09-11','3B',7,NULL,600,NULL,7),(16,'鳥谷敬',2,'1981-06-26','SS',7,NULL,600,NULL,8),(17,'片岡',2,'1981-10-03','LF',7,NULL,600,NULL,7),(18,'赤星憲広',2,'1976-04-10','CF',7,NULL,650,NULL,8),(19,'桧山進次郎',2,'1969-07-01','RF',7,NULL,600,NULL,7),(20,'今岡誠',2,'0194-09-11','2B',7,NULL,600,NULL,7),(21,'藤浪晋太郎',2,'1994-04-12','P',2,6,900,NULL,5),(22,'古田敦也',3,'1965-08-06','C',8,NULL,800,NULL,9),(23,'ペタジーニ',3,'1971-06-02','1B',9,NULL,750,NULL,6),(24,'山田哲人',3,'1992-07-16','2B',9,NULL,750,NULL,9),(25,'岩村明憲',3,'1979-02-09','3B',8,NULL,700,NULL,8),(26,'宮本慎也',3,'1970-11-05','SS',6,NULL,550,NULL,9),(27,'ラミレス',3,'1974-10-03','LF',9,NULL,750,NULL,6),(28,'青木宣親',3,'1982-01-05','CF',8,NULL,750,NULL,8),(29,'バレンティン',3,'1984-07-02','RF',9,NULL,750,NULL,6),(30,'ダルビッシュ有',4,'1986-08-16','P',5,7,5,NULL,10),(31,'大谷翔平',4,'1994-07-05','3B',10,NULL,1500,NULL,10),(32,'高橋信二',4,'1978-08-07','C',7,NULL,600,NULL,7),(33,'小笠原道大',4,'1973-10-25','1B',8,NULL,750,NULL,7),(34,'稲葉篤紀',4,'1972-08-03','RF',8,NULL,750,NULL,8),(35,'SHINJO',4,'1972-01-28','CF',7,NULL,700,NULL,8),(36,'田中幸雄',4,'1967-12-14','SS',7,NULL,650,NULL,7),(37,'張本勲',4,'1940-06-19','LF',9,NULL,700,NULL,7),(38,'大豆畑',5,'1995-09-18','C',5,NULL,600,'普通',5),(39,'ARAMAKI',5,'1992-02-29','1B',5,NULL,600,'普通',5),(40,'池上',5,'1992-02-29','2B',5,NULL,600,'絶不調',5),(41,'一田',5,'1992-02-29','3B',5,NULL,600,'好調',5),(42,'稲田',5,'1992-02-29','SS',5,NULL,600,'好調',5),(43,'大田',5,'1992-02-29','LF',5,NULL,600,'絶不調',5),(44,'太田',5,'1992-02-29','CF',5,NULL,600,'絶不調',5),(45,'豊田',5,'1992-02-29','RF',5,NULL,600,'絶好調',5),(46,'大下',5,'1985-01-01','P',5,7,600,NULL,5),(47,'中田',5,'1992-02-29','C',5,NULL,600,'普通',5),(48,'花田',5,'1992-02-29','1B',5,NULL,600,'不調',5),(49,'久田',5,'1992-02-29','2B',5,NULL,600,'不調',5),(50,'水田',5,'1984-02-29','3B',5,NULL,600,'好調',5),(51,'三田',5,'1992-02-29','SS',5,NULL,600,'絶好調',5),(52,'森田',5,'1992-02-29','LF',5,NULL,600,'好調',5),(53,'山田',5,'1992-02-29','CF',5,NULL,600,'普通',5),(70,'相馬大輔',5,'1992-02-29','RF',10,NULL,1000,'普通',10);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players2`
--

DROP TABLE IF EXISTS `players2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teamId` int DEFAULT NULL,
  `birthday` date NOT NULL,
  `position` char(2) NOT NULL,
  `battingAverage` int NOT NULL,
  `stamina` int DEFAULT NULL,
  `salary` int NOT NULL,
  `feel` varchar(5) DEFAULT NULL,
  `defense` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players2`
--

LOCK TABLES `players2` WRITE;
/*!40000 ALTER TABLE `players2` DISABLE KEYS */;
INSERT INTO `players2` VALUES (1,'松井秀喜',1,'1974-06-12','CF',10,NULL,1000,NULL,7),(2,'バース',2,'1954-03-13','1B',9,NULL,900,NULL,6),(3,'池山隆寛',3,'1965-12-17','SS',6,NULL,500,NULL,8),(4,'イースラー',4,'1960-12-12','2B',7,NULL,400,NULL,6),(5,'遠藤',5,'1983-08-12','P',2,5,100,NULL,7),(6,'仁志敏久',1,'1971-10-04','2B',7,NULL,500,NULL,8),(7,'後藤孝志',1,'1969-05-14','RF',6,NULL,400,NULL,8),(8,'川相昌弘',1,'1964-09-27','LF',6,NULL,400,NULL,7),(9,'落合博満',1,'1953-12-09','1B',10,NULL,800,NULL,7),(10,'清水隆行',1,'1973-10-23','RF',7,NULL,400,NULL,5),(11,'村田真一',1,'1963-12-05','C',6,NULL,400,NULL,7),(12,'シェーン・マック',1,'1963-12-07','CF',8,NULL,600,NULL,8),(13,'斎藤雅樹',1,'1965-02-18','P',8,9,700,NULL,10),(14,'矢野燿大',2,'1968-12-06','C',7,NULL,600,NULL,7),(15,'今岡誠',2,'1974-09-11','3B',7,NULL,600,NULL,7),(16,'鳥谷敬',2,'1981-06-26','SS',7,NULL,600,NULL,8),(17,'片岡',2,'1981-10-03','LF',7,NULL,600,NULL,7),(18,'赤星憲広',2,'1976-04-10','CF',7,NULL,650,NULL,8),(19,'桧山進次郎',2,'1969-07-01','RF',7,NULL,600,NULL,7),(20,'今岡誠',2,'0194-09-11','2B',7,NULL,600,NULL,7),(21,'藤浪晋太郎',2,'1994-04-12','P',2,6,900,NULL,5),(22,'古田敦也',3,'1965-08-06','C',8,NULL,800,NULL,9),(23,'ペタジーニ',3,'1971-06-02','1B',9,NULL,750,NULL,6),(24,'山田哲人',3,'1992-07-16','2B',9,NULL,750,NULL,9),(25,'岩村明憲',3,'1979-02-09','3B',8,NULL,700,NULL,8),(26,'宮本慎也',3,'1970-11-05','SS',6,NULL,550,NULL,9),(27,'ラミレス',3,'1974-10-03','LF',9,NULL,750,NULL,6),(28,'青木宣親',3,'1982-01-05','CF',8,NULL,750,NULL,8),(29,'バレンティン',3,'1984-07-02','RF',9,NULL,750,NULL,6),(30,'ダルビッシュ有',4,'1986-08-16','P',5,7,5,NULL,10),(31,'大谷翔平',4,'1994-07-05','3B',10,NULL,1500,NULL,10),(32,'高橋信二',4,'1978-08-07','C',7,NULL,600,NULL,7),(33,'小笠原道大',4,'1973-10-25','1B',8,NULL,750,NULL,7),(34,'稲葉篤紀',4,'1972-08-03','RF',8,NULL,750,NULL,8),(35,'SHINJO',4,'1972-01-28','CF',7,NULL,700,NULL,8),(36,'田中幸雄',4,'1967-12-14','SS',7,NULL,650,NULL,7),(37,'張本勲',4,'1940-06-19','LF',9,NULL,700,NULL,7),(38,'大豆畑',5,'1995-09-18','C',5,NULL,600,NULL,5),(39,'ARAMAKI',5,'1992-02-29','1B',5,NULL,600,NULL,5),(40,'池上',5,'1992-02-29','2B',5,NULL,600,NULL,5),(41,'一田',5,'1992-02-29','3B',5,NULL,600,NULL,5),(42,'稲田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(43,'大田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(44,'太田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(45,'豊田',5,'1992-02-29','RF',5,NULL,600,NULL,5),(46,'大下',5,'1985-01-01','P',5,7,600,NULL,5),(47,'中田',5,'1992-02-29','C',5,NULL,600,NULL,5),(48,'花田',5,'1992-02-29','1B',5,NULL,600,NULL,5),(49,'久田',5,'1992-02-29','2B',5,NULL,600,NULL,5),(50,'水田',5,'1984-02-29','3B',5,NULL,600,NULL,5),(51,'三田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(52,'森田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(53,'山田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(54,'相馬大輔',5,'1990-09-09','RF',10,NULL,1000,NULL,10);
/*!40000 ALTER TABLE `players2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players3`
--

DROP TABLE IF EXISTS `players3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teamId` int DEFAULT NULL,
  `birthday` date NOT NULL,
  `position` char(2) NOT NULL,
  `battingAverage` int NOT NULL,
  `stamina` int DEFAULT NULL,
  `salary` int NOT NULL,
  `feel` varchar(5) DEFAULT NULL,
  `defense` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players3`
--

LOCK TABLES `players3` WRITE;
/*!40000 ALTER TABLE `players3` DISABLE KEYS */;
INSERT INTO `players3` VALUES (1,'松井秀喜',1,'1974-06-12','CF',10,NULL,1000,NULL,7),(2,'バース',2,'1954-03-13','1B',9,NULL,900,NULL,6),(3,'池山隆寛',3,'1965-12-17','SS',6,NULL,500,NULL,8),(4,'イースラー',4,'1960-12-12','2B',7,NULL,400,NULL,6),(5,'遠藤',5,'1983-08-12','P',2,5,100,NULL,7),(6,'仁志敏久',1,'1971-10-04','2B',7,NULL,500,NULL,8),(7,'後藤孝志',1,'1969-05-14','RF',6,NULL,400,NULL,8),(8,'川相昌弘',1,'1964-09-27','LF',6,NULL,400,NULL,7),(9,'落合博満',1,'1953-12-09','1B',10,NULL,800,NULL,7),(10,'清水隆行',1,'1973-10-23','RF',7,NULL,400,NULL,5),(11,'村田真一',1,'1963-12-05','C',6,NULL,400,NULL,7),(12,'シェーン・マック',1,'1963-12-07','CF',8,NULL,600,NULL,8),(13,'斎藤雅樹',1,'1965-02-18','P',8,9,700,NULL,10),(14,'矢野燿大',2,'1968-12-06','C',7,NULL,600,NULL,7),(15,'今岡誠',2,'1974-09-11','3B',7,NULL,600,NULL,7),(16,'鳥谷敬',2,'1981-06-26','SS',7,NULL,600,NULL,8),(17,'片岡',2,'1981-10-03','LF',7,NULL,600,NULL,7),(18,'赤星憲広',2,'1976-04-10','CF',7,NULL,650,NULL,8),(19,'桧山進次郎',2,'1969-07-01','RF',7,NULL,600,NULL,7),(20,'今岡誠',2,'0194-09-11','2B',7,NULL,600,NULL,7),(21,'藤浪晋太郎',2,'1994-04-12','P',2,6,900,NULL,5),(22,'古田敦也',3,'1965-08-06','C',8,NULL,800,NULL,9),(23,'ペタジーニ',3,'1971-06-02','1B',9,NULL,750,NULL,6),(24,'山田哲人',3,'1992-07-16','2B',9,NULL,750,NULL,9),(25,'岩村明憲',3,'1979-02-09','3B',8,NULL,700,NULL,8),(26,'宮本慎也',3,'1970-11-05','SS',6,NULL,550,NULL,9),(27,'ラミレス',3,'1974-10-03','LF',9,NULL,750,NULL,6),(28,'青木宣親',3,'1982-01-05','CF',8,NULL,750,NULL,8),(29,'バレンティン',3,'1984-07-02','RF',9,NULL,750,NULL,6),(30,'ダルビッシュ有',4,'1986-08-16','P',5,7,5,NULL,10),(31,'大谷翔平',4,'1994-07-05','3B',10,NULL,1500,NULL,10),(32,'高橋信二',4,'1978-08-07','C',7,NULL,600,NULL,7),(33,'小笠原道大',4,'1973-10-25','1B',8,NULL,750,NULL,7),(34,'稲葉篤紀',4,'1972-08-03','RF',8,NULL,750,NULL,8),(35,'SHINJO',4,'1972-01-28','CF',7,NULL,700,NULL,8),(36,'田中幸雄',4,'1967-12-14','SS',7,NULL,650,NULL,7),(37,'張本勲',4,'1940-06-19','LF',9,NULL,700,NULL,7),(38,'大豆畑',5,'1995-09-18','C',5,NULL,600,NULL,5),(39,'ARAMAKI',5,'1992-02-29','1B',5,NULL,600,NULL,5),(40,'池上',5,'1992-02-29','2B',5,NULL,600,NULL,5),(41,'一田',5,'1992-02-29','3B',5,NULL,600,NULL,5),(42,'稲田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(43,'大田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(44,'太田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(45,'豊田',5,'1992-02-29','RF',5,NULL,600,NULL,5),(46,'大下',5,'1985-01-01','P',5,7,600,NULL,5),(47,'中田',5,'1992-02-29','C',5,NULL,600,NULL,5),(48,'花田',5,'1992-02-29','1B',5,NULL,600,NULL,5),(49,'久田',5,'1992-02-29','2B',5,NULL,600,NULL,5),(50,'水田',5,'1984-02-29','3B',5,NULL,600,NULL,5),(51,'三田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(52,'森田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(53,'山田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(54,'相馬大輔',5,'1990-02-18','RF',10,NULL,1000,NULL,10);
/*!40000 ALTER TABLE `players3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players4`
--

DROP TABLE IF EXISTS `players4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players4` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teamId` int DEFAULT NULL,
  `birthday` date NOT NULL,
  `position` char(2) NOT NULL,
  `battingAverage` int NOT NULL,
  `stamina` int DEFAULT NULL,
  `salary` int NOT NULL,
  `feel` varchar(5) DEFAULT NULL,
  `defense` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players4`
--

LOCK TABLES `players4` WRITE;
/*!40000 ALTER TABLE `players4` DISABLE KEYS */;
INSERT INTO `players4` VALUES (1,'松井秀喜',1,'1974-06-12','CF',10,NULL,1000,NULL,7),(2,'バース',2,'1954-03-13','1B',9,NULL,900,NULL,6),(3,'池山隆寛',3,'1965-12-17','SS',6,NULL,500,NULL,8),(4,'イースラー',4,'1960-12-12','2B',7,NULL,400,NULL,6),(5,'遠藤',5,'1983-08-12','P',2,5,100,NULL,7),(6,'仁志敏久',1,'1971-10-04','2B',7,NULL,500,NULL,8),(7,'後藤孝志',1,'1969-05-14','RF',6,NULL,400,NULL,8),(8,'川相昌弘',1,'1964-09-27','LF',6,NULL,400,NULL,7),(9,'落合博満',1,'1953-12-09','1B',10,NULL,800,NULL,7),(10,'清水隆行',1,'1973-10-23','RF',7,NULL,400,NULL,5),(11,'村田真一',1,'1963-12-05','C',6,NULL,400,NULL,7),(12,'シェーン・マック',1,'1963-12-07','CF',8,NULL,600,NULL,8),(13,'斎藤雅樹',1,'1965-02-18','P',8,9,700,NULL,10),(14,'矢野燿大',2,'1968-12-06','C',7,NULL,600,NULL,7),(15,'今岡誠',2,'1974-09-11','3B',7,NULL,600,NULL,7),(16,'鳥谷敬',2,'1981-06-26','SS',7,NULL,600,NULL,8),(17,'片岡',2,'1981-10-03','LF',7,NULL,600,NULL,7),(18,'赤星憲広',2,'1976-04-10','CF',7,NULL,650,NULL,8),(19,'桧山進次郎',2,'1969-07-01','RF',7,NULL,600,NULL,7),(20,'今岡誠',2,'0194-09-11','2B',7,NULL,600,NULL,7),(21,'藤浪晋太郎',2,'1994-04-12','P',2,6,900,NULL,5),(22,'古田敦也',3,'1965-08-06','C',8,NULL,800,NULL,9),(23,'ペタジーニ',3,'1971-06-02','1B',9,NULL,750,NULL,6),(24,'山田哲人',3,'1992-07-16','2B',9,NULL,750,NULL,9),(25,'岩村明憲',3,'1979-02-09','3B',8,NULL,700,NULL,8),(26,'宮本慎也',3,'1970-11-05','SS',6,NULL,550,NULL,9),(27,'ラミレス',3,'1974-10-03','LF',9,NULL,750,NULL,6),(28,'青木宣親',3,'1982-01-05','CF',8,NULL,750,NULL,8),(29,'バレンティン',3,'1984-07-02','RF',9,NULL,750,NULL,6),(30,'ダルビッシュ有',4,'1986-08-16','P',5,7,5,NULL,10),(31,'大谷翔平',4,'1994-07-05','3B',10,NULL,1500,NULL,10),(32,'高橋信二',4,'1978-08-07','C',7,NULL,600,NULL,7),(33,'小笠原道大',4,'1973-10-25','1B',8,NULL,750,NULL,7),(34,'稲葉篤紀',4,'1972-08-03','RF',8,NULL,750,NULL,8),(35,'SHINJO',4,'1972-01-28','CF',7,NULL,700,NULL,8),(36,'田中幸雄',4,'1967-12-14','SS',7,NULL,650,NULL,7),(37,'張本勲',4,'1940-06-19','LF',9,NULL,700,NULL,7),(38,'大豆畑',5,'1995-09-18','C',5,NULL,600,NULL,5),(39,'ARAMAKI',5,'1992-02-29','1B',5,NULL,600,NULL,5),(40,'池上',5,'1992-02-29','2B',5,NULL,600,NULL,5),(41,'一田',5,'1992-02-29','3B',5,NULL,600,NULL,5),(42,'稲田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(43,'大田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(44,'太田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(45,'豊田',5,'1992-02-29','RF',5,NULL,600,NULL,5),(46,'大下',5,'1985-01-01','P',5,7,600,NULL,5),(47,'中田',5,'1992-02-29','C',5,NULL,600,NULL,5),(48,'花田',5,'1992-02-29','1B',5,NULL,600,NULL,5),(49,'久田',5,'1992-02-29','2B',5,NULL,600,NULL,5),(50,'水田',5,'1984-02-29','3B',5,NULL,600,NULL,5),(51,'三田',5,'1992-02-29','SS',5,NULL,600,NULL,5),(52,'森田',5,'1992-02-29','LF',5,NULL,600,NULL,5),(53,'山田',5,'1992-02-29','CF',5,NULL,600,NULL,5),(54,'相馬大輔',5,'1992-02-29','RF',10,NULL,1000,NULL,10);
/*!40000 ALTER TABLE `players4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `established` date DEFAULT NULL,
  `victory` int NOT NULL,
  `win` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'巨大','東京ドーム','1934-12-16',38,0),(2,'半神ジャガーズ','阪神甲子園球場','1935-12-10',5,0),(3,'カルピススワローズ','明治神宮野球','1950-01-12',9,0),(4,'北海道日本スパムズ','エスコンフィールド','1945-11-06',7,0),(5,'新大久保ジードライブズ','西戸山公園野球場','2023-09-01',0,0);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams2`
--

DROP TABLE IF EXISTS `teams2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `established` date DEFAULT NULL,
  `victory` int NOT NULL,
  `win` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams2`
--

LOCK TABLES `teams2` WRITE;
/*!40000 ALTER TABLE `teams2` DISABLE KEYS */;
INSERT INTO `teams2` VALUES (1,'巨大','東京ドーム','1934-12-16',38,0),(2,'半神ジャガーズ','阪神甲子園球場','1935-12-10',5,0),(3,'カルピススワローズ','明治神宮野球','1950-01-12',9,0),(4,'北海道日本スパムズ','エスコンフィールド','1945-11-06',7,0),(5,'新大久保ジードライブズ','西戸山公園野球場','2023-09-01',0,0);
/*!40000 ALTER TABLE `teams2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams3`
--

DROP TABLE IF EXISTS `teams3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `established` date DEFAULT NULL,
  `victory` int NOT NULL,
  `win` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams3`
--

LOCK TABLES `teams3` WRITE;
/*!40000 ALTER TABLE `teams3` DISABLE KEYS */;
INSERT INTO `teams3` VALUES (1,'巨大','東京ドーム','1934-12-16',38,0),(2,'半神ジャガーズ','阪神甲子園球場','1935-12-10',5,0),(3,'カルピススワローズ','明治神宮野球','1950-01-12',9,0),(4,'北海道日本スパムズ','エスコンフィールド','1945-11-06',7,0),(5,'新大久保ジードライブズ','西戸山公園野球場','2023-09-01',0,0);
/*!40000 ALTER TABLE `teams3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams4`
--

DROP TABLE IF EXISTS `teams4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams4` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `place` varchar(100) DEFAULT NULL,
  `established` date DEFAULT NULL,
  `victory` int NOT NULL,
  `win` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams4`
--

LOCK TABLES `teams4` WRITE;
/*!40000 ALTER TABLE `teams4` DISABLE KEYS */;
INSERT INTO `teams4` VALUES (1,'巨大','東京ドーム','1934-12-16',38,0),(2,'半神ジャガーズ','阪神甲子園球場','1935-12-10',5,0),(3,'カルピススワローズ','明治神宮野球','1950-01-12',9,0),(4,'北海道日本スパムズ','エスコンフィールド','1945-11-06',7,0),(5,'新大久保ジードライブズ','西戸山公園野球場','2023-09-01',0,0);
/*!40000 ALTER TABLE `teams4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'baseball_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-21 10:31:04
