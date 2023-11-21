public abstract class Monster {
    protected int[] position;
    protected int health;
    protected int damage;

    public Monster(int[] position, int health, int damage) {
        this.position = position;
        this.health = health;
        this.damage = damage;
    }

    public int[] getPosition() {
        return position;
    }

    public abstract void attack(Player player);


    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("Монстр погиб");
        } else {
            System.out.println("Монстр получил урон. Здоровье: " + health);
        }
    }

    public int getHealth() {
        return health;
    }
}