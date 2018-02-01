package com.codiox.simpledicerollingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.codiox.simpledicerollingapp.constant.DiceConstants;
import com.codiox.simpledicerollingapp.utils.DiceRoller;

public class DiceActivity extends AppCompatActivity {

    private DiceRoller diceRoller;
    ImageView[] diceViews;

    ImageView dieOneView;
    ImageView dieTwoView;
    ImageView dieThreeView;
    ImageView dieFourView;
    ImageView dieFiveView;
    ImageView dieSixView;

    Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_activity);

        diceRoller = new DiceRoller();
        diceViews = new ImageView[DiceConstants.NUM_DICE];

        setupButtons();
        setupImageViews();

    }

    private void setupButtons(){
        rollButton = findViewById(R.id.rollBtn);

        rollButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                diceRoller.rollDice();
                changeDiceImages();

            }
        });
    }

    private void setupImageViews() {
        dieOneView = findViewById(R.id.dieOneView);
        dieTwoView = findViewById(R.id.dieTwoView);
        dieThreeView = findViewById(R.id.dieThreeView);
        dieFourView = findViewById(R.id.dieFourView);
        dieFiveView = findViewById(R.id.dieFiveView);
        dieSixView = findViewById(R.id.dieSixView);

        diceViews[0] = dieOneView;
        diceViews[1] = dieTwoView;
        diceViews[2] = dieThreeView;
        diceViews[3] = dieFourView;
        diceViews[4] = dieFiveView;
        diceViews[5] = dieSixView;
    }

    private int getDrawableDiceId(int number) {
        String name = "die" + number;
        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

    private void changeDiceImages() {
        for(int i = 0; i < DiceConstants.NUM_DICE; i++) {
            diceViews[i].setImageResource(getDrawableDiceId(
                    diceRoller.getDice()[i].getDieResult()
            ));
        }
    }


}
