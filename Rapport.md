# Introduction

Ce dépôt Git servira de lieu de stockage pour tous les travaux pratiques liés au cours de programmation avancée. Il centralisera les codes et les exercices sur lesquels nous travaillerons, avec un focus particulier sur trois aspects majeurs : la programmation parallèle et répartie, la programmation concurrente, et la programmation client/serveur.

Ces différentes thématiques seront explorées à travers des exercices pratiques qui serviront de base pour le projet de SAÉ de ce semestre. L'objectif est d'acquérir une maîtrise suffisante de ces concepts afin de pouvoir les appliquer efficacement dans le cadre de ce projet.

---

# TP1

L'énoncé du premier TP consiste à simuler le mouvement d'un ou plusieurs mobiles en utilisant des threads.

## Qu'est-ce qu'un Thread?

Un **thread** est une unité d'exécution indépendante dans un programme (ou Processus léger). Les threads partagent la même zone mémoire, et permettent d'exécuter plusieurs tâches en parallèle, ce qui est particulièrement utile pour des simulations comme celle-ci, où plusieurs objets (ici des "mobiles") doivent bouger simultanément sans bloquer l'interface utilisateur ou d'autres processus.

### Processus léger : cycle de vie

Un **thread** suit trois états principaux :

1. **Prêt** : Le thread est prêt à être exécuté, mais attend qu'un cœur de processeur soit disponible.
2. **En exécution** : Le thread est sélectionné par l'OS et utilise les ressources du processeur.
3. **Bloqué** : Le thread est suspendu (volontairement ou par l'OS) et attend qu'une ressource devienne disponible.

### Gestion par l'OS

L'OS décide quels threads sont exécutés et sur quels cœurs. Nous, on ne contrôle que leur synchronisation. L'OS peut interrompre un thread et le reprendre sur un autre cœur sans avoir besoin de nous demander ni de nous en informer.

### Premier lancement et fin

Le premier démarrage d'un thread via `start()` est initié par nous, mais ensuite, l'OS gère son exécution. Quand un thread termine la méthode `run()`, il disparaît définitivement.

## Exercice 1

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

## Exercice 3

Nous avons étendu la fonctionnalité de notre application pour permettre le contrôle indépendant de deux mobiles en utilisant des boutons. Voici les principales modifications et le fonctionnement du code :

1. **Gestion de deux mobiles :**
   - Au lieu d'avoir un seul mobile, on a maintenant **deux objets `UnMobile`** (un pour chaque mobile). Ces objets sont ajoutés dans une grille de 2x2 via un `GridLayout`, ce qui permet de bien structurer l'interface avec deux mobiles et leurs boutons correspondants.

2. **Ajout d'un deuxième bouton de contrôle :**
   - Chaque mobile a son propre bouton (`sonBouton1` pour le premier mobile et `sonBouton2` pour le deuxième). Ces boutons permettent de stopper ou de relancer le mouvement de chaque mobile individuellement, en modifiant l'état de pause du mobile associé.

3. **Mécanisme de pause/résumé via un drapeau (`enPause`) :**
   - Les méthodes `suspend()` et `resume()` étant dépréciées, elles ont été remplacées par un mécanisme basé sur un **drapeau (`enPause`)**.
   - Chaque mobile vérifie régulièrement si le drapeau est activé, et si c'est le cas, le thread met le mobile en pause en restant dans une boucle qui attend que le drapeau soit désactivé.
   - La méthode `setPause()` permet de modifier l'état du drapeau, ce qui est contrôlé par le bouton correspondant. Quand l'utilisateur clique sur un bouton, il met à jour l'état de pause du mobile (true pour pause, false pour reprendre).

C'est dans cet exercice qu'on voit vraiment l'intérêt des threads, car les deux mobiles étant lancés dans des processus différents, il est possible pour l'un de rester dans une boucle à attendre tandis que l'autre continue sa route.

Au final, on a donc une fenêtre avec deux mobiles qui se déplacent simultanément et indépendamment l'un de l'autre, avec la possibilité de les arrêter ou de les relancer individuellement via leurs boutons respectifs.