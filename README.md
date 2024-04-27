Projet 9 formation développeur d'application java : Développez une solution en microservices pour votre client

1 - Vous trouverez ci-dessous les informations concernant le green code.

2 - Vous trouverez au niveau de la branche master le Readme technique de l'application.

![1](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/537f9a42-51fe-46da-8f26-589df481f9b8)

![2](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/f451f338-a465-428d-ae6e-30d2693bd6c3)
![3](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/32ee7b8b-4346-4e83-8806-d7e00be1cb9a)
![4](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/d0a39017-cea7-4ede-8ede-dd5014b60d05) 

Une fois l'application installé sur votre post de travaille

Crée les image Docker de chaque micro service :

- déplacé vous dans le fichier racine du service api-gateway 

![2](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/47d54cd5-0cfd-437e-8a28-9d8f0869b517)

![3](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/ec509426-8b64-49f2-807f-a0531c4fd272)

- Puis taper la commande suivante et apuillé sur entrée:

![2](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/5bc7ee0d-3eb4-4ef4-b838-2c1a74a02edf)

- Une fois fois l'opération terminée un message de succès devrait apparaitre: 

![5](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/98b03fe9-0790-4749-a6b3-5082f3eb9485)

- Puis taper la commande cuisante et apuillé sur entrée:
- 
![5](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/a8b262d5-0911-498c-94f3-7d53fe18c005)

- Il devrait apparaitre ceci:
- 
![5](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/8001bc4d-a253-4b7e-b09e-a46b50e085d3)

Crée l'image docker du service suivant :

- déplacé vous dans le fichier racine du service diabetesmanagment. 

- Puis taper la commande suivante et apuillé sur entrée:

![2](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/5bc7ee0d-3eb4-4ef4-b838-2c1a74a02edf)

- taper la commande suivant et appuillé sur entrée:

  ![5](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/c64d377e-acc8-4b5b-a0aa-f5a494d24104)







Cette application a été développée pour aider à détecter le diabète de type 2 chez les patients. Elle est composée de plusieurs microservices basés sur des projets Spring Boot, et ces microservices sont accessibles via un microservice de type "gateway" développé avec Spring Cloud Gateway. 

Installation de l'Application
Voici les instructions pour installer et exécuter l'application sur votre machine :

![4](https://github.com/j-sicard/Medilabo_Solutions/assets/106332407/7c1e5c75-cd1f-4f14-8c1d-5830c95db695)


Avant de proposer des suggestions pour améliorer l'application du point de vue du green code, commençons par définir ce concept : le green code. 

Le Green Coding consiste à adopter des pratiques de développement informatique visant à rendre le code et les produits numériques plus écologiques. Cela va au-delà du simple code source et englobe l'ensemble du processus de développement, y compris le choix des technologies, l'optimisation du code et l'hébergement des applications.

Le Green Coding présente plusieurs avantages significatifs :

Réduction des coûts à long terme grâce à une moindre consommation d'énergie et de bande passante.
Amélioration des performances des applications grâce à un code optimisé.
Simplification de la maintenance du code.
Amélioration de la réputation de l'entreprise en tant qu'acteur soucieux de l'environnement.

Pour pratiquer le Green Coding, plusieurs techniques peuvent être mises en œuvre :

- Écriture d'algorithmes et de code optimisés pour réduire la consommation d'énergie.
- Réduction du code inutile et simplification des API pour diminuer la taille des données échangées.
- Optimisation du stockage des données côté serveur et client pour réduire l'espace nécessaire.
- Choix d'un hébergeur utilisant des sources d'énergie renouvelable et des serveurs proches des utilisateurs.

En conclusion, le Green Coding offre une approche prometteuse pour réduire l'impact environnemental du développement logiciel. En adoptant des pratiques écologiques dès le stade de la conception, les entreprises peuvent contribuer à la transition vers un numérique plus durable et responsable.

Suggestions d’actions à mener pour appliquer le Green Code à ce projet:

Je propose une stratégie de consolidation des microservices pour optimiser notre application, dans une perspective de green code.
En regroupant les fonctionnalités des microservices de gestion des commentaires et d'étude du risque de diabète dans celui de la gestion des patients, 
nous simplifions l'architecture et réduisons le volume global de l'application. Cette consolidation nous permettra de limiter le nombre de requêtes HTTP entre les services, 
ce qui améliorera non seulement les performances de l'application, mais également son empreinte écologique en réduisant la consommation de ressources informatiques.

Pour simplifier la gestion des données, nous utiliserons une seule base de données MySQL avec plusieurs tables pour stocker les informations nécessaires.
Cette approche garantit une gestion efficace des données tout en réduisant la complexité de l'infrastructure, ce qui contribue à une utilisation plus durable des ressources.

En éliminant le serveur Eureka et l'API Gateway, nous simplifions davantage l'architecture, ce qui réduit la charge de travail des serveurs et la consommation d'énergie nécessaire à leur fonctionnement.

Nous maintiendrons un service front-end distinct pour garantir que l'application reste stateless, facilitant ainsi la gestion et la mise à l'échelle des serveurs, 
tout en conservant une approche écologiquement responsable.

Cette approche nous permettra de réduire significativement le volume de l'application et le nombre de requêtes entre les services,
tout en maintenant des performances optimales dans le cadre d'une démarche de développement durable.


