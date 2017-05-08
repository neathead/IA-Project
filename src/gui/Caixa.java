/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author luis
 */

//TODO: Delete This Enum (Its not in use)
public enum Caixa {
    PretaHorizontal (2),    //1
    PretaVertical (3),      //1
    VermelhaHorizontal (4), //2
    VermelhaVertical (5),   //2
    AzulHorizontal (6),     //3
    AzulVertical (7),       //3
    VerdeHorizontal (8),    //4
    VerdeVertical (9);      //4
    
    public final Integer digito;
    //public final String digito;
	
    private Caixa(Integer digito) {
        this.digito = digito;
    }
}
