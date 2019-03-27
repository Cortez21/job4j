package ru.job4j.tracker;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    final int key;
    final String info;

    public BaseAction(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return new StringBuilder().append(this.key()).append(". ").append(this.info).toString();
    }
}
