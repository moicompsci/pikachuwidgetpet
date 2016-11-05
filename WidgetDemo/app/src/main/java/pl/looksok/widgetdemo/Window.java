package pl.looksok.widgetdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Window extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);

	setContentView(R.layout.window);
////
    /*
    WindowManager.LayoutParams params = getWindow().getAttributes();
    params.x = 0;
    params.height = 550; //can be wrap_content
    params.width = 550;
    params.y = 0;
    this.getWindow().setAttributes(params);
    */
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
}
