package com.sxt.serjplayground.Activities.Login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sxt.serjplayground.Activities.Main.MainActivity;
import com.sxt.serjplayground.Helpers.FastDialog;
import com.sxt.serjplayground.Listeners.SimpleListener;
import com.sxt.serjplayground.Models.Bases.SystemData;
import com.sxt.serjplayground.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = (Button)findViewById(R.id.buttonLogin);

    }

    public void OnButtonLoginClick(View V)
    {
        SystemData.Data.Comments.CommentsListRefreshed = OnCommentsListRefreshed;
        SystemData.Data.Comments.RefreshCommentsList();
    }


    private SimpleListener OnCommentsListRefreshed = new SimpleListener() {
        @Override
        public void onEvent(Object obj)
        {
            FastDialog.Show(LoginActivity.this, "Procedere?", "Credenziali confermate",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            startActivity(new Intent( getApplicationContext(), MainActivity.class));
                        }
                    },
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
        }
    };



}
