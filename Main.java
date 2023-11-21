public class Main {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();

        Room room = new Room(3);
        gameManager.setCurrentRoom(room);

        int[] playerPosition = room.getRandomPosition();
        Player player = new Player(playerPosition);

        room.setPosition(playerPosition, 'P');
        gameManager.setPlayer(player);

        MonsterFactory factory = MonsterFactory.getRandomFactory();
        Monster monster1 = factory.createMonster(room);
        Monster monster2 = factory.createMonster(room);

        room.addMonster(monster1);
        room.addMonster(monster2);
        room.generatePotion(player.getPosition(), gameManager);

        gameManager.printCurrentRoomDescription();

        CommandLineInterface cli = new CommandLineInterface(gameManager);
        cli.start();
    }
}
