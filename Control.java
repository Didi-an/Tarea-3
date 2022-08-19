
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Diana
 */
public class Controller implements Initializable {
    
    @FXML
    private TextField entrada;
    
    @FXML
    private void evaluar(ActionEvent event) {
        String result = Evaluar.eval(entrada.getText());
        entrada.setText(result);
    }
    
    @FXML
    private void borrar(ActionEvent event) {
        entrada.setText("");
    }
    
    @FXML
    private void otroBoton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String nuevaEntrada = entrada.getText() + btn.getText();
        entrada.setText(nuevaEntrada);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
