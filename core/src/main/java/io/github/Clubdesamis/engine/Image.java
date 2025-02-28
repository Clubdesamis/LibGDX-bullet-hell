package io.github.Clubdesamis.engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public class Image extends VisualComponent implements Disposable {

    private Texture texture;

    public Image(String path){
        this.texture = new Texture(path);
    }

    public Image(Disposable texture){
        this.texture = (Texture)texture;
    }

    public void draw(Batch batch) {

    }

    public void dispose() {

    }

    public static Disposable load(String internalPath){
        return new Texture(internalPath);
    }

}
