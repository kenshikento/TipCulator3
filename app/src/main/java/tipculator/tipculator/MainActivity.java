package tipculator.tipculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double vat = 20;

    String total = "";
    String total1 = "";
    double v1, v2;
    double grand_Vat;
    String sign = "";
    double grand_total;
    double grand_total2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClick(View v) {
        Button button = (Button) v;
        String str = button.getText().toString();
        total += str;
        EditText edit = (EditText) findViewById(R.id.editText);
        edit.setText(total);
        TextView text =(TextView)findViewById(R.id.textView);
        text.setText("");
    }

    public void onAdd(View v) {
        vat=vat+0.5;
        display(vat);

   }

    public void onSub(View v)
{
    vat=vat-0.5;
    display(vat);
}
private void display(double number){

  TextView editText3  =(TextView)findViewById(R.id.editText3);
    editText3.setText("" + number + "%");
}
        public void onCalculate(View v){

        EditText edit =(EditText)findViewById(R.id.editText);

        if (edit.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "You haven't put any bill down.. Please Enter your Bill", Toast.LENGTH_SHORT).show();
        }
        else{

        String str2=edit.getText().toString();
        v1=Double.parseDouble(str2);

        grand_total= (v1/100.0f)*vat;

        edit.setText(grand_total+"");
        EditText edit2 =(EditText)findViewById(R.id.editText2);
        double grand_total2;
        grand_total2 = v1+grand_total;
        edit2.setText(grand_total2+"");
    }}
    public void OnClear(View v){
        EditText edit =(EditText)findViewById(R.id.editText);
        edit.setText("");

        EditText edit2 =(EditText)findViewById(R.id.editText2);
        edit2.setText("");
        total="";
        TextView text =(TextView)findViewById(R.id.textView);
        text.setText("Bill");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
