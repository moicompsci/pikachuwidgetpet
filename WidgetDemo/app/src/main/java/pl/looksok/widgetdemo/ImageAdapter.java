package pl.looksok.widgetdemo;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by Moises Martinez on 4/8/15.
 */

//this is for the MysteryGift window
public class ImageAdapter extends BaseAdapter {

    int[] images = new int[100];
    private  Context context;

    public ImageAdapter(Context getApplication){
        context = getApplication;
        for(int i=0;i<images.length;i++){
            images[i]= R.drawable.mysterygift1;
        }
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv;
        if(view!=null){
            iv= (ImageView) view;
        }else{
            iv=new ImageView(context);
            iv.setLayoutParams(new GridView.LayoutParams(80,80));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setPadding(8,8,8,8);
        }
        iv.setImageResource(images[i]);

        return iv;
    }
}
