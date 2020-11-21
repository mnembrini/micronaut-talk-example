package ch.aaap.talks.micronaut;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Vaccine implements Serializable {

    private String name;
    private PetType type;
    private long daysSinceBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public long getDaysSinceBirth() {
        return daysSinceBirth;
    }

    public void setDaysSinceBirth(long daysSinceBirth) {
        this.daysSinceBirth = daysSinceBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return daysSinceBirth == vaccine.daysSinceBirth && Objects.equals(name, vaccine.name) && type == vaccine.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, daysSinceBirth);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vaccine.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("type=" + type)
                .add("daysSinceBirth=" + daysSinceBirth)
                .toString();
    }
}
