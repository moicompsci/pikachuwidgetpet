package pl.looksok.widgetdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


/**
 * Created by Moises Martinez on 4/8/15.
 */

//this is for the BagActibity window
public class BagImageAdapter extends BaseAdapter {
    String[] amountOfSameItem = new String[100];
    int[] images = new int[100];
    private  Context context;
    private static LayoutInflater inflater=null;

    public BagImageAdapter(Context getApplication){  //load() in here fasho
        context = getApplication;
        for(int i=0;i<images.length;i++){
            images[i]= R.drawable.cherryberry;
            amountOfSameItem[i] = "x10";
        }
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return  i; //return null
    }

    @Override
    public long getItemId(int i) {
        return i;
    }  //return 0
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder holder=new Holder();
        View rowView;
        ImageView iv;
        TextView textView=null;
        String string = null;

        rowView = inflater.inflate(R.layout.bag_grid, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(amountOfSameItem[i]);
        holder.img.setImageResource(images[i]);
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "You Clicked "+amountOfSameItem[i], Toast.LENGTH_LONG).show();
            }
        });

        /*
        if(view!=null){
            string = (String) getItem( i );
            iv= (ImageView) view;
        }else{
            iv=new ImageView(context);
            textView = new TextView(context);
            iv.setLayoutParams(new GridView.LayoutParams(65,65));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setPadding(8,8,8,8);




        }
        iv.setImageResource(images[i]);
        textView.setText(string);


        return iv;
           */
        return rowView;
    }
}
