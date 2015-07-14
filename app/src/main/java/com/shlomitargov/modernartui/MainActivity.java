package com.shlomitargov.modernartui;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    private static final String MORE_INFO_DIALOG = "MORE_INFO_DIALOG";
    private SeekBar mSeekBar;
    private ImageView mRect1;
    private ImageView mRect2;
    private ImageView mRect3;
    private ImageView mRect5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initMembers();

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

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
        mRect1 = (ImageView)findViewById(R.id.rect1);
    }
}
