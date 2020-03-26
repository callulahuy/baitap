package com.example.btlw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNhanVien extends BaseAdapter {

    Context context;
    ArrayList<NhanVienModel> arrayList;

    public AdapterNhanVien(Context context, ArrayList<NhanVienModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHodel{
        ImageView ivIcon;
        TextView tvMaNV, tvTenNV, tvGioiTinh;
        CheckBox cbXoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHodel hodel;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_nhan_vien, null);
            hodel = new ViewHodel();

            hodel.ivIcon = view.findViewById(R.id.ivIcon);
            hodel.tvMaNV = view.findViewById(R.id.tvMaNV);
            hodel.tvTenNV = view.findViewById(R.id.tvTenNV);
            hodel.tvGioiTinh = view.findViewById(R.id.tvGioiTinh);
            hodel.cbXoa = view.findViewById(R.id.cbXoa);

            view.setTag(hodel);
        }else{
            hodel = (ViewHodel) view.getTag();
        }

        final NhanVienModel nhanVienModel = arrayList.get(i);

        hodel.ivIcon.setImageResource(nhanVienModel.getAnhIcon());
        hodel.tvMaNV.setText(nhanVienModel.getMaNhanVien());
        hodel.tvTenNV.setText(nhanVienModel.getHoTen());
        hodel.tvGioiTinh.setText(nhanVienModel.getGioiTinh());

        hodel.cbXoa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    nhanVienModel.setCheckXoa(hodel.cbXoa.isChecked());
                   arrayList.remove(nhanVienModel);

                    notifyDataSetChanged();
                }
        });

        return view;
    }
}
