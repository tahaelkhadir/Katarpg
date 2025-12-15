package re.forestier.edu.rpg.game;

import re.forestier.edu.rpg.equipment.Equipment;
import re.forestier.edu.rpg.character.CharacterType;

import java.util.*;


public class Player {
    private String playerName;
    private String characterName;
    private Character character;
    private Wallet wallet;
    private Inventory inventory;
    private ExperienceManager experienceManager;

    public Player(String playerName, String characterName, CharacterType characterType, int initialMoney, List<Equipment> initialEquipment) {
        this.playerName = playerName;
        this.characterName = characterName;
        this.character = new Character(characterType);
        this.wallet = new Wallet(initialMoney);
        this.inventory = new Inventory(initialEquipment);
        this.experienceManager = new ExperienceManager();
    }

    public String getCharacterType() {
        return character.getCharacterType();
    }

    public int getMoney() {
        return wallet.getMoney();
    }

    public void addMoney(int amount) {
        wallet.addMoney(amount);
    }

    public void removeMoney(int amount) {
        wallet.removeMoney(amount);
    }

    public List<Equipment> getEquipment() {
        return inventory.getEquipment();
    }

    public int getLevel() {
        return experienceManager.getLevel();
    }

    
    public boolean gainXp(int amount) {
        ArrayList<Equipment> gameEquipment = Equipment.toList();

        int currentLevel = experienceManager.getLevel();
        experienceManager.addXp(amount);
        int newLevel = experienceManager.getLevel();

        if (newLevel != currentLevel) {
           
            Random random = new Random();
            inventory.addEquipment(gameEquipment.get(random.nextInt(gameEquipment.size())));

            
            String characterType = character.getCharacterType();
            character.updateAttributesForLevel(characterType, newLevel);
            return true;
        }

        return false;
    }

    
    public void updatePlayerAfterRound() {
        int currentHealthPoints = character.getCurrentHealthPoints();
        int healthPoints = character.getHealthPoints();
        List<Equipment> equipmentList = inventory.getEquipment();

        if (currentHealthPoints == 0) {
            System.out.println("Le joueur est KO !");
            return;
        }

        if (currentHealthPoints < healthPoints / 2) {
            switch (character.getCharacterType()) {
                case "DWARF":
                    if (equipmentList.contains(Equipment.HOLY_ELIXIR)) {
                        character.setCurrentHealthPoints(character.getCurrentHealthPoints() + 1);
                    }
                    character.setCurrentHealthPoints(character.getCurrentHealthPoints() + 1);
                    break;

                case "ADVENTURER":
                    character.setCurrentHealthPoints(character.getCurrentHealthPoints() + 2);
                    if (experienceManager.getLevel() < 3) {
                        character.setCurrentHealthPoints(character.getCurrentHealthPoints() - 1);
                    }
                    break;

                case "ARCHER":
                    character.setCurrentHealthPoints(character.getCurrentHealthPoints() + 1);
                    if (equipmentList.contains(Equipment.MAGIC_BOW)) {
                        character.setCurrentHealthPoints(character.getCurrentHealthPoints() + (character.getCurrentHealthPoints() / 8 - 1));
                    }
                    break;

                default:
                    break;
            }
        } else if (currentHealthPoints >= healthPoints / 2) {
            if (currentHealthPoints >= healthPoints) {
                character.setCurrentHealthPoints(healthPoints);
                return;
            }
        }

        if (currentHealthPoints >= healthPoints) {
            character.setCurrentHealthPoints(healthPoints);
        }
    }

    public int getXp() {
        return experienceManager.getXp();
    }

    public int getHealthPoints() {
        return character.getHealthPoints();
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    
    public String displayPlayer() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Joueur ").append(characterName).append(" joué par ").append(playerName)
                .append("\nNiveau : ").append(experienceManager.getLevel())
                .append(" (XP totale : ").append(experienceManager.getXp()).append(")")
                .append("\n\nCapacités :");

        character.getAttributes().forEach((name, level) ->
                buffer.append("\n   ").append(name).append(" : ").append(level)
        );

        buffer.append("\n\nInventaire :");
        inventory.getEquipment().forEach(item ->
                buffer.append("\n   ").append(item.getName())
        );

        return buffer.toString();
    }

    public Map<String, Integer> displayAttributes() {
        return character.getAttributes();
    }

    public void setCurrentHealthPoints(int healthPoints) {
        character.setCurrentHealthPoints(healthPoints);
    }

    public void setHealthPoints(int healthPoints) {
        character.setHealthPoints(healthPoints);
    }

    public int getCurrentHealthPoints() {
        return character.getCurrentHealthPoints();
    }

    public Map<String, Integer> getAttributes() {
        return character.getAttributes();
    }

    public void addEquipment(Equipment item) {
        inventory.addEquipment(item);
    }

    
    public String sellEquipment(Equipment item) {
        if (inventory.removeEquipment(item)) {
            wallet.addMoney(item.getValue());
            return "You Sold " + item.getName() + " For " + item.getValue() + " Gold.";
        }
        return "Your Inventory doesn't contain " + item.getName();
    }

    public int totalWeight() {
        return inventory.calculateTotalWeight();
    }

    
    public String displayInMarkdown() {
        StringBuilder markdown = new StringBuilder();

        markdown.append("# Joueur : ").append(characterName).append("\n");
        markdown.append("**Nom réel :** ").append(playerName).append("  \n");
        markdown.append("**Classe :** ").append(character.getCharacterType()).append("  \n");
        markdown.append("**HP :** ").append(character.getHealthPoints()).append("  \n\n");
        markdown.append("## Inventaire\n");

        inventory.getEquipment().forEach(item ->
                markdown.append("* **").append(item.getName()).append("** - *")
                        .append(item.getDescription()).append("* (Poids : ")
                        .append(item.getWeight()).append(", Valeur : ")
                        .append(item.getValue()).append(" pièces d'or)  \n")
        );

        return markdown.toString();
    }

    public String displayPlayerFreeMarker() {
        PlayerDisplayService displayService = new PlayerDisplayService();
        return displayService.displayPlayer(this);
    }
}
