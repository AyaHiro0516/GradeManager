package AppDemo.Controller;

import AppDemo.Index;
import AppDemo.StuDao;
import User_related.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class searchDataCtr {
    @FXML
    private Button Btn_changePassword;
    @FXML
    private Button Btn_changeData;
    @FXML
    private Button Btn_backward;
    @FXML
    private Text usernameText;
    @FXML
    private Text statusText;

    public String username;
    public Text getUsernameText(){
        return usernameText;
    }
    public void changePassword(){
        try{
            Index.changePassword(username, "Manger");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void changeData(){
        try {
            Index.changeData(username);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void delete(){
        if(Index.mp.containsKey(username)){
            Index.mp.remove(username);
            User.cutCurrentID();  //学生总数要减少一个
            try{
                Index.upData();
                StuDao.deleteStuData(username);
            }catch (Exception e){
                e.printStackTrace();
            }
            statusText.setText("删除成功！");
            Btn_changePassword.setVisible(false);
            Btn_changeData.setVisible(false);
        }else {
            statusText.setText("删过一次了，鞭尸？");
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
