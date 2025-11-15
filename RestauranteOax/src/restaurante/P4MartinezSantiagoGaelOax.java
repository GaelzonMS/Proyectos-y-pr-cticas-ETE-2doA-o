package restaurante;

/**
 * Programa: Calculadora de IMC
 * Autores: Martínez Santiago Gael 
 * 			Chávez Núñez Citlalli
 * 			
 * Fecha: 03/nov/25
 * Descripción: Consiste en un cuestionario que te solicita tu
 * peso, estatura y nombre, y con eso dar tu IMC.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class P4MartinezSantiagoGaelOax extends JFrame implements ActionListener {

    private JPanel panelDesayuno, panelComida, panelCena;

    public static void main(String[] args) {
        P4MartinezSantiagoGaelOax marco = new P4MartinezSantiagoGaelOax();
        marco.setSize(1920, 1080);
        marco.setTitle("Restaurante");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setBackground(new Color(1, 101, 231));
        ventana.setLayout(new FlowLayout());

        panelDesayuno = new JPanel();
        panelDesayuno.setPreferredSize(new Dimension(500, 750));
        panelDesayuno.setBackground(new Color(250, 155, 40));
        ventana.add(panelDesayuno);

        panelComida = new JPanel();
        panelComida.setPreferredSize(new Dimension(500, 750));
        panelComida.setBackground(new Color(248, 63, 169));
        ventana.add(panelComida);

        panelCena = new JPanel();
        panelCena.setPreferredSize(new Dimension(500, 750));
        panelCena.setBackground(new Color(0, 156, 152));
        ventana.add(panelCena);
    }

    public void actionPerformed(ActionEvent event) {
        
    }
}
