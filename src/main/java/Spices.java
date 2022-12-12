import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que crea un arraylist para guardar la lista de especias que guardaremos para luego manejarlo en el código
 */
@XmlRootElement(name = "SPICES")
public class Spices {
    List<Spice> spices;

    /**
     * Método que permite acceder a la arraylist spices
     * @return Devuelve un Arraylist de especias
     */
    public List<Spice> getSpices(){
        return spices;
    }
    @XmlElement(name = "SPICE")
    public void setSpices(List<Spice> spices){
        this.spices = spices;
    }

    /**
     * Este método recibe por parámetro un objeto spice y lo añade a la arraylist spices
     * @param spice
     */
    public void add(Spice spice){
        if(this.spices == null){
            this.spices = new ArrayList<Spice>();
        }
        this.spices.add(spice);
    }
}
