package com.example.seabattle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import game.Status;
import game.PreparationStatus;
import game.BattleField;
import game.AI;

public class Field extends AppCompatActivity {

    private Status status = Status.PREPARATION;

    private PreparationStatus preparationStatus = PreparationStatus.FOURDECK;

    private Button[][] playerButtons;
    private Button[][] computerButtons;

    private boolean vertical = true;

    private BattleField playerField = new BattleField();
    private BattleField computerField = new BattleField();

    private AI ai = new AI(playerField);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        playerButtons = new Button[][]{{(Button)findViewById(R.id.bp_0_0), (Button)findViewById(R.id.bp_0_1), (Button)findViewById(R.id.bp_0_2), (Button)findViewById(R.id.bp_0_3), (Button)findViewById(R.id.bp_0_4), (Button)findViewById(R.id.bp_0_5), (Button)findViewById(R.id.bp_0_6), (Button)findViewById(R.id.bp_0_7), (Button)findViewById(R.id.bp_0_8), (Button)findViewById(R.id.bp_0_9), },
                {(Button)findViewById(R.id.bp_1_0), (Button)findViewById(R.id.bp_1_1), (Button)findViewById(R.id.bp_1_2), (Button)findViewById(R.id.bp_1_3), (Button)findViewById(R.id.bp_1_4), (Button)findViewById(R.id.bp_1_5), (Button)findViewById(R.id.bp_1_6), (Button)findViewById(R.id.bp_1_7), (Button)findViewById(R.id.bp_1_8), (Button)findViewById(R.id.bp_1_9), },
                {(Button)findViewById(R.id.bp_2_0), (Button)findViewById(R.id.bp_2_1), (Button)findViewById(R.id.bp_2_2), (Button)findViewById(R.id.bp_2_3), (Button)findViewById(R.id.bp_2_4), (Button)findViewById(R.id.bp_2_5), (Button)findViewById(R.id.bp_2_6), (Button)findViewById(R.id.bp_2_7), (Button)findViewById(R.id.bp_2_8), (Button)findViewById(R.id.bp_2_9), },
                {(Button)findViewById(R.id.bp_3_0), (Button)findViewById(R.id.bp_3_1), (Button)findViewById(R.id.bp_3_2), (Button)findViewById(R.id.bp_3_3), (Button)findViewById(R.id.bp_3_4), (Button)findViewById(R.id.bp_3_5), (Button)findViewById(R.id.bp_3_6), (Button)findViewById(R.id.bp_3_7), (Button)findViewById(R.id.bp_3_8), (Button)findViewById(R.id.bp_3_9), },
                {(Button)findViewById(R.id.bp_4_0), (Button)findViewById(R.id.bp_4_1), (Button)findViewById(R.id.bp_4_2), (Button)findViewById(R.id.bp_4_3), (Button)findViewById(R.id.bp_4_4), (Button)findViewById(R.id.bp_4_5), (Button)findViewById(R.id.bp_4_6), (Button)findViewById(R.id.bp_4_7), (Button)findViewById(R.id.bp_4_8), (Button)findViewById(R.id.bp_4_9), },
                {(Button)findViewById(R.id.bp_5_0), (Button)findViewById(R.id.bp_5_1), (Button)findViewById(R.id.bp_5_2), (Button)findViewById(R.id.bp_5_3), (Button)findViewById(R.id.bp_5_4), (Button)findViewById(R.id.bp_5_5), (Button)findViewById(R.id.bp_5_6), (Button)findViewById(R.id.bp_5_7), (Button)findViewById(R.id.bp_5_8), (Button)findViewById(R.id.bp_5_9), },
                {(Button)findViewById(R.id.bp_6_0), (Button)findViewById(R.id.bp_6_1), (Button)findViewById(R.id.bp_6_2), (Button)findViewById(R.id.bp_6_3), (Button)findViewById(R.id.bp_6_4), (Button)findViewById(R.id.bp_6_5), (Button)findViewById(R.id.bp_6_6), (Button)findViewById(R.id.bp_6_7), (Button)findViewById(R.id.bp_6_8), (Button)findViewById(R.id.bp_6_9), },
                {(Button)findViewById(R.id.bp_7_0), (Button)findViewById(R.id.bp_7_1), (Button)findViewById(R.id.bp_7_2), (Button)findViewById(R.id.bp_7_3), (Button)findViewById(R.id.bp_7_4), (Button)findViewById(R.id.bp_7_5), (Button)findViewById(R.id.bp_7_6), (Button)findViewById(R.id.bp_7_7), (Button)findViewById(R.id.bp_7_8), (Button)findViewById(R.id.bp_7_9), },
                {(Button)findViewById(R.id.bp_8_0), (Button)findViewById(R.id.bp_8_1), (Button)findViewById(R.id.bp_8_2), (Button)findViewById(R.id.bp_8_3), (Button)findViewById(R.id.bp_8_4), (Button)findViewById(R.id.bp_8_5), (Button)findViewById(R.id.bp_8_6), (Button)findViewById(R.id.bp_8_7), (Button)findViewById(R.id.bp_8_8), (Button)findViewById(R.id.bp_8_9), },
                {(Button)findViewById(R.id.bp_9_0), (Button)findViewById(R.id.bp_9_1), (Button)findViewById(R.id.bp_9_2), (Button)findViewById(R.id.bp_9_3), (Button)findViewById(R.id.bp_9_4), (Button)findViewById(R.id.bp_9_5), (Button)findViewById(R.id.bp_9_6), (Button)findViewById(R.id.bp_9_7), (Button)findViewById(R.id.bp_9_8), (Button)findViewById(R.id.bp_9_9), },};

