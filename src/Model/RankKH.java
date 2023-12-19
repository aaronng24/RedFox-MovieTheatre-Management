package Model;

/**
 *
 * @author Nguyen Dung
 */
public class RankKH {
    String makh,rankkh;
    int tongchitieu;

    RankKH(RankKH rank) {
        this.rankkh=rankkh;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getRankkh() {
        return rankkh;
    }

    public void setRankkh(String rankkh) {
        this.rankkh = rankkh;
    }

    @Override
    public String toString(){
        return rankkh;
    }
    
    public int getTongchitieu() {
        return tongchitieu;
    }

    public void setTongchitieu(int tongchitieu) {
        this.tongchitieu = tongchitieu;
    }
    
}
