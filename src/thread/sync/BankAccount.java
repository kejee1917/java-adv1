package thread.sync;

public interface BankAccount {

    boolean withDraw(int amount);

    int getBalance();
}
