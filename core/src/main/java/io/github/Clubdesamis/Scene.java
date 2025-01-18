package io.github.Clubdesamis;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene {

    private String name;

    public Scene(String name){
        this.name = name;
    }

    public abstract void init();

    public abstract void close();

    public abstract boolean update();

    public abstract boolean render(SpriteBatch batch);

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


}
