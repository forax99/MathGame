package com.roky.mathgame;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int totalPoint = 0;
    private int rightCount = 0;
    private int level = 1;

    Button startButton;
    TextView arg1;
    TextView op;
    TextView arg2;
    TextView equal;
    TextView answer;
    Toast toastTrue;
    Toast toastEmpty;
    Button checkButton;
    Button showResultButton;
    TextView rightText;
    TextView pointText;
    TextView levelText;
    // numeric button
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button enter;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startButton = (Button) findViewById(R.id.start);
        arg1 = (TextView) findViewById(R.id.arg1);
        arg2 = (TextView) findViewById(R.id.arg2);
        op = (TextView) findViewById(R.id.op);
        equal = (TextView) findViewById(R.id.equal);
        answer = (TextView) findViewById(R.id.answer);

        toastTrue = Toast.makeText(this, R.string.result_true, Toast.LENGTH_LONG);
        toastEmpty = Toast.makeText(this, R.string.empty, Toast.LENGTH_LONG);
        checkButton = (Button) findViewById(R.id.check);
        checkButton.setOnClickListener(this);
        rightText = (TextView) findViewById(R.id.right_count);
        pointText = (TextView) findViewById(R.id.show_point);
        levelText = (TextView) findViewById(R.id.show_level);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        enter = (Button) findViewById(R.id.enter);
        clear = (Button) findViewById(R.id.clear);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        enter.setOnClickListener(this);
        clear.setOnClickListener(this);

        initialize();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.one){
            answer.setText(answer.getText() + one.getText().toString());
        }
        else if(id==R.id.two){
            answer.setText(answer.getText() + two.getText().toString());
        }
        else if(id==R.id.three){
            answer.setText(answer.getText() + three.getText().toString());
        }else if(id==R.id.four){
            answer.setText(answer.getText() + four.getText().toString());
        }else if(id==R.id.five){
            answer.setText(answer.getText() + five.getText().toString());
        }else if(id==R.id.six){
            answer.setText(answer.getText() + six.getText().toString());
        }else if(id==R.id.seven){
            answer.setText(answer.getText() + seven.getText().toString());
        }else if(id==R.id.eight){
            answer.setText(answer.getText() + eight.getText().toString());
        }else if(id==R.id.nine){
            answer.setText(answer.getText() + nine.getText().toString());
        }else if(id==R.id.zero){
            answer.setText(answer.getText() + zero.getText().toString());
        }else if(id==R.id.enter || id==R.id.check){
            checkAnswer();
        }else if(id==R.id.clear){
            answer.setText("");
        }
    }

    public void startGame(View view)
    {
        startButton.setEnabled(false);
        showAgrs(level);
        checkButton.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);
        six.setVisibility(View.VISIBLE);
        seven.setVisibility(View.VISIBLE);
        eight.setVisibility(View.VISIBLE);
        nine.setVisibility(View.VISIBLE);
        zero.setVisibility(View.VISIBLE);
        enter.setVisibility(View.VISIBLE);
        clear.setVisibility(View.VISIBLE);
    }

    private void showAgrs(int argLevel)
    {
        int randomBase1 = (argLevel - 1) * 5;
        int randomBase2 = argLevel * 5 - 1;
        Random r = new Random();
        int order = r.nextInt(1);;
        int i1 = r.nextInt(4) + randomBase1 + 1;
        int i2 = r.nextInt(randomBase2) + 1;
        if (order == 0){
            arg1.setText("" + i1);
            arg2.setText("" + i2);
        }
        else {
            arg1.setText("" + i2);
            arg2.setText("" + i1);
        }
        op.setText("+");
        equal.setText("=");
        answer.setText("");

        arg1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50 - argLevel);
        arg2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50 - argLevel);
        op.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50 - argLevel);
        equal.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50 - argLevel);
        answer.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50 - argLevel);
    }

    public void checkAnswer()
    {
        int a1 = Integer.parseInt(arg1.getText().toString());
        int a2 = Integer.parseInt(arg2.getText().toString());
        int ans = 0;
        String ansText = answer.getText().toString().trim();

        if (ansText.length() == 0)
        {
            toastEmpty.show();
            showAgrs(level);
            return;
        }
        ans = Integer.parseInt(ansText);

        if (a1 + a2 == ans)
        {
            rightCount++;
            totalPoint += level;
            toastTrue.show();
            if (rightCount % 5 == 0)
            {
                level++;
            }
            rightText.setText(getString(R.string.right_count) + rightCount);
            pointText.setText(getString(R.string.point_count) + totalPoint);
            levelText.setText(getString(R.string.level_count) + level);
            showAgrs(level);
        }
        else
        {
            showResult();
        }

    }

    public void showResult()
    {
        String textResult = "";
        textResult += getString(R.string.right_count);
        textResult += " " + rightCount + "\n";
        textResult += getString(R.string.point_count);
        textResult += " " + totalPoint + "\n";
        textResult += getString(R.string.level_count);
        textResult += " " + level + "\n";
        if (level <= 2)
        {
            textResult += "\n" + getString(R.string.ni);
        }
        else if (level <= 4)
        {
            textResult += "\n" + getString(R.string.good);
        }
        else if (level <= 6)
        {
            textResult += "\n" + getString(R.string.great);
        }
        else
        {
            textResult += "\n" + getString(R.string.perfect);
        }
        showAlert(textResult);

    }

    private void showAlert(String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // 여기서 this는 Activity의 this

        // 여기서 부터는 알림창의 속성 설정
        builder.setTitle(getString(R.string.show_result)) // 제목 설정
                .setMessage(msg) // 메세지 설정
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(){
                    // 확인 버튼 클릭시 설정
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        dialog.cancel();
                        initialize();
                    }
                });

        AlertDialog dialog = builder.create();    // 알림창 객체 생성
        dialog.show();    // 알림창 띄우기
    }

    public void initialize()
    {
        totalPoint = 0;
        rightCount = 0;
        level = 1;

        startButton.setEnabled(true);
        arg1.setText("");
        arg2.setText("");
        op.setText("");
        equal.setText("");
        answer.setText("");
        checkButton.setVisibility(View.INVISIBLE);
        rightText.setText("");
        pointText.setText("");
        levelText.setText("");
        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);
        four.setVisibility(View.INVISIBLE);
        five.setVisibility(View.INVISIBLE);
        six.setVisibility(View.INVISIBLE);
        seven.setVisibility(View.INVISIBLE);
        eight.setVisibility(View.INVISIBLE);
        nine.setVisibility(View.INVISIBLE);
        zero.setVisibility(View.INVISIBLE);
        enter.setVisibility(View.INVISIBLE);
        clear.setVisibility(View.INVISIBLE);
        answer.setVisibility(View.INVISIBLE);
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
}
