package AppDemo;

import AppDemo.Controller.StuMenuCtr;
import User_related.Score;
import User_related.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeMap;

public class Index extends Application{
    public static TreeMap<String,User> mp=null;
    public static void build() throws Exception{
        if (dataFile!=null){
            Scanner fin=new Scanner(dataFile);
            String id, name, password;
            double m, e, c, p;
            while (fin.hasNext())
            {
                name=fin.next(); id=fin.next(); password=fin.next();
                m=fin.nextDouble(); e=fin.nextDouble(); c=fin.nextDouble();  p=fin.nextDouble();
                Score s=new Score(m, e, c, p);
                mp.put(name, new User(name, id, password, s));
            }
        }else {
            User.setCurrentID(0);
            mp.clear();
        }
    }
    public static void upData() throws Exception{
        Writer w=null;
        BufferedWriter bw=null;
        try{
            w=new FileWriter(dataFile.toString());
            bw=new BufferedWriter(w);
            Collection<User> users= Index.mp.values();
            for (User u:users){
                bw.write(u.toString());
                bw.newLine();
            }
            bw.flush();
        }catch (IOException E){
            E.printStackTrace();
        }finally {
            try {
                bw.close();
                w.close();
            } catch (IOException E) {
                E.printStackTrace();
            }
        }
    }
    public static void printAllData() throws Exception{
        Writer w=null;
        BufferedWriter bw=null;
        try{
            w=new FileWriter(showDataFile.toString());
            bw=new BufferedWriter(w);
            bw.write("共有"+User.getCurrentID()+"名学生，信息如下:");
            bw.newLine();
            Collection<User> users= Index.mp.values();
            for (User u:users){
                bw.write("姓名："+u.getName());
                bw.newLine();
                bw.write("编号："+u.getId());
                bw.newLine();
                bw.write("数学："+u.getScore().getMath());
                bw.newLine();
                bw.write("英语："+u.getScore().getEng());
                bw.newLine();
                bw.write("C++："+u.getScore().getCplus());
                bw.newLine();
                bw.write("体育："+u.getScore().getPE());
                bw.newLine();
                bw.write("---------------------");
                bw.newLine();
            }
            bw.flush();
        }catch (IOException E){
            E.printStackTrace();
        }finally {
            try {
                bw.close();
                w.close();
            } catch (IOException E) {
                E.printStackTrace();
            }
        }
    }

    private static Stage stage;
    public static File dataFile=null;
    public static File showDataFile=null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        initMain();
    }

    public static void main(String[] args) throws Exception {
        mp=new TreeMap<>();
        launch(args);
    }
    //初始化选择界面
    public static void initMain() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/Main.fxml"));
        AnchorPane Panel=loader.load();

        AppDemo.Controller.IndexCtr controller=loader.getController();
        TextField textField=controller.getShowFileText();
        if (dataFile!=null){
            textField.setText(dataFile.toString());
        }else {
            textField.setText("您未选择数据文件(txt)");
        }

        Scene scene=new Scene(Panel);
        stage.setTitle("期末成绩管理程序");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //展示管理员菜单
    public static void showMangerMenu() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/MangerMenu.fxml"));
        AnchorPane Panel=loader.load();

        Scene scene=new Scene(Panel);
        stage.setTitle("管理员模式");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //展示学生操作菜单
    public static void showStuMenu(String name)throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/StuMenu.fxml"));
        AnchorPane Panel=loader.load();

        StuMenuCtr controller=loader.getController();
        Text text=controller.getUsername();
        controller.username=name;

        text.setText(name);
        Scene scene=new Scene(Panel);
        stage.setTitle("学生操作模式");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //修改学生密码界面
    public static void changePassword(String username, String lastPage)throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/changePassword.fxml"));
        AnchorPane Panel=loader.load();

        AppDemo.Controller.changePasswordCtr controller=loader.getController();
        controller.username=username;
        controller.lastPage=lastPage;

        Scene scene=new Scene(Panel);
        stage.setTitle("修改密码");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //展示学生成绩页面
    public static void showData(String username)throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/showData.fxml"));
        AnchorPane Panel=loader.load();

        AppDemo.Controller.showDataCtr controller=loader.getController();
        Text mathText=controller.getMath();
        mathText.setText(Index.mp.get(username).getScore().getMath()+"");
        Text engText=controller.getEng();
        engText.setText(Index.mp.get(username).getScore().getEng()+"");
        Text cplusText=controller.getCplus();
        cplusText.setText(Index.mp.get(username).getScore().getCplus()+"");
        Text PEText=controller.getPE();
        PEText.setText(Index.mp.get(username).getScore().getPE()+"");
        Text usernameText=controller.getUsernameText();
        usernameText.setText(username);
        controller.username=username;

        Scene scene=new Scene(Panel);
        stage.setTitle("查看成绩");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //展示全部学生信息界面
    public static void printData()throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/printData.fxml"));
        AnchorPane Panel=loader.load();

        AppDemo.Controller.printDataCtr controller =loader.getController();
        TextArea textArea=controller.getDataArea();
        textArea.appendText("共有"+ User.getCurrentID()+"名学生，信息如下:\n");
        Collection<User> users= Index.mp.values();
        for (User u:users){
            textArea.appendText("姓名："+u.getName()+"\n");
            textArea.appendText("编号："+u.getId()+"\n");
            textArea.appendText("数学："+u.getScore().getMath()+"\n");
            textArea.appendText("英语："+u.getScore().getEng()+"\n");
            textArea.appendText("C++："+u.getScore().getCplus()+"\n");
            textArea.appendText("体育："+u.getScore().getPE()+"\n");
            textArea.appendText("---------------------\n");
        }
        textArea.appendText("输出完毕");
        TextField textField=controller.getShowFileText();
        if (showDataFile!=null){
            textField.setText(showDataFile.toString());
        }else {
            textField.setText("您未选择输出文件(txt)");
        }

        Scene scene=new Scene(Panel);
        stage.setTitle("全部学生成绩信息");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //添加学生信息页面
    public static void addData()throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/addData.fxml"));
        AnchorPane Panel=loader.load();

        Scene scene=new Scene(Panel);
        stage.setTitle("添加学生信息");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //管理员修改学生信息页面
    public static void searchData(String username)throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/searchData.fxml"));
        AnchorPane Panel=loader.load();

        AppDemo.Controller.searchDataCtr controller=loader.getController();
        Text text=controller.getUsernameText();
        text.setText(username);
        controller.username=username;

        Scene scene=new Scene(Panel);
        stage.setTitle("修改学生信息");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
    //修改学生信息页面
    public static void changeData(String username)throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Index.class.getResource("Fxml/changeData.fxml"));
        AnchorPane Panel=loader.load();

        AppDemo.Controller.changeDataCtr controller=loader.getController();
        controller.username=username;
        controller.userIdText.setText(Index.mp.get(username).getId());
        controller.mathText.setText(Index.mp.get(username).getScore().getMath()+"");
        controller.engText.setText(Index.mp.get(username).getScore().getEng()+"");
        controller.cplusText.setText(Index.mp.get(username).getScore().getCplus()+"");
        controller.PEText.setText(Index.mp.get(username).getScore().getPE()+"");

        Scene scene=new Scene(Panel);
        stage.setTitle("修改学生成绩/编号");
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }
}
