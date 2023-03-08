# parkingmap
Application de gestion de parkings

Cette application permet de récupérer la liste des parkings à proximité et leur nombre de places disponibles en temps réel.
Technologies utilisées

    Spring Boot 2.6.4 pour la gestion des dépendances et le développement de l'application web
    Hibernate pour l'ORM
    PostgreSQL pour la base de données
    JUnit + Mockito pour les tests unitaires et l'intégration continue
    Swagger2 pour la documentation de l'API REST
    Maven pour la gestion de projet et la construction de l'application

Prérequis

    Java 17
    PostgreSQL 10+
    Maven 3+

Installation

    Clonez le dépôt Git sur votre machine locale : git clone 
    Ouvrez le projet dans votre IDE préféré (IntelliJ IDEA, Eclipse sts..)

    Exécutez la commande Maven pour construire l'application : mvn clean install
    Exécutez l'application en lançant la classe principale .......... ou avec la commande Maven : mvn spring-boot:run

Utilisation

L'application expose une API REST avec les endpoints suivants :

    GET /parkings : renvoie la liste des parkings à proximité avec leur nom, adresse, nombre de places totales et nombre de places disponibles en temps réel.
    GET /parkings/{id} : renvoie les informations détaillées d'un parking identifié par son ID.
    GET /parkings/disponibilites : renvoie le nombre de places disponibles pour tous les parkings.

Vous pouvez consulter la documentation de l'API REST avec Swagger en ouvrant l'URL http://localhost:8080/swagger-ui.html dans votre navigateur web.
Tests

L'application inclut des tests unitaires et d'intégration avec JUnit et Mockito.
