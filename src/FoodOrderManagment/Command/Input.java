package FoodOrderManagment.Command;

public class Input {

    private int time;
    private String Action;
    private InputCommands inputCommand;

    public Input() {
    }

    public Input(int time, String action, InputCommands inputCommand) {
        this.time = time;
        Action = action;
        this.inputCommand = inputCommand;
    }

    public int getTime() {
        return time;
    }

    public Input setTime(int time) {
        this.time = time;
        return this;
    }

    public String getAction() {
        return Action;
    }

    public Input setAction(String action) {
        Action = action;
        return this;
    }

    public InputCommands getInputCommand() {
        return inputCommand;
    }

    public Input setInputCommand(InputCommands inputCommand) {
        this.inputCommand = inputCommand;
        return this;
    }
}
