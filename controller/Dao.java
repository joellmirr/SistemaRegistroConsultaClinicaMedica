/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author joelmir
 */
public interface Dao<Object>{
    
    public void inserir(Object o);
    public void atualizar(Object o);
    public void excluir(int o);
    
}
