package re.forestier.edu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import re.forestier.edu.rpg.equipment.Equipment;
import re.forestier.edu.rpg.character.CharacterType;
import re.forestier.edu.rpg.game.Player;

public class UnitTests {

    @Test
    @DisplayName("Sample test")
    void testPlayerName() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        assertThat(player.getPlayerName(), is("Florian"));
    }

    @Test
    void testGetExp() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        assertThat(player.getXp(), is(0));
    }

    @Test
    void testAddMoney() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        player.addMoney(100);
        assertThat(player.getMoney(), is(200));
    }

    @Test
    void testRetreiveLevel() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        assertThat(player.getLevel(), is(1));
    }

    @Test
    void testAddXp() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        player.gainXp(10);
        assertThat(player.getLevel(), is(2));
        player.gainXp(20);
        assertThat(player.getLevel(), is(3));
        player.gainXp(30);
        assertThat(player.getLevel(), is(4));
        player.gainXp(80);
        assertThat(player.getLevel(), is(5));
    }

    @Test
    void testAbilityValues() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        assertThat(player.getAttributes().get("INT"), is(1));
        assertThat(player.getAttributes().get("DEF"), is(1));
        assertThat(player.getAttributes().get("CHA"), is(2));
        assertThat(player.getAttributes().get("ATK"), is(3));
    }

    @Test
    void testRemoveMoney() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        player.removeMoney(50);
        assertThat(player.getMoney(), is(50));
    }


    @Test
    void testPlayerKO() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        player.setCurrentHealthPoints(0);
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outSpy));
        try {
            player.updatePlayerAfterRound();
            assertThat(outSpy.toString(), is("Le joueur est KO !\n"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testMaJHpAventurier() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        player.setCurrentHealthPoints(90);
        player.setHealthPoints(200);
        player.updatePlayerAfterRound();
        assertThat(player.getCurrentHealthPoints(), is(91));
    }

    @Test
    void testMaJHpDwarf() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.DWARF, 100, new ArrayList<>());
        player.setCurrentHealthPoints(90);
        player.setHealthPoints(200);
        player.addEquipment(Equipment.HOLY_ELIXIR);
        player.updatePlayerAfterRound();
        assertThat(player.getCurrentHealthPoints(), is(92));
    }

    @Test
    void testMaJHpArcher() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ARCHER, 100, new ArrayList<>());
        player.setCurrentHealthPoints(79);
        player.setHealthPoints(200);
        player.addEquipment(Equipment.MAGIC_BOW);
        player.updatePlayerAfterRound();
        assertThat(player.getCurrentHealthPoints(), is(89));
    }

    @Test
    void testMaJHpEqualsHalf() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.DWARF, 100, new ArrayList<>());
        player.setCurrentHealthPoints(200);
        player.setHealthPoints(100);
        player.updatePlayerAfterRound();
        assertThat(player.getCurrentHealthPoints(), is(100));
    }

    @Test
    void testMaJHpEquals() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.DWARF, 100, new ArrayList<>());
        player.setCurrentHealthPoints(201);
        player.setHealthPoints(200);
        player.updatePlayerAfterRound();
        assertThat(player.getCurrentHealthPoints(), is(200));
    }

    @Test
    void AddxpCurrentequalsnew() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        int xp = 0;
        assertThat(player.gainXp(xp), is(false));
    }

    @Test
    void testInventoryDisplay() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ARCHER, 100, new ArrayList<>());
        player.addEquipment(Equipment.MAGIC_BOW);
        player.addEquipment(Equipment.DRAUPNIR);
        String finalString = player.displayPlayer();
        assertThat(finalString, containsString("Grognak le barbare"));
        assertThat(finalString, containsString("Magic Bow"));
        assertThat(finalString, containsString("Draupnir"));
    }

    @Test
    void testNullPlayerClass() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Player("Florian", "Grognak le barbare", CharacterType.valueOf("BERSERKER"), 100, new ArrayList<>())
        );
    }

    @Test
    void testNullMoneyValue() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 0, new ArrayList<>());
        p.addMoney(50);
        assertThat(p.getMoney(), is(50));
    }

    @Test
    @DisplayName("Impossible to have negative money")
    void testNegativeMoney() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());

        try {
            p.removeMoney(200);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    void testPlayerGetters() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 0, new ArrayList<>());
        assertThat(p.getCharacterType(), is(CharacterType.ADVENTURER.getTypeName()));
        assertThat(p.getHealthPoints(), is(100));
        assertThat(p.getEquipment(), is(new ArrayList<>()));
        assertThat(p.getCharacterName(), is("Grognak le barbare"));
    }

    @Test
    void testPlayerSellItem() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 0, new ArrayList<>());
        p.addEquipment(Equipment.MAGIC_BOW);
        p.addEquipment(Equipment.DRAUPNIR);
        p.sellEquipment(Equipment.MAGIC_BOW);
        assertThat(p.getEquipment().get(0), is(Equipment.DRAUPNIR));
        assertThat(p.sellEquipment(Equipment.MAGIC_CHARM), is("Your Inventory doesn't contain " + Equipment.MAGIC_CHARM.getName()));
    }

    @Test
    void testNegativeAmount() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        assertThrows(
                IllegalArgumentException.class,
                () -> p.removeMoney(-200)
        );
    }

    @Test
    void testAddNegativeAmount() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        p.addMoney(-200);
        assertThat(p.getMoney(), is(100));
    }

    @Test
    void testExceedingWeight() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        p.addEquipment(Equipment.MAGIC_BOW);
        p.addEquipment(Equipment.DRAUPNIR);
        p.addEquipment(Equipment.COMBAT_EDGE);
        assertThat(p.getEquipment().toArray().length, is(2));
    }

    @Test
    void testAddNullItem() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        p.addEquipment(null);
        assertThat(p.getEquipment().toArray().length, is(0));
    }

    @Test
    public void testDisplayInMarkdown() {
        ArrayList<Equipment> equipment = new ArrayList<>();
        equipment.add(Equipment.MAGIC_BOW);
        equipment.add(Equipment.DRAUPNIR);
        Player player = new Player(
                "Florian",
                "Grognak le barbare",
                CharacterType.ADVENTURER,
                100,
                equipment
        );

        String markdown = player.displayInMarkdown();

        String expectedMarkdown =
                "# Joueur : Grognak le barbare\n" +
                        "**Nom réel :** Florian  \n" +
                        "**Classe :** ADVENTURER  \n" +
                        "**HP :** 100  \n\n" +
                        "## Inventaire\n" +
                        "* **Magic Bow** - *A bow but with magic* (Poids : 100, Valeur : 200 pièces d'or)  \n" +
                        "* **Draupnir** - *Increases XP gained by 100%* (Poids : 20, Valeur : 100 pièces d'or)  \n";

        assertEquals(expectedMarkdown.strip(), markdown.strip());
    }

    @Test
    @DisplayName("Test de la valeur de retour de gainXp lors d'un level-up")
    void testGainXpReturnsTrueOnLevelUp() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        assertThat(player.gainXp(10), is(true));
    }

    @Test
    @DisplayName("Test de l'ajout d'objet à l'inventaire lors d'un level-up")
    void testItemAddedOnLevelUp() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        int initialInventorySize = player.getEquipment().size();
        player.gainXp(10);
        assertThat(player.getEquipment().size(), is(initialInventorySize + 1));
    }

    @Test
    @DisplayName("Test de la mise à jour des capacités après un level-up")
    void testAbilitiesUpdatedOnLevelUp() {
        Player player = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        player.gainXp(10);
        assertThat(player.getAttributes().get("CHA"), is(3));
    }

    @Test
    @DisplayName("Test GOBLIN niveau 1")
    void testGoblinLevel1() {
        Player player = new Player("Player1", "Grok", CharacterType.GOBLIN, 100, new ArrayList<>());
        assertThat(player.getAttributes().get("INT"), is(2));
        assertThat(player.getAttributes().get("ATK"), is(2));
        assertThat(player.getAttributes().get("ALC"), is(1));
    }

    @Test
    @DisplayName("Test GOBLIN niveau 5")
    void testGoblinLevel5() {
        Player player = new Player("Player1", "Grok", CharacterType.GOBLIN, 100, new ArrayList<>());
        player.gainXp(111); // Niveau 5
        assertThat(player.getAttributes().get("INT"), is(2));
        assertThat(player.getAttributes().get("ATK"), is(4));
        assertThat(player.getAttributes().get("DEF"), is(2));
        assertThat(player.getAttributes().get("VIS"), is(1));
    }

    @Test
    @DisplayName("Test du poids total de l'inventaire")
    void testTotalWeight() {
        Player p = new Player("Florian", "Grognak le barbare", CharacterType.ADVENTURER, 100, new ArrayList<>());
        p.addEquipment(Equipment.MAGIC_BOW);
        p.addEquipment(Equipment.DRAUPNIR);
        assertThat(p.totalWeight(), is(120));
    }

    @Test
    @DisplayName("Test de vente d'équipement")
    void testSellEquipment() {
        Player p = new Player("Florian", "Grognak", CharacterType.ADVENTURER, 100, new ArrayList<>());
        p.addEquipment(Equipment.MAGIC_BOW);
        int moneyBefore = p.getMoney();
        p.sellEquipment(Equipment.MAGIC_BOW);
        assertThat(p.getMoney(), is(moneyBefore + 200));
        assertThat(p.getEquipment().size(), is(0));
    }
}
