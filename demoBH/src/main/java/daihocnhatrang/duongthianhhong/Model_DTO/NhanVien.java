package daihocnhatrang.duongthianhhong.Model_DTO;


public class NhanVien {
  private String maNhanVien;
  private String hoTen;
  private int tuoi;
  private String gioiTinh;
  private String diaChi;
  private double luong;

  public NhanVien() {
  }

  public NhanVien(String maNhanVien, String hoTen, int tuoi, String gioiTinh, String diaChi, double luong) {
    this.maNhanVien = maNhanVien;
    this.hoTen = hoTen;
    this.tuoi = tuoi;
    this.gioiTinh = gioiTinh;
    this.diaChi = diaChi;
    this.luong = luong;
  }

  public String getMaNhanVien() {
    return this.maNhanVien;
  }

  public void setMaNhanVien(String maNhanVien) {
    this.maNhanVien = maNhanVien;
  }

  public String getHoTen() {
    return this.hoTen;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
  }

  public int getTuoi() {
    return this.tuoi;
  }

  public void setTuoi(int tuoi) {
    this.tuoi = tuoi;
  }

  public String getGioiTinh() {
    return this.gioiTinh;
  }

  public void setGioiTinh(String gioiTinh) {
    this.gioiTinh = gioiTinh;
  }

  public String getDiaChi() {
    return this.diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public double getLuong() {
    return this.luong;
  }

  public void setLuong(double luong) {
    this.luong = luong;
  }

  public void hienThiThongTin() {
    System.out.println("Mã nhân viên: " + this.maNhanVien);
    System.out.println("Họ tên: " + this.hoTen);
    System.out.println("Tuổi: " + this.tuoi);
    System.out.println("Giới tính: " + this.gioiTinh);
    System.out.println("Địa chỉ: " + this.diaChi);
    System.out.println("Lương: " + this.luong);
  }
}
