package com.noman.dialogues;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SingleRecordAdapter extends BaseAdapter {
    Context MainActivityContext;
    Context context;
    ArrayList<StudentModel> studentsList;
    DatabaseHelper databaseHelper;
    LayoutInflater inflater;

    public SingleRecordAdapter(Context applicationContext, Context MainActivityContext, ArrayList<StudentModel> studentsList) {
        this.context = applicationContext;
        this.studentsList = studentsList;
        databaseHelper = new DatabaseHelper(MainActivityContext);
        inflater = (LayoutInflater.from(applicationContext));
        this.MainActivityContext = MainActivityContext;
    }

    @Override
    public int getCount() {
        return studentsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_listview, null);

        TextView name = view.findViewById(R.id.nameTextView);
        TextView id = view.findViewById(R.id.idTextView);
        ImageButton updateBtn = view.findViewById(R.id.updateBtn);
        ImageButton deleteBtn = view.findViewById(R.id.deleteBtn);

        name.setText(studentsList.get(i).getName());
        id.setText(studentsList.get(i).getReg_no());
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDialog(i);

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDialog(i);
            }
        });

        return view;
    }

    private void deleteDialog(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityContext);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure you want to delete this record?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseHelper.deleteStudent(Integer.parseInt(studentsList.get(index).getId()));
                refresh();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void refresh() {
        studentsList = databaseHelper.getALLStudents();
        notifyDataSetChanged();
    }

    private void updateDialog(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityContext);
        builder.setTitle("Update");

        View view = inflater.inflate(R.layout.activity_custom_dialog, null);
        EditText idInput = view.findViewById(R.id.idInput);
        EditText nameInput = view.findViewById(R.id.nameInput);
        idInput.setText(studentsList.get(index).getReg_no());
        nameInput.setText(studentsList.get(index).getName());

        builder.setView(view);

        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StudentModel studentModel = studentsList.get(index);
                studentModel.setName(nameInput.getText().toString());
                studentModel.setReg_no(idInput.getText().toString());

                databaseHelper.updateStudent(studentsList.get(index));
                refresh();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
