package com.example.killer.bottomsheetdialog;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout shareLinearLayout, uploadLinearLayout, copyLinearLayout;
    BottomSheetDialog bottomSheetDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView);

        createBottomSheetDialog();
    }

    private void createBottomSheetDialog() {
        if (bottomSheetDialog == null) {
            View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null);
            shareLinearLayout = view.findViewById(R.id.shareLinearLayout);
            uploadLinearLayout = view.findViewById(R.id.uploadLinearLayout);
            copyLinearLayout = view.findViewById(R.id.copyLinearLayout);

            shareLinearLayout.setOnClickListener(this);
            uploadLinearLayout.setOnClickListener(this);
            copyLinearLayout.setOnClickListener(this);

            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(view);
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDialog(View view) {
        bottomSheetDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shareLinearLayout:
                textView.setText("SHARE");
                bottomSheetDialog.dismiss();
                break;
            case R.id.uploadLinearLayout:
                textView.setText("UPLOAD");
                bottomSheetDialog.dismiss();
                break;
            case R.id.copyLinearLayout:
                textView.setText("COPY");
                bottomSheetDialog.dismiss();
                break;

        }
    }
}
