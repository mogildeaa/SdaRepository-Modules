package com.sda;

public class ExInterviu {

    public ExInterviu() {
    }

    public boolean verifyPin(String pin) {
        boolean verificare = false;
//        Ori cu String ori cu char poti sa iei indexul elementelor.
        String firstElement = pin.substring(0, 1);
        char lastElement = pin.charAt(pin.length() - 1);

        if (pin.length() > 16 || pin.length() < 6) {
            return verificare;
        }

        String[] charPin = pin.split("");
        if (firstElement.matches("[a-zA-Z]") && lastElement != '-') {

            for (int i = 0; i < charPin.length; i++) {
//
                if (charPin[i].matches("0|1|2|3|4|5|6|7|8|9")
                        ||
                        charPin[i].matches("[a-zA-Z]*")
                        ||
                        charPin[i].matches("-")) {
                    verificare = true;
                } else {
                    verificare = false;
                    break;
                }
            }
        }

        return verificare;
    }
}
