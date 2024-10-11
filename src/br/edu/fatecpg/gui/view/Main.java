package br.edu.fatecpg.gui.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import br.edu.fatecpg.gui.model.PreferenciasUsuario;

public class Main extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> combBox;
    private JCheckBox check_des;
    private JSlider slider_vol;
    private JTextArea textArea;
    private PreferenciasUsuario preferenciasUsuario;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 387, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTema = new JLabel("Tema");
        lblTema.setBounds(10, 15, 100, 14);
        contentPane.add(lblTema);
        
        combBox = new JComboBox<>();
        combBox.setModel(new DefaultComboBoxModel<>(new String[] {"Claro", "Escuro"}));
        combBox.setBounds(120, 13, 100, 22);
        contentPane.add(combBox);
        
        JLabel lblNotificacao = new JLabel("Notificações");
        lblNotificacao.setBounds(10, 50, 100, 14);
        contentPane.add(lblNotificacao);
        
        check_des = new JCheckBox("Habilitar/Desabilitar");
        check_des.setBounds(120, 46, 150, 23);
        contentPane.add(check_des);
        
        JLabel lblVolume = new JLabel("Volume");
        lblVolume.setBounds(10, 85, 100, 14);
        contentPane.add(lblVolume);
        
        slider_vol = new JSlider();
        slider_vol.setBounds(120, 81, 150, 26);
        slider_vol.setMinimum(0);
        slider_vol.setMaximum(100);
        contentPane.add(slider_vol);
        
        JButton btnSave = new JButton("Salvar");
        btnSave.setBounds(10, 130, 100, 23);
        contentPane.add(btnSave);
        
        textArea = new JTextArea();
        textArea.setBounds(120, 160, 200, 100);
        contentPane.add(textArea);
        
        preferenciasUsuario = new PreferenciasUsuario(combBox, check_des, slider_vol);
        
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preferenciasUsuario.salvarPreferencias();
                exibirPreferencias();
                alterarTema();
            }
        });
    }

    private void exibirPreferencias() {
        String preferencias = preferenciasUsuario.getPreferencias();
        textArea.setText(preferencias);
    }

    private void alterarTema() {
        String temaSelecionado = (String) combBox.getSelectedItem();
        if ("Escuro".equals(temaSelecionado)) {
            contentPane.setBackground(Color.BLACK);
            textArea.setBackground(Color.BLACK);    
            textArea.setForeground(Color.WHITE);   
        } else {
            contentPane.setBackground(Color.WHITE); 
            textArea.setBackground(Color.WHITE);   
            textArea.setForeground(Color.BLACK);    
        }
    }
}
