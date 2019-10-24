package be.lens.syntra.calculator;

public class Calculator {
    public String add(String s) {
        String separator = ",";
        if(s.length() > 3){
            if(!isNumber(s.substring(0,1))){
                if("\\n".equals(s.substring(1,3))){
                    separator = s.substring(0,1);
                }
                s = s.substring(3,s.length());
            }
        }
        if((s.length() >0) && (s.substring(s.length()-1,s.length()).equals(","))){
            return "Number expected but EOF found.";
        }
        if (s.split(separator).length < 2) {
            if (isNumber(s)) {
                return "" + s;
            }
            return "0";
        }else{
            float result = 0F;
            for (String singleNumberString : s.split(separator)) {
                result += Float.parseFloat(singleNumberString);
            }
            return "" + result;
        }
    }

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
