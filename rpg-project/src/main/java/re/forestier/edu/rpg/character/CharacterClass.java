package re.forestier.edu.rpg.character;

import java.util.HashMap;
import java.util.Map;


public class CharacterClass {
    private String characterType;
    private Map<Integer, CharacterAttribute> levelAttributes;

    public CharacterClass(CharacterType characterType) {
        this.characterType = characterType.getTypeName();
        this.levelAttributes = new HashMap<>();
    }

    
    public void addAttributeToLevel(int level, String attributeName, int value) {
        levelAttributes.putIfAbsent(level, new CharacterAttribute());
        levelAttributes.get(level).addAttribute(attributeName, value);
    }

    
    public CharacterAttribute getAttributesAtLevel(int level) {
        return levelAttributes.getOrDefault(level, new CharacterAttribute());
    }
}
