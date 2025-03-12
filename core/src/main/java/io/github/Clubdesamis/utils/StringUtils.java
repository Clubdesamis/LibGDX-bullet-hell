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

    //Get a file's name without its directory or extension
    public static String getSanitizedFileName(String path){
        int beginIndex, endIndex;
        for(endIndex = path.length() - 1; endIndex >= 0; endIndex--){
            if(path.charAt(endIndex) == '.'){
                //endIndex--;
                break;
            }
        }
        for(beginIndex = endIndex; beginIndex > 0; beginIndex--){
            if(path.charAt(beginIndex) == '/'){
                beginIndex++;
            }
        }
        return path.substring(beginIndex, endIndex);
    }

}
