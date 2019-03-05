package Menu_related;

import User_related.Score;
import User_related.User;

import java.io.*;
import java.util.*;

public class Menu_main {
    public static TreeMap<String,User> mp=null;
    public static void build() throws Exception{
        Scanner fin=new Scanner(new File("F:/test/cd/data.txt"));
        String id, name, password;
        double m, e, c, p;
        while (fin.hasNext())
        {
            name=fin.next(); id=fin.next(); password=fin.next();
            m=fin.nextDouble(); e=fin.nextDouble(); c=fin.nextDouble();  p=fin.nextDouble();
            Score s=new Score(m, e, c, p);
            mp.put(name, new User(name, id, password, s));
        }
    }
    public static void upData() throws Exception{
            Writer w=null;
            BufferedWriter bw=null;
            try{
                w=new FileWriter("F:/test/cd/data.txt");
                bw=new BufferedWriter(w);
                Collection<User> users=Menu_main.mp.values();
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
    public static void printData() throws Exception{
        Writer w=null;
        BufferedWriter bw=null;
        try{
            w=new FileWriter("F:/test/cd/data2.txt");
            bw=new BufferedWriter(w);
            bw.write("共有"+User.getCurrentID()+"名学生，信息如下:");
            bw.newLine();
            Collection<User> users=Menu_main.mp.values();
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
    public static void main(String[] args)throws Exception {
        Scanner in=new Scanner(System.in);
        mp=new TreeMap<>();

        build();
        System.out.println("欢迎使用期末成绩管理系统~");
        while (true)
        {
            System.out.println("\t\t\t\t请选择进入的模式:\n");
            System.out.println("\t\t╔*☆***◎***◇***☆*** 菜单 ***☆***◇***◎***☆*╗");
            System.out.println("\t\t|☆|\t\t                            \t\t|☆|");
            System.out.println("\t\t|★|\t\t     A.进入管理员模式          \t\t|★|");
            System.out.println("\t\t|☆|\t\t     B.进入学生登录窗口        \t\t|☆|");
            System.out.println("\t\t|★|\t\t     Q.退出程序               \t\t|★|");
            System.out.println("\t\t|☆|\t\t                            \t\t|☆|");
            System.out.println("\t\t╚*☆***◎***◇****☆****★****☆****◇***◎***☆*╝\n");
            String mode=in.next();
            switch (mode)
            {
                case"A":
                    new Menu_Manager().menu();
                    break;
                case"B":
                    new Menu_Student().menu();
                    break;
                case"Q":
                    System.out.println("谢谢使用！欢迎常来~");
                    return;
                default:
                    System.out.println("选择有错，请重新选择");
            }
        }
    }

}
