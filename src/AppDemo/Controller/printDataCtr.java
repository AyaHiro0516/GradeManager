package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class printDataCtr {
    @FXML
    private TextArea dataArea;
    @FXML
    private Button Btn_backward;
    @FXML
    private Button Btn_printData;
    @FXML
    private Button Btn_choose;
    @FXML
    private Text statusText;
    @FXML
    private TextField showFileText;

    public TextField getShowFileText(){
        return showFileText;
    }
    public TextArea getDataArea(){
        return dataArea;
    }
    public void printData(){
        if (Index.showDataFile!=null){
            try {
                Index.printAllData();
                statusText.setText("打印成功！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            statusText.setText("未选择输出文件，写入失败！");
        }

    }
    public void chooseFile(){
        statusText.setText("");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择输出文件");
        Stage stage=(Stage)Btn_choose.getScene().getWindow();
        File targetFile=fileChooser.showOpenDialog(stage);
        if (targetFile!=null){
            Index.showDataFile=targetFile;
            showFileText.setText(Index.showDataFile.toString());
        }else {
            Index.showDataFile=null;
            showFileText.setText("您未选择输出文件(txt)");
        }
    }
    public void backward(){
        try {
            Index.showMangerMenu();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
