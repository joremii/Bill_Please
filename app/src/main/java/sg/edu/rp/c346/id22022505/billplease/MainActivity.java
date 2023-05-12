 package sg.edu.rp.c346.id22022505.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    TextView displayBill;
    Button SplitButton;
    Button ResetButton;
    EditText EnteredAmount;
    EditText EnteredPax;
    ToggleButton SVSButton;
    ToggleButton GSTButton;
    EditText DiscountedAmt;
    RadioGroup rgPayment;
    TextView displayTotal;
    TextView displayEach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayBill = findViewById(R.id.totalBillDisplay);
        SplitButton = findViewById(R.id.splitButton);
        ResetButton = findViewById(R.id.resetButton);
        EnteredAmount = findViewById(R.id.enterAmount);
        EnteredPax = findViewById(R.id.enterPax);
        SVSButton = findViewById(R.id.svs);
        GSTButton = findViewById(R.id.GST);
        DiscountedAmt = findViewById(R.id.editDiscount);
        rgPayment = findViewById(R.id.radioGroupPayment);
        displayTotal = findViewById(R.id.emptySpace2);
        displayEach = findViewById(R.id.emptySpace3);

        SplitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (EnteredAmount.getText().toString().trim().length() != 0 && EnteredPax.getText().toString().trim().length() != 0) {

         double newAmount = 0.0;
         if (!SVSButton.isChecked()) {
         double Amount = Double.parseDouble(EnteredAmount.getText().toString());


         } else if (SVSButton.isChecked() && GSTButton.isChecked()) {
         newAmount = Double.parseDouble(displayTotal.getText().toString()) * 1.18;


         }
         if (DiscountedAmt.getText().toString().trim().length() != 0) {
         newAmount *= 1 - Double.parseDouble(DiscountedAmt.getText().toString()) / 100;
         }
         if (rgPayment.getCheckedRadioButtonId() == R.id.cashPaymentButton) {
         String mode = "In Cash";
         } else {
         String mode = "Via PayNow to" + "88580421";

         }
         displayTotal.setText("Total Bill: $" + String.format("%.2f", newAmount));
         int numPerson = Integer.parseInt(EnteredPax.getText().toString());
         if (numPerson != 1) {
         displayEach.setText("Each Pays: $" + String.format("%.2f", newAmount / numPerson));

         } else {
         displayEach.setText("Each Pays: $" + newAmount);
         }
         ResetButton.setOnClickListener((new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         EnteredAmount.setText("");
         EnteredPax.setText("");
         SVSButton.setChecked(false);
         GSTButton.setChecked(false);
         DiscountedAmt.setText("");


         }
         }));
         }
         }
         });

         }
         }
