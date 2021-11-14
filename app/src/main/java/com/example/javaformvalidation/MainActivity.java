package com.example.javaformvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // The view objects
    private EditText
            editTextName, editTextBed, editTextDate, editTextRent,
            editTextReporter, editTextFurniture, editTextNote,
            editTextEmail, editTextMobile, editTextPassword;

    private Button buttonSubmit;


    // defining AwesomeValidation objective

    private AwesomeValidation awesomeValidation;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing 3 types fo validation
        // The library provide the types of validation
        // BASIC
        // COLORATION
        // UNDER LABEL
        //     awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // initializing view objects

        editTextName = findViewById(R.id.editTextProperty);

        editTextBed = findViewById(R.id.editTextBedType);
        editTextDate = findViewById(R.id.editTextDate);
        editTextRent = findViewById(R.id.editTextRent);
        editTextReporter = findViewById(R.id.editTextReporter);
        // editTextFurniture = findViewById(R.id.editTextFurniture);
        // editTextNote = findViewById(R.id.editTextNote);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextMobile = findViewById(R.id.editTextMobileNumber);


        buttonSubmit =  findViewById(R.id.Submit);


        // Add validation to edit texts
        awesomeValidation.addValidation(this,R.id.editTextProperty,"^[a-zA-Z0-9._-]{3,}$", R.string.nameerror );

        awesomeValidation.addValidation(this,R.id.editTextBedType,RegexTemplate.NOT_EMPTY, R.string.bederror );
        awesomeValidation.addValidation(this,R.id.editTextDate,"^\\d{4}-\\d{2}-\\d{2}$", R.string.dateerror );
        awesomeValidation.addValidation(this,R.id.editTextRent,RegexTemplate.NOT_EMPTY, R.string.renterror );
        awesomeValidation.addValidation(this,R.id.editTextReporter,"^[a-zA-Z0-9._-]{3,}$", R.string.reportererror );
        //awesomeValidation.addValidation(this,R.id.editTextFurniture, RegexTemplate.NOT_EMPTY, R.string.nameerror );
        //awesomeValidation.addValidation(this,R.id.editTextNote, RegexTemplate.NOT_EMPTY, R.string.nameerror );

        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextPassword, RegexTemplate.NOT_EMPTY, R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.editTextMobileNumber, "^[1-9]\\d{2}\\s\\d{3}\\s\\d{4}", R.string.mobileerror);

        buttonSubmit.setOnClickListener(this);
    }
    private void submitForm() {
        // first validate form
        // if this become true that mean validation is succesful
        if (awesomeValidation.validate())
        {
            //Process data  further
            Toast.makeText(this, "Validation successful", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View view) {
        if (view == buttonSubmit)
        {
            submitForm();
        }
    }
}