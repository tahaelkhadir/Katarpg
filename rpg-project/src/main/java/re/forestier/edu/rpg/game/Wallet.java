package re.forestier.edu.rpg.game;


public class Wallet {
    private int money;

    public Wallet(int initialMoney) {
        this.money = Math.max(initialMoney, 0); 
    }

    
    public void addMoney(int amount) {
        if (amount > 0) {
            this.money += amount;
        }
    }

    
    public void removeMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative!");
        }
        if (this.money < amount) {
            throw new IllegalArgumentException("Insufficient funds!");
        }
        this.money -= amount;
    }

    public int getMoney() {
        return this.money;
    }
}
