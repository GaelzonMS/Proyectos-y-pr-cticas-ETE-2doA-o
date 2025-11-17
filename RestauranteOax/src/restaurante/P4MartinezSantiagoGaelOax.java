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

    private JPanel panelMenus, panelComida;
    private ImageIcon atole, tamalOax, tlayuyas;
    private JLabel etiqAtole, etiqTamal, etiqTlay, etiquetaDesayuno, nomAtole, nomTamal, nomTlay;
    private JButton butAtole, butTamal, butTlay;

    // Cuenta y precios
    private double precioAtole = 45.0;
    private double precioTamal = 30.0;
    private double precioTlay = 70.0;
    private double totalCuenta = 0.0;
    private JTextArea areaCuenta;
    private JLabel etiquetaTotalCuenta;
    private JButton butLimpiar, butPagar;

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

        // instanciamos colores y fuentes a ocupar
        Font fuenteSerief  = new Font("Serief",Font.BOLD,14);
        Font fuenteSerief30  = new Font("Serief",Font.BOLD,30);
        Color colorCarnita = new Color(255, 222, 166);
        Color colorVerdeOscuro = new Color(88, 138, 39);

        // instanciamos el panel de menus y añadimos elementos
        panelMenus = new JPanel();
        panelMenus.setPreferredSize(new Dimension(500, 750));
        panelMenus.setBackground(new Color(250, 155, 40));

        //---------------Espacio de desayunos------------------
        etiquetaDesayuno = new JLabel("Desayunos");
        etiquetaDesayuno.setFont(fuenteSerief30);
        etiquetaDesayuno.setBounds(80, 40, 250, 20);
        etiquetaDesayuno.setAlignmentX(CENTER_ALIGNMENT);
        etiquetaDesayuno.setOpaque(true);
        etiquetaDesayuno.setBackground(colorCarnita);
        panelMenus.add(etiquetaDesayuno);

        //instanciamos imagenes de los desayunos
        tamalOax = new ImageIcon(new ImageIcon("tamalesOax.jpg").getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));
        atole = new ImageIcon(new ImageIcon("atoles.jpg").getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));
        tlayuyas = new ImageIcon(new ImageIcon("tlayudas.jpg").getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));

         //instanciamos botones de los desayunos
        butAtole = new JButton("Ordenar");
        butAtole.setFont(fuenteSerief);
        butAtole.setBackground(colorVerdeOscuro);
        butAtole.addActionListener(this);
        butTamal = new JButton("Ordenar");
        butTamal.setFont(fuenteSerief);
        butTamal.setBackground(colorVerdeOscuro);
        butTamal.addActionListener(this);
        butTlay = new JButton("Ordenar");
        butTlay.setFont(fuenteSerief);
        butTlay.setBackground(colorVerdeOscuro);
        butTlay.addActionListener(this);

        // botones y etiquetas de imagen de cada platillo
        butAtole = new JButton("Ordenar");
        butAtole.setFont(fuenteSerief);
        butAtole.setBackground(colorVerdeOscuro);
        butAtole.addActionListener(this);
        butAtole.setActionCommand("ATOLE");

        butTamal = new JButton("Ordenar");
        butTamal.setFont(fuenteSerief);
        butTamal.setBackground(colorVerdeOscuro);
        butTamal.addActionListener(this);
        butTamal.setActionCommand("TAMAL");

        butTlay = new JButton("Ordenar");
        butTlay.setFont(fuenteSerief);
        butTlay.setBackground(colorVerdeOscuro);
        butTlay.addActionListener(this);
        butTlay.setActionCommand("TLAYUDA");

        // item Atole
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));
        etiqAtole = new JLabel();
        etiqAtole.setIcon(atole);
        nomAtole = new JLabel("Atoles (chocolate, arroz, guayaba) - $" + String.format("%.2f", precioAtole));
        nomAtole.setFont(fuenteSerief);
        item.add(etiqAtole);
        item.add(nomAtole);
        item.add(butAtole);
        panelMenus.add(item);

        // item Tamal
        item = new JPanel(new FlowLayout(FlowLayout.LEFT));
        etiqTamal = new JLabel();
        etiqTamal.setIcon(tamalOax);
        nomTamal = new JLabel("Tamales oaxaqueños - $" + String.format("%.2f", precioTamal));
        nomTamal.setFont(fuenteSerief);
        item.add(etiqTamal);
        item.add(nomTamal);
        item.add(butTamal);
        panelMenus.add(item);

        // item Tlayuda
        item = new JPanel(new FlowLayout(FlowLayout.LEFT));
        etiqTlay = new JLabel();
        etiqTlay.setIcon(tlayuyas);
        nomTlay = new JLabel("Tlayudas - $" + String.format("%.2f", precioTlay));
        nomTlay.setFont(fuenteSerief);
        item.add(etiqTlay);
        item.add(nomTlay);
        item.add(butTlay);
        panelMenus.add(item);

        ventana.add(panelMenus);
        
        // panel de cuenta
        panelComida = new JPanel();
        panelComida.setPreferredSize(new Dimension(550, 750));
        panelComida.setBackground(new Color(248, 63, 169));
        panelComida.setLayout(new BorderLayout(10,10));

        JLabel tituloCuenta = new JLabel("Cuenta");
        tituloCuenta.setFont(fuenteSerief30);
        tituloCuenta.setHorizontalAlignment(SwingConstants.CENTER);
        panelComida.add(tituloCuenta, BorderLayout.NORTH);

        areaCuenta = new JTextArea();
        areaCuenta.setEditable(false);
        areaCuenta.setFont(new Font("Serief",Font.BOLD,14));
        JScrollPane sp = new JScrollPane(areaCuenta);
        panelComida.add(sp, BorderLayout.CENTER);

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        etiquetaTotalCuenta = new JLabel("Total: $0.00");
        etiquetaTotalCuenta.setFont(fuenteSerief);
        abajo.add(etiquetaTotalCuenta);

        butPagar = new JButton("Pagar");
        butPagar.setFont(fuenteSerief);
        
        butPagar.addActionListener(e -> {
            if (totalCuenta > 0) {
                JOptionPane.showMessageDialog(this, "Total a pagar: $" + String.format("%.2f", totalCuenta));
                areaCuenta.setText("");
                totalCuenta = 0.0;
                etiquetaTotalCuenta.setText("Total: $0.00");
            } else {
                JOptionPane.showMessageDialog(this, "La cuenta está vacía.");
            }
        });
        abajo.add(butPagar);

        butLimpiar = new JButton("Limpiar");
        butLimpiar.setFont(fuenteSerief);
        butLimpiar.addActionListener(e -> {
            areaCuenta.setText("");
            totalCuenta = 0.0;
            etiquetaTotalCuenta.setText("Total: $0.00");
        });
        abajo.add(butLimpiar);

        panelComida.add(abajo, BorderLayout.SOUTH);

        ventana.add(panelComida);
    }

    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        if ("ATOLÉ".equals(cmd)) {
            areaCuenta.append(String.format("Atol\t - $%.2f%n", precioAtole));
            totalCuenta += precioAtole;
        } else if ("TAMAL".equals(cmd)) {
            areaCuenta.append(String.format("Tamal\t - $%.2f%n", precioTamal));
            totalCuenta += precioTamal;
        } else if ("TLAYUDA".equals(cmd)) {
            areaCuenta.append(String.format("Tlayuda - $%.2f%n", precioTlay));
            totalCuenta += precioTlay;
        }
        etiquetaTotalCuenta.setText("Total: $" + String.format("%.2f", totalCuenta));
    }
}
