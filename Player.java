import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private float x, y;
    private Texture texture;
    private Rectangle bounds;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.texture = new Texture("player.png");
        this.bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += 200 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= 200 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 200 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 200 * delta;

        bounds.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}
