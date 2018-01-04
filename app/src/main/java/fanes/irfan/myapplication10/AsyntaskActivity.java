package fanes.irfan.myapplication10;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyntaskActivity extends Activity {


    Button btn_start;
    ProgressBar progressBar;
    TextView txt_percentage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask);

        btn_start = (Button) findViewById(R.id.btn_start);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        txt_percentage = (TextView) findViewById(R.id.txt_percentage);

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                btn_start.setEnabled(false);
                new ShowDialogAsyncTask().execute();
            }
        });
    }


    private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void> {

        int progress_status;

        @Override
        protected void onPreExecute() {
            // update the UI immediately after the task is executed
            super.onPreExecute();

            Toast.makeText(AsyntaskActivity.this,
                    "TUNGGUAN SAKEUDEUNG()", Toast.LENGTH_SHORT).show();

            progress_status = 0;
            txt_percentage.setText("downloading 0%");

        }

        @Override
        protected Void doInBackground(Void... params) {

            while (progress_status < 100) {

                progress_status += 2;

                publishProgress(progress_status);
                SystemClock.sleep(300);

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
            txt_percentage.setText("downloading " + values[0] + "%");

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Toast.makeText(AsyntaskActivity.this,
                    "BLUERAY XXX()", Toast.LENGTH_SHORT).show();

            txt_percentage.setText("download complete");
            btn_start.setEnabled(true);
        }

    }
}