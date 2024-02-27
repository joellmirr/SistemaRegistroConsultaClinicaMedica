/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joelmir
 */
public class ConsultaM {
    private String idconsulta;
    private String dataconsulta;
    private float valorconsulta;
    private String motivoconsulta;
    private String nomeexame;
    private String descricaoexame;
    private int paciente;
    private int medico;

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getMedico() {
        return medico;
    }

    public void setMedico(int medico) {
        this.medico = medico;
    }


    public String getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(String idconsulta) {
        this.idconsulta = idconsulta;
    }


    public String getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(String dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public float getValorconsulta() {
        return valorconsulta;
    }

    public void setValorconsulta(float valorconsulta) {
        this.valorconsulta = valorconsulta;
    }

    public String getMotivoconsulta() {
        return motivoconsulta;
    }

    public void setMotivoconsulta(String motivoconsulta) {
        this.motivoconsulta = motivoconsulta;
    }

    public String getNomeexame() {
        return nomeexame;
    }

    public void setNomeexame(String nomeexame) {
        this.nomeexame = nomeexame;
    }

    public String getDescricaoexame() {
        return descricaoexame;
    }

    public void setDescricaoexame(String descricaoexame) {
        this.descricaoexame = descricaoexame;
    }
    
}
