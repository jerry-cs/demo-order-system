CREATE DATABASE demo_order_system_db;
CREATE USER 'testuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'temp-password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON demo_order_system_db.* to 'testuser'@'localhost';