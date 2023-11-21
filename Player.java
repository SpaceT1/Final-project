import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Player {
    private int health;
    private List<Item> inventory;
    private Item currentWeapon;
    private int[] position;

    public Player(int[] position) {
        this.health = 30;
        this.inventory = new ArrayList<>();
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    private int[] calculateTargetPosition(Direction direction) {
        int[] currentPosition = getPosition();
        int[] targetPosition = currentPosition.clone();
        switch (direction) {
            case UP:
                targetPosition[0]--;
                break;
            case DOWN:
                targetPosition[0]++;
                break;
            case LEFT:
                targetPosition[1]--;
                break;
            case RIGHT:
                targetPosition[1]++;
                break;
        }
        return targetPosition;
    }

    public void heal(int amount) {
        health += amount;
    }

    public void useItem(Item item) {
        if (item instanceof Potion) {
            Potion potion = (Potion) item;
            int healingAmount = potion.getHealingAmount();
            heal(healingAmount);
            System.out.println("Использовано зелье. Восстановлено " + healingAmount + " единиц здоровья.");
        } else {
            System.out.println("Невозможно использовать данный предмет.");
        }
    }


    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}