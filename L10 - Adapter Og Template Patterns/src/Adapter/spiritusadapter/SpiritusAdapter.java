package Adapter.spiritusadapter;

public class SpiritusAdapter extends Vare {
    private Spiritus spiritus;

    public SpiritusAdapter(Spiritus spiritus) {
        super(spiritus.getPrisen(), spiritus.getBetegnelse());
        this.spiritus = spiritus;
    }
    // Alle de her metoder udover getMoms er overflødige, da de automatisk bliver nedarvet fra superklassen
    @Override
    public int getPris() {
        return spiritus.getPrisen();
    }
    @Override
    public void setPris(int pris) {
        spiritus.setPrisen(pris);
    }
    @Override
    public String getNavn() {
        return spiritus.getBetegnelse();
    }
    @Override
    public void setNavn(String navn) {
        spiritus.setBetegnelse(navn);
    }
    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }
}
