package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cBox;
    EditText edName;
    EditText edPhone;
    EditText edPax;
    Button butConfirm;
    Button butReset;
    TimePicker tPick;
    DatePicker dPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cBox=findViewById(R.id.smoke);
        edName=findViewById(R.id.editName);
        edPhone=findViewById(R.id.editPhone);
        edPax=findViewById(R.id.editPax);
        butConfirm=findViewById(R.id.btnConfirm);
        butReset=findViewById(R.id.btnReset);
        tPick=findViewById(R.id.timePicker);
        dPick=findViewById(R.id.datePicker);

        tPick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tPick.setIs24HourView(true);
                if (tPick.getCurrentHour() >= 21 || tPick.getCurrentHour() < 20 ){
                    tPick.setCurrentHour(20);

                }
            }
        });




        butConfirm.setOnClickListener(new View.OnClickListener() {



            public void onClick(View view) {
                // Add your code for the action
                if((!edName.getText().toString().isEmpty())&&(!edPax.getText().toString().isEmpty())&&(!edPhone.getText().toString().isEmpty())) {
                    String smoked = "Non-Smoking Table";
                    if (cBox.isChecked()) {
                        smoked = "Smoking Table";
                    }
                    String Test = "Thank you " + edName.getText() + " for making a " + smoked + " booking for " + edPax.getText() + " people, on " + dPick.getDayOfMonth() + "/" + dPick.getMonth() + "/" + dPick.getYear() + " " + tPick.getCurrentHour() + ":" + tPick.getCurrentMinute() + ". Should there be any changes, we will contact you at " + edPhone.getText() + ".";

                    Toast.makeText(MainActivity.this, Test, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Fill up all the fills!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        butReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code for the action

                edName.setText(null);
                edPax.setText(null);
                edPhone.setText(null);


                cBox.setChecked(false);
                tPick.setCurrentHour(19);
                tPick.setCurrentMinute(30);
                dPick.updateDate(2019,0,1);



            }
        });







    }



}
