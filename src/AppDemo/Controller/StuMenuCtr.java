package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class StuMenuCtr {
    @FXML
    private Button Btn_changePassword;
    @FXML
    private Button Btn_showData;
    @FXML
    private Button Btn_backward;
    @FXML
    private Text usernameText;
    public String username;

    public Text getUsername(){
        return this.usernameText;
    }
    public void changePassword(){
        try{
            Index.changePassword(username, "Stu");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showData(){
        try{
            Index.showData(username);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void backward(){
        try {
            Index.initMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
