package miPresentacion;

import javax.swing.*;
import java.awt.*;

//Jlabel componente gráfico para poner lineas de texto fijo
public class Titulos extends JLabel {
    public Titulos(String titulo, Color colorFondo) {

        //asignar texto al componente gráfico
        this.setText(titulo);
        this.setBackground(colorFondo);
        //color del texto
        this.setForeground(Color.WHITE);
        //fuente
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC, 16));
        //centra etiqueta
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }

}
