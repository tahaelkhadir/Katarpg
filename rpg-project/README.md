# 🎮 RPG Player Manager - Projet Refactorisé

## 📋 Description

Projet Java d'un système de gestion de joueurs RPG (Role-Playing Game) entièrement refactorisé avec des bonnes pratiques de développement logiciel.

### ✨ Fonctionnalités

- **4 Classes de Personnages** : ADVENTURER, ARCHER, DWARF, GOBLIN
- **Système de Progression** : 5 niveaux avec des attributs évolutifs
- **Gestion d'Inventaire** : Contrainte de poids maximum (200)
- **Système d'Équipement** : 8 objets avec poids et valeur
- **Affichage Multiple** : Texte, Markdown, FreeMarker

## 🚀 Installation et Exécution

### Prérequis

- **Java JDK 21** ou supérieur
- **Gradle 8.5** (ou utiliser le wrapper fourni)

### Sous Windows

```bash
# Compiler le projet
.\gradlew.bat build

# Exécuter les tests
.\gradlew.bat test

# Exécuter l'application
.\gradlew.bat run
```

### Sous Linux/Mac

```bash
# Compiler le projet
./gradlew build

# Exécuter les tests
./gradlew test

# Exécuter l'application
./gradlew run
```

## 📊 Rapports de Qualité

### JaCoCo (Couverture de code)
```bash
.\gradlew.bat jacocoTestReport
```
📄 Rapport : `build/reports/jacoco/test/html/index.html`

### PIT (Tests de mutation)
```bash
.\gradlew.bat pitest
```
📄 Rapport : `build/reports/pitest/[timestamp]/index.html`

## 🏗️ Structure du Projet

```
src/main/java/re/forestier/edu/rpg/
├── character/          # Système de personnages
│   ├── CharacterType.java
│   ├── CharacterAttribute.java
│   ├── CharacterClass.java
│   └── CharacterAttributeRegistry.java
├── equipment/          # Équipements
│   └── Equipment.java
└── game/              # Logique de jeu
    ├── Player.java
    ├── Character.java
    ├── ExperienceManager.java
    ├── Inventory.java
    ├── Wallet.java
    └── PlayerDisplayService.java
```

## 🧪 Tests

- **45 tests unitaires** avec JUnit 5
- **Couverture : 94%** (objectif 100%)
- Tests d'approbation avec ApprovalTests

## 📦 Dépendances

- JUnit 5.10.0
- Hamcrest 2.2
- ApprovalTests 15.6.0
- FreeMarker 2.3.30
- PIT 1.7.4 (mutation testing)

## 👥 Auteurs
TAHA EL KHADIR
LEMSIAH EL YAZID
voila link : github https://github.com/tahaelkhadir/Katarpg




