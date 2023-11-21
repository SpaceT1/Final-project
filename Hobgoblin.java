public class Hobgoblin extends Monster {
    public Hobgoblin(int[] position, int health, int damage) {
        super(position, health, damage);
    }
    public int getHealth() {
        return health;
    }
    @Override
    public void attack(Player player) {
        int damage = 8; // Здесь можно добавить реальный расчет урона
        player.takeDamage(damage);
        System.out.println("Хобгоблин атаковал вас и нанес " + damage + " урона.");
    }
}