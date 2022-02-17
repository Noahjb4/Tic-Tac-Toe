public class OACPlayer extends Player {
    private Checker checker;

    public OACPlayer(String name){
        super(name);
        this.checker = new Checker("X");
    }

    public OACPlayer(String name, String c){
        super(name);

        try {
            this.checker = new Checker(c.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Not Valid Order and Chaos PLayer");
        }
    }

    public OACPlayer(String name, char c){
        this(name, ""+c);

    }

    public Checker getChecker(){
        return checker;
    }
}
