package com.rpg.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rpg.model.BattleField;

/**
 * Utils to deal with file.
 *
 * @author vijaykumar.s
 * @com.rpg.copyright@
 */
public class FileUtils {

    private FileUtils() {
        //hides constructor.
    }

    /**
     * Writes an object into a file.
     *
     * @param serObj
     * @param fileName
     * @return 1 or 0
     * @since 1.0-SNAPSHOT.
     */
    public static int writeObjectToFile(Object serObj, String fileName) {
        try {
            try (FileOutputStream fileOut = new FileOutputStream(PropertyUtils.getPropertyValue("base.dir") + fileName + ".ser")) {
                try (ObjectOutputStream
                             objectOut = new ObjectOutputStream(fileOut)) {
                    objectOut.writeObject(serObj);
                }
            }
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Reads an object from the file.
     *
     * @param serObj
     * @since 1.0-SNAPSHOT.
     */
    public static void readObjectFromFile(Object serObj) {
        try {
//            TODO : Refactor the code.
            FileInputStream fileOut = new FileInputStream("C:\\Temp\\game.ser");
            ObjectInputStream
                    objectOut = new ObjectInputStream(fileOut);
            Object o = objectOut.readObject();
            System.out.println(o instanceof BattleField);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
