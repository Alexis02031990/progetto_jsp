CREATE DATABASE  IF NOT EXISTS `sampledb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `sampledb`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: sampledb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `usertype` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

--
-- Table structure for table `Candidati`
--

DROP TABLE IF EXISTS `candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
 CREATE TABLE `candidati` (
  `idCandidati` INT NOT NULL AUTO_INCREMENT,
  `idStaff` INT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `luogoProvenienza` VARCHAR(45) NOT NULL,
  `numeroTelefono` INT(11) NOT NULL,
  `titoloStudio` VARCHAR(45) NOT NULL,
  `titoloLaurea` VARCHAR(45) NULL,
  `dataCandidatura` VARCHAR(45) NULL,
  `rangeCandidatura` VARCHAR(45) NULL,
  `colloquioConoscitivo` TINYINT NULL COMMENT 'boolean',
  `candidatiTramite` VARCHAR(100) NOT NULL,
  `idoneita` TINYINT NULL COMMENT 'boolean',
  `codiceFiscale` VARCHAR(16) NOT NULL,
  `userType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCandidati`),
  UNIQUE INDEX id_UNIQUE (`idCandidati` ASC),
  INDEX idStaff_idx (`idStaff` ASC),
  CONSTRAINT idStaff
    FOREIGN KEY (`idStaff`)
    REFERENCES sampledb.staff (`idStaff`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
  
    
)
ENGINE = InnoDB;
--
-- Table structure for table `Staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `idStaff` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `posizione` VARCHAR(45) NOT NULL,
  `numeroTelefono` INT(11) NOT NULL,
  `dataAssunzione` VARCHAR(45) NOT NULL,
  `sede` VARCHAR(45) NOT NULL,
  `oreSettimanali` INT(3) NOT NULL,
  `codiceFiscale` VARCHAR(16) NULL,
  PRIMARY KEY (`idStaff`))
ENGINE = InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Corso`
--

DROP TABLE IF EXISTS `corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
 CREATE TABLE `corso` (
  `idCorso` INT NOT NULL AUTO_INCREMENT,   
  `idCandidato` INT NOT NULL,
  `idIterSelettivo` INT NOT NULL,
  `argomentoCorso` VARCHAR(45) NOT NULL,
  `valutazioneComunicazioni` INT(3) NOT NULL,
  `valutazioneIntuitivita` INT(3) NOT NULL,
  `valutazioneAttitudine` INT(3) NOT NULL,
  `valutazioneTeamWork` INT(3) NOT NULL,
  `oreTotali` INT(5) NOT NULL,
  `idStaff` INT NOT NULL,
  `dataInizio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCorso`),
  CONSTRAINT idIterSelettivo
    FOREIGN KEY (`idIterSelettivo`)
    REFERENCES sampledb.iterselettivo (`idIterSelettivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB;

--
-- Table structure for table `IterSelettivo`
--

DROP TABLE IF EXISTS `iterselettivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
 CREATE TABLE `iterselettivo` (
  `idIterSelettivo` INT NOT NULL AUTO_INCREMENT,
  `idCandidato` INT NOT NULL,
  `idStaff` INT NOT NULL,
  `punteggioTotaleScritto` INT(3) NOT NULL COMMENT '0/100',
  `punteggioLogica` INT(3) NOT NULL,
  `punteggioPhp` INT(3) NOT NULL,
  `punteggioJava` INT(3) NOT NULL,
  `punteggioHTML` INT(3) NOT NULL,
  `punteggioInglese` INT(3) NOT NULL,
    `dataTestScritto` VARCHAR(45) NOT NULL, 
  `dataTestOrale` VARCHAR(45) NOT NULL,
  `valutazioneOrale` INT(3) NOT NULL COMMENT '0/100',
  PRIMARY KEY (`idIterSelettivo`),
  CONSTRAINT idCandidati
    FOREIGN KEY (`idCandidato`)
    REFERENCES sampledb.candidati (`idCandidati`)
    ON DELETE CASCADE
  )
ENGINE = InnoDB;





SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','ADMIN','admin',1),('user','USER','user',2);
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




-- Dump completed on 2019-06-12 13:10:18
