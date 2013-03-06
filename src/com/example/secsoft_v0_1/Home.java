package com.example.secsoft_v0_1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends Activity {
    /**
     * Called when the activity is first created.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.VenueLogin );
    }
    */

    Button LoginButton, newVenueButton;
    EditText Username, Password;
    String user, password;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main );


        LoginButton = (Button)findViewById(R.id.LoginButton);
        Username = (EditText)findViewById(R.id.TextUser);
        Password = (EditText )findViewById(R.id.TextPassword );


        LoginButton.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        //TODO passChecker to be implemented
                        user = (Username.getText().toString());
                        password = (Password .getText() .toString() );

                    }
                });
        newVenueButton .setOnClickListener(new View.OnClickListener()
                {
                @Override
                    public void onClick(View view)
                    {
                        //TODO ChangePage(NewVenue Form)
                    }
                });

    }

}
