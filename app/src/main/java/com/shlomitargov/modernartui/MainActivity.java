package com.shlomitargov.modernartui;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    private static final String MORE_INFO_DIALOG = "MORE_INFO_DIALOG";
    private SeekBar mSeekBar;
    private ImageView mRect_red;
    private ImageView mRect_blue;
    private ImageView mRect_green;
    private ImageView mRect_pink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initMembers();

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeRectColors(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_information) {
            //Open pop-up menu
            DialogFragment moreInfoDialog = new MoreInformationFragment();
            moreInfoDialog.show(getFragmentManager(), MORE_INFO_DIALOG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initMembers() {
        mSeekBar = (SeekBar)findViewById(R.id.color_seek_bar);
        mRect_red = (ImageView)findViewById(R.id.rect_red);
        mRect_blue = (ImageView)findViewById(R.id.rect_blue);
        mRect_green = (ImageView)findViewById(R.id.rect_green);
        mRect_pink = (ImageView)findViewById(R.id.rect_pink);
    }


    private void changeRectColors(int progress)
    {
        ColorFilter red_filter = new PorterDuffColorFilter(Color.rgb(0, 2 * progress, progress), PorterDuff.Mode.ADD);
        ColorFilter blue_filter = new PorterDuffColorFilter(Color.rgb(progress, 2* progress, 0), PorterDuff.Mode.ADD);
        ColorFilter green_filter = new PorterDuffColorFilter(Color.rgb(2* progress, 0, 0), PorterDuff.Mode.ADD);
        ColorFilter pink_filter = new PorterDuffColorFilter(Color.rgb(progress, progress, 0), PorterDuff.Mode.ADD);

        mRect_red.getDrawable().setColorFilter(red_filter);
        mRect_blue.getDrawable().setColorFilter(blue_filter);
        mRect_green.getDrawable().setColorFilter(green_filter);
        mRect_pink.getDrawable().setColorFilter(pink_filter);
    }
}
