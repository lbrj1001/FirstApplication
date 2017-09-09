package test.liangbo.com.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liangbo.com.view.MainView;
import com.liangbo.com.view.SquareList;
import com.liangbo.com.view.StrokeSquare;

public class MainActivity extends AppCompatActivity {
    private TextView tv_name;
    private boolean isChange=true;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrokeSquare goal = new StrokeSquare();
        goal.setEat(false);
        SquareList snake = new SquareList(5);
        MainView mainView = new MainView(this,goal,snake);
        setContentView(mainView);

        snake.DefaultMove(mainView,goal);
    }
}
