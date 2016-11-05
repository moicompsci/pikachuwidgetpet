package pl.looksok.widgetdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Moises Martinez on 4/8/15.
 */
public class BagActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bag_layout);
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new BagImageAdapter(getApplicationContext()));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View iv, int i, long id) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    public void hide(View v){
        finish();
    }
    public void doNothing(View v){    }
    public void alertOneButton(View v) {

        new AlertDialog.Builder(BagActivity.this)
                .setTitle("Bag Inventory")
                .setMessage("Make Pikachu feel some type of way. Items are earned from Mystery Gift!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                }).show();
    }
}
