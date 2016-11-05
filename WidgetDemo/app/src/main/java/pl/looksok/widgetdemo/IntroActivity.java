package pl.looksok.widgetdemo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Moitroid on 11/5/2016.
 */

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);
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

}
