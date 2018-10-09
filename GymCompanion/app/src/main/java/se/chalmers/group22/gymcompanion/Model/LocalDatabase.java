package se.chalmers.group22.gymcompanion.Model;

import android.content.Context;
import lombok.Getter;

import java.io.*;

public class LocalDatabase {
    private static final String FILENAME = "database.txt";

    private static LocalDatabase localDatabase;
    private static Context context;

    private LocalDatabase(){
    }

    public static LocalDatabase getInstance(){
        if(localDatabase == null){
            localDatabase = new LocalDatabase();
        }
        context = GymCompanion.getContext();
        return localDatabase;
    }

    public void saveUser(User user){
        FileOutputStream fos;
        ObjectOutputStream os;
        try{
            fos = new FileOutputStream(FILENAME);
            os = new ObjectOutputStream(fos);
            os.writeObject(user);
            os.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public User loadUser(){
        User loadedUser = null;
        File file = new File(FILENAME);
        if(file.exists()){
            FileInputStream fis;
            ObjectInputStream is;
            try{
                fis = new FileInputStream(file);
                is = new ObjectInputStream(fis);
                loadedUser = (User) is.readObject();
                is.close();
                fis.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        return loadedUser;
    }
}
