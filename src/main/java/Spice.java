import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SPICE")
public class Spice {
    String name;
    String intro;
    String description;
    String ingredients;
    String basic;
    String recommended;
    String cuisine;
    String productStyle;
    String botanicalName; 
    String fold;
    String notes;
    String shellLife;
    String bottleStyle;
    String capacityVolume;
    String dimensions;
    String cap;
    String caffeine;
    String scoville;
    String handling;
    String origin;
    String dietary;
    String allergen;
    String link;

    public String getName() {
        return name;
    }
    @XmlElement(name = "SPICE_NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }
    @XmlElement(name = "SPICE_INTRO")
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDescription() {
        return description;
    }
    @XmlElement(name = "SPICE_DESCRIPTION")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }
    @XmlElement(name = "SPICE_INGREDIENTS")
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getBasic() {
        return basic;
    }
    @XmlElement(name = "SPICE_BASIC_APPLICATION")
    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getRecommended() {
        return recommended;
    }
    @XmlElement(name = "SPICE_RECOMMENDED_APPLICATION")
    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getCuisine() {
        return cuisine;
    }
    @XmlElement(name = "SPICE_CUISINE")
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getProductStyle() {
        return productStyle;
    }
    @XmlElement(name = "SPICE_PRODUCT_STYLE")
    public void setProductStyle(String productStyle) {
        this.productStyle = productStyle;
    }

    public String getBotanicalName() {
        return botanicalName;
    }
    @XmlElement(name = "SPICE_BOTANICAL_NAME")
    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public String getFold() {
        return fold;
    }
    @XmlElement(name = "SPICE_FOLD")
    public void setFold(String fold) {
        this.fold = fold;
    }

    public String getNotes() {
        return notes;
    }
    @XmlElement(name = "SPICE_NOTES")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getShellLife() {
        return shellLife;
    }
    @XmlElement(name = "SPICE_SHELL_LIFE")
    public void setShellLife(String shellLife) {
        this.shellLife = shellLife;
    }

    public String getBottleStyle() {
        return bottleStyle;
    }
    @XmlElement(name = "SPICE_BOTTLE_STYLE")
    public void setBottleStyle(String bottleStyle) {
        this.bottleStyle = bottleStyle;
    }

    public String getCapacityVolume() {
        return capacityVolume;
    }
    @XmlElement(name = "SPICE_CAPACITY_AND_VOLUME")
    public void setCapacityVolume(String capacityVolume) {
        this.capacityVolume = capacityVolume;
    }

    public String getDimensions() {
        return dimensions;
    }
    @XmlElement(name = "SPICE_DIMENSIONS")
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getCap() {
        return cap;
    }
    @XmlElement(name = "SPICE_CAP")
    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCaffeine() {
        return caffeine;
    }
    @XmlElement(name = "SPICE_CAFFEINE_FREE?")
    public void setCaffeine(String caffeine) {
        this.caffeine = caffeine;
    }

    public String getScoville() {
        return scoville;
    }
    @XmlElement(name = "SPICE_SCOVILLE_HEAT_SCALE")
    public void setScoville(String scoville) {
        this.scoville = scoville;
    }

    public String getHandling() {
        return handling;
    }
    @XmlElement(name = "SPICE_HANDLING_AND_STORAGE")
    public void setHandling(String handling) {
        this.handling = handling;
    }

    public String getOrigin() {
        return origin;
    }
    @XmlElement(name = "SPICE_COUNTRY_ORIGIN")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDietary() {
        return dietary;
    }
    @XmlElement(name = "SPICE_DIETARY_PREFERENCES")
    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    public String getAllergen() {
        return allergen;
    }
    @XmlElement(name = "SPICE_ALLERGEN_INFORMATION")
    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public String getLink() {
        return link;
    }
    @XmlElement(name = "SPICE_LINKS")
    public void setLink(String link) {
        this.link = link;
    }
}
