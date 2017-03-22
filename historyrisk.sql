-- MySQL Script generated by MySQL Workbench
-- Wed Mar 22 07:21:25 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema historyrisk
-- -----------------------------------------------------
-- Banco de dados para armazenar os dados sobre o histórico de riscos em projetos.
DROP SCHEMA IF EXISTS `historyrisk` ;

-- -----------------------------------------------------
-- Schema historyrisk
--
-- Banco de dados para armazenar os dados sobre o histórico de riscos em projetos.
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `historyrisk` ;
SHOW WARNINGS;
USE `historyrisk` ;

-- -----------------------------------------------------
-- Table `historyrisk`.`TB_SETOR_EMPR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `historyrisk`.`TB_SETOR_EMPR` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `historyrisk`.`TB_SETOR_EMPR` (
  `ID_SETOR_EMPR` INT NOT NULL COMMENT 'Identificador único do setor da empresa.',
  `NM_SETOR_EMPR` VARCHAR(400) NOT NULL COMMENT 'Nome do setor da empresa.',
  PRIMARY KEY (`ID_SETOR_EMPR`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `historyrisk`.`TB_HRSK_PRJT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `historyrisk`.`TB_HRSK_PRJT` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `historyrisk`.`TB_HRSK_PRJT` (
  `ID_HRSK_PRJT` INT NOT NULL COMMENT 'Identificador único do projeto para gerenciamento de riscos.',
  `ID_SETOR_EMPR` INT NOT NULL,
  `DS_PRJT` VARCHAR(400) NOT NULL COMMENT 'Descrição do nome do projeto.',
  `DT_RGST_PRJT` DATETIME NOT NULL,
  PRIMARY KEY (`ID_HRSK_PRJT`),
  CONSTRAINT `FK_SETOR_EMPR_PRJT_01`
    FOREIGN KEY (`ID_SETOR_EMPR`)
    REFERENCES `historyrisk`.`TB_SETOR_EMPR` (`ID_SETOR_EMPR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `IX_PRJT_01` ON `historyrisk`.`TB_HRSK_PRJT` (`ID_SETOR_EMPR` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `historyrisk`.`TB_HRSK_FAIXA_PROB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `historyrisk`.`TB_HRSK_FAIXA_PROB` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `historyrisk`.`TB_HRSK_FAIXA_PROB` (
  `ID_FAIXA_PROB` INT NOT NULL,
  `DS_FAIXA_PROB` VARCHAR(400) NOT NULL,
  `NU_LMTE_INFR` INT(3) NOT NULL,
  `NU_LMTE_SUPR` INT(3) NOT NULL,
  PRIMARY KEY (`ID_FAIXA_PROB`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `historyrisk`.`TB_HRSK_CATG_RISCO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `historyrisk`.`TB_HRSK_CATG_RISCO` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `historyrisk`.`TB_HRSK_CATG_RISCO` (
  `ID_CATG_RISCO` INT NOT NULL COMMENT 'Identificador único do registro da categoria de risco.',
  `DS_CATG_RISCO` VARCHAR(400) NOT NULL COMMENT 'Descrição da categoria de risco.',
  PRIMARY KEY (`ID_CATG_RISCO`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `historyrisk`.`TB_HRSK_NIVEL_IPCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `historyrisk`.`TB_HRSK_NIVEL_IPCTO` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (
  `ID_NIVEL_IPCTO` INT NOT NULL,
  `NM_NIVEL_IPCTO` VARCHAR(100) NOT NULL,
  `DS_NIVEL_IPCTO` VARCHAR(400) NOT NULL,
  `IC_NIVEL_IPCTO` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`ID_NIVEL_IPCTO`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `historyrisk`.`TB_HRSK_RISCO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `historyrisk`.`TB_HRSK_RISCO` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `historyrisk`.`TB_HRSK_RISCO` (
  `ID_HRSK_RISCO` INT NOT NULL COMMENT 'Identificador único do risco na lista de risco.',
  `ID_FAIXA_PROB` INT NOT NULL,
  `ID_CATG_RISCO` INT NOT NULL,
  `ID_NIVEL_IPCTO` INT NOT NULL,
  `ID_HRSK_PRJT` INT NOT NULL COMMENT 'Identificador único do projeto para gerenciamento de riscos.',
  `VL_CUSTO_ESPRD_RISCO_NGTV` DECIMAL(10,2) NULL,
  `DS_RISCO` VARCHAR(400) NOT NULL COMMENT 'Descrição do risco identificado.',
  `VL_CUSTO_ESTMD_RISCO` DECIMAL(10,2) NULL,
  `VL_CUSTO_ESPRD_RISCO_PSTV` DECIMAL(10,2) NULL,
  `DT_INCS_RGST_RISCO` DATETIME NOT NULL,
  `DT_ALTR_RGST_RISCO` DATETIME NULL,
  PRIMARY KEY (`ID_HRSK_RISCO`),
  CONSTRAINT `FK_FAIXA_PROB_RISCO_01`
    FOREIGN KEY (`ID_FAIXA_PROB`)
    REFERENCES `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CATG_RISCO_02`
    FOREIGN KEY (`ID_CATG_RISCO`)
    REFERENCES `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_NIVEL_IPCTO_RISCO_03`
    FOREIGN KEY (`ID_NIVEL_IPCTO`)
    REFERENCES `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRJT_RISCO_04`
    FOREIGN KEY (`ID_HRSK_PRJT`)
    REFERENCES `historyrisk`.`TB_HRSK_PRJT` (`ID_HRSK_PRJT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `IX_RISCO1` ON `historyrisk`.`TB_HRSK_RISCO` (`ID_FAIXA_PROB` ASC);

SHOW WARNINGS;
CREATE INDEX `IX_RISCO2` ON `historyrisk`.`TB_HRSK_RISCO` (`ID_CATG_RISCO` ASC);

SHOW WARNINGS;
CREATE INDEX `IX_RISCO3` ON `historyrisk`.`TB_HRSK_RISCO` (`ID_NIVEL_IPCTO` ASC);

SHOW WARNINGS;
CREATE INDEX `IX_RISCO4` ON `historyrisk`.`TB_HRSK_RISCO` (`ID_HRSK_PRJT` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_SETOR_EMPR`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_SETOR_EMPR` (`ID_SETOR_EMPR`, `NM_SETOR_EMPR`) VALUES (1, 'TECNOLOGIA DA INFORMAÇÃO');

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_PRJT`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_PRJT` (`ID_HRSK_PRJT`, `ID_SETOR_EMPR`, `DS_PRJT`, `DT_RGST_PRJT`) VALUES (1, 1, 'PROJETO DE SOFTWARE XPTO', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_FAIXA_PROB`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`) VALUES (1, 'Acima de <90%> de probabilidade de ocorrência', 90, 100);
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`) VALUES (2, 'Entre <70%> e <90%> (inclusive) de probabilidade de ocorrência', 70, 90);
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`) VALUES (3, 'Entre <30%> e <70%> (inclusive) de probabilidade de ocorrência', 30, 70);
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`) VALUES (4, 'Abaixo de <30%> (inclusive) de probabilidade de ocorrência', 0, 30);

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_CATG_RISCO`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`) VALUES (1, 'Técnico');
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`) VALUES (2, 'Recursos Humanos');
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`) VALUES (3, 'Parte Interessada');
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`) VALUES (4, 'Organizacional');
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`) VALUES (5, 'Gestão de Projeto');
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`) VALUES (6, 'Externo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_NIVEL_IPCTO`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`) VALUES (1, 'Catastrófico', 'Risco potencial que impede o prosseguimento do projeto', '1');
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`) VALUES (2, 'Critico', 'Risco potencial que cria uma restrição no projeto, mas não impede de prosseguir', '2');
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`) VALUES (3, 'Marginal', 'Risco com potencial médio ou leve', '3');
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`) VALUES (4, 'Negligivel', 'Risco com impacto pequeno', '4');

COMMIT;

