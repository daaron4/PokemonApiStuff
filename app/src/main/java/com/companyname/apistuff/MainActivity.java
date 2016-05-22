package com.companyname.apistuff;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements WebClient.ApiResponseHandler {

    private Button buttonWithInfo;
    private Button button;
    private EditText editText;
    private SimplePokemon simplePokemon;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonWithInfo = (Button) findViewById(R.id.button_with_info);
        progressBar = (ProgressBar) findViewById(R.id.bar);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);

        buttonWithInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!buttonWithInfo.getText().equals("Data here")) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bulbapedia.bulbagarden.net/wiki/" + simplePokemon.getName()));
                    startActivity(browserIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Do a search first", Toast.LENGTH_LONG).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                String userInput = editText.getText().toString();
                if (!userInput.equals("")) {
                    try {
                        int id = Integer.parseInt(userInput);
                        if (id < 0) {
                            Toast.makeText(getApplicationContext(), "Negatives are not allowed", Toast.LENGTH_LONG).show();
                        }
                        else if (id ==0) {
                            Toast.makeText(getApplicationContext(), "The pokedex does not start counting at zero, fool.", Toast.LENGTH_LONG).show();
                        }
                        else if (id > 721) {
                            Toast.makeText(getApplicationContext(), "There are only 721 pokemon!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            progressBar.setVisibility(View.VISIBLE);
                            WebClient.getInstance(MainActivity.this).doRequest(id);
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Enter a number", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter a query", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void handleResponse(SimplePokemon response) {
        progressBar.setVisibility(View.INVISIBLE);
        simplePokemon = response;
        buttonWithInfo.setText(simplePokemon.toString());
    }
}
