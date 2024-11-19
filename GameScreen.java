import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private Player player;
    private Array<Enemy> enemies;
    private Array<Bullet> bullets;

    public GameScreen(GameLauncher game) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        player = new Player(400, 300);
        enemies = new Array<>();
        bullets = new Array<>();

        // Add enemies at predetermined positions
        enemies.add(new Enemy(100, 500));
        enemies.add(new Enemy(700, 500));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        player.render(game.getBatch());
        for (Enemy enemy : enemies) enemy.render(game.getBatch());
        for (Bullet bullet : bullets) bullet.render(game.getBatch());
        game.getBatch().end();

        player.update(delta);
        for (Enemy enemy : enemies) enemy.update(delta, bullets);
        for (Bullet bullet : bullets) bullet.update(delta);

        checkCollisions();
    }

    private void checkCollisions() {
        for (Bullet bullet : bullets) {
            if (bullet.getBounds().overlaps(player.getBounds())) {
                System.out.println("Game Over!");
                Gdx.app.exit();
            }
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {}
}
