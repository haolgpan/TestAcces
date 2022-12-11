import com.opencsv.CSVWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
    //Index
    //spicesNames; --> 0
    //spiceIntro;  --> 1
    //spiceDescription; --> 2
    //spiceIngredients; --> 3
    //spiceBasic; --> 4
    //spiceRecommended;  --> 5
    //spiceCuisine;  --> 6
    //spiceProductStyle;  --> 7
    //spiceBotanicalName;  --> 8
    //spiceFold; --> 9
    //spiceNotes; --> 10
    //spiceShellLife; --> 11
    //spiceBottleStyle; --> 12
    //spiceCapacityVolume; --> 13
    //spiceDimensions; --> 14
    //spiceCap; --> 15
    //spiceCaffeine; --> 16
    //spiceScoville; --> 17
    //spiceHandling; --> 18
    //spiceOrigin; --> 19
    //spiceDietary; --> 20
    //spiceAllergen; --> 21
    //spiceLink; --> 22
    static List<String[]> spiceBD = new ArrayList<String[]>();
    static List<String> spicesLinks = new ArrayList<>();
    static List<String> spicesNames = new ArrayList<>();
    static String[] header = {"Name","Introduction","Description","Ingredients","Basic preparation","Recommended aplications",
            "Cuisine","Product style","Botanical name","Fold (Strength)","Notes","Shell life","Bottle style","Capacity/Volume","Dimensions",
            "Cap","Caffeine free?","Scoville heat scale","Handling/Storage","Country of origin","Dietary preferences",
            "Allergen information","Page link"};

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        WebDriverWait myWaitVar = new WebDriverWait(driver, 5);
        driver.get("https://www.spicejungle.com/list-of-spices");
        List<WebElement> spicesElements = driver.findElements(By.cssSelector("#paz > ul:nth-child(4) > li:nth-child(n+1) > ul:nth-child(2) > li"));
        spiceBD.add(header);
        for(int i = 0; i< spicesElements.size() ; i++ )
        {
            spicesNames.add(spicesElements.get(i).getText());
        }
        for(int i = 0; i< spicesElements.size() ; i++ )
        {
            spicesLinks.add(spicesElements.get(i).findElement(By.tagName("a")).getAttribute("href"));
        }
        //spicelink size is 481
        for(int i = 0; i < spicesLinks.size()-1 ; i++ )//For some unknown reason, it will only iterate to 480 skipping 481
        {
            try{
                String [] spiceFullInfo = new String[23];
                driver.get(spicesLinks.get(i));
                //myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("description")));
                WebElement description = driver.findElement(By.className("description"));
                WebElement intro = driver.findElement(By.className("value")).findElement(By.tagName("p"));
                spiceFullInfo[0] = spicesNames.get(i);
                System.out.println(spiceFullInfo[0]);
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println(intro.getText());
                spiceFullInfo[1] = (intro.getText());
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println(description.getText());
                spiceFullInfo[2] = (description.getText()).replace("\n","").replace("\r","");
                System.out.println("------------------------------------------------------------------------------------------");
                tableSearchAllInfo(driver,spiceFullInfo);
                System.out.println("------------------------------------------------------------------------------------------");
                spiceFullInfo[22] = spicesLinks.get(i);
                System.out.println(spiceFullInfo[22]);
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println(Arrays.toString(spiceFullInfo));
                spiceBD.add(spiceFullInfo);
            }catch (NoSuchElementException e) {
                System.out.println("No page or no element");
                String [] spiceFullInfo = new String[23];
                driver.get(spicesLinks.get(i));
                spiceFullInfo[0] = spicesNames.get(i);
                System.out.println(spiceFullInfo[0]);
                System.out.println(Arrays.toString(spiceFullInfo));
                spiceBD.add(spiceFullInfo);
            }
        }
        try{
            String [] spiceFullInfo = new String[23];
            int i = spicesLinks.size()-1;
            driver.get(spicesLinks.get(i));
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("description")));
            WebElement description = driver.findElement(By.className("description"));
            WebElement intro = driver.findElement(By.cssSelector("div.attribute:nth-child(1) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)"));
            spiceFullInfo[0] = spicesNames.get(spicesLinks.size()-1);
            System.out.println(spiceFullInfo[0]);
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(intro.getText());
            spiceFullInfo[1] = (intro.getText());
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(description.getText());
            spiceFullInfo[2] = (description.getText()).replace("\n","").replace("\r","");
            System.out.println("------------------------------------------------------------------------------------------");
           tableSearchAllInfo(driver,spiceFullInfo);
            System.out.println("------------------------------------------------------------------------------------------");
            spiceFullInfo[22] = spicesLinks.get(i);
            System.out.println(spiceFullInfo[22]);
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(Arrays.toString(spiceFullInfo));
            spiceBD.add(spiceFullInfo);
        }catch (NoSuchElementException e){
            System.out.println("No page or no element of z");
        }
        openCsvOutput();
        spiceBD.forEach(strings -> System.out.println(Arrays.toString(strings)));
        xmlOuput();
        driver.quit();
    }
    public static void tableSearchAllInfo(WebDriver driver, String[] spiceFullinfo) {
        try{
            WebElement mainTable = driver.findElement(By.id("product-attribute-specs-table"));
            List<WebElement> rows = mainTable.findElements(By.tagName("tr"));
            for (WebElement row: rows){
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Ingredients")) {
                    spiceFullinfo[3] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[3]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Basic Preparation")) {
                    spiceFullinfo[4] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[4]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Recommended Applications")) {
                    spiceFullinfo[5] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[5]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Cuisine")) {
                    spiceFullinfo[6] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[6]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Product Style")) {
                    spiceFullinfo[7] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[7]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Botanical Name")) {
                    spiceFullinfo[8] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[8]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Fold (Strength)")) {
                    spiceFullinfo[9] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[9]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Notes")) {
                    spiceFullinfo[10] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[10]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Shell Life")) {
                    spiceFullinfo[11] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[11]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Bottle Style")) {
                    spiceFullinfo[12] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[12]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Capacity/Volume")) {
                    spiceFullinfo[13] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[13]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Dimensions")) {
                    spiceFullinfo[14] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[14]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Cap")) {
                    spiceFullinfo[15] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[15]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Caffeine Free?")) {
                    spiceFullinfo[16] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[16]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Scoville Heat Scale")) {
                    spiceFullinfo[17] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[17]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Handling / Storage")) {
                    spiceFullinfo[18] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[18]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Country of Origin")) {
                    spiceFullinfo[19] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[19]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Dietary Preferences")) {
                    spiceFullinfo[20] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[20]);
                }
                if (row.findElement(By.tagName("td")).getAttribute("data-th").equals("Allergen Information")) {
                    spiceFullinfo[21] = (row.findElement(By.tagName("td")).getText());
                    System.out.println(spiceFullinfo[21]);
                }
            }
        }catch (NoSuchElementException e){}
    }
    //Without OpenCSV
    /*public static void outputToCsv(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/test.csv"));
            bw.write("Name;Introduction;Description;Ingredients;Basic preparation;Recommended aplications;" +
                    "Cuisine;Product style;Botanical name;Shell life;Bottle style;Capacity/Volume;Dimensions;" +
                    "Cap;Caffeine free?;Scoville heat scale;Handling/Storage;Country of origin;Dietary preferences;" +
                    "Allergen information;Page link;");
            bw.newLine();
            for (String[] s : spiceBD) {
                bw.write(s[0] + ";" + s[1] + ";" + s[2] + ";" + s[3] + ";" + s[4] + ";" + s[5] + ";" + s[6]
                        + ";" + s[7] + ";" + s[8] + ";" + s[9] + ";" + s[10] + ";" + s[11] + ";" + s[12]
                        + ";" + s[13] + ";" + s[14] + ";" + s[15] + ";" + s[16] + ";" + s[17] + ";" + s[18]
                        + ";" + s[19] + ";" + s[20] + ";" + s[21] + ";" + s[22] + ";");
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    public static void openCsvOutput(){
        StringWriter writer = new StringWriter();

        try {
            CSVWriter csvWriter = new CSVWriter( new OutputStreamWriter(new FileOutputStream("spices.csv"), StandardCharsets.UTF_8),
                    ',',
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            csvWriter.writeAll(spiceBD);
            csvWriter.close();
            System.out.println(writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void xmlOuput() {
        Spices spiceXML = new Spices();
        for (int i = 1; i < spiceBD.size(); i++) {
            spiceXML.add(new Spice(spiceBD.get(i)[0],spiceBD.get(i)[1],spiceBD.get(i)[2],spiceBD.get(i)[3],
                    spiceBD.get(i)[4],spiceBD.get(i)[5],spiceBD.get(i)[6],spiceBD.get(i)[7],spiceBD.get(i)[8],
                    spiceBD.get(i)[9],spiceBD.get(i)[10],spiceBD.get(i)[11],spiceBD.get(i)[12],spiceBD.get(i)[13],
                    spiceBD.get(i)[14],spiceBD.get(i)[15],spiceBD.get(i)[16],spiceBD.get(i)[17],spiceBD.get(i)[18],
                    spiceBD.get(i)[19],spiceBD.get(i)[20],spiceBD.get(i)[21],spiceBD.get(i)[22]));
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Spices.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(spiceXML, new File("spices.xml"));
            jaxbMarshaller.marshal(spiceXML, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
