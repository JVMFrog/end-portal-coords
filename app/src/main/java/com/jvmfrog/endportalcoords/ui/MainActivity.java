package com.jvmfrog.endportalcoords.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jvmfrog.endportalcoords.EndPortal;
import com.jvmfrog.endportalcoords.ErrorDialogs;
import com.jvmfrog.endportalcoords.Point;
import com.jvmfrog.endportalcoords.R;
import com.jvmfrog.endportalcoords.exception.AnglesEqualException;
import com.jvmfrog.endportalcoords.exception.AnglesOppositeException;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout first_x_coord_layout, first_z_coord_layout, first_throw_angle_layout;
    private TextInputLayout second_x_coord_layout, second_z_coord_layout, second_throw_angle_layout;

    private TextInputEditText first_x_coord, first_z_coord, first_throw_angle;
    private TextInputEditText second_x_coord, second_z_coord, second_throw_angle;

    private MaterialButton calculate_coordinates_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ErrorDialogs errorDialogs = new ErrorDialogs();

        init();


        calculate_coordinates_btn.setOnClickListener(
                v -> {
                    try {
                        Point endPortal = EndPortal.getPortalCoords(new Point(10, 10), new Point(20, 20), 60, 50);
                        System.out.println(endPortal.x + " " + endPortal.z);
                    } catch (AnglesEqualException e) {
                        errorDialogs.angleEqualException(v.getContext());
                    } catch (AnglesOppositeException e) {
                        errorDialogs.angleOppositeException(v.getContext());
                    }
                });

        // Set error text
        //passwordLayout.error = getString(R.string.error)

        // Clear error text
        //passwordLayout.error = null
    }

    public void init() {
        //TextInputLayout
        first_x_coord_layout = findViewById(R.id.first_x_coord_layout);
        first_z_coord_layout = findViewById(R.id.first_z_coord_layout);
        first_throw_angle_layout = findViewById(R.id.first_throw_angle_layout);
        second_x_coord_layout = findViewById(R.id.second_x_coord_layout);
        second_z_coord_layout = findViewById(R.id.second_z_coord_layout);
        second_throw_angle_layout = findViewById(R.id.second_throw_angle_layout);

        //TextInputEditText
        first_x_coord = findViewById(R.id.first_x_coord);
        first_z_coord = findViewById(R.id.first_z_coord);
        first_throw_angle = findViewById(R.id.first_throw_angle);
        second_x_coord = findViewById(R.id.second_x_coord);
        second_z_coord = findViewById(R.id.second_z_coord);
        second_throw_angle = findViewById(R.id.second_throw_angle);

        //Buttons
        calculate_coordinates_btn = findViewById(R.id.calculate_coordinates_btn);
    }
}