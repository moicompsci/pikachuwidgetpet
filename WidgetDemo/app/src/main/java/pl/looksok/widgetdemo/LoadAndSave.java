package pl.looksok.widgetdemo;

import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Moises Martinez on 4/20/15.
 */
public class LoadAndSave {

    public static int totalNumberItems;
    public static int[] itemsNotFound= new int[]{R.drawable.i0, R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8,R.drawable.i9,R.drawable.i10,R.drawable.i11,R.drawable.i12,R.drawable.i13,R.drawable.i14,R.drawable.i15,R.drawable.i16,R.drawable.i17,R.drawable.i18,R.drawable.i19,R.drawable.i20,R.drawable.i21,R.drawable.i22,R.drawable.i23,R.drawable.i24,R.drawable.i25,R.drawable.i26,R.drawable.i27,R.drawable.i28,R.drawable.i29,R.drawable.i30,R.drawable.i31,R.drawable.i32,R.drawable.i33,R.drawable.i34,R.drawable.i35,R.drawable.i36,R.drawable.i37,R.drawable.i38,R.drawable.i39,R.drawable.i40,R.drawable.i41,R.drawable.i42,R.drawable.i43,R.drawable.i44,R.drawable.i45,R.drawable.i46,R.drawable.i47,R.drawable.i48,R.drawable.i49,R.drawable.i50,R.drawable.i51,R.drawable.i52,R.drawable.i53,R.drawable.i54,R.drawable.i55,R.drawable.i56,R.drawable.i57,R.drawable.i58,R.drawable.i59,R.drawable.i60,R.drawable.i61,R.drawable.i62,R.drawable.i63,R.drawable.i64,R.drawable.i65,R.drawable.i66,R.drawable.i67,R.drawable.i68,R.drawable.i69,R.drawable.i70,R.drawable.i71,R.drawable.i72,R.drawable.i73,R.drawable.i74,R.drawable.i75,R.drawable.i76,R.drawable.i77,R.drawable.i88,R.drawable.i89,R.drawable.i90,R.drawable.i91,R.drawable.i92,R.drawable.i93,R.drawable.i94};
    public static int watts;
    public static float timeStart;
    public static int level;
    public static String gender;
    public static int loveNeededToNextLevel;
    public static int data_block = 100;
    public static int z;


    public LoadAndSave(){  //new game
            Random rand = new Random();
            watts = 0;
            timeStart = System.currentTimeMillis();
            level = 1;
            int g = rand.nextInt(1);
            if (g == 0) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            loveNeededToNextLevel = 100;
            z =1;
            SaveEverything();
    }
    public static int LoadZ(){
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");
            File file = new File(directory, "z.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data = "";
            int size;
            try {
                while ((size = isr.read(data)) > 0) {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data += read_data;
                    z = Integer.parseInt(final_data);
                    data = new char[data_block];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return z;
    }
    public static int LoadWatts(){
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");
            File file = new File(directory, "wattstatus.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data = "";
            int size;
            try {
                while ((size = isr.read(data)) > 0) {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data += read_data;
                    watts = Integer.parseInt(final_data);
                    data = new char[data_block];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return watts;
    }
    public static float LoadTimeStart(){
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");
            File file = new File(directory, "timestart.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data = "";
            int size;
            try {
                while ((size = isr.read(data)) > 0) {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data += read_data;
                    timeStart = Integer.parseInt(final_data);
                    data = new char[data_block];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return timeStart;
    }

    public static int LoadLevel(){
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");
            File file = new File(directory, "level.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data = "";
            int size;
            try {
                while ((size = isr.read(data)) > 0) {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data += read_data;
                    level = Integer.parseInt(final_data);
                    data = new char[data_block];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return level;
    }
    public static String LoadGender(){
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");
            File file = new File(directory, "gender.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data = "";
            int size;
            try {
                while ((size = isr.read(data)) > 0) {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data += read_data;
                    gender = final_data;
                    data = new char[data_block];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gender;
    }
    public static int LoadLoveNeededToNextLevel(){
        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");
            File file = new File(directory, "loveneeded.txt");

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] data = new char[data_block];
            String final_data = "";
            int size;
            try {
                while ((size = isr.read(data)) > 0) {
                    String read_data = String.copyValueOf(data, 0, size);
                    final_data += read_data;
                    loveNeededToNextLevel = Integer.parseInt(final_data);
                    data = new char[data_block];
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return loveNeededToNextLevel;
    }

    public static void SaveWatt(int wat){
        File sdcard = Environment.getExternalStorageDirectory();
        File directory = new File(sdcard.getAbsolutePath() + "/pokepet");

        File file = new File(directory, "wattstatus.txt");
        FileOutputStream fou = null;
        try {
            fou = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fou);
        try {
            osw.write(wat);
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void SaveEverything(){


        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/pokepet");


            /////////////////////////////////////////////////////////////////
            File timestartfile = new File(directory, "timestart.txt");
            FileOutputStream fotsCB = new FileOutputStream(timestartfile);
            OutputStreamWriter ostwCB = new OutputStreamWriter(fotsCB);
            /////////////////////////////////////////////////////////////////
            File levelfile = new File(directory, "level.txt");
            FileOutputStream lfCB = new FileOutputStream(levelfile);
            OutputStreamWriter ofCB = new OutputStreamWriter(lfCB);
            /////////////////////////////////////////////////////////////////
            File genderfile = new File(directory, "gender.txt");
            FileOutputStream lgCB = new FileOutputStream(genderfile);
            OutputStreamWriter ogCB = new OutputStreamWriter(lgCB);
            /////////////////////////////////////////////////////////////////
            File loveneededfile = new File(directory, "loveneeded.txt");
            FileOutputStream lnCB = new FileOutputStream(loveneededfile);
            OutputStreamWriter lvnCB = new OutputStreamWriter(lnCB);
            /////////////////////////////////////////////////////////////////
            File zfile = new File(directory, "z.txt");
            FileOutputStream zCB = new FileOutputStream(zfile);
            OutputStreamWriter znCB = new OutputStreamWriter(zCB);

            try {


                ostwCB.write(getTimeStart());
                ostwCB.flush();
                ostwCB.close();

                ofCB.write(getLevel());
                ofCB.flush();
                ofCB.close();

                ogCB.write(getGender());
                ogCB.flush();
                ogCB.close();

                lvnCB.write(getLoveNeeded());
                lvnCB.flush();
                lvnCB.close();

                znCB.write(getZ());
                znCB.flush();
                znCB.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static String getWatts(){
        return Integer.toString(watts);
    }
    public static String getTimeStart(){
        return Float.toString(timeStart);
    }
    public static String getLevel(){
        return Integer.toString(level);
    }
    public static String getGender(){
        return gender;
    }
    public static String getLoveNeeded(){
        return Integer.toString(loveNeededToNextLevel);
    }
    public static String getZ(){
        return Integer.toString(z);
    }

}
