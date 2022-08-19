

package calculadora;
import java.util.Vector;

/**
 * 
 * @author Diana
 */
public class Evaluar {
    private static Vector<String> elements;
    
    public static String eval(String in) {
	String validos = "0123456789*+-/";
	String num = "";
	elements = new Vector<String>();
	for(int i=0; i<in.length(); i++) {
		char c = in.charAt(i);
		//validar si c es un caracter valido
		if(validos.indexOf(c) == -1 && c != '.'){
			continue;// no valido
		}
		//es un operador?
		if("*/+-".indexOf(c)>=0){
                    elements.add(num);
                    elements.add(c+"");
                    num = "";
		} else {
			num += c;
		}
	}
        elements.add(num);
        //
        printElements();
        while(Evaluar.realizarOperacion("*")==1) {};
        boolean division = true;
        while(division) {
            switch(Evaluar.realizarOperacion("/")){
                case 0:
                    division = false;
                    break;
                case -1:
                    return "ERROR";
            }
        }
        while(Evaluar.realizarOperacion("+")==1) {};
        while(Evaluar.realizarOperacion("-")==1) {};
        Double r = Double.valueOf(elements.get(0));
        return String.format("%.2f", r);
    }

    private static int realizarOperacion(String operador){
        printElements();
        for(int i=0; i<elements.size(); i++){
            String element = elements.get(i);
            if (!element.equals(operador)){
                continue;
            }
            Double op1 = Double.valueOf(elements.get(i-1));
            Double op2 = Double.valueOf(elements.get(i+1));
            Double result = null;
            switch(operador) {
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    if(op2==0){
                        return -1; //Error
                    }
                    result = op1 / op2;
                    break;
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
            }
            if(result == null ){
                return 0;
            }
