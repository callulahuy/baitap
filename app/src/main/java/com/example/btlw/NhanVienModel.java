package com.example.btlw;

public class NhanVienModel {

    private String maNhanVien;
    private String hoTen;
    private String gioiTinh;
    private int anhIcon;
    private boolean checkXoa;

    public NhanVienModel() {
    }

    public NhanVienModel(String maNhanVien, String hoTen, String gioiTinh, int anhIcon) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.anhIcon = anhIcon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getAnhIcon() {
        return anhIcon;
    }

    public void setAnhIcon(int anhIcon) {
        this.anhIcon = anhIcon;
    }

    public boolean isCheckXoa() {
        return checkXoa;
    }

    public void setCheckXoa(boolean checkXoa) {
        this.checkXoa = checkXoa;
    }
}
