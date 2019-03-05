package Menu_related;

import java.util.Scanner;

public class Menu_Student {
    public void menu() {
        Scanner in=new Scanner(System.in);
        if (Menu_main.mp.isEmpty())
        {
            System.out.println("抱歉，没有学生信息，请先录入信息~");
            try{
                new Thread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        while (true)
        {
            System.out.println("小老板你好，请先登录----按Q返回选择端口");
            String name, password;
            System.out.println("请输入姓名："); name=in.next();
            if (name.equals("Q"))
                break;
            System.out.println("请输入密码："); password=in.next();
            boolean isTrue=true;
            if (!Menu_main.mp.containsKey(name))
            {
                System.out.println("抱歉，无该学生信息");
                try{
                    new Thread().sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                isTrue=false;
            }
            else if (Menu_main.mp.containsKey(name) && !Menu_main.mp.get(name).getPassWord().equals(password))
                isTrue=Menu_main.mp.get(name).checkPassWord();
            if (isTrue)
            {
                while (true)
                {
                    System.out.println("\t\t\t\t欢迎"+name+"老板，您想干啥？");
                    System.out.println("\t\t╔*☆***◎***◇***☆*** 菜单 ***☆***◇***◎***☆*╗");
                    System.out.println("\t\t|☆|\t\t                            \t\t|☆|");
                    System.out.println("\t\t|★|\t\t     1.修改密码               \t\t|★|");
                    System.out.println("\t\t|☆|\t\t     2.显示成绩单             \t\t|☆|");
                    System.out.println("\t\t|★|\t\t     Q.返回登录页面            \t\t|★|");
                    System.out.println("\t\t|☆|\t\t                            \t\t|☆|");
                    System.out.println("\t\t╚*☆***◎***◇****☆****★****☆****◇***◎***☆*╝\n");
                    String command=in.next();
                    switch (command)
                    {
                        case"1":
                            if (Menu_main.mp.get(name).setPassWord())
                                try{
                                    Menu_main.upData();;
                                }catch (Exception e){
                                e.printStackTrace();
                                }
                            try{
                                new Thread().sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            break;
                        case"2":
                            Menu_main.mp.get(name).showData();
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
                }//while2
            }//if
            else
                System.out.println("请稍后再试！");
            try{
                new Thread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        try{
            new Thread().sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        return;
    }
}
