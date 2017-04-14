public enum Status {
    VIVO(1), MORTO(-1), DESACORDADO(0);
    
    private int status;
    private Status (int status) {
        this.status = status;
    }  
}