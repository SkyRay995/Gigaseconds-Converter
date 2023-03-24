import javax.swing.*;

public class Main {
    public static void main(String[] args){
        new MyFrame();
        System.out.println(Calculator.calculate(MyFrame.frameYears,MyFrame.frameMonths,MyFrame.frameDays,MyFrame.frameHours,MyFrame.frameMinutes,MyFrame.frameSeconds) + " " +  Calculator.power + "Seconds");
    }
}
