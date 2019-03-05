package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StuLoginCtr {
    @FXML
    private Button Btn_submit;
    @FXML
    private Button Btn_exit;
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Text statusText;
    private int inputTimes=3;
    private String lastUsername="null";
    public void submition(){
        String username=usernameText.getText();
        if (!username.equals(lastUsername)){
            inputTimes=3;
            lastUsername=username;
        }
        String password=passwordText.getText();
        if (!Index.mp.containsKey(username)){
            statusText.setText("无该学生信息！");
        }else if(!Index.mp.get(username).getPassWord().equals(password) && inputTimes>0){
            statusText.setText("密码错误！"+"你还有 "+(inputTimes--)+" 次机会。");
        }else if (Index.mp.get(username).getPassWord().equals(password) && inputTimes>=0){
            try{
                Index.showStuMenu(username);
            }catch (IOException e){
                e.printStackTrace();
            }
            Stage stage=(Stage) Btn_submit.getScene().getWindow();
            stage.close();
        }else {
            Stage stage=(Stage) Btn_submit.getScene().getWindow();
            stage.close();
        }
    }

    public void exit(){
        Stage stage=(Stage) Btn_exit.getScene().getWindow();
        stage.close();
    }
}
