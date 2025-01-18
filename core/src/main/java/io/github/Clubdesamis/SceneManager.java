package io.github.Clubdesamis;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Hashtable;

public class SceneManager {

private Hashtable<String, Scene> scenes;
private ArrayList<Scene> sceneStack;

public SceneManager(){
    scenes = new Hashtable<String, Scene>();
    sceneStack = new ArrayList<Scene>();
}

public void addScene(Scene scene){
    scenes.put(scene.getName(), scene);

}

public void pushScene(String name) throws Exception{
    if(scenes.containsKey(name)){
        scenes.get(name).init();
        sceneStack.add(scenes.get(name));
    }
    else{
        throw new Exception("Invalid scene key in SceneManager.push()");
    }
}

public void pop(){
    if(sceneStack.size() > 0){
        sceneStack.get(sceneStack.size() - 1).close();
        sceneStack.remove(sceneStack.size() - 1);
    }
}

public void update(){
    for(int i = sceneStack.size() - 1; i >= 0; i--){
        if(!sceneStack.get(i).update()){
            break;
        }
    }
}

public void render(SpriteBatch batch){
    for(int i = sceneStack.size() - 1; i >= 0; i--){
        if(!sceneStack.get(i).render(batch)){
            break;
        }
    }
}

}
