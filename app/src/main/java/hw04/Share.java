package hw04;

import java.util.Objects;

public class Share {
    private String owner;
    public Share(String owner) {
        this.owner = owner;
    }
    public void changeOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return this.owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Share share)) return false;
        return Objects.equals(owner, share.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }
}
