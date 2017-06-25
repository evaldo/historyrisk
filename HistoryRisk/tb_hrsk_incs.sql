-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 03-Jun-2017 às 03:25
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `historyrisk`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_hrsk_incs`
--

CREATE TABLE `tb_hrsk_incs` (
  `NU_MATR_INCS` int(11) NOT NULL,
  `NM_INCS` varchar(200) NOT NULL,
  `EMAIL_INCS` varchar(200) NOT NULL,
  `USR_INCS` varchar(20) NOT NULL,
  `PSW_INCS` varchar(12) NOT NULL,
  `DT_INCS` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_hrsk_incs`
--

INSERT INTO `tb_hrsk_incs` (`NU_MATR_INCS`, `NM_INCS`, `EMAIL_INCS`, `USR_INCS`, `PSW_INCS`, `DT_INCS`) VALUES
(1, 'George Talmo Vital Samarino', 'george.samarino@hotmail.com', 'george', '123456', '2017-05-01 00:00:00'),
(2, 'Mariana Chaves Souza', 'marianacsouza@gmail.com', 'mariana', '123123', '2017-05-20 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_hrsk_incs`
--
ALTER TABLE `tb_hrsk_incs`
  ADD PRIMARY KEY (`NU_MATR_INCS`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_hrsk_incs`
--
ALTER TABLE `tb_hrsk_incs`
  MODIFY `NU_MATR_INCS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
