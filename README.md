# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Informations

- **Nom et Prénom** : Rachid Ouahsouni
- **Groupe** : M1 Ingénierie du Logiciel de la Societe numérique (ILSEN) CLA 

## Badges

[![CircleCI](https://circleci.com/gh/RachidOuahsouni/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://circleci.com/gh/RachidOuahsouni/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/RachidOuahsouni/ceri-m1-techniques-de-test/graph/badge.svg?token=SJZTBVQ2OK)](https://codecov.io/gh/RachidOuahsouni/ceri-m1-techniques-de-test)
![Checkstyle](https://img.shields.io/badge/Checkstyle-Passing-green)
[![Javadoc](https://img.shields.io/badge/docs-Javadoc-blue)](https://rachidouahsouni.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)

## Outils et Technologies

- **Langage** : Java
- **Outils de Test** : JUnit, Mockito
- **Intégration Continue** : CircleCI
- **Couverture de Test** : JaCoCo et Codecov

### Choix Techniques

- **Mocks avec Mockito** : Mockito a été utilisé pour simuler les interactions avec les différentes interfaces, ce qui permet de tester indépendamment chaque composant du système.
- **JaCoCo pour la couverture de code** : Le plugin JaCoCo est configuré pour mesurer la couverture de test du code et générer des rapports, qui sont ensuite envoyés sur Codecov.
- **CircleCI pour l'intégration continue** : CircleCI a été choisi pour automatiser l'exécution des tests et s'assurer que le code est testé à chaque commit.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
