package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


import java.io.IOException;

public class showDataCtr {
    @FXML
    private Button Btn_backward;
    @FXML
    private Text math;
    @FXML
    private Text eng;
    @FXML
    private Text cplus;
    @FXML
    private Text PE;
    @FXML
    private Text usernameText;
    public String username;

    public Text getMath() {
        return math;
    }
    public Text getEng() {
        return eng;
    }
    public Text getCplus() {
        return cplus;
    }
    public Text getPE() {
        return PE;
    }
    public Text getUsernameText() {
        return usernameText;
    }
    public void backward(){
        try {
            Index.showStuMenu(username);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
