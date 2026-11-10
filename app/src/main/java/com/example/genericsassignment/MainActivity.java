package com.example.genericsassignment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView output = findViewById(R.id.outputText);
        output.setText(captureOutput());
    }

    /** Запускает все задания и возвращает всё, что они напечатали в System.out. */
    private String captureOutput() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(buffer, true, "UTF-8"));
            GenericsDemo.runAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.flush();
            System.setOut(originalOut);
        }
        return new String(buffer.toByteArray(), StandardCharsets.UTF_8).trim();
    }
}
