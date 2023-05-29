package main.java.format.client;

public abstract class Client {
    private IdEkWateur id;
    private TypeClient type;

    public Client (IdEkWateur id, TypeClient type) {
        this.id = id;
        this.type = type;
    }

    public IdEkWateur getId() {
        return id;
    }

    public void setId(IdEkWateur id) {
        this.id = id;
    }

    public TypeClient getType() {
        return type;
    }

    protected void setType(TypeClient type) {
        this.type = type;
    }
}
