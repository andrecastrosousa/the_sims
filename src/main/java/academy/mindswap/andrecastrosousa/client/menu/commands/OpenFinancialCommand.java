package academy.mindswap.andrecastrosousa.client.menu.commands;

import academy.mindswap.andrecastrosousa.server.models.Account;
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