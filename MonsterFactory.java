import java.util.Random;
import java.util.Arrays;

public abstract class MonsterFactory {
    public abstract Monster createMonster(Room room);
    public abstract MonsterType getRandomMonsterType();

    public static MonsterFactory getRandomFactory() {
        Random random = new Random();
        int factoryType = random.nextInt(2);

        if (factoryType == 0) {
            return new SimpleMonsterFactory();
        } else {
            return new StrongMonsterFactory();
        }
    }
}



class SimpleMonsterFactory extends MonsterFactory {
    @Override
    public MonsterType getRandomMonsterType() {
        Random random = new Random();
        int monsterType = random.nextInt(2);

        if (monsterType == 0) {
            return MonsterType.SKELETON;
        } else {
            return MonsterType.GOBLIN;
        }
    }
    @Override
    public Monster createMonster(Room room) {
        Random random = new Random();
        int hp = 0;
        int damage = 0;
        int[] position = room.getRandomPosition();
        MonsterType monsterType = getRandomMonsterType();

        System.out.println("Created monster at position: " + Arrays.toString(position));

        switch (monsterType) {
            case SKELETON:
                hp = random.nextInt(30) + 1;
                return new Skeleton(position, hp, damage);
            case GOBLIN:
                hp = random.nextInt(30) + 1;
                return new Goblin(position, hp, damage);
            default:
                throw new IllegalArgumentException("Invalid monster type: " + monsterType);
        }
    }
}
class StrongMonsterFactory extends MonsterFactory {
    @Override
    public MonsterType getRandomMonsterType() {
        Random random = new Random();
        int monsterType = random.nextInt(2);

        if (monsterType == 0) {
            return MonsterType.HOBGOBLIN;
        } else {
            return MonsterType.ORC;
        }
    }
    @Override
    public Monster createMonster(Room room) {
        Random random = new Random();
        int hp = 0;
        int damage = 0;
        int[] position = room.getRandomPosition();
        MonsterType monsterType = getRandomMonsterType();

        System.out.println("Created monster at position: " + Arrays.toString(position));

        switch (monsterType) {
            case HOBGOBLIN:
                hp = random.nextInt(21) + 30;
                return new Hobgoblin(position, hp, damage);
            case ORC:
                hp = random.nextInt(21) + 30;
                return new Orc(position, hp, damage);
            default:
                throw new IllegalArgumentException("Invalid monster type: " + monsterType);
        }
    }
}