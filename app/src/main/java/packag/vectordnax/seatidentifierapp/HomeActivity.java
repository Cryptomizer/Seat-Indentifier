package packag.vectordnax.seatidentifierapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public EditText editText;
    public TextView textView;
    int ok;

    public void seat1(int S) {
        if (S >= 1 && S <= 72) {
            int k = (S % 8);
            if (k == 0) {
                textView.setText("  SIDE UPPER SEAT");
            } else {
                switch (k) {
                    case 1: {
                        textView.setText("  LOWER SEAT");
                        break;
                    }
                    case 2: {
                        textView.setText("  MIDDLE SEAT");
                        break;
                    }
                    case 3: {
                        textView.setText("  UPPER SEAT");
                        break;
                    }
                    case 4: {
                        textView.setText("  LOWER SEAT");
                        break;
                    }
                    case 5: {
                        textView.setText("  MIDDLE SEAT");
                        break;
                    }
                    case 6: {
                        textView.setText("  UPPER SEAT");
                        break;
                    }
                    case 7: {
                        textView.setText("  SIDE LOWER SEAT");
                        break;
                    }

                    default:
                        textView.setText(" ");
                        break;

                }
            }
        } else {
            textView.setText("Invalid Seat Number!");
        }

    }

    public void seat2(int S) {
        if (S >= 1 && S <= 46) {
            int k = (S % 6);
            if (k == 0) {
                textView.setText("  SIDE UPPER SEAT");
            } else {
                switch (k) {
                    case 1: {
                        textView.setText("  LOWER SEAT");
                        break;
                    }

                    case 2: {
                        textView.setText("  UPPER SEAT");
                        break;
                    }
                    case 3: {
                        textView.setText("  LOWER SEAT");
                        break;
                    }

                    case 4: {
                        textView.setText("  UPPER SEAT");
                        break;
                    }
                    case 5: {
                        textView.setText("  SIDE LOWER SEAT");
                        break;
                    }

                    default:
                        textView.setText(" ");
                        break;

                }
            }
        } else {
            textView.setText("Invalid Seat Number!");
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("What to do?");
        builder.setMessage("Do you want to Exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        final Switch switch1 = findViewById(R.id.switch1);

        Button button = findViewById(R.id.button);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int S = Integer.parseInt(editText.getText().toString());
                if (ok == 0) {
                    seat1(S);
                }
                if (ok == 1) {
                    seat2(S);
                }


            }

        });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ok = 0;
                } else {
                    ok = 1;
                }
            }
        });
    }
}