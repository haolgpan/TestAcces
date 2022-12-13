import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase crea un constructor llamado especia en inglés y se usará para guardar los atributos que
 * se scrappea de https://github.com/haolgpan/TestAcces.
 */
@XmlRootElement(name="SPICE")
public class Spice {
    //Atributos de la clase especia
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
    @XmlElement(name = "SPICE_CAFFEINE_FREE")
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

    /**
     * Este constructor crea el objeto especia con los siguiente parámatros que corresponden a los atributos de una
     * especia, hierba y sus formas de conservación.
     * @param name Nombre
     * @param intro Introdución
     * @param description Descripción
     * @param ingredients Ingredientes
     * @param basic Aplicación básica
     * @param recommended Aplicación recomenddad
     * @param cuisine Países que cocinan con frecuencia esta especia
     * @param productStyle Formato del producto, en polvo, granulado, líquido o la especia en sí
     * @param botanicalName Nombre botánico
     * @param fold Dosis
     * @param notes Notas
     * @param shellLife Caducidad
     * @param bottleStyle Formato de botella
     * @param capacityVolume Capacidad y volumen de la botella
     * @param dimensions Dimensiones de la botella
     * @param cap Tapón de la botella
     * @param caffeine Cafeína
     * @param scoville Grado calentamineto en escala Scoville
     * @param handling Lugar de conservación
     * @param origin País de orígen
     * @param dietary Preferencias dietarias
     * @param allergen Información para alérgenos
     * @param link Link de la especia
     */
    public Spice(String name, String intro, String description, String ingredients, String basic, String recommended, String cuisine, String productStyle, String botanicalName, String fold, String notes, String shellLife, String bottleStyle, String capacityVolume, String dimensions, String cap, String caffeine, String scoville, String handling, String origin, String dietary, String allergen, String link) {
        this.name = name;
        this.intro = intro;
        this.description = description;
        this.ingredients = ingredients;
        this.basic = basic;
        this.recommended = recommended;
        this.cuisine = cuisine;
        this.productStyle = productStyle;
        this.botanicalName = botanicalName;
        this.fold = fold;
        this.notes = notes;
        this.shellLife = shellLife;
        this.bottleStyle = bottleStyle;
        this.capacityVolume = capacityVolume;
        this.dimensions = dimensions;
        this.cap = cap;
        this.caffeine = caffeine;
        this.scoville = scoville;
        this.handling = handling;
        this.origin = origin;
        this.dietary = dietary;
        this.allergen = allergen;
        this.link = link;
    }

    /**
     * Construcgtor vació para el funcionamiento de JAXB
     */
    public Spice(){
    }
}
