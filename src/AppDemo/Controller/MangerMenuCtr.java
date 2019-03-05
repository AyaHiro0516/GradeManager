package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MangerMenuCtr {
    @FXML
    private Button Btn_addData;
    @FXML
    private Button Btn_searchData;
    @FXML
    private Button Btn_printData;
    @FXML
    private Button Btn_backward;
    @FXML
    private TextField usernameText;
    public void addData(){
        try{
            Index.addData();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void searchData(){
        String username=usernameText.getText();
        if (username.equals("")){
            //空语句
        }else if (Index.mp.containsKey(username)){
            try{
                Index.searchData(username);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            usernameText.setText("无该学生信息");
        }
    }
    public void printData(){
        try{
            Index.printData();
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
