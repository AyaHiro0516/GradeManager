package AppDemo.Controller;

import AppDemo.Index;
import AppDemo.StuDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.IOException;

public class changePasswordCtr {
    @FXML
    private Button Btn_submit;
    @FXML
    private Button Btn_backward;
    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private Text statusText;

    public String username;
    public String lastPage="null";
    public void submition(){
        String oldW=oldPassword.getText();
        String newW=newPassword.getText();
        if (!oldW.equals("") && !newW.equals("")){
            if (oldW.equals(newW)){
                Index.mp.get(username).setPassWord(newW);
            try{
                Index.upData();
                StuDao.changeStuPassword(username,newW);
            }catch (Exception e){
                e.printStackTrace();
            }
                statusText.setText("修改成功！");
            }else {
                statusText.setText("两次输入密码不同，请重试。");
            }
        }else {
            statusText.setText("密码不能为空！");
        }
    }
    public void backward(){
        try{
            if (lastPage.equals("Stu")){
                Index.showStuMenu(username);
            }else{
                Index.searchData(username);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
