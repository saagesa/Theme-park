package model;

public class Perdoruesi {
    private int perdoruesId;
    private String emri;
    private String mbiemri;
    private String emaili;
    private String fjalekalimi;
    private String telefoni;

    public Perdoruesi(int perdoruesId, String emri, String mbiemri, String emaili, String fjalekalimi, String telefoni) {
        this.perdoruesId = perdoruesId;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.emaili = emaili;
        this.fjalekalimi = fjalekalimi;
        this.telefoni = telefoni;
    }

    public int getPerdoruesId() { return perdoruesId; }
    public String getEmri() { return emri; }
    public String getMbiemri() { return mbiemri; }
    public String getEmaili() { return emaili; }
    public String getFjalekalimi() { return fjalekalimi; }
    public String getTelefoni() { return telefoni; }

    @Override
    public String toString() {
        return emri + " " + mbiemri + " | Email: " + emaili + " | Tel: " + telefoni;
    }
}

