package dza.nemo.zodiacsymbolsrecyclerview;

// class that contain all data needed for showing to the screen
public class ZodiacModel {

    // variables that holds data that represent one of the item
    String zodiacName;
    String zodiacDate;
    String zodiacDescription;
    int image;

    public ZodiacModel(String zodiacName, String zodiacDate,String zodiacDescription,int image ) {
        this.zodiacName = zodiacName;
        this.zodiacDate = zodiacDate;
        this.zodiacDescription = zodiacDescription;
        this.image = image;
    }

    public String getZodiacName() {
        return zodiacName;
    }

    public void setZodiacName(String zodiacName) {
        this.zodiacName = zodiacName;
    }

    public String getZodiacDate() {
        return zodiacDate;
    }

    public void setZodiacDate(String zodiacDate) {
        this.zodiacDate = zodiacDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getZodiacDescription() {
        return zodiacDescription;
    }
}
