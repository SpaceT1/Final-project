public class Orc extends Monster {
    public Orc(int[] position, int health, int damage) {
        super(position, health, damage);
    }
    public int getHealth() {
        return health;
    }

    @Override
    public void attack(Player player) {
        int damage = 10;
        player.takeDamage(damage);
        System.out.println("Орк атаковал вас и нанес " + damage + " урона.");
    }
}