package usecase.port;

public class DeleteToDoItemOutputData {
    private final boolean ok;

    public boolean getOk() {
        return ok;
    }

    public DeleteToDoItemOutputData(boolean ok) {
        this.ok = ok;
    }
}