package User_related;

import javafx.scene.control.PasswordField;

import java.util.Scanner;

public class Score {
    private double math;
    private double eng;
    private double cplus;
    private double PE;
    public static Scanner in=new Scanner(System.in);
    public Score() {
    }

    public Score(double math, double eng, double cplus, double PE) {
        this.math = math;
        this.eng = eng;
        this.cplus = cplus;
        this.PE = PE;
    }

    public double getMath() {
        return math;
    }

    public double getEng() {
        return eng;
    }

    public double getCplus() {
        return cplus;
    }

    public double getPE() {
        return PE;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public void setEng(double eng) {
        this.eng = eng;
    }

    public void setCplus(double cplus) {
        this.cplus = cplus;
    }

    public void setPE(double PE) {
        this.PE = PE;
    }

    public void setData(){
        System.out.println("请输入数学成绩:");
        this.math=in.nextDouble();
        System.out.println("请输入英语成绩:");
        this.eng=in.nextDouble();
        System.out.println("请输入C++成绩:");
        this.cplus=in.nextDouble();
        System.out.println("请输入体育成绩:");
        this.PE=in.nextDouble();
    }

    public void showData(){
        System.out.println("数学："+this.math);
        System.out.println("英语："+this.eng);
        System.out.println("C++："+this.cplus);
        System.out.println("体育："+this.PE);
    }
    @Override
    public String toString() {
        return math+"    "+eng+"    "+cplus+"    "+PE;
    }
}
