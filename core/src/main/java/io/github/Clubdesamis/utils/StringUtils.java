package io.github.Clubdesamis.utils;

public class StringUtils {

    public static String getFileExtension(String fileName){
        int beginIndex = 0;
        for(beginIndex = fileName.length() - 1; beginIndex >= 0; beginIndex--){
            if(fileName.charAt(beginIndex) == '.'){
                break;
            }
        }
        return fileName.substring(beginIndex);
    }

    public static String getSanitizedFileName(String path){
        int beginIndex = 0;
        //for(beginIndex = path.length())
        return null;
    }

}
