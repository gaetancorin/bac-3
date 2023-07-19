DROP DATABASE jsp;
CREATE DATABASE jsp;
use jsp;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(30) NOT NULL,
  `code` bigint(20) NOT NULL
);

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `login` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `session_id` varchar(255) NOT NULL
);

INSERT INTO `teacher` (`id`, `name`, `code`) VALUES
(1, 'totoasas', 7),
(2, 'toto', 4);