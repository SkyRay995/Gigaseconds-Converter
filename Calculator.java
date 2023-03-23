public class Calculator {
    //static double result = 0;
    static long result = 0;
    static String power = "";

    public static long revCalcYears(long calcSeconds){
        System.out.println("Years = (" + calcSeconds + "/60/60/24/365 = " + calcSeconds/60/60/24/365);
        return calcSeconds/60/60/24/365;
    }
    public static long revCalcMonths(long calcSeconds){
        if(calcSeconds/60/60/24%365 > 359 && calcSeconds/60/60/24 < 365){
            System.out.println("Months 'IF' number one, returning 11");
            return 11;
        }
        if(calcSeconds/60/60/24 > 364){
            System.out.println("Months 'IF' number two");
            return calcSeconds/60/60/24%365/30;
        }
        System.out.println("Months 'IF' number tree. Months = (" + calcSeconds + "/60/60/24/30)%12 = " + (calcSeconds/60/60/24/30)%12);
        return ((calcSeconds/60/60/24/30));
    }
    public static long revCalcDays(long calcSeconds){
        if(calcSeconds/60/60/24%365 > 359 && calcSeconds/60/60/24 < 365){
            System.out.println("Days 'IF' number one");
            return 31 - (365 - (calcSeconds/60/60/24%365));
        }
        if(calcSeconds/60/60/24 > 364){
            System.out.println("Days 'IF' number two");
            if(((calcSeconds/60/60/24)%365) == 30) {
                return 0;
            }
            return calcSeconds/60/60/24%365%30;
        }
        System.out.println("Days 'IF' number tree. Days = (" + calcSeconds + "/60/60/24)%30 = " + (calcSeconds/60/60/24)%30);
        if(((calcSeconds/60/60/24)%365) == 30){
            return 0;
        }
        else{
            return (calcSeconds/60/60/24)%30;
        }

    }
    public static long revCalcHours(long calcSeconds){
        System.out.println("Hours = (" + calcSeconds + "/60/60)%24 = " + (calcSeconds/60/60)%24);
        return (calcSeconds/60/60)%24;
    }
    public static long revCalcMinutes(long calcSeconds){
        System.out.println("Minutes = (" + calcSeconds + "/60)%60 = " + (calcSeconds/60)%60);
        return (calcSeconds/60)%60;
    }
    public static long revCalcSeconds(long calcSeconds){
        System.out.println("Seconds = " + calcSeconds + " %60 = " + calcSeconds%60);
        return calcSeconds%60;
    }


    public static String calculate(long calcYears, long calcMonths, long calcDays, int calcHrs, int calcMins, int calcSecs){
        //int pwrCounter = 0;
        int compensator = 0;
        if(calcMonths > 11){
            calcYears = calcYears + calcMonths/12;
            calcMonths = calcMonths % 12;
        }
        System.out.println("--------Starting new direct calculation--------");
        result = (calcYears*365*24*60*60)+(calcMonths*30*24*60*60)+(calcDays*24*60*60)+(calcHrs*60*60)+(calcMins*60)+calcSecs;
        System.out.println("Result = " + calcYears + " years*365*24*60*60 + " + calcMonths + " months*30*24*60*60 + " + calcDays + " days*24*60*60 + " + calcHrs + " hours*60*60 + " + calcMins + " minutes*60 + " + calcSecs + " seconds = " + result);
        System.out.println("Counting powers...");
        /*while(result/10 > 0.9999999){
            result = result/10;
            pwrCounter++;
            System.out.print("|| Result = " + result + " Power = " + pwrCounter);
        }*/
        int pwrCounter = (Long.toString(result)).length()-1;
        System.out.println("Power counter = " + pwrCounter);
        //System.out.println("If pwr != one of the options it is reduced to match one.");
        if(pwrCounter != 1 && pwrCounter!= 2 && pwrCounter != 3 && pwrCounter != 6 && pwrCounter!= 9 && pwrCounter!=12 && pwrCounter!=15 && pwrCounter!= 18){
            while (pwrCounter != 1 && pwrCounter!= 2 && pwrCounter != 3 && pwrCounter != 6 && pwrCounter!= 9 && pwrCounter!=12 && pwrCounter!=15 && pwrCounter!= 18){
                if(pwrCounter==0){
                    System.out.println("pwrCounter = 0 in the loop");
                    break;
                }
                pwrCounter--;
                if(pwrCounter < 1){
                    System.out.println("pwrCounter broke");
                    break;
                }
                compensator++;
                System.out.print("|| Power = " + pwrCounter + " Compensator = " + compensator);
            }
        }
        System.out.println("");
        System.out.println("Switch to determine the prefix based on the power.");
        String strResult = Long.toString(result);
        StringBuilder sb = new StringBuilder(strResult);
        char[] charArrayResult = strResult.toCharArray();
        switch (pwrCounter){
            case 0:
                power = "Seconds";
                break;
            case 1:
                power = "decaSeconds (10^1)";
                sb.insert(strResult.length()-1,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 2:
                power = "hectoSeconds (10^2)";
                sb.insert(strResult.length()-2,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 3:
                power = "kiloSeconds (10^3)";
                sb.insert(strResult.length()-3,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 6:
                power = "megaSeconds (10^6)";
                sb.insert(strResult.length()-6,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 9:
                power = "gigaSeconds (10^9)";
                sb.insert(strResult.length()-9,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 12:
                power = "teraSeconds (10^12)";
                sb.insert(strResult.length()-12,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 15:
                power = "petaSeconds (10^15)";
                sb.insert(strResult.length()-15,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            case 18:
                power = "exaSeconds (10^18)";
                sb.insert(strResult.length()-18,".");
                strResult = sb.toString();
                charArrayResult = strResult.toCharArray();
                System.out.println("StrResult length = " + (strResult.length()-1));
                for (int i = strResult.length()-1; i > 0; i--){
                    Character charTemp = charArrayResult[i];
                    if(charTemp.equals('0')){
                        strResult = strResult.substring(0,strResult.length()-1);
                    }
                    else{
                        break;
                    }
                }
                break;
            default:
                power = "";
                break;
        }
        //System.out.println("Returning Result*10 to the power of Compensator: " + result + " * 10^" + compensator + " = " + result*Math.pow(10,compensator));
        //return result*Math.pow(10,compensator);
        return strResult;
    }
}
