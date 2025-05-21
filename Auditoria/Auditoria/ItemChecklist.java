public class ItemChecklist {
    private String texto;
    private String status; // "Conforme", "N�o Conforme", "N�o aplic�vel"

    public ItemChecklist(String texto) {
        this.texto = texto;
        this.status = "Nao aplicavel"; // padr�o
    }

    public String getTexto() { return texto; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
