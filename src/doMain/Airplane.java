package doMain;

import javax.swing.*;

public class Airplane {

    private Boolean checkBox;
    private Integer id;
    private float cordX;
    private float cordY;
    private float raio;
    private float angulo;
    private float velocidade;
    private float direcao;
    private JLabel imgAirplane;

    public Boolean isCheckBoxSelected() {
        return checkBox;
    }

    public void setCheckBox(Boolean checkBox) {
        this.checkBox = checkBox;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    public float getAngulo() {
        return angulo;
    }

    public void setAngulo(float angulo) {
        this.angulo = angulo;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getDirecao() {
        return direcao;
    }

    public void setDirecao(float direcao) {
        this.direcao = direcao;
    }

    public JLabel getImgAirplane() {
        return imgAirplane;
    }

    public void setImgAirplane(JLabel imgAirplane) {
        this.imgAirplane = imgAirplane;
    }
}
