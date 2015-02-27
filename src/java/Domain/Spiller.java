/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author jones
 */
public class Spiller {
    int id;
    String name, Country;

    public Spiller(int id, String navn, String land) {
        this.id = id;
        this.name = navn;
        this.Country = land;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    @Override
    public String toString() {
        return "Spiller{" + "id=" + id + ", name=" + name + ", Country=" + Country + '}';
    }
    
    
    
    
}
