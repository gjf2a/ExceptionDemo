package edu.hendrix.ferrer.exceptiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.editName);
        final EditText age = findViewById(R.id.editAge);

        final DataManager manager = new DataManager(getFilesDir());

        Button saver = findViewById(R.id.save_button);
        saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    manager.saveRecord(new Record(name.getText().toString(), Integer.parseInt(age.getText().toString())));
                } catch (NumberFormatException e) {
                    ModalDialogs.notifyProblem(MainActivity.this, "Your age must be an integer");
                } catch (IOException e) {
                    ModalDialogs.notifyProblem(MainActivity.this, "Could not save your data");
                } catch (Exception e) {
                    ModalDialogs.notifyException(MainActivity.this, e);
                }
            }
        });

        Button opener = findViewById(R.id.open_button);
        opener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Record data = manager.openRecord(name.getText().toString());
                } catch (FileNotFoundException e) {
                    ModalDialogs.notifyProblem(MainActivity.this, "Name not present in database");
                } catch (Exception e) {
                    ModalDialogs.notifyException(MainActivity.this, e);
                }
            }
        });
    }
}
