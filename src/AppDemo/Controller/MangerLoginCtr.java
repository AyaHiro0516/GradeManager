package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MangerLoginCtr {
    @FXML
    private Button Btn_submit;
    @FXML
    private Button Btn_exit;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Text statusText;

    public void submition(){
        String password=passwordText.getText();
        if (password.equals("bxy0516")){
            try{
                Index.showMangerMenu();
            }catch (IOException e){
                e.printStackTrace();
            }
            Stage stage=(Stage) Btn_submit.getScene().getWindow();
            stage.close();
        }else {
            statusText.setText("密码错误！");
        }
    }
    public void close(){
        Stage stage=(Stage) Btn_exit.getScene().getWindow();
        stage.close();
    }
}
