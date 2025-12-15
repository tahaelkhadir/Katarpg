package re.forestier.edu.rpg.character;

import java.util.Map;

public class CharacterAttributeRegistry {
    private static final CharacterClass adventurer;
    private static final CharacterClass archer;
    private static final CharacterClass dwarf;
    private static final CharacterClass goblin;

    static {
        
        adventurer = new CharacterClass(CharacterType.ADVENTURER);
        adventurer.addAttributeToLevel(1, "INT", 1);
        adventurer.addAttributeToLevel(1, "DEF", 1);
        adventurer.addAttributeToLevel(1, "ATK", 3);
        adventurer.addAttributeToLevel(1, "CHA", 2);

        adventurer.addAttributeToLevel(2, "INT", 2);
        adventurer.addAttributeToLevel(2, "DEF", 1);
        adventurer.addAttributeToLevel(2, "ATK", 3);
        adventurer.addAttributeToLevel(2, "CHA", 3);

        adventurer.addAttributeToLevel(3, "INT", 2);
        adventurer.addAttributeToLevel(3, "DEF", 1);
        adventurer.addAttributeToLevel(3, "ATK", 5);
        adventurer.addAttributeToLevel(3, "CHA", 3);
        adventurer.addAttributeToLevel(3, "ALC", 1);

        adventurer.addAttributeToLevel(4, "INT", 2);
        adventurer.addAttributeToLevel(4, "DEF", 3);
        adventurer.addAttributeToLevel(4, "ATK", 5);
        adventurer.addAttributeToLevel(4, "CHA", 3);
        adventurer.addAttributeToLevel(4, "ALC", 1);

        adventurer.addAttributeToLevel(5, "INT", 2);
        adventurer.addAttributeToLevel(5, "DEF", 4);
        adventurer.addAttributeToLevel(5, "ATK", 5);
        adventurer.addAttributeToLevel(5, "CHA", 3);
        adventurer.addAttributeToLevel(5, "ALC", 1);
        adventurer.addAttributeToLevel(5, "VIS", 1);

       
        archer = new CharacterClass(CharacterType.ARCHER);
        archer.addAttributeToLevel(1, "INT", 1);
        archer.addAttributeToLevel(1, "ATK", 3);
        archer.addAttributeToLevel(1, "CHA", 1);
        archer.addAttributeToLevel(1, "VIS", 3);

        archer.addAttributeToLevel(2, "INT", 1);
        archer.addAttributeToLevel(2, "ATK", 3);
        archer.addAttributeToLevel(2, "CHA", 2);
        archer.addAttributeToLevel(2, "VIS", 3);
        archer.addAttributeToLevel(2, "DEF", 1);

        archer.addAttributeToLevel(3, "INT", 1);
        archer.addAttributeToLevel(3, "ATK", 3);
        archer.addAttributeToLevel(3, "CHA", 2);
        archer.addAttributeToLevel(3, "VIS", 3);
        archer.addAttributeToLevel(3, "DEF", 1);

        archer.addAttributeToLevel(4, "INT", 1);
        archer.addAttributeToLevel(4, "ATK", 3);
        archer.addAttributeToLevel(4, "CHA", 2);
        archer.addAttributeToLevel(4, "VIS", 3);
        archer.addAttributeToLevel(4, "DEF", 2);

        archer.addAttributeToLevel(5, "INT", 1);
        archer.addAttributeToLevel(5, "ATK", 4);
        archer.addAttributeToLevel(5, "CHA", 2);
        archer.addAttributeToLevel(5, "VIS", 3);
        archer.addAttributeToLevel(5, "DEF", 2);

        
        dwarf = new CharacterClass(CharacterType.DWARF);
        dwarf.addAttributeToLevel(1, "ALC", 4);
        dwarf.addAttributeToLevel(1, "INT", 1);
        dwarf.addAttributeToLevel(1, "ATK", 3);

        dwarf.addAttributeToLevel(2, "ALC", 5);
        dwarf.addAttributeToLevel(2, "INT", 1);
        dwarf.addAttributeToLevel(2, "ATK", 3);
        dwarf.addAttributeToLevel(2, "DEF", 1);

        dwarf.addAttributeToLevel(3, "ALC", 5);
        dwarf.addAttributeToLevel(3, "INT", 1);
        dwarf.addAttributeToLevel(3, "ATK", 4);
        dwarf.addAttributeToLevel(3, "DEF", 1);

        dwarf.addAttributeToLevel(4, "ALC", 5);
        dwarf.addAttributeToLevel(4, "INT", 1);
        dwarf.addAttributeToLevel(4, "ATK", 4);
        dwarf.addAttributeToLevel(4, "DEF", 2);

        dwarf.addAttributeToLevel(5, "ALC", 5);
        dwarf.addAttributeToLevel(5, "INT", 1);
        dwarf.addAttributeToLevel(5, "ATK", 4);
        dwarf.addAttributeToLevel(5, "DEF", 2);
        dwarf.addAttributeToLevel(5, "CHA", 1);

        
        goblin = new CharacterClass(CharacterType.GOBLIN);
        goblin.addAttributeToLevel(1, "INT", 2);
        goblin.addAttributeToLevel(1, "ATK", 2);
        goblin.addAttributeToLevel(1, "ALC", 1);

        goblin.addAttributeToLevel(2, "INT", 2);
        goblin.addAttributeToLevel(2, "ATK", 3);
        goblin.addAttributeToLevel(2, "ALC", 4);

        goblin.addAttributeToLevel(3, "INT", 2);
        goblin.addAttributeToLevel(3, "ATK", 3);
        goblin.addAttributeToLevel(3, "ALC", 4);
        goblin.addAttributeToLevel(3, "VIS", 1);

        goblin.addAttributeToLevel(4, "INT", 2);
        goblin.addAttributeToLevel(4, "ATK", 3);
        goblin.addAttributeToLevel(4, "ALC", 4);
        goblin.addAttributeToLevel(4, "VIS", 1);
        goblin.addAttributeToLevel(4, "DEF", 1);

        goblin.addAttributeToLevel(5, "INT", 2);
        goblin.addAttributeToLevel(5, "ATK", 4);
        goblin.addAttributeToLevel(5, "ALC", 4);
        goblin.addAttributeToLevel(5, "VIS", 1);
        goblin.addAttributeToLevel(5, "DEF", 2);
    }

    
    public static Map<String, Integer> getAttributes(String characterType, int level) {
        switch (characterType) {
            case "ADVENTURER":
                return adventurer.getAttributesAtLevel(level).getAttributes();
            case "ARCHER":
                return archer.getAttributesAtLevel(level).getAttributes();
            case "DWARF":
                return dwarf.getAttributesAtLevel(level).getAttributes();
            case "GOBLIN":
                return goblin.getAttributesAtLevel(level).getAttributes();
            default:
                return null;
        }
    }
}
