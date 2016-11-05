package pl.looksok.widgetdemo;



import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by Moises Martinez
 * Credit to Jacek Milewski
 * looksok.wordpress.com
 */

public class MyWidgetProvider extends AppWidgetProvider  {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {



		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
		remoteViews.setOnClickPendingIntent(R.id.widget_image, buildImagePendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.widget_button1, buildReturnPendingIntent(context));
		remoteViews.setOnClickPendingIntent(R.id.widget_button2, openWindowPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.mysterygiftbuttonid, openMysteryGiftPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.bagbuttonid, openItemBagPendingIntent(context));
		pushWidgetUpdate(context, remoteViews);
	}

	public static PendingIntent buildImagePendingIntent(Context context) {
		Intent intent = new Intent();
	    intent.setAction("pl.looksok.intent.action.CHANGE_PICTURE");
	    return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	}
    public static PendingIntent buildReturnPendingIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("pl.looksok.intent.action.RETURN");
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
	public static PendingIntent openWindowPendingIntent(Context context) {
		Intent config_intent= new Intent(context,Window.class);
        config_intent.setAction("pl.looksok.intent.action.OPEN_WINDOW");
	    return PendingIntent.getActivity(context, 0, config_intent, PendingIntent.FLAG_UPDATE_CURRENT);
	}
    public static PendingIntent openMysteryGiftPendingIntent(Context context) {
        Intent config_intent= new Intent(context,MysteryGiftActivity.class);
        config_intent.setAction("pl.looksok.intent.action.MYSTERY_GIFT");
        return PendingIntent.getActivity(context, 0, config_intent,PendingIntent.FLAG_UPDATE_CURRENT);
    }
    public static PendingIntent openItemBagPendingIntent(Context context) {
        Intent config_intent= new Intent(context,BagActivity.class);
        config_intent.setAction("pl.looksok.intent.action.ITEM_BAG");
        return PendingIntent.getActivity(context, 0, config_intent,PendingIntent.FLAG_UPDATE_CURRENT);
    }

	public static void pushWidgetUpdate(Context context, RemoteViews remoteViews) {
		ComponentName myWidget = new ComponentName(context, MyWidgetProvider.class);
	    AppWidgetManager manager = AppWidgetManager.getInstance(context);
	    manager.updateAppWidget(myWidget, remoteViews);		
	}


	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);


		//sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);

	}


}
