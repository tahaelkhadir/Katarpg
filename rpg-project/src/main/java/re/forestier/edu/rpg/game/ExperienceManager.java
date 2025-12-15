package re.forestier.edu.rpg.game;


public class ExperienceManager {
    private int xp;
    private static final int[] XP_THRESHOLDS = {0, 10, 27, 57, 111};

    public ExperienceManager() {
        this.xp = 0;
    }

    public int getXp() {
        return this.xp;
    }

   
    public int addXp(int amount) {
        xp += amount;
        return xp;
    }

    
    public int getLevel() {
        for (int level = 1; level < XP_THRESHOLDS.length; level++) {
            if (this.xp < XP_THRESHOLDS[level]) {
                return level;
            }
        }
        return XP_THRESHOLDS.length; 
    }
}
