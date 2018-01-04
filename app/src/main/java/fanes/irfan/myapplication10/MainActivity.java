package fanes.irfan.myapplication10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_progres = findViewById(R.id.btn_progres);
        Button btn_HTTP = findViewById(R.id.btn_HTTP);
        Button btn_asyn = findViewById(R.id.btn_asyn);

        btn_progres.setOnClickListener(this);
        btn_HTTP.setOnClickListener(this);
        btn_asyn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_progres:
                startActivity(new Intent(this, ProgresBar.class));
                break;

            case R.id.btn_HTTP:
                startActivity(new Intent(this, HTTPActivity.class));
                break;

            case R.id.btn_asyn:
                startActivity(new Intent(this, AsyntaskActivity.class));
                break;
        }

        TextView tv_name = (TextView) findViewById(R.id.tv_name_nine);

        TextView tv_city = (TextView) findViewById(R.id.tv_city_nine);

        TextView tv_province = (TextView) findViewById(R.id.tv_province_nine);


//create new JSON Object

//this code for declare json object

        JSONObject student_json = new JSONObject();

        JSONObject address_json = new JSONObject();

        try {

            student_json.put("name", "Irfan");

            address_json.put("city", "bandung");

            address_json.put("province", "west java");

            student_json.put("address", address_json);

            //this for handle set value to text view

            tv_name.setText("Name : " + student_json.getString("name"));

            JSONObject jo_address = (JSONObject) student_json.get("address");

            tv_city.setText("City : " + jo_address.getString("city"));

            tv_province.setText("Province : " + jo_address.getString("province"));

        } catch (JSONException e) {

            Log.i("info", String.valueOf(e));

        }
    }
}
