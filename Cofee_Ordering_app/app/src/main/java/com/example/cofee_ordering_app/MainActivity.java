package com.example.cofee_ordering_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity=2;
    String usernm;
    boolean haswhippedCream;
    boolean hasChocolate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Increament(View view) {
        if(quantity==100)
        {
            Toast.makeText(this,"You can not have more than 100 cups of cofee",Toast.LENGTH_LONG).show();
            return;
        }
        quantity++;
        display(quantity);
    }
    public void Decrement(View view) {
        if(quantity==1)
        {
            Toast.makeText(this,"You can not have less than 1 cups of cofee",Toast.LENGTH_LONG).show();
            return;
        }
        quantity--;
        display(quantity);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    public void submitOrder(View view) {
        CheckBox whippedCreamcb=(CheckBox)findViewById(R.id.checkBox);
        CheckBox chocolatecb=(CheckBox)findViewById(R.id.checkBox2);
        haswhippedCream=whippedCreamcb.isChecked();
        hasChocolate=chocolatecb.isChecked();
        EditText nm=(EditText)findViewById(R.id.name);
        usernm=nm.getText().toString();
        int price=calculateprice();
        String str=createOrderSummary(price);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Cofee ordered By: "+usernm);
        intent.putExtra(Intent.EXTRA_TEXT, str);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private int calculateprice()
    {
        if(haswhippedCream && hasChocolate)
            return quantity*5+quantity*3;
        else if(haswhippedCream)
            return quantity*5+quantity*1;
        else if(hasChocolate)
            return quantity*5+quantity*2;
        else
            return quantity*5;
    }
    private String createOrderSummary(int price)
    {
        String pricemsg="Name: "+usernm;
        pricemsg+="\nAdd Whipped Cream? "+ " "  +haswhippedCream;
        pricemsg+="\nAdd Chocolate? "+" "+hasChocolate;
        pricemsg=pricemsg+"\nQuantity: "+ quantity;
        pricemsg=pricemsg+"\nTotal: $" + price;
        pricemsg=pricemsg+"\nThank you!";
        return pricemsg;
    }

}