--
-- Скрипт сгенерирован Devart dbForge Studio 2019 for MySQL, Версия 8.1.22.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 26.12.2022 22:33:02
-- Версия сервера: 5.6.51-log
-- Версия клиента: 4.1
--

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

--
-- Установка базы данных по умолчанию
--
USE my_shop;

--
-- Удалить таблицу `bucket`
--
DROP TABLE IF EXISTS bucket;

--
-- Удалить таблицу `product`
--
DROP TABLE IF EXISTS product;

--
-- Удалить таблицу `user`
--
DROP TABLE IF EXISTS user;

--
-- Установка базы данных по умолчанию
--
USE my_shop;

--
-- Создать таблицу `user`
--
CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) DEFAULT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  role varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 19,
AVG_ROW_LENGTH = 8192,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `product`
--
CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(255) NOT NULL,
  price decimal(19, 2) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 4,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать таблицу `bucket`
--
CREATE TABLE bucket (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_user int(11) NOT NULL,
  id_product int(11) NOT NULL,
  time_operation text NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 12,
AVG_ROW_LENGTH = 16384,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Создать внешний ключ
--
ALTER TABLE bucket
ADD CONSTRAINT id_product_FK FOREIGN KEY (id_product)
REFERENCES product (id) ON DELETE CASCADE;

--
-- Создать внешний ключ
--
ALTER TABLE bucket
ADD CONSTRAINT id_user_FK FOREIGN KEY (id_user)
REFERENCES user (id) ON DELETE CASCADE;

-- 
-- Вывод данных для таблицы user
--
INSERT INTO user VALUES
(1, 'masha', 'masha', 'masha', 'ADMINISTRATOR', '1'),
(17, 'vitaliktuhata@gmail.com', 'Vitalik', 'Scherbatyuk', 'ADMINISTRATOR', 'Zz123456!'),
(18, 'mama', 'Meow', 'Myrkova', 'USER', '2');

-- 
-- Вывод данных для таблицы product
--
INSERT INTO product VALUES
(3, 'rrrrr', 'asdasdcsadc', 23.00);

-- 
-- Вывод данных для таблицы bucket
--
INSERT INTO bucket VALUES
(11, 18, 3, '2022-12-25');

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;