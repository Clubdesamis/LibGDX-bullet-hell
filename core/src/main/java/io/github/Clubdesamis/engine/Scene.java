package io.github.Clubdesamis.engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public abstract class Scene implements Disposable {

    private String name;

    public Scene(String name){
        this.name = name;
    }

    public abstract void init();

    public abstract boolean update();

    public abstract boolean render(SpriteBatch batch);

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


}
