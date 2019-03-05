package User_related;


import java.util.Scanner;

public class User {
    private static int CurrentID;
    private String id;
    private String name;
    private String passWord;
    private Score score;

    public static Scanner in=new Scanner(System.in);
    public User() {
        this.passWord="111111";
        CurrentID++;
    }

    public User(String name, String id, String passWord, Score score) {
        CurrentID++;
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.score = score;
    }

    public static int getCurrentID() {
        return CurrentID;
    }
    public static void cutCurrentID(){
        CurrentID--;
    }
    public static void setCurrentID(int currentID) {
        CurrentID = currentID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String newPassword){
        this.passWord=newPassword;
    }
    public boolean setPassWord() {
        String s, rs;
        System.out.println("请输入新的密码");
        s=in.next();
        System.out.println("请再次输入密码");
        rs=in.next();
        if (s.equals(rs)){
            this.passWord=s;
            System.out.println("修改成功！");
            return true;
        }
        else{
            System.out.println("两次密码不同，修改失败！");
            return false;
        }
    }
    public boolean checkPassWord(){
        System.out.println("密码输入错误，请再次输入");
        boolean isTrue=false;
        for (int i=2; i>=0; --i){
            if(!in.next().equals(this.passWord)){
                if (i==0)
                    break;
                System.out.println("输入错误，你还有"+i+"次机会");
            }
            else{
                isTrue=true;
                break;
            }
        }
        if (!isTrue)
            System.out.println("抱歉，请稍后再试");
        return isTrue;
    }
    public void setData(String name){
        this.name=name;
        System.out.println("请输入学号");
        this.id=in.next();
        Score newScore=new Score();
        newScore.setData();
        this.score=newScore;
    }
    public void showData(){
        System.out.println("姓名："+this.name);
        System.out.println("编号："+this.id);
        score.showData();
    }

    public void changScore(){
        while (true)
        {
            System.out.println("\t\t\t\t 您想修改啥？\n");
            System.out.println("\t\t╔*☆***◎***◇***☆*** 菜单 ***☆***◇***◎***☆*╗");
            System.out.println("\t\t|☆|\t\t                             \t\t|☆|");
            System.out.println("\t\t|★|\t\t      1: 数学                 \t\t|★|");
            System.out.println("\t\t|☆|\t\t      2: 英语                 \t\t|☆|");
            System.out.println("\t\t|★|\t\t      3: C++                 \t\t|★|");
            System.out.println("\t\t|☆|\t\t      4: 体育                 \t\t|☆|");
            System.out.println("\t\t|★|\t\t      Q: 返回上一级菜单        \t\t|★|");
            System.out.println("\t\t|☆|\t\t                             \t\t|☆|");
            System.out.println("\t\t╚*☆***◎***◇****☆****★****☆****◇***◎***☆*╝");
            String command=in.next();
            switch (command)
            {
                case"1":
                    System.out.println("请输入新的成绩: ");
                    score.setMath(in.nextDouble());
                    System.out.println("修改成功！");
                    try{
                        new Thread().sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case"2":
                    System.out.println("请输入新的成绩: ");
                    score.setEng(in.nextDouble());
                    System.out.println("修改成功！");
                    try{
                        new Thread().sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case"3":
                    System.out.println("请输入新的成绩: ");
                    score.setCplus(in.nextDouble());
                    System.out.println("修改成功！");
                    try{
                        new Thread().sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case"4":
                    System.out.println("请输入新的成绩: ");
                    score.setPE(in.nextDouble());
                    System.out.println("修改成功！");
                    try{
                        new Thread().sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case"Q":
                    System.out.println("载入中...");
                    try{
                        new Thread().sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return;
                default:
                    System.out.println("选择错误，请输入正确的指令！");
                    try{
                        new Thread().sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            }
        }
    }
    @Override
    public String toString() {
        return name+"    "+id+"    "+passWord+"    "+score.toString();
    }

}
