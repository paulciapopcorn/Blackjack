package com.example.macair.jocppa;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    ArrayList<Card> arrayList = new ArrayList<>();
    Stack<Card> stack = new Stack<>();
    Button hit;
    Button stay;
    ImageButton deal;
    ImageView card1;
    ImageView card2;
    ImageView card3;
    ImageView card4;
    ImageView lastcardsus;
    ImageView lastlastcardsus;
    ImageView lastlastcardjos;
    ImageView lastcardjos;
    ImageView card5;
    ImageView card6;
    ImageView card7;
    ImageView card8;
    TextView text1;
    TextView text2;
    TextView results;


    View view;
    int numberOfAcesPlayer;
    int numberOfAcesHouse;
    int draws = 0;
    int draws1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        stay = findViewById(R.id.button3);
        deal = findViewById(R.id.button1);
        hit = findViewById(R.id.button4);
        stay = findViewById(R.id.button3);
        card1 = findViewById(R.id.jos1);
        card1.setRotation(-10);
        card2 = findViewById(R.id.jos2);
        card2.setRotation(-5);
        card3 = findViewById(R.id.jos3);
        card3.setRotation(5);
        card4 = findViewById(R.id.jos4);
        card4.setRotation(13);
        card5 = findViewById(R.id.sus1);
        card5.setRotation(10);
        card6 = findViewById(R.id.sus2);
        card7 = findViewById(R.id.sus3);
        card7.setRotation(5);
        card8 = findViewById(R.id.sus4);
        card8.setRotation(-5);
        lastcardjos = findViewById(R.id.jos5);
        lastcardjos.setRotation(13);
        lastcardsus = findViewById(R.id.sus5);
        lastcardsus.setRotation(-7);
        lastlastcardjos = findViewById(R.id.jos6);
        lastlastcardjos.setRotation(-6);
        lastlastcardsus = findViewById(R.id.sus6);
        lastlastcardsus.setRotation(5);
        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);
        results = findViewById(R.id.textView3);
        view = this.findViewById(android.R.id.content);

        int icons[] = {

                R.drawable.inima_neagra_001,
                R.drawable.inima_neagra_002,
                R.drawable.inima_neagra_003,
                R.drawable.inima_neagra_004,
                R.drawable.inima_neagra_005,
                R.drawable.inima_neagra_006,
                R.drawable.inima_neagra_007,
                R.drawable.inima_neagra_008,
                R.drawable.inima_neagra_009,
                R.drawable.inima_neagra_010,
                R.drawable.inima_neagra_011,
                R.drawable.inima_neagra_012,
                R.drawable.inima_neagra_013,

                R.drawable.inima_rosie_014,
                R.drawable.inima_rosie_015,
                R.drawable.inima_rosie_016,
                R.drawable.inima_rosie_017,
                R.drawable.inima_rosie_018,
                R.drawable.inima_rosie_019,
                R.drawable.inima_rosie_020,
                R.drawable.inima_rosie_021,
                R.drawable.inima_rosie_022,
                R.drawable.inima_rosie_023,
                R.drawable.inima_rosie_024,
                R.drawable.inima_rosie_025,
                R.drawable.inima_rosie_026,

                R.drawable.caro_027,
                R.drawable.caro_028,
                R.drawable.caro_029,
                R.drawable.caro_030,
                R.drawable.caro_031,
                R.drawable.caro_032,
                R.drawable.caro_033,
                R.drawable.caro_034,
                R.drawable.caro_035,
                R.drawable.caro_036,
                R.drawable.caro_037,
                R.drawable.caro_038,
                R.drawable.caro_039,


                R.drawable.trefla_040,
                R.drawable.trefla_041,
                R.drawable.trefla_042,
                R.drawable.trefla_043,
                R.drawable.trefla_044,
                R.drawable.trefla_045,
                R.drawable.trefla_046,
                R.drawable.trefla_047,
                R.drawable.trefla_048,
                R.drawable.trefla_049,
                R.drawable.trefla_050,
                R.drawable.trefla_051,
                R.drawable.trefla_052,


        };


        setup(icons);
        shuffle();
        reset();
        gamestart();


        final Handler handler = new Handler() {


            @Override
            public void handleMessage(Message message) {
                results.setText((String) message.obj);
            }
        };









        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                shuffle();
                gamestart();
                deal.setVisibility(View.INVISIBLE);
                stay.setVisibility(View.VISIBLE);
                hit.setVisibility(View.VISIBLE);
            }
        });









        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = 0;

                if (draws == 0) {
                    value = stack.peek().getValue();
                    card3.setVisibility(View.VISIBLE);
                    card3.setImageResource(stack.pop().getImage());
                    text1.setText(Integer.toString(Integer.parseInt(text1.getText().toString()) + value));
                    view.invalidate();
                }

                if (draws == 1) {
                    value = stack.peek().getValue();
                    card4.setVisibility(View.VISIBLE);
                    card4.setImageResource(stack.pop().getImage());
                    text1.setText(Integer.toString(Integer.parseInt(text1.getText().toString()) + value));
                    view.invalidate();

                }

                if (draws == 2) {
                    value = stack.peek().getValue();
                    lastcardjos.setVisibility(View.VISIBLE);
                    lastcardjos.setImageResource(stack.pop().getImage());
                    text1.setText(Integer.toString(Integer.parseInt(text1.getText().toString()) + value));
                    view.invalidate();

                }
                if (draws == 3) {
                    value = stack.peek().getValue();
                    lastlastcardjos.setVisibility(View.VISIBLE);
                    lastlastcardjos.setImageResource(stack.pop().getImage());
                    text1.setText(Integer.toString(Integer.parseInt(text1.getText().toString()) + value));
                    view.invalidate();

                }
                draws++;
                if(value==11){
                    numberOfAcesPlayer++;
                }

               if(Integer.parseInt(text1.getText().toString())>21 && numberOfAcesPlayer!=0){
                    text1.setText(Integer.toString(Integer.parseInt(text1.getText().toString())-10));
                    numberOfAcesPlayer--;

               }


                if (Integer.parseInt(text1.getText().toString()) == 21) {

                    String message = text1.getText().toString() + " " + " You won".toString();
                    Message msg = new Message();
                    msg.obj = message;
                    handler.sendMessage(msg);

                    deal.setVisibility(View.VISIBLE);
                    delay();
                }


                if (Integer.parseInt(text1.getText().toString()) > 21 && numberOfAcesPlayer==0) {

                    String message = text1.getText().toString() + " " + " You lost".toString();

                    Message msg = new Message();
                    msg.obj = message;
                    handler.sendMessage(msg);
                    deal.setVisibility(View.VISIBLE);

                    delay();

                }
            }
        });






        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                hit.setClickable(false);

                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        while (!isInterrupted()) {

                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                break;
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    int value = 0;
                                    if (draws1 == 0) {
                                        value = stack.peek().getValue();
                                        card6.setImageResource(stack.pop().getImage());
                                        text2.setText(Integer.toString(Integer.parseInt(text2.getText().toString()) + value));
                                        view.invalidate();
                                    }

                                    if (draws1 == 1) {
                                        value = stack.peek().getValue();
                                        card7.setVisibility(View.VISIBLE);
                                        card7.setImageResource(stack.pop().getImage());
                                        text2.setText(Integer.toString(Integer.parseInt(text2.getText().toString()) + value));
                                        view.invalidate();
                                    }

                                    if (draws1 == 2) {
                                        value = stack.peek().getValue();
                                        card8.setVisibility(View.VISIBLE);
                                        card8.setImageResource(stack.pop().getImage());
                                        text2.setText(Integer.toString(Integer.parseInt(text2.getText().toString()) + value));
                                        view.invalidate();

                                    }

                                    if (draws1 == 3) {
                                        value = stack.peek().getValue();
                                        lastcardsus.setVisibility(View.VISIBLE);
                                        lastcardsus.setImageResource(stack.pop().getImage());
                                        text2.setText(Integer.toString(Integer.parseInt(text2.getText().toString()) + value));
                                        view.invalidate();

                                    }
                                    if (draws1 == 4) {
                                        value = stack.peek().getValue();
                                        lastlastcardsus.setVisibility(View.VISIBLE);
                                        lastlastcardsus.setImageResource(stack.pop().getImage());
                                        text2.setText(Integer.toString(Integer.parseInt(text2.getText().toString()) + value));
                                        view.invalidate();

                                    }
                                    draws1++;
                                    if(value==11){
                                        numberOfAcesHouse++;
                                    }

                                    if(Integer.parseInt(text2.getText().toString())>=17 && numberOfAcesHouse!=0){
                                        text2.setText(Integer.toString(Integer.parseInt(text2.getText().toString())-10));
                                        numberOfAcesHouse--;
                                    }

                                    if(Integer.parseInt(text2.getText().toString())>=17 && numberOfAcesHouse==0){


                                        if (Integer.parseInt(text2.getText().toString()) > Integer.parseInt(text1.getText().toString()) && Integer.parseInt(text2.getText().toString()) < 22) {

                                            String message = "Dealer wins with " + text2.getText().toString();
                                            Message msg = new Message();
                                            msg.obj = message;
                                            handler.sendMessage(msg);
                                            draws1 = 15;
                                            deal.setVisibility(View.VISIBLE);
                                            delay();

                                        }



                                        if (Integer.parseInt(text2.getText().toString()) > 21 || Integer.parseInt(text1.getText().toString()) > Integer.parseInt(text2.getText().toString())) {
                                            String message = "Player wins with " + text1.getText().toString();

                                            Message msg = new Message();
                                            msg.obj = message;
                                            handler.sendMessage(msg);
                                            draws1 = 15;
                                            deal.setVisibility(View.VISIBLE);
                                            delay();


                                        }




                                    }





                                }
                            });


                            if (draws1 == 15) {

                                break;
                            }
                        }

                    }

                };
                t1.start();

            }


        });

    }







    public void delay() {
        stay.setVisibility(View.INVISIBLE);
        hit.setVisibility(View.INVISIBLE);
        hit.setClickable(true);
    }


    protected void gamestart() {
        int value = stack.peek().getValue();
        card1.setImageResource(stack.pop().getImage());
        int value1 = stack.peek().getValue();
        card2.setImageResource(stack.pop().getImage());

        if (value == 11 && value1 == 11) {
            value1 -= 10;
            numberOfAcesPlayer+=2;
        }
        if (value == 11 || value1 == 11) {
            numberOfAcesPlayer++;
        }

        text1.setText(Integer.toString(value + value1));


        value = stack.peek().getValue();
        card5.setImageResource(stack.pop().getImage());
        text2.setText(Integer.toString(value));
        deal.setVisibility(View.INVISIBLE);
        if(value==11){
            numberOfAcesHouse++;
        }

        is21fromBeggining();


    }


    public void is21fromBeggining() {
        if (Integer.parseInt(text1.getText().toString()) == 21) {


            Thread t1 = new Thread() {
                @Override
                public void run() {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            results.setText("21 You won");
                            delay();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            shuffle();
                            deal.setVisibility(View.VISIBLE);

                        }
                    });

                }


            };
            t1.start();

        }


    }






    protected void shuffle() {
        Collections.shuffle(arrayList, new Random());
        stack.clear();

        for (int i = 0; i < arrayList.size(); i++) {
            stack.push(arrayList.get(i));
        }
    }






    protected void reset() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                results.setText("");
            }
        });
        draws = 0;
        draws1 = 0;
        numberOfAcesHouse=0;
        numberOfAcesPlayer=0;
        card2.setImageResource(R.drawable.blank);
        card6.setImageResource(R.drawable.blank);
        card3.setVisibility(View.INVISIBLE);
        card4.setVisibility(View.INVISIBLE);
        card7.setVisibility(View.INVISIBLE);
        card8.setVisibility(View.INVISIBLE);
        lastcardjos.setVisibility(View.INVISIBLE);
        lastcardsus.setVisibility(View.INVISIBLE);
        lastlastcardsus.setVisibility(View.INVISIBLE);
        lastlastcardjos.setVisibility(View.INVISIBLE);


    }


    public void setup(int[] icons) {

        Card card1 = new Card(icons[0], 2);
        Card card2 = new Card(icons[1], 3);
        Card card3 = new Card(icons[2], 4);
        Card card4 = new Card(icons[3], 5);
        Card card5 = new Card(icons[4], 6);
        Card card6 = new Card(icons[5], 7);
        Card card7 = new Card(icons[6], 8);
        Card card8 = new Card(icons[7], 9);
        Card card9 = new Card(icons[8], 10);
        Card card10 = new Card(icons[9], 10);
        Card card11 = new Card(icons[10], 10);
        Card card12 = new Card(icons[11], 10);
        Card card13 = new Card(icons[12], 11);

        Card card14 = new Card(icons[13], 2);
        Card card15 = new Card(icons[14], 3);
        Card card16 = new Card(icons[15], 4);
        Card card17 = new Card(icons[16], 5);
        Card card18 = new Card(icons[17], 6);
        Card card19 = new Card(icons[18], 7);
        Card card20 = new Card(icons[19], 8);
        Card card21 = new Card(icons[20], 9);
        Card card22 = new Card(icons[21], 10);
        Card card23 = new Card(icons[22], 10);
        Card card24 = new Card(icons[23], 10);
        Card card25 = new Card(icons[24], 10);
        Card card26 = new Card(icons[25], 11);

        Card card27 = new Card(icons[26], 2);
        Card card28 = new Card(icons[27], 3);
        Card card29 = new Card(icons[28], 4);
        Card card30 = new Card(icons[29], 5);
        Card card31 = new Card(icons[30], 6);
        Card card32 = new Card(icons[31], 7);
        Card card33 = new Card(icons[32], 8);
        Card card34 = new Card(icons[33], 9);
        Card card35 = new Card(icons[34], 10);
        Card card36 = new Card(icons[35], 10);
        Card card37 = new Card(icons[36], 10);
        Card card38 = new Card(icons[37], 10);
        Card card39 = new Card(icons[38], 11);

        Card card40 = new Card(icons[39], 2);
        Card card41 = new Card(icons[40], 3);
        Card card42 = new Card(icons[41], 4);
        Card card43 = new Card(icons[42], 5);
        Card card44 = new Card(icons[43], 6);
        Card card45 = new Card(icons[44], 7);
        Card card46 = new Card(icons[45], 8);
        Card card47 = new Card(icons[46], 9);
        Card card48 = new Card(icons[47], 10);
        Card card49 = new Card(icons[48], 10);
        Card card50 = new Card(icons[49], 10);
        Card card51 = new Card(icons[50], 10);
        Card card52 = new Card(icons[51], 11);


        Collections.addAll(arrayList, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13,
                card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39,
                card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50, card51, card52);


    }


}



