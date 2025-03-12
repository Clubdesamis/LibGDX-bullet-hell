package io.github.Clubdesamis.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import io.github.Clubdesamis.engine.RessourceManager;
import io.github.Clubdesamis.engine.Scene;

import java.io.File;

public class TestScene extends Scene {

    private RessourceManager textureManager;

    public TestScene(String name){
        super(name);

        //File directory = new File("./Textures");
        //File[] files = directory.listFiles();

        textureManager = new RessourceManager();

        textureManager.addDir("./Textures/", true);

    }
    public void init(){
        //textureManager.
    }

    public void dispose(){
        textureManager.dispose();
    }
    public boolean update(){
        return false;
    }

    public boolean render(SpriteBatch batch){
        return false;
    }



}
