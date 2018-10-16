package se.chalmers.group22.gymcompanion.Model;

import android.content.Context;
import android.util.Log;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;

import java.io.*;
import java.util.List;

public class LocalDatabase {
    private static final String FILENAME = "database.txt";

    private static LocalDatabase localDatabase;
    private static Context context;

    private Parser parser;

    private LocalDatabase(){
        parser = new Parser();
        parser.parseJson();
    }

    public static LocalDatabase getInstance(){
        if(localDatabase == null){
            localDatabase = new LocalDatabase();
        }
        context = GymCompanionContext.getContext();
        return localDatabase;
    }

    public void saveUser(User user){
        FileOutputStream fos;
        ObjectOutputStream os;
        try{
            fos = new FileOutputStream("user.ser");
            //fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject(user);
            Log.i("LocalDataBase", user.toString());
            os.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public User loadUser(){
        File file = new File(FILENAME);
        if(!file.exists())
        {
            return new User("Test User", "Test Gym", 10, 10, true);
        }

        User loadedUser = null;
        FileInputStream fis;
        ObjectInputStream is;
        try{
            //fis = context.openFileInput(FILENAME);
            fis = new FileInputStream("user.ser");
            is = new ObjectInputStream(fis);
            loadedUser = (User) is.readObject();
            is.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return loadedUser;
    }

    public List<Exercise> loadTotalExercises(){
        return parser.getExercises();
    }

    public List<Routine> loadTotalRoutines(){
        return parser.getRoutines();
    }
}
