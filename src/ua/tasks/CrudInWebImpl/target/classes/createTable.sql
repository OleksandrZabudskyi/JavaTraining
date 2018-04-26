-- Schema UserDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `UserDB` DEFAULT CHARACTER SET utf8 ;
USE `UserDB` ;

-- -----------------------------------------------------
-- Table `UserDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UserDB`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));





