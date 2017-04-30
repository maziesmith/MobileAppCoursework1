package com.example.thamashi.coursework1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class gameScreen extends AppCompatActivity {

    //initializing variables
    Button one, two, three, four, five, six, seven, eight, nine, zero, del, hash, minus;
    EditText answer;
    TextView question, result, txtTimer;
    String txtresVal, trueAnswer;
    CountDownTimer timerc;
    boolean timerisrunning = true;
    Switch hints;

    int Qcounter = 0;
    int attemptS = 0;
    String currentQues;


    int novicePoints = 0;
    int easyPoints = 0;
    int mediumPoints = 0;
    int guruPoints = 0;

    static final String EXPRESSION="";
    static final String ANSWER = "";
    static final String RESULT = "";
    static final String NOVICE_POINTS = "null";
    static final String EASY_POINTS = "null";
    static final String MEDIUM_POINTS = "null";
    static final String GURU_POINTS = "null";
    static final String DIFFICULTY_LEVEL = "";
    static final String QCOUNTER = "null";
    static final String REMAIN_TIME = "";


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) { //saving the current game

        savedInstanceState.putString(EXPRESSION, question.getText().toString().trim());
        savedInstanceState.putString(ANSWER, answer.getText().toString().trim());
        savedInstanceState.putString(RESULT, result.getText().toString().trim());
        savedInstanceState.putInt(NOVICE_POINTS,novicePoints);
        savedInstanceState.putInt(EASY_POINTS,easyPoints);
        savedInstanceState.putInt(MEDIUM_POINTS,mediumPoints);
        savedInstanceState.putInt(GURU_POINTS,guruPoints);
        savedInstanceState.putString(DIFFICULTY_LEVEL,getIntent().getExtras().getString("levelname").trim());
        savedInstanceState.putInt(QCOUNTER,Qcounter);
        savedInstanceState.putString(REMAIN_TIME,txtTimer.getText().toString().trim());

        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Log.d("back pressed","");
        onSaveInstanceState(getIntent().getExtras());

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);


        Intent i = this.getIntent();

        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        del = (Button) findViewById(R.id.btndel);
        hash = (Button) findViewById(R.id.btnHash);
        minus = (Button) findViewById(R.id.btnMinus);
        answer = (EditText) findViewById(R.id.edittxtAnswer);
        question = (TextView) findViewById(R.id.textViewQ);
        result = (TextView) findViewById(R.id.textViewRes);
        txtTimer = (TextView) findViewById(R.id.textViewTime);
        hints = (Switch) findViewById(R.id.switchHints);

        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("DIFFICULTY_LEVEL");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else {

        txtresVal = answer.getText().toString().trim();
        String quesT = questionforDifficulty(getIntent().getExtras().getString("levelname"));
        question.setText(quesT.trim());

        timeCounter(); //calling the countdown timer
        question.setText(quesT.split(",")[0].trim());


        del.setOnClickListener(new View.OnClickListener() { //delete button
            @Override
            public void onClick(View view) {
                answer.setText(null);

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //setting numbers for the user to input the answer
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("1");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "1");
                }

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("2");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "2");
                }

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("3");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "3");
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("4");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "4");
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("5");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "5");
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("6");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "6");
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("7");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "7");
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("8");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "8");
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("9");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "9");
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("0");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "0");
                }
            }
        });
        hash.setOnClickListener(new View.OnClickListener() { //function of the hash button
            @Override
            public void onClick(View view) {

                //checking whether the answer and result is not null
                if (timerisrunning == false && answer.getText().toString() != null && result.getText().toString() != null) {
                    question.setText(questionforDifficulty(getIntent().getExtras().getString("levelname")).trim());
                    answer.setText(null);
                    result.setText(null);
                    timerc.start();

                } else {
                    String q1 = question.getText().toString().trim();

                    //replacing numbers as variables
                    if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("NOVICE")) {
                        String q2 = q1.replace(q1.split("[*/+-]")[0], "x");
                        String q3 = q2.replace(q2.split("[*/+-]")[1], "y");
                        trueAnswer = (int) Math.floor(calculateResNovice(Integer.parseInt(q1.split("[*/+-]")[0]),
                                Integer.parseInt(q1.split("[*/+-]")[1]), q3)) + ""; //converting the double to int
                    }
                    if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("EASY")) {
                        trueAnswer = (int) Math.floor(calculateResEasy(q1, q1.split("[*/+-]").length)) + "";
                    }
                    if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("MEDIUM")) {
                        trueAnswer = (int) Math.floor(calculateResMedium(q1, q1.split("[*/+-]").length)) + "";
                    }
                    if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("GURU")) {
                        trueAnswer = (int) Math.floor(calculateResGuru(q1, q1.split("[*/+-]").length)) + "";
                    }

                    String usersAns = answer.getText().toString().trim();
                    result.setText(null);

                    //checking for the result
                    if (usersAns.equalsIgnoreCase(trueAnswer.trim())) {

                        result.setText("CORRECT!!");
                        result.setTextColor(Color.GREEN);
                        timerisrunning = false;
                        timerisrunning = false;
                        timerc.cancel();

                        if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("NOVICE")) {
                            novicePoints += marks();
                        } else if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("EASY")) {
                            easyPoints += marks();
                        } else if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("MEDIUM")) {
                            mediumPoints += marks();
                        } else if (getIntent().getExtras().getString("levelname").trim().equalsIgnoreCase("GURU")) {
                            guruPoints += marks();
                        }


                    } else {
                        int usersVal = Integer.parseInt(usersAns);
                        int trueVal = Integer.parseInt(trueAnswer);
                        result.setText("WRONG!!");
                        result.setTextColor(Color.RED);
                        timerisrunning = false;
                        timerc.cancel();
                        currentQues = question.getText().toString().trim();

                        if (hints.isChecked() && attemptS < 4) {
                            //checking whether hints are enabled

                            if (usersVal > trueVal) { //comparing the user input and the correct answer
                                AlertDialog alertDialog = new AlertDialog.Builder(gameScreen.this).create();
                                alertDialog.setTitle("Hint");
                                alertDialog.setMessage("Less");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                attemptS++;
                                                answer.setText("");
                                                question.setText(currentQues);
                                                timerc.start();
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();

                            } else if (usersVal < trueVal) {
                                AlertDialog alertDialog = new AlertDialog.Builder(gameScreen.this).create();
                                alertDialog.setTitle("Hint");
                                alertDialog.setMessage("Greater");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                attemptS++;
                                                answer.setText("");
                                                question.setText(currentQues);
                                                timerc.start();
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();
                            }
                            if (attemptS == 3) {
                                hints.setChecked(false);
                                question.setText(questionforDifficulty(getIntent().getExtras().getString("levelname")).trim());
                                answer.setText(null);
                                result.setText(null);
                                timerc.start();
                            }
                        }
                    }
                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtresVal.trim().equalsIgnoreCase("?")) {
                    answer.setText("");
                    answer.setText("-");
                    txtresVal = answer.getText().toString().trim();
                } else {
                    txtresVal = answer.getText().toString().trim();
                    answer.setText(txtresVal + "-");
                }
            }
        });

        hints.setOnClickListener(new View.OnClickListener() { //when hints switch is enabled or disabled
            @Override
            public void onClick(View view) {

                if (hints.isChecked()) {
                    hints.setChecked(false);
                }
                if (!hints.isChecked()) {
                    hints.setChecked(true);
                }
            }
        });
    }//load save state

    }

    public void timeCounter() { //timer to countdown 10 seconds for answering

        timerc = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

                timerisrunning = true;
                txtTimer.setText("Time remaining: " + millisUntilFinished / 1000 + " secs");
            }

            public void onFinish() {

                timerisrunning = false;
                txtTimer.setText("Time out!");
                result.setText(null);

                if (answer.getText() != null) {

                    answer.setText(null);
                    question.setText(questionforDifficulty(getIntent().getExtras().getString("levelname")).trim());
                    timerc.start();

                }
            }

        }.start();
    }


    public double calculateResNovice(int x, int y, String exp) {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Expression e = new ExpressionBuilder(exp).variables("x", "y").build().setVariable("x", x).setVariable("y", y);

        return e.evaluate();

    }

    public double calculateResEasy(String exp, int leng) {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Expression e = null;
        String q0 = exp;
        switch (leng) {
            case 2:
                String q2 = exp.replace(exp.split("[*/+-]")[0], "x");
                String q3 = q2.replace(q2.split("[*/+-]")[1], "y");
                e = new ExpressionBuilder(q3).variables("x", "y").build().
                        setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]));
                break;
            case 3:
                String q1 = exp.replace(exp.split("[*/+-]")[0], "x");
                String q4 = q1.replace(q1.split("[*/+-]")[1], "y");
                String q5 = q4.replace(q4.split("[*/+-]")[1], "z");
                e = new ExpressionBuilder(q5).variables("x", "y", "z").build()
                        .setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]))
                        .setVariable("z", Integer.parseInt(q0.split("[*/+-]")[2]));
                break;
        }


        return e.evaluate();

    }

    public double calculateResMedium(String exp, int leng) {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Expression e = null;
        String q0 = exp;
        switch (leng) {
            case 2:
                String q2 = exp.replace(exp.split("[*/+-]")[0], "x");
                String q3 = q2.replace(q2.split("[*/+-]")[1], "y");
                e = new ExpressionBuilder(q3).variables("x", "y").build().
                        setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]));
                break;
            case 3:
                String q1 = exp.replace(exp.split("[*/+-]")[0], "x");
                String q4 = q1.replace(q1.split("[*/+-]")[1], "y");
                String q5 = q4.replace(q4.split("[*/+-]")[1], "z");
                e = new ExpressionBuilder(q5).variables("x", "y", "z").build()
                        .setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]))
                        .setVariable("z", Integer.parseInt(q0.split("[*/+-]")[2]));
                break;
            case 4:
                String q6 = exp.replace(exp.split("[*/+-]")[0], "x");
                String q7 = q6.replace(q6.split("[*/+-]")[1], "y");
                String q8 = q7.replace(q7.split("[*/+-]")[2], "z");
                String q9 = q8.replace(q8.split("[*/+-]")[3], "a");
                e = new ExpressionBuilder(q9).variables("x", "y", "z", "a").build()
                        .setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]))
                        .setVariable("z", Integer.parseInt(q0.split("[*/+-]")[2]))
                        .setVariable("a", Integer.parseInt(q0.split("[*/+-]")[3]));
                break;
        }


        return e.evaluate();

    }

    public double calculateResGuru(String exp, int leng) {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Expression e = null;
        String q0 = exp;
        switch (leng) {
            case 4:
                String q6 = exp.replace(exp.split("[*/+-]")[0], "x");
                String q7 = q6.replace(q6.split("[*/+-]")[1], "y");
                String q8 = q7.replace(q7.split("[*/+-]")[2], "z");
                String q9 = q8.replace(q8.split("[*/+-]")[3], "a");
                e = new ExpressionBuilder(q9).variables("x", "y", "z", "a").build()
                        .setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]))
                        .setVariable("z", Integer.parseInt(q0.split("[*/+-]")[2]))
                        .setVariable("a", Integer.parseInt(q0.split("[*/+-]")[3]));
                break;
            case 5:
                String k1 = exp.replace(exp.split("[*/+-]")[0], "x");
                String k2 = k1.replace(k1.split("[*/+-]")[1], "y");
                String k3 = k2.replace(k2.split("[*/+-]")[2], "z");
                String k4 = k3.replace(k3.split("[*/+-]")[3], "a");
                String k5 = k4.replace(k4.split("[*/+-]")[4], "b");
                e = new ExpressionBuilder(k5).variables("x", "y", "z", "a", "b").build()
                        .setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]))
                        .setVariable("z", Integer.parseInt(q0.split("[*/+-]")[2]))
                        .setVariable("a", Integer.parseInt(q0.split("[*/+-]")[3]))
                        .setVariable("b", Integer.parseInt(q0.split("[*/+-]")[4]));
                break;
            case 6:
                String k6 = exp.replace(exp.split("[*/+-]")[0], "x");
                String k7 = k6.replace(k6.split("[*/+-]")[1], "y");
                String k8 = k7.replace(k7.split("[*/+-]")[2], "z");
                String l1 = k8.replace(k8.split("[*/+-]")[3], "a");
                String l2 = l1.replace(l1.split("[*/+-]")[4], "b");
                String l3 = l1.replace(l2.split("[*/+-]")[5], "c");
                e = new ExpressionBuilder(l3).variables("x", "y", "z", "a", "b", "c").build()
                        .setVariable("x", Integer.parseInt(q0.split("[*/+-]")[0]))
                        .setVariable("y", Integer.parseInt(q0.split("[*/+-]")[1]))
                        .setVariable("z", Integer.parseInt(q0.split("[*/+-]")[2]))
                        .setVariable("a", Integer.parseInt(q0.split("[*/+-]")[3]))
                        .setVariable("b", Integer.parseInt(q0.split("[*/+-]")[4]))
                        .setVariable("c", Integer.parseInt(q0.split("[*/+-]")[5]));
                break;
        }


        return e.evaluate();

    }


    private String questionforDifficulty(String levelname) {  //random arithmetic expression generator for difficulty levels

        String strexp = "";
        try {
            Random rd = new Random();
            int num1 = rd.nextInt(1000);
            int num2 = rd.nextInt(1000);
            int num3 = rd.nextInt(1000);
            int num4 = rd.nextInt(1000);
            int num5 = rd.nextInt(1000);
            int num6 = rd.nextInt(1000);


            if (levelname.trim().equalsIgnoreCase("NOVICE")) {
                if (Qcounter != 10) {
                    strexp = getNoviceQ(num1, num2);
                    Qcounter++;
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(gameScreen.this).create();
                    alertDialog.setTitle("Statistics");
                    alertDialog.setMessage("POINTS: " +novicePoints+"");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    timerc.cancel();
                                    Intent gamehome = new Intent(gameScreen.this, difficultyLevels.class);
                                    startActivity(gamehome);
                                }
                            });
                    alertDialog.show();
                }

            }
            if (levelname.trim().equalsIgnoreCase("EASY")) {

                if (Qcounter != 10) {
                    strexp = getEasyQ(rd.nextInt(2), num1, num2, num3);
                    Qcounter++;
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(gameScreen.this).create();
                    alertDialog.setTitle("Statistics");
                    alertDialog.setMessage("POINTS: "+easyPoints+"");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    timerc.cancel();
                                    Intent gamehome = new Intent(gameScreen.this, difficultyLevels.class);
                                    startActivity(gamehome);
                                }
                            });
                    alertDialog.show();
                }
            }
            if (levelname.trim().equalsIgnoreCase("MEDIUM")) {

                if (Qcounter != 10) {
                    strexp = getMediumQ(rd.nextInt(3), num1, num2, num3, num4);
                    Qcounter++;
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(gameScreen.this).create();
                    alertDialog.setTitle("Statistics");
                    alertDialog.setMessage("POINTS: "+mediumPoints+"");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    timerc.cancel();
                                    Intent gamehome = new Intent(gameScreen.this, difficultyLevels.class);
                                    startActivity(gamehome);
                                }
                            });
                    alertDialog.show();
                }

            }
            if (levelname.trim().equalsIgnoreCase("GURU")) {

                if (Qcounter != 10) {
                    strexp = getGuruQ(rd.nextInt(3), num1, num2, num3, num4, num5, num6);
                    Qcounter++;
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(gameScreen.this).create();
                    alertDialog.setTitle("Statistics");
                    alertDialog.setMessage("POINTS: "+guruPoints+"");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    timerc.cancel();
                                    Intent gamehome = new Intent(gameScreen.this, difficultyLevels.class);
                                    startActivity(gamehome);
                                }
                            });
                    alertDialog.show();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return strexp;
    }

    private char getOperator(int i) {
        char op = 0;
        switch (i) {
            case 0:
                op = '+';
                break;
            case 1:
                op = '-';
                break;
            case 2:
                op = '*';
                break;
            case 3:
                op = '/';
                break;
        }
        return op;
    }

    private String getNoviceQ(int n1, int n2) {
        Random r = new Random();
        return n1 + String.valueOf(getOperator(r.nextInt(4))) + n2;
    }

    private String getEasyQ(int i, int n1, int n2, int n3) {
        String Ques = "";
        Random r = new Random();
        switch (i) {
            case 0:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2;
                break;
            case 1:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2 + String.valueOf(getOperator(r.nextInt(4))) + n3;
                break;

        }
        return Ques;
    }

    private String getMediumQ(int i, int n1, int n2, int n3, int n4) {
        String Ques = "";
        Random r = new Random();
        switch (i) {
            case 0:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2;
                break;
            case 1:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2 + String.valueOf(getOperator(r.nextInt(4))) + n3;
                break;
            case 2:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2 + String.valueOf(getOperator(r.nextInt(4))) +
                        n3 + String.valueOf(getOperator(r.nextInt(4))) + n4;
                break;

        }
        return Ques;
    }


    private String getGuruQ(int i, int n1, int n2, int n3, int n4, int n5, int n6) {
        String Ques = "";
        Random r = new Random();
        switch (i) {
            case 0:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2 + String.valueOf(getOperator(r.nextInt(4))) +
                        n3 + String.valueOf(getOperator(r.nextInt(4))) + n4;
                break;
            case 1:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2 + String.valueOf(getOperator(r.nextInt(4))) +
                        n3 + String.valueOf(getOperator(r.nextInt(4)))
                        + n4 + String.valueOf(getOperator(r.nextInt(4))) + n5;
                break;
            case 2:
                Ques = n1 + String.valueOf(getOperator(r.nextInt(4))) + n2 + String.valueOf(getOperator(r.nextInt(4))) +
                        n3 + String.valueOf(getOperator(r.nextInt(4)))
                        + n4 + String.valueOf(getOperator(r.nextInt(4))) + n5 + String.valueOf(getOperator(r.nextInt(4))) + n6;
                break;

        }
        return Ques;
    }

    public int marks() { //calculating the number of points

        int point = 0;

        String timeRemain = txtTimer.getText().toString().split(":")[1].trim().split(" ")[0].trim();
        int time = Integer.parseInt(timeRemain);

        point = (100 / (10 - time));

        return point;

    }


}


