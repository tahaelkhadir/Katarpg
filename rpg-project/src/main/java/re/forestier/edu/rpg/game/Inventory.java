package re.forestier.edu.rpg.game;

import re.forestier.edu.rpg.equipment.Equipment;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a player's inventory with weight constraints.
 * Prevents adding equipment that would exceed the maximum carrying capacity.
 */
public class Inventory {
    private List<Equipment> equipment;
    private final int maxWeight;

    private static final int DEFAULT_MAX_WEIGHT = 200;

    public Inventory(List<Equipment> initialEquipment) {
        this.equipment = new ArrayList<>(initialEquipment);
        this.maxWeight = DEFAULT_MAX_WEIGHT;
    }

    /**
     * Removes an equipment item from the inventory.
     * @param item The equipment to remove
     * @return true if the item was removed, false otherwise
     */
    public boolean removeEquipment(Equipment item) {
        return equipment.remove(item);
    }

    /**
     * Gets all equipment in the inventory.
     * @return A copy of the equipment list
     */
    public List<Equipment> getEquipment() {
        return new ArrayList<>(equipment);
    }

    /**
     * Calculates the total weight of all equipment in the inventory.
     * @return The total weight
     */
    public int calculateTotalWeight() {
        return equipment.stream().mapToInt(Equipment::getWeight).sum();
    }

    /**
     * Adds an equipment item to the inventory if it doesn't exceed max weight.
     * @param item The equipment to add
     */
    public void addEquipment(Equipment item) {
        if (item != null) {
            if (calculateTotalWeight() + item.getWeight() > maxWeight) {
                return;
            }
            equipment.add(item);
        }
    }
}
