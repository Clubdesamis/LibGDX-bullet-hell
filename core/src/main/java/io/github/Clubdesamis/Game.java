package io.github.Clubdesamis;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("smallPurpleProjectile.png");

        font = new BitmapFont();

        Gdx.graphics.setForegroundFPS(10000);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();



        font.draw(batch, Integer.toString(Gdx.graphics.getFramesPerSecond()), (float)10.0, (float)520.0);

        for(int i = 0; i < 200; i++){
            batch.draw(image, 140, 0);
        }


        batch.end();
        //System.out.println(Integer.toString(Gdx.graphics.getFramesPerSecond()));
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
