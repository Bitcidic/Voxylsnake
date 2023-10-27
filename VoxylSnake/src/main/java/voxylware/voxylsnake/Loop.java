package voxylware.voxylsnake;

public class Loop implements Runnable {
    private boolean gameRunning;
    private float frameInterval;
    private Game game;
    public Loop(Game game, int frameRate) {
        this.game = game;
        this.frameInterval = 1000.0f / frameRate;
        this.gameRunning = true;
    }

    @Override
    public void run() {
        game.setup();
        while (gameRunning && !game.gameOver()) {
            float time = System.currentTimeMillis();
            game.tick();
            time = System.currentTimeMillis() - time;
            if (time < frameInterval) {
                try {
                    Thread.sleep((long) (frameInterval - time));
                } catch (InterruptedException ignore) {}
            }
        }
    }

    public void toggleRunning() {
        gameRunning = !gameRunning;
    }
}
