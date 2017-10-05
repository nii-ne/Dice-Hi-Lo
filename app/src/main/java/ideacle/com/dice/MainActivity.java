package ideacle.com.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Copyright (c) 05/10/2017.year.
 *Created by Mr. Artit Attasiri
 *iDeacle.co.th
 */

public class MainActivity extends AppCompatActivity {
    private ImageView dice1, dice2, dice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice1 = findViewById(R.id.imageView1);
        dice2 = findViewById(R.id.imageView2);
        dice3 = findViewById(R.id.imageView3);

    }

    private void renderDice() {
        dice1.setImageResource(this.getImage(this.random()));
        dice2.setImageResource(this.getImage(this.random()));
        dice3.setImageResource(this.getImage(this.random()));
    }

    private int getImage(int index) {
        switch (index) {
            case 1:
                index = R.drawable.one;
                break;
            case 2:
                index = R.drawable.two;
                break;
            case 3:
                index = R.drawable.three;
                break;
            case 4:
                index = R.drawable.four;
                break;
            case 5:
                index = R.drawable.five;
                break;
            default:
                index = R.drawable.six;
                break;
        }
        return index;
    }

    private int random() {
        return 1 + (int) (Math.random() * 6);
    }

    public void add(View v) {
        switch (v.getId()) {
            case R.id.height:
                //TODO 11-17
                this.height();
                break;
            case R.id.low:
                //TODO 4-10
                this.low();
                break;
            default:
                this.renderDice();
                break;
        }

    }

    private void height() {
        boolean loop = false;
        while (!loop) {
            int one = this.random();
            dice1.setImageResource(this.getImage(one));
            int two = this.random();
            dice2.setImageResource(this.getImage(two));
            int three = this.random();
            dice3.setImageResource(this.getImage(three));
            int sum = one + two + three;

            Log.d("Height", one + ":" + two + ":" + three);
            loop = sum >= 11 && sum <= 17;
        }
    }

    private void low() {
        boolean loop = false;
        while (!loop) {
            int one = this.random();
            dice1.setImageResource(this.getImage(one));
            int two = this.random();
            dice2.setImageResource(this.getImage(two));
            int three = this.random();
            dice3.setImageResource(this.getImage(three));
            int sum = one + two + three;
            Log.d("Low", one + ":" + two + ":" + three);
            loop = sum >= 4 && sum <= 10;
        }

    }
}
