package service;

import DataBase.CashRegisterImpl;

import java.util.*;

public class RegisterManager {

    private CashRegisterImpl cashRegister;

    public RegisterManager() {
        cashRegister = new CashRegisterImpl();
    }

    private List<Double> change = new ArrayList<>();

    public void getChange(double value) {
        change.clear();
        double tempVal = value;

        while (tempVal > 0) {
            tempVal = findHighestCoin(tempVal);
        }

        Map<Double, Integer> zlotowki = new TreeMap<>(Comparator.reverseOrder());
        Map<Double, Integer> grosze = new TreeMap<>(Comparator.reverseOrder());

        Collections.sort(change, Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dla reszty ").append(value).append(" zł:").append("\n");

        for (Double element : change) {
            if (element >= 1) {
                zlotowki.putIfAbsent(element, 0);
                zlotowki.put(element, zlotowki.get(element) + 1);
            } else {
                grosze.putIfAbsent(element, 0);
                grosze.put(element, grosze.get(element) + 1);
            }
        }

        for (Double key : zlotowki.keySet()) {
            stringBuilder.append("Wydaj ").append(zlotowki.get(key)).append(" monet ").append((int) Math.floor(key)).append(" zł").append("\n");
        }
        for (Double key : grosze.keySet()) {
            stringBuilder.append("Wydaj ").append(grosze.get(key)).append(" monet ").append((int) (key * 100)).append(" gr").append("\n");
        }

        System.out.println(stringBuilder);
    }

    private double findHighestCoin(double value) {
        if (value >= 5) {
            if (cashRegister.takeOutFromZlotowki(5, 1) == 1) {
                change.add(5.0);
                return Math.ceil((value - 5) * 100) / 100;
            }
        }
        if (value >= 2) {
            if (cashRegister.takeOutFromZlotowki(2, 1) == 1) {
                change.add(2.0);
                return Math.ceil((value - 2) * 100) / 100;
            }
        }
        if (value >= 1) {
            if (cashRegister.takeOutFromZlotowki(1, 1) == 1) {
                change.add(1.0);
                return Math.ceil((value - 1) * 100) / 100;
            }
        }
        if (value >= 0.5) {
            if (cashRegister.takeOutFromGrosze(50, 1) == 1) {
                change.add(0.5);
                return Math.ceil((value - 0.5) * 100) / 100;
            }
        }
        if (value >= 0.2) {
            if (cashRegister.takeOutFromGrosze(20, 1) == 1) {
                change.add(0.2);
                return Math.ceil((value - 0.2) * 100) / 100;
            }
        }
        if (value >= 0.1) {
            if (cashRegister.takeOutFromGrosze(10, 1) == 1) {
                change.add(0.1);
                return Math.ceil((value - 0.1) * 100) / 100;
            }
        }
        if (value >= 0.05) {
            if (cashRegister.takeOutFromGrosze(5, 1) == 1) {
                change.add(0.05);
                return Math.ceil((value - 0.05) * 100) / 100;
            }
        }
        if (value >= 0.02) {
            if (cashRegister.takeOutFromGrosze(2, 1) == 1) {
                change.add(0.02);
                return Math.ceil((value - 0.02) * 100) / 100;
            }
        }
        if (value > 0.01) {
            if (cashRegister.takeOutFromGrosze(1, 1) == 1) {
                change.add(0.01);
                return Math.ceil((value - 0.01) * 100) / 100;
            }
        }
        return 0;
    }




}