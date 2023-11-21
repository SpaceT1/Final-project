public class Potion implements Item {
    private int healingAmount;
    private int[] position;

    public Potion(int[] position) {
        this.healingAmount = 15;
        this.position = position;
    }
    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public void use(Player player) {
        int currentHealth = player.getHealth();
        int newHealth = currentHealth + healingAmount;
        int maxHealth = 30;

        if (newHealth > maxHealth) {
            player.setHealth(maxHealth);
        } else {
            player.setHealth(newHealth);
        }

        System.out.println("Зелье использовано игроком. Восстановлено " + (player.getHealth() - currentHealth) + " единиц здоровья. Текущее здоровье " + player.getHealth());
    }

    @Override
    public int[] getPosition() {
        return position;
    }
}