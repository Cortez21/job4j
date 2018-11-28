package ru.job4j.Claculator;

import java.util.ArrayList;

public class MenuLogic {
    private ArrayList<Operation> operations = new ArrayList<Operation>();
    int x = 1;
    public MenuLogic() {

    }

    private class Add extends Operation {
        public Add(int key, String info) {
            super(key, info);
        }

        
    }
}
