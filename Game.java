package com.example.android.tictak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.android.tictak.R.string.lost;
import static com.example.android.tictak.R.string.won;

public class Game extends AppCompatActivity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private int win,lose,draw;
    private char grid[][]=new char[3][3];
    boolean firstmove;
    private TextView tw,td,tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.v("onCreate()(Game.java)","inside onCreate");
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;*/

        setTitle("Lets Play!!");
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]='e';

        win=lose=draw=0;
        firstmove=true;
        tw=(TextView)findViewById(R.id.wincount);
        td=(TextView)findViewById(R.id.drawcount);
        tl=(TextView)findViewById(R.id.losscount);

        Button b1 = (Button) findViewById(R.id.new_game);
        Button b2 = (Button) findViewById(R.id.end_game);
        t1=(TextView)findViewById(R.id.one);
        t2=(TextView)findViewById(R.id.two);
        t3=(TextView)findViewById(R.id.three);
        t4=(TextView)findViewById(R.id.four);
        t5=(TextView)findViewById(R.id.five);
        t6=(TextView)findViewById(R.id.six);
        t7=(TextView)findViewById(R.id.seven);
        t8=(TextView)findViewById(R.id.eight);
        t9=(TextView)findViewById(R.id.nine);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game.this,MainActivity.class));
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t5.getText().toString().compareTo("O");
                Log.e("onClickFive()","p: "+p);
                if(p!=0)
                {
                    t5.setText("X");
                    grid[1][1]='x';
                    result();
                    nextMove();
                }
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t1.getText().toString().compareTo("O");
                Log.e("onClickOne()","p: "+p);
                if(p!=0)
                {
                    t1.setText("X");
                    grid[0][0]='x';
                    result();
                    nextMove();
                }
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t2.getText().toString().compareTo("O");
                Log.e("onClickTwo()","p: "+p);
                if(p!=0)
                {
                    t2.setText("X");
                    grid[0][1]='x';
                    result();
                    nextMove();
                }
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t3.getText().toString().compareTo("O");
                Log.e("onClickThree()","p: "+p);
                if(p!=0)
                {
                    t3.setText("X");
                    grid[0][2]='x';
                    result();
                    nextMove();
                }
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t4.getText().toString().compareTo("O");
                Log.e("onClickFour()","p: "+p);
                if(p!=0)
                {
                    t4.setText("X");
                    grid[1][0]='x';
                    result();
                    nextMove();
                }
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t6.getText().toString().compareTo("O");
                Log.e("onClickSix()","p: "+p);
                if(p!=0)
                {
                    t6.setText("X");
                    grid[1][2]='x';
                    result();
                    nextMove();
                }
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t7.getText().toString().compareTo("O");
                Log.e("onClickSevn()","p: "+p);
                if(p!=0)
                {
                    t7.setText("X");
                    grid[2][0]='x';
                    result();
                    nextMove();
                }
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t8.getText().toString().compareTo("O");
                Log.e("onClickeigt()","p: "+p);
                if(p!=0)
                {
                    t8.setText("X");
                    grid[2][1]='x';
                    result();
                    nextMove();
                }
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=t9.getText().toString().compareTo("O");
                Log.e("onClicknine()","p: "+p);
                if(p!=0)
                {
                    t9.setText("X");
                    grid[2][2]='x';
                    result();
                    nextMove();
                }
            }
        });
        Random random=new Random();
        int val=random.nextInt(100);
        if(val<50){
            nextMove();
            Toast.makeText(this,"Computer Moves first!!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"You Moves first!",Toast.LENGTH_SHORT).show();
        }
    }

    private void result()
    {
        //x is player and o is computer
        Log.v("result()","inside result() chk mech");
        if(grid[0][0]=='x' && grid[0][1]=='x' &&grid[0][2]=='x')   //player win row 1
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);
            refresh();
        }
        else if(grid[0][0]=='o' &&grid[0][1]=='o'&&grid[0][2]=='o') // comp win row 1
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[0][0]=='o' &&grid[1][0]=='o'&&grid[2][0]=='o') //comp win column 1
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[0][0]=='x' &&grid[1][0]=='x'&&grid[2][0]=='x') // player win column 1
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[1][0]=='x' &&grid[1][1]=='x'&&grid[1][2]=='x') //player win row 2
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[0][1]=='x' &&grid[1][1]=='x'&&grid[2][1]=='x') //player win column 2
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[1][0]=='o' &&grid[1][1]=='o'&&grid[1][2]=='o') // comp win row 2
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[0][1]=='o' &&grid[1][1]=='o'&&grid[2][1]=='o') //comp win column 2
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[2][0]=='x' &&grid[2][1]=='x'&&grid[2][2]=='x') //player win row 3
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[0][2]=='x' &&grid[1][2]=='x'&&grid[2][2]=='x') //player win column 3
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[2][0]=='o' &&grid[2][1]=='o'&&grid[2][2]=='o') //comp win row 3
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[0][2]=='o' &&grid[1][2]=='o'&&grid[2][2]=='o') // comp win column 3
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[0][0]=='x' &&grid[1][1]=='x'&&grid[2][2]=='x') //player win diag 1
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[2][0]=='x' &&grid[1][1]=='x'&&grid[0][2]=='x') //player win diag 2
        {
            win++;
            Toast.makeText(this,won,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(win);
            tw.setText(str);

            refresh();
        }
        else if(grid[0][0]=='o' &&grid[1][1]=='o'&&grid[2][2]=='o') //comp win diag 1
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else if(grid[2][0]=='o' &&grid[1][1]=='o'&&grid[0][2]=='o') //comp win diag 2
        {
            lose++;
            Toast.makeText(this,lost,Toast.LENGTH_SHORT).show();
            String str=String.valueOf(lose);
            tl.setText(str);

            refresh();
        }
        else {
            int flag = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == 'e') {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1)
                    break;
            }
            if (flag == 0)
                drawProtocol();
        }
    }

    private boolean defensive()  // return false when no defensive move possible else true
    {
        Log.v("defensive()","inside defensive mve()");
        if(grid[0][0]=='x' && grid[0][1]=='x' &&grid[0][2]=='e')
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='x' &&grid[0][1]=='e'&&grid[0][2]=='x')
        {
            grid[0][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[0][1]=='x'&&grid[0][2]=='x')
        {
            grid[0][0]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][0]=='x'&&grid[2][0]=='e')
        {
            grid[2][0]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][0]=='e'&&grid[2][0]=='x')
        {
            grid[1][0]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][0]=='x'&&grid[2][0]=='x')
        {
            grid[0][0]='o';
        }
        else if(grid[1][0]=='x' &&grid[1][1]=='x'&&grid[1][2]=='e')
        {
            grid[1][2]='o';
        }
        else if(grid[1][0]=='x' &&grid[1][1]=='e'&&grid[1][2]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[1][0]=='e' &&grid[1][1]=='x'&&grid[1][2]=='x')
        {
            grid[1][0]='o';
        }
        else if(grid[0][1]=='x' &&grid[1][1]=='x'&&grid[2][1]=='e')
        {
            grid[2][1]='o';
        }
        else if(grid[0][1]=='x' &&grid[1][1]=='e'&&grid[2][1]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[0][1]=='e' &&grid[1][1]=='x'&&grid[2][1]=='x')
        {
            grid[0][1]='o';
        }
        else if(grid[2][0]=='x' &&grid[2][1]=='x'&&grid[2][2]=='e')
        {
            grid[2][2]='o';
        }
        else if(grid[2][0]=='x' &&grid[2][1]=='e'&&grid[2][2]=='x')
        {
            grid[2][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[2][1]=='x'&&grid[2][2]=='x')
        {
            grid[2][0]='o';
        }
        else if(grid[0][2]=='x' &&grid[1][2]=='x'&&grid[2][2]=='e')
        {
            grid[2][2]='o';
        }
        else if(grid[0][2]=='x' &&grid[1][2]=='e'&&grid[2][2]=='x')
        {
            grid[1][2]='o';
        }
        else if(grid[0][2]=='e' &&grid[1][2]=='x'&&grid[2][2]=='x')
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][1]=='x'&&grid[2][2]=='e')
        {
            grid[2][2]='o';
        }
        else if(grid[0][0]=='x' &&grid[1][1]=='e'&&grid[2][2]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][1]=='x'&&grid[2][2]=='x')
        {
            grid[0][0]='o';
        }
        else if(grid[2][0]=='x' &&grid[1][1]=='x'&&grid[0][2]=='e')
        {
            grid[0][2]='o';
        }
        else if(grid[2][0]=='x' &&grid[1][1]=='e'&&grid[0][2]=='x')
        {
            grid[1][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[1][1]=='x'&&grid[0][2]=='x')
        {
            grid[2][0]='o';
        }
        else
            return false;
        return true;
    }

    private boolean offensive()  // return true when no offesive move possible else false
    {
        Log.v("offensive()","inside offensive mve()");
        if(grid[0][0]=='o' && grid[0][1]=='o' &&grid[0][2]=='e')  //row 1
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='o' &&grid[0][1]=='e'&&grid[0][2]=='o') // row 1
        {
            grid[0][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[0][1]=='o'&&grid[0][2]=='o') // row 1
        {
            grid[0][0]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][0]=='o'&&grid[2][0]=='e') //column 1
        {
            grid[2][0]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][0]=='e'&&grid[2][0]=='o')
        {
            grid[1][0]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][0]=='o'&&grid[2][0]=='o')
        {
            grid[0][0]='o';
        }
        else if(grid[1][0]=='o' &&grid[1][1]=='o'&&grid[1][2]=='e') //row 2
        {
            grid[1][2]='o';
        }
        else if(grid[1][0]=='o' &&grid[1][1]=='e'&&grid[1][2]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[1][0]=='e' &&grid[1][1]=='o'&&grid[1][2]=='o')
        {
            grid[1][0]='o';
        }
        else if(grid[0][1]=='o' &&grid[1][1]=='o'&&grid[2][1]=='e') //column 2
        {
            grid[2][1]='o';
        }
        else if(grid[0][1]=='o' &&grid[1][1]=='e'&&grid[2][1]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[0][1]=='e' &&grid[1][1]=='o'&&grid[2][1]=='o')
        {
            grid[0][1]='o';
        }
        else if(grid[2][0]=='o' &&grid[2][1]=='o'&&grid[2][2]=='e') // row 3
        {
            grid[2][2]='o';
        }
        else if(grid[2][0]=='o' &&grid[2][1]=='e'&&grid[2][2]=='o')
        {
            grid[2][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[2][1]=='o'&&grid[2][2]=='o')
        {
            grid[2][0]='o';
        }
        else if(grid[0][2]=='o' &&grid[1][2]=='o'&&grid[2][2]=='e') // column 3
        {
            grid[2][2]='o';
        }
        else if(grid[0][2]=='o' &&grid[1][2]=='e'&&grid[2][2]=='o')
        {
            grid[1][2]='o';
        }
        else if(grid[0][2]=='e' &&grid[1][2]=='o'&&grid[2][2]=='o')
        {
            grid[0][2]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][1]=='o'&&grid[2][2]=='e') // diag 1
        {
            grid[2][2]='o';
        }
        else if(grid[0][0]=='o' &&grid[1][1]=='e'&&grid[2][2]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[0][0]=='e' &&grid[1][1]=='o'&&grid[2][2]=='o')
        {
            grid[0][0]='o';
        }
        else if(grid[2][0]=='o' &&grid[1][1]=='o'&&grid[0][2]=='e')  //diag 2
        {
            grid[0][2]='o';
        }
        else if(grid[2][0]=='o' &&grid[1][1]=='e'&&grid[0][2]=='o')
        {
            grid[1][1]='o';
        }
        else if(grid[2][0]=='e' &&grid[1][1]=='o'&&grid[0][2]=='o')
        {
            grid[2][0]='o';
        }
        else
            return true;
        return false;
    }

    private void drawProtocol()
    {
        Log.v("drawProtocol()","inside draw chk mech");
        draw++;
        Toast.makeText(this,R.string.ydraw,Toast.LENGTH_SHORT).show();
        String str=String.valueOf(draw);
        td.setText(str);

        refresh();
    }

    private void nextMove()
    {
        Log.v("nextMove()","inside next Computer mve()");
        Log.v("firstmove blk","firstmove: "+firstmove);
        if(firstmove)
        {
            firstmove=false;
            Random r=new Random();
            int random=r.nextInt(100);
            Log.v("firstmove blk","random: "+random);
            if(random<50)
            {
                grid[1][1]='o';
                Log.v("firstmove blk","random<50");
            }
            else
            {
                if(random<60)
                {
                    grid[0][0]='o';
                }
                else if(random<70)
                {
                    grid[2][0]='o';
                }
                else if(random<80)
                {
                    grid[0][2]='o';
                }
                else if(random<90)
                {
                    grid[2][2]='o';
                }
                else
                {
                    if(random<93)
                        grid[1][0]='o';
                    else if(random<=95)
                        grid[1][2]='o';
                    else if(random<98)
                        grid[0][1]='o';
                    else
                        grid[2][1]='o';
                }
            }
        }
        else
        {
            boolean donedef=defensive();
            boolean notdoneoff=true;
            if(!donedef)
                notdoneoff=offensive();
            if(notdoneoff && !donedef)
            {
                if(grid[1][1]=='e')
                    grid[1][1]='o';
                else if(grid[2][0]=='e')
                {
                    grid[2][0]='o';
                }
                else if(grid[0][2]=='e')
                {
                    grid[0][2]='o';
                }
                else if(grid[2][2]=='e')
                {
                    grid[2][2]='o';
                }
                else if(grid[0][0]=='e')
                    grid[0][0]='o';
                else
                {
                    if(grid[1][0]=='e')
                        grid[1][0]='o';
                    else if(grid[1][2]=='e')
                        grid[1][2]='o';
                    else if(grid[0][1]=='e')
                        grid[0][1]='o';
                    else if(grid[2][1]=='e')
                        grid[2][1]='o';
                    else
                        drawProtocol();
                }
            }
            result();
        }

        if(grid[0][0]=='o')
            t1.setText("O");
        if(grid[0][1]=='o')
            t2.setText("O");
        if(grid[0][2]=='o')
            t3.setText("O");
        if(grid[1][0]=='o')
            t4.setText("O");
        if(grid[1][1]=='o')
        {
            t5.setText("O");
            Log.v("nextMove()","grid[1][1]: "+grid[1][1]+" t5.getText(): "+t5.getText());
        }
        if(grid[1][2]=='o')
            t6.setText("O");
        if(grid[2][0]=='o')
            t7.setText("O");
        if(grid[2][1]=='o')
            t8.setText("O");
        if(grid[2][2]=='o')
            t9.setText("O");
        int flag=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(grid[i][j]=='e')
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        if(flag==0)
            drawProtocol();
    }

    private void refresh()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]='e';
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        firstmove=true;
    }

}