import service.RegisterManager;

public class Main {

    static RegisterManager registerManager = new RegisterManager();
    public static void main(String[] args) {

        registerManager.getChange(1.30);
        registerManager.getChange(11.70);
        registerManager.getChange(6.70);
        registerManager.getChange(4.3);
    }
}