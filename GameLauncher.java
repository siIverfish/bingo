import com.badlogic.gdx.Game;

public class GameLauncher extends Game {
    @Override
    public void create() {
        this.setScreen(new GameScreen(this));
    }

    public static void main(String[] args) {
        com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration config = new com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration();
        config.title = "Bullet Dodger";
        config.width = 800;
        config.height = 600;
        new com.badlogic.gdx.backends.lwjgl.LwjglApplication(new GameLauncher(), config);
    }
}
