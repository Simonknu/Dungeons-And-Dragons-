public class Item {
    private String name;
    private String findName;

    public Item(String name, String findName){
        this.name = name;
        this.findName = findName;

    }

    public String getName(){
        return name;
    }
    public String getFindName(){
        return findName;
    }
}
