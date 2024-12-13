package th.duongthianhhong.th_bai5_simpledict;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DictionaryController {

    @FXML
    private TextField input;
    @FXML
    private TextField transcription;
    @FXML
    private TextField translate;
    @FXML
    private Button find;
    @FXML
    private TextField ex;
    @FXML
    private Button addWordButton;

    private Map<String, String[]> dictionary = new HashMap<>();


    // Constructor để khởi tạo từ điển ban đầu
    public DictionaryController() {
        loadDictionaryFromFile(); // Đọc từ điển từ tệp khi khởi động
    }

    // Hàm tìm từ trong từ điển
    @FXML
    public void findWord() {
        String word = input.getText().toLowerCase();
        if (dictionary.containsKey(word)) {
            String[] meaningAndTranscription = dictionary.get(word);
            transcription.setText(meaningAndTranscription[0]);
            translate.setText(meaningAndTranscription[1]);
            ex.setText(meaningAndTranscription[2]);
        } else {
            transcription.setText("Không tìm thấy");
            translate.setText("Không tìm thấy");
            ex.setText("Không có ví dụ");
        }
    }

    // Hàm thêm từ mới vào từ điển và lưu vào tệp
    @FXML
    public void addNewWord() {
        String word = input.getText().toLowerCase();
        String wordTranscription = transcription.getText();
        String wordMeaning = translate.getText();
        String wordExample = ex.getText();

        // Kiểm tra nếu các trường dữ liệu không rỗng
        if (!word.isEmpty() && !wordTranscription.isEmpty() && !wordMeaning.isEmpty() && !wordExample.isEmpty()) {
            // Kiểm tra xem từ đã tồn tại trong từ điển chưa
            if (dictionary.containsKey(word)) {
                // Nếu từ đã có, hiển thị thông báo
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText(null);  // Không có tiêu đề
                alert.setContentText("Từ '" + word + "' đã tồn tại trong từ điển.");
                alert.showAndWait();
            } else {
                // Nếu từ chưa có, thêm từ mới vào từ điển
                dictionary.put(word, new String[]{wordTranscription, wordMeaning, wordExample});
                // Lưu từ điển vào tệp
                saveDictionaryToFile();

                // Hiển thị thông báo thành công
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);  // Không có tiêu đề
                alert.setContentText("Đã thêm từ '" + word + "' thành công!");
                alert.showAndWait();  // Hiển thị thông báo và chờ người dùng đóng thông báo

                // Xóa các trường nhập liệu sau khi thêm
                input.clear();
                transcription.clear();
                translate.clear();
                ex.clear();
            }
        } else {
            // Thông báo nếu có trường nào đó rỗng
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);  // Không có tiêu đề
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.showAndWait();  // Hiển thị thông báo cảnh báo
        }
    }



    // Lưu từ điển vào tệp
    private void saveDictionaryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))) {
            for (Map.Entry<String, String[]> entry : dictionary.entrySet()) {
                String word = entry.getKey();
                String[] data = entry.getValue();
                writer.write(word + "," + data[0] + "," + data[1] + "," + data[2]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc từ điển từ tệp
    private void loadDictionaryFromFile() {
        File file = new File("dictionary.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();  // Tạo mới nếu tệp không tồn tại
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    dictionary.put(parts[0], new String[]{parts[1], parts[2], parts[3]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
