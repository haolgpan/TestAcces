import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SPICES")
public class Spices {
    List<Spice> spices;
    public List<Spice> getSpices(){
        return spices;
    }
    @XmlElement(name = "SPICE")
    public void setSpices(List<Spice> spices){
        this.spices = spices;
    }
    public void add(Spice spice){
        if(this.spices == null){
            this.spices = new ArrayList<Spice>();
        }
        this.spices.add(spice);
    }
}
