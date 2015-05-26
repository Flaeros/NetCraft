SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE IF NOT EXISTS `attributes` (
  `attr_id` int(10) NOT NULL,
  `attr_type_id` int(10) NOT NULL,
  `attr_group_id` int(10) DEFAULT NULL,
  `name` varchar(300) NOT NULL,
  PRIMARY KEY (`attr_id`),
  KEY `attr_type_id` (`attr_type_id`),
  KEY `attr_group_id` (`attr_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `attr_groups` (
  `attr_group_id` int(10) NOT NULL,
  `name` varchar(300) NOT NULL,
  `tab` varchar(300) NOT NULL,
  PRIMARY KEY (`attr_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `attr_object_types` (
  `attr_id` int(10) NOT NULL,
  `object_type_id` int(10) NOT NULL,
  KEY `attr_id` (`attr_id`),
  KEY `object_type_id` (`object_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `objects` (
  `object_id` int(10) NOT NULL,
  `name` varchar(300) NOT NULL,
  `parent_id` int(10) NOT NULL DEFAULT '0',
  `object_type_id` int(10) NOT NULL,
  PRIMARY KEY (`object_id`),
  KEY `object_type_id` (`object_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `object_types` (
  `object_type_id` int(10) NOT NULL,
  `name` varchar(300) NOT NULL,
  `parent_id` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`object_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `params` (
  `attr_id` int(10) NOT NULL,
  `object_id` int(10) NOT NULL,
  `value` varchar(1000) NOT NULL,
  KEY `object_id` (`object_id`),
  KEY `attr_id` (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `referencess` (
  `attr_id` int(10) NOT NULL,
  `object_id` int(10) NOT NULL,
  `reference` int(10) NOT NULL,
  KEY `attr_id` (`attr_id`),
  KEY `object_id` (`object_id`),
  KEY `reference` (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Constraints for table `attributes`
--
ALTER TABLE `attributes`
  ADD CONSTRAINT `attributes_ibfk_1` FOREIGN KEY (`attr_group_id`) REFERENCES `attr_groups` (`attr_group_id`) ON DELETE SET NULL ON UPDATE NO ACTION;

--
-- Constraints for table `attr_object_types`
--
ALTER TABLE `attr_object_types`
  ADD CONSTRAINT `attr_object_types_ibfk_1` FOREIGN KEY (`attr_id`) REFERENCES `attributes` (`attr_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `attr_object_types_ibfk_2` FOREIGN KEY (`object_type_id`) REFERENCES `object_types` (`object_type_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `objects`
--
ALTER TABLE `objects`
  ADD CONSTRAINT `objects_ibfk_1` FOREIGN KEY (`object_type_id`) REFERENCES `object_types` (`object_type_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `params`
--
ALTER TABLE `params`
  ADD CONSTRAINT `params_ibfk_1` FOREIGN KEY (`attr_id`) REFERENCES `attributes` (`attr_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `params_ibfk_2` FOREIGN KEY (`object_id`) REFERENCES `objects` (`object_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

  
--
-- Constraints for table `referencess`
--
ALTER TABLE `referencess`
  ADD CONSTRAINT `referencess_ibfk_3` FOREIGN KEY (`reference`) REFERENCES `objects` (`object_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `referencess_ibfk_1` FOREIGN KEY (`attr_id`) REFERENCES `attributes` (`attr_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `referencess_ibfk_2` FOREIGN KEY (`object_id`) REFERENCES `objects` (`object_id`) ON DELETE CASCADE ON UPDATE NO ACTION;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
