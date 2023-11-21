import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Room {
    private static final char PLAYER_SYMBOL = 'P';
    private static final char MONSTER_SYMBOL = 'M';
    private static final char ITEM_SYMBOL = 'I';
    private static final char POTION_SYMBOL = 'H';

    private char[][] grid;
    private int size;
    private List<Monster> monsters;
    private Item potion;
    private List<Item> items;

    public Room(int size) {
        this.size = size;
        grid = new char[size][size];
        monsters = new ArrayList<>();
        potion = null;
        items = new ArrayList<>();
        initializeGrid();
    }

    public int getSize() {
        return size;
    }

    public void displayRoom() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public int[] getRandomPosition() {
        Random random = new Random();
        int row = random.nextInt(size);
        int col = random.nextInt(size);
        return new int[]{row, col};
    }

    public void setPosition(int[] position, char symbol) {
        int row = position[0];
        int col = position[1];
        if (row >= 0 && row < size && col >= 0 && col < size) {
            grid[row][col] = symbol;
        }
    }

    public void clearPosition(int[] position) {
        int row = position[0];
        int col = position[1];
        if (row >= 0 && row < size && col >= 0 && col < size) {
            grid[row][col] = '-';
        }
    }

    public char getSymbolAtPosition(int[] position) {
        int row = position[0];
        int col = position[1];
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return grid[row][col];
        }
        return '-';
    }

    public Monster getMonsterAtPosition(int[] position) {
        for (Monster monster : monsters) {
            if (Arrays.equals(monster.getPosition(), position)) {
                return monster;
            }
        }
        return null;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
        setPosition(monster.getPosition(), MONSTER_SYMBOL);
    }

    public void removeMonster(Monster monster, GameManager gameManager) {
        monsters.remove(monster);
        clearPosition(monster.getPosition());
        if (gameManager != null) {
            generatePotion(monster.getPosition(), gameManager);
        }
    }
    public void generatePotion(int[] playerPosition, GameManager gameManager) {
        Random random = new Random();
        int potionRow;
        int potionCol;

        do {
            potionRow = random.nextInt(size);
            potionCol = random.nextInt(size);
        } while (grid[potionRow][potionCol] != '-' ||
                (potionRow == playerPosition[0] && potionCol == playerPosition[1]) ||
                isMonsterPosition(potionRow, potionCol));

        int[] potionPosition = new int[]{potionRow, potionCol};
        potion = new Potion(potionPosition);
        setPosition(potionPosition, POTION_SYMBOL);
    }

    private boolean isMonsterPosition(int row, int col) {
        for (Monster monster : monsters) {
            int[] position = monster.getPosition();
            if (position[0] == row && position[1] == col) {
                return true;
            }
        }
        return false;
    }

    public void removePotion() {
        if (potion != null) {
            clearPosition(potion.getPosition());
            potion = null;
        }
    }

    public Item getPotion() {
        return potion;
    }

    public void addItem(Item item) {
        items.add(item);
        setPosition(item.getPosition(), ITEM_SYMBOL);
    }

    public void removeItem(Item item) {
        items.remove(item);
        clearPosition(item.getPosition());
    }

    public Item getItemAtPosition(int[] position, Direction direction) {
        int[] targetPosition = calculateTargetPosition(position, direction);
        char symbol = getSymbolAtPosition(targetPosition);

        if (symbol == ITEM_SYMBOL) {
            return items.stream()
                    .filter(item -> Arrays.equals(item.getPosition(), targetPosition))
                    .findFirst()
                    .orElse(null);
        } else if (symbol == POTION_SYMBOL) {
            return potion;
        }

        return null;
    }

    private int[] calculateTargetPosition(int[] position, Direction direction) {
        int[] targetPosition = position.clone();
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


    public Monster getMonster() {
        if (!monsters.isEmpty()) {
            return monsters.get(0);
        }
        return null;
    }

}