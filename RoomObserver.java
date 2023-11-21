public class RoomObserver implements Observer {
    private GameManager gameManager;

    public RoomObserver(GameManager gameManager) {
        this.gameManager = gameManager;
        gameManager.registerObserver(this);
        System.out.println("RoomObserver created and registered.");
    }

    @Override
    public void update() {
        System.out.println("Player has moved. Updating RoomObserver.");
    }

}