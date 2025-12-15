package re.forestier.edu;

import re.forestier.edu.rpg.character.CharacterType;
import re.forestier.edu.rpg.game.Player;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Florian", "Ruzberg de Rivehaute", CharacterType.ADVENTURER, 200, new ArrayList<>());
        firstPlayer.addMoney(400);

        firstPlayer.gainXp(15);
        System.out.println(firstPlayer.displayPlayer());
        System.out.println("------------------");
        firstPlayer.gainXp(20);
        System.out.println(firstPlayer.displayPlayer());
    }
}
