/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Chamara PC
 */
//Encapsulation
public class petcare {
    private int itemcode;
    private String name;
    private int  quntity;
    private String UnitPrice;
    
    public petcare (int itemcode, String name, int quntity,String UnitPrice) {
        this.itemcode = itemcode;
        this.name = name;
        this.quntity = quntity;
        this.UnitPrice= UnitPrice;
        
    }


    //  Public getters
    public int getcode() { return itemcode; }
    public String getName() { return name; }
    public int getquntity() { return quntity; }
    public String getUnitPrice() { return UnitPrice; }
}

