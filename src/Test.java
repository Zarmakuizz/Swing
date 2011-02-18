import vue.Alerte;

public class Test {
    private static Alerte al;
    
    public static void main(String[] args) {
        al = new Alerte(1);
        al.pack();
        al.setVisible(true);
    }

}
