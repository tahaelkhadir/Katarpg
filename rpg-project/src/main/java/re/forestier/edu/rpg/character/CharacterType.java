package re.forestier.edu.rpg.character;


public enum CharacterType {
    ADVENTURER("ADVENTURER"),
    ARCHER("ARCHER"),
    DWARF("DWARF"),
    GOBLIN("GOBLIN");

    private final String typeName;

    CharacterType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
