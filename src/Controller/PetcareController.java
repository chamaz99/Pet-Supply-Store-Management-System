/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PetcareDao;
import Model.petcare;
import java.util.List;

/**
 *
 * @author Chamara PC
 */
public class PetcareController {

    private PetcareDao dao = new PetcareDao();

    public void additem(int itemcode, String name, int quntity,String UnitPrice) {
        petcare p = new petcare(itemcode, name, quntity,UnitPrice);
        dao.additem(p);

    }

    public List<petcare> getitem() {
        return dao.getAllitem();
    }
    
    public void deleteItem(int itemcode) {
    dao.deleteItem(itemcode);
}
}

