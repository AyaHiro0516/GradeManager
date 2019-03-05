package AppDemo.Controller;

import AppDemo.Index;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class IndexCtr {
    @FXML
    private Button Btn_mangerLogin;
    @FXML
    private Button Btn_stuLogin;
    @FXML
    private Button Btn_choose;
    @FXML
    private Button Btn_exit;
    @FXML
    private TextField showFileText;
    @FXML
    private Text statusText;

    public TextField getShowFileText(){
        return showFileText;
    }
    public void mangerLogin(){
        if (Index.dataFile!=null){
            try {
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(Index.class.getResource("Fxml/MangerLogin.fxml"));
                AnchorPane Panel=loader.load();

                Scene scene=new Scene(Panel);
                Stage stage=new Stage();
                stage.setTitle("管理员登录");
                stage.setScene(scene);
                stage.resizableProperty().setValue(false);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            statusText.setText("您未选择数据文件！");
        }

    }
    public void stuLogin(){
        if(Index.dataFile!=null){
            try {
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(Index.class.getResource("Fxml/StuLogin.fxml"));
                AnchorPane Panel=loader.load();

                Scene scene=new Scene(Panel);
                Stage stage=new Stage();
                stage.setTitle("学生登录");
                stage.setScene(scene);
                stage.resizableProperty().setValue(false);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            statusText.setText("您未选择数据文件！");
        }

    }
    public void chooseFile(){
        statusText.setText("");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择数据文件");
        Stage stage=(Stage)Btn_choose.getScene().getWindow();
        File targetFile=fileChooser.showOpenDialog(stage);
        if (targetFile!=null){
            Index.dataFile=targetFile;
            showFileText.setText(Index.dataFile.toString());
        }else {
            Index.dataFile=null;
            showFileText.setText("您未选择数据文件！");
        }
        try {
            Index.build();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void exitWarning(){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Index.class.getResource("Fxml/exitWarning.fxml"));
            AnchorPane Panel=loader.load();

            Scene scene=new Scene(Panel);
            Stage stage=new Stage();
            stage.setTitle("温馨提示");
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
