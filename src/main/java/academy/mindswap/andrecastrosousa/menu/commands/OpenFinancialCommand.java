package academy.mindswap.andrecastrosousa.menu.commands;

import academy.mindswap.andrecastrosousa.character.Account;
import academy.mindswap.andrecastrosousa.utils.Messages;

public class OpenFinancialCommand implements Command {

    private final Account account;

    public OpenFinancialCommand(Account account) {
        this.account = account;
    }
    @Override
    public void execute() {
        System.out.println("\n" + Messages.SEPARATOR);
        System.out.println(account.toString());
        System.out.println(Messages.SEPARATOR + "\n");
    }
}