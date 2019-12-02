package socket;

public class Main {

    public static void main(String[] args) {

        int soThapPhan = 17;

        String chuoiNhiPhan = "";

        int ketQuaHienTai = soThapPhan;

        while (ketQuaHienTai >= 2) {
            int soDu = ketQuaHienTai % 2;
            chuoiNhiPhan += soDu;
            ketQuaHienTai /= 2;
        }
        System.out.println(chuoiNhiPhan + (ketQuaHienTai % 2));
    }
}
