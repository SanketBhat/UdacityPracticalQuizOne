package scholarship.udacity.google.udacitypracticalquizone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvName = findViewById(R.id.textViewName);
        tvEmail = findViewById(R.id.textViewEmail);
        tvDescription = findViewById(R.id.textViewDescription);


        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        tvName.setText(pref.getString(MainActivity.EXTRA_NAME, " "));
        tvEmail.setText(pref.getString(MainActivity.EXTRA_EMAIL, " "));
        tvDescription.setText(pref.getString(MainActivity.EXTRA_DESCRIPTION, " "));
    }

}