        computerButtons = new Button[][]{{(Button)findViewById(R.id.bc_0_0), (Button)findViewById(R.id.bc_0_1), (Button)findViewById(R.id.bc_0_2), (Button)findViewById(R.id.bc_0_3), (Button)findViewById(R.id.bc_0_4), (Button)findViewById(R.id.bc_0_5), (Button)findViewById(R.id.bc_0_6), (Button)findViewById(R.id.bc_0_7), (Button)findViewById(R.id.bc_0_8), (Button)findViewById(R.id.bc_0_9), },
                {(Button)findViewById(R.id.bc_1_0), (Button)findViewById(R.id.bc_1_1), (Button)findViewById(R.id.bc_1_2), (Button)findViewById(R.id.bc_1_3), (Button)findViewById(R.id.bc_1_4), (Button)findViewById(R.id.bc_1_5), (Button)findViewById(R.id.bc_1_6), (Button)findViewById(R.id.bc_1_7), (Button)findViewById(R.id.bc_1_8), (Button)findViewById(R.id.bc_1_9), },
                {(Button)findViewById(R.id.bc_2_0), (Button)findViewById(R.id.bc_2_1), (Button)findViewById(R.id.bc_2_2), (Button)findViewById(R.id.bc_2_3), (Button)findViewById(R.id.bc_2_4), (Button)findViewById(R.id.bc_2_5), (Button)findViewById(R.id.bc_2_6), (Button)findViewById(R.id.bc_2_7), (Button)findViewById(R.id.bc_2_8), (Button)findViewById(R.id.bc_2_9), },
                {(Button)findViewById(R.id.bc_3_0), (Button)findViewById(R.id.bc_3_1), (Button)findViewById(R.id.bc_3_2), (Button)findViewById(R.id.bc_3_3), (Button)findViewById(R.id.bc_3_4), (Button)findViewById(R.id.bc_3_5), (Button)findViewById(R.id.bc_3_6), (Button)findViewById(R.id.bc_3_7), (Button)findViewById(R.id.bc_3_8), (Button)findViewById(R.id.bc_3_9), },
                {(Button)findViewById(R.id.bc_4_0), (Button)findViewById(R.id.bc_4_1), (Button)findViewById(R.id.bc_4_2), (Button)findViewById(R.id.bc_4_3), (Button)findViewById(R.id.bc_4_4), (Button)findViewById(R.id.bc_4_5), (Button)findViewById(R.id.bc_4_6), (Button)findViewById(R.id.bc_4_7), (Button)findViewById(R.id.bc_4_8), (Button)findViewById(R.id.bc_4_9), },
                {(Button)findViewById(R.id.bc_5_0), (Button)findViewById(R.id.bc_5_1), (Button)findViewById(R.id.bc_5_2), (Button)findViewById(R.id.bc_5_3), (Button)findViewById(R.id.bc_5_4), (Button)findViewById(R.id.bc_5_5), (Button)findViewById(R.id.bc_5_6), (Button)findViewById(R.id.bc_5_7), (Button)findViewById(R.id.bc_5_8), (Button)findViewById(R.id.bc_5_9), },
                {(Button)findViewById(R.id.bc_6_0), (Button)findViewById(R.id.bc_6_1), (Button)findViewById(R.id.bc_6_2), (Button)findViewById(R.id.bc_6_3), (Button)findViewById(R.id.bc_6_4), (Button)findViewById(R.id.bc_6_5), (Button)findViewById(R.id.bc_6_6), (Button)findViewById(R.id.bc_6_7), (Button)findViewById(R.id.bc_6_8), (Button)findViewById(R.id.bc_6_9), },
                {(Button)findViewById(R.id.bc_7_0), (Button)findViewById(R.id.bc_7_1), (Button)findViewById(R.id.bc_7_2), (Button)findViewById(R.id.bc_7_3), (Button)findViewById(R.id.bc_7_4), (Button)findViewById(R.id.bc_7_5), (Button)findViewById(R.id.bc_7_6), (Button)findViewById(R.id.bc_7_7), (Button)findViewById(R.id.bc_7_8), (Button)findViewById(R.id.bc_7_9), },
                {(Button)findViewById(R.id.bc_8_0), (Button)findViewById(R.id.bc_8_1), (Button)findViewById(R.id.bc_8_2), (Button)findViewById(R.id.bc_8_3), (Button)findViewById(R.id.bc_8_4), (Button)findViewById(R.id.bc_8_5), (Button)findViewById(R.id.bc_8_6), (Button)findViewById(R.id.bc_8_7), (Button)findViewById(R.id.bc_8_8), (Button)findViewById(R.id.bc_8_9), },
                {(Button)findViewById(R.id.bc_9_0), (Button)findViewById(R.id.bc_9_1), (Button)findViewById(R.id.bc_9_2), (Button)findViewById(R.id.bc_9_3), (Button)findViewById(R.id.bc_9_4), (Button)findViewById(R.id.bc_9_5), (Button)findViewById(R.id.bc_9_6), (Button)findViewById(R.id.bc_9_7), (Button)findViewById(R.id.bc_9_8), (Button)findViewById(R.id.bc_9_9), },};


        playerButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 0);
            }
        });
        playerButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 1);
            }
        });
        playerButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 2);
            }
        });
        playerButtons[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 3);
            }
        });
        playerButtons[0][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 4);
            }
        });
        playerButtons[0][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 5);
            }
        });
        playerButtons[0][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 6);
            }
        });
        playerButtons[0][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 7);
            }
        });
        playerButtons[0][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 8);
            }
        });
        playerButtons[0][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(0, 9);
            }
        });


        playerButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 0);
            }
        });
        playerButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 1);
            }
        });
        playerButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 2);
            }
        });
        playerButtons[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 3);
            }
        });
        playerButtons[1][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 4);
            }
        });
        playerButtons[1][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 5);
            }
        });
        playerButtons[1][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 6);
            }
        });
        playerButtons[1][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 7);
            }
        });
        playerButtons[1][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 8);
            }
        });
        playerButtons[1][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(1, 9);
            }
        });


        playerButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 0);
            }
        });
        playerButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 1);
            }
        });
        playerButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 2);
            }
        });
        playerButtons[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 3);
            }
        });
        playerButtons[2][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 4);
            }
        });
        playerButtons[2][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 5);
            }
        });
        playerButtons[2][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 6);
            }
        });
        playerButtons[2][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 7);
            }
        });
        playerButtons[2][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 8);
            }
        });
        playerButtons[2][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(2, 9);
            }
        });


        playerButtons[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 0);
            }
        });
        playerButtons[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 1);
            }
        });
        playerButtons[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 2);
            }
        });
        playerButtons[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 3);
            }
        });
        playerButtons[3][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 4);
            }
        });
        playerButtons[3][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 5);
            }
        });
        playerButtons[3][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 6);
            }
        });
        playerButtons[3][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 7);
            }
        });
        playerButtons[3][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 8);
            }
        });
        playerButtons[3][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(3, 9);
            }
        });


        playerButtons[4][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 0);
            }
        });
        playerButtons[4][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 1);
            }
        });
        playerButtons[4][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 2);
            }
        });
        playerButtons[4][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 3);
            }
        });
        playerButtons[4][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 4);
            }
        });
        playerButtons[4][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 5);
            }
        });
        playerButtons[4][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 6);
            }
        });
        playerButtons[4][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 7);
            }
        });
        playerButtons[4][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 8);
            }
        });
        playerButtons[4][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(4, 9);
            }
        });


        playerButtons[5][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 0);
            }
        });
        playerButtons[5][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 1);
            }
        });
        playerButtons[5][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 2);
            }
        });
        playerButtons[5][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 3);
            }
        });
        playerButtons[5][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 4);
            }
        });
        playerButtons[5][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 5);
            }
        });
        playerButtons[5][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 6);
            }
        });
        playerButtons[5][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 7);
            }
        });
        playerButtons[5][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 8);
            }
        });
        playerButtons[5][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(5, 9);
            }
        });


        playerButtons[6][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 0);
            }
        });
        playerButtons[6][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 1);
            }
        });
        playerButtons[6][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 2);
            }
        });
        playerButtons[6][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 3);
            }
        });
        playerButtons[6][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 4);
            }
        });
        playerButtons[6][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 5);
            }
        });
        playerButtons[6][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 6);
            }
        });
        playerButtons[6][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 7);
            }
        });
        playerButtons[6][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 8);
            }
        });
        playerButtons[6][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 9);
            }
        });


        playerButtons[7][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 0);
            }
        });
        playerButtons[7][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 1);
            }
        });
        playerButtons[7][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 2);
            }
        });
        playerButtons[7][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 3);
            }
        });
        playerButtons[7][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 4);
            }
        });
        playerButtons[7][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 5);
            }
        });
        playerButtons[7][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 6);
            }
        });
        playerButtons[7][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 7);
            }
        });
        playerButtons[7][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 8);
            }
        });
        playerButtons[7][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(7, 9);
            }
        });

        playerButtons[8][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 0);
            }
        });
        playerButtons[8][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 1);
            }
        });
        playerButtons[8][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 2);
            }
        });
        playerButtons[8][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 3);
            }
        });
        playerButtons[8][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 4);
            }
        });
        playerButtons[8][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 5);
            }
        });
        playerButtons[8][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 6);
            }
        });
        playerButtons[8][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 7);
            }
        });
        playerButtons[8][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 8);
            }
        });
        playerButtons[8][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(8, 9);
            }
        });

        playerButtons[9][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 0);
            }
        });
        playerButtons[9][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 1);
            }
        });
        playerButtons[9][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 2);
            }
        });
        playerButtons[9][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 3);
            }
        });
        playerButtons[9][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 4);
            }
        });
        playerButtons[9][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 5);
            }
        });
        playerButtons[9][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 6);
            }
        });
        playerButtons[9][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 7);
            }
        });
        playerButtons[9][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 8);
            }
        });
        playerButtons[9][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(9, 9);
            }
        });











        computerButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 0);
            }
        });
        computerButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 1);
            }
        });
        computerButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 2);
            }
        });
        computerButtons[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 3);
            }
        });
        computerButtons[0][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 4);
            }
        });
        computerButtons[0][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 5);
            }
        });
        computerButtons[0][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 6);
            }
        });
        computerButtons[0][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 7);
            }
        });
        computerButtons[0][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 8);
            }
        });
        computerButtons[0][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(0, 9);
            }
        });


        computerButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 0);
            }
        });
        computerButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 1);
            }
        });
        computerButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 2);
            }
        });
        computerButtons[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 3);
            }
        });
        computerButtons[1][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 4);
            }
        });
        computerButtons[1][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 5);
            }
        });
        computerButtons[1][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 6);
            }
        });
        computerButtons[1][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 7);
            }
        });
        computerButtons[1][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 8);
            }
        });
        computerButtons[1][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(1, 9);
            }
        });


        computerButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 0);
            }
        });
        computerButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 1);
            }
        });
        computerButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 2);
            }
        });
        computerButtons[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 3);
            }
        });
        computerButtons[2][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 4);
            }
        });
        computerButtons[2][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 5);
            }
        });
        computerButtons[2][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 6);
            }
        });
        computerButtons[2][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 7);
            }
        });
        computerButtons[2][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 8);
            }
        });
        computerButtons[2][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(2, 9);
            }
        });


        computerButtons[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 0);
            }
        });
        computerButtons[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 1);
            }
        });
        computerButtons[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 2);
            }
        });
        computerButtons[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 3);
            }
        });
        computerButtons[3][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 4);
            }
        });
        computerButtons[3][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 5);
            }
        });
        computerButtons[3][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 6);
            }
        });
        computerButtons[3][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 7);
            }
        });
        computerButtons[3][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 8);
            }
        });
        computerButtons[3][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(3, 9);
            }
        });


        computerButtons[4][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 0);
            }
        });
        computerButtons[4][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 1);
            }
        });
        computerButtons[4][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 2);
            }
        });
        computerButtons[4][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 3);
            }
        });
        computerButtons[4][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 4);
            }
        });
        computerButtons[4][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 5);
            }
        });
        computerButtons[4][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 6);
            }
        });
        computerButtons[4][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 7);
            }
        });
        computerButtons[4][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 8);
            }
        });
        computerButtons[4][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(4, 9);
            }
        });


        computerButtons[5][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 0);
            }
        });
        computerButtons[5][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 1);
            }
        });
        computerButtons[5][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 2);
            }
        });
        computerButtons[5][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 3);
            }
        });
        computerButtons[5][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 4);
            }
        });
        computerButtons[5][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 5);
            }
        });
        computerButtons[5][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 6);
            }
        });
        computerButtons[5][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 7);
            }
        });
        computerButtons[5][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 8);
            }
        });
        computerButtons[5][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(5, 9);
            }
        });


        computerButtons[6][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 0);
            }
        });
        computerButtons[6][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 1);
            }
        });
        computerButtons[6][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 2);
            }
        });
        computerButtons[6][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 3);
            }
        });
        computerButtons[6][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 4);
            }
        });
        computerButtons[6][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 5);
            }
        });
        computerButtons[6][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 6);
            }
        });
        computerButtons[6][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 7);
            }
        });
        computerButtons[6][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayerButtonClick(6, 8);
            }
        });
        computerButtons[6][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(6, 9);
            }
        });


        computerButtons[7][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 0);
            }
        });
        computerButtons[7][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 1);
            }
        });
        computerButtons[7][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 2);
            }
        });
        computerButtons[7][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 3);
            }
        });
        computerButtons[7][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 4);
            }
        });
        computerButtons[7][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 5);
            }
        });
        computerButtons[7][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 6);
            }
        });
        computerButtons[7][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 7);
            }
        });
        computerButtons[7][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 8);
            }
        });
        computerButtons[7][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(7, 9);
            }
        });

        computerButtons[8][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 0);
            }
        });
        computerButtons[8][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 1);
            }
        });
        computerButtons[8][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 2);
            }
        });
        computerButtons[8][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 3);
            }
        });
        computerButtons[8][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 4);
            }
        });
        computerButtons[8][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 5);
            }
        });
        computerButtons[8][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 6);
            }
        });
        computerButtons[8][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 7);
            }
        });
        computerButtons[8][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 8);
            }
        });
        computerButtons[8][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(8, 9);
            }
        });

        computerButtons[9][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 0);
            }
        });
        computerButtons[9][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 1);
            }
        });
        computerButtons[9][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 2);
            }
        });
        computerButtons[9][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 3);
            }
        });
        computerButtons[9][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 4);
            }
        });
        computerButtons[9][5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 5);
            }
        });
        computerButtons[9][6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 6);
            }
        });
        computerButtons[9][7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 7);
            }
        });
        computerButtons[9][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 8);
            }
        });
        computerButtons[9][9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onComputerButtonClick(9, 9);
            }
        });
    }

    private void onPlayerButtonClick(int i, int j) {
        if(status != Status.PREPARATION) return;
        if(preparationStatus == PreparationStatus.FOURDECK) {
            if(playerField.addShip(i, j, 4, vertical)) {
                preparationStatus = PreparationStatus.THREEDECKFIRST;
                paintPlayerShip(i, j, 4, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.THREEDECKFIRST) {
            if(playerField.addShip(i, j, 3, vertical)) {
                preparationStatus = PreparationStatus.THREEDECKSECOND;
                paintPlayerShip(i, j, 3, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.THREEDECKSECOND) {
            if(playerField.addShip(i, j, 3, vertical)) {
                preparationStatus = PreparationStatus.TWODECKFIRST;
                paintPlayerShip(i, j, 3, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.TWODECKFIRST) {
            if(playerField.addShip(i, j, 2, vertical)) {
                preparationStatus = PreparationStatus.TWODECKSECOND;
                paintPlayerShip(i, j, 2, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.TWODECKSECOND) {
            if(playerField.addShip(i, j, 2, vertical)) {
                preparationStatus = PreparationStatus.TWODECKTHIRD;
                paintPlayerShip(i, j, 2, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.TWODECKTHIRD) {
            if(playerField.addShip(i, j, 2, vertical)) {
                preparationStatus = PreparationStatus.ONEDECKFIRST;
                paintPlayerShip(i, j, 2, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.ONEDECKFIRST) {
            if(playerField.addShip(i, j, 1, vertical)) {
                preparationStatus = PreparationStatus.ONEDECKSECOND;
                paintPlayerShip(i, j, 1, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.ONEDECKSECOND) {
            if(playerField.addShip(i, j, 1, vertical)) {
                preparationStatus = PreparationStatus.ONEDECKTHIRD;
                paintPlayerShip(i, j, 1, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.ONEDECKTHIRD) {
            if(playerField.addShip(i, j, 1, vertical)) {
                preparationStatus = PreparationStatus.ONEDECKFORTH;
                paintPlayerShip(i, j, 1, vertical);
                printShipType();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        if(preparationStatus == PreparationStatus.ONEDECKFORTH) {
            if(playerField.addShip(i, j, 1, vertical)) {
                preparationStatus = PreparationStatus.NONE;
                status = Status.GAME;
                paintPlayerShip(i, j, 1, vertical);
                printShipType();
                Toast.makeText(Field.this, "Game starts", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Field.this, "Incorect input", Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }

    private void paintPlayerShip(int i, int j, int numberOfDeck, boolean vertical) {
        int k = 0;
        if(vertical) for(k = i; k < i + numberOfDeck; k++) playerButtons[k][j].setBackgroundColor(Color.GREEN);
        else for(k = j; k < j + numberOfDeck; k++) playerButtons[i][k].setBackgroundColor(Color.GREEN);
    }

    private void printShipType() {
        TextView textView = (TextView)findViewById(R.id.textShip);
        String text = "Ship: ";
        if (preparationStatus == PreparationStatus.NONE) {
            text = "Game";
            textView.setText(text);
            return;
        }
        if (preparationStatus == PreparationStatus.FOURDECK) text += "Four-deck ";
        if (preparationStatus == PreparationStatus.THREEDECKFIRST || preparationStatus == PreparationStatus.THREEDECKSECOND) text += "Three-deck ";
        if (preparationStatus == PreparationStatus.TWODECKFIRST || preparationStatus == PreparationStatus.TWODECKSECOND || preparationStatus == PreparationStatus.TWODECKTHIRD) text += "Two-deck ";
        if (preparationStatus == PreparationStatus.ONEDECKFIRST || preparationStatus == PreparationStatus.ONEDECKSECOND || preparationStatus == PreparationStatus.ONEDECKTHIRD || preparationStatus == PreparationStatus.ONEDECKFORTH) text += "One-deck ";
        if (vertical) {
            text += "(vertical)";
        } else {
            text += "(horizontal)";
        }
        textView.setText(text);
    }

    public void onReverseButtonClick(View v) {
        if (status == Status.GAME) return;
        TextView textView = (TextView)findViewById(R.id.textShip);
        String text = "Ship: ";
        if (preparationStatus == PreparationStatus.FOURDECK) text += "Four-deck ";
        if (preparationStatus == PreparationStatus.THREEDECKFIRST || preparationStatus == PreparationStatus.THREEDECKSECOND) text += "Three-deck ";
        if (preparationStatus == PreparationStatus.TWODECKFIRST || preparationStatus == PreparationStatus.TWODECKSECOND || preparationStatus == PreparationStatus.TWODECKTHIRD) text += "Two-deck ";
        if (preparationStatus == PreparationStatus.ONEDECKFIRST || preparationStatus == PreparationStatus.ONEDECKSECOND || preparationStatus == PreparationStatus.ONEDECKTHIRD || preparationStatus == PreparationStatus.ONEDECKFORTH) text += "One-deck ";
        if (vertical) {
            vertical = false;
            text += "(horizontal)";
        } else {
            vertical = true;
            text += "(vertical)";
        }
        textView.setText(text);
    }

    private void onComputerButtonClick(int i, int j) {
        if(status != Status.GAME) return;
        int cellStatus = computerField.shootCell(i, j);
        int[] move = new int[2];
        if(cellStatus < 0) return;
        if(cellStatus == 0) {
            paintCell(computerButtons[i][j], Color.YELLOW);
        }
        if(cellStatus == 1) {
            paintCell(computerButtons[i][j], Color.RED);
            if(computerField.checkLose()) {
                status = Status.END;
                Toast.makeText(Field.this, "Congratulations", Toast.LENGTH_LONG).show();
                return;
            }
        }
        move = ai.move();
        cellStatus = playerField.shootCell(move[0], move[1]);
        if(cellStatus == 0) {
            paintCell(playerButtons[i][j], Color.YELLOW);
        }
        if(cellStatus == 1) {
            paintCell(playerButtons[i][j], Color.RED);
            if(playerField.checkLose()) {
                status = Status.END;
                Toast.makeText(Field.this, "You lose", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    private void paintCell(Button cell, int color) {
        cell.setBackgroundColor(color);
    }
}