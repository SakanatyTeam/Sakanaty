package role;

public class Housing {
    private static int id;
    private String location;
    private String image;
    private int price;

    public static int getId() {return id;}

    public String getLocation() {return location;}

    public String getImage() {return image;}

    public int getPrice() {return price;}

    public Housing() {

    }

    public Housing(String location, int price) {
        this.location = location;
        this.price = price;
    }

    public Housing(String location, String image, int price) {
        this.location = location;
        this.image = image;
        this.price = price;
    }
}
