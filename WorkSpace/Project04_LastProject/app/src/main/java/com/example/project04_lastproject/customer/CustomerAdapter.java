package com.example.project04_lastproject.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project04_lastproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter  extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>{

    Context context;
    LayoutInflater inflater;
    List<CustomerVO> list = new ArrayList<>();
    public CustomerAdapter(Context context, List<CustomerVO> list) {
        this.context = context; // 나중에 Intent나 화면처리 Toast 이벤트 등에서 사용하기 위해서 받아옴.
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater <- 칸마다 보여줄 데이터를 붙이기 위해서 ( Customer_Main_item.xml )
        View itemView = inflater.inflate(R.layout.customer_main_item , parent , false );
        //ViewHolder holder = ;
        return new ViewHolder(itemView);
    }

    // ↑ xml이 연결되고나서 bind 데이터 연결 부
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder , position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cus_img ;
        TextView cus_no , cus_name , cus_phone;
        Button btn_detail , btn_edit , btn_del;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cus_img =  itemView.findViewById(R.id.cus_img);
            cus_no =  itemView.findViewById(R.id.cus_no);
            cus_name =  itemView.findViewById(R.id.cus_name);
            cus_phone =  itemView.findViewById(R.id.cus_phone);
            btn_detail =  itemView.findViewById(R.id.btn_detail);
            btn_edit =  itemView.findViewById(R.id.btn_edit);
            btn_del =  itemView.findViewById(R.id.btn_del);
        }

        public void bind(ViewHolder holder, int i) {
            holder.cus_no.setText(list.get(i).getNo() + "" );
            holder.cus_name.setText(list.get(i).getName() + "" );
            holder.cus_phone.setText(list.get(i).getPhone() + "" );

        }
    }
}
