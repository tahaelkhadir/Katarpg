package re.forestier.edu;

import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.game.Player;

import java.util.ArrayList;

import static org.approvaltests.Approvals.verify;

public class GlobalTest {

   
    // @Test
    void testAffichageBase() {
        re.forestier.edu.rpg.character.CharacterType characterType = re.forestier.edu.rpg.character.CharacterType.ADVENTURER;
        Player player = new Player("Florian", "Gnognak le Barbare", characterType, 200, new ArrayList<>());
        player.gainXp(20);

        verify(player.displayPlayer());
    }
}
