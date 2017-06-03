SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_SETOR_EMPR`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_SETOR_EMPR` (`ID_SETOR_EMPR`, `NM_SETOR_EMPR`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (1, 'TECNOLOGIA DA INFORMAÇÃO', DEFAULT, DEFAULT, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_PRJT`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_PRJT` (`ID_HRSK_PRJT`, `ID_SETOR_EMPR`, `DS_PRJT`, `DT_RGST_PRJT`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (1, 1, 'PROJETO DE SOFTWARE XPTO', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_FAIXA_PROB`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (1, 'Acima de <90%> de probabilidade de ocorrência', 90, 100, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (2, 'Entre <70%> e <90%> (inclusive) de probabilidade de ocorrência', 70, 90, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (3, 'Entre <30%> e <70%> (inclusive) de probabilidade de ocorrência', 30, 70, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_FAIXA_PROB` (`ID_FAIXA_PROB`, `DS_FAIXA_PROB`, `NU_LMTE_INFR`, `NU_LMTE_SUPR`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (4, 'Abaixo de <30%> (inclusive) de probabilidade de ocorrência', 0, 30, DEFAULT, DEFAULT, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_CATG_RISCO`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (1, 'Técnico', NULL, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (2, 'Recursos Humanos', NULL, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (3, 'Parte Interessada', NULL, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (4, 'Organizacional', NULL, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (5, 'Gestão de Projeto', NULL, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_CATG_RISCO` (`ID_CATG_RISCO`, `DS_CATG_RISCO`, `NU_MATR_INCS`, `DT_INCS`, `NU_MATR_ALTR`, `DT_ALTR`) VALUES (6, 'Externo', NULL, DEFAULT, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `historyrisk`.`TB_HRSK_NIVEL_IPCTO`
-- -----------------------------------------------------
START TRANSACTION;
USE `historyrisk`;
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`, `VL_ASSC_NIVEL_IPCTO`, `NU_MATL_INCS`, `DT_INCS`, `NU_MATL_ALTR`, `DT_ALTR`) VALUES (1, 'Catastrófico', 'Risco potencial que impede o prosseguimento do projeto', '1', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`, `VL_ASSC_NIVEL_IPCTO`, `NU_MATL_INCS`, `DT_INCS`, `NU_MATL_ALTR`, `DT_ALTR`) VALUES (2, 'Critico', 'Risco potencial que cria uma restrição no projeto, mas não impede de prosseguir', '2', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`, `VL_ASSC_NIVEL_IPCTO`, `NU_MATL_INCS`, `DT_INCS`, `NU_MATL_ALTR`, `DT_ALTR`) VALUES (3, 'Marginal', 'Risco com potencial médio ou leve', '3', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO `historyrisk`.`TB_HRSK_NIVEL_IPCTO` (`ID_NIVEL_IPCTO`, `NM_NIVEL_IPCTO`, `DS_NIVEL_IPCTO`, `IC_NIVEL_IPCTO`, `VL_ASSC_NIVEL_IPCTO`, `NU_MATL_INCS`, `DT_INCS`, `NU_MATL_ALTR`, `DT_ALTR`) VALUES (4, 'Negligivel', 'Risco com impacto pequeno', '4', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);

COMMIT;
