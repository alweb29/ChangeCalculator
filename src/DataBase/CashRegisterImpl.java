package DataBase;

import java.util.HashMap;
import java.util.Map;


public class CashRegisterImpl implements CashRegisterDB{

    static private Map<Integer, Integer> zlotowki = new HashMap<>();
    static private Map<Integer, Integer> grosze = new HashMap<>();

    public CashRegisterImpl() {
        initializeZlotowkiValues();
        initalizeGroszeValues();
    }

    public static Map<Integer, Integer> getZlotowki() {
        return zlotowki;
    }

    public static Map<Integer, Integer> getGrosze() {
        return grosze;
    }


    @Override
    public int takeOutFromZlotowki(int requestedValue, int amount) {
        if (!zlotowki.containsKey(requestedValue) || zlotowki.get(requestedValue) <=0) {
            return -1;
        }
        int tempAmount = zlotowki.get(requestedValue);
        tempAmount -= amount;
        zlotowki.put(requestedValue, tempAmount);

        return amount;
    }

    @Override
    public int takeOutFromGrosze(int requestedValue, int amount) {
        if (!grosze.containsKey(requestedValue) || grosze.get(requestedValue) <=0) {
            return -1;
        }
        int tempAmount = grosze.get(requestedValue);
        tempAmount -= amount;
        grosze.put(requestedValue, tempAmount);

        return amount;
    }

    @Override
    public String putCoinIn(int value) {
        //possible implementation of putting coins into register
        return null;
    }

    private void initializeZlotowkiValues(){
        zlotowki.put(5,1);
        zlotowki.put(2,3);
        zlotowki.put(1,5);
    }
    private void initalizeGroszeValues(){
        grosze.put(50,10);
        grosze.put(20,20);
        grosze.put(10,200);
        grosze.put(5,100);
        grosze.put(2,100);
        grosze.put(1,10000);
    }

}
