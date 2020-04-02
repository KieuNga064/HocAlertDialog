package kieunga.com.hocalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import kieunga.com.hocalertdialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // finish();
                xuLyThoat();
            }
        });
    }

    private void xuLyThoat() {
        //1. Tạo 1 đối tượng AlertDialog
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        //2. Tạo tiêu đề cho cửa sổ
        builder.setTitle("Xác nhận thoát:");
        //3. Thiết lập nội dung cửa sổ:
        builder.setMessage("Muốn thoát hả???");
        //4. Thiết lập các button cho lựa chọn:
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
       builder.setPositiveButton("Có chứ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        //tạo cửa sổ
        AlertDialog dialog=builder.create();
        //hiển thị cửa sổ
        dialog.show();
    }
}
