package academy.mindswap.andrecastrosousa.builder;

import academy.mindswap.andrecastrosousa.utils.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Design Pattern: Builder
 */
public class MenuTerminal {

    private final List<String> options;

    private final boolean hasBackButton;

    public MenuTerminal(List<String> options, boolean hasBackButton) {
        this.options = options;
        this.hasBackButton = hasBackButton;
    }

    public void print() {
        System.out.println(Messages.SEPARATOR);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf(Messages.MENU_OPTION, i, options.get(i));
        }
        if(hasBackButton) {
            System.out.printf(Messages.MENU_OPTION, options.size(), Messages.BACK_COMMAND);
        }
        System.out.println(Messages.SEPARATOR);
    }

    public String selectOption() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    public static class MenuTerminalBuilder {
        private List<String> options;
        private boolean hasBackButton;

        public MenuTerminalBuilder setOptions(List<String> options) {
            this.options = options;
            return this;
        }

        public MenuTerminalBuilder hasBackButton() {
            this.hasBackButton = true;
            return this;
        }

        public MenuTerminal build() {
            return new MenuTerminal(options, hasBackButton);
        }
    }
}
