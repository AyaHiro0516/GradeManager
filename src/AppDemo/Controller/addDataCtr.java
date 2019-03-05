package AppDemo.Controller;

import AppDemo.Index;
import AppDemo.StuDao;
import User_related.Score;
import User_related.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class addDataCtr {
    @FXML
    private Button Btn_submit;
    @FXML
    private Text statusText;
    @FXML
    private Button Btn_backward;
    @FXML
    private TextField userNameText;
    @FXML
    private TextField userIdText;
    @FXML
    private TextField mathText;
    @FXML
    private TextField engText;
    @FXML
    private TextField cplusText;
    @FXML
    private TextField PEText;

    public void submition(){
        String userName=userNameText.getText();
        String userId=userIdText.getText();
        String math=mathText.getText();
        String eng=engText.getText();
        String cplus=cplusText.getText();
        String PE=PEText.getText();

        if(userName.equals("") || userId.equals("") || mathText.getText().equals("") ||
                eng.equals("") || cplus.equals("") || PE.equals("")){
            statusText.setText("有信息未填写！");
        }else if (!Index.mp.containsKey(userName)) {
            try{
                Score score=new Score(new Double(math), new Double(eng), new Double(cplus), new Double(PE));
                User u=new User();
                u.setScore(score);
                u.setName(userName);
                u.setId(userId);
                Index.mp.put(userName, u);
                Index.upData();
                StuDao.addStuData(userId,userName,new Double(math),new Double(eng),new Double(cplus),new Double(PE));
                userNameText.clear();
                userIdText.clear();
                mathText.clear();
                engText.clear();
                cplusText.clear();
                PEText.clear();
                statusText.setText("第"+User.getCurrentID()+"位学生信息添加成功！");
                }catch (NumberFormatException e){
                    statusText.setText("成绩必须是数字！");
                    //e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
        }else {
            statusText.setText("该学生已存在！");
        }
    }
    public void clear(){
        statusText.setText("");
    }
    public void backward(){
        try {
            Index.showMangerMenu();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
