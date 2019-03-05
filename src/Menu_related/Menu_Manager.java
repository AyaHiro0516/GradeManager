package Menu_related;

import User_related.User;

import java.util.Collection;
import java.util.Scanner;

public class Menu_Manager {
    public static Scanner in=new Scanner(System.in);
    public void menu() {
        System.out.println("请输入管理员密码: (bxy0516)<-(划掉)");
        String password=in.next();
        if (!password.equals("bxy0516"))
        {
            System.out.println("你是什么人！想篡改学生信息？不存在的！");
            try{
                new Thread().sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        while (true)
        {
            System.out.println("\t\t\t\t 欢迎大老板，您想干啥？\n");
            System.out.println("\t\t╔*☆***◎***◇***☆*** 菜单 ***☆***◇***◎***☆*╗");
            System.out.println("\t\t|☆|\t\t                             \t\t|☆|");
            System.out.println("\t\t|★|\t\t       1: 录入学生信息         \t\t|★|");
            System.out.println("\t\t|☆|\t\t       2: 查询学生	        \t\t|☆|");
            System.out.println("\t\t|★|\t\t       3: 输出全部信息         \t\t|★|");
            System.out.println("\t\t|☆|\t\t       Q: 返回选择端口         \t\t|☆|");
            System.out.println("\t\t|★|\t\t                             \t\t|★|");
            System.out.println("\t\t╚*☆***◎***◇****☆****★****☆****◇***◎***☆*╝");
            String command=in.next();
            switch (command)
            {
                case"1":
                    entryInformation();
                    break;
                case"2":
                    searchInformation();
                    break;
                case"3":
                    outPutInformation();
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

    public static void entryInformation() {
        System.out.println("请录入学生信息，已姓名为null结束，学生初始密码为“111111”");
        while (true)
        {
            System.out.println("请输入第"+(User.getCurrentID()+1)+"位学生姓名:");
            String name=in.next();
            if (name.equals("null"))
                break;
            if (!Menu_main.mp.containsKey(name))
            {
                User u=new User();
                u.setData(name);
                Menu_main.mp.put(name,u);
            }
            else
            {
                System.out.println("该学生已存在！");
                try{
                    new Thread().sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        try {
            Menu_main.upData();
            System.out.println("载入中");
            new Thread().sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void searchInformation() {
        if (Menu_main.mp.isEmpty())
        {
            System.out.println("抱歉！没有学生信息，请先录入信息~");
            try{
                new Thread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        System.out.println("请输入学生的姓名");
        String name=in.next();
        if (Menu_main.mp.containsKey(name))
        {
            while (true)
            {
                System.out.println("\t\t\t\t 您想干啥？\n");
                System.out.println("\t\t╔*☆***◎***◇***☆*** 菜单 ***☆***◇***◎***☆*╗");
                System.out.println("\t\t|☆|\t\t                             \t\t|☆|");
                System.out.println("\t\t|★|\t\t     1: 修改学生成绩           \t\t|★|");
                System.out.println("\t\t|☆|\t\t     2: 修改学生密码           \t\t|☆|");
                System.out.println("\t\t|★|\t\t     3: 删除该学生信息         \t\t|★|");
                System.out.println("\t\t|☆|\t\t     Q: 返回上一级菜单         \t\t|☆|");
                System.out.println("\t\t|★|\t\t                             \t\t|★|");
                System.out.println("\t\t╚*☆***◎***◇****☆****★****☆****◇***◎***☆*╝\n");
                String command=in.next();
                switch (command)
                {
                    case"1":
                        if (Menu_main.mp.containsKey(name))
                        {
                            Menu_main.mp.get(name).changScore();
                            try {
                                Menu_main.upData();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            System.out.println("抱歉，无该学生信息！");
                            try{
                                new Thread().sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    case"2":
                        if (Menu_main.mp.containsKey(name))
                        {
                            Menu_main.mp.get(name).setPassWord();
                            try{
                                Menu_main.upData();
                                new Thread().sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            System.out.println("抱歉，无该学生信息！");
                            try{
                                new Thread().sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    case"3":
                        if (Menu_main.mp.containsKey(name))
                        {
                            Menu_main.mp.remove(name);
                            User.cutCurrentID();
                            System.out.println("删除成功！");
                            try{
                                Menu_main.upData();
                                new Thread().sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            System.out.println("你已经删过一次了，还想删？");
                            try{
                                new Thread().sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
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
        else
        {
            System.out.println("抱歉，无该学生信息");
            try{
                new Thread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void outPutInformation() {
        if (Menu_main.mp.isEmpty())
        {
            System.out.println("抱歉！没有学生信息，请先录入信息~");
            try{
                new Thread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        System.out.println("共有"+User.getCurrentID()+"名学生，信息如下: \n");
        Collection<User> users=Menu_main.mp.values();
        for (User u:users){
            u.showData();
            System.out.println("---------------------");
        }
        System.out.println("输出完毕");
        try{
            new Thread().sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("检查无误，是否需要打印？（输入“Y”确认或任意字符退出）");
        String op=in.next();
        if (op.equals("Y"))
        {
            try {
                Menu_main.printData();
                Menu_main.upData();
                System.out.println("打印成功！");
                new Thread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
