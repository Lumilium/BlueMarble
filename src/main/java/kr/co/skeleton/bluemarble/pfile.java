package kr.co.skeleton.bluemarble;


import java.io.*;
import java.util.Properties;
import java.util.UUID;

public class pfile {
    public static void Aaddp(String file, UUID u, String txt) {
        String Uid = u.toString();
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        prop.setProperty(Uid, txt);

        try {
            prop.save(new FileOutputStream(file), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String Loadp(String file, UUID u) {
        Properties prop  = new Properties();
        String Uid = u.toString();

        try {
            InputStream stream = new FileInputStream(file);
            prop.load(stream);
            stream.close();

            String result = prop.getProperty(Uid);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}