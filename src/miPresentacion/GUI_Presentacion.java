package miPresentacion;

import java.awt.*; //listener: los escuchas
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //source: fuente generadora de eventos
import javax.swing.border.TitledBorder;

// para crear una ventana: espacio rectangular
// GUI: subclase de JFrame
public class GUI_Presentacion extends JFrame {

    // atributos
    // declaramos los 3 objetos
    private JButton mifoto, miHobby, misExpectativas;

    // componente que alberga otros componentes gráficos
    private JPanel panelBotones, panelDatos;

    // declaro el objeto titulo
    // luego lo configuro en initGUI()
    private Titulos titulo;
    private Escucha escucha;
    private JLabel labelImagen;            // etiqutea de texto
    private JTextArea miTextoExpectativas; // bloque de texto

    // métodos
    // CONSTRUCTOR: que arranque como deseo visualizarla
    public GUI_Presentacion() {

        initGUI(); // inicializar componentes gráficos

        // configuración base de la ventana

        this.setTitle("Borja Introducing"); // titulo

        this.setSize(600, 540);           // tamaño de la ventana
        this.setLocationRelativeTo(null); // centrar la ventana al abrirse
        this.setVisible(true);            // poner ventana visible
        this.setResizable(false);         // hacerla redimensionable o no

        // para que deje de ejecutarse cuando cierre la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //para iniciar componentes
    private void initGUI() {
        // definir Container y Layout del JFrame
        // función de Container(recibir objetos)
        // Layout (gestiona la ubicación/posición)
        // Crear objetos Escuha y Control
        escucha = new Escucha();

        // config JComponents
        titulo = new Titulos(
                "Hola soy Andrés Borja, oprime los botones y conocerás de mí...",
                Color.ORANGE);
        this.add(titulo, BorderLayout.NORTH); // donde lo ubico??

        panelDatos = new JPanel();
        // en BorderFactory no instancio objetos
        panelDatos.setBorder(BorderFactory.createTitledBorder(
                null, "Más sobre mí...", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("Calibri", Font.PLAIN, 20),
                Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        mifoto = new JButton("Este soy yo");
        // adicionamos al componente gráfico
        mifoto.addActionListener(escucha);
        mifoto.setBackground(Color.lightGray);
        miHobby = new JButton("Este es mi pasatiempo");
        miHobby.addActionListener(escucha);
        miHobby.setBackground(Color.lightGray);
        misExpectativas = new JButton("Expectativas");
        misExpectativas.addActionListener(escucha);
        misExpectativas.setBackground(Color.lightGray);

        panelBotones = new JPanel();
        // establecemos orden
        panelBotones.add(mifoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        // color botones
        panelBotones.setBackground(Color.orange);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImagen = new JLabel();
        miTextoExpectativas = new JTextArea(12, 24);
    }

    public static void main(String[] args) {

        // objeto que permite manejo de eventos
        // cola manejadora de eventos
        EventQueue.invokeLater(new Runnable() {
            // interfaz gráfica se ejecuta como subproceso
            // para ello nceseita de estructura concurrente Runnable()
            // Runnable es la interfase que me provee el método run
            public void run() {

                // crear la instancia de la clase
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    // no heredan sino que se implementan
    // implementará el metodo ActionListeners
    // ActionListener es un Escucha de acción
    // es decir al dar click sobre un boton él se dirije
    // al método actionPerformed(ActionEvent e)
    private class Escucha implements ActionListener {

        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            // la sgte línea es una prueba de lo que hace al dar clic
            // en un boton y llamar a actionPerformed
            // JOptionPane.showMessageDialog(null, "oprime el boton");

            panelDatos.removeAll();

            // para indicar cuál boton fue, hacemos condicionales
            if (e.getSource() == mifoto) {
                image = new ImageIcon(getClass().getResource("/recursos/borjaM.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);

            } else {
                if (e.getSource() == miHobby) {
                    image = new ImageIcon(
                            getClass().getResource("/recursos/hobbie (1).jpeg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);

                } else {
                    miTextoExpectativas.setFont(new Font("SansSerif", 1, 20));
                    miTextoExpectativas.setFont(
                            new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 20));
                    miTextoExpectativas.setLineWrap(true);
                    miTextoExpectativas.setWrapStyleWord(true);
                    miTextoExpectativas.setEditable(false);
                    miTextoExpectativas.setText(
                            "No se nada de programación orientada a eventos. Espero a lo largo del curso aplicar y dominar todas las herramientas.\nMis expectativas son altas para este semestre, deseo sea mucho mejor que el semestre anterior.");
                    // miTextoExpectativas.setFont(new Font(Font.SANS_SERIF,
                    // Font.BOLD+Font.ITALIC, 20));
                    miTextoExpectativas.setBackground(Color.WHITE);
                    panelDatos.add(miTextoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }
}
