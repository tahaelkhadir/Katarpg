package re.forestier.edu.rpg.game;

import re.forestier.edu.rpg.character.CharacterAttributeRegistry;
import re.forestier.edu.rpg.character.CharacterType;

import java.util.Map;


public class Character {
    private String characterType;
    private int healthPoints;
    private int currentHealthPoints;
    private Map<String, Integer> attributes;

    private static final int DEFAULT_HEALTH_POINTS = 100;

    public Character(CharacterType characterType) {
        this.characterType = characterType.getTypeName();
        this.currentHealthPoints = DEFAULT_HEALTH_POINTS;
        this.healthPoints = DEFAULT_HEALTH_POINTS;
        updateAttributesForLevel(this.characterType, 1);
    }

   
    public void updateAttributesForLevel(String characterType, int level) {
        this.attributes = CharacterAttributeRegistry.getAttributes(characterType, level);
    }

    public String getCharacterType() {
        return characterType;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int amount) {
        healthPoints = amount;
    }

    public void setCurrentHealthPoints(int amount) {
        currentHealthPoints = amount;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public Map<String, Integer> getAttributes() {
        return attributes;
    }
}
