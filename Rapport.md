# Introduction

Ce dépôt Git servira de lieu de stockage pour tous les travaux pratiques liés au cours de programmation avancée. Il centralisera les codes et les exercices sur lesquels nous travaillerons, avec un focus particulier sur trois aspects majeurs : la programmation parallèle et répartie, la programmation concurrente, et la programmation client/serveur.

Ces différentes thématiques seront explorées à travers des exercices pratiques qui serviront de base pour le projet de SAÉ de ce semestre. L'objectif est d'acquérir une maîtrise suffisante de ces concepts afin de pouvoir les appliquer efficacement dans le cadre de ce projet.

---

# TP1

L'énoncé du premier TP consiste à simuler le mouvement d'un ou plusieurs mobiles en utilisant des threads. Un **thread** est une unité d'exécution indépendante dans un programme (ou Processus léger). Les threads partagent la même zone mémoire, et permettent d'exécuter plusieurs tâches en parallèle, ce qui est particulièrement utile pour des simulations comme celle-ci, où plusieurs objets (ici des "mobiles") doivent bouger simultanément sans bloquer l'interface utilisateur ou d'autres processus.

### Exercice 1

L'exercice 1 nous demande d'implémenter le mouvement d'un mobile qui se déplace d'abord en avant, puis en arrière lorsqu'il atteint une extrémité de la fenêtre. Voici comment le code fonctionne :

1. **Classe `UnMobile` :**
    - Cette classe hérite de `JPanel` et implémente l'interface `Runnable`, ce qui lui permet d'exécuter son code dans un thread distinct.
    - Dans la méthode `run()`, deux boucles permettent au mobile de se déplacer. La première boucle déplace le mobile de gauche à droite, tandis que la seconde le fait revenir de droite à gauche. À chaque itération, le mobile est redessiné à sa nouvelle position grâce à la méthode `repaint()`, et un délai est introduit pour contrôler la vitesse de déplacement.


2. **Classe `UneFenetre` :**
    - Hérite de `JFrame` et constitue la fenêtre principale de l'application. Dans son constructeur, une instance de `UnMobile` est créée et ajoutée au conteneur de la fenêtre.
    - Un thread est démarré pour exécuter la méthode `run()` de l'objet mobile, permettant ainsi le mouvement en continu.

## Exercice 2

Dans l'exercice 2, la classe `UneFenetre` a été modifiée pour inclure un bouton qui permet de contrôler le mouvement du mobile. Pour ce faire, un `ActionListener` a été attaché au bouton pour gérer les événements de clic. Lorsque le bouton est cliqué, il vérifie son texte :
   - Si le texte est "Stop", cela signifie que le mobile doit être arrêté. Le texte du bouton est changé en "Start", et la méthode `suspend()` est appelée sur le thread du mobile pour le mettre en pause.
   - Si le texte est "Start", le mobile doit reprendre son mouvement. Le texte du bouton est alors réinitialisé en "Stop", et la méthode `resume()` est appelée pour relancer le thread.

Cependant, ce code ne fonctionne pas. En effet, les méthodes `suspend()` et `resume()` de la classe `Thread` sont considérées comme dépréciées et ne sont plus recommandées - et dans ce cas, ne fonctionnent plus - pour la gestion des threads en Java.

Pour l'exercice 3, nous allons donc utiliser d'autres méthodes pour que ce dernier fonctionne.