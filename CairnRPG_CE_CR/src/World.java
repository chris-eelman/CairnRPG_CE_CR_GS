public class World {

    String gameName;
    String publisher;

    public World(String gameName, String publisher) {
        this.gameName = gameName;
        this.publisher = publisher;
    }

    public World() {
        this.gameName = "Something";
        this.publisher = "11 as 1";
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
