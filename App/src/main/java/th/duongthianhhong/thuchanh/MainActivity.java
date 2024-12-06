package th.duongthianhhong.thuchanh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB;
    private Spinner spinnerOperator;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        spinnerOperator = findViewById(R.id.spinnerOperator);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Tạo adapter cho Spinner
        ArrayAdapter<String> operatorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                new String[]{"+", "-", "*", "/"});
        operatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperator.setAdapter(operatorAdapter);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double numA = Double.parseDouble(editTextA.getText().toString());
                    double numB = Double.parseDouble(editTextB.getText().toString());
                    String operator = spinnerOperator.getSelectedItem().toString();
                    double result = 0;

                    // Thực hiện phép toán dựa trên phép toán đã chọn
                    switch (operator) {
                        case "+":
                            result = numA + numB;
                            break;
                        case "-":
                            result = numA - numB;
                            break;
                        case "*":
                            result = numA * numB;
                            break;
                        case "/":
                            if (numB != 0) {
                                result = numA / numB;
                            } else {
                                textViewResult.setText("Lỗi: Chia cho 0");
                                return;
                            }
                            break;
                    }

                    // Hiển thị kết quả
                    textViewResult.setText("Kết quả: " + result);

                } catch (NumberFormatException e) {
                    textViewResult.setText("Vui lòng nhập số hợp lệ.");
                }
            }
        });
    }
}
