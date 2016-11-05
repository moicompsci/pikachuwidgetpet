package pl.looksok.widgetdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Moises Martinez on 4/8/15.
 */
public class MysteryGiftActivity extends Activity {
    TextView watts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mystery_gift_layout);
        GridView gv = (GridView) findViewById(R.id.gridView);
        //watts = (TextView) findViewById(R.id.wattext);
        //watts.setText(LoadAndSave.getWatts());
        gv.setAdapter(new ImageAdapter(getApplicationContext()));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View iv, int i, long id) {
                  //1.remove photo
                //2. show add
                //3. toest "check your bag"
                //more info on dude that showed how to do this:
                // https://www.youtube.com/watch?v=Y75i3U7X-ng
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
       // watts.setText(LoadAndSave.getWatts());
    }

    @Override
    public void onBackPressed() {
        onDestroy();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    public void hide(View v){
        finish();
    }
    public void doNothing(View v){

    }
    public void alertOneButton(View v) {

        new AlertDialog.Builder(MysteryGiftActivity.this)
                .setTitle("Watts are needed to earn Mystery Gifts")
                .setMessage("2 ways: " +
                        "Walk Pikachu"
                + "NFC")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                }).show();
    }
}
