package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    TextView output,input;
    Button clear,modulus,divide,multiply,addition,equal,zero,doubleZero,three,two,one,four,five,six,seven,eight,nine,minus,decimal,mod,power;
    ImageView erase;
    String st = "";
    int DecimalCount=0,flag=0,CheckSymbol=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        mod = findViewById(R.id.mod);
        power = findViewById(R.id.power);
        clear = findViewById(R.id.clear);
        modulus = findViewById(R.id.percentage);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        addition = findViewById(R.id.addition);
        equal = findViewById(R.id.equal);
        decimal = findViewById(R.id.decimal);
        zero = findViewById(R.id.zero);
        doubleZero = findViewById(R.id.doubleZero);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        one = findViewById(R.id.one);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        erase = findViewById(R.id.erase);
        minus = findViewById(R.id.minus);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.samsung_touch);
        try{
            equal.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mediaPlayer.start();
                    if(!output.getText().toString().equals(""))
                    {
                        st=output.getText().toString();
                        input.setText(st);
                        output.setText("");
                        CheckSymbol=0;
                        for(int i=0;i<st.length();i++)
                        {
                            if(st.charAt(i)=='.')
                                DecimalCount=1;
                        }
                    }
                    return true;
                }
            });
            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    calculate(st,output,flag);
                }
            });
            erase.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mediaPlayer.start();
                    st = "";
                    flag=0;
                    DecimalCount=0;
                    CheckSymbol=0;
                    input.setText(st);
                    output.setText("");
                    return true;
                }
            });
            addition.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(flag==1 && Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                    {
                        DecimalCount=0;
                        st = st+"+";
                        input.setText(st);
                    }
                    else if(flag==1 && st.charAt(st.length()-1)!='.' && st.charAt(st.length()-1)!='-' && st.charAt(st.length()-1)!='d')
                    {
                        DecimalCount=0;
                        st = st.substring(0,st.length()-1);
                        st = st+"+";
                        input.setText(st);
                    }
                }
            });
            divide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(flag==1 && Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                    {
                        st+="/";
                        DecimalCount=0;
                        input.setText(st);
                    }
                    else if(flag==1 && st.charAt(st.length()-1)!='.' && st.charAt(st.length()-1)!='-' && st.charAt(st.length()-1)!='d')
                    {
                        DecimalCount=0;
                        st = st.substring(0,st.length()-1);
                        st = st+"/";
                        input.setText(st);
                    }
                }
            });
            mod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(flag==1 && Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                    {
                        st+="mod";
                        DecimalCount=0;
                        input.setText(st);
                    }
                    else if(flag==1 && st.charAt(st.length()-1)!='.' && st.charAt(st.length()-1)!='-' && st.charAt(st.length()-1)!='d')
                    {
                        DecimalCount=0;
                        st = st.substring(0,st.length()-1);
                        st = st+"mod";
                        input.setText(st);
                    }
                }
            });
            power.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(flag==1 && Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                    {
                        st+="^";
                        DecimalCount=0;
                        input.setText(st);
                    }
                    else if(flag==1 && st.charAt(st.length()-1)!='.' && st.charAt(st.length()-1)!='-' && st.charAt(st.length()-1)!='d')
                    {
                        DecimalCount=0;
                        st = st.substring(0,st.length()-1);
                        st = st+"^";
                        input.setText(st);
                    }
                }
            });
            multiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(flag==1 && Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                    {
                        st+="x";
                        DecimalCount=0;
                        input.setText(st);
                    }
                    else if(flag==1 && st.charAt(st.length()-1)!='.' && st.charAt(st.length()-1)!='-' && st.charAt(st.length()-1)!='d')
                    {
                        DecimalCount=0;
                        st = st.substring(0,st.length()-1);
                        st = st+"x";
                        input.setText(st);
                    }
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(st.length()<1 || st.charAt(st.length()-1)!='-') {
                        st += "-";
                        DecimalCount = 0;
                        input.setText(st);
                        if (st.charAt(st.length() - 1) != '.') {
                            DecimalCount = 0;
                            st = st.substring(0, st.length() - 1);
                            st = st + "-";
                            input.setText(st);
                        }
                    }
                }
            });
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st = "";
                    flag=0;
                    DecimalCount=0;
                    input.setText(st);
                    output.setText("");
                }
            });
            modulus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    if(flag==1 && Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                    {
                        st = st+"%";
                        DecimalCount=0;
                        input.setText(st);
                    }
                    else if(flag==1 && st.charAt(st.length()-1)!='.' && st.charAt(st.length()-1)!='-' && st.charAt(st.length()-1)!='d')
                    {
                        DecimalCount=0;
                        st = st.substring(0,st.length()-1);
                        st = st+"%";
                        input.setText(st);
                    }
                }
            });
            erase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    output.setText("");
                    if(st.length()!=0)
                    {
                        if(st.charAt(st.length()-1)=='d')
                            st = st.substring(0,st.length()-3);
                        else
                            st = st.substring(0,st.length()-1);
                    }
                    input.setText(st);
                    int c=0;
                    if(st.equals(""))
                    {
                        flag=0;

                    }
                    for(int i=0;i<st.length();i++)
                    {
                        if(st.charAt(i)=='.')
                        {
                            c=1;
                        }
                    }
                    if(c==0)
                    {
                        DecimalCount=0;
                    }
                }
            });
            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="1";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="2";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="3";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="4";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="5";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            six.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="6";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            seven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="7";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            eight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="8";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            nine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="9";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            zero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="0";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            doubleZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    st+="00";
                    flag=1;
                    input.setText(st);
                    output.setText("");
                }
            });
            decimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    DecimalCount++;
                    if(DecimalCount==1)
                    {
                        st+=".";
                        input.setText(st);
                        output.setText("");
                    }
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @SuppressLint("SetTextI18n")
    public static void calculate(String st, TextView output, int flag)
    {
        try{
            if(flag==1)
            {
                if(Character.getNumericValue(st.charAt(st.length()-1))>=0 && Character.getNumericValue(st.charAt(st.length()-1))<=9)
                {
                    Stack<String> stack = new Stack<>();
                    int i=0,j,negNum=0;
                    if(st.charAt(0)=='-')
                        negNum = 1;
                    while(i<st.length())
                    {
                        if(negNum==1 || Character.getNumericValue(st.charAt(i))>=0 && Character.getNumericValue(st.charAt(i))<=9 || st.charAt(i)=='.')
                        {
                            i++;
                            negNum=0;
                        }
                        else
                            break;
                    }
                    stack.push(st.substring(0,i));
                    int f=0;
                    for(int k=0;k<st.length();k++)
                    {
                        if(st.charAt(k)=='.')
                        {
                            f=1;
                            break;
                        }
                    }
                    j=i;
                    if(st.charAt(i)=='m')
                        i=i+3;
                    else
                        i++;
                    if(st.charAt(i)=='-')
                        negNum = 1;
                    while(i<st.length())
                    {
                        if(negNum==1 || i!=st.length()-1 && Character.getNumericValue(st.charAt(i))>=0 && Character.getNumericValue(st.charAt(i))<=9 || st.charAt(i)=='.')
                        {
                            i++;
                            negNum=0;
                        }
                        else
                        {
                            if(i==st.length()-1)
                                i++;
                            if(f==0 && st.charAt(j)!='/' && st.charAt(j)!='%')
                            {
                                long n1 = (long) Double.parseDouble(stack.pop());
                                long n2;
                                if(st.charAt(j)=='m')
                                    n2 = (long) Double.parseDouble(st.substring(j+3,i));
                                else
                                    n2 = (long) Double.parseDouble(st.substring(j+1,i));
                                switch(st.charAt(j))
                                {
                                    case '+':
                                        stack.push(Long.toString(n1+n2));
                                        break;
                                    case '-':
                                        stack.push(Long.toString(n1-n2));
                                        break;
                                    case 'x':
                                        stack.push(Long.toString(n1*n2));
                                        break;
                                    case 'm':
                                        stack.push(Long.toString(n1%n2));
                                        break;
                                    case '^':
                                        stack.push(Double.toString(Math.pow(n1,n2)));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            else
                            {
                                double n1d = Double.parseDouble(stack.pop());
                                double n2d;
                                if(st.charAt(j)=='m')
                                    n2d = Double.parseDouble(st.substring(j+3,i));
                                else
                                    n2d = Double.parseDouble(st.substring(j+1,i));
                                switch(st.charAt(j))
                                {
                                    case '+':
                                        stack.push(Double.toString(n1d+n2d));
                                        break;
                                    case '-':
                                        stack.push(Double.toString(n1d-n2d));
                                        break;
                                    case '/':
                                        stack.push(Double.toString(n1d/n2d));
                                        break;
                                    case '%':
                                        stack.push(Double.toString(n1d*n2d/100));
                                        break;
                                    case 'x':
                                        stack.push(Double.toString(n1d*n2d));
                                        break;
                                    case '^':
                                        stack.push(Double.toString(Math.pow(n1d,n2d)));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            j=i;
                            if(i<st.length() && st.charAt(i)=='m')
                                i=i+3;
                            else
                                i++;
                            if(i<st.length() && st.charAt(i)=='-')
                                negNum = 1;
                        }
                    }
                    output.setText(stack.pop());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void onBackPressed()
    {
        super.onBackPressed();
        System.exit(0);
    }
}