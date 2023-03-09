# parkingmap
Application de gestion de parkings

Cette application permet de récupérer la liste des parkings à proximité et leur nombre de places disponibles en temps réel.
Technologies utilisées

    Spring Boot 2.6.4 pour la gestion des dépendances et le développement de l'application web
    Hibernate pour gérer la persistence des objets en base de donnée
    PostgreSQL pour la base de données
    JUnit + Mockito pour les tests unitaires
    Swagger2 pour la documentation de l'API REST
    Maven pour la gestion de projet et la construction de l'application

Prérequis

    Java 17
    PostgreSQL 10+
    Maven

Installation

    Clonez le dépôt Git sur votre machine locale : git clone 
    Ouvrez le projet dans votre IDE préféré (IntelliJ IDEA, Eclipse sts..)

    Exécutez la commande Maven pour construire l'application : mvn clean install
    Exécutez l'application en lançant la classe principale ParkingmapApplication

Utilisation

L'application expose une API REST avec les endpoints suivants :

    GET /parking/proximite : renvoie la liste des parkings de la ville, adresse, nombre de places totales et nombre de places disponibles en temps réel.
    GET /parking/add : ajouter un parking dans la base de donnée.
    GET /parking/all : renvoie la liste de tous les parkings de la ville.

Vous pouvez consulter la documentation de l'API REST avec Swagger en ouvrant l'URL http://localhost:8080/swagger-ui/ dans votre navigateur web.
Tests

L'application inclut des tests unitaires et d'intégration avec JUnit et Mockito.
