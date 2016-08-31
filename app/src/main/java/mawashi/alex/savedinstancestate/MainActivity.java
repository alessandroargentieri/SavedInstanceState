package mawashi.alex.savedinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String LAST_EDIT = "last edit";
    String mLastEdit;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edit);
        textView = (TextView) findViewById(R.id.text);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            mLastEdit = savedInstanceState.getString(LAST_EDIT);
        } else {
            // Probably initialize members with default values for a new instance
            mLastEdit = "No edit yet";
        }
        textView.setText(mLastEdit);
    }

    /*
    * This callback method saves the "state" of the app when destroyed.
    * This state will be recovered in the onCreate method
    * */


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString(LAST_EDIT, mLastEdit);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


    //button onClick
    public void GetText(View v){
        mLastEdit = editText.getText().toString();
        textView.setText(mLastEdit);
    }
}
