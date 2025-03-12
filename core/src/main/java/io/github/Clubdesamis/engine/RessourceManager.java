package io.github.Clubdesamis.engine;

import com.badlogic.gdx.utils.Disposable;
import io.github.Clubdesamis.utils.StringUtils;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

//Has the role of creating and disposing of all elements it contains

public class RessourceManager implements Disposable {

    private HashMap<String, Disposable> ressources;
    private HashMap<String, RessourceLoader> loaders;

    private static final String assetsFolderPath = "assets/";

    public RessourceManager(){
        ressources = new HashMap<String, Disposable>();
        loaders = new HashMap<String, RessourceLoader>();

        initFileLoaders();
    }

    public void initFileLoaders(){
        loaders.put(".png", Image::load);
        loaders.put(".jpg", Image::load);
        loaders.put(".bmp", Image::load);
    }

    public void add(String relPath){
        //ressources.put()
    }

    public void addDir(String relPath, boolean doRecursion){
        File directory = new File(relPath);
        File[] files = directory.listFiles();
        String[] fileNames = new String[files.length];
        for(int i = 0; i < files.length; i++){
            fileNames[i] = StringUtils.getSanitizedFileName(files[i].getName());
        }

        for(int i = 0; i < files.length; i++){
            String fileFormat = StringUtils.getFileExtension(files[i].getName());
            //Determines if file is a file or a directory with an extension
            if(!fileFormat.equals("")){
                if(loaders.get(fileFormat) != null){
                    ressources.put(StringUtils.getSanitizedFileName(files[i].getName()), loaders.get(fileFormat).load(relPath + files[i].getName()));
                }
            }
            else{
                if(doRecursion){
                    addDir(relPath + files[i].getName(), doRecursion);
                }
            }
        }
    }

    public Disposable get(String name){
        return ressources.get(name);
    }

    public void remove(String name){
        ressources.get(name).dispose();
        ressources.remove(name);
    }

    public void dispose(){

        Iterator<HashMap.Entry<String, Disposable>> it = ressources.entrySet().iterator();

        while(it.hasNext()){
            HashMap.Entry<String, Disposable> entry = it.next();
            entry.getValue().dispose();
            it.remove();
        }
    }
}
