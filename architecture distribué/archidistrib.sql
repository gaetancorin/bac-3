CREATE DATABASE archidistrib;
use archidistrib;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `idclient` int(11) DEFAULT NULL,
  `idchauffeur` int(11) DEFAULT NULL,
  `datecourse` date NOT NULL,
  `tempstrajet` int(11) NOT NULL,
  `distance` int(11) NOT NULL
);

INSERT INTO `course` (`id`, `idclient`, `idchauffeur`, `datecourse`, `tempstrajet`, `distance`) VALUES
(1, 3, 2, '2023-07-20', 45, 20);

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `naissance` date NOT NULL,
  `inscription` date NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `naissance`, `inscription`, `type`) VALUES
(1, 'lenom', 'leprenom', '2022-12-12', '2023-06-13', 'motard'),
(2, 'nomchauffeur', 'prenomchauffeur', '2023-07-09', '2023-07-11', 'chauffeur'),
(3, 'nomclient', 'prenomclient', '2023-07-04', '2023-07-06', 'client');

ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
