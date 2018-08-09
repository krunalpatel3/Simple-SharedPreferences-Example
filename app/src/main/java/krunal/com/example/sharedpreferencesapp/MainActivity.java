package krunal.com.example.sharedpreferencesapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextName,mEditTextAge;

    private Button mSaveButton, mDisplaybtn;

    private String mName = "Name";

    private String mAge = "Age";

    private String Name = "";

    private String Age ="";

    private TextView mTextViewResult;

    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private static final String mPreferncesName = "MyPerfernces";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize  preferences object.
        mPreferences = getSharedPreferences(mPreferncesName, MODE_PRIVATE);

        mDisplaybtn = findViewById(R.id.buttonResult);

        mEditTextName = findViewById(R.id.editTextName);

        mTextViewResult = findViewById(R.id.Display);

        mEditTextAge = findViewById(R.id.editTextAge);

        mSaveButton = findViewById(R.id.buttonSave);

        mSaveButton.setOnClickListener(v -> {

            Name = mEditTextName.getText().toString();
            Age = mEditTextAge.getText().toString();

            if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Age)) {
                    Toast.makeText(this, "Enter Name and Age!", Toast.LENGTH_LONG).show();
            } else {
                // Save the values in Shared Perfernce file.
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString(mName, Name);
                preferencesEditor.putInt(mAge, Integer.valueOf(Age));
                preferencesEditor.apply();

                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
            }
        });

        mDisplaybtn.setOnClickListener(v -> {
            // Get the Values from Shared Perfernce file and Display in Text View.
            String getName = mPreferences.getString(mName,null);
            if (getName != null){
                int getAge = mPreferences.getInt(mAge,0);

                mTextViewResult.setText("Name: " + getName + "Age: " + getAge);

            }else {
                Toast.makeText(this,"There is No Values!",Toast.LENGTH_LONG).show();
            }
        });
    }





}





