import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class GameManager {
    private static GameManager instance = null;
    private Room currentRoom;
    private Player player;
    private List<Observer> observers;

    private GameManager() {
        observers = new ArrayList<>();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public void movePlayer(Direction direction) {
        int[] newPosition = calculateNewPosition(direction);
        if (isValidPosition(newPosition)) {
            if (!isMonsterAtPosition(newPosition)) {
                currentRoom.clearPosition(player.getPosition());
                player.setPosition(newPosition);
                currentRoom.setPosition(player.getPosition(), 'P');
                notifyObservers();
            } else {
                System.out.println("Монстр в этом направлении. Вы не можете перемещаться на клетку монстра.");
            }
        } else {
            System.out.println("Неверное перемещение или монстр блокирует путь.");
        }
    }



    public void attackMonster(Direction attackDirection) {
        Player currentPlayer = getPlayer();
        int[] playerPosition = currentPlayer.getPosition();
        int[] targetPosition = calculateTargetPosition(playerPosition, attackDirection);

        Monster monster = currentRoom.getMonsterAtPosition(targetPosition);
        if (monster != null) {
            int damage = 15;
            System.out.println("Ты атаковал монстра и нанес " + damage + " урона.");
            monster.takeDamage(damage);

            if (monster.getHealth() <= 0) {
                currentRoom.removeMonster(monster, this);
                System.out.println("Ты победил монстра! Твое здоровье: " + currentPlayer.getHealth());
            } else {
                monster.attack(currentPlayer);
                if (currentPlayer.getHealth() <= 0) {
                    System.out.println("Ты был побежден!");
                } else {
                    System.out.println("Твое здоровье: " + currentPlayer.getHealth());
                }
            }
        } else {
            System.out.println("There is no monster to attack.");
        }
    }
    private int[] calculateTargetPosition(int[] currentPosition, Direction attackDirection) {
        int[] targetPosition = currentPosition.clone();
        switch (attackDirection) {
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



    private int[] calculateNewPosition(Direction direction) {
        int[] currentPosition = player.getPosition();
        int[] newPosition = currentPosition.clone();
        switch (direction) {
            case UP:
                newPosition[0]--;
                break;
            case DOWN:
                newPosition[0]++;
                break;
            case LEFT:
                newPosition[1]--;
                break;
            case RIGHT:
                newPosition[1]++;
                break;
        }
        return newPosition;
    }

    private boolean isValidPosition(int[] position) {
        int row = position[0];
        int col = position[1];
        return row >= 0 && row < currentRoom.getSize() && col >= 0 && col < currentRoom.getSize();
    }

    private boolean isMonsterAtPosition(int[] position) {
        return currentRoom.getMonsterAtPosition(position) != null;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public void printCurrentRoomDescription() {
        currentRoom.displayRoom();
    }

    public void printInventory() {
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Инвентарь пуст.");
        } else {
            System.out.println("Инвентарь:");
            for (Item item : inventory) {
                System.out.println(item.toString());
            }
        }
    }

    public void usePotion(Direction direction) {
        Player currentPlayer = getPlayer();
        int[] playerPosition = currentPlayer.getPosition();
        Item potion = currentRoom.getItemAtPosition(playerPosition, direction);

        if (potion instanceof Potion) {
            currentPlayer.useItem((Potion) potion);
            currentRoom.removePotion();
            System.out.println("Вы использовали зелье и восстановили здоровье.");
        } else {
            System.out.println("Здесь нет зелья для использования.");
        }
    }

    public void pickUpItem(Direction direction) {
        Player player = getPlayer();
        int[] playerPosition = player.getPosition();

        int[] targetPosition = calculateNewPosition(direction);
        if (isValidPosition(targetPosition) && !isMonsterAtPosition(targetPosition)) {
            Room currentRoom = getCurrentRoom();
            Item item = currentRoom.getItemAtPosition(playerPosition, direction);
            if (item != null) {
                player.addItem(item);
                currentRoom.removeItem(item);
                System.out.println("Предмет подобран.");
            } else {
                System.out.println("Здесь нет предмета для подбора.");
            }
        } else {
            System.out.println("Неверное направление или монстр блокирует путь.");
        }
    }
    public void useItem(int itemIndex) {
        Player currentPlayer = getPlayer();
        List<Item> inventory = currentPlayer.getInventory();

        if (itemIndex >= 0 && itemIndex < inventory.size()) {
            Item item = inventory.get(itemIndex);

            if (item instanceof Potion) {
                Potion usableItem = (Potion) item;
                usableItem.use(currentPlayer);
                inventory.remove(item);
                System.out.println("Предмет использован.");
            } else {
                System.out.println("Этот предмет нельзя использовать.");
            }
        } else {
            System.out.println("Неверный индекс предмета.");
        }
    }


}