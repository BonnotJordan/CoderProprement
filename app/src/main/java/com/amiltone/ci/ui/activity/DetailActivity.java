package com.amiltone.ci.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.amiltone.ci.R;
import com.amiltone.ci.model.manager.BLEManager;
import com.amiltone.ci.ui.composition.MessagingModule;
import com.amiltone.ci.ui.composition.MessagingModuleToastImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by amiltonedev_lt027 on 01/11/2016.
 */

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.activity_detail_tv_content) TextView tvContent;
    private BLEManager bleManager;
    private MessagingModule messagingModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initializeInjection();
    }

    private void initializeInjection() {
        bleManager = BLEManager.getInstance();
        messagingModule = new MessagingModuleToastImpl();
    }

    @OnClick(R.id.activity_detail_button_history)
    public void actionRetrieve(Button button) {
        String result = bleManager.getBLELastValues();
        if (result != null) {
            updateContent(result);
        } else {
            displayError("not connected to device");
        }
    }

    private void updateContent(String value) {
        tvContent.setText(value);
    }

    private void displayError(String errorMsg) {
        messagingModule.displayError(this,errorMsg);
    }
}