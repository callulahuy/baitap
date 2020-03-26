package com.example.btlw;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etMa, etTen;
    RadioButton rbNam, rbNu;
    ListView lvDSNV;
    Button btNhap;
    ImageView ivClear;
    TextView tvXemDS;
    ArrayList<NhanVienModel> arrayList = new ArrayList<>();
    AdapterNhanVien adapterNhanVien;
    public static String Anh = "anh";
    public static String maNV = "ma";
    public static String tenNV = "ten";
    public static String GT = "gt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        showDL();
        nhapNhanVien();
        adapterNhanVien = new AdapterNhanVien(this, arrayList);
        hienThiDS();

        xoaDL();



    }

    public void anhXa(){
        etMa = findViewById(R.id.etMaNV);
        etTen = findViewById(R.id.etTenNV);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btNhap = findViewById(R.id.btNhap);
        ivClear = findViewById(R.id.ivClear);
        tvXemDS = findViewById(R.id.tvXemDS);
        lvDSNV = findViewById(R.id.lvDSNV);
    }

    public void nhapNhanVien(){
        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NhanVienModel nhanVienThem = new NhanVienModel();
                nhanVienThem.setMaNhanVien(etMa.getText().toString());
                nhanVienThem.setHoTen(etTen.getText().toString());

                if(rbNam.isChecked()){
                    nhanVienThem.setAnhIcon(R.drawable.nvnam);
                    nhanVienThem.setGioiTinh(rbNam.getText().toString());
                }else {
                    nhanVienThem.setAnhIcon(R.drawable.nvnu);
                    nhanVienThem.setGioiTinh(rbNu.getText().toString());
                }

                arrayList.add(nhanVienThem);
                etMa.setText("");
                etTen.setText("");

            }
        });
    }

    public void hienThiDS(){
        tvXemDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvDSNV.setAdapter(adapterNhanVien);
            }
        });
    }

    public void xoaDL(){
        ivClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setMessage("Bạn vui lòng chọn vị trí muốn xóa?");
                dialog.show();
            }
        });
    }

    public void showDL(){
        lvDSNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.hien_thi_item);
                NhanVienModel tam = arrayList.get(i);

                ImageView ivIcon = dialog.findViewById(R.id.ivIcon);
                TextView tvMaNV = dialog.findViewById(R.id.tvMaNV);
                TextView tvTenNV = dialog.findViewById(R.id.tvTenNV);
                TextView tvGioiTinh = dialog.findViewById(R.id.tvGioiTinh);

                ivIcon.setImageResource(tam.getAnhIcon());
                tvMaNV.setText(tam.getMaNhanVien());
                tvTenNV.setText(tam.getHoTen());
                tvGioiTinh.setText(tam.getGioiTinh());

                dialog.show();


            }
        });
    }


}
