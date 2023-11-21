public class Goblin extends Monster {
    public Goblin(int[] position, int health, int damage) {
        super(position, health, damage);
    }
    public int getHealth() {
        return health;
    }
    @Override
    public void attack(Player player) {
        int damage = 3;
        player.takeDamage(damage);
        System.out.println("Гоблин атаковал вас и нанес " + damage + " урона.");
    }
}