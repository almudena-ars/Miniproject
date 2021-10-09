DROP SCHEMA IF EXISTS `demo` ;

CREATE SCHEMA IF NOT EXISTS `demo`;
USE `demo` ;

DROP TABLE IF EXISTS `demo`.`user` ;

CREATE TABLE IF NOT EXISTS `demo`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `user_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

DROP TABLE IF EXISTS `demo`.`admin` ;
CREATE TABLE IF NOT EXISTS `demo`.`admin` (
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `demo`.`user` (`id`));

DROP TABLE IF EXISTS `demo`.`third_party` ;
CREATE TABLE IF NOT EXISTS `demo`.`third_party` (
  `hashed_key` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `demo`.`user` (`id`));


DROP TABLE IF EXISTS `demo`.`role` ;
CREATE TABLE IF NOT EXISTS `demo`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT NULL DEFAULT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`user_id`) REFERENCES `demo`.`user` (`id`));


DROP TABLE IF EXISTS `demo`.`account_holder` ;
CREATE TABLE IF NOT EXISTS `demo`.`account_holder` (
  `date_of_birth` DATE NULL DEFAULT NULL,
  `mailing_city` VARCHAR(255) NULL DEFAULT NULL,
  `mailing_postal_code` VARCHAR(255) NULL DEFAULT NULL,
  `mailing_street` VARCHAR(255) NULL DEFAULT NULL,
  `primary_city` VARCHAR(255) NULL DEFAULT NULL,
  `primary_postal_code` VARCHAR(255) NULL DEFAULT NULL,
  `primary_street` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`id`) REFERENCES `demo`.`user` (`id`));

DROP TABLE IF EXISTS `demo`.`account` ;
CREATE TABLE IF NOT EXISTS `demo`.`account` (
  `account_id` BIGINT NOT NULL AUTO_INCREMENT,
  `balance_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `balance_currency` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `primary_owner` BIGINT NULL DEFAULT NULL,
  `secondary_owner` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  FOREIGN KEY (`secondary_owner`) REFERENCES `demo`.`account_holder` (`id`),
  FOREIGN KEY (`primary_owner`) REFERENCES `demo`.`account_holder` (`id`));


DROP TABLE IF EXISTS `demo`.`checking` ;
CREATE TABLE IF NOT EXISTS `demo`.`checking` (
  `creation_date` DATE NULL DEFAULT NULL,
  `minimum_balance_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `minimum_balance_currency` VARCHAR(255) NULL DEFAULT NULL,
  `monthly_maintenance_fee_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `monthly_maintenance_fee_currency` VARCHAR(255) NULL DEFAULT NULL,
  `penalty_fee_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `penalty_fee_currency` VARCHAR(255) NULL DEFAULT NULL,
  `secret_key` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `demo`.`account` (`account_id`));

DROP TABLE IF EXISTS `demo`.`student_checking` ;
CREATE TABLE IF NOT EXISTS `demo`.`student_checking` (
  `creation_date` DATE NULL DEFAULT NULL,
  `penalty_fee_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `penalty_fee_currency` VARCHAR(255) NULL DEFAULT NULL,
  `secret_key` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `demo`.`account` (`account_id`));


DROP TABLE IF EXISTS `demo`.`credit_card` ;
CREATE TABLE IF NOT EXISTS `demo`.`credit_card` (
  `amount_credit_limit` DECIMAL(19,2) NULL DEFAULT NULL,
  `currency_credit_limit` VARCHAR(255) NULL DEFAULT NULL,
  `amount_interest_rate` DECIMAL(19,2) NULL DEFAULT NULL,
  `currency_interest_rate` VARCHAR(255) NULL DEFAULT NULL,
  `amount_penalty_fee` DECIMAL(19,2) NULL DEFAULT NULL,
  `currency_penalty_fee` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `demo`.`account` (`account_id`));



DROP TABLE IF EXISTS `demo`.`savings` ;
CREATE TABLE IF NOT EXISTS `demo`.`savings` (
  `creation_date` DATE NULL DEFAULT NULL,
  `amount_interest_rate` DECIMAL(19,2) NULL DEFAULT NULL,
  `currency_interest_rate` VARCHAR(255) NULL DEFAULT NULL,
  `minimum_balance_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `minimum_balance_currency` VARCHAR(255) NULL DEFAULT NULL,
  `penalty_fee_amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `penalty_fee_currency` VARCHAR(255) NULL DEFAULT NULL,
  `secret_key` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `demo`.`account` (`account_id`));


DROP TABLE IF EXISTS `demo`.`transaction` ;
CREATE TABLE IF NOT EXISTS `demo`.`transaction` (
  `transaction_id` BIGINT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL DEFAULT NULL,
  `amount_quantity` DECIMAL(19,2) NULL DEFAULT NULL,
  `currency_quantity` VARCHAR(255) NULL DEFAULT NULL,
  `receiving_account` BIGINT NULL DEFAULT NULL,
  `sending_account` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  FOREIGN KEY (`receiving_account`) REFERENCES `demo`.`account` (`account_id`),
  FOREIGN KEY (`sending_account`) REFERENCES `demo`.`account` (`account_id`));
