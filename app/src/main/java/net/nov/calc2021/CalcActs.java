package net.nov.calc2021;



public class CalcActs {

    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        operationSelected,
        secondArgInput,
        resultShow
    }

    public CalcActs() {
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (state == State.operationSelected) {
            state = State.secondArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.key_0:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.key_1:
                    inputStr.append("1");
                    break;
                case R.id.key_2:
                    inputStr.append("2");
                    break;
                case R.id.key_3:
                    inputStr.append("3");
                    break;
                case R.id.key_4:
                    inputStr.append("4");
                    break;
                case R.id.key_5:
                    inputStr.append("5");
                    break;
                case R.id.key_6:
                    inputStr.append("6");
                    break;
                case R.id.key_7:
                    inputStr.append("7");
                    break;
                case R.id.key_8:
                    inputStr.append("8");
                    break;
                case R.id.key_9:
                    inputStr.append("9");
                    break;
            }
        }

    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.key_equal && state == State.secondArgInput && inputStr.length() > 0) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.key_add:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.key_sub:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.key_mul:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.key_div:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.key_degree:
                    inputStr.append(pow(firstArg,secondArg));
                    break;
                case R.id.key_percent:
                    inputStr.append(firstArg / secondArg*100);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput && actionId != R.id.key_equal) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.operationSelected;
            actionSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputStr.toString();
            case operationSelected:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .toString();
            case secondArgInput:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputStr)
                        .toString();
            case resultShow:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(secondArg)
                        .append(" = ")
                        .append(inputStr.toString())
                        .toString();
        }
    }

    private char getOperationChar() {
        switch (actionSelected) {
            case R.id.key_add:
                return '+';
            case R.id.key_sub:
                return '-';
            case R.id.key_mul:
                return '*';
            case R.id.key_degree:
                return '^';
            case R.id.key_percent:
                return '%';
            case R.id.key_div:
            default:
                return '/';

        }
    }
        public int pow (int value, int powValue) {
            int result = 1;
            for (int i = 1; i <= powValue; i++) {
                result = result * value;
            }
            return result;
        }

    public void reset() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }
}
