--
-- Base de données : `ContratDeBail`
--

-- --------------------------------------------------------

--
-- Structure de la table `CITE`
--

CREATE TABLE `CITE` (
  `IDCITE` varchar(20) NOT NULL,
  `NUMPIECE` varchar(6) NOT NULL,
  `NOM` varchar(20) DEFAULT NULL,
  `ADRESSE` varchar(20) DEFAULT NULL,
  `NOMBREC` int(11) DEFAULT NULL,
  `NOMBRES` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `CONTRAT`
--

CREATE TABLE `CONTRAT` (
  `IDCONTRAT` varchar(20) NOT NULL DEFAULT '',
  `DATEDEBUT` date DEFAULT NULL,
  `DUREE` int(11) DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



--
-- Structure de la table `GERER`
--

CREATE TABLE `GERER` (
  `IDCITE` varchar(20) NOT NULL,
  `LOGIN` varchar(20) NOT NULL,
  `PWD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `LOCATAIRE`
--

CREATE TABLE `LOCATAIRE` (
  `NUMEROCNI` varchar(20) NOT NULL,
  `NUMPIECE` varchar(6) NOT NULL,
  `IDCONTRAT` varchar(20) NOT NULL,
  `NOM` varchar(20) DEFAULT NULL,
  `PRENOM` varchar(20) DEFAULT NULL,
  `DATENAISSANCE` date DEFAULT NULL,
  `SEXE` varchar(15) DEFAULT NULL,
  `PROFESSION` varchar(20) DEFAULT NULL,
  `STATUT_SOCIAL` varchar(20) DEFAULT NULL,
  `E_MAIL` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `PIECE`
--

CREATE TABLE `PIECE` (
  `NUMPIECE` varchar(6) NOT NULL,
  `TYPEPIECE` varchar(10) DEFAULT NULL,
  `TYPE` varchar(10) DEFAULT NULL,
  `PRIX` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `UTILISATEUR`
--

CREATE TABLE `UTILISATEUR` (
  `LOGIN` varchar(20) NOT NULL,
  `PWD` varchar(20) NOT NULL,
  `IDCONTRAT` varchar(20) DEFAULT NULL,
  `CON_IDCONTRAT` varchar(20) DEFAULT NULL,
  `CON_IDCONTRAT2` varchar(20) DEFAULT NULL,
  `NOM` varchar(40) DEFAULT NULL,
  `E_MAIL` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



--
-- Index pour la table `CITE`
--
ALTER TABLE `CITE`
  ADD PRIMARY KEY (`IDCITE`);


--
-- Index pour la table `CONTRAT`
--
ALTER TABLE `CONTRAT`
  ADD PRIMARY KEY (`IDCONTRAT`);

--
-- Index pour la table `GERER`
--
ALTER TABLE `GERER`
  ADD PRIMARY KEY (`IDCITE`,`LOGIN`,`PWD`);

--
-- Index pour la table `LOCATAIRE`
--
ALTER TABLE `LOCATAIRE`
  ADD PRIMARY KEY (`NUMEROCNI`);

--
-- Index pour la table `PIECE`
--
ALTER TABLE `PIECE`
  ADD PRIMARY KEY (`NUMPIECE`);

--
-- Index pour la table `UTILISATEUR`
--
ALTER TABLE `UTILISATEUR`
  ADD PRIMARY KEY (`LOGIN`,`PWD`);


