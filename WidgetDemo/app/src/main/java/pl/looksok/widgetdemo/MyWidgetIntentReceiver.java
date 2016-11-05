package pl.looksok.widgetdemo;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.RemoteViews;

public class MyWidgetIntentReceiver extends BroadcastReceiver {// implements SensorEventListener,StepListener

	//private static int clickCount = 0;
    private static Context globalContext;
    private MyTask mTask;
    Intent globalIntent;
    Intent returnIntent;
    private static int key=0;
    private static Boolean fuckYou = true;
    private int [] defaultslides ={R.drawable.default2,R.drawable.default3,R.drawable.default4,R.drawable.default5,R.drawable.default6,R.drawable.default7,R.drawable.default8,R.drawable.default9,R.drawable.default10,R.drawable.default11,R.drawable.default12,R.drawable.default13,R.drawable.default14,R.drawable.default15,R.drawable.default16,R.drawable.default17,R.drawable.default18,R.drawable.default19,R.drawable.default20,R.drawable.default21,R.drawable.default22,R.drawable.default23,R.drawable.default24};
	public static int currentIndex =0;

/*
    private SimpleStepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    public static int watts;
    */

	@Override
	public void onReceive(Context context, Intent intent) {
/*
        watts = LoadAndSave.LoadWatts();

        String con = context.SENSOR_SERVICE;
        sensorManager = (SensorManager) context.getSystemService(con);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new SimpleStepDetector();
        simpleStepDetector.registerListener(this);
        */


        Log.i("onRecieve","OnReceive");
        globalContext = context;
        globalIntent = intent;
        mTask = new MyTask();
        if(intent.getAction().equals("pl.looksok.intent.action.RETURN")){
            Log.i("Return Button","Return Button");
            returnIntent = intent;
            mTask.cancel(true);
        }

        if(key==0&&(intent.getAction().equals("pl.looksok.intent.action.CHANGE_PICTURE"))){
            Log.i("Image View","Image View");
            key++;
            fuckYou=true;
            mTask.execute();
        }
    }

	private void updateWidgetPictureAndButtonListener(Context context) {
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
		remoteViews.setImageViewResource(R.id.widget_image, getImageToSet());
		//REMEMBER TO ALWAYS REFRESH YOUR BUTTON CLICK LISTENERS!!!
        remoteViews.setOnClickPendingIntent(R.id.widget_button1, MyWidgetProvider.buildReturnPendingIntent(context));
	   	remoteViews.setOnClickPendingIntent(R.id.widget_button2, MyWidgetProvider.openWindowPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.mysterygiftbuttonid, MyWidgetProvider.openMysteryGiftPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.bagbuttonid, MyWidgetProvider.openItemBagPendingIntent(context));
		remoteViews.setOnClickPendingIntent(R.id.widget_image, MyWidgetProvider.buildImagePendingIntent(context));
		MyWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
	}
    private void putInsidePokeball(Context context){
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
        remoteViews.setImageViewResource(R.id.widget_image, R.drawable.pokeball9);
        remoteViews.setOnClickPendingIntent(R.id.widget_button1, MyWidgetProvider.buildReturnPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.widget_button2, MyWidgetProvider.openWindowPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.mysterygiftbuttonid, MyWidgetProvider.openMysteryGiftPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.bagbuttonid, MyWidgetProvider.openItemBagPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.widget_image, MyWidgetProvider.buildImagePendingIntent(context));
        key=0;
        MyWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
    }
	private int getImageToSet() {
        long chance = System.currentTimeMillis() % 8;

        if(currentIndex>=defaultslides.length)
            currentIndex=0;
        return defaultslides[currentIndex++];


        /*
        if (chance < 3)
            return R.drawable.confusedcolor1;
        else if (chance < 6)
           return R.drawable.confusedcolor2;
        else
            return R.drawable.confusedcolor3;

        /*
        clickCount++;
		return clickCount % 2 == 0 ? R.drawable.confused : R.drawable.ignoring;
		*/
	}

    private Context getContext(){
        return globalContext;
    }
    private Intent getGlobalIntent(){return globalIntent;}
    private Intent getReturnIntent(){return returnIntent;}
/*
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void step(long timeNs) {
        watts--;
        LoadAndSave.SaveWatt(watts);
    }
    public void unRegisterStepL(){
        sensorManager.unregisterListener(this);
        Log.i("Unregister", "Unregister");
    }
*/
    class MyTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected Void doInBackground(Void... voids) {
            int x = 1;
            while (x < 100000000) {
                Log.i("cancelled?",Boolean.toString(isCancelled()));
                if (isCancelled()) {break;}
                if(!fuckYou){break;}
                updateWidgetPictureAndButtonListener(getContext());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x--;
                x++;
            }
            return null;
        }
        @Override
        protected void onCancelled() {
            Log.i("onCancelled", Boolean.toString(isCancelled()));
            fuckYou=false;
            putInsidePokeball(getContext());
        }
        @Override
        protected void onProgressUpdate(Void... values) {

        }
        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }
}