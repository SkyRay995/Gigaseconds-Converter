import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button01;
    JButton buttonRevCalc;
    JButton buttonRefresh;
    JLabel labelYears;
    JLabel labelMonths;
    JLabel labelDays;
    JLabel labelHours;
    JLabel labelMinutes;
    JLabel labelSeconds;
    JLabel labelResult;
    JLabel textFieldPwr;
    JLabel toSeconds; JLabel fromSeconds;
    String[] prefixes = {"Seconds","decaSeconds (10^1)","hectoSeconds (10^2)", "kiloSeconds (10^3)", "megaSeconds (10^6)", "gigaSeconds (10^9)", "teraSeconds (10^12)", "petaSeconds (10^15)", "exaSeconds (10^18)"};
    JComboBox comboBoxPrefixes;
    JTextField result;
    JTextField textFieldYears;
    JTextField textFieldMonths;
    JTextField textFieldDays;
    JTextField textFieldHours;
    JTextField textFieldMinutes;
    JTextField textFieldSeconds;

    static double frameRevSeconds = 0;
    static long frameRevSecondsAbsolute = 0;
    static long frameMonths = 0;
    static long frameYears = 0;
    static long frameDays = 0;
    static int frameHours = 0;
    static int frameMinutes = 0;
    static int frameSeconds = 0;
    Border border = BorderFactory.createLineBorder(Color.black, 1, true);

    MyFrame(){

        this.setTitle("Gigaseconds converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 480);
        this.setLayout(null);
        this.setResizable(false);

        labelYears = new JLabel("Years");
        labelYears.setBounds(20, 0, 60,20);
        textFieldYears = new JTextField();
        textFieldYears.setText("0");
        textFieldYears.setBorder(border);
        textFieldYears.setBounds(20, 20, 100, 40);
        this.add(labelYears);
        this.add(textFieldYears);

        labelMonths = new JLabel("Months");
        labelMonths.setBounds(20,70,60,20);
        textFieldMonths = new JTextField();
        textFieldMonths.setText("0");
        textFieldMonths.setBorder(border);
        textFieldMonths.setBounds(20,90,100,40);
        this.add(labelMonths);
        this.add(textFieldMonths);

        labelDays = new JLabel("Days");
        labelDays.setBounds(20,140,60,20);
        textFieldDays = new JTextField();
        textFieldDays.setText("0");
        textFieldDays.setBorder(border);
        textFieldDays.setBounds(20, 160, 100, 40);
        this.add(labelDays);
        this.add(textFieldDays);

        labelHours = new JLabel("Hours");
        labelHours.setBounds(20,210,60,20);
        textFieldHours = new JTextField();
        textFieldHours.setText("0");
        textFieldHours.setBorder(border);
        textFieldHours.setBounds(20, 230, 100, 40);
        this.add(labelHours);
        this.add(textFieldHours);

        labelMinutes = new JLabel("Minutes");
        labelMinutes.setBounds(20,280,60,20);
        textFieldMinutes = new JTextField();
        textFieldMinutes.setText("0");
        textFieldMinutes.setBorder(border);
        textFieldMinutes.setBounds(20, 300, 100, 40);
        this.add(labelMinutes);
        this.add(textFieldMinutes);

        labelSeconds = new JLabel("Seconds");
        labelSeconds.setBounds(20,360,60,20);
        textFieldSeconds = new JTextField();
        textFieldSeconds.setText("0");
        textFieldSeconds.setBorder(border);
        textFieldSeconds.setOpaque(true);
        textFieldSeconds.setBounds(20, 380, 100, 40);
        this.add(labelSeconds);
        this.add(textFieldSeconds);

        labelResult = new JLabel("Result");
        labelResult.setBounds(150,140,60,20);
        result = new JTextField(Long.toString(frameDays));              //Assign any number/text
        result.setBorder(border);
        result.setBounds(150, 160, 160, 40);
        textFieldPwr = new JLabel();
        textFieldPwr.setBounds(150,200,160,20);
        comboBoxPrefixes = new JComboBox(prefixes);
        comboBoxPrefixes.addActionListener(this);
        comboBoxPrefixes.setBounds(150,200,160,20);
        //this.add(textFieldPwr);
        this.add(comboBoxPrefixes);
        this.add(labelResult);
        this.add(result);

        button01 = new JButton("Calculate");
        button01.addActionListener(this);
        button01.setBorder(border);
        button01.setBounds(150, 20, 70, 70);
        this.add(button01);

        toSeconds = new JLabel("To seconds");
        toSeconds.setBounds(152, 90, 80,20);
        this.add(toSeconds);

        buttonRefresh = new JButton("Refresh");
        buttonRefresh.addActionListener(this);
        buttonRefresh.setBorder(border);
        buttonRefresh.setBounds(195, 230, 70, 40);
        this.add(buttonRefresh);

        buttonRevCalc = new JButton("Calculate");
        buttonRevCalc.addActionListener(this);
        buttonRevCalc.setBorder(border);
        buttonRevCalc.setBounds(240, 20, 70, 70);
        this.add(buttonRevCalc);

        fromSeconds = new JLabel("From seconds");
        fromSeconds.setBounds(235, 90, 100,20);
        this.add(fromSeconds);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button01){
            frameYears = Long.parseLong(textFieldYears.getText());
            frameMonths = Long.parseLong(textFieldMonths.getText());
            frameDays = Long.parseLong(textFieldDays.getText());
            frameHours = Integer.parseInt(textFieldHours.getText());
            frameMinutes = Integer.parseInt(textFieldMinutes.getText());
            frameSeconds = Integer.parseInt(textFieldSeconds.getText());
            //result.setText(Long.toString(Calculator.calculate(frameYears,frameMonths,frameDays,frameHours,frameMinutes,frameSeconds)));
            result.setText(Calculator.calculate(frameYears,frameMonths,frameDays,frameHours,frameMinutes,frameSeconds));
            //textFieldPwr.setText(Calculator.power + "Seconds");
            comboBoxPrefixes.setSelectedItem(Calculator.power);
        }
        if(e.getSource() == buttonRefresh){
            textFieldYears.setText("0");
            textFieldMonths.setText("0");
            textFieldDays.setText("0");
            textFieldHours.setText("0");
            textFieldMinutes.setText("0");
            textFieldSeconds.setText("0");
            result.setText("0");
            comboBoxPrefixes.setSelectedItem("Seconds");
        }
        if(e.getSource() == buttonRevCalc){
            System.out.println("--------Starting new reverse calculation--------");
            frameRevSeconds = Double.parseDouble((result.getText()).replace(',','.'));
            switch (comboBoxPrefixes.getSelectedIndex()){
                case 0:
                    frameRevSecondsAbsolute = (long)frameRevSeconds;
                    break;
                case 1:
                    frameRevSecondsAbsolute = (long)frameRevSeconds*10;
                    break;
                case 2:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,2));
                    break;
                case 3:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,3));
                    break;
                case 4:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,6));
                    break;
                case 5:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,9));
                    break;
                case 6:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,12));
                    break;
                case 7:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,15));
                    break;
                case 8:
                    frameRevSecondsAbsolute = (long)(frameRevSeconds*Math.pow(10,18));
                    break;
            }
            System.out.println("FrameRevSecs = " + frameRevSecondsAbsolute);
            textFieldYears.setText(Long.toString(Calculator.revCalcYears(frameRevSecondsAbsolute)));
            textFieldMonths.setText(Long.toString(Calculator.revCalcMonths(frameRevSecondsAbsolute)));
            textFieldDays.setText(Long.toString(Calculator.revCalcDays(frameRevSecondsAbsolute)));
            textFieldHours.setText(Long.toString(Calculator.revCalcHours(frameRevSecondsAbsolute)));
            textFieldMinutes.setText(Long.toString(Calculator.revCalcMinutes(frameRevSecondsAbsolute)));
            textFieldSeconds.setText(Long.toString(Calculator.revCalcSeconds(frameRevSecondsAbsolute)));
        }
        if(e.getSource() == comboBoxPrefixes){

        }
    }
}
