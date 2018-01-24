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

    final String CHANGE_PICTURE = "pl.looksok.intent.action.CHANGE_PICTURE";
    final String OPEN_WINDOW = "pl.looksok.intent.action.OPEN_WINDOW";
    final String RETURN = "pl.looksok.intent.action.RETURN";
    final String MYSTERY_GIFT = "pl.looksok.intent.action.MYSTERY_GIFT";
    final String ITEM_BAG = "pl.looksok.intent.action.ITEM_BAG";
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
		remoteViews.setOnClickPendingIntent(R.id.widget_image, buildPendingIntent(context, CHANGE_PICTURE));
        remoteViews.setOnClickPendingIntent(R.id.widget_button1, buildPendingIntent(context, RETURN));
		remoteViews.setOnClickPendingIntent(R.id.widget_button2, buildPendingIntent(context, OPEN_WINDOW));
        remoteViews.setOnClickPendingIntent(R.id.mysterygiftbuttonid, buildPendingIntent(context, MYSTERY_GIFT));
        remoteViews.setOnClickPendingIntent(R.id.bagbuttonid, buildPendingIntent(context, ITEM_BAG));
		pushWidgetUpdate(context, remoteViews);
	}

	public static PendingIntent buildPendingIntent(Context context, String s){
        Intent intent = new Intent();
        intent.setAction(s);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

	public static void pushWidgetUpdate(Context context, RemoteViews remoteViews) {
		ComponentName myWidget = new ComponentName(context, MyWidgetProvider.class);
	    AppWidgetManager manager = AppWidgetManager.getInstance(context);
	    manager.updateAppWidget(myWidget, remoteViews);		
	}


}
