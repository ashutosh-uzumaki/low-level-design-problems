package org.ashutosh.entities;

public class Player {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    Symbol symbol;

    public Player(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }
}
