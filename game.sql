-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 07, 2019 at 02:13 PM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `game`
--

-- --------------------------------------------------------

--
-- Table structure for table `abilities`
--

CREATE TABLE `abilities` (
  `id` int(11) NOT NULL,
  `ability` varchar(25) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `abilities`
--

INSERT INTO `abilities` (`id`, `ability`, `description`) VALUES
(1, 'Ice Block', 'Encases you in a block of ice, protecting you from all attacks and damage for 10 sec, but during that time you cannot attack, move, or cast spells.\r\nCauses Hypothermia, preventing you from recasting Ice Block for 30 sec.'),
(2, 'Blink', 'Teleports you forward 20 yds or until reaching an obstacle, and frees you from all stuns and bonds.'),
(3, 'Frostbolt', 'Launches a bolt of frost at the enemy, causing (51.1% of Spell power) Frost damage and slowing movement speed by 50% for 8 sec.'),
(4, 'Feign Death', 'Feign death, tricking enemies into ignoring you. Lasts up to 6 min.'),
(5, 'Counter Shot', 'Interrupts spellcasting, preventing any spell in that school from being cast for 3 sec.'),
(6, 'Kill Command', 'Give the command to kill, causing your pet to savagely deal (225%-450% of RAP) Physical damage to its target. 25 yard range.'),
(7, 'Hearthstone', 'Returns you to <Hearthstone Location>. Speak to an Innkeeper in a different place to change your home location. (30 Min Cooldown)'),
(8, 'Divine Shield', 'Protects you from all damage and spells for 8 sec. Cannot be used if you have Forbearance. Causes Forbearance for 30 sec.'),
(9, 'Moonfire', 'A quick beam of lunar light burns the enemy for (110% of spell power) Arcane damage and then an additional (400% of spell power) Arcane damage over 16 sec. Usable while in Bear Form.'),
(10, 'Fear', 'Strikes fear in the enemy, disorienting for 20 sec. Damage may cancel the effect. Limit 1.'),
(11, 'Charge', 'Charge to an enemy, reducing its movement speed by 50% for 6 sec.');

-- --------------------------------------------------------

--
-- Table structure for table `chars`
--

CREATE TABLE `chars` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `level` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `classID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chars`
--

INSERT INTO `chars` (`id`, `name`, `level`, `userID`, `classID`) VALUES
(1, 'Barkiller', 98, 1, 1),
(2, 'craigtheslayer', 100, 2, 3),
(3, 'bait', 15, 2, 2),
(4, 'pullraidbossBubbleHS', 88, 2, 3),
(5, 'blaster', 35, 1, 3),
(6, 'Silentkilla', 35, 4, 6);

-- --------------------------------------------------------

--
-- Table structure for table `classabilities`
--

CREATE TABLE `classabilities` (
  `id` int(11) NOT NULL,
  `abilityID` int(11) NOT NULL,
  `classID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classabilities`
--

INSERT INTO `classabilities` (`id`, `abilityID`, `classID`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 2),
(5, 5, 2),
(6, 6, 2),
(7, 7, 3),
(8, 8, 3),
(9, 9, 6),
(10, 10, 5),
(11, 11, 4);

-- --------------------------------------------------------

--
-- Table structure for table `classset`
--

CREATE TABLE `classset` (
  `id` int(11) NOT NULL,
  `className` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classset`
--

INSERT INTO `classset` (`id`, `className`) VALUES
(6, 'druid'),
(2, 'hunter'),
(1, 'mage'),
(3, 'paladin'),
(5, 'warlock'),
(4, 'warrior');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'warlord1337', 'balubammuma'),
(2, 'muskatel', 'muskatello25'),
(3, 'bartek799', 'testo'),
(4, 'emberwalker', 'amazingpasswordxxx');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abilities`
--
ALTER TABLE `abilities`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ability` (`ability`);

--
-- Indexes for table `chars`
--
ALTER TABLE `chars`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `userID` (`userID`),
  ADD KEY `classID` (`classID`);

--
-- Indexes for table `classabilities`
--
ALTER TABLE `classabilities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classID` (`classID`),
  ADD KEY `abilityID` (`abilityID`);

--
-- Indexes for table `classset`
--
ALTER TABLE `classset`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `className` (`className`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `abilities`
--
ALTER TABLE `abilities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `chars`
--
ALTER TABLE `chars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `classabilities`
--
ALTER TABLE `classabilities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `classset`
--
ALTER TABLE `classset`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chars`
--
ALTER TABLE `chars`
  ADD CONSTRAINT `chars_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `class_rule` FOREIGN KEY (`classID`) REFERENCES `classset` (`id`);

--
-- Constraints for table `classabilities`
--
ALTER TABLE `classabilities`
  ADD CONSTRAINT `classabilities_ibfk_1` FOREIGN KEY (`classID`) REFERENCES `classset` (`id`),
  ADD CONSTRAINT `classabilities_ibfk_2` FOREIGN KEY (`abilityID`) REFERENCES `abilities` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
