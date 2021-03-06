package domain;

import java.util.Objects;

public class Chip {
    private int amount;

    public Chip(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("칩을 정확히 입력하세요.");
        }
        this.amount = amount;
    }

    public Chip init() {
        this.amount = 0;
        return this;
    }

    public int plus(Chip bettingChip) {
        this.amount += bettingChip.amount;
        return this.amount;
    }

    public int minus(Chip bettingChip) {
        if (this.amount < bettingChip.amount) {
            throw new IllegalArgumentException("배팅할 칩이 부족합니다.");
        }
        this.amount -= bettingChip.amount;
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chip chip = (Chip) o;
        return amount == chip.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
