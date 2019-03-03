package com.ckdtech.www.lovecalculator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LovequotesActivity extends AppCompatActivity {


    ListView listView;
    String[] lovequotes = {"I am happiest when I’m right next to you.",
            "My night has become a sunny dawn because of you.",
            "The best thing to hold onto in life is each other.",
            "You may hold my hand for a while, but you hold my heart forever.",
            "I know I am in love with you because my reality is finally better than my dreams.",
            "I need you like a heart needs a beat.",
            "Your love is all I need to feel complete.",
            "Every time I see you, I fall in love all over again."};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lovequotes_activity);


        listView = (ListView) findViewById(R.id.idlistView);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lovequotes);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select One Option");
        menu.add(0, v.getId(), 0, "Send SMS");
        menu.add(0, v.getId(), 0, "Send Whatsapp");
        menu.add(0, v.getId(), 0, "Send E-mail");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String msg  = lovequotes[menuInfo.position];
       // Toast.makeText(this, "Selected String is :-"+msg, Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "item clicked is:"+lovequotes[menuItemIndex], Toast.LENGTH_SHORT).show();
        if (item.getTitle() == "Send SMS") {

            Intent a = new Intent(LovequotesActivity.this, Lovequotes2Activity.class);
            a.putExtra("message",msg);
            startActivity(a);
           // a.putExtra();
            Toast.makeText(this, "Send as SMS clicked", Toast.LENGTH_SHORT).show();
        }


        if (item.getTitle() == "Send Whatsapp") {

            Toast.makeText(this, "Send as Whatsapp Clicked ", Toast.LENGTH_SHORT).show();
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT,"I have just found a love quote for you which is : "+msg);
            sharingIntent.setPackage("com.whatsapp");
            startActivity(sharingIntent);

        }


        if (item.getTitle() == "Send E-mail") {

            Toast.makeText(this, "Send as E-mail clicked", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("email"));
            i.putExtra(Intent.EXTRA_SUBJECT,"Love Quote For You");
            i.putExtra(Intent.EXTRA_TEXT,"I have just found a love quote for you which is :-\n\n"+msg);
            i.setType("message/rfc822");
            Intent chooser = Intent.createChooser(i,"Launch Email");
            startActivity(chooser);



























        }
        return true;

    }

}
