/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joelmir
 */
public class PessoaJuridica extends Pessoa {
    private String Cnpj;
    private String RazaoSocial;
    private String InscricaoEstadual;
    private String InscricaoMunicipal;
    private String Segmento;
    private String DataAbertura;

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getInscricaoEstadual() {
        return InscricaoEstadual;
    }

    public void setInscricaoEstadual(String InscricaoEstadual) {
        this.InscricaoEstadual = InscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return InscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String InscricaoMunicipal) {
        this.InscricaoMunicipal = InscricaoMunicipal;
    }

    public String getSegmento() {
        return Segmento;
    }

    public void setSegmento(String Segmento) {
        this.Segmento = Segmento;
    }

    public String getDataAbertura() {
        return DataAbertura;
    }

    public void setDataAbertura(String DataAbertura) {
        this.DataAbertura = DataAbertura;
    }
}
