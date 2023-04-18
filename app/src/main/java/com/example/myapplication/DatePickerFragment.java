package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c =Calendar.getInstance();
        int year =c.get(Calendar.YEAR);
        int month =c.get(Calendar.MONTH);
        int day =c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(requireContext(),this,year,month,day);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Toast.makeText(getActivity(),"Date picked successfully: "+year+ month + day, Toast.LENGTH_SHORT).show();


    }
}
