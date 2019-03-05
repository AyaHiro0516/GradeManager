package AppDemo.Controller;

import AppDemo.Index;
import AppDemo.StuDao;
import User_related.Score;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class changeDataCtr {
    @FXML
    public TextField userIdText;
    @FXML
    public TextField mathText;
    @FXML
    public TextField engText;
    @FXML
    public TextField cplusText;
    @FXML
    public TextField PEText;
    @FXML
    private Text statusText;
    @FXML
    private Button Btn_submit;
    @FXML
    private Button Btn_backward;
    public String username;

    public void submition(){
        String userId=userIdText.getText();
        String math=mathText.getText();
        String eng=engText.getText();
        String cplus=cplusText.getText();
        String PE=PEText.getText();
        if (userId.equals("") || math.equals("") || eng.equals("") || cplus.equals("") || PE.equals("")){
            statusText.setText("有信息未填写！");
        }else {
            try{
                Score score=new Score(new Double(math), new Double(eng), new Double(cplus), new Double(PE));
                Index.mp.get(username).setScore(score);
                Index.mp.get(username).setId(userId);
                Index.upData();
                StuDao.changeStuData(username,userId,new Double(math),new Double(eng),new Double(cplus),new Double(PE));
                statusText.setText("修改成功！");
            }catch (NumberFormatException e){
                statusText.setText("成绩必须是数字！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void backward(){
        try{
            Index.searchData(username);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
