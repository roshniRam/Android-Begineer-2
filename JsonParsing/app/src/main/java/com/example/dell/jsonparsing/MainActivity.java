package com.example.dell.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView tv = (TextView) fingViewById(R.id.text_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            JSONObject obj = new JSONObject(readJSONFromAsset());
            JSONArray inningsArray = obj.getJSONArray("innings");

            for (int i = 0; i < inningsArray.length(); i++){
                JSONObject inning = inningsArray.getJSONObject(i);
                String inningsNumber = inning.getString("innings_number");
                tv.setText(inningsNumber + "Inning \n");
                String battingTeam = inning.getString("batting_team_id");
                if (battingTeam == "6") {
                    tv.setText("Batting team India and Blowing team West Indies" + "\n");
                } else {
                    tv.setText("Batting team West Indies and Blowing team India" + "\n");
                }
                String runs = inning.getString("runs");
                tv.setText(runs + "\n");

                tv.setText("\n\n");


            }

        }catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("match.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

