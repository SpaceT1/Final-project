public class Skeleton extends Monster {
    public Skeleton(int[] position, int health, int damage) {
        super(position, health, damage);
    }
    public int getHealth() {
        return health;
    }

    @Override
    public void attack(Player player) {
        int damage = 5; // Placeholder for actual damage calculation
        player.takeDamage(damage);
        System.out.println("Скелет атакует тебя клинком и наносит " + damage + " урона.");
    }
}