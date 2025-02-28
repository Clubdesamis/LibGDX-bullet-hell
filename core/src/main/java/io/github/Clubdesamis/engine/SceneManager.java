package io.github.Clubdesamis.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import io.github.Clubdesamis.engine.Scene;

import java.util.*;

public class SceneManager implements Disposable {

private HashMap<String, Scene> scenes;
private ArrayList<Scene> sceneStack;

public SceneManager(){
    scenes = new HashMap<String, Scene>();
    sceneStack = new ArrayList<Scene>();
}

public void addScene(Scene scene){
    scenes.put(scene.getName(), scene);
}

public void removeScene(Scene scene){
    scenes.remove(scene);
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
        sceneStack.get(sceneStack.size() - 1).dispose();
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

    @Override
    public void dispose() {
        Iterator<HashMap.Entry<String, Scene>> it = scenes.entrySet().iterator();
        while(it.hasNext()){
            HashMap.Entry<String, Scene> entry = it.next();
            entry.getValue().dispose();
            it.remove();
        }
        sceneStack.clear();
    }
}
