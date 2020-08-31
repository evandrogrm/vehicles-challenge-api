CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `mark_id` int(11) NOT NULL,
  `city_consume` NUMERIC(12,2) DEFAULT NULL,
  `highway_consume` NUMERIC(12,2) DEFAULT NULL,
  `fabrication` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_vehicle_mark_id` FOREIGN KEY (`mark_id`) REFERENCES `mark` (`id`)
);
