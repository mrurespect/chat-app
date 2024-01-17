# Messagerie-app using Thymleaf

## Description
Ce projet représente une application de messagerie basée sur Thymeleaf, développée en Java avec Spring Boot. L'application permet aux utilisateurs de s'authentifier, de visualiser des conversations privées ou de groupe, d'envoyer des messages, et donne aux administrateurs et modérateurs la capacité de bannir des utilisateurs.

## Fonctionnalités principales
1. **Authentification :** Les utilisateurs peuvent s'authentifier avec leur nom d'utilisateur et leur mot de passe.
2. **Accueil :** Après l'authentification, les utilisateurs sont redirigés vers la page d'accueil où ils peuvent voir la liste des conversations auxquelles ils participent.
3. **Sélection de la Conversation :** Les utilisateurs peuvent sélectionner une conversation spécifique parmi celles auxquelles ils participent.
4. **Messagerie Privée :** Les utilisateurs peuvent avoir des conversations privées avec d'autres utilisateurs.
5. **Messagerie de Groupe :** Les utilisateurs peuvent participer à des conversations de groupe.
6. **Envoi de Messages :** Les utilisateurs peuvent envoyer des messages dans la conversation sélectionnée.
7. **Gestion des Utilisateurs de la Conversation :** Les administrateurs et modérateurs peuvent bannir des utilisateurs de la conversation.
8. **Informations Utilisateur :** Les utilisateurs peuvent accéder à une page d'informations où ils peuvent voir les détails de leur profil.

## Structure du Projet
- Le projet est structuré en utilisant le modèle MVC (Modèle-Vue-Contrôleur).
- Les entités telles que User, Conversation, Message, et ConversationUser sont définies dans le package "entity".
- Les services (UserService, ConversationService, MessageService, ConversationUserService) gèrent l'accès aux données.
- Le contrôleur principal (DemoController) gère les requêtes HTTP et la navigation entre les vues.

## Technologies Utilisées
- Java avec Spring Boot
- Thymeleaf pour la création des vues
- Hibernate pour l'accès à la base de données
- HttpSession pour gérer la session utilisateur

## Instructions d'Utilisation
1. Accéder à la page de connexion ("/login") pour vous authentifier.
2. Après l'authentification, vous serez redirigé vers la page d'accueil ("/home").
3. Sélectionnez une conversation privée ou de groupe parmi celles auxquelles vous participez.
4. Envoyez des messages dans la conversation sélectionnée.
5. Accédez à la page d'informations ("/info") pour voir les détails de votre profil.
6. Pour gérer les utilisateurs de la conversation en tant qu'administrateur ou modérateur, accédez à la page "/users".
7. Les administrateurs et modérateurs peuvent bannir des utilisateurs de la conversation.
## Diagramme de classe
![messagerie](https://github.com/mrurespect/chat-app/assets/121578147/74efdaf7-ed02-4bfe-9fc6-101602f12e6a)

