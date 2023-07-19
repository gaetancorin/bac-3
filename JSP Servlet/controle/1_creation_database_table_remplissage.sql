DROP DATABASE controlejsp;
CREATE DATABASE controlejsp;
use controlejsp;
CREATE TABLE `fruitslegumes`(
fruitslegumesid INT AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(30) NOT NULL,
activated BOOLEAN NOT NULL,
number INT NOT NULL
);

CREATE TABLE `commandes`(
commandesid INT AUTO_INCREMENT PRIMARY KEY,
sessionid INT NOT NULL,
nom VARCHAR(30) NOT NULL,
telephone VARCHAR(10) NOT NULL,
jour DATE NOT NULL
);

CREATE TABLE commandes_has_fruitslegumes (
    fruitslegumesid INT,
    commandesid INT,
    stock INT,
    PRIMARY KEY (fruitslegumesid , commandesid),
    FOREIGN KEY (fruitslegumesid)
        REFERENCES fruitslegumes (fruitslegumesid),
    FOREIGN KEY (commandesid)
        REFERENCES commandes (commandesid)
);

insert into fruitslegumes (fruitslegumesid, nom, activated, number) values
(1,'pomme', True, 4),
(2,'framboise',True, 12),
(3,'kiwi',False, 20),
(4,'abricot', True, 8),
(5, 'choux de bruxelles', True, 6),
(6, 'épinard', True, 12);

insert into commandes (commandesid, sessionid, nom, telephone, jour) values
(1, 0001, 'Albert', 0514578454, "2024-01-23"),
(2, 0002, 'Roger', 0558457485, "2024-02-23"),
(3, 0003,'Gerard', 0525645125, "2024-03-23"),
(4, 0004, 'Romuald', 0524578451, "2024-04-23"),
(5, 0005, 'Gertrude', 0545965854, "2024-05-23"),
(6, 0006, 'Patrick', 0521454125, "2024-06-23");

insert into commandes_has_fruitslegumes (fruitslegumesid, commandesid, stock) values
(1, 1, 2),
(2, 5, 3);
