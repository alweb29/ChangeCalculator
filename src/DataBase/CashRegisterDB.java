package DataBase;

public interface CashRegisterDB {
    int takeOutFromZlotowki(int requestedValue, int amount);
    int takeOutFromGrosze(int requestedValue, int amount);
    String putCoinIn(int value);
}
