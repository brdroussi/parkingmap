# parkingmap
Parking Map

Cette application permet de récupérer la liste des parkings à proximité et leur nombre de places disponibles en temps réel.
Technologies utilisées :

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

    GET /parking/proximite : renvoie la liste des parkings à proximité de la ville, id, adresse, altitude, longitude, nom, nombre de places totales et nombre de places disponibles en temps réel.
    GET /parking/add : ajout d'un parking dans la base de donnée.
    GET /parking/all : renvoie la liste de tous les parkings de la ville.

Vous pouvez consulter la documentation de l'API REST avec Swagger en ouvrant l'URL http://localhost:8080/swagger-ui/ dans votre navigateur web.
Tests

L'application inclut des tests unitaires et d'intégration avec JUnit et Mockito.

Amélioration 0 JOUTER:

Je n'ai pas eu le temps pour récupérer les facets et vérifier la disponibité de parking avant l'affichage


<img width="928" alt="Requête Parkings à proximité2" src="https://user-images.githubusercontent.com/41145526/224035047-c8f496c4-4a48-4780-b020-4fa2f4790310.PNG">
<img width="843" alt="Swagger" src="https://user-images.githubusercontent.com/41145526/224035052-f138dc08-848d-4c71-ae41-e989ee950816.PNG">
<img width="926" alt="Requête Parkings à proximité" src="https://user-images.githubusercontent.com/41145526/224035054-7d4bb24f-07ea-4d7f-a130-822261b20c06.PNG">
