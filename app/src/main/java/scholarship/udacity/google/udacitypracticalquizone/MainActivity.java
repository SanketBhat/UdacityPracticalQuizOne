package scholarship.udacity.google.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_DESCRIPTION = "description";

    EditText etName, etEmail, etDescription;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = findViewById(R.id.name);
        etEmail = findViewById(R.id.email);
        etDescription = findViewById(R.id.description);
        buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_profile) {
            startActivity(new Intent(this,DetailsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (isNotEmpty(etName.getText().toString()) && isNotEmpty(etEmail.getText().toString()) && isNotEmpty(etDescription.getText().toString())) {
            saveContents();
            startActivity(new Intent(this, DetailsActivity.class));
        } else {
            Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveContents() {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString(EXTRA_NAME, etName.getText().toString());
        editor.putString(EXTRA_EMAIL, etEmail.getText().toString());
        editor.putString(EXTRA_DESCRIPTION, etDescription.getText().toString());
        editor.commit();
    }

    boolean isNotEmpty(String string) {
        return !string.trim().equals("");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(EXTRA_NAME, etName.getText().toString());
        outState.putString(EXTRA_EMAIL, etEmail.getText().toString());
        outState.putString(EXTRA_DESCRIPTION, etDescription.getText().toString());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle b) {
        super.onRestoreInstanceState(b);
        etName.setText(b.getString(EXTRA_NAME));
        etEmail.setText(b.getString(EXTRA_EMAIL));
        etDescription.setText(b.getString(EXTRA_DESCRIPTION));
    }
}
