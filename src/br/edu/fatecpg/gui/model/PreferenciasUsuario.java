package br.edu.fatecpg.gui.model;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSlider;

public class PreferenciasUsuario {
    private JComboBox<String> combBox;
    private JCheckBox check_des;
    private JSlider slider_vol;
    private Usuario usuario;

    public PreferenciasUsuario(JComboBox<String> combBox, JCheckBox check_des, JSlider slider_vol) {
        this.combBox = combBox;
        this.check_des = check_des;
        this.slider_vol = slider_vol;
    }

    public void salvarPreferencias() {
        String tema = (String) combBox.getSelectedItem();
        boolean notificacoesHabilitadas = check_des.isSelected();
        int volume = slider_vol.getValue();
        
        usuario = new Usuario(tema, notificacoesHabilitadas, volume);
    }

    public String getPreferencias() {
        return "Tema: " + usuario.getTema() + "\n" +
               "Notificações: " + (usuario.isNotificacoesHabilitadas() ? "Habilitadas" : "Desabilitadas") + "\n" +
               "Volume: " + usuario.getVolume();
    }
}
