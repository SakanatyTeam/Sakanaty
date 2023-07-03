package StaticDB;

public class Housing {
    private static int id;
    private String location;
    private String image;
    private int price;

    public Housing(String location, String image, int price) {
        this.location = location;
        this.image = image;
        this.price = price;
    }
}
