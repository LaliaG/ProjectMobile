# PROJET MOBILE 09/09/2024 LALIA SY

## Maquette
[maquette](./maquette/)


## App projetMobile react native
[App projetMobile](./front-end/projetMobile/)

## Objectif de ce projet
Répondre au sujet du [projetMobile](./ProjetMobile.md/)


Cas d'Utilisation (Use Case)
1. Acteurs Principaux :

Client : Une personne qui passe des commandes et consulte les produits.
Livreur : Une personne qui gère et suit les livraisons.
Administrateur : Gère les utilisateurs, les produits, les commandes et supervise les opérations.
2. Cas d'Utilisation :

Pour le Client :

S'inscrire / Se connecter : S'enregistrer dans l'application et se connecter via un email et un mot de passe.
Consulter Produits : Parcourir et consulter les détails des produits disponibles.
Passer Commande : Sélectionner des produits et passer une commande.
Suivre Livraison : Suivre le statut de la livraison de la commande.

Pour le Livreur :

Voir Commandes à Livrer : Consulter la liste des commandes assignées pour livraison.
Mettre à Jour le Statut de Livraison : Modifier le statut de la livraison (en cours, livré, etc.).
Voir Détails de Livraison : Consulter les détails des livraisons (adresse, type de livraison, etc.).

Pour l'Administrateur :

Gérer Utilisateurs : Ajouter, modifier ou supprimer des utilisateurs (clients, livreurs).
Gérer Produits : Ajouter, modifier ou supprimer des produits et leurs catégories.
Gérer Commandes : Voir, modifier ou annuler des commandes.
Gérer Stock : Mettre à jour les niveaux de stock des produits.
Gérer Livraisons : Superviser et assigner des commandes aux livreurs.

Diagramme de Cas d'Utilisation (Use Case Diagram)
Ce diagramme visualise les interactions entre les acteurs et les systèmes. Voici comment nous pourrions structurer le diagramme :

Client est connecté à : "S'inscrire / Se connecter", "Consulter Produits", "Passer Commande", "Suivre Livraison".
Livreur est connecté à : "Voir Commandes à Livrer", "Mettre à Jour le Statut de Livraison", "Voir Détails de Livraison".
Administrateur est connecté à : "Gérer Utilisateurs", "Gérer Produits", "Gérer Commandes", "Gérer Stock", "Gérer Livraisons".

Comparaison des bases de données relationnelles : MySQL vs PostgreSQL
PostgreSQL offre une plus grande flexibilité avec des types de données avancés (comme JSONB) et une meilleure gestion des relations complexes, ce qui en fait un choix solide pour les applications qui nécessitent une extensibilité des données.
MySQL est simple à mettre en place et peut offrir des performances légèrement meilleures pour les applications purement transactionnelles et fortement structurées, mais PostgreSQL est souvent considéré comme plus puissant pour des cas d'utilisation complexes.
Récapitulatif :
PostgreSQL : Authentification, Gestion des Clients, Gestion des Commandes, Gestion des Produits, Gestion des Stocks, et potentiellement la Gestion des Livraisons si vous souhaitez bénéficier du support JSONB.
MongoDB : Reste une excellente option pour la Gestion des Livraisons si vous préférez la flexibilité de données non structurées.
Aucune base de données : API Gateway.


API Gateway
Base de données recommandée : Aucune base de données nécessaire
Pourquoi ?
L'API Gateway ne nécessite pas de base de données pour ses opérations. Son rôle est de faire le routage, la gestion de la sécurité et la surveillance des requêtes.

Mais comme je n'ai pas le temps:
Récapitulatif :
MySQL : Authentification, Gestion des Clients, Gestion des Commandes, Gestion des Produits, Gestion des Stocks.
MongoDB : Gestion des Livraisons.
Aucune base de données : API Gateway.
MySQL est plus approprié pour les services nécessitant des structures de données fortement relationnelles, une intégrité transactionnelle stricte, et des contraintes comme des relations entre les entités. MongoDB, en revanche, offre une flexibilité pour gérer des données semi-structurées ou des documents complexes avec des schémas pouvant évoluer.

