package soulreaper.com.facvidownloaderexample;

import androidx.appcompat.app.AppCompatActivity;
import soulreaper.com.facvidownloader.FacViDownloader;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editText;
    DownloadManager manager;
    String fileName;
    long did;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);
        manager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        fileName="one.mp4";
        registerReceiver(receiver,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

    }
        public void download(View v){
        try {


            DownloadManager.Request request = new FacViDownloader(editText.getText().toString()).getRequest();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDescription("download" + fileName);
            request.setTitle(fileName);
            request.setDestinationUri(Uri.parse("file://" + Environment.getExternalStorageDirectory() + "/Download" + "/" + fileName));
            did = manager.enqueue(request);
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();

        }
        }    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);

            if (id == did) {
                Toast.makeText(getApplicationContext(),"DONE",Toast.LENGTH_LONG).show();
            }

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
