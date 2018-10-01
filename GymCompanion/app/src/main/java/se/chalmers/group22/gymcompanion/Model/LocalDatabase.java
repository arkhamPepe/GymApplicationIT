package se.chalmers.group22.gymcompanion.Model;

import android.content.Context;
import lombok.Getter;

import java.io.*;

public class LocalDatabase {
    private static final String filename = "database.txt";

    @Getter
    private LocalDatabase localDatabase;

    private LocalDatabase(){}

    public LocalDatabase getInstance(){
        if(localDatabase == null){
            localDatabase = new LocalDatabase();
        }
        return localDatabase;
    }

    public void saveUser(Context context, User user){
        FileOutputStream fos;
        ObjectOutputStream os;
        try{
            fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject(user);
            os.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public User loadUser(Context context){
        FileInputStream fis;
        ObjectInputStream is;
        User loadedUser = null;
        try{
            fis = context.openFileInput(filename);
            is = new ObjectInputStream(fis);
            loadedUser = (User) is.readObject();
            is.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return loadedUser;
    }
}
