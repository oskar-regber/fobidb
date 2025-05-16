-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 16. Mai 2025 um 11:09
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `fobidb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `anbieter`
--

CREATE TABLE `anbieter` (
  `Anbieter_Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `anbieter`
--

INSERT INTO `anbieter` (`Anbieter_Name`) VALUES
('Annedoreleber'),
('dwad'),
('test');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `fachbereiche`
--

CREATE TABLE `fachbereiche` (
  `FB_Name` varchar(255) NOT NULL,
  `FB_Leiter` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `fortbildungen`
--

CREATE TABLE `fortbildungen` (
  `Fortbildung_ID` int(11) NOT NULL,
  `Fortbildungstitel` varchar(255) NOT NULL,
  `Datum` datetime NOT NULL,
  `Kursleiter` varchar(255) NOT NULL,
  `Dauer_min` int(11) NOT NULL,
  `Anbieter_Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `fortbildungen`
--

INSERT INTO `fortbildungen` (`Fortbildung_ID`, `Fortbildungstitel`, `Datum`, `Kursleiter`, `Dauer_min`, `Anbieter_Name`) VALUES
(1, '', '2025-05-16 00:00:00', '', 100, ''),
(2, 'Test', '2025-05-14 00:00:00', 'Test', 101, ''),
(3, 'test', '2025-05-16 00:00:00', 'test', 100, ''),
(4, 'test', '2025-05-16 00:00:00', 'test', 100, ''),
(5, 'dwad', '2025-05-16 00:00:00', 'deadawda', 100, 'annedoreleber');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `name_short` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `training_time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `teacher`
--

INSERT INTO `teacher` (`id`, `surname`, `name`, `name_short`, `email`, `training_time`) VALUES
(1, 'Schubert', 'Simon', 'sb', 'simon.schubert@aloberlin.de', 45),
(2, 'Pommer', 'Dennis', 'pr', 'dennis.pommer@aloberlin.de', 45),
(3, 'Max', 'Mustermann', 'Mm', 'maxmuste@mail.com', 90);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `xkukfb`
--

CREATE TABLE `xkukfb` (
  `xKFB_ID` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `FB_Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `xkukfortbildungen`
--

CREATE TABLE `xkukfortbildungen` (
  `xKF_ID` int(11) NOT NULL,
  `Bewertung` int(11) NOT NULL,
  `AnsprechpartnerSein` tinyint(1) NOT NULL,
  `VorstellungFK` tinyint(1) NOT NULL,
  `MikroschulungAnbieten` tinyint(1) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `Fortbildung_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `anbieter`
--
ALTER TABLE `anbieter`
  ADD PRIMARY KEY (`Anbieter_Name`);

--
-- Indizes für die Tabelle `fachbereiche`
--
ALTER TABLE `fachbereiche`
  ADD PRIMARY KEY (`FB_Name`),
  ADD KEY `FB_Leiter` (`FB_Leiter`);

--
-- Indizes für die Tabelle `fortbildungen`
--
ALTER TABLE `fortbildungen`
  ADD PRIMARY KEY (`Fortbildung_ID`),
  ADD KEY `Anbieter_Name` (`Anbieter_Name`);

--
-- Indizes für die Tabelle `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `xkukfb`
--
ALTER TABLE `xkukfb`
  ADD PRIMARY KEY (`xKFB_ID`),
  ADD KEY `id` (`id`),
  ADD KEY `FB_Name` (`FB_Name`);

--
-- Indizes für die Tabelle `xkukfortbildungen`
--
ALTER TABLE `xkukfortbildungen`
  ADD PRIMARY KEY (`xKF_ID`),
  ADD KEY `id` (`id`),
  ADD KEY `Fortbildung_ID` (`Fortbildung_ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `fortbildungen`
--
ALTER TABLE `fortbildungen`
  MODIFY `Fortbildung_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT für Tabelle `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `xkukfb`
--
ALTER TABLE `xkukfb`
  MODIFY `xKFB_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `xkukfortbildungen`
--
ALTER TABLE `xkukfortbildungen`
  MODIFY `xKF_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `fachbereiche`
--
ALTER TABLE `fachbereiche`
  ADD CONSTRAINT `fachbereiche_ibfk_1` FOREIGN KEY (`FB_Leiter`) REFERENCES `teacher` (`id`);

--
-- Constraints der Tabelle `fortbildungen`
--
ALTER TABLE `fortbildungen`
  ADD CONSTRAINT `fortbildungen_ibfk_1` FOREIGN KEY (`Anbieter_Name`) REFERENCES `anbieter` (`Anbieter_Name`);

--
-- Constraints der Tabelle `xkukfb`
--
ALTER TABLE `xkukfb`
  ADD CONSTRAINT `xkukfb_ibfk_1` FOREIGN KEY (`id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `xkukfb_ibfk_2` FOREIGN KEY (`FB_Name`) REFERENCES `fachbereiche` (`FB_Name`);

--
-- Constraints der Tabelle `xkukfortbildungen`
--
ALTER TABLE `xkukfortbildungen`
  ADD CONSTRAINT `xkukfortbildungen_ibfk_1` FOREIGN KEY (`id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `xkukfortbildungen_ibfk_2` FOREIGN KEY (`Fortbildung_ID`) REFERENCES `fortbildungen` (`Fortbildung_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
