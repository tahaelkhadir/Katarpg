package re.forestier.edu.rpg.equipment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents equipment equipment that can be carried by players in the RPG game.
 * Each equipment has a name, description, weight, and monetary value.
 */
public enum Equipment {
    LOOKOUT_RING("Lookout Ring", "Prevents surprise attacks", 5, 200),
    SCROLL_OF_STUPIDITY("Scroll of Stupidity", "INT-2 when applied to an enemy", 1, 100),
    DRAUPNIR("Draupnir", "Increases XP gained by 100%", 20, 100),
    MAGIC_CHARM("Magic Charm", "Magic +10 for 5 rounds", 5, 50),
    RUNE_STAFF_OF_CURSE("Rune Staff of Curse", "May burn your enemies... Or yourself. Who knows?", 10, 20),
    COMBAT_EDGE("Combat Edge", "Well, that's an edge", 200, 100),
    HOLY_ELIXIR("Holy Elixir", "Recover your HP", 2, 200),
    MAGIC_BOW("Magic Bow", "A bow but with magic", 100, 200);

    private final String name;
    private final String description;
    private final int weight;
    private final int value;

    Equipment(String name, String description, int weight, int value) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public static ArrayList<Equipment> toList() {
        return new ArrayList<>(Arrays.asList(Equipment.values()));
    }
}
