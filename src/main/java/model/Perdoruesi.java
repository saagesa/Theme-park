package model;

public class Perdoruesi {
    private int perdoruesId;
    private String emri;
    private String mbiemri;
    private String emaili;
    private String fjalekalimi;
    private String telefoni;

    private Perdoruesi(Builder builder) {
        this.perdoruesId = builder.perdoruesId;
        this.emri = builder.emri;
        this.mbiemri = builder.mbiemri;
        this.emaili = builder.emaili;
        this.fjalekalimi = builder.fjalekalimi;
        this.telefoni = builder.telefoni;
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

    // -------- Builder --------
    public static class Builder {
        private int perdoruesId;
        private String emri;
        private String mbiemri;
        private String emaili;
        private String fjalekalimi;
        private String telefoni;

        public Builder setPerdoruesId(int perdoruesId) {
            this.perdoruesId = perdoruesId;
            return this;
        }
        public Builder setEmri(String emri) {
            this.emri = emri;
            return this;
        }
        public Builder setMbiemri(String mbiemri) {
            this.mbiemri = mbiemri;
            return this;
        }
        public Builder setEmaili(String emaili) {
            this.emaili = emaili;
            return this;
        }
        public Builder setFjalekalimi(String fjalekalimi) {
            this.fjalekalimi = fjalekalimi;
            return this;
        }
        public Builder setTelefoni(String telefoni) {
            this.telefoni = telefoni;
            return this;
        }

        public Perdoruesi build() {
            return new Perdoruesi(this);
        }
    }
}
